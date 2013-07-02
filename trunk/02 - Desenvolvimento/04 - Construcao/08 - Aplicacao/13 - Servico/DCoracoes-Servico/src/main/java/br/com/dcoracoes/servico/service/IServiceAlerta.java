/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.servico.service;

import br.com.dcoracoes.servico.beans.cadastro.Pessoa;
import java.util.List;

/**
 *
 * @author Jose Robson
 */
public interface IServiceAlerta {
    
    public List recAlertasPorPessoa(Pessoa param) throws Exception;
    
    public String gerarNumeroProtoco() throws Exception;
}
