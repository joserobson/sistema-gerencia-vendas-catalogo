/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.bo.pedido;

import br.com.dcoracoes.server.bo.produto.FornecedorBoImpl;
import br.com.dcoracoes.server.bo.produto.ItemProdutoBoImpl;
import br.com.dcoracoes.server.dao.pedido.CodigoItemDaoImpl;
import br.com.dcoracoes.server.dao.pedido.PagamentoDaoImpl;
import br.com.dcoracoes.server.dao.pedido.PedidoDao;
import br.com.dcoracoes.server.dao.produto.FornecedorDaoImpl;
import br.com.dcoracoes.server.dao.produto.ItemProdutoDaoImpl;
import br.com.dcoracoes.server.enuns.Enum_Forma_Pagamento;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.cadastro.Revendedor;
import br.com.dcoracoes.server.model.pedido.CodigoItem;
import br.com.dcoracoes.server.model.pedido.ItemPedido;
import br.com.dcoracoes.server.model.pedido.Pedido;
import br.com.dcoracoes.server.model.pedido.PedidoCompra;
import br.com.dcoracoes.server.model.pedido.PedidoVenda;
import br.com.dcoracoes.server.model.produto.Fornecedor;
import br.com.dcoracoes.server.model.produto.ItemProduto;
import br.com.dcoracoes.server.util.HibernateUtil;
import br.com.dcoracoes.server.util.LogUtil;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Robson
 */
public class PedidoBoImpl<T extends Pedido> implements PedidoBo<T> {

    private PedidoDao pedidoDao = null;

    @Override
    public void setPedidoDao(PedidoDao dao) {
        this.pedidoDao = dao;
    }

    @Override
    public void mantemPedido(T pedido) throws ServerException {

        //Log
        LogUtil.logInicioProcessoMetodo(Pedido.class, "mantemPedido");
        try {
            //Abrir Sessao
            HibernateUtil.setSession();

            //Abrir Transacao
            HibernateUtil.setTransacao();

            //verificar o tipo de pedido é Venda
            if (pedido.getClass().equals(PedidoVenda.class)) {

                //metodo para criar Pagamento para o pedido e salva-lo
                gerarPagamentoPedido((PedidoVenda) pedido);
            }else
            {
                //salvar fornecedor
                if(((PedidoCompra)pedido).getFornecedor() != null)
                    salvarFornecedor(((PedidoCompra)pedido).getFornecedor());
            }

            //Garantir que os itens de pedido estão vinculados ao Pedido
            for (ItemPedido item : pedido.getListaItensPedido()) {

                //salvar CodigoItem
                salvarCodigoItem(item.getCodigo());
                item.setPedido(pedido);
            }

            //salvar Pedido
            this.pedidoDao.mantemPedido(pedido);

            //Atualizar Estoque dos produtos do pedido
            this.atualizarEstoque(pedido);

            //Commit transacao
            HibernateUtil.getTransacao().commit();

            //Log
            LogUtil.logSucesso(Pedido.class, "mantemPedido");

        } catch (ServerException ex) {
            HibernateUtil.getTransacao().rollback();
            LogUtil.logDescricaoErro(Pedido.class, "ERRO AO SALVAR PEDIDO", ex);
            throw ex;
        } catch (Exception exGenerica) {
            HibernateUtil.getTransacao().rollback();
            LogUtil.logDescricaoErro(Pedido.class, "ERRO AO SALVAR PEDIDO", exGenerica);
            throw new ServerException(exGenerica);
        } finally {

            //fechar sessao
            HibernateUtil.getSession().close();

            //Log
            LogUtil.logFimProcessoMetodo(Pedido.class, "MantemPedido");
        }
    }

    @Override
    public List<T> recPedidos(T pedido) throws ServerException {

        List<T> listaPedidos = null;
        try {
            //LOG
            LogUtil.logInicioProcessoMetodo(Pedido.class, "recPedidos");

            //Abrir Sessao
            HibernateUtil.setSession();

            //chamada do metodo dao
            listaPedidos = this.pedidoDao.recPedidos(pedido);

            //Log
            LogUtil.logSucesso(Pedido.class, "recPedidos");


        } catch (ServerException ex) {
            //LOG
            LogUtil.logDescricaoErro(Pedido.class, "ERRO AO CONSULTAR PEDIDO", ex);
            throw ex;
        } catch (Exception exGenerica) {
            //LOG
            LogUtil.logDescricaoErro(Pedido.class, "ERRO AO CONSULTA PEDIDO", exGenerica);
            throw new ServerException(exGenerica);
        } finally {

            //Fechar Sessao
            HibernateUtil.getSession().close();

            //Log
            LogUtil.logFimProcessoMetodo(Pedido.class, "recPedidos");
        }

        return listaPedidos;
    }

