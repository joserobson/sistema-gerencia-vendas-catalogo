/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.dao.cadastro;

import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.cadastro.Pessoa;
import br.com.dcoracoes.server.model.cadastro.Revendedor;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Robson
 */
public interface RevendedorDao <T extends Revendedor> {

    public void mantemRevendedor(T pRevendedor) throws ServerException;

    public T recUltimoRevendedorCadastrado() throws ServerException;

    public int recCodigoSequencial() throws ServerException;
    
    public List<T> recRevendedor(T revendedor) throws ServerException;
    
    public List<Pessoa> recRevendedorEtiqueta(HashMap<String, Object> parameter) throws ServerException;
    
    public List<Revendedor> recRevendedorPorCPF(String cpf) throws ServerException;
}
