/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dcoracoes.server.bo.cadastro;

import br.com.dcoracoes.server.dao.cadastro.PessoaDao;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.cadastro.Email;
import br.com.dcoracoes.server.model.cadastro.Pessoa;
import br.com.dcoracoes.server.model.cadastro.Telefone;
import java.util.List;

/**
 *
 * @author Robson
 */
public interface PessoaBo <T extends Pessoa> {

    /**
     *
     * @param dao
     */
    public void setPessoaDao(PessoaDao dao);

    /**
     * 
     * @param pessoaFisica
     */
    public void mantemPessoa(T pessoa) throws ServerException;

    /**
     *
     * @param id
     * @return
     */
    public List<Telefone> getListaTelefonePorPessoa(Long id) throws ServerException;

    /**
     * 
     * @param id
     * @return
     */
    public List<Email> getListaEmailPorPessoa(Long id) throws ServerException;
    
    /**
     * 
     * @param cpf
     * @return
     * @throws ServerException 
     */
    public List<T> recPessoaPorCPF(String cpf) throws ServerException;


    public T recPessoPorId(long id) throws ServerException;
}
