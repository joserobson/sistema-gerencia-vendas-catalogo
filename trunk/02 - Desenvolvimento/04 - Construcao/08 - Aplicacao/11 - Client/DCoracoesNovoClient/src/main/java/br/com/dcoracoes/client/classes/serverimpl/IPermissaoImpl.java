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
 * @author Binho
 */
interface IPermissaoImpl {
    
    public List<Permissao> recTodasPemissoes() throws ClientDCoracoesException;
}
