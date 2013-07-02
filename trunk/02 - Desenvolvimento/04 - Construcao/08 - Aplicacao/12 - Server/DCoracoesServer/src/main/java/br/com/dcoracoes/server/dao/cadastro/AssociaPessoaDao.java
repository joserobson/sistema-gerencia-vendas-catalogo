/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.dao.cadastro;

import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.cadastro.AssociaPessoa;
import br.com.dcoracoes.server.model.cadastro.Pessoa;
import java.util.List;

/**
 *
 * @author Robson
 */
public interface AssociaPessoaDao<T extends AssociaPessoa> {

    public void mantemAssociaPessoa(T pAssociaPessoa) throws ServerException;

    public List<T> recPessoasAssociadas(Pessoa pessoa) throws ServerException;
}
