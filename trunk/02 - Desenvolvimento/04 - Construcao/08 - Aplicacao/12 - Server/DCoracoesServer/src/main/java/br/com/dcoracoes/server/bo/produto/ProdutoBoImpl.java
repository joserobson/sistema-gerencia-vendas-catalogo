/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.bo.produto;

import br.com.dcoracoes.server.dao.produto.CorDaoImpl;
import br.com.dcoracoes.server.dao.produto.FornecedorDaoImpl;
import br.com.dcoracoes.server.dao.produto.ProdutoDao;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.produto.Cor;
import br.com.dcoracoes.server.model.produto.Fornecedor;
import br.com.dcoracoes.server.model.produto.ItemProduto;
import br.com.dcoracoes.server.model.produto.Produto;
import br.com.dcoracoes.server.util.HibernateUtil;
import br.com.dcoracoes.server.util.LogUtil;
import java.util.List;
import org.hibernate.Hibernate;

/**
 *
 * @author Robson
 */
public class ProdutoBoImpl implements ProdutoBo<Produto> {

    private ProdutoDao produtoDao;

    @Override
    public void setProdutoDao(ProdutoDao dao) {
        this.produtoDao = dao;
    }

    @Override
    public void mantemProduto(Produto produto) throws ServerException {

        //GERAR LOG
        LogUtil.logInicioProcessoMetodo(ProdutoBoImpl.class, "mantemProduto");

        try {

            //Abrir Sessao
            HibernateUtil.setSession();
            //Abrir transacao
            HibernateUtil.setTransacao();

            Fornecedor fornecedorAux = buscarFornecedorCodigoNome(produto.getFornecedor()); 
            if(fornecedorAux != null)
                produto.setFornecedor(fornecedorAux);
            else
                //Salvar Fornecedor
                salvarFornecedor(produto.getFornecedor());

            //Contador estoque para cada produto
            int contEstoque = 0;
            //Percorre lista de itens de produto salvando Cor
            for (ItemProduto itemProduto : produto.getListaItensProduto()) {

                //Salvar Cor
                salvarCor(itemProduto.getCor());
                itemProduto.setProduto(produto);
                contEstoque += itemProduto.getEstoqueAtual();
            }

            //Atualiza estoque total produto
            produto.setEstoqueTotal(contEstoque);

            //Salvar produto
            this.produtoDao.mantemProduto(produto);

            //Commit
            HibernateUtil.getTransacao().commit();

            //Log
            LogUtil.logSucesso(ProdutoBoImpl.class, "mantemProduto");

        } catch (ServerException ex) {
            HibernateUtil.getTransacao().rollback();
            LogUtil.logDescricaoErro(ProdutoBoImpl.class, "ERRO AO SALVAR PRODUTO " + produto.getId(), ex);
            throw ex;
        } catch (Exception exGenerica) {
            HibernateUtil.getTransacao().rollback();
            throw new ServerException(exGenerica);
        } finally {
            //FECHAR SESSAO
            HibernateUtil.getSession().close();

            //FECHA LOG
            LogUtil.logFimProcessoMetodo(ProdutoBoImpl.class, "mantemProduto");
        }
    }

    @Override
    public List<Produto> recProdutos(Produto produto, boolean useLike) throws ServerException{
        
        List<Produto> listaRetorno = null;
        try
        {
            //Abrir Log
            LogUtil.logInicioProcessoMetodo(Produto.class, "recProdutos"); 
            
            //Abrir Sessao
            HibernateUtil.setSession();
            
            //chamada do metodo server
            listaRetorno = this.produtoDao.recProdutos(produto, useLike);
            
            //carregar
            
            //Log
            LogUtil.logSucesso(Produto.class, "recProdutos");
            
        }catch(ServerException ex)
        {
            //Log
            LogUtil.logDescricaoErro(Produto.class, "ERRO AO CONSULTAR PRODUTO", ex);
            throw ex;
        }catch(Exception exGenerica)
        {
            //Log
            LogUtil.logDescricaoErro(Produto.class, "ERRO AO CONSULTAR PRODUTO", exGenerica);
            throw new ServerException(exGenerica);
        }
        finally
        {
            //fecha Sessao
            HibernateUtil.getSession().close();
            
            //Log
            LogUtil.logFimProcessoMetodo(Produto.class, "recProdutos");
        }
        
        return listaRetorno;
    }

