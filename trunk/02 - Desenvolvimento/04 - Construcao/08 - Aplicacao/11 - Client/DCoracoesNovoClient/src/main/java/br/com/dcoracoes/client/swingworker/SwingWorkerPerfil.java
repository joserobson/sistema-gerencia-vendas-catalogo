/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.swingworker;

import br.com.dcoracoes.client.classes.serverimpl.PerfilServerImpl;
import br.com.dcoracoes.client.telas.perfil.FormConsultaPerfil;
import br.com.dcoracoes.client.telas.perfil.FormPerfil;
import br.com.dcoracoes.client.telas.usuario.FormConsultaUsuario;
import br.com.dcoracoes.client.telas.usuario.FormUsuario;
import br.com.dcoracoes.client.util.LogUtil;
import br.com.dcoracoes.client.util.message.MessagePerfil;
import br.com.dcoracoes.servico.service.AssociaPerfilPermissao;
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
    private FormConsultaPerfil formConsultaPerfil =  null;
    private FormPerfil formPerfil = null;
    private List<AssociaPerfilPermissao> lstPermissoes;

    public List<AssociaPerfilPermissao> getLstPermissoes() {
        return lstPermissoes;
    }

    public void setLstPermissoes(List<AssociaPerfilPermissao> lstPermissoes) {
        this.lstPermissoes = lstPermissoes;
    }

    public FormPerfil getFormPerfil() {
        return formPerfil;
    }

    public void setFormPerfil(FormPerfil formPerfil) {
        this.formPerfil = formPerfil;
    }

    public FormConsultaPerfil getFormConsultaPerfil() {
        return formConsultaPerfil;
    }

    public void setFormConsultaPerfil(FormConsultaPerfil formConsultaPerfil) {
        this.formConsultaPerfil = formConsultaPerfil;
    }

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
            habilitaTelaAguarde(formConsultaPerfil);
            try {
                return new PerfilServerImpl<T>().recTodos(perfil);
            } catch (Exception ex) {
                desabilitaTelaAguarde(formConsultaPerfil);
                throw ex;
            }
        }

        @Override
        protected void done() {
            desabilitaTelaAguarde(formConsultaPerfil);
            try {
                if (get() != null) {
                    List<Perfil> lst = (List<Perfil>) get();
                    if (lst != null) {    
                        formConsultaPerfil.popularTela(lst);                    
                    }
                }
                formConsultaPerfil.setVisible(true);
            } catch (Exception ex) {
                LogUtil.logDescricaoErro(formConsultaPerfil.getClass(), ex);
                JOptionPane.showMessageDialog(formConsultaPerfil, MessagePerfil.ERRO_CONSULTA_PERFIL, "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    
    public SwingWorker<List<T>, Object> workSearchPerfil = new SwingWorker<List<T>, Object>() {

        @Override
        protected List<T> doInBackground() throws Exception {
            try {
                habilitaTelaAguarde(formConsultaPerfil);
                return new PerfilServerImpl<T>().recTodos(perfil);
            } catch (Exception ex) {
                throw ex;
            }
        }

        @Override
        protected void done() {
            try {
                desabilitaTelaAguarde(formConsultaPerfil);
                if (get() != null) {
                    List<Perfil> list = (List<Perfil>) get();
                    formConsultaPerfil.popularTela(list);
                }
                formConsultaUsuario.setVisible(true);
            } catch (Exception ex) {
                LogUtil.logDescricaoErro(formConsultaPerfil.getClass(), ex);
                JOptionPane.showMessageDialog(formConsultaPerfil, MessagePerfil.ERRO_CONSULTA_PERFIL, "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    
    public SwingWorker<Boolean, Object> workSalvaPerfil = new SwingWorker<Boolean, Object>() {

        @Override
        protected Boolean doInBackground() throws Exception {
            try {
                habilitaTelaAguarde(formPerfil);
                new PerfilServerImpl<T>().salvarPerfil(perfil, lstPermissoes);
                return true;
            } catch (Exception ex) {
                desabilitaTelaAguarde(formPerfil);
                throw ex;
            }
        }

        @Override
        protected void done() {
            try {
                desabilitaTelaAguarde(formPerfil);
                if (get()) {
                    formPerfil.salvarComSucesso();
                }
            } catch (Exception ex) {
                LogUtil.logDescricaoErro(formPerfil.getClass(), ex);
                JOptionPane.showMessageDialog(formPerfil, MessagePerfil.ERRO_SALVAR_PERFIL, "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    };
}
