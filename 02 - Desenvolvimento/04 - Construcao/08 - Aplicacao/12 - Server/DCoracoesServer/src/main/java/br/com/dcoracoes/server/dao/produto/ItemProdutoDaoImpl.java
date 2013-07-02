/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.dao.produto;

import br.com.dcoracoes.server.dao.ModelGenericoDaoImpl;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.produto.ItemProduto;
import br.com.dcoracoes.server.util.HibernateUtil;
import org.hibernate.HibernateException;

/**
 *
 * @author Robson
 */
public class ItemProdutoDaoImpl extends ModelGenericoDaoImpl implements ItemProdutoDao {

    @Override
    public void mantemItemProduto(ItemProduto itemProduto) throws ServerException {
        this.mantemObjectGenerico(ItemProduto.class, itemProduto);
    }

    @Override
    public ItemProduto removeItemProduto(ItemProduto itemProduto) throws ServerException {
        return (ItemProduto) this.deleteObject(itemProduto);
    }

    @Override
    public ItemProduto recProdutoPorId(long id) throws ServerException {
        try {            
            //INSTANCIA ITEMPRODUTO POR ID
            ItemProduto item = (ItemProduto)HibernateUtil.getSession().get(ItemProduto.class, id);
            return item;
        } catch (HibernateException ex) {
            throw new ServerException(ex);
        } catch (Exception exGenerica) {
            throw new ServerException(exGenerica);
        } 
    }
}
