/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iepi.derechoautor;

import com.iepi.databases.DerechoAutor;
import com.iepi.databases.ObraDerechoAutor;
import com.iepi.databases.SqlServerAutorext;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Administrator
 */
@WebService(serviceName = "DerechoAutorWS")
public class DerechoAutorWS {

    /**
     * Web service operation
     * @param identificacion RUC o Cédula
     * @return List
     */
    @WebMethod(operationName = "devolverInformacionAutor")
    public DerechoAutor devolverInformacionAutor(@WebParam(name = "login") String login, @WebParam(name = "password") String password, @WebParam(name = "identificacion") String identificacion) {
        DerechoAutor ListaInformacion = new DerechoAutor();
        
        SqlServerAutorext sqlserver = new SqlServerAutorext();

        try {
            boolean autenticacion = sqlserver.consultaUsuarioPass(login, password);

            if (autenticacion) {
                ListaInformacion = sqlserver.InformacionDerechoAutor(identificacion);
            } else {
                ListaInformacion.setError("Usuario y/o contraseña incorrecto(s)");
            }
        } catch (Exception ex) {
            ListaInformacion.setError("Ocurrio un error al consultar el servicio");
        }

        return ListaInformacion;
    }

    /**
     * Web service operation
     * @param login usuario
     * @param password contraseña
     * @return Boolean
     */
//    @WebMethod(operationName = "consultaUsuarioPass")
//    public Boolean consultaUsuarioPass(@WebParam(name = "login") String login, @WebParam(name = "password") String password) {
//        try {
//            Boolean autenticacion = false;
//
//            SqlServerAutorext sqlserver = new SqlServerAutorext();
//
//            autenticacion = sqlserver.consultaUsuarioPass(login, password);
//
//            return autenticacion;
//
//        } catch (Exception ex) {
//            return false;
//        }
//    }
}
