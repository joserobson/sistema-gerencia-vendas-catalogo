package br.com.dcoracoes.servico.beans.cadastro;

import java.io.Serializable;
import java.util.Date;

public class Revendedor implements Serializable {

    private Long id;
    private int codigo;
    private String codigoConFiscal;
    private Date dataCadastro;
    private Date dataUltimaCompra;
    private float limiteCredito;
    private float limiteEmUso;
    private float limiteUtilizavel;
    private String numeroNotaFiscal;
    private String observacoes;
    private int situacao;
    private Pessoa pessoa;

    public Revendedor() {
        super();
    }

    public void finalize() throws Throwable {
        super.finalize();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCodigoConFiscal() {
        return codigoConFiscal;
    }

    public void setCodigoConFiscal(String codigoConFiscal) {
        this.codigoConFiscal = codigoConFiscal;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataUltimaCompra() {
        return dataUltimaCompra;
    }

    public void setDataUltimaCompra(Date dataUltimaCompra) {
        this.dataUltimaCompra = dataUltimaCompra;
    }

    public float getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(float limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public float getLimiteEmUso() {
        return limiteEmUso;
    }

    public void setLimiteEmUso(float limiteEmUso) {
        this.limiteEmUso = limiteEmUso;
    }

    public float getLimiteUtilizavel() {
        return limiteUtilizavel;
    }

    public void setLimiteUtilizavel(float limiteUtilizavel) {
        this.limiteUtilizavel = limiteUtilizavel;
    }

    public String getNumeroNotaFiscal() {
        return numeroNotaFiscal;
    }

    public void setNumeroNotaFiscal(String numeroNotaFiscal) {
        this.numeroNotaFiscal = numeroNotaFiscal;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    /*
     * public List getListaPedidos() { return listaPedidos; }
     *
     * public void setListaPedidos(List listaPedidos) { this.listaPedidos =
     * listaPedidos;
    }
     */
}
