/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.classes.serverimpl;

import br.com.dcoracoes.client.Excecao.ClientDCoracoesException;
import br.com.dcoracoes.servico.service.PedidoVenda;

/**
 *
 * @author Jose Robson
 */
public class PedidoVendaServerImpl <T extends PedidoVenda> extends PedidoServerImpl<T> implements IPedidoVendaServerImpl<T> {

    @Override
    public Object salvarComRetorno(Object param) throws ClientDCoracoesException {
        try{
            return this.port.salvarPedidoVendaComRetorno((T)param);            
        }catch(Exception ex){
            throw new ClientDCoracoesException(ex);
        }
    }
    
}
