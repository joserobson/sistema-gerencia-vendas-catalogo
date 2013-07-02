/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.bo.canalacesso;

import br.com.dcoracoes.server.dao.canalacesso.AssociaPerfilPermissaoDao;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.canalacesso.AssociaPerfilPermissao;
import br.com.dcoracoes.server.model.canalacesso.Perfil;
import java.util.List;

/**
 *
 * @author Robson
 */
public interface AssociaPerfilPermissaoBo<T extends AssociaPerfilPermissao> {

    public void setDao(AssociaPerfilPermissaoDao dao);

    public void mantemAssociaPerfilPermissao(T associaPerfilPermissao) throws ServerException;

    public List<T> recPermissoesPorPerfil(Perfil p) throws ServerException;
}
