/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.servico.beans.relatorio;

import java.io.Serializable;

/**
 *
 * @author Robson
 */
public class ModelGerarEtiqueta implements Serializable {
    
    private int situacao;
    private String uf;
    private String dataNascimentoInicio;
    private String dataNascimentoFim;    

    public String getDataNascimentoFim() {
        return dataNascimentoFim;
    }

    public void setDataNascimentoFim(String dataNascimentoFim) {
        this.dataNascimentoFim = dataNascimentoFim;
    }

    public String getDataNascimentoInicio() {
        return dataNascimentoInicio;
    }

    public void setDataNascimentoInicio(String dataNascimentoInicio) {
        this.dataNascimentoInicio = dataNascimentoInicio;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
