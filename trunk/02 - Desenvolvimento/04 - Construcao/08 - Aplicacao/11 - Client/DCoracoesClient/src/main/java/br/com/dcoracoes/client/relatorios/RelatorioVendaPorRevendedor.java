/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.relatorios;

import java.util.List;

/**
 *
 * @author Cléberson
 */
public class RelatorioVendaPorRevendedor {
    
    private List<ItemRelatorioVendaPorRevendedor> listaItens;

    public RelatorioVendaPorRevendedor() {
    }

    public List<ItemRelatorioVendaPorRevendedor> getListaItens() {
        return listaItens;
    }

    public void setListaItens(List<ItemRelatorioVendaPorRevendedor> listaItens) {
        this.listaItens = listaItens;
    }
    
    
}
