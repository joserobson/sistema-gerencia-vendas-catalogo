/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.dao.produto;

import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.produto.Fornecedor;
import java.util.List;

/**
 *
 * @author Robson
 */
public interface FornecedorDao <T extends Fornecedor>{
    
    public void mantemFornecedor(T fornecedor) throws ServerException;
    
    public List<T> recFornecedores(T fornecedor) throws ServerException;
    
    public List<T> recFornecedorPorCodigoNome(String codigo, String nome) throws ServerException;
}
