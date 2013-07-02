/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.bo.pedido;

import br.com.dcoracoes.server.dao.pedido.PedidoDao;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.cadastro.Revendedor;
import br.com.dcoracoes.server.model.pedido.Pedido;
import br.com.dcoracoes.server.model.pedido.PedidoVenda;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Robson
 */
public interface PedidoBo <T extends Pedido>{
    
    public void setPedidoDao(PedidoDao dao);
    
    public void mantemPedido(T pedido) throws ServerException;
    
    public List<T> recPedidos(T pedido) throws ServerException;
    
    public void removePedido(T pedido) throws ServerException;
    
    public int recMaxCodigoPedido() throws ServerException;
    
    public PedidoVenda recUltimoPedidoVenda(Revendedor rev) throws ServerException;
    
    public List recRelatorioPedidosPorRevendedor(HashMap<String, Object> parameter) throws ServerException;
}
