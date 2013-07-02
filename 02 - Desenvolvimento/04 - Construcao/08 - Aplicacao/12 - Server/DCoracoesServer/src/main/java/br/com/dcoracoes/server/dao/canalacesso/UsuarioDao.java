/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.dao.canalacesso;

import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.canalacesso.Usuario;
import java.util.List;

/**
 *
 * @author Robson
 */
public interface UsuarioDao<T extends Usuario> {

    public void mantemUsuario(T usuario) throws ServerException;

    public List<T> recUsuario(T usuario) throws ServerException;
    
    public T getUsuarioPorId(Long id) throws ServerException;
}
