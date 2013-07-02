/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.bo.pedido;

import br.com.dcoracoes.server.dao.pedido.CodigoItemDao;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.pedido.CodigoItem;

/**
 *
 * @author Robson
 */
public class CodigoItemBoImpl <T extends CodigoItem> implements CodigoItemBo<T> {

    private CodigoItemDao codigoItemDao;
    
    @Override
    public void setDao(CodigoItemDao dao) {
        this.codigoItemDao = dao;
    }

    @Override
    public void mantemCodigoItem(T codigoItem) throws ServerException {
        this.codigoItemDao.mantemCodigoItem(codigoItem);
    }
    
}
