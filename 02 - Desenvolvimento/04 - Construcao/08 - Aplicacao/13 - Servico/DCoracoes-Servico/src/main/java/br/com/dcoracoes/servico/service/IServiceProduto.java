/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.servico.service;

import br.com.dcoracoes.servico.beans.produto.ItemProduto;
import br.com.dcoracoes.servico.beans.produto.Produto;

/**
 *
 * @author Jose Robson
 */
public interface IServiceProduto<T extends Produto> {

    void removeItemProduto(ItemProduto itemProduto) throws Exception;
}
