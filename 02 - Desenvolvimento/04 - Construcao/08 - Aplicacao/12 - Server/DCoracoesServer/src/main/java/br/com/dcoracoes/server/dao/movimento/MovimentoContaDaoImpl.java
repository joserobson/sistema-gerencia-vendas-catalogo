/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.dao.movimento;

import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.movimento.MovimentoConta;
import br.com.dcoracoes.server.util.HibernateUtil;
import br.com.dcoracoes.server.util.LogUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Robson
 */
public class MovimentoContaDaoImpl implements MovimentoContaDao {

    @Override
    public void mantemMovimentoConta(MovimentoConta pMovimentoConta) throws ServerException {
        LogUtil.logInicioProcessoMetodo(pMovimentoConta.getClass(), "mantemMovimentoConta");

        Session sessao = null;
        try {
            sessao = HibernateUtil.getSession();
            sessao.saveOrUpdate(pMovimentoConta);
            LogUtil.logSucesso(pMovimentoConta.getClass(), "mantemMovimentoConta", pMovimentoConta.getId());

        } catch (HibernateException ex) {
            LogUtil.logDescricaoErro(pMovimentoConta.getClass(), "ERRO AO SALVAR MOVIMENTO CONTA: " + pMovimentoConta.getId(), ex);
            throw new ServerException(ex);
        } catch (Exception exGenerica) {
            throw new ServerException(exGenerica);
        } finally {
            LogUtil.logFimProcessoMetodo(pMovimentoConta.getClass(), "mantemMovimentoConta");
        }
    }
}
