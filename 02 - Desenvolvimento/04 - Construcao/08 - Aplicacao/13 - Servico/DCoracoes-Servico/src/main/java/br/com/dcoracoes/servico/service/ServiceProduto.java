/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.servico.service;

import br.com.dcoracoes.servico.beans.produto.ItemProduto;
import br.com.dcoracoes.servico.beans.produto.Produto;
import br.com.dcoracoes.transacao.classes.TnProduto;
import br.com.dcoracoes.transacao.constantes.ConstanteTnProduto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dozer.MappingException;

/**
 *
 * @author Jose Robson
 */
public class ServiceProduto<T extends Produto> extends ServiceBase<T> implements IServiceProduto<T> {

    private TnProduto tnProduto = null;

    public ServiceProduto() {
        this.tnProduto = new TnProduto();
    }

    @Override
    public void salvar(Object param) throws Exception {
        try {
            tnProduto.setProduto((br.com.dcoracoes.server.model.produto.Produto) converteToModel(param));
            tnProduto.salvar(ConstanteTnProduto.NOME_EVENTO_SALVAR_PRODUTO);
        } catch (MappingException ex) {
            throw ex;
        }
    }

    @Override
    public Object salvarComRetorno(Object param) throws Exception {
        try {
            tnProduto.setProduto((br.com.dcoracoes.server.model.produto.Produto) converteToModel(param));
            tnProduto.salvar(ConstanteTnProduto.NOME_EVENTO_SALVAR_PRODUTO);
            return converteToBean(tnProduto.getProduto());
        } catch (MappingException ex) {
            throw ex;
        }
    }
    
    

    @Override
    public List recTodos(Object param, boolean useLike) throws Exception {
        List<T> lstProdutosBeans = null;
        try {
            List<br.com.dcoracoes.server.model.produto.Produto> lstProdutosModel =
                    tnProduto.recProdutos((br.com.dcoracoes.server.model.produto.Produto) converteToModel(param), useLike);
            lstProdutosBeans = getListToBeans(lstProdutosModel);

        } catch (MappingException ex) {
            throw ex;
        }

        return lstProdutosBeans;
    }

    @Override
    public T converteToBean(Object param) throws ClassNotFoundException {
        return (T) this.mapper.map(param, Produto.class);
    }

    @Override
    public Object converteToModel(Object param) throws ClassNotFoundException {
        return this.mapper.map(param, br.com.dcoracoes.server.model.produto.Produto.class);
    }

    @Override
    public List getListToBeans(List listModel) throws ClassNotFoundException {
        List<T> listBeans = null;

        if (listModel != null
                && !listModel.isEmpty()) {
            listBeans = new ArrayList<T>();
            Iterator<br.com.dcoracoes.server.model.produto.Produto> iterator = listModel.iterator();
            while (iterator.hasNext()) {
                listBeans.add((T) converteToBean(iterator.next()));
            }
        }

        return listBeans;
    }

    @Override
    public void removeItemProduto(ItemProduto itemProduto) throws Exception {
        try {
            br.com.dcoracoes.server.model.produto.ItemProduto itemModel =
                    this.mapper.map(itemProduto, br.com.dcoracoes.server.model.produto.ItemProduto.class);
            tnProduto.removeItemProduto(itemModel);
        } catch (MappingException ex) {
            throw ex;
        }
    }

    @Override
    public T deletar(Object param) throws Exception {

        T produtoModel = null;
        try {
            tnProduto.setProduto((br.com.dcoracoes.server.model.produto.Produto) converteToModel(param));
            tnProduto.deletar(ConstanteTnProduto.NOME_EVENTO_EXCLUIR_PRODUTO);
            produtoModel = converteToBean(tnProduto.getProduto());
        } catch (MappingException ex) {
            throw ex;
        }

        return produtoModel;
    }
}
