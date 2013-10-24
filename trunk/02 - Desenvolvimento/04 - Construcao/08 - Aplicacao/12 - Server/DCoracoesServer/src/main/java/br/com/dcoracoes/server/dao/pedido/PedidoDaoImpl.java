/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.dao.pedido;

import br.com.dcoracoes.server.dao.ModelGenericoDaoImpl;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.cadastro.PessoaFisica;
import br.com.dcoracoes.server.model.cadastro.Revendedor;
import br.com.dcoracoes.server.model.pedido.Pedido;
import br.com.dcoracoes.server.model.pedido.PedidoCompra;
import br.com.dcoracoes.server.model.pedido.PedidoVenda;
import br.com.dcoracoes.server.util.HibernateUtil;
import br.com.dcoracoes.server.util.LogUtil;
import br.com.dcoracoes.server.util.ServerUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Robson
 */
public class PedidoDaoImpl<T extends Pedido> extends ModelGenericoDaoImpl implements PedidoDao<T> {

    @Override
    public void mantemPedido(T pedido) throws ServerException {
        this.mantemObjectGenerico(pedido.getClass(), pedido);
    }

    @Override
    public List<T> recPedidos(T pedido) throws ServerException {
        List<T> listaRetorno = null;
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSession();
            Query query = sessao.createQuery(montarHql(pedido));
            listaRetorno = query.list();

            //Inicializa ItensDePedido
            for (Pedido item : listaRetorno) {
                //Inicializa lista de itens do pedido
                Hibernate.initialize(item.getListaItensPedido());

                //Inicializa atributos de pedido venda
                if (item.getClass().equals(PedidoVenda.class)) {
                    if (((PedidoVenda) item).getPagamento() != null) {
                        //Inicializa lista de parcelas do pagamento
                        Hibernate.initialize(((PedidoVenda) item).getPagamento().getListaParcelas());
                    }

                    //Inicializa Lista de Telefones e Email do Revendedor
                    Hibernate.initialize(((PedidoVenda) item).getRevendedor().getPessoa().getEmails());
                    Hibernate.initialize(((PedidoVenda) item).getRevendedor().getPessoa().getTelefones());
                } else {
                    //Inicializa Pedido Compra
                    //Inicializa Lista de Telefones e Email do Fornecedor
                    if(((PedidoCompra) item).getFornecedor() != null){
                        Hibernate.initialize(((PedidoCompra) item).getFornecedor().getPessoa().getEmails());
                        Hibernate.initialize(((PedidoCompra) item).getFornecedor().getPessoa().getTelefones());
                    }
                }


            }



        } catch (HibernateException ex) {
            throw new ServerException(ex);
        } catch (Exception exGenerica) {
            throw new ServerException(exGenerica);
        }
        return listaRetorno;
    }

    @Override
    public void removePedido(T pedido) throws ServerException {
        this.deleteObject(pedido);
    }

    /**
     * MONTAR HQL DINAMICO PARA PEDIDO
     * @param pedido
     * @return 
     */
    private String montarHql(T pedido) {
        boolean useWhere = false;

        StringBuilder hql = new StringBuilder();
        hql.append("From Pedido p ");
        hql.append(" WHERE p.class = '").append(pedido.getClass().getSimpleName()).append("'");

        //VERIFICA CODIGO PEDIDO
        String codigo = pedido.getCodigo();
        if (codigo != null) {
            if (!codigo.isEmpty()) {
                hql.append(ServerUtil.getClausulaSql(useWhere));
                hql.append(" p.codigo = '").append(codigo).append("' ");
            }
        }

        //DATA DO PEDIDO
        Date data = pedido.getDataPedido();
        if (data != null) {
            SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");            
            hql.append(ServerUtil.getClausulaSql(useWhere));
            hql.append(" p.data_pedido = '").append(formatoData.format(data)).append("'");
        }

        //ATRIBUTO PEDIDO VENDA
        if (pedido.getClass().equals(PedidoVenda.class)) {
            PedidoVenda pedidoVenda = (PedidoVenda) pedido;
            //Nome do Revendedor
            if (pedidoVenda.getRevendedor() != null) {
                String nome = pedidoVenda.getRevendedor().getPessoa().getNome();
                if (nome != null) {
                    if (!nome.isEmpty()) {
                        hql.append(ServerUtil.getClausulaSql(useWhere));
                        hql.append("p.revendedor.pessoa.nome like '").append(nome).append("%'").append(" ");
                    }
                }
            }
        } else {
            PedidoCompra pedidoCompra = (PedidoCompra) pedido;
            if (pedidoCompra.getFornecedor() != null) {
                String nome = pedidoCompra.getFornecedor().getPessoa().getNome();
                if (nome != null) {
                    if (!nome.isEmpty()) {
                        hql.append(ServerUtil.getClausulaSql(useWhere));
                        hql.append("p.fornecedor.pessoa.nome like '").append(nome).append("%'").append(" ");
                    }
                }
            }
            
            if(pedido.getDataPedido() == null){
                GregorianCalendar calendar = new GregorianCalendar(); 
                calendar.add(Calendar.MONTH, -6); 
                Date dataFiltro = calendar.getTime();
                
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                hql.append(" And ").append(" p.dataPedido >= '").append(format.format(dataFiltro)).append("'");
            }
        }

        return hql.toString();
    }

    /**
     * RECUPERA MAX CODIGO DO PEDIDO CADASTRADO
     * @return
     * @throws ServerException 
     */
    @Override
    public int recMaxCodigoPedido() throws ServerException {
        int retorno = -1;
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSession();
            StringBuilder hql = new StringBuilder();
            hql.append("Select Max(p.codigo) from Pedido p");
            Query query = sessao.createQuery(hql.toString());
            Object ob = query.uniqueResult();
            if (ob != null) {
                retorno = Integer.parseInt(String.valueOf(query.uniqueResult()));
            } else {
                retorno = -1;
            }
        } catch (HibernateException ex) {
            throw new ServerException(ex);
        } catch (Exception exGenerica) {
            throw new ServerException(exGenerica);
        }
        return retorno;
    }

    @Override
    public PedidoVenda recUltimoPedidoVenda(Revendedor rev) throws ServerException {
        Session sessao = null;
        PedidoVenda retornoPedido = null;
        try {
            sessao = HibernateUtil.getSession();
            StringBuilder hql = new StringBuilder();
            hql.append("From Pedido p Where p.dataPedido = ");
            hql.append("(Select Max(dataPedido) from Pedido) ");
            hql.append(" And p.revendedor.id  = ").append(rev.getId());
            Query query = sessao.createQuery(hql.toString());
            Object ob = query.uniqueResult();
            if (ob != null) {
                retornoPedido = (PedidoVenda) query.uniqueResult();
            }
        } catch (HibernateException ex) {
            throw new ServerException(ex);
        } catch (Exception exGenerica) {
            throw new ServerException(exGenerica);
        }
        return retornoPedido;
    }

    @Override
    public List<HashMap<String, Object>> recRelatorioPedidosPorRevendedor(HashMap<String, Object> parameter) throws ServerException {
        LogUtil.logInicioProcessoMetodo(Revendedor.class, "recRelatorioPedidosPorRevendedor");
        Session sessao = null;
        List listaIDRevendedor = null;
        List listaRetorno = new ArrayList();
        try {
            sessao = HibernateUtil.getSession();
            listaIDRevendedor = recListIDRevendedorVenda(sessao, parameter);
            if(listaIDRevendedor == null)
                return listaRetorno;            
                        
            listaRetorno = recListRelatorioRevendedorPedidoVenda(sessao, listaIDRevendedor, parameter);

            LogUtil.logSucesso(Revendedor.class, "recRelatorioPedidosPorRevendedor");

        } catch (HibernateException ex) {
            LogUtil.logDescricaoErro(Revendedor.class, "ERRO AO BUSCAR RELATORIO VENDA POR REVENDEDOR", ex);
            throw new ServerException(ex);
        } catch (Exception exGenerica) {
            LogUtil.logDescricaoErro(Revendedor.class, "ERRO GENERICO", exGenerica);
            throw new ServerException(exGenerica);
        } finally {
            LogUtil.logFimProcessoMetodo(Revendedor.class, "recRelatorioPedidosPorRevendedor");
        }

        return listaRetorno;
    }
    
    /**
     * Retorna lista com todos id dos revendedores para PedidoVenda
     * @param session
     * @return 
     */
    private List recListIDRevendedorVenda(Session sessao, HashMap<String, Object> parameter){
        
        boolean useWhere = true;
        
        StringBuilder hql = new StringBuilder();
        hql.append("Select Distinct(ped.revendedor.id) From PedidoVenda ped ");
        
        montaParameter(useWhere, hql, parameter);
        
        Query query = sessao.createQuery(hql.toString());
        return query.list();
    }
    
    /**
     * RETORNA LISTA DE RELATORIO PARA PEDIDO VENDA POR REVENDEDOR
     * @param revendedor
     * @return 
     */
    private List<PedidoVenda> recListRelatorioRevendedorPedidoVenda(Session sessao, List list, HashMap<String, Object> parameter) {
        
        List<PedidoVenda> listRetorno = new ArrayList<PedidoVenda>();
        for (Object object : list) {
            boolean useWhere = true;
            
            StringBuilder hql = new StringBuilder();
            hql.append("Select ped.revendedor.codigo, ped.revendedor.pessoa.nome, sum(ped.total) From PedidoVenda ped ");
            hql.append(ServerUtil.getClausulaSql(useWhere));
            hql.append("ped.revendedor.id = ").append(object);
            hql.append(" ");
            useWhere = false;
            
            montaParameter(useWhere, hql, parameter);            
            
            Query query = sessao.createQuery(hql.toString());
            
            Object[] result = (Object[])query.uniqueResult();
            
            PedidoVenda pedidoVenda = new PedidoVenda();
            
            Revendedor revendedor = new Revendedor();
            revendedor.setCodigo((Integer)result[0]);
            PessoaFisica pessoa = new PessoaFisica();
            pessoa.setNome((String)result[1]);
            revendedor.setPessoa(pessoa);
            pedidoVenda.setRevendedor(revendedor);
            pedidoVenda.setTotal(Float.parseFloat(result[2].toString()));
            
            listRetorno.add(pedidoVenda);
        }
        return listRetorno;
    }
    
    private void montaParameter(boolean useWhere, StringBuilder hql, HashMap<String, Object> parameter){
        
        //ID REVENDEDOR
        if(parameter.containsKey("codigoRevendedor")){
            hql.append(ServerUtil.getClausulaSql(useWhere)); 
            hql.append("ped.revendedor.codigo = ").append(Integer.parseInt(parameter.get("codigoRevendedor").toString())).append(" ");
            useWhere = false;
        }
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd H:mm:ss"); 
        //DATA NASCIMENTO INICIO
        if(parameter.containsKey("dataPedidoInicio")){
            hql.append(ServerUtil.getClausulaSql(useWhere));      
            Date date = (Date)parameter.get("dataPedidoInicio");
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            calendar.set(GregorianCalendar.HOUR_OF_DAY, 0);
            calendar.set(GregorianCalendar.MINUTE, 0);
            calendar.set(GregorianCalendar.SECOND, 0);
            String data = format.format(calendar.getTime().getTime());
            
            hql.append("ped.dataPedido >= '").append(data).append("' ");
            useWhere = false;
        }
        
        //DATA NASCIMENTO FINAL
        if(parameter.containsKey("dataPedidoFim")){
            hql.append(ServerUtil.getClausulaSql(useWhere));
            Date date = (Date)parameter.get("dataPedidoFim");
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            calendar.set(GregorianCalendar.HOUR_OF_DAY, 23);
            calendar.set(GregorianCalendar.MINUTE, 59);
            calendar.set(GregorianCalendar.SECOND, 59);
            String data = format.format(calendar.getTime().getTime());
            
            hql.append("ped.dataPedido <= '").append(data).append("' ");
        }
    }
}
