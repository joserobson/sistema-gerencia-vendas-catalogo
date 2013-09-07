/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.classes.serverimpl;

import br.com.dcoracoes.client.Excecao.ClientDCoracoesException;
import br.com.dcoracoes.servico.service.*;
import java.lang.Exception;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Robson
 */
public class RevendedorServerImpl<T extends Revendedor> extends BaseServerImpl<T> implements IRevendedorImpl<T> {

    @Override
    public List recRevendedorEtiqueta(HashMap<String, Object> parameter) throws ClientDCoracoesException {
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
        ViewRevendedor viewRevendedore = null;

        try {
            viewRevendedore = this.port.recUltimoRevendedorCadastro();
        } catch (Exception ex) {
            throw new ClientDCoracoesException(ex);
        }
        return viewRevendedore;
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
    
    
    
//    /**
//     * METODO PARA CHAMAR CLASSE DO SERVER PARA SALVAR REVENDEDOR
//     * @param viewRevendedor
//     * @throws Exception
//     */
//    public ViewRevendedor salvarRevendedor(ViewRevendedor viewRevendedor) throws TransException {
//        try {
//            TnRevendedor tn = new TnRevendedor();
//            tn.setViewRevendedor(viewRevendedor);
//            tn.salvar(ConstanteTnRevendedor.NOME_EVENTO_SALVAR_REVENDEDOR);
//            return tn.getViewRevendedor();
//        } catch (TransException ex) {
//            throw ex;
//        }
//    }
//
//    /**
//     * RECUPERA ULTIMO REVENDEDOR CADASTRADO NO SISTEMA
//     * @return
//     * @throws TransacaoException
//     */
//    public ViewRevendedor recUltimoRevendedorCadastro() throws TransException {
//        try {
//            TnRevendedor tn = new TnRevendedor();
//            tn.recUltimoRevendedorCadastrado();
//            return tn.getViewRevendedor();
//        } catch (TransException ex) {
//            throw ex;
//        }
//    }

//
//    /**
//     * RECUPERA LISTA DE VIEW REVENDEDOR DE ACORDO COM O PARAMETRO
//     * METODO MONTA CONSULTA DINAMICAMENTE
//     * @return
//     * @throws Exception 
//     */
//    public List<ViewRevendedor> recListaViewRevendedor(Revendedor pRevendedor) throws TransException {
//        List<ViewRevendedor> retListaViewRevendedor = null;
//        try {
//            TnRevendedor tn = new TnRevendedor();
//            retListaViewRevendedor = tn.recListaViewRevendedor(pRevendedor);
//        } catch (TransException ex) {
//            throw ex;
//        }
//
//        return retListaViewRevendedor;
//    }
//
    
//
//    
//    
//    /**
//     * Metodo para gerar lista de revendedoras para criação de etiquetas
//     * @param parameter
//     * @return 
//     */
//    public List<Pessoa> recRevendedorEtiqueta(HashMap<String, Object> parameter) throws TransException {
//        try{
//            TnRevendedor tn = new TnRevendedor();
//            return tn.recRevendedorEtiqueta(parameter);
//        } catch (TransException ex){
//            throw ex;
//        }
//    }
//    
//    /**
//     * recupera pessoa pelo id
//     * @param id
//     * @return
//     * @throws TransException 
//     */
//    public Pessoa recPessoaPorId(Long id) throws TransException {
//        Pessoa retorno = null;
//        try {
//            TnRevendedor tn = new TnRevendedor();
//            retorno = tn.recPessoaPorId(id);                           
//        } catch (TransException ex) {
//            throw ex;
//        }
//        return retorno;
//    }

    
}
