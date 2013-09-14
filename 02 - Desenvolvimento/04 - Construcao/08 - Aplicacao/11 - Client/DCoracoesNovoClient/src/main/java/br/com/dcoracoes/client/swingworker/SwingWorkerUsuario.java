/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.swingworker;

import br.com.dcoracoes.client.classes.serverimpl.PerfilServerImpl;
import br.com.dcoracoes.client.classes.serverimpl.UsuarioServerImpl;
import br.com.dcoracoes.client.telas.login.FormLogin;
import br.com.dcoracoes.client.telas.usuario.FormConsultaUsuario;
import br.com.dcoracoes.client.telas.usuario.FormUsuario;
import br.com.dcoracoes.client.util.LogUtil;
import br.com.dcoracoes.client.util.message.MessagePerfil;
import br.com.dcoracoes.client.util.message.MessageUsuario;
import br.com.dcoracoes.servico.service.Perfil;
import br.com.dcoracoes.servico.service.Usuario;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author Jose Robson
 */
public class SwingWorkerUsuario<T extends Usuario> extends BaseSwingWorker {

    private FormLogin formLogin = null;
    private FormConsultaUsuario formConsultaUsuario = null;
    private FormUsuario formUsuario = null;
    private Usuario usuario = null;

    public SwingWorkerUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public FormLogin getFormLogin() {
        return formLogin;
    }

    public void setFormLogin(FormLogin formLogin) {
        this.formLogin = formLogin;
    }

    public FormConsultaUsuario getFormConsultaUsuario() {
        return formConsultaUsuario;
    }

    public void setFormConsultaUsuario(FormConsultaUsuario formConsultaUsuario) {
        this.formConsultaUsuario = formConsultaUsuario;
    }

    public void setFormUsuario(FormUsuario formUsuario) {
        this.formUsuario = formUsuario;
    }

    public SwingWorkerUsuario() {
        super();
    }
    public SwingWorker<List<T>, Object> workRecUsuarios = new SwingWorker<List<T>, Object>() {

        @Override
        protected List<T> doInBackground() throws Exception {
            try {
                habilitaTelaAguarde(formLogin,"Carregando Usuários....");
                return new UsuarioServerImpl<T>().recTodos(new Usuario());
            } catch (Exception ex) {
                desabilitaTelaAguarde(formLogin);
                throw ex;
            }
        }

        @Override
        protected void done() {
            try {
                if (get() != null) {
                    List<Usuario> listUsuario = (List<Usuario>) get();
                    formLogin.populaComboUsuario(listUsuario);
                }
                desabilitaTelaAguarde(formLogin);
                formLogin.setVisible(true);
                formLogin.getCbUsuario().requestFocus();

            } catch (Exception ex) {                
                desabilitaTelaAguarde(formLogin);
                LogUtil.logDescricaoErro(formLogin.getClass(), ex);
                JOptionPane.showMessageDialog(formLogin, MessageUsuario.ERRO_CONSULTAR_USUARIO, "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    public SwingWorker<List<T>, Object> workSearchUsuarios = new SwingWorker<List<T>, Object>() {

        @Override
        protected List<T> doInBackground() throws Exception {
            try {
                habilitaTelaAguarde(formConsultaUsuario);
                return new UsuarioServerImpl<T>().recTodos(usuario);
            } catch (Exception ex) {
                throw ex;
            }
        }

        @Override
        protected void done() {
            try {
                desabilitaTelaAguarde(formConsultaUsuario);
                if (get() != null) {
                    List<Usuario> listUsuario = (List<Usuario>) get();
                    formConsultaUsuario.populaTela(listUsuario);
                }
                formConsultaUsuario.setVisible(true);
            } catch (Exception ex) {
                LogUtil.logDescricaoErro(formConsultaUsuario.getClass(), ex);
                JOptionPane.showMessageDialog(formConsultaUsuario, MessageUsuario.ERRO_CONSULTAR_USUARIO, "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    public SwingWorker<T, Object> workSalvaUsuario = new SwingWorker<T, Object>() {

        @Override
        protected T doInBackground() throws Exception {
            try {
                habilitaTelaAguarde(formUsuario);
                UsuarioServerImpl server = new UsuarioServerImpl();
                return (T)server.salvarComRetorno(usuario);                
            } catch (Exception ex) {
                desabilitaTelaAguarde(formUsuario);
                throw ex;
            }
        }

        @Override
        protected void done() {
            try {
                desabilitaTelaAguarde(formUsuario);
                if (get() != null) {
                    formUsuario.salvarComSucesso();
                    formUsuario.setUsuario(get());
                }
            } catch (Exception ex) {
                LogUtil.logDescricaoErro(formUsuario.getClass(), ex);
                JOptionPane.showMessageDialog(formUsuario, MessageUsuario.ERRO_SALVAR_USUARIO, "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    
    /**
     * 
     */
    public SwingWorker<List<Perfil>, Object> workOpenTelaConsultaUsuario = new SwingWorker<List<Perfil>, Object>() {

        @Override
        protected List<Perfil> doInBackground() throws Exception {
            try {
                habilitaTelaAguarde(formConsultaUsuario);
                return new PerfilServerImpl<Perfil>().recTodos(new Perfil());
            } catch (Exception ex) {
                throw ex;
            }
        }

        @Override
        protected void done() {
            try {
                desabilitaTelaAguarde(formConsultaUsuario);
                if (get() != null) {
                    List<Perfil> list = (List<Perfil>) get();
                    formConsultaUsuario.setListPerfil(list);
                    formConsultaUsuario.showFrame();
                }
                formConsultaUsuario.setVisible(true);
            } catch (Exception ex) {
                LogUtil.logDescricaoErro(formConsultaUsuario.getClass(), ex);
                JOptionPane.showMessageDialog(formConsultaUsuario, MessagePerfil.ERRO_CONSULTA_PERFIL, "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    };
}