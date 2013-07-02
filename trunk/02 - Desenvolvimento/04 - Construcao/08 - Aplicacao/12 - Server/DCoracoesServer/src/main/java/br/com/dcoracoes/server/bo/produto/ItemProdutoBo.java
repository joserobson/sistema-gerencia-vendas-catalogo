/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.bo.produto;

import br.com.dcoracoes.server.dao.produto.ItemProdutoDao;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.produto.ItemProduto;

/**
 *
 * @author Robson
 */
public interface ItemProdutoBo<T extends ItemProduto> {

    public void setItemProdutoDao(ItemProdutoDao dao);

    public void mantemItemProduto(T itemProduto) throws ServerException;
    
    public T removeItemProduto(T itemProduto) throws ServerException;
    
    public T recItemProdutoPorId(long id) throws ServerException;
}
