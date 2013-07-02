package br.com.dcoracoes.server.model.movimento;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Jose Robson
 * @version 1.0
 * @created 06-mar-2012 18:43:12
 */
@Entity
@DiscriminatorValue("ContaPoupanca")
public class ContaPoupanca extends MovimentoConta {

	public ContaPoupanca(){
            super();
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}