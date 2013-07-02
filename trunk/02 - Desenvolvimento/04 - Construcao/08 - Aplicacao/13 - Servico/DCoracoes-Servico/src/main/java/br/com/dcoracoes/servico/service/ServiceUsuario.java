/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.servico.service;

import br.com.dcoracoes.servico.beans.canalacesso.Usuario;
import br.com.dcoracoes.transacao.classes.TnUsuario;
import br.com.dcoracoes.transacao.constantes.ConstanteTnUsuario;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dozer.MappingException;

/**
 *
 * @author Jose Robson
 */
public class ServiceUsuario<T extends Usuario> extends ServiceBase<T> implements IServiceUsuario<T> {

    private TnUsuario tnUsuario = null;

    public ServiceUsuario() {
        this.tnUsuario = new TnUsuario();
    }

    @Override
    public void salvar(Object param) throws Exception {
        try {
            tnUsuario.setUsuario((br.com.dcoracoes.server.model.canalacesso.Usuario) converteToModel(param));
            tnUsuario.salvar(ConstanteTnUsuario.NOME_EVENTO_SALVAR_USUARIO);
        } catch (MappingException ex) {
            throw ex;
        }
    }

    @Override
    public List<T> recTodos(Object param) throws Exception {
        List<T> listUsuariosBeans = null;
        try {
            List<br.com.dcoracoes.server.model.canalacesso.Usuario> listUsuariosModel =
                    tnUsuario.recListaUsuario((br.com.dcoracoes.server.model.canalacesso.Usuario) converteToModel(param));
            listUsuariosBeans = getListToBeans(listUsuariosModel);
        } catch (MappingException ex) {
            throw ex;
        }

        return listUsuariosBeans;

    }

    @Override
    public T recPorId(Long id) throws Exception {
        return converteToBean(tnUsuario.recUsuarioPorId(id));
    }

    @Override
    public T converteToBean(Object param) throws ClassNotFoundException {
        return (T) this.mapper.map(param, Usuario.class);
    }

    @Override
    public Object converteToModel(Object param) throws ClassNotFoundException {
        return this.mapper.map(param, br.com.dcoracoes.server.model.canalacesso.Usuario.class);
    }

    @Override
    public List<T> getListToBeans(List listModel) throws ClassNotFoundException {
        List<T> listBeans = null;
        if (listModel != null
                && !listModel.isEmpty()) {
            listBeans = new ArrayList<T>();
            Iterator<br.com.dcoracoes.server.model.canalacesso.Usuario> iterator = listModel.iterator();
            while (iterator.hasNext()) {
                listBeans.add((T) converteToBean(iterator.next()));
            }
        }

        return listBeans;
    }
}
