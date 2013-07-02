/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.relatorios;

/**
 *
 * @author Robson
 */
public class ItemRelatorio {

    private String referenciaCatalogo;
    private String quantidade;
    private String descricao;
    private String cor;
    private String corPorExtenso;

    public String getCorPorExtenso() {
        return corPorExtenso;
    }

    public void setCorPorExtenso(String corPorExtenso) {
        this.corPorExtenso = corPorExtenso;
    }

    public ItemRelatorio() {
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

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getReferenciaCatalogo() {
        return referenciaCatalogo;
    }

    public void setReferenciaCatalogo(String referenciaCatalogo) {
        this.referenciaCatalogo = referenciaCatalogo;
    }
}
