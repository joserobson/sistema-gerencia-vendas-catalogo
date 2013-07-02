/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.dao.produto;

import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.produto.ItemProduto;


/**
 *
 * @author Robson
 */
public interface ItemProdutoDao<T extends ItemProduto> {
    
    public void mantemItemProduto(T itemProduto) throws ServerException;
    
    public T removeItemProduto(T itemProduto) throws ServerException;
    
    public T recProdutoPorId(long id) throws ServerException;
    
}
