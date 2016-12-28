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
    public List<PersonaDerechoAutor> InformacionDerechoAutor(String identificacion) {

        List<PersonaDerechoAutor> ListaVacia = new ArrayList<PersonaDerechoAutor>();
        
        PersonaDerechoAutor RegistroVacio = new PersonaDerechoAutor();

        List<PersonaDerechoAutor> ListaInformacionAutor = new ArrayList<PersonaDerechoAutor>();

        try {
            /**
             * Se consulta el autor
             */
            String query = "select distinct FIRSTNAME as persNombre, SURNAME + coalesce(' ' + SURNAME2, '') as persApellidos, coalesce(ADDRESS1, '') as persDireccion, ACT_NOM as persActividad, IDENTIFICATION as identificacion from [dbo].[vDerechoAutor] where IDENTIFICATION = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, identificacion);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                PersonaDerechoAutor Persona = new PersonaDerechoAutor(
                        result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        new ArrayList<ObraDerechoAutor>());

                ListaInformacionAutor.add(Persona);
            }

            result.close();

            /**
             * Se consultan las obras del autor
             */
            for (Iterator<PersonaDerechoAutor> persona = ListaInformacionAutor.iterator(); persona.hasNext();) {
                
                query = "SELECT distinct REG_TOR, REG_DES, REG_TES, REG_COD, USR_NOM, REG_FIRCAR, REG_FEC from dbo.vDerechoAutor where IDENTIFICATION = ?"
                        + " and FIRSTNAME = ? and ACT_NOM = ?";

                PersonaDerechoAutor personaIterador = persona.next();
                
                statement = connection.prepareStatement(query);
                statement.setString(1, identificacion);
                statement.setString(2, personaIterador.getPersNombre());
                statement.setString(3, personaIterador.getPersActividad());

                result = statement.executeQuery();

                List<ObraDerechoAutor> ListaObras = new ArrayList<ObraDerechoAutor>();

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
                            result.getString(7));

                    ListaObras.add(Obra);
                }
                
                result.close();

                personaIterador.setObras(ListaObras);
            }

            /**
             * Se cierra la conexión y se retornan los datos
             */
            connection.close();

            if (ListaInformacionAutor.size() > 0) {
                return ListaInformacionAutor;
            } else {
                RegistroVacio.setError("No se encontraron datos para la identificación introducida");

                ListaVacia.add(RegistroVacio);

                return ListaVacia;
            }
        } catch (Exception e) {
            RegistroVacio.setError("Ocurrió un error al consultar el servicio");

            ListaVacia.add(RegistroVacio);

            return ListaVacia;
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
