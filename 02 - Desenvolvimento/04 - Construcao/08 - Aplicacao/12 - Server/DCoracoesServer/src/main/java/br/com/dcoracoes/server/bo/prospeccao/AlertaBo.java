/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.bo.prospeccao;

import br.com.dcoracoes.server.dao.prospeccao.AlertaDao;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.cadastro.Pessoa;
import br.com.dcoracoes.server.model.prospeccao.Alerta;
import java.util.List;

/**
 *
 * @author Robson
 */
public interface AlertaBo <T extends Alerta>{
    
    /**
     * 
     * @param dao 
     */
    public void setAlertaDao(AlertaDao dao);
    
    /**
     * SALVAR UM ALERTA
     * @param alerta
     * @throws ServerException 
     */
    public void mantemAlerta(T alerta)throws ServerException;
    
    /**
     * 
     * @param p
     * @return
     * @throws ServerException 
     */
    public List<T> recAlertasPorPessoa(Pessoa p) throws ServerException;
    
    /**
     * 
     * @return
     * @throws ServerException 
     */
    public int recNumeroAlertaPorDia() throws ServerException;
    
    
    public List<T> recListaAlertas(T alerta) throws ServerException;
}
