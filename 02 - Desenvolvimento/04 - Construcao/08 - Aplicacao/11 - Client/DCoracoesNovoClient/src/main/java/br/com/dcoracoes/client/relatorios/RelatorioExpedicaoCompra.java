/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.relatorios;

/**
 *
 * @author Cléberson
 */
public class RelatorioExpedicaoCompra extends RelatorioExpedicao{


    private String fornecedor;

    public RelatorioExpedicaoCompra() {
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    
}
