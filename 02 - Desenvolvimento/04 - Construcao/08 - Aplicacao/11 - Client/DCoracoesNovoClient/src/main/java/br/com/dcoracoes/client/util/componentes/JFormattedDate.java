/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.util.componentes;

import javax.swing.JFormattedTextField;

/**
 *
 * @author rerum
 */
public class JFormattedDate extends JFormattedTextField{

    public JFormattedDate() {        
        this.setDocument(new DateDocument());
    }
    
}
