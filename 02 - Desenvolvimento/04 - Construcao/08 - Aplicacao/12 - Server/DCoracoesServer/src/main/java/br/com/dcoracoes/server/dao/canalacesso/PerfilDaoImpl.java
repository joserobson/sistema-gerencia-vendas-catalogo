/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.dao.canalacesso;

import br.com.dcoracoes.server.dao.ModelGenericoDaoImpl;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.canalacesso.Perfil;
import br.com.dcoracoes.server.util.HibernateUtil;
import br.com.dcoracoes.server.util.ServerUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Robson
 */
public class PerfilDaoImpl extends ModelGenericoDaoImpl implements PerfilDao {

    /**
     * SALVAR PERFIL
     * @param perfil
     * @throws ServerException 
     */
    @Override
    public void mantemPerfil(Perfil perfil) throws ServerException {
        this.mantemObjectGenerico(Perfil.class, perfil);
    }

    /**
     * RECUPERA LISTA DE PERFIL
     * @param perfil
     * @return
     * @throws ServerException 
     */
    @Override
    public List<Perfil> recPerfil(Perfil perfil) throws ServerException {

        List<Perfil> listaRetorno = null;
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSession();
            Query hql = sessao.createQuery(montarHql(perfil));
            listaRetorno = hql.list();
        } catch (HibernateException ex) {
            throw new ServerException(ex);
        } catch (Exception exGenerica) {
            throw new ServerException(exGenerica);
        }
        return listaRetorno;
    }

    /**
     * MONTAR HQL PARA CONSULTA DE PERFIS
     * @param perfil
     * @return 
     */
    private String montarHql(Perfil perfil) {
        boolean useWhere = true;

        StringBuilder hql = new StringBuilder();
        hql.append("From Perfil p ");

        //CODIGO
        Long codigo = perfil.getId();
        if(codigo != null){
            hql.append("Where p.id = ").append(codigo);
            useWhere = false;
        }
        
        //NOME PERFIL
        String nomePerfil = perfil.getNomePerfil();
        if (nomePerfil != null) {
            hql.append(ServerUtil.getClausulaSql(useWhere));
            hql.append("p.nomePerfil like '").append(nomePerfil).append("%' ");            
        }
        
        return hql.toString();
    }

    @Override
    public Perfil getPerfilPorId(Long id) throws ServerException {
        return (Perfil)this.getObjectPorId(id, Perfil.class);
    }
}
