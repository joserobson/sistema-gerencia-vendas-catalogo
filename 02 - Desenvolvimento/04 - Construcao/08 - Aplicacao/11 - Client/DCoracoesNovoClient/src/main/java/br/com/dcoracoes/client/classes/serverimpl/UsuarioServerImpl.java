/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.classes.serverimpl;

import br.com.dcoracoes.client.Excecao.ClientDCoracoesException;
import br.com.dcoracoes.servico.service.Usuario;
import java.util.List;

/**
 *
 * @author Robson
 */
public class UsuarioServerImpl<T extends Usuario> extends BaseServerImpl<T> implements IUsuarioServerImpl<T> {

    @Override
    public void salvar(Object param) throws ClientDCoracoesException {
        try {
            this.port.salvarUsuario((Usuario) param);
        } catch (Exception ex) {
            throw new ClientDCoracoesException(ex);
        }
    }

    @Override
    public List recTodos(Object param) throws ClientDCoracoesException {
        List<Usuario> usuarios = null;
        try {
            usuarios = this.port.recListaUsuario((Usuario) param);
        } catch (Exception ex) {
            throw new ClientDCoracoesException(ex);
        }
        return usuarios;
    }

    @Override
    public Object recPorId(Long id) throws ClientDCoracoesException {
        Usuario usuario = null;
        try {
            usuario = this.port.recUsuarioPorId(id);
        } catch (Exception ex) {
            throw new ClientDCoracoesException(ex);
        }

        return usuario;
    }
//    /**
//     * METODO PARA SALVAR USUARIO
//     * @param usuario
//     * @return
//     * @throws TransException 
//     */
//    public Usuario salvarUsuario(Usuario usuario) throws TransException {
//        try {
//            TnUsuario tn = new TnUsuario(usuario);
//            tn.salvar(ConstanteTnUsuario.NOME_EVENTO_SALVAR_USUARIO);
//            return tn.getUsuario();
//        } catch (TransException ex) {
//            throw ex;
//        }
//    }
//
//    /**
//     * METODO PARA RECUPERAR USUARIO DINAMICAMENTE PELO PARAMETRO
//     * RECUPERA PELOS ATRIBUTOS:
//     * NOME DA PESSOA
//     * NOME DO USUARIO
//     * NOME DO PERFIL
//     * @param pUsuario
//     * @return
//     * @throws TransException 
//     */
//    public List<Usuario> recListaUsuario(Usuario pUsuario) throws TransException {
//        List<Usuario> retListaUsuario = null;
//        try {
//            TnUsuario tn = new TnUsuario();
//            retListaUsuario = tn.recListaUsuario(pUsuario);
//        } catch (TransException ex) {
//            throw ex;
//        }
//
//        return retListaUsuario;
//    }
//
//    /**
//     * 
//     * @param id
//     * @return
//     * @throws TransException 
//     */
//    public Usuario recUsuarioPorId(Long id) throws TransException {
//        Usuario retorno = null;
//        try {
//            TnUsuario tn = new TnUsuario();
//            retorno = tn.recUsuarioPorId(id);
//        } catch (TransException ex) {
//            throw ex;
//        }
//        return retorno;
//    }
}
