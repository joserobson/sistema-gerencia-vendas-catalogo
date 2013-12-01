/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.classes.serverimpl;

import br.com.dcoracoes.client.Excecao.ClientDCoracoesException;
import br.com.dcoracoes.servico.service.ModelGerarEtiqueta;
import br.com.dcoracoes.servico.service.Parcela;
import br.com.dcoracoes.servico.service.Pessoa;
import br.com.dcoracoes.servico.service.Revendedor;
import br.com.dcoracoes.servico.service.ViewRevendedor;
import java.util.List;

/**
 *
 * @author Robson
 */
interface IRevendedorImpl<T> {
    
   public List<Pessoa> recRevendedorEtiqueta(ModelGerarEtiqueta parameter) throws ClientDCoracoesException; 
   
   public ViewRevendedor recUltimoRevendedorCadastro() throws ClientDCoracoesException; 
   
   public int recCodigoSequencia() throws ClientDCoracoesException; 
   
   public List<Parcela> recHistoricoParcelas(Revendedor revendedor) throws ClientDCoracoesException;
}
