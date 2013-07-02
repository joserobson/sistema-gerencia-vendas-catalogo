/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.bo.produto;

import br.com.dcoracoes.server.dao.produto.CorDaoImpl;
import br.com.dcoracoes.server.dao.produto.ItemProdutoDao;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.produto.Cor;
import br.com.dcoracoes.server.model.produto.ItemProduto;
import br.com.dcoracoes.server.util.HibernateUtil;
import br.com.dcoracoes.server.util.LogUtil;

/**
 *
 * @author Robson
 */
public class ItemProdutoBoImpl implements ItemProdutoBo {

    private ItemProdutoDao itemProdutoDao;

    @Override
    public void setItemProdutoDao(ItemProdutoDao dao) {
        this.itemProdutoDao = dao;
    }

    @Override
    public void mantemItemProduto(ItemProduto itemProduto) throws ServerException {
        this.itemProdutoDao.mantemItemProduto(itemProduto);
    }

    @Override
    public ItemProduto removeItemProduto(ItemProduto itemProduto) throws ServerException {
        ItemProduto retorno = null;
        try {
            //Abrir Log
            LogUtil.logInicioProcessoMetodo(ItemProduto.class, "removeItemProduto");

            //Abrir Sessao
            HibernateUtil.setSession();

            //Abrir transacao
            HibernateUtil.setTransacao();
                        
            //remove itemproduto
            retorno = this.itemProdutoDao.removeItemProduto(itemProduto);
            
            //remover Cor de ItemProduto
            this.removerCor(itemProduto.getCor());

            //Log
            LogUtil.logSucesso(ItemProduto.class, "removeItemProduto", itemProduto.getId());

            //Commit Transacao
            HibernateUtil.getTransacao().commit();

        } catch (ServerException ex) {
            HibernateUtil.getTransacao().rollback();
            LogUtil.logDescricaoErro(ItemProduto.class, "ERRO AO REMOVER Item PRODUTO", ex);
            throw ex;
        } catch (Exception exGenerica) {
            HibernateUtil.getTransacao().rollback();
            LogUtil.logDescricaoErro(ItemProduto.class, "ERRO AO REMOVER ITEM PRODUTO", exGenerica);
            throw new ServerException(exGenerica);
        } finally {
            //fechar Sessao
            HibernateUtil.getSession().close();

            //FECHA LOG
            LogUtil.logFimProcessoMetodo(ItemProduto.class, "removeItemProduto");
        }

        return retorno;
    }

    /**
     * 
     * @param cor 
     */
    private void removerCor(Cor cor) throws ServerException {
        try {
            CorBoImpl corBo = new CorBoImpl();
            CorDaoImpl corDao = new CorDaoImpl();
            corBo.setCorDao(corDao);
            corBo.removerCor(cor);
        } catch (ServerException ex) {
            throw ex;
        }
    }

    @Override
    public ItemProduto recItemProdutoPorId(long id) throws ServerException {
        return this.itemProdutoDao.recProdutoPorId(id);
    }
}
