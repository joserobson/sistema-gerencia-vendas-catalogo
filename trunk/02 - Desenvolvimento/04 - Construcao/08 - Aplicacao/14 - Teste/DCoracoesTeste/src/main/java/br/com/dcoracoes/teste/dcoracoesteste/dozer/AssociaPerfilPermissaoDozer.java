/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.teste.dcoracoesteste.dozer;

import br.com.dcoracoes.teste.dcoracoes.beans.AssociaPerfilPermissao;
import br.com.dcoracoes.teste.dcoracoes.beans.AssociaPerfilPermissaoFK;
import br.com.dcoracoes.teste.dcoracoes.beans.Permissao;
import org.dozer.MappingException;

/**
 *
 * @author Jose Robson
 */
public class AssociaPerfilPermissaoDozer extends BaseDozer {

    @Override
    public void convertBeanParaModel() {

        br.com.dcoracoes.server.model.canalacesso.AssociaPerfilPermissao model = null;

        try {
            AssociaPerfilPermissao bean = (AssociaPerfilPermissao) getBean();

            model = (br.com.dcoracoes.server.model.canalacesso.AssociaPerfilPermissao) this.mapper.map(bean, br.com.dcoracoes.server.model.canalacesso.AssociaPerfilPermissao.class);

        } catch (MappingException ex) {
            System.out.println(ex.getMessage());
        }

        isConvertOk(model);
    }

    @Override
    public void convertModelParaBean() {

        AssociaPerfilPermissao bean = null;

        try {
            br.com.dcoracoes.server.model.canalacesso.AssociaPerfilPermissao model =
                    (br.com.dcoracoes.server.model.canalacesso.AssociaPerfilPermissao) getModel();

            bean = (AssociaPerfilPermissao) this.mapper.map(model, AssociaPerfilPermissao.class);

        } catch (MappingException ex) {
            System.out.println(ex.getMessage());
        }

        isConvertOk(bean);
    }

    @Override
    public Object getBean() {
        AssociaPerfilPermissao associa = new AssociaPerfilPermissao();

        AssociaPerfilPermissaoFK fk = new AssociaPerfilPermissaoFK();

        fk.setPerfil(UtilDozer.getPerfilBean());

        Permissao permissao = new Permissao();
        permissao.setId(Long.MIN_VALUE);
        permissao.setDescricao("1q23123");
        fk.setPermissao(permissao);

        associa.setChaveComposta(fk);

        return associa;
    }

    @Override
    public Object getModel() {
        br.com.dcoracoes.server.model.canalacesso.AssociaPerfilPermissao associa = new br.com.dcoracoes.server.model.canalacesso.AssociaPerfilPermissao();

        br.com.dcoracoes.server.model.canalacesso.AssociaPerfilPermissaoFK fk = new br.com.dcoracoes.server.model.canalacesso.AssociaPerfilPermissaoFK();

        fk.setPerfil(UtilDozer.getPerfilModel());

        br.com.dcoracoes.server.model.canalacesso.Permissao permissao =
                new br.com.dcoracoes.server.model.canalacesso.Permissao();
        permissao.setId(Long.MIN_VALUE);
        permissao.setDescricao("1q23123");
        fk.setPermissao(permissao);

        associa.setChaveComposta(fk);

        return associa;
    }
}
