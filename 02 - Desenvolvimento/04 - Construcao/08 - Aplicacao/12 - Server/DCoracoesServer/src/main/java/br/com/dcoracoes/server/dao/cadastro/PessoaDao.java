/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.dao.cadastro;

import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.cadastro.Email;
import br.com.dcoracoes.server.model.cadastro.Pessoa;
import br.com.dcoracoes.server.model.cadastro.PessoaFisica;
import br.com.dcoracoes.server.model.cadastro.Telefone;
import java.util.List;

/**
 *
 * @author Robson
 */
public interface PessoaDao {

    public void mantemPessoa(Pessoa pf) throws ServerException;

    public List<Telefone> getListaTelefonesPorPessoa(Long id) throws ServerException;

    public List<Email> getListaEmailPorPessoa(Long id) throws ServerException;

    public List<Pessoa> recPessoaPorCPF(String cpf) throws ServerException;

    public Pessoa recPessoaPorId(long id) throws ServerException;
}
