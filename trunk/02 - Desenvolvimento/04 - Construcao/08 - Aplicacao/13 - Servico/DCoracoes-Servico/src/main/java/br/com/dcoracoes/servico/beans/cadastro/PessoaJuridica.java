/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.servico.beans.cadastro;

/**
 *
 * @author Robson
 */
public class PessoaJuridica extends Pessoa {

    private String cnpj;
    private String inscricaoEstadual;

    public PessoaJuridica() {
        super();
        this.cnpj = null;
        this.inscricaoEstadual = null;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }
}
