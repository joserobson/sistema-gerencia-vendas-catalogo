    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.classes.serverimpl;

/**
 *
 * @author Robson
 */
public class PedidoServerImpl {

//    /**
//     * METODO PARA SALVAR PEDIDO VENDA
//     * @param Pedido
//     * @return
//     * @throws TransException 
//     */
//    public PedidoVenda salvarPedidoVenda(PedidoVenda pedido) throws TransException {
//        try {
//            TnPedido tn = new TnPedido();
//            tn.setPedido(pedido);
//            tn.salvar(ConstanteTnPedido.NOME_EVENTO_SALVAR_PEDIDO);
//            return (PedidoVenda) tn.getPedido();
//        } catch (TransException ex) {
//            throw ex;
//        }
//    }
//
//    /**
//     * RECUPERA LISTA DE PEDIDO DE ACORDO COM O PARAMETRO
//     * @param Pedido
//     * @return
//     * @throws TransException 
//     */
//    public List<PedidoVenda> recPedidosVenda(PedidoVenda pedido) throws TransException {
//        List<PedidoVenda> listaRetorno = null;
//        try {
//            TnPedido tn = new TnPedido();
//            listaRetorno = tn.recPedidosVenda(pedido);
//        } catch (TransException ex) {
//            throw ex;
//        }
//
//        return listaRetorno;
//    }
//
//    /**
//     * RECUPERAR CODIGO SEGUENCIAL PARA ORCAMENTO
//     * @return
//     * @throws TransException 
//     */
//    public String recCodigoOrcamento() throws TransException {
//        String codigoRetorno = null;
//        try {
//            TnPedido tn = new TnPedido();
//            codigoRetorno = tn.recCodigoOrcamento();
//
//        } catch (TransException ex) {
//            throw ex;
//        }
//        return codigoRetorno;
//    }
//
//    /**
//     * REMOVE PEDIDO PASSADO NO PARAMETRO
//     * @param pedido
//     * @return
//     * @throws TransException 
//     */
//    public Pedido removePedido(Pedido pedido) throws TransException {
//        try {
//            TnPedido tn = new TnPedido(pedido);
//            tn.deletar(ConstanteTnPedido.NOME_EVENTO_DELETAR_PEDIDO);
//            return tn.getPedido();
//        } catch (TransException ex) {
//            throw ex;
//        }
//    }
//
//    /**
//     * Metodo para aprovar o pedido
//     * Atributos necessários: 
//     * Pagamento.getFormaPagamento
//     * Revendedor
//     * pedido.valorpedidoEscrito
//     * @param pedido
//     * @return
//     * @throws TransException 
//     */
//    public boolean aprovarPedido(Pedido pedido) throws TransException {
//        try {
//            TnPedido tn = new TnPedido(pedido);
//            return tn.aprovarPedido(ConstanteTnPedido.NOME_EVENTO_APROVAR_PEDIDO);
//        } catch (TransException ex) {
//            throw ex;
//        }
//    }
//
//    /**
//     * METODO PARA SALVAR PEDIDO COMPRA
//     * @param Pedido
//     * @return
//     * @throws TransException 
//     */
//    public PedidoCompra salvarPedidoCompra(PedidoCompra pedido) throws TransException {
//        try {
//            TnPedido tn = new TnPedido();
//            tn.setPedido(pedido);
//            tn.salvar(ConstanteTnPedido.NOME_EVENTO_SALVAR_PEDIDO);
//            return (PedidoCompra) tn.getPedido();
//        } catch (TransException ex) {
//            throw ex;
//        }
//    }
//
//    /**
//     * RECUPERA LISTA DE PEDIDOS COMPRA DE ACORDO COM O PARAMETRO
//     * @param Pedido
//     * @return
//     * @throws TransException 
//     */
//    public List<PedidoCompra> recPedidosCompra(PedidoCompra pedido) throws TransException {
//        List<PedidoCompra> listaRetorno = null;
//        try {
//            TnPedido tn = new TnPedido();
//            listaRetorno = tn.recPedidosCompra(pedido);
//        } catch (TransException ex) {
//            throw ex;
//        }
//
//        return listaRetorno;
//    }
//    
//    /**
//     * RECUPERA LISTA DE VENDA POR REVENDEDOR PARA OS PARAMETROS PASSADOS
//     * @param HashMap
//     * @return
//     * @throws TransException 
//     */
//    public List recRelatorioPedidosPorRevendedor(HashMap<String, Object> parameter) throws TransException {
//        List listaRetorno = null;
//        try {
//            TnPedido tn = new TnPedido();
//            listaRetorno = tn.recRelatorioPedidosPorRevendedor(parameter);
//        } catch (TransException ex) {
//            throw ex;
//        }
//
//        return listaRetorno;
//    }
}
