/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.servico.service;

import br.com.dcoracoes.servico.util.InterfaceBase;
import java.util.List;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;

/**
 *
 * @author Robson
 */
public class ServiceBase<T extends Object> implements InterfaceBase {

    protected Mapper mapper = null;

    public ServiceBase() {
        this.mapper = DozerBeanMapperSingletonWrapper.getInstance();
    }

    @Override
    public void salvar(Object param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<T> recTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public T recObjeto(Object param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public T deletar(Object param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean salvarListObjetos(List lstObjetos) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<T> recTodos(Object param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Class getClassToModel(Object param) throws ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Class getClassToBean(Object param) throws ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object converteToModel(Object param) throws ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object converteToBean(Object param) throws ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List getListToBeans(List listModel) throws ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object recPorId(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List recTodos(Object param, boolean useLike) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
