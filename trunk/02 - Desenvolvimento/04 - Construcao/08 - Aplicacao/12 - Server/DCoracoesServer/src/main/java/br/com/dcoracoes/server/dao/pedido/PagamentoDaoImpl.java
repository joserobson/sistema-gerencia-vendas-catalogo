/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.dao.pedido;

import br.com.dcoracoes.server.dao.ModelGenericoDaoImpl;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.pedido.Pagamento;
import java.util.List;

/**
 *
 * @author Robson
 */
public class PagamentoDaoImpl extends ModelGenericoDaoImpl implements PagamentoDao<Pagamento> {

    @Override
    public void mantemPagamento(Pagamento pagamento) throws ServerException {
        this.mantemObjectGenerico(PagamentoDaoImpl.class, pagamento);
    }

    @Override
    public List<Pagamento> recPagamentos(Pagamento pagamento) throws ServerException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
