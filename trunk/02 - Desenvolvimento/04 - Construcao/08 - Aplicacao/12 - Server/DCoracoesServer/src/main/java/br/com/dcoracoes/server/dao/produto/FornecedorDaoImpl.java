/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.dao.produto;

import br.com.dcoracoes.server.dao.ModelGenericoDaoImpl;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.produto.Fornecedor;
import br.com.dcoracoes.server.util.HibernateUtil;
import br.com.dcoracoes.server.util.ServerUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Robson
 */
public class FornecedorDaoImpl extends ModelGenericoDaoImpl implements FornecedorDao<Fornecedor> {

    @Override
    public void mantemFornecedor(Fornecedor fornecedor) throws ServerException {
        this.mantemObjectGenerico(Fornecedor.class, fornecedor);
    }

    @Override
    public List<Fornecedor> recFornecedores(Fornecedor fornecedor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Fornecedor> recFornecedorPorCodigoNome(String codigo, String nome) throws ServerException {
                        
        List<Fornecedor> lstFornecedor = null;
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSession();
            StringBuilder hql = new StringBuilder();
            hql.append("FROM Fornecedor f"); 
            
            hql.append(ServerUtil.getClausulaSql(true));
            hql.append("f.codigo");
            if(codigo == null)
                hql.append(" is null");
            else
                hql.append(" = '").append(codigo).append("'");
            
            hql.append(ServerUtil.getClausulaSql(false));
            hql.append("f.pessoa.nome = '").append(nome).append("'");
            
            Query query = sessao.createQuery(hql.toString());
            lstFornecedor = query.list();

        } catch (HibernateException ex) {
            throw new ServerException(ex);
        } catch (Exception exGenerica) {
            throw new ServerException(exGenerica);
        }
        return lstFornecedor;
    }
    
}
