package br.com.dcoracoes.server.model.cadastro;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * @author Jose Robson
 * @version 1.0
 * @created 06-mar-2012 18:42:53
 */
@Entity
@Table(name = "tb_revendedor")
public class Revendedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "codigo")
    private int codigo;
    @Column(name = "codigo_confiscal")
    private String codigoConFiscal;
    @Column(name = "data_cadastro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataCadastro;
    @Column(name = "data_ultima_compra")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataUltimaCompra;
    @Column(name = "limite_credito")
    private float limiteCredito;
    @Column(name = "limite_emuso")
    private float limiteEmUso;
    @Column(name = "limite_utilizavel")
    private float limiteUtilizavel;
    @Column(name = "numero_nota_fiscal")
    private String numeroNotaFiscal;
    @Column(name = "observacoes")
    private String observacoes;
    @Column(name = "id_situacao")
    private int situacao;
    @OneToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;
    //@OneToMany(mappedBy = "revendedor", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    //private List<Pedido> listaPedidos;

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

   /* public List getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List listaPedidos) {
        this.listaPedidos = listaPedidos;
    }*/
}
