/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.bo.pedido;

import br.com.dcoracoes.server.dao.pedido.ParcelaDao;
import br.com.dcoracoes.server.enuns.Enum_Situacao_Parcela;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.pedido.Parcela;
import br.com.dcoracoes.server.util.HibernateUtil;
import br.com.dcoracoes.server.util.LogUtil;
import java.util.List;

/**
 *
 * @author Robson
 */
public class ParcelaBoImpl<T extends Parcela> implements ParcelaBo<T> {
    
    private ParcelaDao dao;
    
    @Override
    public void setParcelaDao(ParcelaDao dao) {
        this.dao = dao;
    }
    
    @Override
    public void mantemParcela(T parcela) throws ServerException {
        //Log
        LogUtil.logInicioProcessoMetodo(Parcela.class, "mantemParcela");
        try {
            this.dao.mantemParcela(parcela);
            //Log
            LogUtil.logInicioProcessoMetodo(Parcela.class, "mantemParcela");
        } catch (ServerException ex) {
            throw new ServerException("ERRO AO SALVAR PARCELA", ex);
        } catch (Exception exGenerica) {
            throw new ServerException("ERRO AO SALVAR PARCELA", exGenerica);
        } finally {
            LogUtil.logFimProcessoMetodo(Parcela.class, "mantemParcela");
        }
    }
    
    @Override
    public void removeParcela(T parcela) throws ServerException {
        this.removeParcela(parcela);
    }
    
    @Override
    public List<T> recParcelasALiberar(long idRevendedor) throws ServerException {
        List<T> listaParcelas = null;
        try {
            //LOG
            LogUtil.logInicioProcessoMetodo(Parcela.class, "recParcelasALiberar");

            //Abrir Sessao
            HibernateUtil.setSession();

            //chamada do metodo dao
            listaParcelas = this.dao.recParcelasALiberar(idRevendedor);

            //Log
            LogUtil.logSucesso(Parcela.class, "recParcelasALiberar");
            
            
        } catch (ServerException ex) {
            //LOG
            LogUtil.logDescricaoErro(Parcela.class, "ERRO AO CONSULTAR PARCELAS A LIBERAR", ex);
            throw ex;
        } catch (Exception exGenerica) {
            //LOG
            LogUtil.logDescricaoErro(Parcela.class, "ERRO AO CONSULTAR PARCELAS A LIBERAR", exGenerica);
            throw new ServerException(exGenerica);
        } finally {

            //Fechar Sessao
            HibernateUtil.getSession().close();

            //Log
            LogUtil.logFimProcessoMetodo(Parcela.class, "recParcelasALiberar");
        }
        
        return listaParcelas;
    }
    
    @Override
    public void quitarParcelas(List<T> lstParcelas) throws ServerException {
        //ABRIR LOG
        LogUtil.logInicioProcessoMetodo(ParcelaBoImpl.class, "quitarParcelas");
        
        try {
            //ABRIR SESSAO
            HibernateUtil.setSession();

            //ABRIR TRANSACAO
            HibernateUtil.setTransacao();

            //PERCORRER A LISTA DE PARCELAS E ATUALIZANDO STATUS PARA QUITADO
            for (Parcela parcela : lstParcelas) {
                parcela.setStatus(Enum_Situacao_Parcela.QUITADA.getCodigo());
                this.dao.mantemParcela(parcela);
            }

            //COMMIT NA TRANSACAO
            HibernateUtil.getTransacao().commit();

            //LOG SUCESSO
            LogUtil.logSucesso(ParcelaBoImpl.class, "quitarParcelas");
            
        } catch (ServerException ex) {
            HibernateUtil.getTransacao().rollback();
            LogUtil.logDescricaoErro(ParcelaBoImpl.class, "ERRO AO QUITAR LISTA PARCELAS", ex);
            throw ex;
        } catch (Exception exGenerica) {
            HibernateUtil.getTransacao().rollback();
            throw new ServerException(exGenerica);
        } finally {
            //FECHAR SESSAO
            HibernateUtil.getSession().close();

            //FECHA LOG
            LogUtil.logFimProcessoMetodo(ParcelaBoImpl.class, "quitarParcelas");
        }
    }
}
