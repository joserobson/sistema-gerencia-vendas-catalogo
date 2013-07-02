/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.teste.dcoracoes.beans;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Robson
 */
public class Produto implements Serializable {

    private Long id;
    private String codigoBarra;
    private String codigoForFiscal;
    private String codigoProFiscal;
    private String descricao;
    private int estoqueTotal;
    private String referenciaCatalogo;
    private float valorCusto;
    private float valorVenda;
    private Fornecedor fornecedor;
    private List<ItemProduto> listaItensProduto;
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
