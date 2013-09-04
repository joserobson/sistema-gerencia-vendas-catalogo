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
 * @author Robson
 */
public class AlertaServerImpl<T extends Alerta> extends BaseServerImpl<T> implements IAlertaSempreImpl<T> {

    @Override
    public void salvar(Object param) throws ClientDCoracoesException {
        try {
            this.port.salvarAlerta((T) param);
        } catch (Exception ex) {
            throw new ClientDCoracoesException(ex);
        }
    }
    
    @Override
    public Object salvarComRetorno(Object param) throws ClientDCoracoesException {
        try {
            return this.port.salvarAlertaComRetorno((Alerta) param);
        } catch (Exception ex) {
            throw new ClientDCoracoesException(ex);
        }
    }

    public List<Alerta> recAlertasPorPessoa(Pessoa p) throws ClientDCoracoesException {

        List<Alerta> listAlertas = null;
        try {
            listAlertas = this.port.recAlertasPorPessoa(p);
        } catch (Exception ex) {
            throw new ClientDCoracoesException(ex);
        }

        return listAlertas;
    }

    public String gerarNumeroProtocolo() throws ClientDCoracoesException {

        String protocolo = "";
        try {
            protocolo = this.port.gerarNumeroProtocolo();
        } catch (Exception ex) {
            throw new ClientDCoracoesException(ex);
        }

        return protocolo;
    }

    @Override
    public List recTodos(Object param) throws ClientDCoracoesException {

        List<Alerta> alertas = null;

        try {
            alertas = this.port.recListaAlertas((Alerta) param);
        } catch (Exception ex) {
            throw new ClientDCoracoesException(ex);
        }

        return alertas;
    }
    
    
    
    
//    /**
//     * METODO PARA SALVAR ALERTA - PROSPECCAO
//     * @param alerta
//     * @return
//     * @throws TransException 
//     */
//    public Alerta salvarAlerta(Alerta alerta) throws TransException {
//        try {
//            TnAlerta tn = new TnAlerta();
//            tn.setProspeccao(alerta);
//            tn.salvar(ConstanteTnAlerta.NOME_EVENTO_SALVAR_ALERTA);
//            return tn.getProspeccao();
//        } catch (TransException ex) {
//            throw ex;
//        }
//    }
//
//    /**
//     * METODO PARA RECUPERAR ALERTAS VINCULADOS A UMA PESSOA
//     * @param p
//     * @return
//     * @throws TransException 
//     */
//    public List<Alerta> recAlertasPorPessoa(Pessoa p) throws TransException {
//        try {
//            TnAlerta tn = new TnAlerta();
//            return tn.recAlertasPorPessoa(p);
//        } catch (TransException ex) {
//            throw ex;
//        }
//    }
//
//    /**
//     * METODO PARA GERAR O NUMERO DO PROTOCOLO PARA UM NOVO ALERTA
//     * @return
//     * @throws TransException 
//     */
//    public String gerarNumeroProtocolo() throws TransException {
//        try {
//            TnAlerta tn = new TnAlerta();
//            return tn.gerarNumeroProtocolo();
//        } catch (TransException ex) {
//            throw ex;
//        }
//    }
//
//    /**
//     * RECUPERAR LISTA DE ALERTAS MONTANDO CONSULTA DINAMICAMENTE
//     * @param pAlerta
//     * @return
//     * @throws TransException 
//     */
//    public List<Alerta> recListaAlertas(Alerta pAlerta) throws TransException {
//        List<Alerta> retListaAlerta = null;
//        try {
//            TnAlerta tn = new TnAlerta();
//            retListaAlerta = tn.recListaAlertas(pAlerta);
//        } catch (TransException ex) {
//            throw ex;
//        }
//
//        return retListaAlerta;
//    }
}
