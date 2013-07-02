/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.dao.produto;

import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.produto.Produto;
import java.util.List;

/**
 *
 * @author Robson
 */
public interface ProdutoDao <T extends Produto>{
    
    public void mantemProduto(T produto) throws ServerException;
    
    public List<T> recProdutos(T produto, boolean useLike) throws ServerException;
    
    public T removeProduto(T produto) throws ServerException;
}
