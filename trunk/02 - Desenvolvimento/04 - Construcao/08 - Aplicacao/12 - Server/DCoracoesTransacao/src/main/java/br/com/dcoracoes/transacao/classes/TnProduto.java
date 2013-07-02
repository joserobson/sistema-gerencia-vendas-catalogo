/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.transacao.classes;

import br.com.dcoracoes.server.bo.produto.FornecedorBoImpl;
import br.com.dcoracoes.server.bo.produto.ItemProdutoBoImpl;
import br.com.dcoracoes.server.bo.produto.ProdutoBoImpl;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.produto.Fornecedor;
import br.com.dcoracoes.server.model.produto.ItemProduto;
import br.com.dcoracoes.server.model.produto.Produto;
import br.com.dcoracoes.transacao.excecao.TransException;
import br.com.dcoracoes.transacao.interfaces.InterfaceTransacao;
import br.com.dcoracoes.transacao.util.TransacaoUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Robson
 */
public class TnProduto implements InterfaceTransacao {

    /**
     * ATRIBUTOS DA CLASSE
     */
    private Produto produto;

    /**
     * METODOS CONSTRUTORES
     */
    public TnProduto() {
    }

    public TnProduto(Produto produto) {
        this.produto = produto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * METODOS DA INTERFACE PADRAO
     */
    /**
     * SALVAR PRODUTO
     * @param evento
     * @throws TransException 
     */
    @Override
    public void salvar(String evento) throws TransException {
        try {
            if (validarDados(evento)) {
                //Instancia ProdutoBo
                ProdutoBoImpl produtoBo = (ProdutoBoImpl) TransacaoUtil.getInstanceBo(Produto.class);
                produtoBo.mantemProduto(produto);
            }

        } catch (ServerException ex) {
            throw new TransException(ex);
        }
    }

    /**
     * VALIDAR DADOS
     * @param evento
     * @return
     * @throws TransException 
     */
    @Override
    public boolean validarDados(String evento) throws TransException {
        return true;
    }

    /**
     * DELETAR PRODUTO
     * @param evento
     * @throws TransException 
     */
    @Override
    public void deletar(String evento) throws TransException {
        try {
            //Instancia ProdutoBo
            ProdutoBoImpl produtoBo = (ProdutoBoImpl) TransacaoUtil.getInstanceBo(Produto.class);
            produtoBo.removeProduto(produto);

        } catch (ServerException ex) {
            throw new TransException(ex);
        }
    }

    /**
     * METODO PARA RECUPERAR PRODUTO PELO PARAMETRO
     * @param pProduto
     * @return 
     */
    public List<Produto> recProdutos(Produto pProduto, boolean useLike) throws TransException {
        List<Produto> listaRetorno = null;
        try {
            ProdutoBoImpl produtoBo = (ProdutoBoImpl) TransacaoUtil.getInstanceBo(Produto.class);
            listaRetorno = produtoBo.recProdutos(pProduto, useLike);
        } catch (ServerException ex) {
            throw new TransException(ex);
        }
        return listaRetorno;
    }

    /**
     * DELETA ITEM PRODUTO PASSADO COMO PARAMETRO
     * @param cor 
     */
    public void removeItemProduto(ItemProduto item) throws TransException {
        try {
            ItemProdutoBoImpl itemBo = (ItemProdutoBoImpl) TransacaoUtil.getInstanceBo(ItemProduto.class);
            itemBo.removeItemProduto(item);
        } catch (ServerException ex) {
            throw new TransException(ex);
        }
    }
}
