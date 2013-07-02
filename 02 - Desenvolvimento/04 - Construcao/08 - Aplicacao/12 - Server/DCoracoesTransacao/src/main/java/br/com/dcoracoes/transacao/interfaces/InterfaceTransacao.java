/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dcoracoes.transacao.interfaces;

import br.com.dcoracoes.transacao.excecao.TransException;

/**
 *
 * @author Robson
 */
public interface InterfaceTransacao {

    public void salvar(String evento)throws TransException;    
    
    public boolean validarDados(String evento)throws TransException;

    public void deletar(String evento)throws TransException;;
}
