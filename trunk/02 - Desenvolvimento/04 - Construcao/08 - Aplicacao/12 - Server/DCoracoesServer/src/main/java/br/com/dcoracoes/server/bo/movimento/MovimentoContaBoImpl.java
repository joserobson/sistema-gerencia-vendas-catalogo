/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dcoracoes.server.bo.movimento;

import br.com.dcoracoes.server.dao.movimento.MovimentoContaDao;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.movimento.MovimentoConta;

/**
 *
 * @author Robson
 */
public class MovimentoContaBoImpl implements MovimentoContaBo<MovimentoConta> {

    private MovimentoContaDao movimentoContaDao;

    @Override
    public void setMovimentoContaDao(MovimentoContaDao dao) {
        this.movimentoContaDao = dao;
    }

    @Override
    public void mantemMovimentoConta(MovimentoConta movimentoConta) throws ServerException {
        movimentoContaDao.mantemMovimentoConta(movimentoConta);
    }

}
