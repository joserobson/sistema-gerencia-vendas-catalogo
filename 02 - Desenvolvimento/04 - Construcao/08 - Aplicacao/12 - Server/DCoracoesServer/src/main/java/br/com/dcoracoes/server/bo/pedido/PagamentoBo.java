/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.bo.pedido;

import br.com.dcoracoes.server.dao.pedido.PagamentoDao;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.cadastro.Revendedor;
import br.com.dcoracoes.server.model.pedido.Pagamento;
import java.util.List;

/**
 *
 * @author Robson
 */
public interface PagamentoBo  <T extends Pagamento> {
    
    public void setPagamentoDao(PagamentoDao dao);
    
    public void mantemPagamento(T pagamento) throws ServerException;
           
    public List<T> recPagamentos(T pagamento) throws ServerException;
}
