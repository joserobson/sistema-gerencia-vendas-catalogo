/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.classes.serverimpl;

import br.com.dcoracoes.server.model.canalacesso.AssociaPerfilPermissao;
import br.com.dcoracoes.server.model.canalacesso.Perfil;
import br.com.dcoracoes.transacao.classes.TnPerfil;
import br.com.dcoracoes.transacao.classes.TnUsuario;
import br.com.dcoracoes.transacao.constantes.ConstanteTnPerfil;
import br.com.dcoracoes.transacao.excecao.TransException;
import java.util.List;

/**
 *
 * @author Cleberson
 */
public class PerfilServerImpl {

    /**
     * METODO PARA SALVAR PERFIL
     * @param perfil
     * @return
     * @throws TransException 
     */
    public Perfil salvarPerfil(Perfil perfil, List<AssociaPerfilPermissao> listAssociaPerfilPermissao) throws TransException {
        try {
            TnPerfil tn = new TnPerfil();
            tn.setPerfil(perfil);
            tn.setLstAssociaPerfilPermissao(listAssociaPerfilPermissao);
            tn.salvar(ConstanteTnPerfil.NOME_EVENTO_SALVAR_PERFIL);
            return tn.getPerfil();
        } catch (TransException ex) {
            throw ex;
        }
    }

    /**
     * RECUPERAR LISTA DE PERIS MONTANDO CONSULTA DINAMICAMENTE
     * BUSCA PERFIL POR:
     * NOMEPERFIL
     * @param pPerfil
     * @return
     * @throws TransException 
     */
    public List<Perfil> recListaPerfis(Perfil pPerfil) throws TransException {
        List<Perfil> retListaPerfil = null;
        try {
            TnPerfil tn = new TnPerfil();
            retListaPerfil = tn.recListaPerfil(pPerfil);
        } catch (TransException ex) {
            throw ex;
        }

        return retListaPerfil;
    }

    /**
     * RECUPERAR PERFIL PELO ID
     * @param id
     * @return
     * @throws TransException 
     */
    public Perfil recPerfilPorId(Long id) throws TransException {
        Perfil retorno = null;
        try {
            TnPerfil tn = new TnPerfil();
            retorno = tn.recPerfilPorId(id);
        } catch (TransException ex) {
            throw ex;
        }
        return retorno;
    }

    /**
     * Recuperar lista associaPerfilPermissao por perfil
     * @param usuario
     * @return
     * @throws TransException 
     */
    public List<AssociaPerfilPermissao> recPermissoesPorPerfil(Perfil perfil) throws TransException {
        List<AssociaPerfilPermissao> lstRetorno = null;
        try {
            TnPerfil tn = new TnPerfil();
            tn.setPerfil(perfil);
            lstRetorno = tn.recPermissoesPorPerfil();
        } catch (TransException ex) {
            throw ex;
        }
        return lstRetorno;
    }
}
