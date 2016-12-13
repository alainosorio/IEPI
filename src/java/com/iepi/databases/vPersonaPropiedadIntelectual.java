/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iepi.databases;

/**
 *
 * @author Administrator
 */
public class vPersonaPropiedadIntelectual {

    private String persdocumento;
    private String persnombre;
    private String ERROR;

    public vPersonaPropiedadIntelectual(String persdocumento, String persnombre) {
        this.persdocumento = persdocumento;
        this.persnombre = persnombre;
    }

    public vPersonaPropiedadIntelectual() {
        
    }

    /**
     * @return the persdocumento
     */
    public String getPersdocumento() {
        return persdocumento;
    }

    /**
     * @param persdocumento the persdocumento to set
     */
    public void setPersdocumento(String persdocumento) {
        this.persdocumento = persdocumento;
    }

    /**
     * @return the persnombre
     */
    public String getPersnombre() {
        return persnombre;
    }

    /**
     * @param persnombre the persnombre to set
     */
    public void setPersnombre(String persnombre) {
        this.persnombre = persnombre;
    }

    /**
     * @return the ERROR
     */
    public String getERROR() {
        return ERROR;
    }

    /**
     * @param ERROR the ERROR to set
     */
    public void setERROR(String ERROR) {
        this.ERROR = ERROR;
    }
}
