/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.bo.canalacesso;

import br.com.dcoracoes.server.dao.canalacesso.AssociaPerfilPermissaoDao;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.canalacesso.AssociaPerfilPermissao;
import br.com.dcoracoes.server.model.canalacesso.Perfil;
import br.com.dcoracoes.server.util.HibernateUtil;
import java.util.List;

/**
 *
 * @author Robson
 */
public class AssociaPerfilPermissaoBoImpl implements AssociaPerfilPermissaoBo<AssociaPerfilPermissao> {

    private AssociaPerfilPermissaoDao associaDao;

    @Override
    public void setDao(AssociaPerfilPermissaoDao dao) {
        this.associaDao = dao;
    }

    @Override
    public void mantemAssociaPerfilPermissao(AssociaPerfilPermissao associaPerfilPermissao) throws ServerException {
        this.associaDao.mantemAssociaPerfilPermissao(associaPerfilPermissao);
    }

    @Override
    public List<AssociaPerfilPermissao> recPermissoesPorPerfil(Perfil p) throws ServerException {

        List<AssociaPerfilPermissao> lstAssocia = null;

        try {
            HibernateUtil.setSession();

            lstAssocia = associaDao.recPermissoesPorPerfil(p);
            
        } catch (ServerException ex) {
            throw ex;
        }finally{
            HibernateUtil.getSession().close();
        }

        return lstAssocia;

    }
}
