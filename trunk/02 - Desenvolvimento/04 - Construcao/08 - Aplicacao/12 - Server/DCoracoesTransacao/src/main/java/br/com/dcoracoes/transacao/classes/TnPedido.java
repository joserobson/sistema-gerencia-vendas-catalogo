/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.transacao.classes;

import br.com.dcoracoes.server.bo.cadastro.RevendedorBoImpl;
import br.com.dcoracoes.server.bo.pedido.PedidoBoImpl;
import br.com.dcoracoes.server.dao.cadastro.RevendedorDaoImpl;
import br.com.dcoracoes.server.enuns.Enum_Forma_Pagamento;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.cadastro.Revendedor;
import br.com.dcoracoes.server.model.pedido.Pedido;
import br.com.dcoracoes.server.model.pedido.PedidoCompra;
import br.com.dcoracoes.server.model.pedido.PedidoVenda;
import br.com.dcoracoes.transacao.constantes.ConstanteTnPedido;
import br.com.dcoracoes.transacao.excecao.TransException;
import br.com.dcoracoes.transacao.interfaces.InterfaceTransacao;
import br.com.dcoracoes.transacao.util.TransacaoUtil;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Robson
 */
public class TnPedido implements InterfaceTransacao {

    /**
     * ATRIBUTOS DA CLASSE
     */
    private Pedido pedido;

    /**
     * METODOS CONSTRUTORES
     */
    public TnPedido() {
    }

    /**
     * METODOS ACESSORES
     * @param pedido 
     */
    public TnPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    /**
     * SALVAR PEDIDO
     * @param evento
     * @throws TransException 
     */
    @Override
    public void salvar(String evento) throws TransException {
        try {
            if (validarDados(evento)) {

                //SalvarPedido
                PedidoBoImpl pedidoBo = (PedidoBoImpl) TransacaoUtil.getInstanceBo(Pedido.class);
                pedidoBo.mantemPedido(pedido);

                if (pedido.getClass().equals(PedidoVenda.class)) {
                    //Atualizar Dados de Crédito do Revendedor
                    this.atualizaDadosCreditoRevendedor(pedido);
                }
            }
        } catch (ServerException ex) {
            throw new TransException(ex);
        }
    }

    /**
     * VALIDAR METODOS PARA PEDIDO
     * @param evento
     * @return
     * @throws TransException 
     */
    @Override
    public boolean validarDados(String evento) throws TransException {

        boolean retorno = true;
        try {
            if (evento == ConstanteTnPedido.NOME_EVENTO_APROVAR_PEDIDO) {
                retorno = false;
                if (this.pedido.getClass().equals(PedidoVenda.class)) {
                    PedidoVenda pv = (PedidoVenda) this.pedido;
                    if (pv.getRevendedor() != null
                            && pv.getValorPedidoEscrito() > 0
                            && pv.getPagamento() != null
                            && pv.getPagamento().getFormaPagamento() > 0) {
                        retorno = true;
                    }
                }
            }

        } catch (Exception ex) {
            throw new TransException(ex);
        }

        return retorno;
    }

    /**
     * DELETAR PEDIDO
     * @param evento
     * @throws TransException 
     */
    @Override
    public void deletar(String evento) throws TransException {
        try {
            if (validarDados(evento)) {
                PedidoBoImpl pedidoBo = (PedidoBoImpl) TransacaoUtil.getInstanceBo(Pedido.class);
                pedidoBo.removePedido(this.pedido);
            }
        } catch (ServerException ex) {
            throw new TransException(ex);
        }
    }

    /**
     * RECUPERAR LISTA DE PEDIDOS DE ACORDO COM O PARAMETRO
     * RECUPERAR DE FORMA DINAMICA
     * @param pedido
     * @return
     * @throws TransException 
     */
    public List<Pedido> recPedidos(Pedido pedido) throws TransException {
        List<Pedido> listaRetorno = null;
        try {
            PedidoBoImpl pedidoBo = (PedidoBoImpl) TransacaoUtil.getInstanceBo(Pedido.class);
            listaRetorno = pedidoBo.recPedidos(pedido);

        } catch (ServerException ex) {
            throw new TransException(ex);
        }
        return listaRetorno;
    }

    /**
     * RECUPERA LISTA DE PEDIDOS VENDA
     * @param pedido
     * @return
     * @throws TransException
     */
    public List<PedidoVenda> recPedidosVenda(PedidoVenda pedido) throws TransException {
        List<PedidoVenda> listaRetorno = null;
        try {
            PedidoBoImpl pedidoBo = (PedidoBoImpl) TransacaoUtil.getInstanceBo(Pedido.class);
            listaRetorno = pedidoBo.recPedidos(pedido);

        } catch (ServerException ex) {
            throw new TransException(ex);
        }
        return listaRetorno;
    }

