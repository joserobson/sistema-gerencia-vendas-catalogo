package br.com.dcoracoes.server.model.movimento;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Jose Robson
 * @version 1.0
 * @created 06-mar-2012 18:43:11
 */
@Entity
@DiscriminatorValue("ContaCorrente")
public class ContaCorrente extends MovimentoConta {

    public ContaCorrente() {
        super();
    }
    
}
