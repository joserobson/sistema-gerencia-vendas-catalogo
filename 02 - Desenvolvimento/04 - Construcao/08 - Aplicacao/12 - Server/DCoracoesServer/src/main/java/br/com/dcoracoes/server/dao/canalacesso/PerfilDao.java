/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.dao.canalacesso;

import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.canalacesso.Perfil;
import java.util.List;

/**
 *
 * @author Robson
 */
public interface PerfilDao {

    public void mantemPerfil(Perfil perfil) throws ServerException;

    public List<Perfil> recPerfil(Perfil perfil) throws ServerException;
    
    public Perfil getPerfilPorId(Long id) throws ServerException;
}
