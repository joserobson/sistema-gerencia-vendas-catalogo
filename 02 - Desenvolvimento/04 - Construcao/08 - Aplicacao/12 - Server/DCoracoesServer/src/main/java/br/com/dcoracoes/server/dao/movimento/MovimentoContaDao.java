/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dcoracoes.server.dao.movimento;

import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.movimento.MovimentoConta;

/**
 *
 * @author Robson
 */
public interface MovimentoContaDao {

    public void mantemMovimentoConta(MovimentoConta movimentoConta) throws ServerException;
}
