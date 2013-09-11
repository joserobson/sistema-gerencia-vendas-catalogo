/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.servico.beans.relatorio;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Robson
 */
public class ModelGerarEtiqueta implements Serializable {
    
    private int situacao;
    private String uf;
    private Date dataNascimentoInicio;
    private Date dataNascimentoFim;    

    public Date getDataNascimentoFim() {
        return dataNascimentoFim;
    }

    public void setDataNascimentoFim(Date dataNascimentoFim) {
        this.dataNascimentoFim = dataNascimentoFim;
    }

    public Date getDataNascimentoInicio() {
        return dataNascimentoInicio;
    }

    public void setDataNascimentoInicio(Date dataNascimentoInicio) {
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
