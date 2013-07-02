/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.classes.serverimpl;

/**
 *
 * @author Robson
 */
public class RevendedorServerImpl {

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
//     * RECUPERA CODIGO SEQUENCIAL PARA REVENDEDOR
//     * @return
//     * @throws Exception
//     */
//    public int recCodigoSequencia() throws TransException {
//        try {
//            TnRevendedor tn = new TnRevendedor();
//            return tn.recCodigoSequencial();
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
//    /**
//     * Busca CPF
//     * @param pessoa
//     * @return
//     * @throws TransException 
//     */
//    public String validaCPF(Pessoa pessoa) throws TransException {
//        String retorno = null;
//        try {
//            TnRevendedor tn = new TnRevendedor();
//            retorno = tn.validaCPF(pessoa);                        
//        } catch (TransException ex) {
//            throw ex;
//        }
//        return retorno;
//    }
//
//    /**
//     * Metodo para recuperar o último pedido do revendedor
//     * @param rev
//     * @return
//     * @throws TransException 
//     */
//    public PedidoVenda recUltimoPedidoVenda(Revendedor rev) throws TransException {
//        try {
//            TnRevendedor tn = new TnRevendedor();
//            ViewRevendedor view = new ViewRevendedor();
//            view.setRevendedor(rev);
//            tn.setViewRevendedor(view);
//            return tn.recUltimoPedidoVenda();
//        } catch (TransException ex) {
//            throw ex;
//        }
//    }
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
