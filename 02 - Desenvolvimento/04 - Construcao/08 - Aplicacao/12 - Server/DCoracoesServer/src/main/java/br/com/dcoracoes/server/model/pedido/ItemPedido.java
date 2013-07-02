package br.com.dcoracoes.server.model.pedido;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * @author Robson
 * @version 1.0
 * @created 16-mai-2012 22:42:14
 */
@Entity
@Table(name = "tb_item_pedido")
public class ItemPedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "cor")
    private String cor;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "quantidade")
    private int quantidade;
    @Column(name = "valor_unitario")
    private float valorUnitario;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pedido", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    public Pedido pedido;
    @Column(name = "id_item_produto")
    private long idItemProduto;
    @OneToOne
    @JoinColumn(name = "id_codigo_item")
    private CodigoItem codigo;
    @Column(name = "valor_total")
    private float valorTotal;
    @Column(name = "cor_extenso")
    private String CorPorExtenso;
    @Column(name = "codigo_fiscal")
    private String codigoFiscal;

    public ItemPedido() {
    }

    public CodigoItem getCodigo() {
        return codigo;
    }

    public void setCodigo(CodigoItem codigo) {
        this.codigo = codigo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public long getIdItemProduto() {
        return idItemProduto;
    }

    public void setIdItemProduto(long idItemProduto) {
        this.idItemProduto = idItemProduto;
    }

    public String getCorPorExtenso() {
        return CorPorExtenso;
    }

    public void setCorPorExtenso(String CorPorExtenso) {
        this.CorPorExtenso = CorPorExtenso;
    }

    public String getCodigoFiscal() {
        return codigoFiscal;
    }

    public void setCodigoFiscal(String codigoFiscal) {
        this.codigoFiscal = codigoFiscal;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
}