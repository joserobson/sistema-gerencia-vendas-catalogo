/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.servico.service;

import br.com.dcoracoes.transacao.excecao.TransException;
import br.com.dcoracoes.transacao.util.TransacaoUtil;

/**
 *
 * @author Jose Robson
 */
public class ServiceUtil implements IServiceUtil {

    /**
     * Verifica conexao com banco
     *
     * @return
     * @throws TransException
     */
    @Override
    public boolean verificaConexaoComBanco() {
        return TransacaoUtil.verificaConexaoComBanco();

    }
}
