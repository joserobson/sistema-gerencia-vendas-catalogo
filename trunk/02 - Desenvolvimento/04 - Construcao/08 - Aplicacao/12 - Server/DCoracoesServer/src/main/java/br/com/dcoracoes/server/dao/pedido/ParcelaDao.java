/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.dao.pedido;

import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.pedido.Parcela;
import java.util.List;

/**
 *
 * @author Robson
 */
public interface ParcelaDao<T extends Parcela> {

    public void mantemParcela(T parcela) throws ServerException;

    public void removeParcela(T parcela) throws ServerException;
    
    public List<T> recParcelasALiberar(long idRevendedor) throws ServerException;
}
