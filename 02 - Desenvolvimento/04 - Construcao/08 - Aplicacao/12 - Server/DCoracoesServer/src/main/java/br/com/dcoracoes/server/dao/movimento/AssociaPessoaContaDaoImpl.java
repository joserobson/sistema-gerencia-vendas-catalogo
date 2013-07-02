/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.dao.movimento;

import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.cadastro.Pessoa;
import br.com.dcoracoes.server.model.movimento.AssociaPessoaConta;
import br.com.dcoracoes.server.util.HibernateUtil;
import br.com.dcoracoes.server.util.LogUtil;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Robson
 */
public class AssociaPessoaContaDaoImpl implements AssociaPessoaContaDao {

    @Override
    public void mantemAssociaPessoaConta(AssociaPessoaConta pAssociaPessoaConta) throws ServerException {
        LogUtil.logInicioProcessoMetodo(AssociaPessoaConta.class, "mantemAssociaPessoaConta");

        Session sessao = null;
        try {
            sessao = HibernateUtil.getSession();
            sessao.saveOrUpdate(pAssociaPessoaConta);

            LogUtil.logSucesso(AssociaPessoaConta.class, "mantemAssociaPessoaConta", pAssociaPessoaConta.getAssociaPessoaFK().getPessoa().getId());

        } catch (HibernateException ex) {
            LogUtil.logDescricaoErro(AssociaPessoaConta.class, "ERRO AO SALVAR ASSOCIAPESSOACONTA: " + pAssociaPessoaConta.getAssociaPessoaFK().getPessoa().getId(), ex);
            throw new ServerException(ex);
        } catch (Exception exGenerica) {
            LogUtil.logDescricaoErro(AssociaPessoaConta.class, "ERRO GENERICO AO SALVAR ASSOCIAPESSOACONTA: " + pAssociaPessoaConta.getAssociaPessoaFK().getPessoa().getId(), exGenerica);
            throw new ServerException(exGenerica);
        } finally {
            LogUtil.logFimProcessoMetodo(AssociaPessoaConta.class, "mantemAssociaPessoaConta");
        }
    }

    @Override
    public AssociaPessoaConta recAssociaPessoaConta(Pessoa pessoa) throws ServerException {
        AssociaPessoaConta retornoAssocia = null;
        LogUtil.logInicioProcessoMetodo(AssociaPessoaConta.class, "recAssociaPessoaConta");
        try {
            Session sessao = HibernateUtil.getSession();
            StringBuilder hql = new StringBuilder();
            hql.append("from AssociaPessoaConta ap ");
            hql.append("where ap.associaPessoaFK.pessoa.id = ");
            hql.append(pessoa.getId());
            Query query = sessao.createQuery(hql.toString());
            retornoAssocia = (AssociaPessoaConta) query.uniqueResult();

            if (retornoAssocia != null) {
                Hibernate.initialize(retornoAssocia.getAssociaPessoaFK().getPessoa().getEmails());
                Hibernate.initialize(retornoAssocia.getAssociaPessoaFK().getPessoa().getTelefones());
            }
        } catch (HibernateException ex) {
            LogUtil.logDescricaoErro(AssociaPessoaConta.class, "ERRO AO RECUPERAR ASSOCIA PESSOA CONTA", ex);
            throw new ServerException(ex);
        } catch (Exception exGenerica) {
            LogUtil.logDescricaoErro(AssociaPessoaConta.class, "ERRO AO RECUPERAR ASSOCIA PESSOA CONTA", exGenerica);
            throw new ServerException(exGenerica);
        } finally {
            LogUtil.logFimProcessoMetodo(AssociaPessoaConta.class, "recAssociaPessoaConta");
        }

        return retornoAssocia;
    }
}
