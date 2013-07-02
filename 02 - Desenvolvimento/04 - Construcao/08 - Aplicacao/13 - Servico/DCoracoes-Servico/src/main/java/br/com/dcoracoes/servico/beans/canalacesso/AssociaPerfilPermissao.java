/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.servico.beans.canalacesso;


import java.io.Serializable;

/**
 *
 * @author Robson
 */
public class AssociaPerfilPermissao implements Serializable {

    private AssociaPerfilPermissaoFK chaveComposta;
    private boolean status;

    public AssociaPerfilPermissaoFK getChaveComposta() {
        return chaveComposta;
    }

    public void setChaveComposta(AssociaPerfilPermissaoFK chaveComposta) {
        this.chaveComposta = chaveComposta;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
