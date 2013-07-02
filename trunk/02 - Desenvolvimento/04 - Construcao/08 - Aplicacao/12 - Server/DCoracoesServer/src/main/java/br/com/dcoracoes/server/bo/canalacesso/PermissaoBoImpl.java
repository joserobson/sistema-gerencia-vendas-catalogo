/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.bo.canalacesso;

import br.com.dcoracoes.server.dao.canalacesso.PermissaoDao;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.canalacesso.Permissao;
import br.com.dcoracoes.server.util.HibernateUtil;
import br.com.dcoracoes.server.util.LogUtil;
import java.util.List;

/**
 *
 * @author Robson
 */
public class PermissaoBoImpl implements PermissaoBo {

    private PermissaoDao permissaoDao;

    @Override
    public void setPermissaoDao(PermissaoDao dao) {
        this.permissaoDao = dao;
    }

    @Override
    public void mantemPermissao(Permissao permissao) throws ServerException {
        this.permissaoDao.mantemPermissao(permissao);
    }

    @Override
    public List recTodasPermissoes() throws ServerException {
         List<Permissao> listaRetorno = null;
        try {
            //Log
            LogUtil.logInicioProcessoMetodo(Permissao.class, "recTodasPermissoes");

            //ABRE SESSAO
            HibernateUtil.setSession();

            //Consulta
            listaRetorno = this.permissaoDao.recTodasPermissoes();
        } catch (ServerException ex) {
            LogUtil.logDescricaoErro(Permissao.class, "ERRO AO CONSULTAR PERMISSOES", ex);
            throw ex;
        } catch (Exception exGenerica) {
            LogUtil.logDescricaoErro(Permissao.class, "ERRO AO CONSULTAR PERMISSOES", exGenerica);
            throw new ServerException(exGenerica);
        } finally {
            LogUtil.logFimProcessoMetodo(Permissao.class, "recTodasPermissoes");
        }

        return listaRetorno;
    }
}
