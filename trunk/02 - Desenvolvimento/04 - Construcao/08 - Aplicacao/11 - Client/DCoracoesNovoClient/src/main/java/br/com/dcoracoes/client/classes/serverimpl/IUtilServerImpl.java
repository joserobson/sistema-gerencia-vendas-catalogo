/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.classes.serverimpl;

import br.com.dcoracoes.client.Excecao.ClientDCoracoesException;

/**
 *
 * @author Jose Robson
 */
interface IUtilServerImpl {

    boolean testeConexaoBanco() throws ClientDCoracoesException;
}
