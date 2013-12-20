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
    
    private String valorTotal;
    private List<ItemRelatorioVendaPorRevendedor> listaItens;

    public RelatorioVendaPorRevendedor() {
    }

    public List<ItemRelatorioVendaPorRevendedor> getListaItens() {
        return listaItens;
    }

    public void setListaItens(List<ItemRelatorioVendaPorRevendedor> listaItens) {
        this.listaItens = listaItens;
    }    

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }
    
}
