package br.com.dcoracoes.servico.beans.pedido;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Robson
 * @version 1.0 @created 16-mai-2012 22:42:15
 */
public class Pedido implements Serializable {

    private Long id;
    private String codigo;
    private Date dataPedido;
    private float descontoDinheiro;
    private float descontoPorcentagem;
    private float subTotal;
    private float total;
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