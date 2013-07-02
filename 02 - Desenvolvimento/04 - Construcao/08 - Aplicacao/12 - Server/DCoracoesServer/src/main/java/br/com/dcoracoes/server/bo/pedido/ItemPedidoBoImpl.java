/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.bo.pedido;

import br.com.dcoracoes.server.dao.pedido.ItemPedidoDao;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.pedido.ItemPedido;

/**
 *
 * @author Robson
 */
public class ItemPedidoBoImpl<T extends ItemPedido> implements ItemPedidoBo<T> {
    
    private ItemPedidoDao itemPedidoDao;
    
    @Override
    public void setItemPedidoDao(ItemPedidoDao dao) {
        this.itemPedidoDao = dao;
    }
    
    @Override
    public void mantemItemPedido(T itemPedido) throws ServerException {
        this.itemPedidoDao.mantemItemPedido(itemPedido);
    }
    
    @Override
    public void removeItemPedido(T itemPedido) throws ServerException {
        this.removeItemPedido(itemPedido);
    }
}
