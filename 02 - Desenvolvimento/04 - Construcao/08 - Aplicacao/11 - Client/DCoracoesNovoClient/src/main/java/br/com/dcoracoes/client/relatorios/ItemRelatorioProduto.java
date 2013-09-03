/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.relatorios;

import java.util.List;

/**
 *
 * @author Cleberson
 */
public class ItemRelatorioProduto {
    
    private List<ItemRelatorioItensProduto> listaItensProduto;
    private String totalItensProduto;

    public List<ItemRelatorioItensProduto> getListaItensProduto() {
        return listaItensProduto;
    }

    public void setListaItensProduto(List<ItemRelatorioItensProduto> listaItensProduto) {
        this.listaItensProduto = listaItensProduto;
    }

    public String getTotalItensProduto() {
        return totalItensProduto;
    }

    public void setTotalItensProduto(String totalItensProduto) {
        this.totalItensProduto = totalItensProduto;
    }
    
}
