/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iepi.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Clase de conexión a la base de datos SQLServer
 * @author Administrator
 */
public class SqlServerAutorext {

    public String bd = "Autorext";
    public String login = "sa";
    public String password = "Adm1n1str4t0r";
    private String url = "jdbc:sqlserver://localhost\\sqlexpress:1433;databaseName=Autorext";
    private Connection connection = null;

    public SqlServerAutorext() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, login, password);

        } catch (Exception e) {
        }
    }

    /**
     * @return the connection
     */
    public Connection getConex() {
        return connection;
    }

    /**
     * Retorna una lista con la información de Derecho de Autor
     * @param identificacion RUC o Cédula
     * @return List
     */
    public DerechoAutor InformacionDerechoAutor(String identificacion) {

        List<ObraDerechoAutor> ListaObraDerechoAutor = new ArrayList<ObraDerechoAutor>();

        DerechoAutor ListaObras = new DerechoAutor();

        String query = "";

        try {
            /**
             * Se consulta la obra
             */
            //query = "select distinct FIRSTNAME as persNombre, SURNAME + coalesce(' ' + SURNAME2, '') as persApellidos, coalesce(ADDRESS1, '') as persDireccion, ACT_NOM as persActividad, IDENTIFICATION as identificacion from [dbo].[vDerechoAutor] where IDENTIFICATION = ?";
            query = "SELECT distinct REG_TOR, REG_DES, REG_TES, REG_COD, USR_NOM, REG_FIRCAR, REG_FEC from dbo.vDerechoAutor where IDENTIFICATION = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, identificacion);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                ObraDerechoAutor Obra = new ObraDerechoAutor(
                        result.getString(1),
                        result.getString(2),
                        "autorObra",
                        "titularObra",
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6),
                        result.getString(7),
                        new ListaPersonaDerechoAutor());
                
                ListaObraDerechoAutor.add(Obra);
            }

            ListaObras.getObras().setObra(ListaObraDerechoAutor);

            result.close();

            /**
             * Se consultan las personas
             */
            for (Iterator<ObraDerechoAutor> obra = ListaObraDerechoAutor.iterator(); obra.hasNext();) {
                query = "select distinct FIRSTNAME as persNombre, SURNAME + coalesce(' ' + SURNAME2, '') as persApellidos, coalesce(ADDRESS1, '') as persDireccion, ACT_NOM as persActividad, IDENTIFICATION as identificacion from [dbo].[vDerechoAutor] where IDENTIFICATION = ? and REG_COD = ?";

                ObraDerechoAutor obraIterator = obra.next();

                statement = connection.prepareStatement(query);
                statement.setString(1, identificacion);
                statement.setString(2, obraIterator.getNroCertificado());

                result = statement.executeQuery();

                List<PersonaDerechoAutor> ListaPersona = new ArrayList<PersonaDerechoAutor>();

                while (result.next()) {
                    PersonaDerechoAutor Persona = new PersonaDerechoAutor(
                            result.getString(1),
                            result.getString(2),
                            result.getString(3),
                            result.getString(4),
                            result.getString(5));

                    ListaPersona.add(Persona);
                }

                result.close();

                obraIterator.getPersonas().setPersona(ListaPersona);
            }

            /**
             * Se cierra la conexión y se retornan los datos
             */
            connection.close();

            if (ListaObras.getObras().getObra().size() > 0) {
                return ListaObras;
            } else {
                ListaObras.setError("No se encontraron datos para la identificación introducida");

                return ListaObras;
            }
        } catch (Exception e) {

            ListaObras.setError("Ocurrió un error al consultar el servicio");

            return ListaObras;
        }
    }

    /**
     * Verifica la existencia del usuario
     * @param login usuario
     * @param password contraseña
     * @return Boolean
     */
    public Boolean consultaUsuarioPass(String login, String password) {
        try {
            String nombreUsuario = "";

            PreparedStatement statement = connection.prepareStatement("SELECT [USR_NOM] FROM [dbo].[USUARIO] WHERE [USR_LOG] = ? AND [pwd] = ?");
            statement.setString(1, login);
            statement.setString(2, password);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                nombreUsuario = result.getString(1);
            }

            result.close();

            return !"".equals(nombreUsuario);

        } catch (Exception e) {
            return false;
        }
    }
}
