/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iepi.databases;

/**
 * PersonaDerechoAutor
 * @author Administrator
 */
public class PersonaDerechoAutor {

    /**
     * Nombre de la persona
     */
    private String persNombre; ///
    /**
     * Apellidos de la persona
     */
    private String persApellidos; ///
    /**
     * Direción de la persona
     */
    private String persDireccion; ///
    /**
     * Actividad
     */
    private String persActividad; ///
    /**
     * Cédula o RUC
     */
    private String identificacion;
    /**
     * Mensaje de error
     */
    private String error;

    public PersonaDerechoAutor(String persNombre, String persApellidos, String persDireccion, String persActividad, String identificacion) {
        this.persNombre = persNombre;
        this.persApellidos = persApellidos;
        this.persDireccion = persDireccion;
        this.persActividad = persActividad;
        this.identificacion = identificacion;
    }

    public PersonaDerechoAutor() {
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getPersActividad() {
        return persActividad;
    }

    public void setPersActividad(String persActividad) {
        this.persActividad = persActividad;
    }

    public String getPersApellidos() {
        return persApellidos;
    }

    public void setPersApellidos(String persApellidos) {
        this.persApellidos = persApellidos;
    }

    public String getPersDireccion() {
        return persDireccion;
    }

    public void setPersDireccion(String persDireccion) {
        this.persDireccion = persDireccion;
    }

    public String getPersNombre() {
        return persNombre;
    }

    public void setPersNombre(String persNombre) {
        this.persNombre = persNombre;
    }
}
