/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.util.componentes;

import br.com.dcoracoes.client.util.MonetarioDocument;
import javax.swing.JFormattedTextField;

/**
 * Componente para criar um campo para digitar valor moeda
 * @author rerum
 */
public class JFormattedMoeda extends JFormattedTextField{

    public JFormattedMoeda() {        
        this.setDocument(new MonetarioDocument());
        this.setHorizontalAlignment(javax.swing.JTextField.RIGHT);        
    }
    
    
}
