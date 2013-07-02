/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.servico.util;

import java.util.List;

/**
 *
 * @author Robson
 */
public interface InterfaceBase<T extends Object> {

    void salvar(T param) throws Exception;

    List<T> recTodos() throws Exception;

    T recObjeto(T param) throws Exception;

    T deletar(T param) throws Exception;

    boolean salvarListObjetos(List<T> lstObjetos) throws Exception;

    List<T> recTodos(T param) throws Exception;
    
    List<T> recTodos(T param, boolean useLike) throws Exception;

    Class getClassToModel(T param) throws ClassNotFoundException;

    Class getClassToBean(Object param) throws ClassNotFoundException;

    T converteToModel(Object param) throws ClassNotFoundException;

    T converteToBean(Object param) throws ClassNotFoundException;
    
    List<T> getListToBeans(List<T> listModel) throws ClassNotFoundException;
    
    T recPorId(Long id) throws Exception;
}
