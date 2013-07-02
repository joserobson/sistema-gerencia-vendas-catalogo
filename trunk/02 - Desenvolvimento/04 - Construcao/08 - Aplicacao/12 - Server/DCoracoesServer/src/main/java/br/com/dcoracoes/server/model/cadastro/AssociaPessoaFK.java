/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dcoracoes.server.model.cadastro;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Robson
 */
@Embeddable
public class AssociaPessoaFK implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_pessoa_associada")
    private Pessoa pessoaAssociada;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_pessoa_associante")
    private Pessoa pessoaAssociante;

    public Pessoa getPessoaAssociada() {
        return pessoaAssociada;
    }

    public void setPessoaAssociada(Pessoa pessoaAssociada) {
        this.pessoaAssociada = pessoaAssociada;
    }

    public Pessoa getPessoaAssociante() {
        return pessoaAssociante;
    }

    public void setPessoaAssociante(Pessoa pessoaAssociante) {
        this.pessoaAssociante = pessoaAssociante;
    }

    

}
