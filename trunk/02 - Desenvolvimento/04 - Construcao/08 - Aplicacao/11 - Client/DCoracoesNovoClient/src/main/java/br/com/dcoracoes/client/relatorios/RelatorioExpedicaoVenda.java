/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.relatorios;

/**
 *
 * @author Cléberson
 */
public class RelatorioExpedicaoVenda extends RelatorioExpedicao{


    private String codigoConsultor;
    private String codigoConFiscal;
    private String codigoNotaFiscal;
    private String nome;
    private String cidadeEstado;
    private String endereco;
    private String cep;
    private String cpf;

    public RelatorioExpedicaoVenda() {
    }

    public String getCodigoConsultor() {
        return codigoConsultor;
    }

    public void setCodigoConsultor(String codigoConsultor) {
        this.codigoConsultor = codigoConsultor;
    }
    
    public String getCodigoConFiscal() {
        return codigoConFiscal;
    }

    public void setCodigoConFiscal(String codigoConFiscal) {
        this.codigoConFiscal = codigoConFiscal;
    }

    public String getCodigoNotaFiscal() {
        return codigoNotaFiscal;
    }

    public void setCodigoNotaFiscal(String codigoNotaFiscal) {
        this.codigoNotaFiscal = codigoNotaFiscal;
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
}
