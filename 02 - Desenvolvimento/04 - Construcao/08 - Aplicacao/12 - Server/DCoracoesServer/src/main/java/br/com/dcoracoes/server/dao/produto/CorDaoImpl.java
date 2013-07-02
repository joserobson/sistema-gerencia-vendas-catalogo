/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.dao.produto;

import br.com.dcoracoes.server.dao.ModelGenericoDaoImpl;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.produto.Cor;
import java.util.List;

/**
 *
 * @author Robson
 */
public class CorDaoImpl extends ModelGenericoDaoImpl implements CorDao {

    @Override
    public void mantemCor(Cor cor) throws ServerException {
        this.mantemObjectGenerico(Cor.class, cor);
    }

    @Override
    public List recCor(Cor cor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Cor removeCor(Cor cor) throws ServerException {
        return (Cor) this.deleteObject(cor);
    }
}
