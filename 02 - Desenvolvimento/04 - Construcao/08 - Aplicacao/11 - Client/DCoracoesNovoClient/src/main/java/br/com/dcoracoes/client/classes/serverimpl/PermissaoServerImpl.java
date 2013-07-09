/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.classes.serverimpl;

import br.com.dcoracoes.client.Excecao.ClientDCoracoesException;
import br.com.dcoracoes.servico.service.Permissao;
import java.util.List;

/**
 *
 * @author Robson
 */
public class PermissaoServerImpl <T extends Permissao> extends BaseServerImpl<T> implements IPermissaoImpl{

    @Override
    public void salvar(Object param) throws ClientDCoracoesException {
        try {
            this.port.salvarPermissao((Permissao) param);
        } catch (Exception ex) {
            throw new ClientDCoracoesException(ex);
        }
    }
    
    @Override
    public List<Permissao> recTodasPemissoes() throws ClientDCoracoesException {
        List<Permissao> permissoes = null;

        try {
            permissoes = this.port.recTodasPemissoes();
        } catch (Exception ex) {
            throw new ClientDCoracoesException(ex);
        }
        return permissoes;
    }
}
