/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.servico.beans.pedido;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Robson
 */
public class Pagamento implements Serializable {

    private Long id;
    private int formaPagamento;
    private float valor;
    private List<Parcela> listaParcelas;
    private float bonus;
    private float valorDinheiro;

    public int getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(int formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Parcela> getListaParcelas() {
        return listaParcelas;
    }

    public void setListaParcelas(List<Parcela> listaParcelas) {
        this.listaParcelas = listaParcelas;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

    public float getValorDinheiro() {
        return valorDinheiro;
    }

    public void setValorDinheiro(float valorDinheiro) {
        this.valorDinheiro = valorDinheiro;
    }
}