    /**
     * 
     * @return 
     */
    public String recCodigoOrcamento() throws TransException {
        String codigoRetorno = null;
        try {
            PedidoBoImpl pedidoBo = (PedidoBoImpl) TransacaoUtil.getInstanceBo(Pedido.class);
            int codigo = pedidoBo.recMaxCodigoPedido();
            codigoRetorno = this.formatarCodigoOrcamento(codigo);
        } catch (ServerException ex) {
            throw new TransException(ex);
        }

        return codigoRetorno;
    }

    /**
     * FORMATA CODIGO ORCAMENTO PARA FICAR NO PADRAO #00001#
     * @param cod
     * @return 
     */
    private String formatarCodigoOrcamento(int cod) {
        String codigoRetorno = "1";
        if (cod != -1) {
            codigoRetorno = String.valueOf(cod + 1);
        }

        int tamMax = 5;
        int tamCodigo = codigoRetorno.length();
        for (int i = 0; i < tamMax - tamCodigo; i++) {
            codigoRetorno = "0" + codigoRetorno;
        }
        return codigoRetorno;
    }

    /**
     * METODO PARA APROVAR PEDIDO PARA O REVENDEDOR 
     * OS ATRIBUTOS VALOR DO PEDIDO ESCRITO 
     * TIPO DA FORMA DE PAGAMENTO E FORNECEDOR DEVEM ESTAR PREENCHIDOS
     * @param pedido
     * @return 
     */
    public boolean aprovarPedido(String evento) throws TransException {

        boolean sePedidoAprovado = true;
        PedidoVenda pedidoVenda = (PedidoVenda) this.pedido;

        try {
            if (validarDados(evento)) {
                //Atualizar dados de Crédito do Revendedor
                this.atualizaDadosCreditoRevendedor(pedidoVenda.getRevendedor());

                //verifica tipo de pagamento
                if (pedidoVenda.getPagamento().getFormaPagamento() == Enum_Forma_Pagamento.APRAZO.getCodigo()) {
                    //verificar se o Revendedor tem Crédito para cobrir o valor do Pedido
                    //de acordo com o tipo de pedido
                    if (pedidoVenda.getRevendedor().getLimiteUtilizavel() == 0
                            || pedidoVenda.getRevendedor().getLimiteUtilizavel() < pedidoVenda.getValorPedidoEscrito()) {
                        sePedidoAprovado = false;
                    }
                }
            }
        } catch (ServerException ex) {
            throw new TransException(ex);
        }
        return sePedidoAprovado;
    }

    /**
     * Metodo para atualizar dados de Crédito do Revendedor
     * @param pedido
     * @throws ServerException 
     */
    private void atualizaDadosCreditoRevendedor(Pedido pedido) throws ServerException {
        try {
            PedidoVenda pedidoVenda = (PedidoVenda) pedido;
            if (pedidoVenda.getPagamento().getFormaPagamento() != Enum_Forma_Pagamento.AVISTA.getCodigo()) {
                RevendedorBoImpl revendedorBo = new RevendedorBoImpl();
                RevendedorDaoImpl revendedorDao = new RevendedorDaoImpl();
                revendedorBo.setRevendedorDao(revendedorDao);
                revendedorBo.atualizaDadosCreditoRevendedor((PedidoVenda) pedido);
            }
        } catch (ServerException ex) {
            throw ex;
        }

    }

    /**
     * METODO PARA ATUALIZAR DADOS DE CREDITO DO REVENDEDOR
     * @param pedido
     * @throws ServerException 
     */
    private void atualizaDadosCreditoRevendedor(Revendedor revendedor) throws ServerException {
        try {
            RevendedorBoImpl revendedorBo = new RevendedorBoImpl();
            RevendedorDaoImpl revendedorDao = new RevendedorDaoImpl();
            revendedorBo.setRevendedorDao(revendedorDao);
            revendedorBo.atualizaDadosCreditoRevendedor(revendedor);
        } catch (ServerException ex) {
            throw ex;
        }

    }

    /**
     * RECUPERA LISTA DE PEDIDOS COMPRA
     * @param pedido
     * @return
     * @throws TransException
     */
    public List<PedidoCompra> recPedidosCompra(PedidoCompra pedido) throws TransException {
        List<PedidoCompra> listaRetorno = null;
        try {
            PedidoBoImpl pedidoBo = (PedidoBoImpl) TransacaoUtil.getInstanceBo(Pedido.class);
            listaRetorno = pedidoBo.recPedidos(pedido);

        } catch (ServerException ex) {
            throw new TransException(ex);
        }
        return listaRetorno;
    }

    /**
     * RECUPERA LISTA DE VENDA POR REVENDEDOR PARA OS PARAMETROS PASSADOS
     * @param HashMap
     * @return
     * @throws TransException 
     */
    public List recRelatorioPedidosPorRevendedor(HashMap<String, Object> parameter) throws TransException {
        List listaRetorno = null;
        try {
            PedidoBoImpl pedidoBo = (PedidoBoImpl) TransacaoUtil.getInstanceBo(Pedido.class);
            listaRetorno = pedidoBo.recRelatorioPedidosPorRevendedor(parameter);

        } catch (ServerException ex) {
            throw new TransException(ex);
        }
        return listaRetorno;
    }
}
