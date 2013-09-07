/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.servico.service;

import br.com.dcoracoes.servico.beans.cadastro.Pessoa;
import br.com.dcoracoes.servico.beans.cadastro.PessoaFisica;
import br.com.dcoracoes.servico.beans.cadastro.Revendedor;
import br.com.dcoracoes.servico.beans.cadastro.ViewRevendedor;
import br.com.dcoracoes.servico.beans.pedido.PedidoVenda;
import br.com.dcoracoes.transacao.classes.TnRevendedor;
import br.com.dcoracoes.transacao.constantes.ConstanteTnRevendedor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.dozer.MappingException;

/**
 *
 * @author Jose Robson
 */
public class ServiceRevendedor<T extends ViewRevendedor> extends ServiceBase<T> implements IServiceRevendedor<T> {

    private TnRevendedor tnRevendedor = null;

    public ServiceRevendedor() {
        this.tnRevendedor = new TnRevendedor();
    }

    @Override
    public void salvar(Object param) throws Exception {
        try {
            tnRevendedor.setViewRevendedor((br.com.dcoracoes.transacao.classes.view.ViewRevendedor) converteToModel(param));
            tnRevendedor.salvar(ConstanteTnRevendedor.NOME_EVENTO_SALVAR_REVENDEDOR);
        } catch (MappingException ex) {
            throw ex;
        }
    }
    
    @Override
    public Object salvarComRetorno(Object param) throws Exception {
        try {
            tnRevendedor.setViewRevendedor((br.com.dcoracoes.transacao.classes.view.ViewRevendedor) converteToModel(param));
            tnRevendedor.salvar(ConstanteTnRevendedor.NOME_EVENTO_SALVAR_REVENDEDOR);
            return converteToBean(tnRevendedor.getViewRevendedor());

        } catch (MappingException ex) {
            throw ex;
        }
    }

    @Override
    public List<T> recTodos(Object param) throws Exception {
        List<T> listViewRevendedorBeans = null;
        try {

            br.com.dcoracoes.server.model.cadastro.Revendedor rev = this.mapper.map(param, br.com.dcoracoes.server.model.cadastro.Revendedor.class);
            List<br.com.dcoracoes.transacao.classes.view.ViewRevendedor> listRevendedorModel = tnRevendedor.recListaViewRevendedor(rev);
            listViewRevendedorBeans = getListToBeans(listRevendedorModel);
        } catch (MappingException ex) {
            throw ex;
        }

        return listViewRevendedorBeans;
    }

    @Override
    public List getListToBeans(List listModel) throws ClassNotFoundException {
        List<T> listBeans = null;
        if (listModel != null
                && !listModel.isEmpty()) {
            listBeans = new ArrayList<T>();
            Iterator<br.com.dcoracoes.transacao.classes.view.ViewRevendedor> iterator = listModel.iterator();
            while (iterator.hasNext()) {
                listBeans.add((T) converteToBean(iterator.next()));
            }
        }

        return listBeans;
    }

    @Override
    public T converteToBean(Object param) throws ClassNotFoundException {
        return (T) this.mapper.map(param, ViewRevendedor.class);
    }

    @Override
    public Object converteToModel(Object param) throws ClassNotFoundException {
        return this.mapper.map(param, br.com.dcoracoes.transacao.classes.view.ViewRevendedor.class);
    }

    @Override
    public T recUltimoRevendedorCadastro() throws Exception {

        T viewRevendedor = null;
        try {
            tnRevendedor.recUltimoRevendedorCadastrado();
            viewRevendedor = (T) converteToBean(tnRevendedor.getViewRevendedor());

        } catch (MappingException ex) {
            throw ex;
        }

        return viewRevendedor;
    }

    @Override
    public int recCodigoSequencia() throws Exception {
        return tnRevendedor.recCodigoSequencial();
    }

    @Override
    public String validaCPF(PessoaFisica pessoa) throws Exception {

        String retorno = "";

        try {
            br.com.dcoracoes.server.model.cadastro.PessoaFisica pf =
                    this.mapper.map(pessoa, br.com.dcoracoes.server.model.cadastro.PessoaFisica.class);
            retorno = tnRevendedor.validaCPF(pf);
        } catch (MappingException ex) {
            throw ex;
        }

        return retorno;
    }

    @Override
    public PedidoVenda recUltimoPedidoVenda(Revendedor rev) throws Exception {

        PedidoVenda pedidoVendaBean = null;

        try {
            br.com.dcoracoes.transacao.classes.view.ViewRevendedor viewRevendedor =
                    new br.com.dcoracoes.transacao.classes.view.ViewRevendedor();
            br.com.dcoracoes.server.model.cadastro.Revendedor revModel =
                    this.mapper.map(rev, br.com.dcoracoes.server.model.cadastro.Revendedor.class);
            viewRevendedor.setRevendedor(revModel);

            tnRevendedor.setViewRevendedor(viewRevendedor);

            br.com.dcoracoes.server.model.pedido.PedidoVenda pedidoVendaModel = tnRevendedor.recUltimoPedidoVenda();
            if(pedidoVendaBean != null)
                pedidoVendaBean = this.mapper.map(pedidoVendaModel, PedidoVenda.class);

        } catch (MappingException ex) {
            throw ex;
        }

        return pedidoVendaBean;
    }

    @Override
    public List<Pessoa> recRevendedorEtiqueta(HashMap<String, Object> parameter) throws Exception {

        List<Pessoa> lstPessoasBeans = null;
        try {

            List<br.com.dcoracoes.server.model.cadastro.Pessoa> lstPessoasModel = tnRevendedor.recRevendedorEtiqueta(parameter);

            if (lstPessoasModel != null
                    && !lstPessoasModel.isEmpty()) {
                lstPessoasBeans = new ArrayList<Pessoa>();
                Iterator<br.com.dcoracoes.server.model.cadastro.Pessoa> iterator = lstPessoasModel.iterator();
                while (iterator.hasNext()) {
                    Pessoa pessoaBean = this.mapper.map(iterator.hasNext(), Pessoa.class);
                    lstPessoasBeans.add(pessoaBean);
                }
            }

        } catch (MappingException ex) {
            throw ex;
        }

        return lstPessoasBeans;
    }

    @Override
    public Pessoa recPessoaPorId(Long id) throws Exception {

        Pessoa pessoaBean = null;
        try {

            br.com.dcoracoes.server.model.cadastro.Pessoa pessoaModel = tnRevendedor.recPessoaPorId(id);
            pessoaBean = this.mapper.map(pessoaModel, Pessoa.class);
        } catch (MappingException ex) {
            throw ex;
        }

        return pessoaBean;
    }
}
