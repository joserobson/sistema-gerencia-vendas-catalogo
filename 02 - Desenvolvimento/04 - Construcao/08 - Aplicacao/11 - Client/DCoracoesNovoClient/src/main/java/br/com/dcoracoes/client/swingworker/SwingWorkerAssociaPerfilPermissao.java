/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.swingworker;

import br.com.dcoracoes.client.classes.serverimpl.PerfilServerImpl;
import br.com.dcoracoes.client.telas.login.FormLogin;
import br.com.dcoracoes.client.util.LogUtil;
import br.com.dcoracoes.client.util.message.MessagePerfil;
import br.com.dcoracoes.servico.service.AssociaPerfilPermissao;
import br.com.dcoracoes.servico.service.Perfil;
import br.com.dcoracoes.servico.service.Usuario;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author Jose Robson
 */
public class SwingWorkerAssociaPerfilPermissao extends BaseSwingWorker {
    
    private FormLogin formLogin = null;
    
    public void setFormLogin(FormLogin formLogin) {
        this.formLogin = formLogin;
    }
    public SwingWorker<List<AssociaPerfilPermissao>, Object> workRecAssociaPermissao = new SwingWorker<List<AssociaPerfilPermissao>, Object>() {
        
        @Override
        protected List<AssociaPerfilPermissao> doInBackground() throws Exception {
            habilitaTelaAguarde(formLogin);
            try {
                Usuario user = formLogin.getUser();
                return new PerfilServerImpl<Perfil>().recPermissoesPorPerfil(user.getPerfil());
            } catch (Exception ex) {
                desabilitaTelaAguarde(formLogin);
                throw ex;
            }
        }
        
        protected void done() {
            desabilitaTelaAguarde(formLogin);
            try {
                if (get() != null) {
                    List<AssociaPerfilPermissao> lst = (List<AssociaPerfilPermissao>) get();
                    if (lst != null) {
                        formLogin.setControleAcesso(lst);
                    }
                }
            } catch (Exception ex) {
                LogUtil.logDescricaoErro(formLogin.getClass(), ex);
                JOptionPane.showMessageDialog(formLogin, MessagePerfil.ERRO_CONSULTA_ASSOCIA_PERFIL_PERMISSAO, "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    };
}
