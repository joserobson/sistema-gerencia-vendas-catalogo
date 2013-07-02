/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.model.canalacesso;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Robson
 */
@Entity
@Table(name = "tb_associa_perfil_permissao")
public class AssociaPerfilPermissao implements Serializable {

    @EmbeddedId
    private AssociaPerfilPermissaoFK chaveComposta;
    @Column(name = "status")
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
