/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.servico.service;

import br.com.dcoracoes.servico.beans.canalacesso.Permissao;
import br.com.dcoracoes.transacao.classes.TnPermissao;
import br.com.dcoracoes.transacao.constantes.ConstanteTnPermissao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dozer.MappingException;

/**
 *
 * @author Jose Robson
 */
public class ServicePermissao<T extends Permissao> extends ServiceBase<T> implements IServicePermissao<T> {

    private TnPermissao tnPermissao;

    public ServicePermissao() {
        this.tnPermissao = new TnPermissao();
    }

    @Override
    public void salvar(Object param) throws Exception {
        try {
            tnPermissao.setPermissao((br.com.dcoracoes.server.model.canalacesso.Permissao) converteToModel(param));
            tnPermissao.salvar(ConstanteTnPermissao.NOME_EVENTO_SALVAR_PERMISSAO);
        } catch (MappingException ex) {
            throw ex;
        }
    }

    @Override
    public List<T> recTodos() throws Exception {

        List<T> lstPemissoesBeans = null;
        try {
            List<br.com.dcoracoes.server.model.canalacesso.Permissao> lstPermissoesModel =
                    tnPermissao.recTodasPemissoes();

            lstPermissoesModel = getListToBeans(lstPermissoesModel);
        } catch (MappingException ex) {
            throw ex;
        }

        return lstPemissoesBeans;
    }

    @Override
    public Object converteToModel(Object param) throws ClassNotFoundException {
        return this.mapper.map(param, br.com.dcoracoes.server.model.canalacesso.Permissao.class);
    }

    @Override
    public T converteToBean(Object param) throws ClassNotFoundException {
        return (T) this.mapper.map(param, Permissao.class);
    }

    @Override
    public List getListToBeans(List listModel) throws ClassNotFoundException {
        List<T> listBeans = null;

        if (listModel != null
                && !listModel.isEmpty()) {
            listBeans = new ArrayList<T>();
            Iterator<br.com.dcoracoes.server.model.canalacesso.Permissao> iterator = listModel.iterator();
            while (iterator.hasNext()) {
                listBeans.add((T) converteToBean(iterator.next()));
            }
        }

        return listBeans;
    }
}
