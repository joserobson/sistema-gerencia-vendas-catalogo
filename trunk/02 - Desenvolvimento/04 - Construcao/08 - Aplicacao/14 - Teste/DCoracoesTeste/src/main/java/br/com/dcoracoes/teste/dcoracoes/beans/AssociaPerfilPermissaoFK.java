/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.teste.dcoracoes.beans;

import java.io.Serializable;

/**
 *
 * @author Robson
 */
public class AssociaPerfilPermissaoFK implements Serializable {

    private Perfil perfil;
    private Permissao permissao;

    public AssociaPerfilPermissaoFK() {
    }

    public AssociaPerfilPermissaoFK(Perfil perfil, Permissao permissao) {
        this.perfil = perfil;
        this.permissao = permissao;
    }

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
