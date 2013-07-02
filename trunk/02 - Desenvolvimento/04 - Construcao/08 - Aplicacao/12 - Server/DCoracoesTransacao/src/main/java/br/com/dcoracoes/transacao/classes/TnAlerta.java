/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.transacao.classes;

import br.com.dcoracoes.server.bo.prospeccao.AlertaBoImpl;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.cadastro.Pessoa;
import br.com.dcoracoes.server.model.prospeccao.Alerta;
import br.com.dcoracoes.transacao.excecao.TransException;
import br.com.dcoracoes.transacao.interfaces.InterfaceTransacao;
import br.com.dcoracoes.transacao.util.TransacaoUtil;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Robson
 */
public class TnAlerta implements InterfaceTransacao {

    /**
     * ATRIBUTOS
     */
    private Alerta prospeccao;

    /**
     * CONSTRUCTORES
     */
    public TnAlerta() {
    }

    /**
     * METODOS ACESSORES
     * @return 
     */
    public Alerta getProspeccao() {
        return prospeccao;
    }

    public void setProspeccao(Alerta prospeccao) {
        this.prospeccao = prospeccao;
    }

    /**
     * METODOS DA INTERFACE
     */
    /**
     * SALVAR ALERTA
     * @param evento
     * @throws TransException 
     */
    @Override
    public void salvar(String evento) throws TransException {
        try {
            if (validarDados(evento)) {                
                AlertaBoImpl alertaBo = (AlertaBoImpl) TransacaoUtil.getInstanceBo(Alerta.class);
                alertaBo.mantemAlerta(this.prospeccao);
            }
        } catch (ServerException ex) {
            throw new TransException(ex);
        }
    }

    @Override
    public boolean validarDados(String evento) throws TransException {
        return true;
    }

    @Override
    public void deletar(String evento) throws TransException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * METODOS PARTICULARES DA CLASSE
     * 
     */
    /**
     * RECUPERA LISTA DE ALERTAS DA PESSOA PASSADA POR PARAMETRO
     * @param pessoa
     * @return 
     */
    public List<Alerta> recAlertasPorPessoa(Pessoa pessoa) throws TransException {
        try {
            AlertaBoImpl alertaBo = (AlertaBoImpl) TransacaoUtil.getInstanceBo(Alerta.class);
            return alertaBo.recAlertasPorPessoa(pessoa);
        } catch (ServerException ex) {
            throw new TransException(ex);
        }
    }

    /**
     * GERA NUMERO PROTOCOLO DO ALERTA
     * @return 
     */
    public String gerarNumeroProtocolo() throws TransException {
        String numProtocolo = null;
        try {
            AlertaBoImpl alertaBo = (AlertaBoImpl) TransacaoUtil.getInstanceBo(Alerta.class);
            int contAlertas = alertaBo.recNumeroAlertaPorDia() + 1;

            String data = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());

            numProtocolo = String.valueOf(contAlertas);
            int numAddZerosEsquerda = 3 - numProtocolo.length();

            while (numAddZerosEsquerda > 0) {
                numProtocolo = "0" + numProtocolo;
                numAddZerosEsquerda--;
            }

            numProtocolo = data.replace("/", "") + numProtocolo;

        } catch (ServerException ex) {
            throw new TransException(ex);
        }

        return numProtocolo;
    }

    /**
     * METODO PARA RECUPERAR UMA LISTA DE ALERTAS MONTANDO
     * CONSULTA DINAMICAMENTE
     * @param pAlerta
     * @return 
     */
    public List<Alerta> recListaAlertas(Alerta pAlerta) throws TransException {
        List<Alerta> retListaAlerta = null;
        try {
            AlertaBoImpl alertaBo = (AlertaBoImpl) TransacaoUtil.getInstanceBo(Alerta.class);
            retListaAlerta = alertaBo.recListaAlertas(pAlerta);

        } catch (ServerException ex) {
            throw new TransException(ex);
        }
        return retListaAlerta;
    }
}
