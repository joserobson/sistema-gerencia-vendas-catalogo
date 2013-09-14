package br.com.dcoracoes.client;


import br.com.dcoracoes.client.swingworker.SwingWorkerLogin;
import br.com.dcoracoes.client.telas.login.FormLogin;
import br.com.dcoracoes.client.telas.principal.FormPrincipal;
import br.com.dcoracoes.client.util.LogUtil;
import br.com.dcoracoes.client.util.MensagensUtil;
import br.com.dcoracoes.servico.service.Usuario;
import java.net.ServerSocket;
import javax.swing.JOptionPane;

/**
 * Hello world!
 *
 */
public class App {

    /**
     * mantem o usuario logado no sistema
     */
    public static Usuario userLog;
    public static FormPrincipal formPrincipal;
    private static final int RUN_PORT = 8666;
    private static ServerSocket ss;

    public static Usuario getUserLog() {
        return userLog;
    }

    public static void setUserLog(Usuario userLog) {
        App.userLog = userLog;
    }

    public static void main(String[] av) {
        try {
            LogUtil.logInformacao("INICIANDO APLICACAO");
            ss = new ServerSocket(RUN_PORT);
            FormLogin form = new FormLogin();
            
            SwingWorkerLogin work = new SwingWorkerLogin();
            work.setFormLogin(form);
            work.workCarregarSistema.execute();
            
                        
        } catch (java.io.IOException ex) {
            System.out.println("Programa está rodando! " + ex.getMessage());  
            LogUtil.logDescricaoErro(App.class, ex);
            JOptionPane.showMessageDialog(null, "UMA INSTÂNCIA DO PROGRAMA JÁ ESTÁ EM EXECUÇÃO!!", MensagensUtil.ERRO, 0);
            System.exit(0);
        }
    }

    public static void testarRelatorio() {
//        try {
//            testeRelatorio teste = new testeRelatorio();
//            teste.exibirRelatorioCompletoVenda();
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
    }
}
