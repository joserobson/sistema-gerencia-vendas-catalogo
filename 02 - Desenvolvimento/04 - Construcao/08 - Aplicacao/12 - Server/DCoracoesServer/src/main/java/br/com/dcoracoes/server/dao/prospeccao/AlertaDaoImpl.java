/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.dao.prospeccao;

import br.com.dcoracoes.server.dao.ModelGenericoDaoImpl;
import br.com.dcoracoes.server.enuns.Enum_Situacao_Alerta;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.cadastro.Pessoa;
import br.com.dcoracoes.server.model.canalacesso.Usuario;
import br.com.dcoracoes.server.model.prospeccao.Alerta;
import br.com.dcoracoes.server.util.DataUtil;
import br.com.dcoracoes.server.util.HibernateUtil;
import br.com.dcoracoes.server.util.LogUtil;
import br.com.dcoracoes.server.util.ServerUtil;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Robson
 */
public class AlertaDaoImpl extends ModelGenericoDaoImpl implements AlertaDao {

    /**
     * 
     * @param alerta
     * @throws ServerException 
     */
    @Override
    public void mantemAlerta(Alerta alerta) throws ServerException {
        this.mantemObjectGenerico(Alerta.class, alerta);
    }

    /**
     * 
     * @param p
     * @return
     * @throws ServerException 
     */
    @Override
    public List recAlertasPorPessoa(Pessoa p) throws ServerException {
        LogUtil.logInicioProcessoMetodo(Alerta.class, "recAlertasPorPessoa");
        List<Alerta> retornoLista = null;
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSession();
            StringBuilder hql = new StringBuilder();
            hql.append("From Alerta a Where a.pessoa.id = ");
            hql.append(p.getId());
            Query query = sessao.createQuery(hql.toString());
            retornoLista = query.list();           
            initializeList(retornoLista);
            LogUtil.logSucesso(Alerta.class, "recAlertasPorPessoa", p.getId());
        } catch (HibernateException ex) {
            LogUtil.logDescricaoErro(Alerta.class, "ERRO AO RECUPERAR LISTA DE ALERTAS POR PESSOA", ex);
            throw new ServerException(ex);
        } catch (Exception exGenerica) {
            LogUtil.logDescricaoErro(Alerta.class, "ERRO GENERICO AO RECUPERAR LISTA DE ALERTAS POR PESSOA", exGenerica);
            throw new ServerException(exGenerica);
        } finally {
            LogUtil.logFimProcessoMetodo(Alerta.class, "recAlertasPorPessoa");
        }

