/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.classes.serverimpl;

import br.com.dcoracoes.client.Excecao.ClientDCoracoesException;
import br.com.dcoracoes.servico.service.AssociaPerfilPermissao;
import br.com.dcoracoes.servico.service.Perfil;
import java.util.List;

/**
 *
 * @author Cleberson
 */
public class PerfilServerImpl<T extends Perfil> extends BaseServerImpl<T> implements IPerfilImpl<T> {

    @Override
    public List<AssociaPerfilPermissao> recPermissoesPorPerfil(Perfil perfil) throws ClientDCoracoesException {

        List<AssociaPerfilPermissao> lstPermissoes = null;

        try {
            lstPermissoes = this.port.recPermissoesPorPerfil(perfil);
        } catch (Exception ex) {
            throw new ClientDCoracoesException(ex);
        }

        return lstPermissoes;
    }

    @Override
    public List recTodos(Object param) throws ClientDCoracoesException {
        List<Perfil> perfis = null;

        try {
            perfis = this.port.recListaPerfis((T)param);
        } catch (Exception ex) {
            throw new ClientDCoracoesException(ex);
        }
        return perfis;
    }
    /**
     * METODO PARA SALVAR PERFIL
     * @param perfil
     * @return
     * @throws TransException 
     */
    public void salvarPerfil(Perfil perfil, List<AssociaPerfilPermissao> listAssociaPerfilPermissao) throws ClientDCoracoesException {
        try {
            this.port.salvarPerfil(perfil, listAssociaPerfilPermissao);
        } catch (Exception ex) {
            throw new ClientDCoracoesException(ex);
        }
    }
//
//    /**
//     * RECUPERAR LISTA DE PERIS MONTANDO CONSULTA DINAMICAMENTE
//     * BUSCA PERFIL POR:
//     * NOMEPERFIL
//     * @param pPerfil
//     * @return
//     * @throws TransException 
//     */
//    public List<Perfil> recListaPerfis(Perfil pPerfil) throws TransException {
//        List<Perfil> retListaPerfil = null;
//        try {
//            TnPerfil tn = new TnPerfil();
//            retListaPerfil = tn.recListaPerfil(pPerfil);
//        } catch (TransException ex) {
//            throw ex;
//        }
//
//        return retListaPerfil;
//    }
//
//    /**
//     * RECUPERAR PERFIL PELO ID
//     * @param id
//     * @return
//     * @throws TransException 
//     */
//    public Perfil recPerfilPorId(Long id) throws TransException {
//        Perfil retorno = null;
//        try {
//            TnPerfil tn = new TnPerfil();
//            retorno = tn.recPerfilPorId(id);
//        } catch (TransException ex) {
//            throw ex;
//        }
//        return retorno;
//    }
//
//    /**
//     * Recuperar lista associaPerfilPermissao por perfil
//     * @param usuario
//     * @return
//     * @throws TransException 
//     */
//    public List<AssociaPerfilPermissao> recPermissoesPorPerfil(Perfil perfil) throws TransException {
//        List<AssociaPerfilPermissao> lstRetorno = null;
//        try {
//            TnPerfil tn = new TnPerfil();
//            tn.setPerfil(perfil);
//            lstRetorno = tn.recPermissoesPorPerfil();
//        } catch (TransException ex) {
//            throw ex;
//        }
//        return lstRetorno;
//    }
}
