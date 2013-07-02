/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.teste.dcoracoes.beans;


/**
 *
 * @author Robson
 */
public class PedidoCompra extends Pedido {

    private Fornecedor fornecedor;

    public PedidoCompra() {
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}
