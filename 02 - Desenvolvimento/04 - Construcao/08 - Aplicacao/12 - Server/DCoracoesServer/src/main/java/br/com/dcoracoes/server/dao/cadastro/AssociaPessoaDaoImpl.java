/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.dao.cadastro;

import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.cadastro.AssociaPessoa;
import br.com.dcoracoes.server.model.cadastro.Pessoa;
import br.com.dcoracoes.server.util.HibernateUtil;
import br.com.dcoracoes.server.util.LogUtil;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Robson
 */
public class AssociaPessoaDaoImpl implements AssociaPessoaDao {

    @Override
    public void mantemAssociaPessoa(AssociaPessoa pAssociaPessoa) throws ServerException {

        LogUtil.logInicioProcessoMetodo(AssociaPessoa.class, "mantemAssociaPessoa");
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSession();
            sessao.saveOrUpdate(pAssociaPessoa);
            LogUtil.logSucesso(AssociaPessoa.class, "mantemAssociaPessoa", pAssociaPessoa.getChaveComposta().getPessoaAssociante().getId());
        } catch (HibernateException ex) {
            LogUtil.logDescricaoErro(AssociaPessoa.class, "ERRO AO SALVAR ASSOCIAPESSOA: " + pAssociaPessoa.getChaveComposta().getPessoaAssociante().getId(), ex);
            throw new ServerException(ex);
        } catch (Exception exGenerica) {
            throw new ServerException(exGenerica);
        } finally {
            LogUtil.logFimProcessoMetodo(AssociaPessoa.class, "mantemAssociaPessoa");
        }
    }

    @Override
    public List recPessoasAssociadas(Pessoa pessoa) throws ServerException {

        List<AssociaPessoa> listaRetorno = null;
        LogUtil.logInicioProcessoMetodo(AssociaPessoa.class, "recPessoasAssociadas");
        try {
            Session sessao = HibernateUtil.getSession();
            StringBuilder hqlConsulta = new StringBuilder();
            hqlConsulta.append("from AssociaPessoa ap ");
            hqlConsulta.append("where ap.chaveComposta.pessoaAssociante.id = ");
            hqlConsulta.append(pessoa.getId());
            Query query = sessao.createQuery(hqlConsulta.toString());
            listaRetorno =  query.list();
            for (AssociaPessoa associaPessoa : listaRetorno) {
                Hibernate.initialize(associaPessoa.getChaveComposta().getPessoaAssociada().getEmails());
                Hibernate.initialize(associaPessoa.getChaveComposta().getPessoaAssociada().getTelefones());
                Hibernate.initialize(associaPessoa.getChaveComposta().getPessoaAssociante().getEmails());
                Hibernate.initialize(associaPessoa.getChaveComposta().getPessoaAssociante().getTelefones());
            }

        } catch (HibernateException ex) {
            LogUtil.logDescricaoErro(AssociaPessoa.class, "recPessoasAssociadas", ex);
            throw new ServerException(ex);
        } catch (Exception ex) {
            throw new ServerException(ex);
        } finally {
            LogUtil.logFimProcessoMetodo(AssociaPessoa.class, "recPessoasAssociadas");
        }

        return listaRetorno;
    }
}
