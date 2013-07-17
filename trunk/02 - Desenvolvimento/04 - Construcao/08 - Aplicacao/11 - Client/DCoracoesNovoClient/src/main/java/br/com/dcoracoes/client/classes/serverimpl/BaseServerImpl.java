/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.classes.serverimpl;

import br.com.dcoracoes.client.Excecao.ClientDCoracoesException;
import br.com.dcoracoes.servico.service.WsServiceDCoracoes_Service;
import java.util.List;

/**
 *
 * @author Robson
 */
public class BaseServerImpl<T extends Object> implements InterfaceServiceImpl {

    private br.com.dcoracoes.servico.service.WsServiceDCoracoes_Service service;
    protected br.com.dcoracoes.servico.service.WsServiceDCoracoes port;

    public BaseServerImpl() {
        this.service = new WsServiceDCoracoes_Service();
        this.port = service.getWsServiceDCoracoesPort();
    }
    
    public Object salvarComRetorno(Object param) throws ClientDCoracoesException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void salvar(Object param) throws ClientDCoracoesException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List recTodos() throws ClientDCoracoesException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object recObjeto(Object param) throws ClientDCoracoesException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object deletar(Object param) throws ClientDCoracoesException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean salvarListObjetos(List lstObjetos) throws ClientDCoracoesException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List recTodos(Object param) throws ClientDCoracoesException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List recTodos(Object param, boolean useLike) throws ClientDCoracoesException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object recPorId(Long id) throws ClientDCoracoesException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
