/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.dao.canalacesso;

import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.canalacesso.Perfil;
import br.com.dcoracoes.server.model.canalacesso.Permissao;
import java.util.List;

/**
 *
 * @author Robson
 */
public interface PermissaoDao <T extends Permissao>{
    
    public void mantemPermissao(T permissao) throws ServerException;

    public List<Permissao> recTodasPermissoes()throws ServerException;

    
}
