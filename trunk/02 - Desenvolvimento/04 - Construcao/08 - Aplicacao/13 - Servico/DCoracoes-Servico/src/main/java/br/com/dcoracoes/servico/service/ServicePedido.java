/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.servico.service;

import br.com.dcoracoes.servico.beans.cadastro.Revendedor;
import br.com.dcoracoes.servico.beans.pedido.Parcela;
import br.com.dcoracoes.servico.beans.pedido.Pedido;
import br.com.dcoracoes.transacao.classes.TnPedido;
import br.com.dcoracoes.transacao.constantes.ConstanteTnPedido;
import br.com.dcoracoes.transacao.excecao.TransException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.dozer.MappingException;

/**
 *
 * @author Jose Robson
 */
public class ServicePedido<T extends Pedido> extends ServiceBase implements IServicePedido {

    private TnPedido tnPedido = null;

    public ServicePedido() {
        this.tnPedido = new TnPedido();
    }

    @Override
    public void salvar(Object param) throws Exception {
        try {
            tnPedido.setPedido((br.com.dcoracoes.server.model.pedido.Pedido) converteToModel(param));
            tnPedido.salvar(ConstanteTnPedido.NOME_EVENTO_SALVAR_PEDIDO);
        } catch (MappingException ex) {
            throw ex;
        }
    }

    @Override
    public Object salvarComRetorno(Object param) throws Exception {
        try {
            tnPedido.setPedido((br.com.dcoracoes.server.model.pedido.Pedido) converteToModel(param));
            tnPedido.salvar(ConstanteTnPedido.NOME_EVENTO_SALVAR_PEDIDO);
            return converteToBean(tnPedido.getPedido());
        } catch (MappingException ex) {
            throw ex;
        }
    }

    @Override
    public List<T> recTodos(Object param) throws Exception {
        List<T> listPedidosBeans = null;

        try {
            List<br.com.dcoracoes.server.model.pedido.Pedido> listPedidosModel =
                    tnPedido.recPedidos((br.com.dcoracoes.server.model.pedido.Pedido) this.mapper.map(param, getClassToModel(param)));
            listPedidosBeans = getListToBeans(listPedidosModel);
        } catch (MappingException ex) {
            throw ex;
        }
        
        return listPedidosBeans;
        
    }

    @Override
    public String recCodigoOrcamento() throws Exception {
        return tnPedido.recCodigoOrcamento();
    }

    @Override
    public boolean aprovarPedido(Pedido pedido) throws Exception {

        boolean aprovarPedido = false;

        try {
            tnPedido.setPedido((br.com.dcoracoes.server.model.pedido.Pedido) converteToModel(pedido));
            aprovarPedido = tnPedido.aprovarPedido(ConstanteTnPedido.NOME_EVENTO_APROVAR_PEDIDO);

        } catch (MappingException ex) {
            throw ex;
        }

        return aprovarPedido;
    }

    @Override
    public List<T> recRelatorioPedidosPorRevendedor(HashMap parameter) throws Exception {
        List<T> listPedidosBeans = null;
        try {
            List<br.com.dcoracoes.server.model.pedido.PedidoVenda> listPedidosModel =
                    tnPedido.recRelatorioPedidosPorRevendedor(parameter);
            listPedidosBeans = getListToBeans(listPedidosModel);
        } catch (MappingException ex) {
            throw ex;
        }

        return listPedidosBeans;
    }

    @Override
    public T deletar(Object param) throws Exception {

        T pedidoBean = null;

        try {
            tnPedido.setPedido((br.com.dcoracoes.server.model.pedido.Pedido) converteToModel(param));
            tnPedido.deletar(ConstanteTnPedido.NOME_EVENTO_DELETAR_PEDIDO);
            pedidoBean = this.converteToBean(tnPedido.getPedido());
        } catch (MappingException ex) {
            throw ex;
        }

        return pedidoBean;
    }

    @Override
    public Class getClassToModel(Object param) throws ClassNotFoundException {
        return Class.forName("br.com.dcoracoes.server.model.pedido." + param.getClass().getSimpleName());
    }

    @Override
    public Class getClassToBean(Object param) throws ClassNotFoundException {
        return Class.forName("br.com.dcoracoes.servico.beans.pedido." + param.getClass().getSimpleName());
    }

    @Override
    public Object converteToModel(Object param) throws ClassNotFoundException {
        return (br.com.dcoracoes.server.model.pedido.Pedido) this.mapper.map(param, getClassToModel(param));
    }

    @Override
    public T converteToBean(Object param) throws ClassNotFoundException {
        return (T) this.mapper.map(param, getClassToBean(param));
    }

    @Override
    public List<T> getListToBeans(List listPedidosModel) throws ClassNotFoundException {
        List<T> listPedidosBeans = null;

        if (listPedidosModel != null
                && !listPedidosModel.isEmpty()) {
            listPedidosBeans = new ArrayList<T>();
            Iterator<br.com.dcoracoes.server.model.pedido.Pedido> iterator = listPedidosModel.iterator();
            while (iterator.hasNext()) {
                
                br.com.dcoracoes.server.model.pedido.PedidoVenda p = (br.com.dcoracoes.server.model.pedido.PedidoVenda) iterator.next();
                //p.setRevendedor(null);        
                //p.setPagamento(null);                                
                listPedidosBeans.add(converteToBean(p));
            }
        }        
        
        return listPedidosBeans;
    }
    
    @Override
    public List<Parcela> recHistoricoParcelas(Revendedor param) throws Exception {

        List<Parcela> listParcelasBeans = null;
        try {
            List<br.com.dcoracoes.server.model.pedido.Parcela> listParcelaModel =
                    tnPedido.recHistoricoParcelas(this.mapper.map(param, br.com.dcoracoes.server.model.cadastro.Revendedor.class));

            listParcelasBeans = getListToBeansParcela(listParcelaModel);

        } catch (TransException ex) {
            throw new Exception(ex);
        }

        return listParcelasBeans;
    }
    
    public List<Parcela> getListToBeansParcela(List listParcelasModel) throws ClassNotFoundException {
        List<Parcela> listParcelasBeans = null;

        if (listParcelasModel != null
                && !listParcelasModel.isEmpty()) {
            listParcelasBeans = new ArrayList<Parcela>();
            Iterator<br.com.dcoracoes.server.model.pedido.Parcela> iterator = listParcelasModel.iterator();
            while (iterator.hasNext()) {
                
                br.com.dcoracoes.server.model.pedido.Parcela p = (br.com.dcoracoes.server.model.pedido.Parcela) iterator.next();
                //p.setRevendedor(null);        
                //p.setPagamento(null);                                
                listParcelasBeans.add(converteToBeanParcela(p));
            }
        }        
        
        return listParcelasBeans;
    }
    
    public Parcela converteToBeanParcela(Object param) throws ClassNotFoundException {
        return (Parcela) this.mapper.map(param, getClassToBeanParcela(param));
    }
    
    public Class getClassToBeanParcela(Object param) throws ClassNotFoundException {
        return Class.forName("br.com.dcoracoes.servico.beans.pedido." + param.getClass().getSimpleName());
    }
}
