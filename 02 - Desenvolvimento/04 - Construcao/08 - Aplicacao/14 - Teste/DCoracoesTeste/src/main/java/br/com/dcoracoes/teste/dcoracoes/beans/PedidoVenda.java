/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.teste.dcoracoes.beans;

import br.com.dcoracoes.server.model.cadastro.Revendedor;

/**
 *
 * @author Robson
 */
public class PedidoVenda extends Pedido {

    private float valorPedidoEscrito;
    private Revendedor revendedor;
    private Pagamento pagamento;

    public PedidoVenda() {
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Revendedor getRevendedor() {
        return revendedor;
    }

    public void setRevendedor(Revendedor revendedor) {
        this.revendedor = revendedor;
    }

    public float getValorPedidoEscrito() {
        return valorPedidoEscrito;
    }

    public void setValorPedidoEscrito(float valorPedidoEscrito) {
        this.valorPedidoEscrito = valorPedidoEscrito;
    }
}
