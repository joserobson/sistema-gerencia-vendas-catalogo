/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.servico.service;

import br.com.dcoracoes.servico.beans.cadastro.Revendedor;
import br.com.dcoracoes.servico.beans.pedido.Pedido;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Jose Robson
 */
public interface IServicePedido <T extends Pedido>{

    public String recCodigoOrcamento() throws Exception;

    public boolean aprovarPedido(T pedido) throws Exception;
    
    public List<T> recRelatorioPedidosPorRevendedor(HashMap<String, Object> parameter) throws Exception;
    
    public List recHistoricoParcelas(Revendedor param) throws Exception;
}
