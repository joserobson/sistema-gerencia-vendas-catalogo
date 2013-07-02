/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.dao.pedido;

import br.com.dcoracoes.server.dao.ModelGenericoDaoImpl;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.pedido.CodigoItem;

/**
 *
 * @author Robson
 */
public class CodigoItemDaoImpl extends ModelGenericoDaoImpl implements CodigoItemDao<CodigoItem> {

    @Override
    public void mantemCodigoItem(CodigoItem codigoItem) throws ServerException {
        this.mantemObjectGenerico(CodigoItem.class, codigoItem);
    }
}
