package br.com.dcoracoes.servico.beans.cadastro;

import java.io.Serializable;
import java.util.List;

/**
 * @author Jose Robson
 * @version 1.0 @created 06-mar-2012 18:42:28
 */
public class Pessoa implements Serializable {

    private Long id;
    private String nome;
    private Endereco endereco;
    private List<Telefone> telefones;
    private List<Email> emails;

    public Pessoa() {
        this.nome = "";
        this.endereco = null;
        this.telefones = null;
        this.emails = null;
        this.id = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
