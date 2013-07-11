/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.bo.cadastro;

import br.com.dcoracoes.server.dao.ModelGenericoDao;
import br.com.dcoracoes.server.dao.ModelGenericoDaoImpl;
import br.com.dcoracoes.server.dao.cadastro.PessoaDao;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.cadastro.Email;
import br.com.dcoracoes.server.model.cadastro.Pessoa;
import br.com.dcoracoes.server.model.cadastro.PessoaFisica;
import br.com.dcoracoes.server.model.cadastro.Telefone;
import br.com.dcoracoes.server.util.HibernateUtil;
import br.com.dcoracoes.server.util.LogUtil;
import java.util.List;

/**
 *
 * @author Robson
 */
public class PessoaBoImpl implements PessoaBo<Pessoa> {

    private PessoaDao pessoaDao;

    @Override
    public void setPessoaDao(PessoaDao dao) {
        this.pessoaDao = dao;
    }

    @Override
    public void mantemPessoa(Pessoa pessoa) throws ServerException {
        associaPessoaEndereco(pessoa);
        
        //verifica se precisa remover emails
        //quando edita os emails eles são removidos e depois inseridos
        removerEmails(pessoa);        
        associaPessoaEmail(pessoa);
        
        //verifica se precisa remover telefones
        //quando edita os telefones são removidos e depois inseridos
        removerTelefones(pessoa);
        associaPessoaTelefone(pessoa);
                        
        pessoaDao.mantemPessoa(pessoa);
    }

    @Override
    public List<Telefone> getListaTelefonePorPessoa(Long id) throws ServerException {

        //ABRIR LOG
        LogUtil.logInicioProcessoMetodo(PessoaBoImpl.class, "getListaTelefonePorPessoa");

        List<Telefone> retLista = null;
        try {
            //ABRIR SESSAO
            HibernateUtil.setSession();

            retLista = pessoaDao.getListaTelefonesPorPessoa(id);

        } catch (ServerException ex) {
            throw ex;
        } catch (Exception exGenerica) {
            throw new ServerException(exGenerica);
        } finally {
            //FECHAR SESSAO
            HibernateUtil.getSession().close();

            //FECHA LOG
            LogUtil.logFimProcessoMetodo(PessoaBoImpl.class, "getListaTelefonePorPessoa");
        }

        return retLista;
    }

    @Override
    public List<Email> getListaEmailPorPessoa(Long id) throws ServerException {

        //ABRIR LOG
        LogUtil.logInicioProcessoMetodo(PessoaBoImpl.class, "getListaEmailPorPessoa");

        List<Email> retLista = null;
        try {
            //ABRIR SESSAO
            HibernateUtil.setSession();

            retLista = pessoaDao.getListaEmailPorPessoa(id);

        } catch (ServerException ex) {
            throw ex;
        } catch (Exception exGenerica) {
            throw new ServerException(exGenerica);
        } finally {
            //FECHAR SESSAO
            HibernateUtil.getSession().close();

            //FECHA LOG
            LogUtil.logFimProcessoMetodo(PessoaBoImpl.class, "getListaEmailPorPessoa");
        }

        return retLista;
    }

    @Override
    public List<Pessoa> recPessoaPorCPF(String cpf) throws ServerException {

        //ABRIR LOG
        LogUtil.logInicioProcessoMetodo(PessoaFisica.class, "recPessoaPorCPF");

        List<Pessoa> pessoas = null;
        try {

            //ABRIR SESSAO
            HibernateUtil.setSession();

            //CONSULTA
            pessoas = pessoaDao.recPessoaPorCPF(cpf);

            //LOG
            LogUtil.logSucesso(PessoaFisica.class, "recPessoaPorCPF");
        } catch (ServerException ex) {
            //LOG
            LogUtil.logDescricaoErro(PessoaFisica.class, "ERRO AO CONSULTAR CPF", ex);
            throw ex;
        } catch (Exception exGenerica) {
            //LOG
            LogUtil.logDescricaoErro(PessoaFisica.class, "ERRO AO CONSULTAR CPF", exGenerica);
            throw new ServerException(exGenerica);
        } finally {
            //FECHAR SESSAO            
            HibernateUtil.getSession().close();
            //FECHA LOG
            LogUtil.logFimProcessoMetodo(PessoaBoImpl.class, "recPessoaPorCPF");
        }
        return pessoas;
    }

    @Override
    public Pessoa recPessoPorId(long id) throws ServerException {
        return this.pessoaDao.recPessoaPorId(id);
    }

    private void associaPessoaEndereco(Pessoa pessoa) {
        if (pessoa.getEndereco() != null)
        {
            pessoa.getEndereco().setPessoa(pessoa);
        }
    }

    private void associaPessoaEmail(Pessoa pessoa) {
        if (pessoa.getEmails()!= null &&
                pessoa.getEmails().size() > 0){
            for (Email itemEmail : pessoa.getEmails()) {                
                itemEmail.setPessoa(pessoa);
            }
        }
    }

    private void associaPessoaTelefone(Pessoa pessoa) {
        if (pessoa.getTelefones()!= null &&
                pessoa.getTelefones().size() > 0){
            for (Telefone itemTel : pessoa.getTelefones()) {                
                itemTel.setPessoa(pessoa);
            }
        }
    }

    private void removerEmails(Pessoa pessoa) throws ServerException {
     
        List<Email> emailsEmBanco = this.pessoaDao.getListaEmailPorPessoa(pessoa.getId());
                
        if (emailsEmBanco != null &&
                !emailsEmBanco.isEmpty())
        {
            ModelGenericoDao dao = new ModelGenericoDaoImpl();
            for (Email email : emailsEmBanco) {
                dao.deleteObject(email);
            }
        }        
    }
    
    private void removerTelefones(Pessoa pessoa) throws ServerException {
     
        List<Telefone> telefonesEmBanco = this.pessoaDao.getListaTelefonesPorPessoa(pessoa.getId());
                
        if (telefonesEmBanco != null &&
                !telefonesEmBanco.isEmpty())
        {
            ModelGenericoDao dao = new ModelGenericoDaoImpl();
            for (Telefone tel : telefonesEmBanco) {
                dao.deleteObject(tel);
            }
        }        
    }
}
