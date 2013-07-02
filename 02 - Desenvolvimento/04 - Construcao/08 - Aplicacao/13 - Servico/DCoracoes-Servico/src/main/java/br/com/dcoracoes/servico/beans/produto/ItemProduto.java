/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.servico.beans.produto;

import java.io.Serializable;

/**
 *
 * @author Robson
 */
public class ItemProduto implements Serializable {

    private Long id;
    private int estoqueMinimo;
    private int EstoqueAtual;
    private Produto produto;
    private Cor Cor;

    public Cor getCor() {
        return Cor;
    }

    public void setCor(Cor Cor) {
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
