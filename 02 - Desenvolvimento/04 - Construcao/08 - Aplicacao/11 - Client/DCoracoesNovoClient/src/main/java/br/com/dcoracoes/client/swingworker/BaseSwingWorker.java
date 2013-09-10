/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.swingworker;

import br.com.dcoracoes.client.telas.dialog.JDialogProcessando;
import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Jose Robson
 */
public class BaseSwingWorker<T>//<T, V> extends SwingWorker<T, Object> {
{

    protected JDialogProcessando aguarde;

    protected void habilitaTelaAguarde(JFrame frame, String msg) {
        if (this.aguarde == null) {
            aguarde = new JDialogProcessando(frame, "Aguarde...", msg);
        }
        desabilitaComponentesTela(frame);
        aguarde.setVisible(true);
    }
    
    
    protected void habilitaTelaAguarde(JFrame frame) {
        if (this.aguarde == null) {
            aguarde = new JDialogProcessando(frame, "Aguarde...", "Aguarde Processando...");
        }
        desabilitaComponentesTela(frame);
        aguarde.setVisible(true);
    }

    public void habilitaTelaAguarde(JDialog frame) {
        if (this.aguarde == null) {
            aguarde = new JDialogProcessando(frame, "Aguarde...", "Aguarde Processando...");
        }
        desabilitaComponentesTela(frame);
        aguarde.setVisible(true);

    }

    public void habilitaTelaAguarde(Window frame) {
        if (this.aguarde == null) {
            aguarde = new JDialogProcessando(frame, "Aguarde...", "Aguarde Processando...");
        }
        desabilitaComponentesTela(frame);
        aguarde.setVisible(true);

    }

    public void desabilitaTelaAguarde(Window frame) {
        if (this.aguarde != null) {
            aguarde.setVisible(false);
        }
        habilitaComponentesTela(frame);
    }

    public void habilitaComponentesTela(Window frame) {
        frame.setEnabled(true);
    }

    public void desabilitaComponentesTela(Window frame) {
        frame.setEnabled(false);
    }
}
