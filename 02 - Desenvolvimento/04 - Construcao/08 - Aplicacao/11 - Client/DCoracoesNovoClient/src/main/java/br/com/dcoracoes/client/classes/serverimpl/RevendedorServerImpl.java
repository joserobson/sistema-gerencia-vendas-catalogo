/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.classes.serverimpl;

import br.com.dcoracoes.client.Excecao.ClientDCoracoesException;
import br.com.dcoracoes.servico.service.*;
import java.lang.Exception;
import java.util.List;

/**
 *
 * @author Robson
 */
public class RevendedorServerImpl<T extends Revendedor> extends BaseServerImpl<T> implements IRevendedorImpl<T> {

    @Override
    public List recRevendedorEtiqueta(ModelGerarEtiqueta parameter) throws ClientDCoracoesException {
        List<Pessoa> pessoas = null;

        try {
            pessoas = this.port.recRevendedorEtiqueta(parameter);
        } catch (Exception ex) {
            throw new ClientDCoracoesException(ex);
        }
        return pessoas;
    }
    
    @Override
    public List recTodos(Object param) throws ClientDCoracoesException {
        List<ViewRevendedor> viewRevendedores = null;

        try {
            viewRevendedores = this.port.recListaViewRevendedor((T)param);
        } catch (Exception ex) {
            throw new ClientDCoracoesException(ex);
        }
        return viewRevendedores;
    }
    
    @Override
    public ViewRevendedor recUltimoRevendedorCadastro() throws ClientDCoracoesException {
        ViewRevendedor viewRevendedor = null;

        try {
            viewRevendedor = this.port.recUltimoRevendedorCadastro();
            //busca data ultima venda do revendedor
            PedidoVenda pedidoVenda = this.port.recUltimoPedidoVenda(viewRevendedor.getRevendedor());
            if(pedidoVenda != null)
                viewRevendedor.getRevendedor().setDataUltimaCompra(pedidoVenda.getDataPedido());  
        } catch (Exception ex) {
            throw new ClientDCoracoesException(ex);
        }
        return viewRevendedor;
    }
    
    @Override
    public Object salvarComRetorno(Object param) throws ClientDCoracoesException {
        try {
            return this.port.salvarRevendedorComRetorno((ViewRevendedor) param);
        } catch (Exception ex) {
            throw new ClientDCoracoesException(ex);
        }
    }
    
    
    /**
     * RECUPERA CODIGO SEQUENCIAL PARA REVENDEDOR
     * @return
     * @throws Exception
     */
    @Override
    public int recCodigoSequencia() throws ClientDCoracoesException {
        try {
            return this.port.recCodigoSequencia();
        } catch (Exception ex) {
            throw new ClientDCoracoesException(ex);
        }
    }
    
    /**
     * Busca CPF
     * @param pessoa
     * @return
     * @throws TransException 
     */
    public String validaCPF(PessoaFisica pessoa) throws ClientDCoracoesException {
        String retorno = null;
        try {
            retorno = this.port.validaCPF(pessoa);                        
        } catch (Exception ex) {            
            throw new ClientDCoracoesException(ex);
        }
        return retorno;
    }
    
    /**
     * Metodo para recuperar o último pedido do revendedor
     * @param rev
     * @return
     * @throws TransException 
     */
    public PedidoVenda recUltimoPedidoVenda(Revendedor rev) throws ClientDCoracoesException {
        PedidoVenda pedidoVenda = null;
        try {
            pedidoVenda = this.port.recUltimoPedidoVenda(rev); 
        } catch (Exception ex) {
            throw new ClientDCoracoesException(ex);
        }
        return pedidoVenda;
    }

    @Override
    public List<Parcela> recHistoricoParcelas(Revendedor param) throws ClientDCoracoesException {
        List<Parcela> lst = null;

        try {
            lst = this.port.recHistoricoParcelas((Revendedor)param);
        } catch (Exception ex) {
            throw new ClientDCoracoesException(ex);
        }
        return lst;
    }
        
}
