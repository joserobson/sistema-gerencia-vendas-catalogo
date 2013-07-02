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
public interface MovimentoContaBo <T extends MovimentoConta>{

    public void setMovimentoContaDao(MovimentoContaDao dao);

    public void mantemMovimentoConta(T movimentoConta) throws ServerException;

}
