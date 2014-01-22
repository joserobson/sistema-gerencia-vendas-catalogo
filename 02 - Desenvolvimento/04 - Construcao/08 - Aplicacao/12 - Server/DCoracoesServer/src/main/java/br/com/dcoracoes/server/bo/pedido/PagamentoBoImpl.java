     /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.bo.pedido;

import br.com.dcoracoes.server.dao.pedido.PagamentoDao;
import br.com.dcoracoes.server.dao.pedido.ParcelaDaoImpl;
import br.com.dcoracoes.server.enuns.Enum_Forma_Pagamento;
import br.com.dcoracoes.server.enuns.Enum_Situacao_Parcela;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.pedido.Pagamento;
import br.com.dcoracoes.server.model.pedido.Parcela;
import br.com.dcoracoes.server.util.LogUtil;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Robson
 */
public class PagamentoBoImpl<T extends Pagamento> implements PagamentoBo<T> {

    private PagamentoDao dao;

    @Override
    public void setPagamentoDao(PagamentoDao dao) {
        this.dao = dao;
    }

    @Override
    public void mantemPagamento(T pagamento) throws ServerException {
        //Log
        LogUtil.logInicioProcessoMetodo(Pagamento.class, "mantemPagamento");
        try {

            //associa parcelas ao pagamento
            if (pagamento.getListaParcelas() != null && pagamento.getListaParcelas().size() > 0)
            {
                for (Parcela p : pagamento.getListaParcelas()) {
                    p.setPagamento(pagamento);
                }
            }
            
            //salvar Pagamento
            this.dao.mantemPagamento(pagamento);

            //Log
            LogUtil.logSucesso(Pagamento.class, "mantemPagamento");

        } catch (ServerException ex) {
            throw new ServerException("ERRO AO SALVAR PAGAMENTO", ex);
        } catch (Exception exGenerica) {
            throw new ServerException("ERRO AO SALVAR PAGAMENTO", exGenerica);
        } finally {
            LogUtil.logFimProcessoMetodo(Pagamento.class, "mantemPagamento");
        }
    }

    @Override
    public List<T> recPagamentos(T pagamento) throws ServerException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * GERAR PARCELAS PARA O PAGAMENTO CORRENTE
     * @param pagamentoPedido
     * @throws ServerException 
     */
    @Deprecated
    private void gerarParcelasPagamento(Pagamento pagamentoPedido) throws ServerException {
        try {

            //Calcular valor das parcelas
            Float valorParcela = pagamentoPedido.getValor() / 2;

            //gerar primeira parcela para 60 dias
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DAY_OF_YEAR, 60);
            Date dataParcela = c.getTime();
            gerarParcela(dataParcela, pagamentoPedido, valorParcela);

            //gerar segunda Parcela para 90 dias
            c.add(Calendar.DAY_OF_YEAR, 30);
            dataParcela = c.getTime();
            gerarParcela(dataParcela, pagamentoPedido, valorParcela);


        } catch (ServerException ex) {
            LogUtil.logDescricaoErro(PedidoBoImpl.class, "ERRO AO GERAR PARCELAS PARA O PAGAMENTO " + pagamentoPedido.getId(), ex);
            throw ex;
        } catch (Exception exGenerica) {
            LogUtil.logDescricaoErro(PedidoBoImpl.class, "ERRO AO GERAR PARCELAS PARA O PAGAMENTO " + pagamentoPedido.getId(), exGenerica);
            throw new ServerException(exGenerica);
        }
    }

    /**
     * METODO PARA GERAR E SALVAR PARCELA
     * @param dataParcela
     * @param pagamento
     * @param valor
     * @throws ServerException 
     */
    private void gerarParcela(Date dataParcela, Pagamento pagamento, float valor) throws ServerException {
        try {
            //Seta dados da parcela
            Parcela parcela = new Parcela();
            parcela.setDataVencimento(dataParcela);
            parcela.setStatus(Enum_Situacao_Parcela.PENDENTE.getCodigo());
            parcela.setValor(valor);
            parcela.setPagamento(pagamento);

            //Salva a parcela
            ParcelaBoImpl parcelaBo = new ParcelaBoImpl();
            ParcelaDaoImpl parcelaDao = new ParcelaDaoImpl();
            parcelaBo.setParcelaDao(parcelaDao);
            parcelaBo.mantemParcela(parcela);

        } catch (ServerException ex) {
            throw ex;
        }

    }

    /**
     * metodo para salvar as parcelas do pagamento
     *
     * @param pagamento
     */
    private void salvarParcelas(Pagamento pagamento) throws ServerException{
        try {

            if (pagamento.getListaParcelas() != null
                    && pagamento.getListaParcelas().size() > 0) {
                for (Parcela p : pagamento.getListaParcelas()) {
                    //Salva a parcela
                    ParcelaBoImpl parcelaBo = new ParcelaBoImpl();
                    ParcelaDaoImpl parcelaDao = new ParcelaDaoImpl();
                    parcelaBo.setParcelaDao(parcelaDao);
                    p.setPagamento(pagamento);
                    parcelaBo.mantemParcela(p);
                }
            }
        } catch (ServerException ex) {
            throw ex;
        }
    }
}
