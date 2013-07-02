/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.relatorios;

import java.util.List;

/**
 *
 * @author Robson
 */
public class RelatorioCompleto {

    private String data;
    private String subTotal;
    private String total;
    private String totalItensPedido;
    private List<ItemRelatorioCompleto> listaItens;

    public List<ItemRelatorioCompleto> getListaItens() {
        return listaItens;
    }

    public void setListaItens(List<ItemRelatorioCompleto> listaItens) {
        this.listaItens = listaItens;
    }

    public RelatorioCompleto() {
    }

    public String getTotalItensPedido() {
        return totalItensPedido;
    }

    public void setTotalItensPedido(String totalItensPedido) {
        this.totalItensPedido = totalItensPedido;
    }

    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
