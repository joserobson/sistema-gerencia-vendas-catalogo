package br.com.dcoracoes.servico.beans.pedido;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * @author Robson
 * @version 1.0 @created 16-mai-2012 22:42:14
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ItemPedido implements Serializable {

    private long id;
    private String cor;
    private String descricao;
    private int quantidade;
    private float valorUnitario;
    private long idItemProduto;
    private CodigoItem codigo;
    private float valorTotal;
    private String CorPorExtenso;
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