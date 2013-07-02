package br.com.dcoracoes.teste.dcoracoes.beans;

import java.io.Serializable;

/**
 * @author robson
 * @version 1.0 @created 06-mar-2012 18:42:26
 */
public class Email implements Serializable {

    private Long id;
    private String enderecoEmail;
    public Pessoa pessoa;

    public Email() {
        super();
        this.enderecoEmail = null;
        this.pessoa = null;
    }

    public String getEnderecoEmail() {
        return enderecoEmail;
    }

    public void setEnderecoEmail(String enderecoEmail) {
        this.enderecoEmail = enderecoEmail;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa m_Pessoa) {
        this.pessoa = m_Pessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
