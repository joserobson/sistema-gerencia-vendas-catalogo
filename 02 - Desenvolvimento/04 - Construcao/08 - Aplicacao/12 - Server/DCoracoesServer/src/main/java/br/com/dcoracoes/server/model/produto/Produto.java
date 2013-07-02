/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.model.produto;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Robson
 */
@Entity
@Table(name = "tb_produto")
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "codigo_barra")
    private String codigoBarra;
    @Column(name = "codigo_for_fiscal")
    private String codigoForFiscal;
    @Column(name = "codigo_pro_fiscal")
    private String codigoProFiscal;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "estoque_total")
    private int estoqueTotal;
    @Column(name = "referencia_catalogo")
    private String referenciaCatalogo;
    @Column(name = "valor_custo")
    private float valorCusto;
    @Column(name = "valor_venda")
    private float valorVenda;
    @OneToOne
    @JoinColumn(name = "id_fornecedor")
    private Fornecedor fornecedor;
    @OneToMany(mappedBy = "produto", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<ItemProduto> listaItensProduto;
    
    @Transient
    private Boolean estoqueBaixo = null;

    public Boolean getEstoqueBaixo() {
        return estoqueBaixo;
    }

    public void setEstoqueBaixo(Boolean estoqueBaixo) {
        this.estoqueBaixo = estoqueBaixo;
    }

    public List<ItemProduto> getListaItensProduto() {
        return listaItensProduto;
    }

    public void setListaItensProduto(List<ItemProduto> listaItensProduto) {
        this.listaItensProduto = listaItensProduto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getCodigoForFiscal() {
        return codigoForFiscal;
    }

    public void setCodigoForFiscal(String codigoForFiscal) {
        this.codigoForFiscal = codigoForFiscal;
    }

    public String getCodigoProFiscal() {
        return codigoProFiscal;
    }

    public void setCodigoProFiscal(String codigoProFiscal) {
        this.codigoProFiscal = codigoProFiscal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getEstoqueTotal() {
        return estoqueTotal;
    }

    public void setEstoqueTotal(int estoqueTotal) {
        this.estoqueTotal = estoqueTotal;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getReferenciaCatalogo() {
        return referenciaCatalogo;
    }

    public void setReferenciaCatalogo(String referenciaCatalogo) {
        this.referenciaCatalogo = referenciaCatalogo;
    }

    public float getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(float valorCusto) {
        this.valorCusto = valorCusto;
    }

    public float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }
}
