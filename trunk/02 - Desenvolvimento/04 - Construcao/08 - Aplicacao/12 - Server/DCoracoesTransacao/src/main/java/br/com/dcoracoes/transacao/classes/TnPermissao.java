/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.transacao.classes;

import br.com.dcoracoes.server.bo.canalacesso.PermissaoBoImpl;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.canalacesso.Permissao;
import br.com.dcoracoes.transacao.excecao.TransException;
import br.com.dcoracoes.transacao.interfaces.InterfaceTransacao;
import br.com.dcoracoes.transacao.util.TransacaoUtil;
import java.util.List;

/**
 *
 * @author Robson
 */
public class TnPermissao implements InterfaceTransacao {

    private Permissao permissao;

    public TnPermissao() {
    }

    public TnPermissao(Permissao permissao) {
        this.permissao = permissao;
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }

    @Override
    public void salvar(String evento) throws TransException {
        try {
            if (validarDados(evento)) {
                PermissaoBoImpl permissaoBo = (PermissaoBoImpl) TransacaoUtil.getInstanceBo(Permissao.class);
                permissaoBo.mantemPermissao(this.permissao);
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

    public List<Permissao> recTodasPemissoes() throws TransException {
        List<Permissao> lstRetorno = null;
        try {
            PermissaoBoImpl permissaoBo = (PermissaoBoImpl) TransacaoUtil.getInstanceBo(Permissao.class);
            lstRetorno = permissaoBo.recTodasPermissoes();
        } catch (ServerException ex) {
            throw new TransException(ex);
        }
        return lstRetorno;
    }
}
