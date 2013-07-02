    package br.com.dcoracoes.server.model.cadastro;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * @author Jose Robson
 * @version 1.0
 * @created 06-mar-2012 18:42:30
 */
@Entity
@Table(name = "tb_telefone")
public class Telefone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "numero")
    private String numero;
    @Column(name = "operadora")
    private String operadora;
    @Column(name = "id_tipo")
    private int tipoTelefone;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pessoa", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
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
