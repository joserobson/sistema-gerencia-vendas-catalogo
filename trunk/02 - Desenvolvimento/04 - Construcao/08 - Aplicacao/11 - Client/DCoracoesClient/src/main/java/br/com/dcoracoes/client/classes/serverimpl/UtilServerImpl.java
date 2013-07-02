/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.classes.serverimpl;

import br.com.dcoracoes.transacao.util.TransacaoUtil;

/**
 *
 * @author Robson
 */
public class UtilServerImpl {

    public boolean testeConexaoBanco() {

        return TransacaoUtil.verificaConexaoComBanco();

    }
}
