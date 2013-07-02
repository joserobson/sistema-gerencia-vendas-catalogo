package br.com.dcoracoes.teste.dcoracoes.beans;

import java.util.Date;

/**
 * @author Jose Robson
 * @version 1.0 @created 06-mar-2012 18:42:29
 */
public class PessoaFisica extends Pessoa {

    private String cpf;
    private Date dataNascimento;
    private int estadoCivil;
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
