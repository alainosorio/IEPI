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
public class TituloModificaciones {

    /**
     * Número de registro
     */
    private String titunumRegistro;
    /**
     * Fecha de registro
     */
    private String tituFechaRegistro;
    /**
     * Fecha de vencimiento
     */
    private String tituFechaVencimiento;
    /**
     * Nombre del titular
     */
    private String nombreTitular;
    /**
     * Dirección del titular
     */
    private String direccionTitular;
    /**
     * Tipo de documento de la persona
     */
    private String persTipDocumento;
    /**
     * Documento de identidad de la persona
     */
    private String persDocumento;
    /**
     * Listado de solicitudes
     */
    private List<SolicitudModificaciones> solicitudes;

    public TituloModificaciones(String titunumRegistro, String tituFechaRegistro, String tituFechaVencimiento, String nombreTitular, String direccionTitular, String persTipDocumento, String persDocumento, List<SolicitudModificaciones> solicitudes) {
        this.titunumRegistro = titunumRegistro;
        this.tituFechaRegistro = tituFechaRegistro;
        this.tituFechaVencimiento = tituFechaVencimiento;
        this.nombreTitular = nombreTitular;
        this.direccionTitular = direccionTitular;
        this.persTipDocumento = persTipDocumento;
        this.persDocumento = persDocumento;
        this.solicitudes = solicitudes;
    }

    public List<SolicitudModificaciones> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<SolicitudModificaciones> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public TituloModificaciones() {
    }

    public String getDireccionTitular() {
        return direccionTitular;
    }

    public void setDireccionTitular(String direccionTitular) {
        this.direccionTitular = direccionTitular;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getPersDocumento() {
        return persDocumento;
    }

    public void setPersDocumento(String persDocumento) {
        this.persDocumento = persDocumento;
    }

    public String getPersTipDocumento() {
        return persTipDocumento;
    }

    public void setPersTipDocumento(String persTipDocumento) {
        this.persTipDocumento = persTipDocumento;
    }

    public String getTituFechaRegistro() {
        return tituFechaRegistro;
    }

    public void setTituFechaRegistro(String tituFechaRegistro) {
        this.tituFechaRegistro = tituFechaRegistro;
    }

    public String getTituFechaVencimiento() {
        return tituFechaVencimiento;
    }

    public void setTituFechaVencimiento(String tituFechaVencimiento) {
        this.tituFechaVencimiento = tituFechaVencimiento;
    }

    public String getTitunumRegistro() {
        return titunumRegistro;
    }

    public void setTitunumRegistro(String titunumRegistro) {
        this.titunumRegistro = titunumRegistro;
    }
}
