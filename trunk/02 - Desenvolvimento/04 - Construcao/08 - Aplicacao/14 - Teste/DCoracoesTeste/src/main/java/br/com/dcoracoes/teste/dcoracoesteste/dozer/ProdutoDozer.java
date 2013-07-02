/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.teste.dcoracoesteste.dozer;

import br.com.dcoracoes.teste.dcoracoes.beans.Cor;
import br.com.dcoracoes.teste.dcoracoes.beans.Fornecedor;
import br.com.dcoracoes.teste.dcoracoes.beans.ItemProduto;
import br.com.dcoracoes.teste.dcoracoes.beans.Produto;
import java.util.ArrayList;
import java.util.List;
import org.dozer.MappingException;

/**
 *
 * @author Jose Robson
 */
public class ProdutoDozer extends BaseDozer {

    @Override
    public void convertBeanParaModel() {
        
        br.com.dcoracoes.server.model.produto.Produto model = null;
        
        try
        {
            Produto bean = (Produto)getBean();
            model = this.mapper.map(bean, br.com.dcoracoes.server.model.produto.Produto.class);
            
        }catch(MappingException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        isConvertOk(model);
    }

    @Override
    public void convertModelParaBean() {
        
        Produto bean = null;
        
        try{
            br.com.dcoracoes.server.model.produto.Produto model = 
                    (br.com.dcoracoes.server.model.produto.Produto)getModel();
            bean = this.mapper.map(model,Produto.class );
            
        }catch(MappingException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        isConvertOk(bean);
    }

    @Override
    public Object getBean() {
        Produto bean = new Produto();
        bean.setId(Long.MIN_VALUE);
        bean.setCodigoBarra("12312312312");
        bean.setCodigoForFiscal("134234");
        bean.setCodigoProFiscal("123123");
        bean.setDescricao("12312323");
        bean.setEstoqueBaixo(Boolean.TRUE);
        bean.setEstoqueTotal(123);
        bean.setEstoqueTotal(12);
        
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(Long.MIN_VALUE);
        fornecedor.setPessoa(UtilDozer.getPessoaFisicaBean());        
        bean.setFornecedor(fornecedor);
        
        ItemProduto itemProduto = new ItemProduto();
        Cor cor = new Cor();
        cor.setCodigo("12312");
        cor.setDescricao("234234");
        cor.setId(Long.MIN_VALUE);
        itemProduto.setCor(cor);
        itemProduto.setEstoqueAtual(12);
        itemProduto.setEstoqueMinimo(1);
        itemProduto.setId(Long.MIN_VALUE);
        itemProduto.setProduto(bean);
        
        List<ItemProduto> lstItemProduto = new ArrayList<ItemProduto>();
        lstItemProduto.add(itemProduto);
        bean.setListaItensProduto(lstItemProduto);
        bean.setReferenciaCatalogo("123");
        bean.setValorCusto(Float.MAX_EXPONENT);
        bean.setValorVenda(Float.MAX_VALUE);
        
        return bean;
    }

    @Override
    public Object getModel() {
        br.com.dcoracoes.server.model.produto.Produto model = 
                new br.com.dcoracoes.server.model.produto.Produto();
        model.setId(Long.MIN_VALUE);
        model.setCodigoBarra("12312312312");
        model.setCodigoForFiscal("134234");
        model.setCodigoProFiscal("123123");
        model.setDescricao("12312323");
        model.setEstoqueBaixo(Boolean.TRUE);
        model.setEstoqueTotal(123);
        model.setEstoqueTotal(12);
        
        br.com.dcoracoes.server.model.produto.Fornecedor fornecedor = 
                new br.com.dcoracoes.server.model.produto.Fornecedor();
        fornecedor.setId(Long.MIN_VALUE);
        fornecedor.setPessoa(UtilDozer.getPessoaFisicaModel());        
        model.setFornecedor(fornecedor);
        
        br.com.dcoracoes.server.model.produto.ItemProduto itemProduto = 
                new br.com.dcoracoes.server.model.produto.ItemProduto();
        br.com.dcoracoes.server.model.produto.Cor cor = 
                new br.com.dcoracoes.server.model.produto.Cor();
        cor.setCodigo("12312");
        cor.setDescricao("234234");
        cor.setId(Long.MIN_VALUE);
        itemProduto.setCor(cor);
        itemProduto.setEstoqueAtual(12);
        itemProduto.setEstoqueMinimo(1);
        itemProduto.setId(Long.MIN_VALUE);
        itemProduto.setProduto(model);
        
        List<br.com.dcoracoes.server.model.produto.ItemProduto> lstItemProduto 
                = new ArrayList<br.com.dcoracoes.server.model.produto.ItemProduto>();
        lstItemProduto.add(itemProduto);
        model.setListaItensProduto(lstItemProduto);
        model.setReferenciaCatalogo("123");
        model.setValorCusto(Float.MAX_EXPONENT);
        model.setValorVenda(Float.MAX_VALUE);
        
        return model;
    }
}
