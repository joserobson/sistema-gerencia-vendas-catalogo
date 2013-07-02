/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.teste.dcoracoesteste.dozer;

import br.com.dcoracoes.teste.dcoracoes.beans.Perfil;

/**
 *
 * @author Jose Robson
 */
public class PerfilDozer extends BaseDozer {

    @Override
    public void convertBeanParaModel() {
        br.com.dcoracoes.server.model.canalacesso.Perfil model = null;

        try {
            Perfil PerfilBean = (Perfil) getBean();
            model = this.mapper.map(PerfilBean, br.com.dcoracoes.server.model.canalacesso.Perfil.class);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        isConvertOk(model);
    }

    @Override
    public void convertModelParaBean() {
        Perfil bean = null;

        try {
            br.com.dcoracoes.server.model.canalacesso.Perfil model =
                    (br.com.dcoracoes.server.model.canalacesso.Perfil) getModel();
            bean = this.mapper.map(model, Perfil.class);


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        isConvertOk(bean);
    }

    @Override
    public Object getBean() {
        return UtilDozer.getPerfilBean();
    }

    @Override
    public Object getModel() {
        return UtilDozer.getPerfilModel();
    }
}
