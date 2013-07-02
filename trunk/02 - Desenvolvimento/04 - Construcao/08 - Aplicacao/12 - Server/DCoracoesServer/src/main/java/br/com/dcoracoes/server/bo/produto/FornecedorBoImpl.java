/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.bo.produto;

import br.com.dcoracoes.server.bo.cadastro.PessoaBoImpl;
import br.com.dcoracoes.server.dao.produto.FornecedorDao;
import br.com.dcoracoes.server.dao.cadastro.PessoaDaoImpl;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.cadastro.Pessoa;
import br.com.dcoracoes.server.model.produto.Fornecedor;
import java.util.List;

/**
 *
 * @author Robson
 */
public class FornecedorBoImpl implements FornecedorBo<Fornecedor> {

    private FornecedorDao fornecedorDao;

    @Override
    public void setFornecedorDao(FornecedorDao dao) {
        this.fornecedorDao = dao;
    }

    @Override
    public void mantemFornecedor(Fornecedor fornecedor) throws ServerException {

        try {
            //SALVAR PESSOA VINCULADA AO FORNECEDOR
            salvarPessoa(fornecedor.getPessoa());

            //SALVAR FORNECEDOR
            this.fornecedorDao.mantemFornecedor(fornecedor);
        } catch (ServerException ex) {
            throw ex;
        }
    }

    @Override
    public List<Fornecedor> recFornecedores(Fornecedor fornecedor) throws ServerException {
        return this.fornecedorDao.recFornecedores(fornecedor);
    }

    /**
     * METODO PARA SALVAR PESSOA
     * @param pessoa
     */
    private void salvarPessoa(Pessoa pessoa) throws ServerException {
        try {
            PessoaBoImpl pessoaBo = new PessoaBoImpl();
            PessoaDaoImpl pessoaDao = new PessoaDaoImpl();
            pessoaBo.setPessoaDao(pessoaDao);
            pessoaBo.mantemPessoa(pessoa);
        } catch (ServerException ex) {
            throw ex;
        }
    }

    @Override
    public List<Fornecedor> recFornecedorPorCodigoNome(String codigo, String nome) throws ServerException {
        return this.fornecedorDao.recFornecedorPorCodigoNome(codigo, nome);
    }
}
