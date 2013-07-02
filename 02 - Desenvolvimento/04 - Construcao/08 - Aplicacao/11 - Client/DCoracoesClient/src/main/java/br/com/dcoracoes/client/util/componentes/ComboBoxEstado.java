/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.util.componentes;

import br.com.dcoracoes.client.enuns.Enum_UF;

/**
 *
 * @author Cléberson
 */
public class ComboBoxEstado extends javax.swing.JComboBox{

    public ComboBoxEstado() {
        super();
        populaEstados();
    }
    
    private void populaEstados(){
        this.addItem(Enum_UF.selecione);
        this.addItem(Enum_UF.AC);
        this.addItem(Enum_UF.AL);
        this.addItem(Enum_UF.AM);
        this.addItem(Enum_UF.AP);
        this.addItem(Enum_UF.BA);
        this.addItem(Enum_UF.CE);
        this.addItem(Enum_UF.DF);
        this.addItem(Enum_UF.ES);
        this.addItem(Enum_UF.GO);
        this.addItem(Enum_UF.MA);
        this.addItem(Enum_UF.MG);
        this.addItem(Enum_UF.MS);
        this.addItem(Enum_UF.MT);
        this.addItem(Enum_UF.PA);
        this.addItem(Enum_UF.PB);
        this.addItem(Enum_UF.PE);
        this.addItem(Enum_UF.PI);
        this.addItem(Enum_UF.PR);
        this.addItem(Enum_UF.RJ);
        this.addItem(Enum_UF.RN);
        this.addItem(Enum_UF.RO);
        this.addItem(Enum_UF.RR);
        this.addItem(Enum_UF.RS);
        this.addItem(Enum_UF.SC);
        this.addItem(Enum_UF.SE);
        this.addItem(Enum_UF.SP);
        this.addItem(Enum_UF.TO);        
    }
}
