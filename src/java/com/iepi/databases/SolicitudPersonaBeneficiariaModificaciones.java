/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iepi.databases;

/**
 *
 * @author Administrator
 */
public class SolicitudPersonaBeneficiariaModificaciones {

    /**
     * Observaciones
     */
    private String TipolicencianteDescripcion;
    /**
     * Nombre del beneficiante
     */
    private String nombre;
    /**
     * Cédula del beneficiante
     */
    private String cedula;
    /**
     * Dirección del beneficiante
     */
    private String direccion;

    public SolicitudPersonaBeneficiariaModificaciones(String TipolicencianteDescripcion, String nombre, String cedula, String direccion) {
        this.TipolicencianteDescripcion = TipolicencianteDescripcion;
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
    }

    public SolicitudPersonaBeneficiariaModificaciones() {
    }

    public String getTipolicencianteDescripcion() {
        return TipolicencianteDescripcion;
    }

    public void setTipolicencianteDescripcion(String TipolicencianteDescripcion) {
        this.TipolicencianteDescripcion = TipolicencianteDescripcion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
