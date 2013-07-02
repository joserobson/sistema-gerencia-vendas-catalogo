/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.classes.serverimpl;

import br.com.dcoracoes.client.Excecao.ClientDCoracoesException;
import br.com.dcoracoes.servico.service.AssociaPerfilPermissao;
import br.com.dcoracoes.servico.service.Perfil;
import java.util.List;

/**
 *
 * @author Jose Robson
 */
interface IPerfilImpl<T> {

   public List<AssociaPerfilPermissao> recPermissoesPorPerfil(Perfil perfil) throws ClientDCoracoesException; 
}
