/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.dao.pedido;

import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.pedido.CodigoItem;

/**
 *
 * @author Robson
 */
public interface CodigoItemDao<T extends CodigoItem> {

    public void mantemCodigoItem(T codigoItem) throws ServerException;
}
