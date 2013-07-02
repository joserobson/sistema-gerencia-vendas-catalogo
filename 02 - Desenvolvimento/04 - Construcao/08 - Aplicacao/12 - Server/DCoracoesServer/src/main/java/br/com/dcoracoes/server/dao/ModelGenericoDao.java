/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.dao;

import br.com.dcoracoes.server.excecao.ServerException;

/**
 *
 * @author Robson
 */
public interface ModelGenericoDao {
    
    /**
     * SALVAR OBJECTOS MODEL DO PROJETO
     * @param cls
     * @param model
     * @throws ServerException 
     */
    public void mantemObjectGenerico(Class cls, Object model) throws ServerException;
    
    /**
     * RECUPERAR OBJETOS MODELO PELO ID
     * @param id
     * @param cls
     * @return
     * @throws ServerException 
     */
    public Object getObjectPorId(Long id,Class cls) throws ServerException;
    
    /**
     * 
     * @param model
     * @return
     * @throws ServerException 
     */
    public Object deleteObject(Object model) throws ServerException;
}
