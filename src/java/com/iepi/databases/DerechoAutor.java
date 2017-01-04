/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iepi.databases;

/**
 *
 * @author Administrator
 */
public class DerechoAutor {

    /**
     * Lista de obras
     */
    private ListaObraDerechoAutor obras;
    /**
     * Mensaje de error
     */
    private String error;

    public DerechoAutor(ListaObraDerechoAutor obras) {
        this.obras = obras;
    }

    public DerechoAutor() {
        this.obras = new ListaObraDerechoAutor();
    }

    public ListaObraDerechoAutor getObras() {
        return obras;
    }

    public void setObras(ListaObraDerechoAutor obras) {
        this.obras = obras;
    }

    public void setError(String error) {
        this.error = error;
    }
}
