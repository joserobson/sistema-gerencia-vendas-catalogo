/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.swingworker;

import br.com.dcoracoes.client.classes.serverimpl.PerfilServerImpl;
import br.com.dcoracoes.client.telas.usuario.FormConsultaUsuario;
import br.com.dcoracoes.client.telas.usuario.FormUsuario;
import br.com.dcoracoes.client.util.LogUtil;
import br.com.dcoracoes.client.util.message.MessagePerfil;
import br.com.dcoracoes.servico.service.Perfil;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author Jose Robson
 */
public class SwingWorkerPerfil<T extends Perfil> extends BaseSwingWorker {

    private T perfil;
    private FormConsultaUsuario formConsultaUsuario = null;
    private FormUsuario formUsuario = null;

    public FormConsultaUsuario getFormConsultaUsuario() {
        return formConsultaUsuario;
    }

    public void setFormConsultaUsuario(FormConsultaUsuario formConsultaUsuario) {
        this.formConsultaUsuario = formConsultaUsuario;
    }

    public SwingWorkerPerfil(T perfil) {
        this.perfil = perfil;
    }

    public FormUsuario getFormUsuario() {
        return formUsuario;
    }

    public void setFormUsuario(FormUsuario formUsuario) {
        this.formUsuario = formUsuario;
    }

    public SwingWorkerPerfil() {
        super();
    }
    public SwingWorker<List<T>, Object> workRecPerfil = new SwingWorker<List<T>, Object>() {

        @Override
        protected List<T> doInBackground() throws Exception {
            habilitaTelaAguarde(formConsultaUsuario);
            try {
                return new PerfilServerImpl<T>().recTodos(perfil);
            } catch (Exception ex) {
                desabilitaTelaAguarde(formConsultaUsuario);
                throw ex;
            }
        }

        @Override
        protected void done() {
            desabilitaTelaAguarde(formConsultaUsuario);
            try {
                if (get() != null) {
                    List<Perfil> lst = (List<Perfil>) get();
                    if (lst != null) {      
                        formConsultaUsuario.setListPerfil(lst);
                        formConsultaUsuario.showFrame();                        
                    }
                }
            } catch (Exception ex) {
                LogUtil.logDescricaoErro(formConsultaUsuario.getClass(), ex);
                JOptionPane.showMessageDialog(formConsultaUsuario, MessagePerfil.ERRO_CONSULTA_PERFIL, "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    };
}
