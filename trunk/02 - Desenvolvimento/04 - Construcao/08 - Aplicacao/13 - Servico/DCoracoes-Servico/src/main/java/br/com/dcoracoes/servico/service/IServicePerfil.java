/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.servico.service;

import br.com.dcoracoes.servico.beans.canalacesso.AssociaPerfilPermissao;
import br.com.dcoracoes.servico.beans.canalacesso.Perfil;
import java.util.List;

/**
 *
 * @author Jose Robson
 */
public interface IServicePerfil<T extends Perfil> {

    public List<AssociaPerfilPermissao> recPermissoesPorPerfil(Perfil perfil) throws Exception;
}
