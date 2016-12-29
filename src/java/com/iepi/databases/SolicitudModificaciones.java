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
public class SolicitudModificaciones {

    /**
     * Descripción de la solicitud
     */
    private String solTipDescripcion;
    /**
     * Nuevo valor
     */
    private String soliValorNuevo;
    /**
     * Fecha del certificado
     */
    private String soliFechaCertificado;
    /**
     * Número del certificado
     */
    private String soliNumCertificado;
    /**
     * Fecha de licencia
     */
    private String soliFechaContratoLicencia;
    /**
     * Listado de personas beneficiarias
     */
    private List<SolicitudPersonaBeneficiariaModificaciones> personasBeneficiarias;

    public SolicitudModificaciones(String solTipDescripcion, String soliValorNuevo, String soliFechaCertificado, String soliNumCertificado, String soliFechaContratoLicencia, List<SolicitudPersonaBeneficiariaModificaciones> personasBeneficiarias) {
        this.solTipDescripcion = solTipDescripcion;
        this.soliValorNuevo = soliValorNuevo;
        this.soliFechaCertificado = soliFechaCertificado;
        this.soliNumCertificado = soliNumCertificado;
        this.soliFechaContratoLicencia = soliFechaContratoLicencia;
        this.personasBeneficiarias = personasBeneficiarias;
    }

    public SolicitudModificaciones() {
    }

    public String getSolTipDescripcion() {
        return solTipDescripcion;
    }

    public void setSolTipDescripcion(String solTipDescripcion) {
        this.solTipDescripcion = solTipDescripcion;
    }

    public String getSoliFechaCertificado() {
        return soliFechaCertificado;
    }

    public void setSoliFechaCertificado(String soliFechaCertificado) {
        this.soliFechaCertificado = soliFechaCertificado;
    }

    public String getSoliFechaContratoLicencia() {
        return soliFechaContratoLicencia;
    }

    public void setSoliFechaContratoLicencia(String soliFechaContratoLicencia) {
        this.soliFechaContratoLicencia = soliFechaContratoLicencia;
    }

    public String getSoliNumCertificado() {
        return soliNumCertificado;
    }

    public void setSoliNumCertificado(String soliNumCertificado) {
        this.soliNumCertificado = soliNumCertificado;
    }

    public String getSoliValorNuevo() {
        return soliValorNuevo;
    }

    public void setSoliValorNuevo(String soliValorNuevo) {
        this.soliValorNuevo = soliValorNuevo;
    }

    public List<SolicitudPersonaBeneficiariaModificaciones> getPersonasBeneficiarias() {
        return personasBeneficiarias;
    }

    public void setPersonasBeneficiarias(List<SolicitudPersonaBeneficiariaModificaciones> personasBeneficiarias) {
        this.personasBeneficiarias = personasBeneficiarias;
    }
}
