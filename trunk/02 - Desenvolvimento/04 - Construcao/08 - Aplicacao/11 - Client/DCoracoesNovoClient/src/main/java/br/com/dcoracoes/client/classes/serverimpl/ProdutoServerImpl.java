/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.classes.serverimpl;

import br.com.dcoracoes.client.Excecao.ClientDCoracoesException;
import br.com.dcoracoes.servico.service.ItemProduto;
import br.com.dcoracoes.servico.service.Produto;
import java.util.List;

/**
 *
 * @author Robson
 */
public class ProdutoServerImpl<T extends Produto> extends BaseServerImpl<T> implements IProdutoServerImpl<T> {

    /**
     * 
     * @param param
     * @return
     * @throws ClientDCoracoesException 
     */
    @Override
    public Object salvarComRetorno(Object param) throws ClientDCoracoesException {
        try {
            return this.port.salvarProdutoComRetorno((Produto) param);            
        } catch (Exception ex) {
            throw new ClientDCoracoesException(ex);
        }
    }
    
     /**
     * METODO PARA REMOVER UM ITEM DE UM PRODUTO
     * @param cor
     * @throws TransException 
     */
    @Override
    public void deleteItemProduto(ItemProduto itemProduto) throws ClientDCoracoesException {
        try {
            this.port.removeItemProduto(itemProduto);
        } catch (Exception ex) {
            throw new ClientDCoracoesException(ex);
        }
    }

    /**
     * METODO PARA REMOVER PRODUTO
     * @param cor
     * @throws TransException 
     */    
    @Override
    public Object deletar(Object param) throws ClientDCoracoesException {
        try {
            this.port.removeProduto((T)param);
            return null;
        } catch (Exception ex) {
            throw new ClientDCoracoesException(ex);
        }
    }
     
    
    
     /**
     * RECUPERA LISTA DE PRODUTO DE ACORDO COM O PARAMETRO
     * @param produto
     * @return
     * @throws TransException 
     */
    @Override
    public List<T> recProdutos(Produto produto, boolean useLike) throws ClientDCoracoesException {
        List<T> listaRetorno = null;
        try {            
            listaRetorno = (List<T>)this.port.recProdutos(produto, useLike);
        } catch (Exception ex) {
            throw new ClientDCoracoesException(ex);
        }
        return listaRetorno;
    }
    
//    /**
//     * METODO PARA SALVAR PRODUTO
//     * @param produto
//     * @return
//     * @throws TransException 
//     */
//    public Produto salvarProduto(Produto produto) throws TransException {
//        try {
//            TnProduto tn = new TnProduto();
//            tn.setProduto(produto);
//            tn.salvar(ConstanteTnProduto.NOME_EVENTO_SALVAR_PRODUTO);
//            return tn.getProduto();
//        } catch (TransException ex) {
//            throw ex;
//        }
//    }
//
//    /**
//     * RECUPERA LISTA DE PRODUTO DE ACORDO COM O PARAMETRO
//     * @param produto
//     * @return
//     * @throws TransException 
//     */
//    public List<Produto> recProdutos(Produto produto, boolean useLike) throws TransException {
//        List<Produto> listaRetorno = null;
//        try {
//            TnProduto tn = new TnProduto();
//            listaRetorno = tn.recProdutos(produto, useLike);
//        } catch (TransException ex) {
//            throw ex;
//        }
//
//        return listaRetorno;
//    }
//
//    /**
//     * METODO PARA REMOVER UM ITEM DE UM PRODUTO
//     * @param cor
//     * @throws TransException 
//     */
//    public void removeItemProduto(ItemProduto itemProduto) throws TransException {
//        try {
//            TnProduto tn = new TnProduto();
//            tn.removeItemProduto(itemProduto);
//
//        } catch (TransException ex) {
//            throw ex;
//        }
//    }
//    
//    /**
//     * METODO PARA REMOVER PRODUTO
//     * @param cor
//     * @throws TransException 
//     */
//    public void removeProduto(Produto produto) throws TransException {
//        try {
//            TnProduto tn = new TnProduto();
//            tn.setProduto(produto);
//            tn.deletar(ConstanteTnProduto.NOME_EVENTO_EXCLUIR_PRODUTO);
//
//        } catch (TransException ex) {
//            throw ex;
//        }
//    }
}
