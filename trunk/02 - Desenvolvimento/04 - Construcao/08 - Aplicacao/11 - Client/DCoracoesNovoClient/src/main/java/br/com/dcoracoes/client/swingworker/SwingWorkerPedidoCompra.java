/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.swingworker;

import br.com.dcoracoes.client.classes.serverimpl.PedidoCompraServerImpl;
import br.com.dcoracoes.client.classes.serverimpl.ProdutoServerImpl;
import br.com.dcoracoes.client.telas.compra.FormCompra;
import br.com.dcoracoes.client.telas.compra.FormConsultaCompra;
import br.com.dcoracoes.client.util.LogUtil;
import br.com.dcoracoes.client.util.MensagensUtil;
import br.com.dcoracoes.client.util.message.MessageCompra;
import br.com.dcoracoes.servico.service.Pedido;
import br.com.dcoracoes.servico.service.PedidoCompra;
import br.com.dcoracoes.servico.service.Produto;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author Jose Robson
 */
public class SwingWorkerPedidoCompra<T extends PedidoCompra> extends BaseSwingWorker<T> {

    private FormCompra formCompra = null;
    private FormConsultaCompra formConsultaCompra = null;
    private Pedido pedido;
    private Produto produtoPedidoCompra;
    private int rowProduto;

    public FormCompra getFormCompra() {
        return formCompra;
    }

    public void setFormCompra(FormCompra formCompra) {
        this.formCompra = formCompra;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public FormConsultaCompra getFormConsultaCompra() {
        return formConsultaCompra;
    }

    public void setFormConsultaCompra(FormConsultaCompra formConsultaCompra) {
        this.formConsultaCompra = formConsultaCompra;
    }

    public Produto getProdutoPedidoCompra() {
        return produtoPedidoCompra;
    }

    public void setProdutoPedidoCompra(Produto produtoPedidoCompra) {
        this.produtoPedidoCompra = produtoPedidoCompra;
    }

    public int getRowProduto() {
        return rowProduto;
    }

    public void setRowProduto(int rowProduto) {
        this.rowProduto = rowProduto;
    }
    /**
     * Salvar Pedido Compra
     */
    public SwingWorker<T, Object> workSalvaPedidoCompra = new SwingWorker<T, Object>() {

        @Override
        protected T doInBackground() throws Exception {
            try {
                habilitaTelaAguarde(formCompra);
                PedidoCompraServerImpl server = new PedidoCompraServerImpl();
                return (T) server.salvarComRetorno(pedido);
            } catch (Exception ex) {
                desabilitaTelaAguarde(formCompra);
                throw ex;
            }
        }

        @Override
        protected void done() {
            try {
                desabilitaTelaAguarde(formCompra);
                if (get() != null) {
                    formCompra.setPedidoCompra((T)get());
                    formCompra.salvarComSucesso();                    
                }                
            } catch (Exception ex) {
                LogUtil.logDescricaoErro(formCompra.getClass(), ex);
                JOptionPane.showMessageDialog(formCompra, MessageCompra.ERRO_SALVAR_PEDIDO, "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    public SwingWorker<List<T>, Object> workSearchPedidos = new SwingWorker<List<T>, Object>() {

        @Override
        protected List<T> doInBackground() throws Exception {
            try {
                habilitaTelaAguarde(formConsultaCompra);
                return new PedidoCompraServerImpl<T>().recTodos(pedido);
            } catch (Exception ex) {
                throw ex;
            }
        }

        @Override
        protected void done() {
            try {
                desabilitaTelaAguarde(formConsultaCompra);
                if (get() != null) {
                    List<PedidoCompra> listPedido = (List<PedidoCompra>) get();
                    formConsultaCompra.popularTela(listPedido);
                }
                formConsultaCompra.setVisible(true);
            } catch (Exception ex) {
                LogUtil.logDescricaoErro(formConsultaCompra.getClass(), ex);
                JOptionPane.showMessageDialog(formConsultaCompra, MessageCompra.ERRO_CONSULTAR_VENDA, "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    public SwingWorker<List<Produto>, Object> workSearchProdutos = new SwingWorker<List<Produto>, Object>() {

        @Override
        protected List<Produto> doInBackground() throws Exception {
            try {
                habilitaTelaAguarde(formCompra);
                return new ProdutoServerImpl<Produto>().recProdutos(produtoPedidoCompra, false);
            } catch (Exception ex) {
                throw ex;
            }
        }

        @Override
        protected void done() {
            try {
                desabilitaTelaAguarde(formCompra);
                if (get() != null) {
                    List<Produto> listProduto = (List<Produto>) get();
                    formCompra.returnListProduto(listProduto, rowProduto);
                }
            } catch (Exception ex) {
                LogUtil.logDescricaoErro(formCompra.getClass(), ex);
                JOptionPane.showMessageDialog(formCompra, MessageCompra.ERRO_CONSULTAR_PRODUTO, MensagensUtil.ERRO, JOptionPane.ERROR_MESSAGE);
            }
        }
    };
}
