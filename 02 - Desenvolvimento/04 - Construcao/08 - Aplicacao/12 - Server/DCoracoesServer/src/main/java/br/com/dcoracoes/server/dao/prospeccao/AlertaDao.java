/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.dao.prospeccao;

import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.cadastro.Pessoa;
import br.com.dcoracoes.server.model.prospeccao.Alerta;
import java.util.List;

/**
 *
 * @author Robson
 */
public interface AlertaDao<T extends Alerta> {

    public void mantemAlerta(Alerta alerta) throws ServerException;

    public List<T> recAlertasPorPessoa(Pessoa p) throws ServerException;
    
    public int recNumeroAlertasDoDia() throws ServerException;
    
    public List<T> recListaAlerta(T alerta) throws ServerException;
    
}
