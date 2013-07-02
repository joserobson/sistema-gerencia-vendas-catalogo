/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.transacao.classes;

import br.com.dcoracoes.server.bo.canalacesso.UsuarioBoImpl;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.canalacesso.Usuario;
import br.com.dcoracoes.transacao.excecao.TransException;
import br.com.dcoracoes.transacao.interfaces.InterfaceTransacao;
import br.com.dcoracoes.transacao.util.TransacaoUtil;
import java.util.List;

/**
 *
 * @author Robson
 */
public class TnUsuario implements InterfaceTransacao {

    /**
     * ATRIBUTOS DA CLASSE
     */
    private Usuario usuario;

    /**
     * METODOS CONSTRUTORES
     */
    public TnUsuario() {
    }

    public TnUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * METODOS ACESSORES
     * @return 
     */
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * METODOS DA INTERFACE PADRAO
     */
    /**
     * SALVAR USUARIO
     * @param evento
     * @throws TransException 
     */
    @Override
    public void salvar(String evento) throws TransException {
        try {
            if (validarDados(evento)) {
                UsuarioBoImpl usuarioBo = (UsuarioBoImpl) TransacaoUtil.getInstanceBo(Usuario.class);
                usuarioBo.mantemUsuario(this.usuario);
            }

        } catch (ServerException ex) {
            throw new TransException(ex);
        }
    }

    /**
     * 
     * @param evento
     * @return
     * @throws TransException 
     */
    @Override
    public boolean validarDados(String evento) throws TransException {
        return true;
    }

    /**
     * 
     * @param evento
     * @throws TransException 
     */
    @Override
    public void deletar(String evento) throws TransException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Recuperar lista de Usuarios
     * @param pUsuario
     * @return
     * @throws TransException 
     */
    public List<Usuario> recListaUsuario(Usuario pUsuario) throws TransException {
        List<Usuario> retListaUsuario = null;
        try {
            UsuarioBoImpl usuarioBo = (UsuarioBoImpl) TransacaoUtil.getInstanceBo(Usuario.class);
            retListaUsuario = usuarioBo.recUsuario(pUsuario);
        } catch (ServerException ex) {
            throw new TransException(ex);
        }
        return retListaUsuario;
    }

    /**
     * METODO PARA RECUPERAR USUARIO PELO ID
     * @param id
     * @return
     * @throws TransException 
     */
    public Usuario recUsuarioPorId(Long id) throws TransException {
        Usuario retorno = null;
        try {
            UsuarioBoImpl usuarioBo = (UsuarioBoImpl) TransacaoUtil.getInstanceBo(Usuario.class);
            retorno = usuarioBo.getUsuarioPorId(id);
        } catch (ServerException ex) {
            throw new TransException(ex);
        }
        return retorno;
    }
    
   
}
