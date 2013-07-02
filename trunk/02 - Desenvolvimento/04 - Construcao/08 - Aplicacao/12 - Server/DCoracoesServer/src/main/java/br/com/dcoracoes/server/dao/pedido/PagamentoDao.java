/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.dao.pedido;

import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.pedido.Pagamento;
import java.util.List;

/**
 *
 * @author Robson
 */
public interface PagamentoDao <T extends Pagamento> {
    
    public void mantemPagamento(T pagamento) throws ServerException;
    
    public List<T> recPagamentos(T pagamento) throws ServerException;
    
}
