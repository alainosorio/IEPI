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
 * Clase de conexión a la base de datos PostreSQL
 * @author Administrator
 */
public class PostgreSQLIEPI {

    public String bd = "iepi";
    public String login = "postgres";
    public String password = "postgresl";
    private String url = "jdbc:postgresql://localhost:5432/iepi";
    private Connection connection = null;

    public PostgreSQLIEPI() {
        try {
            Class.forName("org.postgresql.Driver");
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
     * Verifica la existencia del usuario
     * @param login usuario
     * @param password contraseña
     * @return Boolean
     */
    public Boolean consultaUsuarioPass(String login, String password) {
        try {
            String nombreUsuario = "";

            /*PreparedStatement statement = connection.prepareStatement("SELECT [USR_NOM] FROM [dbo].[USUARIO] WHERE [USR_LOG] = ? AND [pwd] = ?");
            statement.setString(1, login);
            statement.setString(2, password);
            
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
            nombreUsuario = result.getString(1);
            }
            
            result.close();
            
            connection.close();*/

            if (connection != null) {
                nombreUsuario = "conectado";
            } else {
                nombreUsuario = "";
            }

            return !"".equals(nombreUsuario);

        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Retorna una lista con las modificaciones
     * @param identificacion RUC o Cédula
     * @return 
     */
    public List<vPersonaPropiedadIntelectual> devolverModificacionesTramites(String identificacion) {
        List<vPersonaPropiedadIntelectual> ListaInformacion = new ArrayList<vPersonaPropiedadIntelectual>();

        List<vPersonaPropiedadIntelectual> ListaVacia = new ArrayList<vPersonaPropiedadIntelectual>();
        vPersonaPropiedadIntelectual registroVacio = new vPersonaPropiedadIntelectual();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT persdocumento, persnombre FROM persona where persdocumento = ?");
            statement.setString(1, identificacion);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                vPersonaPropiedadIntelectual registro = new vPersonaPropiedadIntelectual(result.getString(1),
                        result.getString(2));

                ListaInformacion.add(registro);
            }

            result.close();

            connection.close();

            if (ListaInformacion.size() > 0) {
                return ListaInformacion;
            } else {
                registroVacio.setERROR("No se encontraron datos para la identificación introducida");

                ListaVacia.add(registroVacio);

                return ListaVacia;
            }
        } catch (Exception e) {
            registroVacio.setERROR("Ocurrio un error al consultar el servicio");

            ListaVacia.add(registroVacio);

            return ListaVacia;
        }
    }
}
