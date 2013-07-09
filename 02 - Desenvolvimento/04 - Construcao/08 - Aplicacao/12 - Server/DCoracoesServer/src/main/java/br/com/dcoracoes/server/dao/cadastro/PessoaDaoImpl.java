/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.dao.cadastro;

import br.com.dcoracoes.server.dao.ModelGenericoDaoImpl;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.cadastro.Email;
import br.com.dcoracoes.server.model.cadastro.Pessoa;
import br.com.dcoracoes.server.model.cadastro.Telefone;
import br.com.dcoracoes.server.util.HibernateUtil;
import br.com.dcoracoes.server.util.LogUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Robson
 */
public class PessoaDaoImpl extends ModelGenericoDaoImpl implements PessoaDao {

    @Override
    public void mantemPessoa(Pessoa pPessoa) throws ServerException {
        LogUtil.logInicioProcessoMetodo(pPessoa.getClass(), "mantemPessoa");

        Session sessao = null;
        try {
            sessao = HibernateUtil.getSession();
            sessao.saveOrUpdate(pPessoa);            

            LogUtil.logSucesso(pPessoa.getClass(), "mantemPessoa", pPessoa.getId());

        } catch (HibernateException ex) {
            LogUtil.logDescricaoErro(pPessoa.getClass(), "ERRO AO SALVAR PESSOA: " + pPessoa.getId(), ex);
            throw new ServerException(ex);
        } catch (Exception exGenerica) {
            throw new ServerException(exGenerica);
        } finally {
            LogUtil.logFimProcessoMetodo(pPessoa.getClass(), "mantemPessoa");
        }
    }

    @Override
    public List<Telefone> getListaTelefonesPorPessoa(Long id) throws ServerException {
        LogUtil.logInicioProcessoMetodo(PessoaDaoImpl.class, "getListaTelefonesPorPessoa");

        Session sessao = null;
        List<Telefone> retLista = null;
        try {
            sessao = HibernateUtil.getSession();

            Query q = sessao.createQuery("SELECT t FROM Telefone t WHERE t.pessoa.id = :idPessoa");
            q.setParameter("idPessoa", id);
            retLista = q.list();

            LogUtil.logSucesso(PessoaDaoImpl.class, "getListaTelefonesPorPessoa", Long.valueOf(0));

        } catch (HibernateException ex) {
            LogUtil.logDescricaoErro(PessoaDaoImpl.class, "ERRO AO BUSCA LISTA DE TELEFONES: " + id, ex);
            throw new ServerException(ex);
        } catch (Exception exGenerica) {
            throw new ServerException(exGenerica);
        } finally {
            LogUtil.logFimProcessoMetodo(PessoaDaoImpl.class, "getListaTelefonesPorPessoa");
        }

        return retLista;
    }

    @Override
    public List<Email> getListaEmailPorPessoa(Long id) throws ServerException {
        LogUtil.logInicioProcessoMetodo(PessoaDaoImpl.class, "getListaEmailPorPessoa");

        Session sessao = null;
        List<Email> retLista = null;
        try {
            sessao = HibernateUtil.getSession();

            Query q = sessao.createQuery("SELECT e FROM Email e WHERE e.pessoa.id = :idPessoa");
            q.setParameter("idPessoa", id);
            retLista = q.list();

            LogUtil.logSucesso(PessoaDaoImpl.class, "getListaEmailPorPessoa", Long.valueOf(0));

        } catch (HibernateException ex) {
            LogUtil.logDescricaoErro(PessoaDaoImpl.class, "ERRO AO BUSCA LISTA DE EMAIL: " + id, ex);
            throw new ServerException(ex);
        } catch (Exception exGenerica) {
            throw new ServerException(exGenerica);
        } finally {
            LogUtil.logFimProcessoMetodo(PessoaDaoImpl.class, "getListaEmailPorPessoa");
        }

        return retLista;
    }

    /**
     * 
     * @param cpf
     * @return
     * @throws ServerException 
     */
    @Override
    public List<Pessoa> recPessoaPorCPF(String cpf) throws ServerException {

        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSession();
            StringBuilder hql = new StringBuilder();
            hql.append("FROM PessoaFisica p Where p.cpf = '").append(cpf).append("'");
            Query query = sessao.createQuery(hql.toString());
            List lstPessoa = query.list();
            if(!lstPessoa.isEmpty()){
                pessoas.addAll(lstPessoa);             
            }

        } catch (HibernateException ex) {
            throw new ServerException(ex);
        } catch (Exception exGenerica) {
            throw new ServerException(exGenerica);
        }
        return pessoas;
    }

    @Override
    public Pessoa recPessoaPorId(long id) throws ServerException {
        return (Pessoa)this.getObjectPorId(id, Pessoa.class);
    }
}
