/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.swingworker;

import br.com.dcoracoes.client.classes.serverimpl.RevendedorServerImpl;
import br.com.dcoracoes.client.telas.revendedor.FormConsultaRevendedor;
import br.com.dcoracoes.client.telas.revendedor.FormFiltroGerarEtiquetas;
import br.com.dcoracoes.client.telas.revendedor.FormRevendedor;
import br.com.dcoracoes.client.util.MensagensUtil;
import br.com.dcoracoes.client.util.message.MessageRevendedor;
import br.com.dcoracoes.servico.service.*;
import br.com.wedesenv.common.log.LogUtil;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author Robson
 */
public class SwingWorkerRevendedor<T extends ViewRevendedor> extends BaseSwingWorker {
    
    private Revendedor revendedor;
    private FormConsultaRevendedor formConsultaRevendedor = null;
    private List<ViewRevendedor> lstViewRevendedor;
    private ModelGerarEtiqueta modelGerarEtiqueta;
    private FormFiltroGerarEtiquetas formFiltroGerarEtiqueta = null;
    private ViewRevendedor viewRevendedor;
    private PessoaFisica pessoa;

    private FormRevendedor formRevendedor = null;
    
    public SwingWorkerRevendedor(){ }
    
    public SwingWorkerRevendedor(ViewRevendedor viewRevendedor){
        this.viewRevendedor = viewRevendedor;
    }
    
    public SwingWorkerRevendedor(Revendedor revendedor){
        this.revendedor = revendedor;
    }
    
    public SwingWorkerRevendedor(ModelGerarEtiqueta modelGerarEtiqueta){
        this.modelGerarEtiqueta = modelGerarEtiqueta;
    }
    
    public SwingWorkerRevendedor(PessoaFisica pPessoa){
        this.pessoa = pPessoa;
    }

