/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.teste.dcoracoesteste.dozer;

import br.com.dcoracoes.teste.dcoracoes.beans.CodigoItem;
import br.com.dcoracoes.teste.dcoracoes.beans.ItemPedido;
import br.com.dcoracoes.teste.dcoracoes.beans.Pedido;
import br.com.dcoracoes.teste.dcoracoes.beans.PedidoCompra;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.ehcache.Cache;
import org.dozer.MappingException;

/**
 *
 * @author Jose Robson
 */
public class PedidoDozer extends BaseDozer {

    @Override
    public void convertBeanParaModel() {

        br.com.dcoracoes.server.model.pedido.Pedido model = null;

        try {
            Pedido bean = (Pedido) getBean();

            Class cl = Class.forName("br.com.dcoracoes.server.model.pedido." + bean.getClass().getSimpleName());

            model = (br.com.dcoracoes.server.model.pedido.Pedido) this.mapper.map(bean, cl);

        } catch (MappingException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoDozer.class.getName()).log(Level.SEVERE, null, ex);
        }

        isConvertOk(model);
    }

    @Override
    public void convertModelParaBean() {

        Pedido bean = null;

        try {
            br.com.dcoracoes.server.model.pedido.Pedido model =
                    (br.com.dcoracoes.server.model.pedido.Pedido) getModel();

            bean = this.mapper.map(model, Pedido.class);
        } catch (MappingException ex) {
            System.out.println(ex.getMessage());
        }

        isConvertOk(bean);
    }

    @Override
    public Object getBean() {

        PedidoCompra pedido = new PedidoCompra();
        pedido.setCodigo("123");
        pedido.setDataPedido(new Date());
        pedido.setDescontoDinheiro(Float.MAX_VALUE);
        pedido.setDescontoPorcentagem(Float.MIN_VALUE);
        pedido.setId(Long.MIN_VALUE);
        pedido.setSubTotal(Float.MAX_EXPONENT);
        pedido.setTotal(Float.MIN_NORMAL);

        ItemPedido item = new ItemPedido();
        CodigoItem codigoItem = new CodigoItem();
        codigoItem.setId(Long.MAX_VALUE);
        codigoItem.setCodigo("123123");
        codigoItem.setTipo(1);
        item.setCodigo(codigoItem);
        item.setCodigoFiscal("1212");
        item.setCor("213");
        item.setCorPorExtenso("123123123");
        item.setDescricao("123123");
        item.setId(Long.MAX_VALUE);
        item.setIdItemProduto(Long.MAX_VALUE);
        item.setPedido(pedido);
        item.setQuantidade(12);
        item.setValorTotal(Float.MAX_EXPONENT);
        item.setValorUnitario(Float.MIN_EXPONENT);
        List<ItemPedido> lstItem = new ArrayList<ItemPedido>();
        pedido.setListaItensPedido(lstItem);

        pedido.setFornecedor(null);

        return pedido;
    }

    @Override
    public Object getModel() {
        br.com.dcoracoes.server.model.pedido.Pedido pedido =
                new br.com.dcoracoes.server.model.pedido.Pedido();
        pedido.setCodigo("123");
        pedido.setDataPedido(new Date());
        pedido.setDescontoDinheiro(Float.MAX_VALUE);
        pedido.setDescontoPorcentagem(Float.MIN_VALUE);
        pedido.setId(Long.MIN_VALUE);
        pedido.setSubTotal(Float.MAX_EXPONENT);
        pedido.setTotal(Float.MIN_NORMAL);

        br.com.dcoracoes.server.model.pedido.ItemPedido item =
                new br.com.dcoracoes.server.model.pedido.ItemPedido();
        br.com.dcoracoes.server.model.pedido.CodigoItem codigoItem =
                new br.com.dcoracoes.server.model.pedido.CodigoItem();
        codigoItem.setId(Long.MAX_VALUE);
        codigoItem.setCodigo("123123");
        codigoItem.setTipo(1);
        item.setCodigo(codigoItem);
        item.setCodigoFiscal("1212");
        item.setCor("213");
        item.setCorPorExtenso("123123123");
        item.setDescricao("123123");
        item.setId(Long.MAX_VALUE);
        item.setIdItemProduto(Long.MAX_VALUE);
        item.setPedido(pedido);
        item.setQuantidade(12);
        item.setValorTotal(Float.MAX_EXPONENT);
        item.setValorUnitario(Float.MIN_EXPONENT);
        List<br.com.dcoracoes.server.model.pedido.ItemPedido> lstItem =
                new ArrayList<br.com.dcoracoes.server.model.pedido.ItemPedido>();
        pedido.setListaItensPedido(lstItem);

        return pedido;
    }
}
