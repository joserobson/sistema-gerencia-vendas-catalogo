/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.model.pedido;

import br.com.dcoracoes.server.model.produto.Fornecedor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.*;

/**
 *
 * @author Robson
 */
@Entity
@DiscriminatorValue("PedidoCompra")
public class PedidoCompra extends Pedido {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_fornecedor", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
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
