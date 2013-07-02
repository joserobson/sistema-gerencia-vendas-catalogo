/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.classes.serverimpl;

import br.com.dcoracoes.client.Excecao.ClientDCoracoesException;

/**
 *
 * @author Robson
 */
public class UtilServerImpl extends BaseServerImpl<Object> implements IUtilServerImpl {

    public boolean testeConexaoBanco() throws ClientDCoracoesException {

        boolean conectou = true;
        try {
            conectou = this.port.verificarConexaoComBanco();
        } catch (Exception ex) {
            throw new ClientDCoracoesException(ex);
        }

        return conectou;
    }
}
