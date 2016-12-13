/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iepi.derechoautor;

import com.iepi.databases.SqlServerAutorext;
import com.iepi.databases.vRegistro;
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
    public List<vRegistro> devolverInformacionAutor(@WebParam(name = "identificacion") String identificacion) {
        try {
            List<vRegistro> ListaInformacion = new ArrayList<vRegistro>();

            SqlServerAutorext sqlserver = new SqlServerAutorext();

            ListaInformacion = sqlserver.InformacionAutor(identificacion);

            return ListaInformacion;

        } catch (Exception ex) {
            return new ArrayList<vRegistro>();
        }
    }

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

            SqlServerAutorext sqlserver = new SqlServerAutorext();

            autenticacion = sqlserver.consultaUsuarioPass(login, password);

            return autenticacion;

        } catch (Exception ex) {
            return false;
        }
    }       
}
