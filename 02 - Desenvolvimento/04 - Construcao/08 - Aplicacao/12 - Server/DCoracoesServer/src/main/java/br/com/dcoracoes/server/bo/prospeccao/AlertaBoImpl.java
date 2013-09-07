/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.bo.prospeccao;

import br.com.dcoracoes.server.bo.cadastro.PessoaBoImpl;
import br.com.dcoracoes.server.dao.prospeccao.AlertaDao;
import br.com.dcoracoes.server.dao.cadastro.PessoaDaoImpl;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.cadastro.Pessoa;
import br.com.dcoracoes.server.model.cadastro.PessoaFisica;
import br.com.dcoracoes.server.model.prospeccao.Alerta;
import br.com.dcoracoes.server.util.HibernateUtil;
import br.com.dcoracoes.server.util.LogUtil;
import java.util.List;

/**
 *
 * @author Robson
 */
public class AlertaBoImpl implements AlertaBo<Alerta> {

    private AlertaDao dao;

    @Override
    public void setAlertaDao(AlertaDao dao) {
        this.dao = dao;
    }

    @Override
    public void mantemAlerta(Alerta alerta) throws ServerException {

        //ABRIR LOG
        LogUtil.logInicioProcessoMetodo(AlertaBoImpl.class, "mantemAlerta");
        try {
            //ABRIR SESSAO
            HibernateUtil.setSession();

            //ABRIR TRANSACAO
            HibernateUtil.setTransacao();

            //VERIFICAR SE PESSOA VINCULADA AO ALERTA ESTA CADASTRADO
            PessoaBoImpl pessoaBo = new PessoaBoImpl();
            PessoaDaoImpl pessaoDao = new PessoaDaoImpl();
            pessoaBo.setPessoaDao(pessaoDao);
            if (alerta.getPessoa().getId() == null) {                
                pessoaBo.mantemPessoa(alerta.getPessoa());                                                        
            }
            //SALVAR ALERTA
            this.dao.mantemAlerta(alerta);

            //COMMIT NA TRANSACAO
            HibernateUtil.getTransacao().commit();

            //LOG SUCESSO
            LogUtil.logSucesso(AlertaBoImpl.class, "mantemAlerta", alerta.getId());
            
        } catch (ServerException ex) {
            HibernateUtil.getTransacao().rollback();
            LogUtil.logDescricaoErro(AlertaBoImpl.class, "ERRO AO SALVAR ALERTA: " + alerta.getId(), ex);
            throw ex;
        } catch (Exception exGenerica) {
            HibernateUtil.getTransacao().rollback();
            LogUtil.logDescricaoErro(AlertaBoImpl.class, "ERRO GENERICO: " + alerta.getId(), exGenerica);
            throw new ServerException(exGenerica);
        } finally {
            //FECHAR SESSAO
            HibernateUtil.getSession().close();

            //FECHA LOG
            LogUtil.logFimProcessoMetodo(AlertaBoImpl.class, "mantemAlerta");
        }
    }

    @Override
    public List<Alerta> recAlertasPorPessoa(Pessoa p) throws ServerException {
        try {
            //ABRIR SESSAO
            HibernateUtil.setSession();
            return this.dao.recAlertasPorPessoa(p);
        } catch (ServerException ex) {
            throw ex;
        } catch (Exception exGenerica) {
            throw new ServerException(exGenerica);
        } finally {
            //FECHAR SESSAO
            HibernateUtil.getSession().close();
        }
    }

    @Override
    public int recNumeroAlertaPorDia() throws ServerException {
        try {
            //Abrir Sessao
            HibernateUtil.setSession();

            //Consulta numero de alertas por dia
            int cont = this.dao.recNumeroAlertasDoDia();
            return cont;
        } catch (ServerException ex) {
            throw ex;
        } catch (Exception exGenerica) {
            throw new ServerException(exGenerica);
        } finally {
            //FECHAR SESSAO 
            HibernateUtil.getSession().close();
        }
    }

    @Override
    public List<Alerta> recListaAlertas(Alerta alerta) throws ServerException {
        try {
            //Abrir Sessao
            HibernateUtil.setSession();
            return this.dao.recListaAlerta(alerta);
        } catch (ServerException ex) {
            throw ex;
        } catch (Exception exGenerica) {
            throw new ServerException(exGenerica);
        } finally {
            //FECHAR SESSAO 
            HibernateUtil.getSession().close();
        }
    }
}
