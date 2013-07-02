/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.model.canalacesso;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Robson
 */
@Embeddable
public class AssociaPerfilPermissaoFK implements Serializable {

    public AssociaPerfilPermissaoFK() {
    }
    
    public AssociaPerfilPermissaoFK(Perfil perfil, Permissao permissao){
        setPerfil(perfil);
        setPermissao(permissao);
    }
    
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="id_perfil")
    private Perfil perfil;
    
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="id_permissao")           
    private Permissao permissao;

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }
}
