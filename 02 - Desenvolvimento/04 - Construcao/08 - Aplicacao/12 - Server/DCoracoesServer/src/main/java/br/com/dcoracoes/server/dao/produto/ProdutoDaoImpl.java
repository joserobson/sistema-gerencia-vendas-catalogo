/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.dao.produto;

import br.com.dcoracoes.server.dao.ModelGenericoDaoImpl;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.produto.Produto;
import br.com.dcoracoes.server.util.HibernateUtil;
import br.com.dcoracoes.server.util.ServerUtil;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Robson
 */
public class ProdutoDaoImpl extends ModelGenericoDaoImpl implements ProdutoDao<Produto> {

    @Override
    public void mantemProduto(Produto produto) throws ServerException {
        this.mantemObjectGenerico(Produto.class, produto);
    }

    @Override
    public List<Produto> recProdutos(Produto produto, boolean useLike) throws ServerException {

        List<Produto> listaRetorno = null;
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSession();
            Query query = sessao.createQuery(montarHql(produto, useLike));
            listaRetorno = query.list();

            for (Produto item : listaRetorno) {
                //carrega lista itensProduto
                Hibernate.initialize(item.getListaItensProduto());
                
                //carrega dados do fornecedor
                if (item.getFornecedor() != null && item.getFornecedor().getPessoa() != null)
                {
                    Hibernate.initialize(item.getFornecedor().getPessoa().getEmails());
                    Hibernate.initialize(item.getFornecedor().getPessoa().getTelefones());
                }
            }
        } catch (HibernateException ex) {
            throw new ServerException(ex);
        } catch (Exception exGenerica) {
            throw new ServerException(exGenerica);
        }

        return listaRetorno;
    }

    /**
     * Monta HQL Passando parametro
     * @param produto
     * @return 
     */
    private String montarHql(Produto produto, boolean useLike) {
        boolean useWhere = true;
        String comparacao = " = ";
        if(useLike)
            comparacao = " like ";

        StringBuilder hql = new StringBuilder();
        hql.append("Select p From Produto p");
        
        //ESTOQUE ABAIXO ESTOQUE MINIMO
        if(produto.getEstoqueBaixo() != null)
            if(produto.getEstoqueBaixo()){
                hql.append(", ItemProduto i");
                hql.append(ServerUtil.getClausulaSql(useWhere));
                hql.append("p.id").append(" = ").append("i.produto.id");
                useWhere = false;
                hql.append(ServerUtil.getClausulaSql(useWhere));
                hql.append("i.EstoqueAtual").append(" <= ").append("i.estoqueMinimo");
            }

        //VERIFICA CODIGO BARRA
        String codigoBarra = produto.getCodigoBarra();
        if (codigoBarra != null) 
            if(!codigoBarra.isEmpty()){
                hql.append(ServerUtil.getClausulaSql(useWhere));
                hql.append("p.codigoBarra").append(comparacao).append("'").append(codigoBarra);
                if(useLike)
                    hql.append("%");
                hql.append("' ");
                useWhere = false;
            }

        //VERIFICA CODIGO FOR FISCAL
        String codigoForFiscal = produto.getCodigoForFiscal();
        if (codigoForFiscal != null) 
            if(!codigoForFiscal.isEmpty()){
                hql.append(ServerUtil.getClausulaSql(useWhere));
                hql.append("p.codigoForFiscal").append(comparacao).append("'").append(codigoForFiscal);
                if(useLike)
                    hql.append("%");
                hql.append("' ");
                useWhere = false;
            }

        //VERIFICA CODIGO PRO FISCAL
        String codigoProFiscal = produto.getCodigoProFiscal();
        if (codigoProFiscal != null) 
            if(!codigoProFiscal.isEmpty()){
                hql.append(ServerUtil.getClausulaSql(useWhere));
                hql.append("p.codigoProFiscal").append(comparacao).append("'").append(codigoProFiscal);
                if(useLike)
                    hql.append("%");
                hql.append("' ");
                useWhere = false;
            }

        //VERIFICA DESCRICAO
        String descricao = produto.getDescricao();
        if (descricao != null) 
            if(!descricao.isEmpty()){
                hql.append(ServerUtil.getClausulaSql(useWhere));
                hql.append("p.descricao like '").append(descricao).append("%'").append(" ");
                useWhere = false;
            }

        //REFERENCIA CATALOGO
        String referencia = produto.getReferenciaCatalogo();
        if (referencia != null) 
            if(!referencia.isEmpty()){
                hql.append(ServerUtil.getClausulaSql(useWhere));
//                hql.append("p.referenciaCatalogo like '").append(referencia).append("%' ");
                hql.append("p.referenciaCatalogo").append(comparacao).append("'").append(referencia);
                if(useLike)
                    hql.append("%");
                hql.append("' ");
                useWhere = false;
            }

        
        if (produto.getFornecedor() != null) {
            //NOME FORNECEDOR
            if(produto.getFornecedor().getPessoa() != null){
                String nomeFornecedor = produto.getFornecedor().getPessoa().getNome();
                if (nomeFornecedor != null) 
                    if(!nomeFornecedor.isEmpty()){
                        hql.append(ServerUtil.getClausulaSql(useWhere));
                        hql.append("p.fornecedor.pessoa.nome").append(comparacao).append("'").append(nomeFornecedor);
                        if(useLike)
                            hql.append("%");
                        hql.append("' ");
                        useWhere = false;
                    }
            }
            //CODIGO FORNECEDOR
            String codigoFornecedor = produto.getFornecedor().getCodigo();
            if (codigoFornecedor != null) 
                if(!codigoFornecedor.isEmpty()){
                    hql.append(ServerUtil.getClausulaSql(useWhere));
                    hql.append("p.fornecedor.codigo").append(comparacao).append("'").append(codigoFornecedor);
                    if(useLike)
                        hql.append("%");
                    hql.append("' ");
                }
            
        }
        
        hql.append(" ")
                .append("ORDER BY").append(" ")
                .append("p.fornecedor.pessoa.nome").append(", ")
                .append("p.descricao");
        

        return hql.toString();
    }

    @Override
    public Produto removeProduto(Produto produto) throws ServerException {
        return (Produto) this.deleteObject(produto);
    }
}
