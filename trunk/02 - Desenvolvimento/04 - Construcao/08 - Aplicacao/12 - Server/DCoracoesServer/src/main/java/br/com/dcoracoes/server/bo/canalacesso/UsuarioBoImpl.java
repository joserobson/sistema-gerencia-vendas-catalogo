/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.bo.canalacesso;

import br.com.dcoracoes.server.bo.cadastro.PessoaBoImpl;
import br.com.dcoracoes.server.dao.cadastro.PessoaDaoImpl;
import br.com.dcoracoes.server.dao.canalacesso.UsuarioDao;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.cadastro.Pessoa;
import br.com.dcoracoes.server.model.canalacesso.Usuario;
import br.com.dcoracoes.server.util.HibernateUtil;
import br.com.dcoracoes.server.util.LogUtil;
import java.util.List;

/**
 *
 * @author Robson
 */
public class UsuarioBoImpl implements UsuarioBo {

    private UsuarioDao usuarioDao;

    @Override
    public void setUsuarioDao(UsuarioDao dao) {
        this.usuarioDao = dao;
    }

    /**
     * MANTEM USUARIO
     * @param usuario
     * @throws ServerException 
     */
    @Override
    public void mantemUsuario(Usuario usuario) throws ServerException {
        //ABRIR LOG
        LogUtil.logInicioProcessoMetodo(UsuarioBoImpl.class, "mantemUsuario");
        try {
            //ABRIR SESSAO
            HibernateUtil.setSession();

            //ABRIR TRANSACAO
            HibernateUtil.setTransacao();

            //SALVAR PESSOA
            this.salvarPessoa(usuario.getPessoa());

            //SALVA USUARIO
            this.usuarioDao.mantemUsuario(usuario);

            //COMMIT NA TRANSACAO
            HibernateUtil.getTransacao().commit();

            //LOG SUCESSO
            LogUtil.logSucesso(UsuarioBoImpl.class, "mantemUsuario", usuario.getId());
        } catch (ServerException ex) {
            HibernateUtil.getTransacao().rollback();
            LogUtil.logDescricaoErro(UsuarioBoImpl.class, "ERRO AO SALVAR USUARIO: " + usuario.getId(), ex);
            throw ex;
        } catch (Exception exGenerica) {
            HibernateUtil.getTransacao().rollback();
            throw new ServerException(exGenerica);
        } finally {
            //FECHAR SESSAO
            HibernateUtil.getSession().close();

            //FECHA LOG
            LogUtil.logFimProcessoMetodo(UsuarioBoImpl.class, "mantemUsuario");
        }
    }

    /**
     * RECUPERA USUARIO POR ID
     * @param id
     * @return
     * @throws ServerException 
     */
    @Override
    public Usuario getUsuarioPorId(Long id) throws ServerException {
        Usuario retornoUsuario = null;
        LogUtil.logInicioProcessoMetodo(UsuarioBoImpl.class, "getUsuarioPorId");
        try {

            //INSTANCIA USUARIO POR ID
            retornoUsuario = (Usuario) this.usuarioDao.getUsuarioPorId(id);

            //LOG
            LogUtil.logSucesso(PerfilBoImpl.class, "getUsuarioPorId", id);

        } catch (ServerException ex) {
            LogUtil.logDescricaoErro(PerfilBoImpl.class, "ERRO AO RECUPERAR USUARIO POR ID", ex);
            throw new ServerException(ex);
        } catch (Exception exGenerica) {
            throw new ServerException(exGenerica);
        } finally {
            //LOG
            LogUtil.logFimProcessoMetodo(UsuarioBoImpl.class, "getUsuarioPorId");
        }

        return retornoUsuario;
    }

    @Override
    public List recUsuario(Usuario usuario) throws ServerException {

        List<Usuario> listaRetorno = null;
        try {
            //ABRIR LOG
            LogUtil.logInicioProcessoMetodo(Usuario.class, "recUsuario");

            //Abrir Sessao
            HibernateUtil.setSession();

            //Consulta
            listaRetorno = this.usuarioDao.recUsuario(usuario);

        } catch (ServerException ex) {
            //Log
            LogUtil.logDescricaoErro(Usuario.class, "ERRO AO CONSULTAR USUARIOS", ex);
            throw ex;
        } catch (Exception exGenerica) {
            //Log
            LogUtil.logDescricaoErro(Usuario.class, "ERRO AO CONSULTAR USUARIOS", exGenerica);
            throw new ServerException(exGenerica);
        } finally {
            //fechar sessao
            HibernateUtil.getSession().close();
        }

        return listaRetorno;
    }

    /**
     * METODO PARA SALVAR UMA PESSOA
     * @param pessoa
     */
    private void salvarPessoa(Pessoa pessoa) throws ServerException {
        PessoaBoImpl bo = new PessoaBoImpl();
        PessoaDaoImpl dao = new PessoaDaoImpl();
        bo.setPessoaDao(dao);
        bo.mantemPessoa(pessoa);
    }
}
