/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.swingworker;

import br.com.dcoracoes.client.classes.serverimpl.AlertaServerImpl;
import br.com.dcoracoes.client.telas.prospeccoes.FormProspeccoes;
import br.com.dcoracoes.client.telas.revendedor.FormRevendedor;
import br.com.dcoracoes.client.util.LogUtil;
import br.com.dcoracoes.client.util.MensagensUtil;
import br.com.dcoracoes.client.util.message.MessageProspeccao;
import br.com.dcoracoes.servico.service.Alerta;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author Robson
 */
public class SwingWorkerProspeccoes<T extends Alerta> extends BaseSwingWorker {
    
    private FormProspeccoes formProspeccoes = null;
    private Alerta prospeccao = null;
    private FormRevendedor formRevendedor = null;
    
    public SwingWorkerProspeccoes(Alerta prospeccao){
        this.prospeccao = prospeccao;
    }

    public SwingWorkerProspeccoes() {
        super();
    }

    public FormProspeccoes getFormProspeccoes() {
        return formProspeccoes;
    }

    public void setFormProspeccoes(FormProspeccoes formProspeccoes) {
        this.formProspeccoes = formProspeccoes;
    }

    public Alerta getProspeccao() {
        return prospeccao;
    }

    public void setProspeccao(Alerta prospeccao) {
        this.prospeccao = prospeccao;
    }
    
    public FormRevendedor getFormRevendedor() {
        return formRevendedor;
    }

    public void setFormRevendedor(FormRevendedor formRevendedor) {
        this.formRevendedor = formRevendedor;
    }
    
    public SwingWorker<T, Object> workSalvaProspeccao = new SwingWorker<T, Object>() {

        @Override
        protected T doInBackground() throws Exception {
            try {
                habilitaTelaAguarde(formProspeccoes);
                AlertaServerImpl server = new AlertaServerImpl();
                return (T)server.salvarComRetorno(prospeccao);                
            } catch (Exception ex) {
                desabilitaTelaAguarde(formProspeccoes);
                throw ex;
            }
        }

        @Override
        protected void done() {
            try {
                desabilitaTelaAguarde(formProspeccoes);
                if (get() != null) {
                    formProspeccoes.salvarComSucesso();
                    formProspeccoes.setProspeccao(get());
                }
                formProspeccoes.setVisible(true);
            } catch (Exception ex) {
                LogUtil.logDescricaoErro(formProspeccoes.getClass(), ex);
                JOptionPane.showMessageDialog(formProspeccoes, MessageProspeccao.ERRO_SALVAR_PROSPECCAO, MensagensUtil.ERRO, JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    
    public SwingWorker<List<T>, Object> workRecListaAlertas = new SwingWorker<List<T>, Object>() {

        @Override
        protected List<T> doInBackground() throws Exception {
            try {
                if(formProspeccoes != null)
                    habilitaTelaAguarde(formProspeccoes);
                else
                    if(formRevendedor != null)
                        habilitaTelaAguarde(formRevendedor);
                return new AlertaServerImpl<T>().recTodos(prospeccao);
            } catch (Exception ex) {
                throw ex;
            }
        }

        @Override
        protected void done() {
            try {
                if(formProspeccoes != null)
                    desabilitaTelaAguarde(formProspeccoes);
                else
                    if(formRevendedor != null)
                        desabilitaTelaAguarde(formRevendedor);
                
                if (get() != null) {
                    List<Alerta> listUsuario = (List<Alerta>) get();
                    
                    if(formProspeccoes != null){
                        formProspeccoes.populaTela(listUsuario);
                        formProspeccoes.setVisible(true);
                    }
                    else
                        if(formRevendedor != null){
                            formRevendedor.existAlertaRevendedor(!listUsuario.isEmpty());
                            formRevendedor.setVisible(true);
                        }
                }
            } catch (Exception ex) {
                LogUtil.logDescricaoErro(formProspeccoes.getClass(), ex);
                JOptionPane.showMessageDialog(formProspeccoes, MessageProspeccao.ERRO_CONSULTAR_PROSPECCAO, MensagensUtil.ERRO, JOptionPane.ERROR_MESSAGE);
            }
        }
    };
}
