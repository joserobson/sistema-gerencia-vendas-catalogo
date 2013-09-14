/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.swingworker;

import br.com.dcoracoes.client.Excecao.ClientDCoracoesException;
import br.com.dcoracoes.client.classes.serverimpl.UtilServerImpl;
import br.com.dcoracoes.client.telas.login.FormLogin;
import br.com.dcoracoes.client.util.LogUtil;
import br.com.dcoracoes.client.util.MensagensUtil;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author Jose Robson
 */
public class SwingWorkerLogin extends BaseSwingWorker<Object> {
    
    private FormLogin formLogin;

    public void setFormLogin(FormLogin formLogin) {
        this.formLogin = formLogin;
    }
    
    
    
    public SwingWorker<Boolean, Object> workCarregarSistema = new SwingWorker<Boolean, Object>(){

        @Override
        protected Boolean doInBackground() throws Exception {
            habilitaTelaAguarde(formLogin,"Conectando ao Servidor...");
            return testaConexaoComBanco();            
        }

        @Override
        protected void done() {
            try {
                desabilitaTelaAguarde(formLogin);
                if (get())
                {
                    formLogin.showFrame();
                }            
            }catch(Exception ex)
            {
                desabilitaTelaAguarde(formLogin);
                LogUtil.logDescricaoErro(formLogin.getClass(), ex);
                JOptionPane.showMessageDialog(formLogin, MensagensUtil.MENSAGEM_ERRO_CONECTAR_BANCO, MensagensUtil.ERRO, 0);
                System.exit(0);
            }
        }                    
    };
    
    
    /**
     * Teste Conexao
     */
    private Boolean testaConexaoComBanco() throws ClientDCoracoesException {
        UtilServerImpl utilServer = new UtilServerImpl();
        try {
            LogUtil.logInformacao("TESTANDO CONEXAO COM BANCO DE DADOS");
            
            /*if (!utilServer.testeConexaoBanco()) {
                JOptionPane.showMessageDialog(formLogin, MensagensUtil.MENSAGEM_ERRO_CONECTAR_BANCO, MensagensUtil.ERRO, 0);
                System.exit(0);
            }*/
            return utilServer.testeConexaoBanco();
                        
        } catch (ClientDCoracoesException ex) {                    
            throw ex;
        }

    }
}
