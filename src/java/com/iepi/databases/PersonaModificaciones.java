/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iepi.databases;

import java.util.List;

/**
 *
 * @author Administrator
 */
public class PersonaModificaciones {

    /**
     * Nombre de la persona
     */
    private String persNombre;
    /**
     * Dirección de la persona
     */
    private String persDireccion;
    /**
     * Tipo de documento de la persona
     */
    private String persTipDocumento;
    /**
     * Documento de identificación de la persona
     */
    private String persDocumento;
    /**
     * Lista de títulos
     */
    private List<TituloModificaciones> titulos;
    /**
     * Mensaje de error
     */
    private String error;

    public PersonaModificaciones(String persNombre, String persDireccion, String persTipDocumento, String persDocumento, List<TituloModificaciones> titulos) {
        this.persNombre = persNombre;
        this.persDireccion = persDireccion;
        this.persTipDocumento = persTipDocumento;
        this.persDocumento = persDocumento;
        this.titulos = titulos;
    }

    public PersonaModificaciones() {
    }

    public String getPersDireccion() {
        return persDireccion;
    }

    public void setPersDireccion(String persDireccion) {
        this.persDireccion = persDireccion;
    }

    public String getPersDocumento() {
        return persDocumento;
    }

    public void setPersDocumento(String persDocumento) {
        this.persDocumento = persDocumento;
    }

    public String getPersNombre() {
        return persNombre;
    }

    public void setPersNombre(String persNombre) {
        this.persNombre = persNombre;
    }

    public String getPersTipDocumento() {
        return persTipDocumento;
    }

    public void setPersTipDocumento(String persTipDocumento) {
        this.persTipDocumento = persTipDocumento;
    }

    public List<TituloModificaciones> getTitulos() {
        return titulos;
    }

    public void setTitulos(List<TituloModificaciones> titulos) {
        this.titulos = titulos;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
