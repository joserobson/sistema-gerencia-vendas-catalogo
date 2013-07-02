/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.dao.canalacesso;

import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.canalacesso.AssociaPerfilPermissao;
import br.com.dcoracoes.server.model.canalacesso.Perfil;
import br.com.dcoracoes.server.model.canalacesso.Permissao;
import br.com.dcoracoes.server.util.HibernateUtil;
import br.com.dcoracoes.server.util.LogUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Robson
 */
public class AssociaPerfilPermissaoDaoImpl implements AssociaPerfilPermissaoDao {

    @Override
    public void mantemAssociaPerfilPermissao(AssociaPerfilPermissao associaPerfilPermissao) throws ServerException {

        LogUtil.logInicioProcessoMetodo(AssociaPerfilPermissao.class, "mantemAssociaPerfilPermissao");

        Session sessao = null;
        try {
            sessao = HibernateUtil.getSession();
            sessao.saveOrUpdate(associaPerfilPermissao);
            LogUtil.logSucesso(AssociaPerfilPermissao.class, "mantemAssociaPerfilPermissao", associaPerfilPermissao.getChaveComposta().getPerfil().getId());

        } catch (HibernateException ex) {
            LogUtil.logDescricaoErro(AssociaPerfilPermissao.class, "ERRO AO SALVAR ASSOCIAPERFILPERMISSAO: " + associaPerfilPermissao.getChaveComposta().getPerfil().getId(), ex);
            throw new ServerException(ex);
        } catch (Exception exGenerica) {
            LogUtil.logDescricaoErro(AssociaPerfilPermissao.class, "ERRO GENERICO AO SALVAR ASSOCIAPERFILPERMISSAO: " + associaPerfilPermissao.getChaveComposta().getPerfil().getId(), exGenerica);
            throw new ServerException(exGenerica);
        } finally {
            LogUtil.logFimProcessoMetodo(AssociaPerfilPermissao.class, "mantemAssociaPerfilPermissao");
        }
    }

    @Override
    public List recPermissoesPorPerfil(Perfil p) throws ServerException {
        LogUtil.logInicioProcessoMetodo(Permissao.class, "recPermissoesPorPerfil");
        Session sessao = null;
        List<Permissao> retornoLista = null;
        try {
            sessao = HibernateUtil.getSession();
            StringBuilder hql = new StringBuilder("");
            hql.append("From AssociaPerfilPermissao a  ");
            hql.append("Where a.chaveComposta.perfil.id = ").append(p.getId());
            Query query = sessao.createQuery(hql.toString());
            retornoLista = query.list();
            LogUtil.logSucesso(Permissao.class, "recPermissoesPorPerfil");
        } catch (HibernateException ex) {
            LogUtil.logDescricaoErro(Permissao.class, "ERRO AO RECUPERAR PERMISSOES", ex);
            throw new ServerException(ex);
        } catch (Exception exGenerica) {
            LogUtil.logDescricaoErro(Permissao.class, "ERRO GENERICO AO RECUPERAR PERMISSOES", exGenerica);
            throw new ServerException(exGenerica);
        } finally {
            LogUtil.logFimProcessoMetodo(Permissao.class, "recPermissoesPorPerfil");
        }

        return retornoLista;
    }
}
