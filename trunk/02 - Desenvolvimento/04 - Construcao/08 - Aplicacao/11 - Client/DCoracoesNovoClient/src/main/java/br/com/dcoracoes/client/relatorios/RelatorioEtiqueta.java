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
public class RelatorioEtiqueta {
        
    private List<ItemRelatorioEtiqueta> listaItens;

    public RelatorioEtiqueta() {        
    }

    public List<ItemRelatorioEtiqueta> getListaItens() {
        return listaItens;
    }

    public void setListaItens(List<ItemRelatorioEtiqueta> listaItens) {
        this.listaItens = listaItens;
    }
    
    
}
