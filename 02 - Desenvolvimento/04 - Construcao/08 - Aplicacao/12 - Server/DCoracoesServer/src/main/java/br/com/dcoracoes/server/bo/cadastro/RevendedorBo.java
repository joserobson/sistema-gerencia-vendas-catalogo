/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.bo.cadastro;

import br.com.dcoracoes.server.dao.cadastro.RevendedorDao;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.cadastro.AssociaPessoa;
import br.com.dcoracoes.server.model.cadastro.Pessoa;
import br.com.dcoracoes.server.model.cadastro.Revendedor;
import br.com.dcoracoes.server.model.movimento.AssociaPessoaConta;
import br.com.dcoracoes.server.model.pedido.PedidoVenda;
import java.util.HashMap;
import java.util.List;


/**
 *
 * @author Robson
 */
public interface RevendedorBo<T extends Revendedor> {

    public void setRevendedorDao(RevendedorDao dao);

    public void mantemRevendedor(T revendedor, Pessoa conjugue,
            List<AssociaPessoaConta> lstAssociaPessoaConta, List<AssociaPessoa> lstAssociaPessoaRevendedor) throws ServerException;

    public T recUltimoRevendedorCadastrado() throws ServerException;

    public int recCodigoSequencial() throws ServerException;
    
    public List<T> recRevendedor(T revendedor) throws ServerException;
    
    public void atualizaDadosCreditoRevendedor(PedidoVenda pedido) throws ServerException;
    
    public void atualizaDadosCreditoRevendedor(T revendedor) throws ServerException;
    
    public void atualizaSituacaoRevendedor(T revendedor) throws ServerException;
    
    public List<Pessoa> recRevendedorEtiqueta(HashMap<String, Object> parameter) throws ServerException;
    
    public List<T> recRevendedorPorCPF(String cpf) throws ServerException;
            
}
