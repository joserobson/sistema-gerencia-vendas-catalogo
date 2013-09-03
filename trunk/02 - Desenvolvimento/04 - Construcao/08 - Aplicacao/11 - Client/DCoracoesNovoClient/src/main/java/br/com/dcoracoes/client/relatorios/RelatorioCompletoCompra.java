    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.relatorios;

/**
 *
 * @author Robson
 */
public class RelatorioCompletoCompra extends RelatorioCompleto {

    private String fornecedor;
    private String descontoEmPorcentagem;
    private String descontoEmDinheiro;

    public RelatorioCompletoCompra() {
    }

    public String getDescontoEmDinheiro() {
        return descontoEmDinheiro;
    }

    public void setDescontoEmDinheiro(String descontoEmDinheiro) {
        this.descontoEmDinheiro = descontoEmDinheiro;
    }

    public String getDescontoEmPorcentagem() {
        return descontoEmPorcentagem;
    }

    public void setDescontoEmPorcentagem(String descontoEmPorcentagem) {
        this.descontoEmPorcentagem = descontoEmPorcentagem;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
}
