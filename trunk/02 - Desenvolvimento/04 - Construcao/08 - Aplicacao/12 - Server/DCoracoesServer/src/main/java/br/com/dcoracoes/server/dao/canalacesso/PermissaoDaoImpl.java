/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.dao.canalacesso;

import br.com.dcoracoes.server.dao.ModelGenericoDaoImpl;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.canalacesso.Permissao;
import br.com.dcoracoes.server.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Robson
 */
public class PermissaoDaoImpl extends ModelGenericoDaoImpl implements PermissaoDao {

    @Override
    public void mantemPermissao(Permissao permissao) throws ServerException {
        this.mantemObjectGenerico(Permissao.class, permissao);
    }

    @Override
    public List recTodasPermissoes() throws ServerException {
        List<Permissao> listaRetorno = null;
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSession();
            Query hql = sessao.createQuery("From Permissao p");
            listaRetorno = hql.list();
        } catch (HibernateException ex) {
            throw new ServerException(ex);
        } catch (Exception exGenerica) {
            throw new ServerException(exGenerica);
        }
        return listaRetorno;
    }
}
