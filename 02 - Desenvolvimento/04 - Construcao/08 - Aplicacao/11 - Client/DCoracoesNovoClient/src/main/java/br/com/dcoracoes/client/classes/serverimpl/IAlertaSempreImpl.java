/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.classes.serverimpl;

import br.com.dcoracoes.client.Excecao.ClientDCoracoesException;
import br.com.dcoracoes.servico.service.Alerta;
import br.com.dcoracoes.servico.service.Pessoa;
import java.util.List;

/**
 *
 * @author Jose Robson
 */
interface IAlertaSempreImpl<T> {

    List<Alerta> recAlertasPorPessoa(Pessoa p) throws ClientDCoracoesException;

    String gerarNumeroProtocolo() throws ClientDCoracoesException;
}
