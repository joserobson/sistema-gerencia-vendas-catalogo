/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.swingworker;

import br.com.dcoracoes.client.classes.serverimpl.AlertaServerImpl;
import br.com.dcoracoes.client.classes.serverimpl.PedidoServerImpl;
import br.com.dcoracoes.client.classes.serverimpl.PedidoVendaServerImpl;
import br.com.dcoracoes.client.classes.serverimpl.ProdutoServerImpl;
import br.com.dcoracoes.client.classes.serverimpl.RevendedorServerImpl;
import br.com.dcoracoes.client.enuns.Enum_Situacao_Alerta;
import br.com.dcoracoes.client.telas.relatorio.FormRelatorioVendaPorRevendedor;
import br.com.dcoracoes.client.telas.venda.FormConsultaVenda;
import br.com.dcoracoes.client.telas.venda.FormFormaPagamento;
import br.com.dcoracoes.client.telas.venda.FormVenda;
import br.com.dcoracoes.client.util.LogUtil;
import br.com.dcoracoes.client.util.MensagensUtil;
import br.com.dcoracoes.client.util.message.MessageProspeccao;
import br.com.dcoracoes.client.util.message.MessageRevendedor;
import br.com.dcoracoes.client.util.message.MessageVenda;
import br.com.dcoracoes.servico.service.*;
import java.lang.Exception;
import java.util.HashMap;
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
    private FormFormaPagamento formFormaPagamento = null;
    private Pedido pedido;
    private Produto produtoPedidoVenda;
    private int rowProduto;
    private String corProduto;
    private int quantidadeProduto;
    private Revendedor revendedor;
    private Alerta alerta;
    private FormRelatorioVendaPorRevendedor formRelatorioVendaPorRevendedor = null;
    private ModelRelatorioPedidoRevendedor modelRelatorioPedidoRevendedor;

    public ModelRelatorioPedidoRevendedor getModelRelatorioPedidoRevendedor() {
        return modelRelatorioPedidoRevendedor;
    }

    public void setModelRelatorioPedidoRevendedor(ModelRelatorioPedidoRevendedor modelRelatorioPedidoRevendedor) {
        this.modelRelatorioPedidoRevendedor = modelRelatorioPedidoRevendedor;
    }

    public FormRelatorioVendaPorRevendedor getFormRelatorioVendaPorRevendedor() {
        return formRelatorioVendaPorRevendedor;
    }

    public void setFormRelatorioVendaPorRevendedor(FormRelatorioVendaPorRevendedor formRelatorioVendaPorRevendedor) {
        this.formRelatorioVendaPorRevendedor = formRelatorioVendaPorRevendedor;
    }

    public Revendedor getRevendedor() {
        return revendedor;
    }

    public void setRevendedor(Revendedor revendedor) {
        this.revendedor = revendedor;
    }

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

    public Alerta getAlerta() {
        return alerta;
    }

    public void setAlerta(Alerta alerta) {
        this.alerta = alerta;
    }

    public FormFormaPagamento getFormFormaPagamento() {
        return formFormaPagamento;
    }

    public void setFormFormaPagamento(FormFormaPagamento formFormaPagamento) {
        this.formFormaPagamento = formFormaPagamento;
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
                    formVenda.salvarComSucesso();
                }
                formVenda.setVisible(true);
            } catch (Exception ex) {
                LogUtil.logDescricaoErro(formVenda.getClass(), ex);
                JOptionPane.showMessageDialog(formVenda, MessageVenda.ERRO_SALVAR_PEDIDO, "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    /**
     *
     */
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
                formVenda.setVisible(true);
            } catch (Exception ex) {
                LogUtil.logDescricaoErro(formVenda.getClass(), ex);
                JOptionPane.showMessageDialog(formVenda, MessageVenda.ERRO_CONSULTAR_PRODUTO, MensagensUtil.ERRO, JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    /**
     *
     */
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
                    formVenda.refreshGridCorProduto(listProduto.get(0), rowProduto, corProduto, quantidadeProduto);
                }
                formVenda.setVisible(true);
            } catch (Exception ex) {
                LogUtil.logDescricaoErro(formVenda.getClass(), ex);
                JOptionPane.showMessageDialog(formVenda, MessageVenda.ERRO_CONSULTAR_PRODUTO, MensagensUtil.ERRO, JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    /**
     *
     */
    public SwingWorker<String, Object> workGerarNumeroOrcamento = new SwingWorker<String, Object>() {

        @Override
        protected String doInBackground() throws Exception {
            try {
                habilitaTelaAguarde(formVenda);
                return new PedidoVendaServerImpl().recCodigoOrcamento();
            } catch (Exception ex) {
                throw ex;
            }
        }

        @Override
        protected void done() {
            try {
                desabilitaTelaAguarde(formVenda);
                if (get() != null) {
                    formVenda.clear();
                    formVenda.setCodigoOrcamento(get());
                    formVenda.createNew();
                }
                formVenda.setVisible(true);
            } catch (Exception ex) {
                LogUtil.logDescricaoErro(formVenda.getClass(), ex);
                JOptionPane.showMessageDialog(formVenda, MessageVenda.ERRO_GERAR_CODIGO_ORCAMENTO, MensagensUtil.ERRO, JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    /**
     *
     */
    public SwingWorker<HashMap<String, Object>, Object> workBuscaRevendedor = new SwingWorker<HashMap<String, Object>, Object>() {

        public final String CONST_REV = "rev";
        public final String CONST_ALERTAS = "alertas";

        @Override
        protected HashMap<String, Object> doInBackground() throws Exception {
            try {
                habilitaTelaAguarde(formVenda);

                Revendedor rev = null;
                List<Alerta> lstAlertas = null;

                //map retorno
                HashMap<String, Object> mapRetorno = new HashMap<String, Object>();

                //busca o revendedor
                List<ViewRevendedor> lstRevs = new RevendedorServerImpl<Revendedor>().recTodos(revendedor);

                //buscar as prospeccoes do revendedor
                if (lstRevs != null && lstRevs.size() > 0) {
                    rev = lstRevs.get(0).getRevendedor();

                    Alerta prospeccao = new Alerta();
                    prospeccao.setPessoa(rev.getPessoa());
                    prospeccao.setSituacaoAlerta(Enum_Situacao_Alerta.EMABERTO.getCodigo());

                    AlertaServerImpl serverImpl = new AlertaServerImpl();
                    lstAlertas = serverImpl.recTodos(prospeccao);

                }

                mapRetorno.put(CONST_REV, rev);
                mapRetorno.put(CONST_ALERTAS, lstAlertas);
                return mapRetorno;

            } catch (Exception ex) {
                throw ex;
            }
        }

        @Override
        protected void done() {
            try {
                desabilitaTelaAguarde(formVenda);
                if (get() != null) {

                    HashMap<String, Object> mapRetorno = get();

                    Revendedor rev = (Revendedor) mapRetorno.get(CONST_REV);
                    List<Alerta> lstAlertas = (List<Alerta>) mapRetorno.get(CONST_ALERTAS);

                    formVenda.afterBuscaRevendedor(rev, lstAlertas);

                }
            } catch (Exception ex) {
                LogUtil.logDescricaoErro(formVenda.getClass(), ex);
                JOptionPane.showMessageDialog(formVenda, MessageRevendedor.ERRO_CONSULTAR_REVENDEDOR, MensagensUtil.ERRO, JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    public SwingWorker<Pedido, Object> workRemoverPedido = new SwingWorker<Pedido, Object>() {

        @Override
        protected Pedido doInBackground() throws Exception {
            try {
                habilitaTelaAguarde(formVenda);
                PedidoVendaServerImpl server = new PedidoVendaServerImpl<T>();
                return (Pedido) server.deletar(pedido);
            } catch (Exception ex) {
                throw ex;
            }
        }

        @Override
        protected void done() {
            try {
                desabilitaTelaAguarde(formVenda);
                if (get() != null) {
                    formVenda.afterDelete();
                }
                formVenda.setVisible(true);
            } catch (Exception ex) {
                LogUtil.logDescricaoErro(formVenda.getClass(), ex);
                JOptionPane.showMessageDialog(formVenda, MessageVenda.ERRO_REMOVER_PEDIDO_VENDA, MensagensUtil.ERRO, JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    public SwingWorker<List<Alerta>, Object> workSearchAlertas = new SwingWorker<List<Alerta>, Object>() {

        @Override
        protected List<Alerta> doInBackground() throws Exception {
            try {
                habilitaTelaAguarde(formVenda);
                AlertaServerImpl serverImpl = new AlertaServerImpl();
                return serverImpl.recTodos(alerta);
            } catch (Exception ex) {
                throw ex;
            }
        }

        @Override
        protected void done() {
            try {
                desabilitaTelaAguarde(formVenda);
                formVenda.afterConsultaProspeccoes(get());
            } catch (Exception ex) {
                LogUtil.logDescricaoErro(formVenda.getClass(), ex);
                JOptionPane.showMessageDialog(formVenda, MessageProspeccao.ERRO_CONSULTAR_PROSPECCAO, MensagensUtil.ERRO, JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    public SwingWorker<List<T>, Object> workSearchPedidos = new SwingWorker<List<T>, Object>() {

        @Override
        protected List<T> doInBackground() throws Exception {
            try {
                habilitaTelaAguarde(formConsultaVenda);
                return new PedidoVendaServerImpl<T>().recTodos(pedido);
            } catch (Exception ex) {
                throw ex;
            }
        }

        @Override
        protected void done() {
            try {
                desabilitaTelaAguarde(formConsultaVenda);
                if (get() != null) {
                    List<PedidoVenda> listPedido = (List<PedidoVenda>) get();
                    formConsultaVenda.popularTela(listPedido);
                }
                formConsultaVenda.setVisible(true);
            } catch (Exception ex) {
                LogUtil.logDescricaoErro(formConsultaVenda.getClass(), ex);
                JOptionPane.showMessageDialog(formConsultaVenda, MessageVenda.ERRO_CONSULTAR_VENDA, "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    public SwingWorker<Boolean, Object> workAprovarPedidoVenda = new SwingWorker<Boolean, Object>() {

        @Override
        protected Boolean doInBackground() throws Exception {
            try {
                habilitaTelaAguarde(formFormaPagamento);
                return new PedidoVendaServerImpl<T>().aprovarPedido(pedido);
            } catch (Exception ex) {
                throw ex;
            }
        }

        @Override
        protected void done() {
            try {
                desabilitaTelaAguarde(formFormaPagamento);
                formFormaPagamento.afterAprovarVenda(get());                
            } catch (Exception ex) {
                LogUtil.logDescricaoErro(formFormaPagamento.getClass(), ex);
                JOptionPane.showMessageDialog(formFormaPagamento, MessageVenda.ERRO_APROVAR_PEDIDO, "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    public SwingWorker<List<T>, Object> workRecRelatorioPedidosPorRevendedor = new SwingWorker<List<T>, Object>() {

        @Override
        protected List<T> doInBackground() throws Exception {
            try {
                habilitaTelaAguarde(formRelatorioVendaPorRevendedor);
                PedidoServerImpl serverImpl = new PedidoServerImpl();
                return serverImpl.recRelatorioPedidosPorRevendedor(modelRelatorioPedidoRevendedor);
            } catch (Exception ex) {
                throw ex;
            }
        }

        @Override
        protected void done() {
            try {
                desabilitaTelaAguarde(formRelatorioVendaPorRevendedor);
                formRelatorioVendaPorRevendedor.setVisible(true);
                if (get() != null) {
                    formRelatorioVendaPorRevendedor.processaList((List<PedidoVenda>) get());
                }
            } catch (Exception ex) {
                LogUtil.logDescricaoErro(formRelatorioVendaPorRevendedor.getClass(), ex);
                JOptionPane.showMessageDialog(formRelatorioVendaPorRevendedor, MessageRevendedor.ERRO_CONSULTAR_REVENDEDOR, MensagensUtil.ERRO, JOptionPane.ERROR_MESSAGE);
            }
        }
    };
}
