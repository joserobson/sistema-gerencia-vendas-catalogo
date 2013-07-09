/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.bo.canalacesso;

import br.com.dcoracoes.server.dao.canalacesso.AssociaPerfilPermissaoDaoImpl;
import br.com.dcoracoes.server.dao.canalacesso.PerfilDao;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.canalacesso.AssociaPerfilPermissao;
import br.com.dcoracoes.server.model.canalacesso.Perfil;
import br.com.dcoracoes.server.util.HibernateUtil;
import br.com.dcoracoes.server.util.LogUtil;
import java.util.List;

/**
 *
 * @author Robson
 */
public class PerfilBoImpl implements PerfilBo {

    private PerfilDao perfilDao;

    @Override
    public void setPerfilDao(PerfilDao perfilDao) {
        this.perfilDao = perfilDao;
    }

    @Override
    public void mantemPerfil(Perfil perfil, List lstAssociaPerfilPermissao) throws ServerException {

        LogUtil.logInicioProcessoMetodo(PerfilBoImpl.class, "mantemPerfil");
        try {
            //ABRIR SESSAO   
            HibernateUtil.setSession();

            //ABRIR TRANSACAO
            HibernateUtil.setTransacao();

            //SALVAR PERFIL            
            this.perfilDao.mantemPerfil(perfil);

            //SALVAR LISTA DE ASSOCIA PERFIL PERMISSAO
            this.salvarAssociaPerfilPermissao(lstAssociaPerfilPermissao, perfil);

            //COMMIT TRANSACAO
            HibernateUtil.getTransacao().commit();

            //LOG SUCESSO
            LogUtil.logSucesso(PerfilBoImpl.class, "mantemPerfil");

        } catch (ServerException ex) {
            LogUtil.logDescricaoErro(PerfilBoImpl.class, "ERRO AO SALVAR PERFIL", ex);
            throw new ServerException(ex);
        } finally {
            //LOG
            LogUtil.logFimProcessoMetodo(PerfilBoImpl.class, "mantemPerfil");

            //FECHAR SESSAO
            HibernateUtil.getSession().close();
        }
    }

    @Override
    public Perfil getPerfilPorId(Long id) throws ServerException {
        Perfil retornoPerfil = null;
        LogUtil.logInicioProcessoMetodo(PerfilBoImpl.class, "getPerfilPorId");
        try {
            //ABRIR SESSAO
            HibernateUtil.setSession();

            //INSTANCIA PERFIL POR ID
            retornoPerfil = this.perfilDao.getPerfilPorId(id);

            //LOG
            LogUtil.logSucesso(PerfilBoImpl.class, "getPerfilPorId", id);

        } catch (ServerException ex) {
            LogUtil.logDescricaoErro(PerfilBoImpl.class, "ERRO AO RECUPERAR PERFIL POR ID", ex);
            throw new ServerException(ex);
        } finally {
            //LOG
            LogUtil.logFimProcessoMetodo(PerfilBoImpl.class, "getPerfilPorId");

            //FECHAR SESSAO
            HibernateUtil.getSession().close();
        }

        return retornoPerfil;
    }

    @Override
    public List recPerfil(Perfil perfil) throws ServerException {
        List<Perfil> listaRetorno = null;
        try {
            //Log
            LogUtil.logInicioProcessoMetodo(Perfil.class, "recPerfil");

            //ABRE SESSAO
            HibernateUtil.setSession();

            //Consulta
            listaRetorno = this.perfilDao.recPerfil(perfil);
        } catch (ServerException ex) {
            LogUtil.logDescricaoErro(Perfil.class, "ERRO AO CONSULTAR PERFIL - METODO RecPerfil", ex);
            throw ex;
        } catch (Exception exGenerica) {
            LogUtil.logDescricaoErro(Perfil.class, "ERRO AO CONSULTAR PERFIL - METODO RecPerfil", exGenerica);
            throw new ServerException(exGenerica);
        } finally {
            LogUtil.logFimProcessoMetodo(Perfil.class, "recPerfil");
        }

        return listaRetorno;
    }

    /**
     * 
     * @param lstAssocia 
     */
    public void salvarAssociaPerfilPermissao(List<AssociaPerfilPermissao> lstAssocia, Perfil perfil) throws ServerException {
        try {
            AssociaPerfilPermissaoBoImpl associaBo = new AssociaPerfilPermissaoBoImpl();
            AssociaPerfilPermissaoDaoImpl associaDao = new AssociaPerfilPermissaoDaoImpl();
            associaBo.setDao(associaDao);

            for (AssociaPerfilPermissao associaPerfilPermissao : lstAssocia) {
                associaPerfilPermissao.getChaveComposta().setPerfil(perfil);
                associaBo.mantemAssociaPerfilPermissao(associaPerfilPermissao);
            }

        } catch (ServerException ex) {
            throw ex;
        }
    }
}
