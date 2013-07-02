/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dcoracoes.server.bo.cadastro;

import br.com.dcoracoes.server.dao.cadastro.AssociaPessoaDao;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.cadastro.AssociaPessoa;
import br.com.dcoracoes.server.model.cadastro.Pessoa;
import java.util.List;

/**
 *
 * @author Robson
 */
public interface AssociaPessoaBo <T extends AssociaPessoa>{

    public void setAssociaPessoaDao(AssociaPessoaDao dao);

    public void mantemAssociaPessoa(T associaPessoa) throws ServerException;

    public List<T> recPessoasAssociadas(Pessoa pessoa) throws ServerException;

}
