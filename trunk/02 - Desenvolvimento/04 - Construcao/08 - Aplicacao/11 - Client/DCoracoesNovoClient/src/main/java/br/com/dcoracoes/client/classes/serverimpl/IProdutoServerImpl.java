/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.classes.serverimpl;

import br.com.dcoracoes.client.Excecao.ClientDCoracoesException;
import br.com.dcoracoes.servico.service.ItemProduto;
import br.com.dcoracoes.servico.service.Produto;
import java.util.List;

/**
 *
 * @author Jose Robson
 */
public interface IProdutoServerImpl<T extends Produto> {
    
    public void deleteItemProduto(ItemProduto itemProduto) throws ClientDCoracoesException;
    
    public List<T> recProdutos(Produto produto, boolean useLike) throws ClientDCoracoesException;
    
}
