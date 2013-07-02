/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.bo.cadastro;

import br.com.dcoracoes.server.dao.cadastro.AssociaPessoaDao;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.cadastro.AssociaPessoa;
import br.com.dcoracoes.server.model.cadastro.Pessoa;
import br.com.dcoracoes.server.util.HibernateUtil;
import java.util.List;

/**
 *
 * @author Robson
 */
public class AssociaPessoaBoImpl implements AssociaPessoaBo<AssociaPessoa> {

    private AssociaPessoaDao associaPessoaDao;

    @Override
    public void setAssociaPessoaDao(AssociaPessoaDao dao) {
        this.associaPessoaDao = dao;
    }

    @Override
    public void mantemAssociaPessoa(AssociaPessoa associaPessoa) throws ServerException {
        this.associaPessoaDao.mantemAssociaPessoa(associaPessoa);
    }

    @Override
    public List<AssociaPessoa> recPessoasAssociadas(Pessoa pessoa) throws ServerException {

        try {
            HibernateUtil.setSession();
            List<AssociaPessoa> lstAssociaPessoa = associaPessoaDao.recPessoasAssociadas(pessoa);
            return lstAssociaPessoa;
        } catch (ServerException ex) {
            throw ex;
        } finally {
            //FECHAR SESSAO
            HibernateUtil.getSession().close();
        }
    }
}