    @Override
    public void removePedido(T pedido) throws ServerException {

        try {
            //Log
            LogUtil.logInicioProcessoMetodo(Pedido.class, "removePedido");

            //Abrir Sessao
            HibernateUtil.setSession();

            //Abrir transacao
            HibernateUtil.setTransacao();

            //Metodo dao para remover
            this.pedidoDao.removePedido(pedido);

            //Commit na transacao
            HibernateUtil.getTransacao().commit();

            //Log
            LogUtil.logSucesso(Pedido.class, "removePedido", pedido.getId());

        } catch (ServerException ex) {
            LogUtil.logDescricaoErro(Pedido.class, "ERRO AO REMOVER PEDIDO", ex);
            HibernateUtil.getTransacao().rollback();
            throw ex;
        } catch (Exception exGenerica) {
            LogUtil.logDescricaoErro(Pedido.class, "ERRO AO REMOVER PEDIDO", exGenerica);
            HibernateUtil.getTransacao().rollback();
            throw new ServerException(exGenerica);
        } finally {

            //FECHAR SESSAO
            HibernateUtil.getSession().close();

            //LOg
            LogUtil.logFimProcessoMetodo(Pedido.class, "removePedido");
        }
    }

    @Override
    public int recMaxCodigoPedido() throws ServerException {

        int retorno = -1;
        try {
            //Log
            LogUtil.logInicioProcessoMetodo(Pedido.class, "recMaxCodigoPedido");

            //Abrir sessao
            HibernateUtil.setSession();

            //Chamada Server
            retorno = this.pedidoDao.recMaxCodigoPedido();

            //log
            LogUtil.logSucesso(Pedido.class, "recMaxCodigoPedido");
        } catch (ServerException ex) {
            LogUtil.logDescricaoErro(Pedido.class, "ERRO AO RECUPERAR CODIGO MAX PEDIDO", ex);
            throw ex;
        } catch (Exception exGenerica) {
            LogUtil.logDescricaoErro(Pedido.class, "ERRO AO RECUPERAR CODIGO MAX PEDIDO", exGenerica);
            throw new ServerException(exGenerica);
        } finally {
            HibernateUtil.getSession().close();
        }
        return retorno;
    }

    /**
     * Logica para gerar pagamento para o pedido
     * Atributo pagamento de pedido já veem setado e indicando somente a forma de pagamento
     * a lista de parcelas vai ser gerada a partir desse método
     * @param pedido 
     */
    private void gerarPagamentoPedido(PedidoVenda pedido) throws ServerException {

        try {
            //Setar e Salvar pagamento            
            PagamentoBoImpl pagamentoBo = new PagamentoBoImpl();
            PagamentoDaoImpl pagamentoDao = new PagamentoDaoImpl();
            pagamentoBo.setPagamentoDao(pagamentoDao);

            if (pedido.getPagamento().getFormaPagamento() == Enum_Forma_Pagamento.APRAZOCOMCOMPLEMENTO.getCodigo()) {
                pedido.getPagamento().setValor(pedido.getRevendedor().getLimiteUtilizavel());
            }

            pagamentoBo.mantemPagamento(pedido.getPagamento());

        } catch (ServerException ex) {
            LogUtil.logDescricaoErro(Pedido.class, "ERRO AO GERAR PAGAMENTO PARA O PEDIDO " + pedido.getCodigo(), ex);
            throw ex;
        } catch (Exception exGenerica) {
            LogUtil.logDescricaoErro(Pedido.class, "ERRO AO GERAR PAGAMENTO PARA O PEDIDO " + pedido.getCodigo(), exGenerica);
            throw new ServerException(exGenerica);
        }
    }

