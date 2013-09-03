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
public class RelatorioExpedicao {

    private String numeroOrcamento;
    private String data;
    private String totalItensPedido;
    private List<ItemRelatorioExpedicao> listaItens;

    public RelatorioExpedicao() {
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

    public List<ItemRelatorioExpedicao> getListaItens() {
        return listaItens;
    }

    public void setListaItens(List<ItemRelatorioExpedicao> listaItens) {
        this.listaItens = listaItens;
    }

    public String getNumeroOrcamento() {
        return numeroOrcamento;
    }

    public void setNumeroOrcamento(String numeroOrcamento) {
        this.numeroOrcamento = numeroOrcamento;
    }
}
