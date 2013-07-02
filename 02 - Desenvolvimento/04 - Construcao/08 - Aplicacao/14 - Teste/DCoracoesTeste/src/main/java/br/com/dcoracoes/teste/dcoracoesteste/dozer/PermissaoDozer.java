/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.teste.dcoracoesteste.dozer;

import br.com.dcoracoes.server.model.canalacesso.Perfil;

/**
 *
 * @author Jose Robson
 */
public class PermissaoDozer extends BaseDozer {

    @Override
    public void convertBeanParaModel() {
        
        
    }

    @Override
    public void convertModelParaBean() {
        
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
