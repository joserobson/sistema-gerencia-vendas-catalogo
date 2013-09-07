/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.swingworker;

import br.com.dcoracoes.client.classes.serverimpl.ProdutoServerImpl;
import br.com.dcoracoes.client.telas.produto.FormConsultaProduto;
import br.com.dcoracoes.client.telas.produto.FormProduto;
import br.com.dcoracoes.client.telas.relatorio.FormRelatorioProduto;
import br.com.dcoracoes.client.util.LogUtil;
import br.com.dcoracoes.client.util.message.MessageProduto;
import br.com.dcoracoes.servico.service.ItemProduto;
import br.com.dcoracoes.servico.service.Produto;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author Jose Robson
 */
public class SwingWorkerProduto<T extends Produto> extends BaseSwingWorker {

    private FormProduto formProduto = null;
    private FormConsultaProduto formConsultaProduto = null;
    private Produto produto = null;
    private ItemProduto itemProduto = null;
    private boolean useLike;
    private FormRelatorioProduto formRelatorioProduto = null;

    public FormRelatorioProduto getFormRelatorioProduto() {
        return formRelatorioProduto;
    }

    public void setFormRelatorioProduto(FormRelatorioProduto formRelatorioProduto) {
        this.formRelatorioProduto = formRelatorioProduto;
    }

    public FormProduto getFormProduto() {
        return formProduto;
    }

    public void setFormProduto(FormProduto formProduto) {
        this.formProduto = formProduto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public ItemProduto getItemProduto() {
        return itemProduto;
    }

    public void setItemProduto(ItemProduto itemProduto) {
        this.itemProduto = itemProduto;
    }

    public FormConsultaProduto getFormConsultaProduto() {
        return formConsultaProduto;
    }

    public void setFormConsultaProduto(FormConsultaProduto formConsultaProduto) {
        this.formConsultaProduto = formConsultaProduto;
    }

    public boolean isUseLike() {
        return useLike;
    }

    public void setUseLike(boolean useLike) {
        this.useLike = useLike;
    }
    /**
     * Salvar produto
     */
    public SwingWorker<T, Object> workSalvaProduto = new SwingWorker<T, Object>() {

        @Override
        protected T doInBackground() throws Exception {
            try {
                habilitaTelaAguarde(formProduto);
                ProdutoServerImpl server = new ProdutoServerImpl();
                return (T) server.salvarComRetorno(produto);
            } catch (Exception ex) {
                desabilitaTelaAguarde(formProduto);
                throw ex;
            }
        }

        @Override
        protected void done() {
            try {
                desabilitaTelaAguarde(formProduto);
                if (get() != null) {
                    formProduto.salvarComSucesso();
                    formProduto.setProduto(get());
                }
            } catch (Exception ex) {
                LogUtil.logDescricaoErro(formProduto.getClass(), ex);
                JOptionPane.showMessageDialog(formProduto, MessageProduto.ERRO_SALVAR_PRODUTO, "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    /**
     * remover item produto
     */
    public SwingWorker<ItemProduto, Object> workRemoveItemProduto = new SwingWorker<ItemProduto, Object>() {

        @Override
        protected ItemProduto doInBackground() throws Exception {
            try {
                habilitaTelaAguarde(formProduto);
                ProdutoServerImpl server = new ProdutoServerImpl();
                server.deleteItemProduto(itemProduto);
                return itemProduto;
            } catch (Exception ex) {
                desabilitaTelaAguarde(formProduto);
                throw ex;
            }
        }

        @Override
        protected void done() {
            try {
                desabilitaTelaAguarde(formProduto);
                if (get() != null) {
                    formProduto.removeItemProdutoNaTela(get());
                }
            } catch (Exception ex) {
                LogUtil.logDescricaoErro(formProduto.getClass(), ex);
                JOptionPane.showMessageDialog(formProduto, MessageProduto.ERRO_REMOVER_COR, "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    /**
     * remover item produto
     */
    public SwingWorker<T, Object> workRemoveProduto = new SwingWorker<T, Object>() {

        @Override
        protected T doInBackground() throws Exception {
            try {
                habilitaTelaAguarde(formProduto);
                ProdutoServerImpl server = new ProdutoServerImpl();
                server.deletar(produto);
                return (T) produto;
            } catch (Exception ex) {
                desabilitaTelaAguarde(formProduto);
                throw ex;
            }
        }

        @Override
        protected void done() {
            try {
                desabilitaTelaAguarde(formProduto);
                if (get() != null) {
                    formProduto.removeProdutoComSucesso();
                }
            } catch (Exception ex) {
                LogUtil.logDescricaoErro(formProduto.getClass(), ex);
                JOptionPane.showMessageDialog(formProduto, MessageProduto.ERRO_REMOVER_PRODUTO, "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    public SwingWorker<List<T>, Object> workSearchProdutos = new SwingWorker<List<T>, Object>() {

        @Override
        protected List<T> doInBackground() throws Exception {
            try {
                if(formConsultaProduto != null)
                    habilitaTelaAguarde(formConsultaProduto);
                else
                    if(formRelatorioProduto != null)
                        habilitaTelaAguarde(formRelatorioProduto);
                return new ProdutoServerImpl<T>().recProdutos(produto, useLike);
            } catch (Exception ex) {
                throw ex;
            }
        }

        @Override
        protected void done() {
            try {                
                if(formConsultaProduto != null)
                    desabilitaTelaAguarde(formConsultaProduto);
                else
                    if(formRelatorioProduto != null)
                        desabilitaTelaAguarde(formRelatorioProduto);
                
                if (get() != null) {
                    List<Produto> listProduto = (List<Produto>) get();
                        
                    if(formConsultaProduto != null)
                        formConsultaProduto.popularTela(listProduto);
                    else
                        if(formRelatorioProduto != null)
                            formRelatorioProduto.processaListaProduto(listProduto);
                }
            } catch (Exception ex) {
                LogUtil.logDescricaoErro(formConsultaProduto.getClass(), ex);
                JOptionPane.showMessageDialog(formConsultaProduto, MessageProduto.ERRO_CONSULTAR_PRODUTO, "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    };
}
