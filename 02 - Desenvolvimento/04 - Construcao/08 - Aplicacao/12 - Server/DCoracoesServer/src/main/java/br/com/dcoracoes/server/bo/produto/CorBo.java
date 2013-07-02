/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.bo.produto;

import br.com.dcoracoes.server.dao.produto.CorDao;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.produto.Cor;
import java.util.List;

/**
 *
 * @author Robson
 */
public interface CorBo<T extends Cor> {

    public void setCorDao(CorDao dao);

    public void mantemCor(T cor) throws ServerException;

    public List<T> recCor(T cor) throws ServerException;
    
    public T removerCor(T cor) throws ServerException;
}
