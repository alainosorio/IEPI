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
public class ListaPersonaDerechoAutor {

    /**
     * Lista de persona
     */
    private List<PersonaDerechoAutor> persona;

    public ListaPersonaDerechoAutor(List<PersonaDerechoAutor> personas) {
        this.persona = personas;
    }

    public ListaPersonaDerechoAutor() {
    }

    public List<PersonaDerechoAutor> getPersona() {
        return persona;
    }

    public void setPersona(List<PersonaDerechoAutor> persona) {
        this.persona = persona;
    }

}
