/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.classes.serverimpl;

import br.com.dcoracoes.server.model.cadastro.Pessoa;
import br.com.dcoracoes.server.model.prospeccao.Alerta;
import br.com.dcoracoes.transacao.classes.TnAlerta;
import br.com.dcoracoes.transacao.constantes.ConstanteTnAlerta;
import br.com.dcoracoes.transacao.excecao.TransException;
import java.util.List;

/**
 *
 * @author Robson
 */
public class AlertaServerImpl {

    /**
     * METODO PARA SALVAR ALERTA - PROSPECCAO
     * @param alerta
     * @return
     * @throws TransException 
     */
    public Alerta salvarAlerta(Alerta alerta) throws TransException {
        try {
            TnAlerta tn = new TnAlerta();
            tn.setProspeccao(alerta);
            tn.salvar(ConstanteTnAlerta.NOME_EVENTO_SALVAR_ALERTA);
            return tn.getProspeccao();
        } catch (TransException ex) {
            throw ex;
        }
    }

    /**
     * METODO PARA RECUPERAR ALERTAS VINCULADOS A UMA PESSOA
     * @param p
     * @return
     * @throws TransException 
     */
    public List<Alerta> recAlertasPorPessoa(Pessoa p) throws TransException {
        try {
            TnAlerta tn = new TnAlerta();
            return tn.recAlertasPorPessoa(p);
        } catch (TransException ex) {
            throw ex;
        }
    }

    /**
     * METODO PARA GERAR O NUMERO DO PROTOCOLO PARA UM NOVO ALERTA
     * @return
     * @throws TransException 
     */
    public String gerarNumeroProtocolo() throws TransException {
        try {
            TnAlerta tn = new TnAlerta();
            return tn.gerarNumeroProtocolo();
        } catch (TransException ex) {
            throw ex;
        }
    }

    /**
     * RECUPERAR LISTA DE ALERTAS MONTANDO CONSULTA DINAMICAMENTE
     * @param pAlerta
     * @return
     * @throws TransException 
     */
    public List<Alerta> recListaAlertas(Alerta pAlerta) throws TransException {
        List<Alerta> retListaAlerta = null;
        try {
            TnAlerta tn = new TnAlerta();
            retListaAlerta = tn.recListaAlertas(pAlerta);
        } catch (TransException ex) {
            throw ex;
        }

        return retListaAlerta;
    }
}
