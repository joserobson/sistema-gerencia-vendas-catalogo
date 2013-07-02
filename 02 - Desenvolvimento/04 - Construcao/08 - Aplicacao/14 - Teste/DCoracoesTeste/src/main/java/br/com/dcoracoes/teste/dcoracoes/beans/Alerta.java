/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.teste.dcoracoes.beans;


import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Robson
 */
public class Alerta implements Serializable {

    private Long id;
    private String assunto;
    private Date dataAlerta;
    private String descricao;
    private String protocolo;
    private int situacaoAlerta;
    private Pessoa pessoa;
    private Usuario atendente;

    public Alerta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public Usuario getAtendente() {
        return atendente;
    }

    public void setAtendente(Usuario atendente) {
        this.atendente = atendente;
    }

    public Date getDataAlerta() {
        return dataAlerta;
    }

    public void setDataAlerta(Date dataAlerta) {
        this.dataAlerta = dataAlerta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public int getSituacaoAlerta() {
        return situacaoAlerta;
    }

    public void setSituacaoAlerta(int situacaoAlerta) {
        this.situacaoAlerta = situacaoAlerta;
    }
}