    /**
     * METODO PARA SALVAR COR
     * @param cor 
     */
    private void salvarCor(Cor cor) throws ServerException {
        try {
            CorBoImpl corBo = new CorBoImpl();
            CorDaoImpl corDao = new CorDaoImpl();
            corBo.setCorDao(corDao);
            corBo.mantemCor(cor);
        } catch (ServerException ex) {
            throw ex;
        }
    }

    /**
     * SALVAR FORNECEDOR
     * @param fornecedor 
     */
    private void salvarFornecedor(Fornecedor fornecedor) throws ServerException {
        try {
            FornecedorBoImpl fornecedorBo = new FornecedorBoImpl();
            FornecedorDaoImpl fornecedorDao = new FornecedorDaoImpl();
            fornecedorBo.setFornecedorDao(fornecedorDao);
            fornecedorBo.mantemFornecedor(fornecedor);
        } catch (ServerException ex) {
            throw ex;
        }
    }
    
    /**
     * Busca fornecedor pelo codigo e/ou nome
     * @param fornecedor
     * @return
     * @throws ServerException 
     */
    private Fornecedor buscarFornecedorCodigoNome(Fornecedor fornecedor) throws ServerException {
        Fornecedor ret = null;
        try {
            FornecedorBoImpl fornecedorBo = new FornecedorBoImpl();
            FornecedorDaoImpl fornecedorDao = new FornecedorDaoImpl();
            fornecedorBo.setFornecedorDao(fornecedorDao);
            //Buscando fornecedor pelo codigo e/ou nome informado
            List<Fornecedor> lstFornecedor = fornecedorBo.recFornecedorPorCodigoNome(
                    fornecedor.getCodigo(), fornecedor.getPessoa().getNome());
            
            if(lstFornecedor.size() > 0)
            {
                ret = lstFornecedor.get(0);            
                Hibernate.initialize(ret.getPessoa().getEmails());
                Hibernate.initialize(ret.getPessoa().getTelefones());
            }
            
        } catch (ServerException ex) {
            throw ex;
        }
        return ret;
    }
    
    @Override
    public Produto removeProduto(Produto produto) throws ServerException {
        Produto retorno = null;
        try {
            //Abrir Log
            LogUtil.logInicioProcessoMetodo(ItemProduto.class, "removeProduto");

            //Abrir Sessao
            HibernateUtil.setSession();

            //Abrir transacao
            HibernateUtil.setTransacao();
                        
            //remove produto
            retorno = this.produtoDao.removeProduto(produto);

            //Log
            LogUtil.logSucesso(ItemProduto.class, "removeProduto", produto.getId());

            //Commit Transacao
            HibernateUtil.getTransacao().commit();

        } catch (ServerException ex) {
            HibernateUtil.getTransacao().rollback();
            LogUtil.logDescricaoErro(ItemProduto.class, "ERRO AO REMOVER PRODUTO", ex);
            throw ex;
        } catch (Exception exGenerica) {
            HibernateUtil.getTransacao().rollback();
            LogUtil.logDescricaoErro(ItemProduto.class, "ERRO AO REMOVER PRODUTO", exGenerica);
            throw new ServerException(exGenerica);
        } finally {
            //fechar Sessao
            HibernateUtil.getSession().close();

            //FECHA LOG
            LogUtil.logFimProcessoMetodo(ItemProduto.class, "removeProduto");
        }

        return retorno;
    }
}
