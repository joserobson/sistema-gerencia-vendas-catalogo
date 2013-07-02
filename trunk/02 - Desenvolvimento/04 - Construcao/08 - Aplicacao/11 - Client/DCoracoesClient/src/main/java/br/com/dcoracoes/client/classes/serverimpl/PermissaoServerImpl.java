/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.classes.serverimpl;

import br.com.dcoracoes.server.model.canalacesso.Permissao;
import br.com.dcoracoes.transacao.classes.TnPermissao;
import br.com.dcoracoes.transacao.constantes.ConstanteTnPermissao;
import br.com.dcoracoes.transacao.excecao.TransException;
import java.util.List;

/**
 *
 * @author Robson
 */
public class PermissaoServerImpl {

    /**
     * METODO PARA SALVAR PERMISSAO
     * @param perfil
     * @return
     * @throws TransException 
     */
    public Permissao salvarPermissao(Permissao permissao) throws TransException {
        try {
            TnPermissao tn = new TnPermissao(permissao);
            tn.salvar(ConstanteTnPermissao.NOME_EVENTO_SALVAR_PERMISSAO);
            return tn.getPermissao();
        } catch (TransException ex) {
            throw ex;
        }
    }
    
    /**
     * METODO PARA RECUPERAR TODAS AS PERMISSAO
     * @param perfil
     * @return
     * @throws TransException 
     */
    public List<Permissao> recTodasPemissoes() throws TransException {
        try {
            TnPermissao tn = new TnPermissao(null);
            return tn.recTodasPemissoes();
        } catch (TransException ex) {
            throw ex;
        }
    }
}
