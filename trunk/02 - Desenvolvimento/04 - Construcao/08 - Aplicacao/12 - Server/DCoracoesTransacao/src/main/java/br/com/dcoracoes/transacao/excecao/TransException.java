/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dcoracoes.transacao.excecao;

/**
 *
 * @author Robson
 */
public class TransException extends Exception{

    public TransException(Throwable cause) {
        super(cause);
    }

    public TransException(String message, Throwable cause) {
        super(message, cause);
    }

    public TransException(String message) {
        super(message);
    }

    public TransException() {
    }

  
}
