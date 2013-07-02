/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.classes.serverimpl;

import br.com.dcoracoes.server.model.canalacesso.AssociaPerfilPermissao;
import br.com.dcoracoes.server.model.canalacesso.Usuario;
import br.com.dcoracoes.transacao.classes.TnUsuario;
import br.com.dcoracoes.transacao.constantes.ConstanteTnUsuario;
import br.com.dcoracoes.transacao.excecao.TransException;
import java.util.List;

/**
 *
 * @author Robson
 */
public class UsuarioServerImpl {

    /**
     * METODO PARA SALVAR USUARIO
     * @param usuario
     * @return
     * @throws TransException 
     */
    public Usuario salvarUsuario(Usuario usuario) throws TransException {
        try {
            TnUsuario tn = new TnUsuario(usuario);
            tn.salvar(ConstanteTnUsuario.NOME_EVENTO_SALVAR_USUARIO);
            return tn.getUsuario();
        } catch (TransException ex) {
            throw ex;
        }
    }

    /**
     * METODO PARA RECUPERAR USUARIO DINAMICAMENTE PELO PARAMETRO
     * RECUPERA PELOS ATRIBUTOS:
     * NOME DA PESSOA
     * NOME DO USUARIO
     * NOME DO PERFIL
     * @param pUsuario
     * @return
     * @throws TransException 
     */
    public List<Usuario> recListaUsuario(Usuario pUsuario) throws TransException {
        List<Usuario> retListaUsuario = null;
        try {
            TnUsuario tn = new TnUsuario();
            retListaUsuario = tn.recListaUsuario(pUsuario);
        } catch (TransException ex) {
            throw ex;
        }

        return retListaUsuario;
    }

    /**
     * 
     * @param id
     * @return
     * @throws TransException 
     */
    public Usuario recUsuarioPorId(Long id) throws TransException {
        Usuario retorno = null;
        try {
            TnUsuario tn = new TnUsuario();
            retorno = tn.recUsuarioPorId(id);
        } catch (TransException ex) {
            throw ex;
        }
        return retorno;
    }

   
}
