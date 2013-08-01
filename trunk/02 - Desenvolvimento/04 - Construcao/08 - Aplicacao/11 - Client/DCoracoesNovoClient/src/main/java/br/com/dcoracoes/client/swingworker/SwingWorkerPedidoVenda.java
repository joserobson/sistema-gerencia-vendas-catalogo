/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.swingworker;

import br.com.dcoracoes.client.classes.serverimpl.PedidoCompraServerImpl;
import br.com.dcoracoes.client.classes.serverimpl.PedidoVendaServerImpl;
import br.com.dcoracoes.client.classes.serverimpl.ProdutoServerImpl;
import br.com.dcoracoes.client.telas.venda.FormConsultaVenda;
import br.com.dcoracoes.client.telas.venda.FormVenda;
import br.com.dcoracoes.client.util.LogUtil;
import br.com.dcoracoes.client.util.MensagensUtil;
import br.com.dcoracoes.client.util.message.MessageCompra;
import br.com.dcoracoes.servico.service.Pedido;
import br.com.dcoracoes.servico.service.PedidoVenda;
import br.com.dcoracoes.servico.service.Produto;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author Jose Robson
 */
public class SwingWorkerPedidoVenda<T extends PedidoVenda> extends BaseSwingWorker<T> {

    private FormVenda formVenda = null;
    private FormConsultaVenda formConsultaVenda = null;
    private Pedido pedido;
    private Produto produtoPedidoVenda;
    private int rowProduto;
    private String corProduto;
    private int quantidadeProduto;

    public FormConsultaVenda getFormConsultaVenda() {
        return formConsultaVenda;
    }

    public void setFormConsultaVenda(FormConsultaVenda formConsultaVenda) {
        this.formConsultaVenda = formConsultaVenda;
    }

    public FormVenda getFormVenda() {
        return formVenda;
    }

    public void setFormVenda(FormVenda formVenda) {
        this.formVenda = formVenda;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProdutoPedidoVenda() {
        return produtoPedidoVenda;
    }

    public void setProdutoPedidoVenda(Produto produtoPedidoVenda) {
        this.produtoPedidoVenda = produtoPedidoVenda;
    }

    public int getRowProduto() {
        return rowProduto;
    }

    public void setRowProduto(int rowProduto) {
        this.rowProduto = rowProduto;
    }

    public String getCorProduto() {
        return corProduto;
    }

    public void setCorProduto(String corProduto) {
        this.corProduto = corProduto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }
    /**
     * Salvar Pedido Compra
     */
    public SwingWorker<T, Object> workSalvaPedidoVenda = new SwingWorker<T, Object>() {

        @Override
        protected T doInBackground() throws Exception {
            try {
                habilitaTelaAguarde(formVenda);
                PedidoVendaServerImpl server = new PedidoVendaServerImpl();
                return (T) server.salvarComRetorno(pedido);
            } catch (Exception ex) {
                desabilitaTelaAguarde(formVenda);
                throw ex;
            }
        }

        @Override
        protected void done() {
            try {
                desabilitaTelaAguarde(formVenda);
                if (get() != null) {
                    formVenda.setPedido((T) get());
                    formVenda.salvarComSucesso();
                }
            } catch (Exception ex) {
                LogUtil.logDescricaoErro(formVenda.getClass(), ex);
                JOptionPane.showMessageDialog(formVenda, MessageCompra.ERRO_SALVAR_PEDIDO, "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    public SwingWorker<List<Produto>, Object> workSearchProdutos = new SwingWorker<List<Produto>, Object>() {

        @Override
        protected List<Produto> doInBackground() throws Exception {
            try {
                habilitaTelaAguarde(formVenda);
                return new ProdutoServerImpl<Produto>().recProdutos(produtoPedidoVenda, false);
            } catch (Exception ex) {
                throw ex;
            }
        }

        @Override
        protected void done() {
            try {
                desabilitaTelaAguarde(formVenda);
                if (get() != null) {
                    List<Produto> listProduto = (List<Produto>) get();
                    formVenda.returnListProduto(listProduto, rowProduto);
                }
            } catch (Exception ex) {
                LogUtil.logDescricaoErro(formVenda.getClass(), ex);
                JOptionPane.showMessageDialog(formVenda, MessageCompra.ERRO_CONSULTAR_PRODUTO, MensagensUtil.ERRO, JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    public SwingWorker<List<Produto>, Object> workSearchProdutosAtualizaCor = new SwingWorker<List<Produto>, Object>() {

        @Override
        protected List<Produto> doInBackground() throws Exception {
            try {
                habilitaTelaAguarde(formVenda);
                return new ProdutoServerImpl<Produto>().recProdutos(produtoPedidoVenda, false);
            } catch (Exception ex) {
                throw ex;
            }
        }

        @Override
        protected void done() {
            try {
                desabilitaTelaAguarde(formVenda);
                if (get() != null) {
                    List<Produto> listProduto = (List<Produto>) get();
                    formVenda.returnSearchProdutosAtualizaCor(listProduto.get(0), rowProduto, corProduto, quantidadeProduto);
                }
            } catch (Exception ex) {
                LogUtil.logDescricaoErro(formVenda.getClass(), ex);
                JOptionPane.showMessageDialog(formVenda, MessageCompra.ERRO_CONSULTAR_PRODUTO, MensagensUtil.ERRO, JOptionPane.ERROR_MESSAGE);
            }
        }
    };
}
