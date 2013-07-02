/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.dao.canalacesso;

import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.canalacesso.AssociaPerfilPermissao;
import br.com.dcoracoes.server.model.canalacesso.Perfil;
import java.util.List;

/**
 *
 * @author Robson
 */
public interface AssociaPerfilPermissaoDao<T extends AssociaPerfilPermissao> {

    /**
     * 
     * @param associaPerfilPermissao
     * @throws ServerException 
     */
    public void mantemAssociaPerfilPermissao(T associaPerfilPermissao) throws ServerException;
    
    public List<T> recPermissoesPorPerfil(Perfil p) throws ServerException;
}
