package br.com.dcoracoes.server.model.movimento;

import javax.persistence.*;

/**
 * @author Jose Robson
 * @version 1.0
 * @created 06-mar-2012 18:43:13
 */
@Entity
@DiscriminatorValue("MovimentoConta")
public class MovimentoConta extends MovimentoFinanceiro {

    @Column(name = "banco")
    private String banco;
    @Column(name = "numero_conta")
    private String numero;
    @Column(name = "agencia")
    private String agencia;

    public MovimentoConta() {
        this.banco = "";
        this.numero = "";
        this.agencia = "";
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }
}
