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
public class ObraDerechoAutor {

    /**
     * Título de la obra
     */
    private String tituloObra; ///
    /**
     * Clase de la Obra
     */
    private String descripcionclaseObra; ///
    /**
     * 
     */
    private String autorObra; ///
    /**
     * 
     */
    private String titularObra; ///
    /**
     * Datos del Interprete en caso de obra musical
     */
    private String interpreteObra; ///
    /**
     * Nro de Certificado
     */
    private String nroCertificado; ///
    /**
     * Usuario que firma el certificado
     */
    private String nombreUsuarioAprobacion; ///
    /**
     * Categoría del usuario que firma el certificado
     */
    private String categoriaUsuarioAprobacion; ///
    /**
     * Fecha de Registro
     */
    private String fechaRegistroObra; ///
    /**
     * 
     */
    private ListaPersonaDerechoAutor personas;
    /**
     * Mensaje de error
     */
    private String error;

    public ObraDerechoAutor(String tituloObra, 
            String descripcionclaseObra, 
            String autorObra, 
            String titularObra, 
            String interpreteObra, 
            String nroCertificado, 
            String nombreUsuarioAprobacion, 
            String categoriaUsuarioAprobacion, 
            String fechaRegistroObra, 
            ListaPersonaDerechoAutor persona) {
        this.tituloObra = tituloObra;
        this.descripcionclaseObra = descripcionclaseObra;
        this.autorObra = autorObra;
        this.titularObra = titularObra;
        this.interpreteObra = interpreteObra;
        this.nroCertificado = nroCertificado;
        this.nombreUsuarioAprobacion = nombreUsuarioAprobacion;
        this.categoriaUsuarioAprobacion = categoriaUsuarioAprobacion;
        this.fechaRegistroObra = fechaRegistroObra;
        this.personas = persona;
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

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
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

    public ListaPersonaDerechoAutor getPersonas() {
        return personas;
    }

    public void setPersonas(ListaPersonaDerechoAutor persona) {
        this.personas = persona;
    }

    public String getTitularObra() {
        return titularObra;
    }

    public void setTitularObra(String titularObra) {
        this.titularObra = titularObra;
    }

    public String getTituloObra() {
        return tituloObra;
    }

    public void setTituloObra(String tituloObra) {
        this.tituloObra = tituloObra;
    }
}
