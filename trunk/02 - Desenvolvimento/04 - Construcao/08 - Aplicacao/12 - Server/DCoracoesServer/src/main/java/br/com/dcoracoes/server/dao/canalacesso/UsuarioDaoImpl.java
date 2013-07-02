/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.dao.canalacesso;

import br.com.dcoracoes.server.dao.ModelGenericoDaoImpl;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.canalacesso.Usuario;
import br.com.dcoracoes.server.util.HibernateUtil;
import br.com.dcoracoes.server.util.ServerUtil;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Robson
 */
public class UsuarioDaoImpl extends ModelGenericoDaoImpl implements UsuarioDao {

    /**
     * SALVAR USUARIO
     * @param usuario
     * @throws ServerException 
     */
    @Override
    public void mantemUsuario(Usuario usuario) throws ServerException {
        this.mantemObjectGenerico(Usuario.class, usuario);
    }

    /**
     * RECUPERAR USUARIOS
     * @param usuario
     * @return
     * @throws ServerException 
     */
    @Override
    public List recUsuario(Usuario usuario) throws ServerException {
        List<Usuario> listaRetorno = null;
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSession();
            Query hql = sessao.createQuery(montarHql(usuario));
            listaRetorno = hql.list();
            for (Usuario item : listaRetorno) {
                Hibernate.initialize(item.getPessoa().getEmails());
                Hibernate.initialize(item.getPessoa().getTelefones());
            }
        } catch (HibernateException ex) {
            throw new ServerException(ex);
        } catch (Exception exGenerica) {
            throw new ServerException(exGenerica);
        }
        return listaRetorno;
    }

    /**
     * MONTAR HQL PARA CONSULTA DE USUARIO
     * @param perfil
     * @return 
     */
    private String montarHql(Usuario usuario) {
        boolean useWhere = true;

        StringBuilder hql = new StringBuilder();
        hql.append("From Usuario u ");

        //LOGIN
        String login = usuario.getLogin();
        if (login != null) {
            hql.append("Where u.login like '").append(login).append("%'").append(" ");
            useWhere = false;
        }

        //NOME USUARIO
        if (usuario.getPessoa() != null) {
            //VERIFICA NOME
            String nome = usuario.getPessoa().getNome();
            if (nome != null) {
                hql.append(ServerUtil.getClausulaSql(useWhere));
                hql.append("u.pessoa.nome like '").append(nome).append("%'").append(" ");
            }
        }

        //PERFIL
        if (usuario.getPerfil() != null) {
            //VERIFICA PERFIL
            String perfil = usuario.getPerfil().getNomePerfil();
            if (perfil != null) {
                hql.append(ServerUtil.getClausulaSql(useWhere));
                hql.append("u.perfil.nomePerfil = '").append(perfil).append("'").append(" ");
            }
        }

        return hql.toString();
    }

    /**
     * RECUPERA USUARIO POR ID
     * @param id
     * @return
     * @throws ServerException 
     */
    @Override
    public Usuario getUsuarioPorId(Long id) throws ServerException {
        return (Usuario)this.getObjectPorId(id, Usuario.class);
    }
}
