package br.com.dcoracoes.servico.beans.movimento;

/**
 * @author Jose Robson
 * @version 1.0 @created 06-mar-2012 18:43:13
 */
public class MovimentoConta extends MovimentoFinanceiro {

    private String banco;
    private String numero;
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
