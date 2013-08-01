/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.classes.serverimpl;

import br.com.dcoracoes.client.Excecao.ClientDCoracoesException;
import br.com.dcoracoes.servico.service.PedidoCompra;

/**
 *
 * @author Jose Robson
 */
public class PedidoCompraServerImpl <T extends PedidoCompra> extends PedidoServerImpl<T> implements IPedidoCompraImpl{

    /**
     * METODO PARA SALVAR PEDIDO COMPRA
     * @param Pedido
     * @return
     * @throws TransException 
     */
    @Override
    public Object salvarComRetorno(Object param) throws ClientDCoracoesException {
        try{
            return this.port.salvarPedidoCompraComRetorno((T)param);            
        }catch(Exception ex){
            throw new ClientDCoracoesException(ex);
        }
    }  
       

    
}
