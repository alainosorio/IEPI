/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iepi.propiedadindustrial;

import com.iepi.databases.PostgreSQLIEPI;
import com.iepi.databases.vPersonaPropiedadIntelectual;
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
    @WebMethod(operationName = "consultaUsuarioPass")
    public Boolean consultaUsuarioPass(@WebParam(name = "login") String login, @WebParam(name = "password") String password) {
        try {
            Boolean autenticacion = false;

            PostgreSQLIEPI postgresql = new PostgreSQLIEPI();

            autenticacion = postgresql.consultaUsuarioPass(login, password);

            return autenticacion;

        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * Web service operation
     * @param identificacion RUC o Cédula
     * @return List
     */
    @WebMethod(operationName = "devolverModificacionesTramites")
    public List<vPersonaPropiedadIntelectual> devolverModificacionesTramites(@WebParam(name = "identificacion") String identificacion) {
        try {
            List<vPersonaPropiedadIntelectual> ListaInformacion = new ArrayList<vPersonaPropiedadIntelectual>();

            PostgreSQLIEPI postgresql = new PostgreSQLIEPI();

            ListaInformacion = postgresql.devolverModificacionesTramites(identificacion);

            return ListaInformacion;

        } catch (Exception ex) {
            return new ArrayList<vPersonaPropiedadIntelectual>();
        }
    }
}