        return retornoLista;
    }

    @Override
    public int recNumeroAlertasDoDia() throws ServerException {
        LogUtil.logInicioProcessoMetodo(Alerta.class, "recNumeroAlertasDoDia");
        int retorno = -1;
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSession();
            StringBuilder hql = new StringBuilder();
            hql.append("Select count(*)From Alerta a Where a.dataAlerta BETWEEN :dataInicial And :dataFinal ");
            Query query = sessao.createQuery(hql.toString());

            //PASSAGEM DE PARAMETROS
            Date dataInicial = DataUtil.getDataInicial(Calendar.getInstance().getTime());
            Date dataFinal = DataUtil.getDataFinal(Calendar.getInstance().getTime());
            query.setParameter("dataInicial", dataInicial);
            query.setParameter("dataFinal", dataFinal);

            retorno = Integer.parseInt(query.uniqueResult().toString());

            LogUtil.logSucesso(Alerta.class, "recNumeroAlertasDoDia", Long.valueOf(0));
        } catch (HibernateException ex) {
            LogUtil.logDescricaoErro(Alerta.class, "ERRO AO RECUPERAR NUMERO DE ALERTAS DO DIA", ex);
            throw new ServerException(ex);
        } catch (Exception exGenerica) {
            LogUtil.logDescricaoErro(Alerta.class, "ERRO GENERICO", exGenerica);
            throw new ServerException(exGenerica);
        } finally {
            LogUtil.logFimProcessoMetodo(Alerta.class, "recNumeroAlertasDoDia");
        }

        return retorno;
    }

    /**
     * RECUPERA LISTA DE ALERTAS COM PARAMETRO MONTADO
     * DINAMICAMENTE
     * @param alerta
     * @return
     * @throws ServerException 
     */
    @Override
    public List recListaAlerta(Alerta alerta) throws ServerException {
        LogUtil.logInicioProcessoMetodo(Alerta.class, "recListaAlerta");
        Session sessao = null;
        List<Alerta> listaRetorno = null;
        try {
            sessao = HibernateUtil.getSession();
            Query query = sessao.createQuery(montarHql(alerta));
            listaRetorno = query.list();            
            initializeList(listaRetorno);
            LogUtil.logSucesso(Alerta.class, "recListaAlerta", Long.valueOf(0));

        } catch (HibernateException ex) {
            LogUtil.logDescricaoErro(Alerta.class, "ERRO AO BUSCAR ALERTAS", ex);
            throw new ServerException(ex);
        } catch (Exception exGenerica) {
            LogUtil.logDescricaoErro(Alerta.class, "ERRO GENERICO", exGenerica);
            throw new ServerException(exGenerica);
        } finally {
            LogUtil.logFimProcessoMetodo(Alerta.class, "recListaAlerta");
        }

        return listaRetorno;
    }

    /**
     * MONTA HQL DINAMICAMENTE PARA UMA CONSULTA DE ALERTA
     * @param alerta
     * @return 
     */
    private String montarHql(Alerta alerta) {
        boolean useWhere = true;

        StringBuilder hql = new StringBuilder();
        hql.append("From Alerta a ");
        
        //VERIFICA DATAALERTA
        Date dataAlerta = alerta.getDataAlerta();
        if (dataAlerta != null) {
            Date dataInicial = DataUtil.getDataInicial(dataAlerta);
            Date dataFinal = DataUtil.getDataFinal(dataAlerta);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            hql.append("Where a.dataAlerta BETWEEN '").append(format.format(dataInicial)).append("' And '").append(format.format(dataFinal)).append("'");
            useWhere = false;
        }

        //VERIFICA ATENDENTE
        Usuario atendente = alerta.getAtendente();
        if (atendente != null) {
            hql.append(ServerUtil.getClausulaSql(useWhere));
            hql.append("a.atendente.pessoa.nome like '").append(atendente.getPessoa().getNome()).append("%'").append(" ");
            useWhere = false;
        }

        //VERIFICA REVENDEDOR PESSOA        
        Pessoa pessoaRevendedor = alerta.getPessoa();
        if (pessoaRevendedor != null) {
            hql.append(ServerUtil.getClausulaSql(useWhere));
            hql.append("a.pessoa.nome like '").append(pessoaRevendedor.getNome()).append("%'").append(" ");
            useWhere = false;
        }

        //VERIFICA PROTOCOLO
        String protocolo = alerta.getProtocolo();
        if (protocolo != null
                && !protocolo.equals("")) {
            hql.append(ServerUtil.getClausulaSql(useWhere));
            hql.append("a.protocolo = '").append(protocolo).append("'").append(" ");
            useWhere = false;
        }

        //VERIFICA ASSUNTO
        String assunto = alerta.getAssunto();
        if (assunto != null
                && !assunto.equals("")) {
            hql.append(ServerUtil.getClausulaSql(useWhere));
            hql.append("a.assunto = '").append(assunto).append("'").append(" ");
            useWhere = false;
        }

        //VERIFICA SITUACAO
        int situacao = alerta.getSituacaoAlerta();
        if (situacao > 0) {
            hql.append(ServerUtil.getClausulaSql(useWhere));
            hql.append("a.situacaoAlerta = ").append(situacao).append(" ");;
            useWhere = false;
            if(situacao == Enum_Situacao_Alerta.RESOLVIDO.getCodigo()){
                GregorianCalendar calendar = new GregorianCalendar(); 
                calendar.add(Calendar.DAY_OF_MONTH, -30); 
                Date dataFiltro = calendar.getTime();
                
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                hql.append(" And ").append(" a.dataAlerta >= '").append(format.format(dataFiltro)).append("'");
            }
        }        
        
        //ADICIONADO ORDENAÇÃO POR DATA DECRESCENTE
        hql.append(" ORDER BY a.dataAlerta DESC");
            
        return hql.toString();
    }
    
    private void initializeList(List<Alerta> lista){
        for (Alerta item : lista) {
                Hibernate.initialize(item.getPessoa().getEmails());
                Hibernate.initialize(item.getPessoa().getTelefones());
                Hibernate.initialize(item.getAtendente().getPessoa().getEmails());
                Hibernate.initialize(item.getAtendente().getPessoa().getTelefones());
            }
    }
}
