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

            /*PreparedStatement statementPersona = connection.prepareStatement("SELECT [USR_NOM] FROM [dbo].[USUARIO] WHERE [USR_LOG] = ? AND [pwd] = ?");
            statementPersona.setString(1, login);
            statementPersona.setString(2, password);
            
            ResultSet resultPersona = statementPersona.executeQuery();
            
            while (resultPersona.next()) {
            nombreUsuario = resultPersona.getString(1);
            }
            
            resultPersona.close();
            
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
    public List<PersonaModificaciones> devolverModificacionesTramites(String identificacion) {
        
        List<PersonaModificaciones> ListaPersonaModificaciones = new ArrayList<PersonaModificaciones>();
        PersonaModificaciones registroPersona = new PersonaModificaciones();

        List<TituloModificaciones> ListaTituloModificaciones = new ArrayList<TituloModificaciones>();

        List<SolicitudModificaciones> ListaSolicitudModificaciones = new ArrayList<SolicitudModificaciones>();

        List<SolicitudPersonaBeneficiariaModificaciones> ListaSolicitudPersonaBeneficiariaModificaciones =
                new ArrayList<SolicitudPersonaBeneficiariaModificaciones>();

        List<PersonaModificaciones> ListaVacia = new ArrayList<PersonaModificaciones>();
        PersonaModificaciones RegistroVacio = new PersonaModificaciones();

        try {
            /**
             * Se consulta la persona
             */
            String query = "SELECT distinct persnombre, persdireccion, perstipdocumento, persdocumento FROM v_modificaciones where persdocumento = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, identificacion);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                registroPersona = new PersonaModificaciones(result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        new ArrayList<TituloModificaciones>());

                ListaPersonaModificaciones.add(registroPersona);
            }

            /**
             * Se consultan los titulos por la persona
             */
            for (Iterator<PersonaModificaciones> persona = ListaPersonaModificaciones.iterator(); persona.hasNext();) {

                PersonaModificaciones personaIterador = persona.next();

                query = "SELECT titunumregistro, titufecharegistro, titufechavencimiento, persnombre, persdireccion, perstipdocumento, persdocumento FROM v_modificaciones where persnombre = ? and  persdireccion = ? and persdocumento = ?";

                statement = connection.prepareStatement(query);
                statement.setString(1, personaIterador.getPersNombre());
                statement.setString(2, personaIterador.getPersDireccion());
                statement.setString(3, personaIterador.getPersDocumento());

                ResultSet resultTitulo = statement.executeQuery();

                while (resultTitulo.next()) {
                    TituloModificaciones registroTitulo = new TituloModificaciones(resultTitulo.getString(1),
                            resultTitulo.getString(2),
                            resultTitulo.getString(3),
                            resultTitulo.getString(4),
                            resultTitulo.getString(5),
                            resultTitulo.getString(6),
                            resultTitulo.getString(7),
                            new ArrayList<SolicitudModificaciones>());

                    ListaTituloModificaciones.add(registroTitulo);
                }
            }

            /**
             * Se consultan las solicitudes por titulo
             */
            for (Iterator<TituloModificaciones> titulo = ListaTituloModificaciones.iterator(); titulo.hasNext();) {
                TituloModificaciones tituloIterador = titulo.next();

                query = "SELECT soltipdescripcion, solivalornuevo, solifechacertificado, solinumcertificado, solifechacontratolicencia FROM v_modificaciones where titunumregistro = ?";

                statement = connection.prepareStatement(query);
                statement.setString(1, tituloIterador.getTitunumRegistro());

                ResultSet resultSolicitud = statement.executeQuery();

                while (resultSolicitud.next()) {
                    SolicitudModificaciones registroSolicitud = new SolicitudModificaciones(resultSolicitud.getString(1),
                            resultSolicitud.getString(2),
                            resultSolicitud.getString(3),
                            resultSolicitud.getString(4),
                            resultSolicitud.getString(5),
                            new ArrayList<SolicitudPersonaBeneficiariaModificaciones>());

                    ListaSolicitudModificaciones.add(registroSolicitud);
                }

                tituloIterador.setSolicitudes(ListaSolicitudModificaciones);
            }

            /**
             * Se consultan los beneficiarios por solicitudes
             */
            for (Iterator<SolicitudModificaciones> solicitud = ListaSolicitudModificaciones.iterator(); solicitud.hasNext();) {
                SolicitudModificaciones solicitudIterador = solicitud.next();

                query = "SELECT tipolicenciantedescripcion, nombre, cedula, direccion FROM v_modificaciones where soliNumCertificado = ?;";

                statement = connection.prepareStatement(query);
                statement.setString(1, solicitudIterador.getSoliNumCertificado());

                ResultSet resultBeneficiario = statement.executeQuery();

                while (resultBeneficiario.next()) {
                    SolicitudPersonaBeneficiariaModificaciones registroBeneficiario = new SolicitudPersonaBeneficiariaModificaciones(resultBeneficiario.getString(1),
                            resultBeneficiario.getString(2),
                            resultBeneficiario.getString(3),
                            resultBeneficiario.getString(4));

                    ListaSolicitudPersonaBeneficiariaModificaciones.add(registroBeneficiario);
                }

                solicitudIterador.setPersonasBeneficiarias(ListaSolicitudPersonaBeneficiariaModificaciones);
            }

            registroPersona.setTitulos(ListaTituloModificaciones);

            result.close();

            connection.close();

            if (ListaPersonaModificaciones.size() > 0) {
                return ListaPersonaModificaciones;
            } else {
                RegistroVacio.setError("No se encontraron datos para la identificación introducida");

                ListaVacia.add(RegistroVacio);

                return ListaVacia;
            }
        } catch (Exception e) {
            RegistroVacio.setError("Ocurrió un error al consultar el servicio");

            ListaVacia.add(RegistroVacio);

            return ListaVacia;
        } finally {
        }
    }
}
