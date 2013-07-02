/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.bo.canalacesso;

import br.com.dcoracoes.server.dao.canalacesso.PerfilDao;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.canalacesso.AssociaPerfilPermissao;
import br.com.dcoracoes.server.model.canalacesso.Perfil;
import java.util.List;

/**
 *
 * @author Robson
 */
public interface PerfilBo<T extends Perfil> {

    public void setPerfilDao(PerfilDao perfilDao);

    public void mantemPerfil(Perfil perfil, List<AssociaPerfilPermissao> lstAssociaPerfilPermissao) throws ServerException;

    public T getPerfilPorId(Long id) throws ServerException;

    public List<T> recPerfil(T perfil) throws ServerException;
}
