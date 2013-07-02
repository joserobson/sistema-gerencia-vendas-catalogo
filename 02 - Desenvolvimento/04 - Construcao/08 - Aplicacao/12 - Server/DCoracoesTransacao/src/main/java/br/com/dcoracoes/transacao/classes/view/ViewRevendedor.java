/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.transacao.classes.view;

import br.com.dcoracoes.server.model.cadastro.PessoaFisica;
import br.com.dcoracoes.server.model.cadastro.Revendedor;
import java.util.List;

/**
 *
 * @author Robson
 */
public class ViewRevendedor {

    private Revendedor revendedor;
    private PessoaFisica conjugue;
    private List<ViewInfComplementaresRevendedor> lstInformacoesComplementares;
    

    public ViewRevendedor() {
    }

    public ViewRevendedor(Revendedor revendedor, PessoaFisica conjugue, List<ViewInfComplementaresRevendedor> lstInformacoesComplementares) {
        this.revendedor = revendedor;
        this.conjugue = conjugue;
        this.lstInformacoesComplementares = lstInformacoesComplementares;
    }

    public PessoaFisica getConjugue() {
        return conjugue;
    }

    public void setConjugue(PessoaFisica conjugue) {
        this.conjugue = conjugue;
    }

    public Revendedor getRevendedor() {
        return revendedor;
    }

    public void setRevendedor(Revendedor revendedor) {
        this.revendedor = revendedor;
    }

    public List<ViewInfComplementaresRevendedor> getLstInformacoesComplementares() {
        return lstInformacoesComplementares;
    }

    public void setLstInformacoesComplementares(List<ViewInfComplementaresRevendedor> lstInformacoesComplementares) {
        this.lstInformacoesComplementares = lstInformacoesComplementares;
    }
          
}
