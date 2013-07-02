/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.transacao.classes;

import br.com.dcoracoes.server.bo.canalacesso.AssociaPerfilPermissaoBoImpl;
import br.com.dcoracoes.server.bo.canalacesso.PerfilBoImpl;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.canalacesso.AssociaPerfilPermissao;
import br.com.dcoracoes.server.model.canalacesso.Perfil;
import br.com.dcoracoes.transacao.excecao.TransException;
import br.com.dcoracoes.transacao.interfaces.InterfaceTransacao;
import br.com.dcoracoes.transacao.util.TransacaoUtil;
import java.util.List;

/**
 *
 * @author Cléberson
 */
public class TnPerfil implements InterfaceTransacao {

    /**
     * ATRIBUTOS
     */
    private Perfil perfil;
    private List<AssociaPerfilPermissao> lstAssociaPerfilPermissao;

    /**
     * CONSTRUCTORES
     */
    public TnPerfil() {
    }

    /**
     * METODOS ACESSORES
     * @return 
     */
    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public List<AssociaPerfilPermissao> getLstAssociaPerfilPermissao() {
        return lstAssociaPerfilPermissao;
    }

    public void setLstAssociaPerfilPermissao(List<AssociaPerfilPermissao> lstAssociaPerfilPermissao) {
        this.lstAssociaPerfilPermissao = lstAssociaPerfilPermissao;
    }

    /**
     * METODOS DA INTERFACE
     */
    /**
     * SALVAR PERFIL
     * @param evento
     * @throws TransException 
     */
    @Override
    public void salvar(String evento) throws TransException {
        try {
            if (validarDados(evento)) {
                PerfilBoImpl perfilBo = (PerfilBoImpl) TransacaoUtil.getInstanceBo(Perfil.class);
                perfilBo.mantemPerfil(this.perfil, this.lstAssociaPerfilPermissao);
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
     * METODO PARA RECUPERAR UMA LISTA DE PERFIS MONTANDO
     * CONSULTA DINAMICAMENTE
     * @param pPerfil
     * @return 
     */
    public List<Perfil> recListaPerfil(Perfil pPerfil) throws TransException {
        List<Perfil> retListaPerfil = null;
        try {
            PerfilBoImpl perfilBo = (PerfilBoImpl) TransacaoUtil.getInstanceBo(Perfil.class);
            retListaPerfil = perfilBo.recPerfil(pPerfil);
        } catch (ServerException ex) {
            throw new TransException(ex);
        }
        return retListaPerfil;
    }

    /**
     * METODO PARA RECUPERAR PERFIL PELO ID
     * @param id
     * @return
     * @throws TransException 
     */
    public Perfil recPerfilPorId(Long id) throws TransException {
        Perfil retorno = null;
        try {
            PerfilBoImpl perfilBo = (PerfilBoImpl) TransacaoUtil.getInstanceBo(Perfil.class);
            retorno = perfilBo.getPerfilPorId(id);
        } catch (ServerException ex) {
            throw new TransException(ex);
        }
        return retorno;
    }

    /**
     * Recupera lista de AssociaPerfilPermissao para o perfil
     * @return
     * @throws TransException 
     */
    public List<AssociaPerfilPermissao> recPermissoesPorPerfil() throws TransException {
        List<AssociaPerfilPermissao> lstRetorno = null;
        try {
            AssociaPerfilPermissaoBoImpl associaBo = (AssociaPerfilPermissaoBoImpl) TransacaoUtil.getInstanceBo(AssociaPerfilPermissao.class);
            lstRetorno = associaBo.recPermissoesPorPerfil(this.getPerfil());
        } catch (ServerException ex) {
            throw new TransException(ex);
        }

        return lstRetorno;
    }
}