    public PessoaFisica getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaFisica pessoa) {
        this.pessoa = pessoa;
    }

    public FormFiltroGerarEtiquetas getFormFiltroGerarEtiqueta() {
        return formFiltroGerarEtiqueta;
    }

    public void setFormFiltroGerarEtiqueta(FormFiltroGerarEtiquetas formFiltroGerarEtiqueta) {
        this.formFiltroGerarEtiqueta = formFiltroGerarEtiqueta;
    }

    public FormConsultaRevendedor getFormConsultaRevendedor() {
        return formConsultaRevendedor;
    }

    public void setFormConsultaRevendedor(FormConsultaRevendedor formConsultaRevendedor) {
        this.formConsultaRevendedor = formConsultaRevendedor;
    }

    public List<ViewRevendedor> getLstViewRevendedor() {
        return lstViewRevendedor;
    }

    public void setLstViewRevendedor(List<ViewRevendedor> lstViewRevendedor) {
        this.lstViewRevendedor = lstViewRevendedor;
    }

    public Revendedor getRevendedor() {
        return revendedor;
    }

    public void setRevendedor(Revendedor revendedor) {
        this.revendedor = revendedor;
    }
    
    public ViewRevendedor getViewRevendedor() {
        return viewRevendedor;
    }

    public void setViewRevendedor(ViewRevendedor viewRevendedor) {
        this.viewRevendedor = viewRevendedor;
    }
    
    public FormRevendedor getFormRevendedor() {
        return formRevendedor;
    }

    public void setFormRevendedor(FormRevendedor formRevendedor) {
        this.formRevendedor = formRevendedor;
    }
    
    public SwingWorker<List<T>, Object> workSearchViewRevendedor = new SwingWorker<List<T>, Object>() {

        @Override
        protected List<T> doInBackground() throws java.lang.Exception {
            try {
                habilitaTelaAguarde(formConsultaRevendedor);
                return new RevendedorServerImpl<Revendedor>().recTodos(revendedor);
            } catch (java.lang.Exception ex) {
                throw ex;
            }
        }

        @Override
        protected void done() {
            try {
                desabilitaTelaAguarde(formConsultaRevendedor);
                if (get() != null) {
                    List<ViewRevendedor> list = (List<ViewRevendedor>) get();
                    formConsultaRevendedor.populaTela(list);
                }                
                formConsultaRevendedor.setVisible(true);
            } catch (java.lang.Exception ex) {
                desabilitaTelaAguarde(formConsultaRevendedor);
                LogUtil.logDescricaoErro(formConsultaRevendedor.getClass(), ex);
                JOptionPane.showMessageDialog(formConsultaRevendedor, MessageRevendedor.ERRO_CONSULTAR_REVENDEDOR, MensagensUtil.ERRO, JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    
    public SwingWorker<List<T>, Object> workRecRevendedorEtiqueta = new SwingWorker<List<T>, Object>() {

        @Override
        protected List<T> doInBackground() throws java.lang.Exception {
            try {
                habilitaTelaAguarde(formFiltroGerarEtiqueta);
                RevendedorServerImpl serverImpl = new RevendedorServerImpl();
                return serverImpl.recRevendedorEtiqueta(modelGerarEtiqueta);
            } catch (java.lang.Exception ex) {
                throw ex;
            }
        }

        @Override
        protected void done() {
            try {
                desabilitaTelaAguarde(formFiltroGerarEtiqueta);
                formFiltroGerarEtiqueta.setVisible(true);
                if (get() != null) {
                    List list = (List) get();
                    formFiltroGerarEtiqueta.processaEtiquetas(list);
                }
            } catch (java.lang.Exception ex) {
                LogUtil.logDescricaoErro(formConsultaRevendedor.getClass(), ex);
                JOptionPane.showMessageDialog(formConsultaRevendedor, MessageRevendedor.ERRO_CONSULTAR_REVENDEDOR, MensagensUtil.ERRO, JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    
    public SwingWorker<T, Object> workRecUltimoRevendedorCadastro = new SwingWorker<T, Object>() {

        @Override
        protected T doInBackground() throws java.lang.Exception {
            try {
                habilitaTelaAguarde(formRevendedor);
                RevendedorServerImpl serverImpl = new RevendedorServerImpl();
                return (T)serverImpl.recUltimoRevendedorCadastro();
            } catch (java.lang.Exception ex) {
                throw ex;
            }
        }

        @Override
        protected void done() {
            try {
                desabilitaTelaAguarde(formRevendedor);
                if (get() != null) {
                    formRevendedor.setRevendedor(get());
                } else
                    formRevendedor.createNew();
                
                formRevendedor.setVisible(true);
            } catch (java.lang.Exception ex) {
                LogUtil.logDescricaoErro(formRevendedor.getClass(), ex);
                JOptionPane.showMessageDialog(formRevendedor, MessageRevendedor.ERRO_CONSULTAR_REVENDEDOR, MensagensUtil.ERRO, JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    
    public SwingWorker<T, Object> workSalvaRevendedor = new SwingWorker<T, Object>() {

        @Override
        protected T doInBackground() throws java.lang.Exception {
            try {
                habilitaTelaAguarde(formRevendedor);
                RevendedorServerImpl server = new RevendedorServerImpl();
                return (T)server.salvarComRetorno(viewRevendedor);                
            } catch (java.lang.Exception ex) {
                desabilitaTelaAguarde(formRevendedor);
                throw ex;
            }
        }

        @Override
        protected void done() {
            try {
                desabilitaTelaAguarde(formRevendedor);
                if (get() != null) {
                    formRevendedor.salvarComSucesso(get());
                }
                formRevendedor.setVisible(true);
            } catch (java.lang.Exception ex) {
                LogUtil.logDescricaoErro(formRevendedor.getClass(), ex);
                if(ex.getCause().getCause().getMessage().contains("CPF JÁ CADASTRADO EM NOSSO BANCO DE DADOS."))
                    JOptionPane.showMessageDialog(formRevendedor, ex.getCause().getCause().getMessage(), MensagensUtil.ERRO, JOptionPane.ERROR_MESSAGE);
                else
                    JOptionPane.showMessageDialog(formRevendedor, MessageRevendedor.ERRO_SALVAR_REVENDEDOR, MensagensUtil.ERRO, JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    
    public SwingWorker<Integer, Object> workRecCodigoSequencia = new SwingWorker<Integer, Object>() {

        @Override
        protected Integer doInBackground() throws java.lang.Exception {
            try {
                habilitaTelaAguarde(formRevendedor);
                RevendedorServerImpl serverImpl = new RevendedorServerImpl();
                return serverImpl.recCodigoSequencia();
            } catch (java.lang.Exception ex) {
                throw ex;
            }
        }

        @Override
        protected void done() {
            try {
                desabilitaTelaAguarde(formRevendedor);
                if (get() != null) {
                    formRevendedor.populaNewCodigoConsultor(get());
                }
                formRevendedor.setVisible(true);
            } catch (java.lang.Exception ex) {
                LogUtil.logDescricaoErro(formRevendedor.getClass(), ex);
                JOptionPane.showMessageDialog(formRevendedor, MessageRevendedor.ERRO_CONSULTAR_REVENDEDOR, MensagensUtil.ERRO, JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    
    public SwingWorker<Boolean, Object> workValidaCPF = new SwingWorker<Boolean, Object>() {

        @Override
        protected Boolean doInBackground() throws java.lang.Exception {
            try {
                habilitaTelaAguarde(formRevendedor);
                RevendedorServerImpl serverImpl = new RevendedorServerImpl();
                return serverImpl.validaCPF(pessoa) != null;
            } catch (java.lang.Exception ex) {
                throw ex;
            }
        }

        @Override
        protected void done() {
            try {
                desabilitaTelaAguarde(formRevendedor);
                if (get()) {
                    //Implemetar quando necessario
                    //hoje não está sendo utilizado
                }
                formRevendedor.setVisible(true);
            } catch (java.lang.Exception ex) {
                LogUtil.logDescricaoErro(formRevendedor.getClass(), ex);
                JOptionPane.showMessageDialog(formRevendedor, MessageRevendedor.ERRO_CONSULTAR_REVENDEDOR, MensagensUtil.ERRO, JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    
    public SwingWorker<PedidoVenda, Object> workRecUltimoPedidoVenda = new SwingWorker<PedidoVenda, Object>() {

        @Override
        protected PedidoVenda doInBackground() throws java.lang.Exception {
            try {
                habilitaTelaAguarde(formRevendedor);
                RevendedorServerImpl serverImpl = new RevendedorServerImpl();
                return serverImpl.recUltimoPedidoVenda(revendedor);
            } catch (java.lang.Exception ex) {
                desabilitaTelaAguarde(formRevendedor);
                throw ex;
            }
        }

        @Override
        protected void done() {
            try {
                desabilitaTelaAguarde(formRevendedor);
                if (get() != null) 
                    formRevendedor.atualizaDataUltimaCompra(get());
                
                formRevendedor.setVisible(true);
            } catch (java.lang.Exception ex) {
                LogUtil.logDescricaoErro(formRevendedor.getClass(), ex);
                JOptionPane.showMessageDialog(formRevendedor, MessageRevendedor.ERRO_CONSULTAR_REVENDEDOR, MensagensUtil.ERRO, JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    
    public SwingWorker<List<Parcela>, Object> workRecHistoricoParcelas = new SwingWorker<List<Parcela>, Object>() {

        @Override
        protected List<Parcela> doInBackground() throws java.lang.Exception {
            try {
                habilitaTelaAguarde(formRevendedor);
                return new RevendedorServerImpl<Revendedor>().recHistoricoParcelas(revendedor);
            } catch (java.lang.Exception ex) {
                throw ex;
            }
        }

        @Override
        protected void done() {
            try {
                desabilitaTelaAguarde(formRevendedor);
                formRevendedor.setVisible(true);
                if (get() != null) {
                    List<Parcela> list = (List<Parcela>) get();
                    formRevendedor.openFormHistoricoLimiteEmUso(list);
                }                
            } catch (java.lang.Exception ex) {
                desabilitaTelaAguarde(formRevendedor);
                LogUtil.logDescricaoErro(formRevendedor.getClass(), ex);
                JOptionPane.showMessageDialog(formRevendedor, MessageRevendedor.ERRO_CONSULTAR_REVENDEDOR, MensagensUtil.ERRO, JOptionPane.ERROR_MESSAGE);
            }
        }
    };
}
