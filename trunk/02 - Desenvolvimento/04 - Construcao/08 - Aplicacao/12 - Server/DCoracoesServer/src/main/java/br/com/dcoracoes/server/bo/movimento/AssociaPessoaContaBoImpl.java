/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.bo.movimento;

import br.com.dcoracoes.server.dao.movimento.AssociaPessoaContaDao;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.cadastro.Pessoa;
import br.com.dcoracoes.server.model.movimento.AssociaPessoaConta;
import br.com.dcoracoes.server.util.HibernateUtil;
import org.hibernate.HibernateException;

/**
 *
 * @author Robson
 */
public class AssociaPessoaContaBoImpl implements AssociaPessoaContaBo<AssociaPessoaConta> {

    private AssociaPessoaContaDao associaPessaoContaDao;

    @Override
    public void setAssociaPessoaContaDao(AssociaPessoaContaDao dao) {
        this.associaPessaoContaDao = dao;
    }

    @Override
    public void mantemAssociaPessoaConta(AssociaPessoaConta pAssociaPessoaConta) throws ServerException  {
        associaPessaoContaDao.mantemAssociaPessoaConta(pAssociaPessoaConta);
    }

    @Override
    public AssociaPessoaConta recAssociaPessoaConta(Pessoa pessoa) throws ServerException{
        try {
            //INICIALIZA SESSAO
            HibernateUtil.setSession();
            return associaPessaoContaDao.recAssociaPessoaConta(pessoa);
        } catch (HibernateException ex) {
            throw ex;
        } finally {
            HibernateUtil.getSession().clear();
        }

    }
}
