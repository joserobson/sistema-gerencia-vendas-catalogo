 package br.com.dcoracoes.server.model.cadastro;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;

/**
 * @author Jose Robson
 * @version 1.0
 * @created 06-mar-2012 18:42:29
 */
@Entity
@DiscriminatorValue("PessoaFisica")
public class PessoaFisica extends Pessoa {

    @Column(name="cpf")
    private String cpf;
    @Column(name="data_nascimento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;
    @Column(name="id_estado_civil")
    private int estadoCivil;
    @Column(name="identidade")
    private String identidade;

    public PessoaFisica() {
        super();
        this.cpf = null;
        this.dataNascimento = null;        
        this.identidade = null;
    }

    public void finalize() throws Throwable {
        super.finalize();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(int estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }
}
