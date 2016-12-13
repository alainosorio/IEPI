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
import java.util.List;

/**
 *
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
     * Retorna una lista con la información de derecho de autor
     * @param identificacion RUC o Cédula
     * @return List
     */
    public List<vRegistro> InformacionAutor(String identificacion) {
        List<vRegistro> ListaVacia = new ArrayList<vRegistro>();
        vRegistro RegistroVacio = new vRegistro();


        List<vRegistro> ListaInformacionAutor = new ArrayList<vRegistro>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM [dbo].[vRegistro] WHERE [IDENTIFICATION] = ?");
            statement.setString(1, identificacion);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                vRegistro registro = new vRegistro(result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6),
                        result.getString(7),
                        result.getString(8),
                        result.getString(9),
                        result.getString(10),
                        result.getString(11),
                        result.getString(12),
                        result.getString(13),
                        result.getString(14),
                        result.getString(15),
                        result.getString(16),
                        result.getString(17),
                        result.getString(18),
                        result.getString(19),
                        result.getString(20),
                        result.getString(21));

                ListaInformacionAutor.add(registro);
            }

            result.close();

            connection.close();

            if (ListaInformacionAutor.size() > 0) {
                return ListaInformacionAutor;
            } else {
                RegistroVacio.setERROR("No se encontraron datos para la identificación introducida");

                ListaVacia.add(RegistroVacio);

                return ListaVacia;
            }
        } catch (Exception e) {
            RegistroVacio.setERROR("Ocurrio un error al consultar el servicio");

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

            connection.close();

            return !"".equals(nombreUsuario);

        } catch (Exception e) {
            return false;
        }
    }
}
