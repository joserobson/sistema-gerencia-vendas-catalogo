/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.bo.produto;

import br.com.dcoracoes.server.dao.produto.CorDao;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.produto.Cor;
import br.com.dcoracoes.server.util.HibernateUtil;
import br.com.dcoracoes.server.util.LogUtil;
import java.util.List;

/**
 *
 * @author Robson
 */
public class CorBoImpl implements CorBo {

    private CorDao corDao;

    @Override
    public void setCorDao(CorDao dao) {
        this.corDao = dao;
    }

    @Override
    public void mantemCor(Cor cor) throws ServerException {
        this.corDao.mantemCor(cor);
    }

    @Override
    public List recCor(Cor cor) throws ServerException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Cor removerCor(Cor cor) throws ServerException {
        return this.corDao.removeCor(cor);

    }
}
