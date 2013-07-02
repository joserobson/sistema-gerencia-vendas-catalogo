/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.model.pedido;

import br.com.dcoracoes.server.model.cadastro.Revendedor;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author Robson
 */
@Entity
@DiscriminatorValue("PedidoVenda")
public class PedidoVenda extends Pedido {

    @Column(name = "valor_pedido_escrito")
    private float valorPedidoEscrito;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_revendedor", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Revendedor revendedor;
    @OneToOne
    @JoinColumn(name = "id_pagamento")
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
