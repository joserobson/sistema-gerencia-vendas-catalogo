/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.servico.service;

import br.com.dcoracoes.servico.beans.cadastro.Pessoa;
import br.com.dcoracoes.servico.beans.prospeccao.Alerta;
import br.com.dcoracoes.transacao.classes.TnAlerta;
import br.com.dcoracoes.transacao.constantes.ConstanteTnAlerta;
import br.com.dcoracoes.transacao.excecao.TransException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Jose Robson
 */
public class ServiceAlerta<T extends Alerta> extends ServiceBase implements IServiceAlerta {

    private TnAlerta tnAlerta = null;

    public ServiceAlerta() {
        this.tnAlerta = new TnAlerta();
    }

    @Override
    public void salvar(Object param) throws Exception {

        try {
            tnAlerta.setProspeccao(this.mapper.map(param, br.com.dcoracoes.server.model.prospeccao.Alerta.class));
            tnAlerta.salvar(ConstanteTnAlerta.NOME_EVENTO_SALVAR_ALERTA);
        } catch (TransException ex) {
            throw new Exception(ex);
        }

    }

    @Override
    public List<T> recTodos(Object param) throws Exception {

        List<T> listAlertasBeans = null;

        try {
            List<br.com.dcoracoes.server.model.prospeccao.Alerta> listAlertaModel =
                    tnAlerta.recListaAlertas(this.mapper.map(param, br.com.dcoracoes.server.model.prospeccao.Alerta.class));

            listAlertasBeans = getListToBeans(listAlertaModel);

        } catch (TransException ex) {
            throw new Exception(ex);
        }

        return listAlertasBeans;
    }

    @Override
    public List<T> recAlertasPorPessoa(Pessoa param) throws Exception {

        List<T> listAlertasBeans = null;
        try {
            List<br.com.dcoracoes.server.model.prospeccao.Alerta> listAlertaModel =
                    tnAlerta.recAlertasPorPessoa(this.mapper.map(param, br.com.dcoracoes.server.model.cadastro.Pessoa.class));

            listAlertasBeans = getListToBeans(listAlertaModel);

        } catch (TransException ex) {
            throw new Exception(ex);
        }

        return listAlertasBeans;
    }

    @Override
    public String gerarNumeroProtoco() throws Exception {
        return tnAlerta.gerarNumeroProtocolo();
    }

    @Override
    public List getListToBeans(List listModel) throws ClassNotFoundException {
        List<T> listAlertasBeans = null;

        if (listModel != null
                && !listModel.isEmpty()) {
            listAlertasBeans = new ArrayList<T>();
            Iterator<br.com.dcoracoes.server.model.prospeccao.Alerta> iterator = listModel.iterator();
            while (iterator.hasNext()) {
                listAlertasBeans.add((T) mapper.map(iterator.next(), Alerta.class));
            }
        }

        return listAlertasBeans;
    }
}
