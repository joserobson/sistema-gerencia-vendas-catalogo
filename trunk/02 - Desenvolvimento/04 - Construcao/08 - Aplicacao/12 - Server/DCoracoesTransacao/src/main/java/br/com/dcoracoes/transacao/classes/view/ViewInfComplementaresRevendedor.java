/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dcoracoes.transacao.classes.view;

import br.com.dcoracoes.server.model.cadastro.Pessoa;
import br.com.dcoracoes.server.model.cadastro.PessoaFisica;
import br.com.dcoracoes.server.model.movimento.MovimentoConta;

/**
 *
 * @author Robson
 */
public class ViewInfComplementaresRevendedor {
  private MovimentoConta contaBancaria;
  private PessoaFisica primeiroTitular;
  private String grauParentescoPrimeiroTitular;
  private Pessoa segundoTitular;
  private String grauParentescoSegundoTitular;

    public ViewInfComplementaresRevendedor() {
    }

    public ViewInfComplementaresRevendedor(MovimentoConta contaBancaria, PessoaFisica primeiroTitular, String grauParentescoPrimeiroTitular, PessoaFisica segundoTitular, String graulParentescoSegundoTitular) {
        this.contaBancaria = contaBancaria;
        this.primeiroTitular = primeiroTitular;
        this.grauParentescoPrimeiroTitular = grauParentescoPrimeiroTitular;
        this.segundoTitular = segundoTitular;
        this.grauParentescoSegundoTitular = graulParentescoSegundoTitular;
    }

    public MovimentoConta getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(MovimentoConta contaBancaria) {
        this.contaBancaria = contaBancaria;
    }

    public String getGrauParentescoPrimeiroTitular() {
        return grauParentescoPrimeiroTitular;
    }

    public void setGrauParentescoPrimeiroTitular(String grauParentescoPrimeiroTitular) {
        this.grauParentescoPrimeiroTitular = grauParentescoPrimeiroTitular;
    }

    public String getGraulParentescoSegundoTitular() {
        return grauParentescoSegundoTitular;
    }

    public void setGraulParentescoSegundoTitular(String graulParentescoSegundoTitular) {
        this.grauParentescoSegundoTitular = graulParentescoSegundoTitular;
    }

    public PessoaFisica getPrimeiroTitular() {
        return primeiroTitular;
    }

    public void setPrimeiroTitular(PessoaFisica primeiroTitular) {
        this.primeiroTitular = primeiroTitular;
    }

    public Pessoa getSegundoTitular() {
        return segundoTitular;
    }

    public void setSegundoTitular(Pessoa segundoTitular) {
        this.segundoTitular = segundoTitular;
    }

  

}
