/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.servico.service;

import br.com.dcoracoes.servico.beans.canalacesso.AssociaPerfilPermissao;
import br.com.dcoracoes.servico.beans.canalacesso.Perfil;
import br.com.dcoracoes.transacao.classes.TnPerfil;
import br.com.dcoracoes.transacao.constantes.ConstanteTnPerfil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dozer.MappingException;

/**
 *
 * @author Jose Robson
 */
public class ServicePerfil<T extends Perfil> extends ServiceBase<T> implements IServicePerfil<T> {

    private TnPerfil tnPerfil = null;

    public ServicePerfil() {
        this.tnPerfil = new TnPerfil();
    }

    @Override
    public void salvar(Object param) throws Exception {
        try {
            tnPerfil.setPerfil((br.com.dcoracoes.server.model.canalacesso.Perfil) converteToModel(param));
            tnPerfil.salvar(ConstanteTnPerfil.NOME_EVENTO_SALVAR_PERFIL);
        } catch (MappingException ex) {
            throw ex;
        }
    }

    @Override
    public List<T> recTodos(Object param) throws Exception {
        List<T> listPefilBeans = null;
        try {
            br.com.dcoracoes.server.model.canalacesso.Perfil perfil = (br.com.dcoracoes.server.model.canalacesso.Perfil)converteToModel(param);            
            List<br.com.dcoracoes.server.model.canalacesso.Perfil> listPerfisModel = tnPerfil.recListaPerfil(perfil);
            listPefilBeans = getListToBeans(listPerfisModel);
        } catch (MappingException ex) {
            throw ex;
        }

        return listPefilBeans;

    }

    @Override
    public Object converteToBean(Object param) throws ClassNotFoundException {
        return this.mapper.map(param, Perfil.class);
    }

    @Override
    public Object converteToModel(Object param) throws ClassNotFoundException {
        return this.mapper.map(param, br.com.dcoracoes.server.model.canalacesso.Perfil.class);
    }

    @Override
    public List<T> getListToBeans(List listModel) throws ClassNotFoundException {
        List<T> listBeans = null;

        if (listModel != null
                && !listModel.isEmpty()) {
            listBeans = new ArrayList<T>();
            Iterator<br.com.dcoracoes.server.model.canalacesso.Perfil> iterator = listModel.iterator();
            while (iterator.hasNext()) {
                listBeans.add((T) converteToBean(iterator.next()));
            }
        }

        return listBeans;
    }

    @Override
    public T recPorId(Long id) throws Exception {
        T perfilBean = (T) converteToBean(tnPerfil.recPerfilPorId(id));
        return perfilBean;
    }

    @Override
    public List<AssociaPerfilPermissao> recPermissoesPorPerfil(Perfil perfil) throws Exception {

        List<AssociaPerfilPermissao> lstAssociaBeans = null;

        try {
            tnPerfil.setPerfil((br.com.dcoracoes.server.model.canalacesso.Perfil) converteToModel(perfil));
            List<br.com.dcoracoes.server.model.canalacesso.AssociaPerfilPermissao> lstAssociaModel =
                    tnPerfil.recPermissoesPorPerfil();
            if (lstAssociaModel != null
                    && !lstAssociaModel.isEmpty()) {
                lstAssociaBeans = new ArrayList<AssociaPerfilPermissao>();
                Iterator<br.com.dcoracoes.server.model.canalacesso.AssociaPerfilPermissao> iterator = lstAssociaModel.iterator();
                while (iterator.hasNext()) {
                    lstAssociaBeans.add(this.mapper.map(iterator.next(), AssociaPerfilPermissao.class));
                }
            }

        } catch (MappingException ex) {
            throw ex;
        }

        return lstAssociaBeans;

    }
}
