package br.com.dcoracoes.server.model.pedido;

import br.com.dcoracoes.server.model.cadastro.Revendedor;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * @author Robson
 * @version 1.0
 * @created 16-mai-2012 22:42:15
 */
@Entity
@Table(name = "tb_pedido")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "classe_name", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Pedido")
public class Pedido implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "data_pedido")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataPedido;
    @Column(name = "desconto_dinheiro")
    private float descontoDinheiro;
    @Column(name = "desconto_porcentagem")
    private float descontoPorcentagem;
    @Column(name = "sub_total")
    private float subTotal;
    @Column(name = "total")
    private float total;
    @OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<ItemPedido> listaItensPedido;

    public Pedido() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public float getDescontoDinheiro() {
        return descontoDinheiro;
    }

    public void setDescontoDinheiro(float descontoDinheiro) {
        this.descontoDinheiro = descontoDinheiro;
    }

    public float getDescontoPorcentagem() {
        return descontoPorcentagem;
    }

    public void setDescontoPorcentagem(float descontoPorcentagem) {
        this.descontoPorcentagem = descontoPorcentagem;
    }

    public List<ItemPedido> getListaItensPedido() {
        return listaItensPedido;
    }

    public void setListaItensPedido(List<ItemPedido> listaItensPedido) {
        this.listaItensPedido = listaItensPedido;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}