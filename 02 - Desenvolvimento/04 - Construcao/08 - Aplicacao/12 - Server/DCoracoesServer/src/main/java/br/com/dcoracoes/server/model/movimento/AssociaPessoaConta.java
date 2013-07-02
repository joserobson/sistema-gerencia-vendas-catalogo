package br.com.dcoracoes.server.model.movimento;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Robson
 * @version 1.0
 * @created 06-mar-2012 18:46:07
 */
@Entity
@Table(name="tb_associa_pessoa_movimento")
public class AssociaPessoaConta implements Serializable {

    @EmbeddedId
    private AssociaPessoaContaFK associaPessoaFK;
    @Column(name = "titularidade")
    private int titularidade;

    public AssociaPessoaConta() {
        super();
    }

    public void finalize() throws Throwable {
    }

    public int getTitularidade() {
        return titularidade;
    }

    public void setTitularidade(int titularidade) {
        this.titularidade = titularidade;
    }

    public AssociaPessoaContaFK getAssociaPessoaFK() {
        return associaPessoaFK;
    }

    public void setAssociaPessoaFK(AssociaPessoaContaFK associaPessoaFK) {
        this.associaPessoaFK = associaPessoaFK;
    }
}
