/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.model.produto;

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
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * 
 * @author Robson
 */
@Entity
@Table(name = "tb_item_produto")
public class ItemProduto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "estoque_minimo")
    private int estoqueMinimo;
    @Column(name = "estoque_atual")
    private int EstoqueAtual;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_produto", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Produto produto;
    @OneToOne
    @JoinColumn(name = "id_cor")
    private Cor Cor;

    public br.com.dcoracoes.server.model.produto.Cor getCor() {
        return Cor;
    }

    public void setCor(br.com.dcoracoes.server.model.produto.Cor Cor) {
        this.Cor = Cor;
    }

    public int getEstoqueAtual() {
        return EstoqueAtual;
    }

    public void setEstoqueAtual(int EstoqueAtual) {
        this.EstoqueAtual = EstoqueAtual;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
