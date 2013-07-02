/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.dao.produto;

import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.produto.Cor;
import java.util.List;

/**
 *
 * @author Robson
 */
public interface CorDao <T extends Cor> {
    
    public void mantemCor(T cor) throws ServerException;
    
    public List<T> recCor(T cor) throws ServerException;
    
    public T removeCor(T cor) throws ServerException;    
    
}
