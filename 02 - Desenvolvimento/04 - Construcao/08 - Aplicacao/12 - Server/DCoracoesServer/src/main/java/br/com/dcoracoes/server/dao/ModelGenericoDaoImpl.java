/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.dao;

import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Robson
 */
public class ModelGenericoDaoImpl implements ModelGenericoDao {

    @Override
    public void mantemObjectGenerico(Class cls, Object model) throws ServerException {
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSession();
            sessao.saveOrUpdate(model);

        } catch (HibernateException ex) {
            throw new ServerException(ex);
        }/**
         * TRATAMENTO EXCECAO GENERICA, DEPOIS REMOVER
         */
        catch (Exception exGenerica) {
            throw new ServerException(exGenerica);
        }
    }

    @Override
    public Object getObjectPorId(Long id, Class cls) throws ServerException {
        Object retorno = null;
        try {
            //ABRIR SESSAO
            HibernateUtil.setSession();

            //INSTANCIA OBJECT POR ID
            retorno = HibernateUtil.getSession().get(cls, id);

        } catch (HibernateException ex) {
            throw new ServerException(ex);
        } catch (Exception exGenerica) {
            throw new ServerException(exGenerica);
        } finally {
            //FECHAR SESSAO
            HibernateUtil.getSession().close();
        }

        return retorno;
    }

    @Override
    public Object deleteObject(Object model) throws ServerException {

        Object retorno = null;
        Session sessao = null;
        try {
            //ABRIR SESSAO
            sessao = HibernateUtil.getSession();

            //DELETE
            sessao.delete(model);

            retorno = model;

        } catch (HibernateException ex) {
            throw new ServerException(ex);
        } catch (Exception exGenerica) {
            throw new ServerException(exGenerica);
        } 
        return retorno;
    }
}
