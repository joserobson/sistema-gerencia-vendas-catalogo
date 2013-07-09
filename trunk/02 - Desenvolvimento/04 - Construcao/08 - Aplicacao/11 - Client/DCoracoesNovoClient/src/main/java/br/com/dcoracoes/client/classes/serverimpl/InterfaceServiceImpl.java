/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.classes.serverimpl;

import br.com.dcoracoes.client.Excecao.ClientDCoracoesException;
import java.util.List;

/**
 * Interface para metodos ServiceImpl
 *
 * @author Robson
 */
interface InterfaceServiceImpl<T extends Object> {

    T salvarComRetorno (T param) throws ClientDCoracoesException;
    
    void salvar(T param) throws ClientDCoracoesException;

    List<T> recTodos() throws ClientDCoracoesException;

    T recObjeto(T param) throws ClientDCoracoesException;

    T deletar(T param) throws ClientDCoracoesException;

    boolean salvarListObjetos(List<T> lstObjetos) throws ClientDCoracoesException;

    List<T> recTodos(T param) throws ClientDCoracoesException;

    List<T> recTodos(T param, boolean useLike) throws ClientDCoracoesException;

    T recPorId(Long id) throws ClientDCoracoesException;
}
