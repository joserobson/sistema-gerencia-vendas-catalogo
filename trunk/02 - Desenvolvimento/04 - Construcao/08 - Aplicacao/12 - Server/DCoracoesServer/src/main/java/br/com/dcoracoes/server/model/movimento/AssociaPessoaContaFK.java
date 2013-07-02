/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dcoracoes.server.model.movimento;

import br.com.dcoracoes.server.model.cadastro.Pessoa;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Robson
 */
@Embeddable
public class AssociaPessoaContaFK implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_movimento")
    private MovimentoConta conta;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_pessoa")
    private Pessoa pessoa;

    public MovimentoConta getConta() {
        return conta;
    }

    public void setConta(MovimentoConta conta) {
        this.conta = conta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    
}
