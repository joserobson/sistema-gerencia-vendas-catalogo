/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.relatorios;

/**
 *
 * @author Robson
 */
public class RelatorioCompletoVenda extends RelatorioCompleto {

    private String numeroOrcamento;
    private String codigoConsultora;
    private String codigoConFiscal;
    private String notaFiscal;
    private String nome;
    private String cidadeEstado;
    private String endereco;
    private String cep;
    private String cpf;
    private String desconto25;

    public String getDesconto25() {
        return desconto25;
    }

    public void setDesconto25(String desconto25) {
        this.desconto25 = desconto25;
    }

    public RelatorioCompletoVenda() {
    }

    public String getCodigoConFiscal() {
        return codigoConFiscal;
    }

    public void setCodigoConFiscal(String codigoConFiscal) {
        this.codigoConFiscal = codigoConFiscal;
    }

    public String getCodigoConsultora() {
        return codigoConsultora;
    }

    public void setCodigoConsultora(String codigoConsultora) {
        this.codigoConsultora = codigoConsultora;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidadeEstado() {
        return cidadeEstado;
    }

    public void setCidadeEstado(String cidadeEstado) {
        this.cidadeEstado = cidadeEstado;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(String notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public String getNumeroOrcamento() {
        return numeroOrcamento;
    }

    public void setNumeroOrcamento(String numeroOrcamento) {
        this.numeroOrcamento = numeroOrcamento;
    }
}
