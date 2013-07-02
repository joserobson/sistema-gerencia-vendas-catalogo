    package br.com.dcoracoes.server.model.cadastro;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * @author Jose Robson
 * @version 1.0
 * @created 06-mar-2012 18:42:28
 */
@Entity
@Table(name = "tb_pessoa")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "classe_name", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Pessoa")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @OneToOne(mappedBy = "pessoa", cascade = {CascadeType.ALL})
    private Endereco endereco;
    @OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Telefone> telefones;
    @OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
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
