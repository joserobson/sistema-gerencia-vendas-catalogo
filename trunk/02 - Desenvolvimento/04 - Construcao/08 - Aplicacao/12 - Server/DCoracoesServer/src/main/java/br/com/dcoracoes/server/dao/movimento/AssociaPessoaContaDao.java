/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dcoracoes.server.dao.movimento;

import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.cadastro.Pessoa;
import br.com.dcoracoes.server.model.movimento.AssociaPessoaConta;

/**
 *
 * @author Robson
 */
public interface AssociaPessoaContaDao <T extends AssociaPessoaConta>  {

    public void mantemAssociaPessoaConta(T pAssociaPessoaConta) throws ServerException;

    public T recAssociaPessoaConta(Pessoa pessoa) throws ServerException;
}
