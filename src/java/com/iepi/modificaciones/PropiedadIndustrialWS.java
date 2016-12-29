/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iepi.modificaciones;

import com.iepi.databases.PersonaModificaciones;
import com.iepi.databases.PostgreSQLIEPI;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Administrator
 */
@WebService(serviceName = "RegistroWS")
public class PropiedadIndustrialWS {

    /**
     * Web service operation
     * @param login usuario
     * @param password contraseña
     * @return Boolean
     */
    /*@WebMethod(operationName = "consultaUsuarioPass")
    public Boolean consultaUsuarioPass(@WebParam(name = "login") String login, @WebParam(name = "password") String password) {
    try {
    Boolean autenticacion = false;
    
    PostgreSQLIEPI postgresql = new PostgreSQLIEPI();
    
    autenticacion = postgresql.consultaUsuarioPass(login, password);
    
    return autenticacion;
    
    } catch (Exception ex) {
    return false;
    }
    }*/
    
    /**
     * Web service operation
     * @param identificacion RUC o Cédula
     * @return List
     */
    @WebMethod(operationName = "devolverModificacionesTramites")
    public List<PersonaModificaciones> devolverModificacionesTramites(@WebParam(name = "login") String login,
            @WebParam(name = "password") String password,
            @WebParam(name = "identificacion") String identificacion) {

        List<PersonaModificaciones> ListaInformacion = new ArrayList<PersonaModificaciones>();

        PersonaModificaciones RegistroError = new PersonaModificaciones();

        try {
            Boolean autenticacion = false;

            PostgreSQLIEPI postgresql = new PostgreSQLIEPI();

            autenticacion = postgresql.consultaUsuarioPass(login, password);

            if (autenticacion) {
                ListaInformacion = postgresql.devolverModificacionesTramites(identificacion);

            } else {
                RegistroError.setError("Usuario y/o contraseña incorreto(s)");

                ListaInformacion.add(RegistroError);
            }
        } catch (Exception ex) {
            RegistroError.setError("Ocurrió un error al consultar el servicio");

            ListaInformacion.add(RegistroError);
        }

        return ListaInformacion;
    }
}
