package br.com.dcoracoes.teste.dcoracoes.beans;

import java.io.Serializable;

/**
 * @author Jose Robson
 * @version 1.0 @created 06-mar-2012 18:42:30
 */
public class Telefone implements Serializable {

    private Long id;
    private String numero;
    private String operadora;
    private int tipoTelefone;
    public Pessoa pessoa;

    public Telefone() {
        this.numero = null;
        this.operadora = null;
        this.tipoTelefone = 0;
        this.pessoa = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa m_Pessoa) {
        this.pessoa = m_Pessoa;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    public int getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(int tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }
}
