/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.bo.canalacesso;

import br.com.dcoracoes.server.dao.canalacesso.PermissaoDao;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.canalacesso.Permissao;
import java.util.List;

/**
 *
 * @author Robson
 */
public interface PermissaoBo <T extends Permissao>{
    
    public void setPermissaoDao(PermissaoDao dao);
    
    public void mantemPermissao(T permissao) throws ServerException;
    
    public List<T> recTodasPermissoes()throws ServerException;
    
}
