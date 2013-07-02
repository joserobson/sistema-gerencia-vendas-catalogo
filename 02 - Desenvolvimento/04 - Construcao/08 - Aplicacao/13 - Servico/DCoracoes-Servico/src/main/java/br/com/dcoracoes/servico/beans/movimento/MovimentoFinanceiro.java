package br.com.dcoracoes.servico.beans.movimento;

import java.io.Serializable;

/**
 * @author Jose Robson
 * @version 1.0 @created 06-mar-2012 18:43:14
 */
public class MovimentoFinanceiro implements Serializable {

    private Long id;

    public MovimentoFinanceiro() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
