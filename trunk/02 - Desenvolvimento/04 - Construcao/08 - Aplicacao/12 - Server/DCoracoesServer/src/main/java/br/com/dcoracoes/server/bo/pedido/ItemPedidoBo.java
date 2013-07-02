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
public interface ItemPedidoBo<T extends ItemPedido> {

    public void setItemPedidoDao(ItemPedidoDao dao);

    public void mantemItemPedido(T itemPedido) throws ServerException;

    public void removeItemPedido(T itemPedido) throws ServerException;
}
