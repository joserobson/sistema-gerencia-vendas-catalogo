/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.Excecao;

/**
 *
 * @author Robson
 */
public class ClientDCoracoesException extends Exception {

    public ClientDCoracoesException(Throwable cause) {
        super(cause);
    }

    public ClientDCoracoesException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClientDCoracoesException(String message) {
        super(message);
    }

    public ClientDCoracoesException() {
    }
}
