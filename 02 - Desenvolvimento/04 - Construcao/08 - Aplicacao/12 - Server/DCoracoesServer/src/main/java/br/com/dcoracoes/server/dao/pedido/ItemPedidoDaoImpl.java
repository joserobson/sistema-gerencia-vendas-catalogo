/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.dao.pedido;

import br.com.dcoracoes.server.dao.ModelGenericoDaoImpl;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.pedido.ItemPedido;

/**
 *
 * @author Robson
 */
public class ItemPedidoDaoImpl<T extends ItemPedido> extends ModelGenericoDaoImpl implements ItemPedidoDao<T> {

    @Override
    public void mantemItemPedido(T itemPedido) throws ServerException {
        this.mantemObjectGenerico(ItemPedido.class, itemPedido);
    }

    @Override
    public void removeItemPedido(T itemPedido) throws ServerException {
        this.deleteObject(itemPedido);
    }
}
