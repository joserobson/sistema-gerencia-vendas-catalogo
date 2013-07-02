/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.model.prospeccao;

import br.com.dcoracoes.server.model.cadastro.Pessoa;
import br.com.dcoracoes.server.model.canalacesso.Usuario;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author Robson
 */
@Entity
@Table(name = "tb_alerta")
public class Alerta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "assunto")
    private String assunto;
    @Column(name = "dataAlerta")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataAlerta;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "protocolo")
    private String protocolo;
    @Column(name = "situacao")
    private int situacaoAlerta;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_pessoa",insertable=true, updatable=true)
    @Fetch(FetchMode.JOIN)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Pessoa pessoa;       
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_usuario",insertable=true, updatable=true)
    @Fetch(FetchMode.JOIN)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
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
