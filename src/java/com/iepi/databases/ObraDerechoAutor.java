/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iepi.databases;

/**
 *
 * @author Administrator
 */
public class ObraDerechoAutor {

    /**
     * Título de la obra
     */
    private String tituloObra;
    /**
     * Clase de la Obra
     */
    private String descripcionclaseObra;
    /**
     * 
     */
    private String autorObra;
    /**
     * 
     */
    private String ttitularObra;
    /**
     * Datos del Interprete en caso de obra musical
     */
    private String interpreteObra;
    /**
     * Nro de Certificado
     */
    private String nroCertificado;
    /**
     * Usuario que firma el certificado
     */
    private String nombreUsuarioAprobacion;
    /**
     * Categoría del usuario que firma el certificado
     */
    private String categoriaUsuarioAprobacion;
    /**
     * Fecha de Registro
     */
    private String fechaRegistroObra;

    public ObraDerechoAutor(String tituloObra, String descripcionclaseObra, String autorObra, String ttitularObra, String interpreteObra, String nroCertificado, String nombreUsuarioAprobacion, String categoriaUsuarioAprobacion, String fechaRegistroObra) {
        this.tituloObra = tituloObra;
        this.descripcionclaseObra = descripcionclaseObra;
        this.autorObra = autorObra;
        this.ttitularObra = ttitularObra;
        this.interpreteObra = interpreteObra;
        this.nroCertificado = nroCertificado;
        this.nombreUsuarioAprobacion = nombreUsuarioAprobacion;
        this.categoriaUsuarioAprobacion = categoriaUsuarioAprobacion;
        this.fechaRegistroObra = fechaRegistroObra;
    }

    public ObraDerechoAutor() {
    }

    public String getAutorObra() {
        return autorObra;
    }

    public void setAutorObra(String autorObra) {
        this.autorObra = autorObra;
    }

    public String getCategoriaUsuarioAprobacion() {
        return categoriaUsuarioAprobacion;
    }

    public void setCategoriaUsuarioAprobacion(String categoriaUsuarioAprobacion) {
        this.categoriaUsuarioAprobacion = categoriaUsuarioAprobacion;
    }

    public String getDescripcionclaseObra() {
        return descripcionclaseObra;
    }

    public void setDescripcionclaseObra(String descripcionclaseObra) {
        this.descripcionclaseObra = descripcionclaseObra;
    }

    public String getFechaRegistroObra() {
        return fechaRegistroObra;
    }

    public void setFechaRegistroObra(String fechaRegistroObra) {
        this.fechaRegistroObra = fechaRegistroObra;
    }

    public String getInterpreteObra() {
        return interpreteObra;
    }

    public void setInterpreteObra(String interpreteObra) {
        this.interpreteObra = interpreteObra;
    }

    public String getNombreUsuarioAprobacion() {
        return nombreUsuarioAprobacion;
    }

    public void setNombreUsuarioAprobacion(String nombreUsuarioAprobacion) {
        this.nombreUsuarioAprobacion = nombreUsuarioAprobacion;
    }

    public String getNroCertificado() {
        return nroCertificado;
    }

    public void setNroCertificado(String nroCertificado) {
        this.nroCertificado = nroCertificado;
    }

    public String getTituloObra() {
        return tituloObra;
    }

    public void setTituloObra(String tituloObra) {
        this.tituloObra = tituloObra;
    }

    public String getTtitularObra() {
        return ttitularObra;
    }

    public void setTtitularObra(String ttitularObra) {
        this.ttitularObra = ttitularObra;
    }
}