    /**
     * Atualiza estoque dos produtos vinculados ao pedido
     * @param pedido 
     */
    private void atualizarEstoque(T pedido) throws ServerException {
        try {
            //Log
            LogUtil.logInicioProcessoMetodo(Pedido.class, "atualizarEstoque");

            ItemProdutoBoImpl itemProdutoBo = new ItemProdutoBoImpl();
            ItemProdutoDaoImpl itemProdutoDao = new ItemProdutoDaoImpl();
            itemProdutoBo.setItemProdutoDao(itemProdutoDao);

            //verifica se é para somar ou diminuir a quantidade de itens e de produto
            //de acordo com o tipo de Pedido
            boolean somar = false;
            if (pedido.getClass().equals(PedidoCompra.class)) {
                somar = true;
            }

            for (ItemPedido item : pedido.getListaItensPedido()) {

                ItemProduto itemProduto = itemProdutoBo.recItemProdutoPorId(item.getIdItemProduto());
                if (itemProduto != null) {
                    if (!somar) {
                        //atualiza estoque do itemProduto
                        itemProduto.setEstoqueAtual(itemProduto.getEstoqueAtual() - item.getQuantidade());
                        //atualiza estoque do produto
                        itemProduto.getProduto().setEstoqueTotal(itemProduto.getProduto().getEstoqueTotal() - item.getQuantidade());
                    } else {
                        //atualiza estoque do itemProduto
                        itemProduto.setEstoqueAtual(itemProduto.getEstoqueAtual() + item.getQuantidade());
                        //atualiza estoque do produto
                        itemProduto.getProduto().setEstoqueTotal(itemProduto.getProduto().getEstoqueTotal() + item.getQuantidade());
                    }
                    itemProdutoBo.mantemItemProduto(itemProduto);
                }
            }

            LogUtil.logSucesso(Pedido.class, "atualizarEstoque");

        } catch (ServerException ex) {
            LogUtil.logDescricaoErro(Pedido.class, "ERRO AO ATUALIZAR ESTOQUE: " + pedido.getId(), ex);
            throw ex;
        } finally {
            LogUtil.logFimProcessoMetodo(Pedido.class, "atualizarEstoque");
        }
    }

    /**
     * 
     * @param codigo 
     */
    private void salvarCodigoItem(CodigoItem codigo) throws ServerException {
        CodigoItemBoImpl codigoItemBo = new CodigoItemBoImpl();
        CodigoItemDaoImpl codigoItemDao = new CodigoItemDaoImpl();
        codigoItemBo.setDao(codigoItemDao);
        codigoItemBo.mantemCodigoItem(codigo);
    }

    @Override
    public PedidoVenda recUltimoPedidoVenda(Revendedor rev) throws ServerException {

        PedidoVenda retornoPedido = null;
        try {
            //Log
            LogUtil.logInicioProcessoMetodo(Pedido.class, "recUltimoPedidoVenda");

            //Abrir sessao
            HibernateUtil.setSession();

            //consulta
            retornoPedido = this.pedidoDao.recUltimoPedidoVenda(rev);

            //Log
            LogUtil.logSucesso(Pedido.class, "recUltimoPedidoVenda", rev.getId());

        } catch (ServerException ex) {
            //log
            LogUtil.logDescricaoErro(Pedido.class, "Erro ao recuperar ultimo pedido venda do fornecedor " + rev.getId(), ex);
            throw ex;
        } finally {
            //log
            LogUtil.logFimProcessoMetodo(Pedido.class, "recUltimoPedidoVenda");

            //fecha Sessao
            HibernateUtil.getSession().close();
        }

        return retornoPedido;
    }

    /**
     * Salvar Fornecedor
     * @param fornecedor 
     */
    private void salvarFornecedor(Fornecedor fornecedor) throws ServerException {
        FornecedorBoImpl fornecedorBo = new FornecedorBoImpl();
        FornecedorDaoImpl fornecedorDao = new FornecedorDaoImpl();
        fornecedorBo.setFornecedorDao(fornecedorDao);
        fornecedorBo.mantemFornecedor(fornecedor);
    }

    @Override
    public List recRelatorioPedidosPorRevendedor(HashMap<String, Object> parameter) throws ServerException {
        List retornoPedido = null;
        try {
            //Log
            LogUtil.logInicioProcessoMetodo(Pedido.class, "recRelatorioPedidosPorRevendedor");

            //Abrir sessao
            HibernateUtil.setSession();

            //consulta
            retornoPedido = this.pedidoDao.recRelatorioPedidosPorRevendedor(parameter);

            //Log
            LogUtil.logSucesso(Pedido.class, "recRelatorioPedidosPorRevendedor");
        } catch (ServerException ex) {
            //log
            LogUtil.logDescricaoErro(Pedido.class, "Erro ao recuperar os dados para o relatorio de venda por revendedor", ex);
            throw ex;
        } finally {
            //log
            LogUtil.logFimProcessoMetodo(Pedido.class, "recRelatorioPedidosPorRevendedor");

            //fecha Sessao
            HibernateUtil.getSession().close();
        }

        return retornoPedido;
    }
}
