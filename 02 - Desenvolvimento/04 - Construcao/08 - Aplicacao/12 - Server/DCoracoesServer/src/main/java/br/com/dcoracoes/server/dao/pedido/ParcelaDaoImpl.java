 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.dao.pedido;

import br.com.dcoracoes.server.dao.ModelGenericoDaoImpl;
import br.com.dcoracoes.server.enuns.Enum_Situacao_Parcela;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.pedido.Parcela;
import br.com.dcoracoes.server.util.HibernateUtil;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Robson
 */
public class ParcelaDaoImpl extends ModelGenericoDaoImpl implements ParcelaDao<Parcela> {

    @Override
    public void mantemParcela(Parcela parcela) throws ServerException {
        this.mantemObjectGenerico(Parcela.class, parcela);
    }

    @Override
    public void removeParcela(Parcela parcela) throws ServerException {
        this.deleteObject(parcela);
    }

    @Override
    public List<Parcela> recParcelasALiberar(long idRevendedor) throws ServerException {
        List<Parcela> listaRetorno = null;
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSession();
            Query query = sessao.createQuery(montarHql(idRevendedor, true));
            listaRetorno = query.list();
        } catch (HibernateException ex) {
            throw new ServerException(ex);
        } catch (Exception exGenerica) {
            throw new ServerException(exGenerica);
        }
        return listaRetorno;
    }
    
    @Override
    public List<Parcela> recParcelasAtivas(long idRevendedor) throws ServerException {
        List<Parcela> listaRetorno = null;
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSession();
            Query query = sessao.createQuery(montarHql(idRevendedor, false));
            listaRetorno = query.list();
        } catch (HibernateException ex) {
            throw new ServerException(ex);
        } catch (Exception exGenerica) {
            throw new ServerException(exGenerica);
        }
        return listaRetorno;
    }

    /**
     * Monta hql para consultar parcelas a liberar e ativas
     * @param idRevendedor
     * @return 
     */
    //sql errado
    private String montarHql(long idRevendedor, boolean aLiberar) {        
        StringBuilder hql = new StringBuilder();
        hql.append("Select parc from Parcela parc,Pagamento pag, Pedido ped ");
        hql.append("Where ped.pagamento.id = pag.id and parc.pagamento.id = pag.id ");
        hql.append("and ped.revendedor.id = ").append(idRevendedor);
        hql.append(" and parc.status = ").append(Enum_Situacao_Parcela.PENDENTE.getCodigo());
        if(aLiberar){
            SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();        
            Date dataAtual = calendar.getTime();             
            hql.append(" and parc.dataVencimento <= '").append(formatoData.format(dataAtual)).append("'");  
        }
        return hql.toString();
    }
}
