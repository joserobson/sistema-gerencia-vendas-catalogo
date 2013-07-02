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
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Jose Robson
 */
public interface IServiceRevendedor<T extends ViewRevendedor> {

    T recUltimoRevendedorCadastro() throws Exception;

    int recCodigoSequencia() throws Exception;

    String validaCPF(PessoaFisica pessoa) throws Exception;

    PedidoVenda recUltimoPedidoVenda(Revendedor rev) throws Exception;

    List<Pessoa> recRevendedorEtiqueta(HashMap<String, Object> parameter) throws Exception;

    Pessoa recPessoaPorId(Long id) throws Exception;
}
