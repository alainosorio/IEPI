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
public class ListaObraDerechoAutor {

    /**
     * Lista de obras
     */
    private List<ObraDerechoAutor> obra;

    public ListaObraDerechoAutor(List<ObraDerechoAutor> obra) {
        this.obra = obra;
    }

    public ListaObraDerechoAutor() {
    }

    public List<ObraDerechoAutor> getObra() {
        return obra;
    }

    public void setObra(List<ObraDerechoAutor> obra) {
        this.obra = obra;
    }
}
