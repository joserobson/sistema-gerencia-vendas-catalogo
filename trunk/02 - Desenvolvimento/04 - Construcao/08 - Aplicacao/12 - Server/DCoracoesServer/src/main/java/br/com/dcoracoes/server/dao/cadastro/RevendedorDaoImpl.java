/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.dao.cadastro;

import br.com.dcoracoes.server.dao.ModelGenericoDaoImpl;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.cadastro.Pessoa;
import br.com.dcoracoes.server.model.cadastro.PessoaFisica;
import br.com.dcoracoes.server.model.cadastro.Revendedor;
import br.com.dcoracoes.server.model.cadastro.Telefone;
import br.com.dcoracoes.server.util.HibernateUtil;
import br.com.dcoracoes.server.util.LogUtil;
import br.com.dcoracoes.server.util.ServerUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
public class RevendedorDaoImpl extends ModelGenericoDaoImpl implements RevendedorDao {

    /**
     * SALVAR REVENDEDOR
     * @param pRevendedor
     * @throws ServerException
     */
    @Override
    public void mantemRevendedor(Revendedor pRevendedor) throws ServerException {
        this.mantemObjectGenerico(Revendedor.class, pRevendedor);
    }

    /**
     *RECUPERA ULTIMO REVENDEDOR CADASTRADO
     * @return
     * @throws ServerException
     */
    @Override
    public Revendedor recUltimoRevendedorCadastrado() throws ServerException {
        LogUtil.logInicioProcessoMetodo(Revendedor.class, "recUltimoRevendedorCadastrado");
        Session sessao = null;
        Revendedor retorno = null;
        try {
            sessao = HibernateUtil.getSession();
            StringBuilder hql = new StringBuilder();
            hql.append("FROM Revendedor rev where rev.dataCadastro = (");
            hql.append("Select Max(dataCadastro) FROM Revendedor)");
            Query query = sessao.createQuery(hql.toString());
            List lst = query.list();
            if (lst != null
                    && lst.size() > 0) {
                retorno = (Revendedor) lst.get(0);

                //Inicializa Lista de Emails e telefones
                Hibernate.initialize(retorno.getPessoa().getEmails());
                Hibernate.initialize(retorno.getPessoa().getTelefones());
            }
            LogUtil.logSucesso(Revendedor.class, "recUltimoRevendedorCadastrado", Long.valueOf(0));

        } catch (HibernateException ex) {
            LogUtil.logDescricaoErro(Revendedor.class, "ERRO AO BUSCAR ULTIMO REVENDEDOR CADASTRADO", ex);
            throw new ServerException(ex);
        } catch (Exception exGenerica) {
            LogUtil.logDescricaoErro(Revendedor.class, "ERRO GENERICO AO BUSCAR ULTIMO REVENDEDOR CADASTRADO", exGenerica);
            throw new ServerException(exGenerica);
        } finally {
            LogUtil.logFimProcessoMetodo(Revendedor.class, "recUltimoRevendedorCadastrado");
        }

        return retorno;
    }

    /**
     * RECUPERA CODIGO SEQUENCIAL
     * @return
     */
    @Override
    public int recCodigoSequencial() throws ServerException {
        LogUtil.logInicioProcessoMetodo(Revendedor.class, "recCodigoSequencial");
        Session sessao = null;
        int retorno = 0;
        try {
            sessao = HibernateUtil.getSession();
            StringBuilder hql = new StringBuilder();
            hql.append("SELECT MAX(rev.codigo)FROM Revendedor rev");
            Query query = sessao.createQuery(hql.toString());
            Object obj = query.uniqueResult();
            if (obj != null) {
                retorno = Integer.valueOf(obj.toString()) + 1;
            }
            LogUtil.logSucesso(Revendedor.class, "recCodigoSequencial", Long.valueOf(0));

        } catch (HibernateException ex) {
            LogUtil.logDescricaoErro(Revendedor.class, "ERRO AO BUSCAR ULTIMO REVENDEDOR CADASTRADO", ex);
            throw new ServerException(ex);
        }/**
         * TRATAMENTO EXCECAO GENERICA, DEPOIS REMOVER
         */
        catch (Exception exGenerica) {
            LogUtil.logDescricaoErro(Revendedor.class, "ERRO GENERICO REC SEQUENCIAL", exGenerica);
            throw new ServerException(exGenerica);
        } finally {
            LogUtil.logFimProcessoMetodo(Revendedor.class, "recCodigoSequencial");
        }

        return retorno;
    }

    /**
     * RECUPERAR LISTA DE REVENDEDORES SEGUNDO PARAMETRO
     * @param revendedor
     * @return
     * @throws ServerException 
     */
    @Override
    public List recRevendedor(Revendedor revendedor) throws ServerException {
        LogUtil.logInicioProcessoMetodo(Revendedor.class, "recRevendedor");
        Session sessao = null;
        List<Revendedor> listaRetorno = null;
        try {
            sessao = HibernateUtil.getSession();
            Query query = sessao.createQuery(montarHql(revendedor));
            listaRetorno = query.list();
            for (Revendedor item : listaRetorno) {
                Hibernate.initialize(item.getPessoa().getEmails());
                Hibernate.initialize(item.getPessoa().getTelefones());
            }

            LogUtil.logSucesso(Revendedor.class, "recRevendedor");

        } catch (HibernateException ex) {
            LogUtil.logDescricaoErro(Revendedor.class, "ERRO AO BUSCAR REVENDEDOR", ex);
            throw new ServerException(ex);
        } catch (Exception exGenerica) {
            LogUtil.logDescricaoErro(Revendedor.class, "ERRO GENERICO", exGenerica);
            throw new ServerException(exGenerica);
        } finally {
            LogUtil.logFimProcessoMetodo(Revendedor.class, "recRevendedor");
        }

        return listaRetorno;
    }

    /**
     * MONTA HQL DINAMICO DE ACORDO COM O PARAMETRO
     * @param revendedor
     * @return 
     */
    private String montarHql(Revendedor revendedor) {

        boolean useWhere = true;

        StringBuilder hql = new StringBuilder();
        hql.append("Select rev From Revendedor rev ");
        if (revendedor.getPessoa().getTelefones() != null)
            if(!revendedor.getPessoa().getTelefones().isEmpty()){
                hql.append("join rev.pessoa.telefones tel ");
            }
            
        //VERIFICA CODIGO
        int codigo = revendedor.getCodigo();
        if (codigo > 0) {
            hql.append("Where rev.codigo = ").append(codigo).append(" ");
            useWhere = false;
        }

        //VERIFICA PESSOA
        if (revendedor.getPessoa() != null) {
            //VERIFICA CPF
            String cpf = ((PessoaFisica) revendedor.getPessoa()).getCpf();
            if (cpf != null) {
                hql.append(ServerUtil.getClausulaSql(useWhere));
                hql.append("rev.pessoa.cpf = '").append(cpf).append("'").append(" ");
                useWhere = false;
            }


            //VERIFICA NOME
            String nome = revendedor.getPessoa().getNome();
            if (!nome.equals("")) {
                hql.append(ServerUtil.getClausulaSql(useWhere));
                hql.append("rev.pessoa.nome like '").append(nome).append("%'").append(" ");
                useWhere = false;
            }
            
            //VERIFICA ENDERECO
            if (revendedor.getPessoa().getEndereco() != null){
                
                //VERIFICA CIDADE
                String cidade = revendedor.getPessoa().getEndereco().getCidade();
                if (cidade != null) {
                    hql.append(ServerUtil.getClausulaSql(useWhere));
                    hql.append("rev.pessoa.endereco.cidade like '").append(cidade).append("%'").append(" ");
                }
                
                //VERIFICA CEP
                String cep = revendedor.getPessoa().getEndereco().getCep();
                if (cep != null) {
                    hql.append(ServerUtil.getClausulaSql(useWhere));
                    hql.append("rev.pessoa.endereco.cep = '").append(cep).append("'").append(" ");
                }
                
                //VERIFICA CEP
                String bairro = revendedor.getPessoa().getEndereco().getBairro();
                if (bairro != null) {
                    hql.append(ServerUtil.getClausulaSql(useWhere));
                    hql.append("rev.pessoa.endereco.bairro like '").append(bairro).append("%'").append(" ");
                }
            }
            
            //VERIFICA TELEFONE
            if (revendedor.getPessoa().getTelefones() != null)
                if(!revendedor.getPessoa().getTelefones().isEmpty()){
                    hql.append(ServerUtil.getClausulaSql(useWhere));
                    //hql.append("rev.pessoa.id = tel.pessoa.id").append(" ");
                    Telefone telefone = revendedor.getPessoa().getTelefones().get(0);
                    hql.append("tel.numero like '").append(telefone.getNumero()).append("%'").append(" ");
                }
        }
        return hql.toString();
    }

    @Override
    public List<Pessoa> recRevendedorEtiqueta(HashMap parameter) throws ServerException {
        LogUtil.logInicioProcessoMetodo(Revendedor.class, "recRevendedorEtiqueta");
        Session sessao = null;
        List<Pessoa> listaRetorno = null;
        try {
            sessao = HibernateUtil.getSession();
            Query query = sessao.createQuery(montarHql(parameter));
            listaRetorno = query.list();

            LogUtil.logSucesso(Revendedor.class, "recRevendedorEtiqueta");

        } catch (HibernateException ex) {
            LogUtil.logDescricaoErro(Revendedor.class, "ERRO AO BUSCAR REVENDEDOR", ex);
            throw new ServerException(ex);
        } catch (Exception exGenerica) {
            LogUtil.logDescricaoErro(Revendedor.class, "ERRO GENERICO", exGenerica);
            throw new ServerException(exGenerica);
        } finally {
            LogUtil.logFimProcessoMetodo(Revendedor.class, "recRevendedorEtiqueta");
        }

        return listaRetorno;
    }
    
    /**
     * MONTA HQL DINAMICO DE ACORDO COM O PARAMETRO
     * @param revendedor
     * @return 
     */
    private String montarHql(HashMap parameter) {

        boolean useWhere = true;

        StringBuilder hql = new StringBuilder();
        hql.append("Select rev.pessoa From Revendedor rev ");
        
        //SITUACAO
        if(parameter.containsKey("situacao")){
            hql.append("Where rev.situacao = ").append((Integer)parameter.get("situacao")).append(" ");
            useWhere = false;
        }
        
        //UF
        if(parameter.containsKey("uf")){
            hql.append(ServerUtil.getClausulaSql(useWhere));
            hql.append("rev.pessoa.endereco.estado = '").append((String)parameter.get("uf")).append("' ");
            useWhere = false;
        }
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
        //DATA NASCIMENTO INICIO
        if(parameter.containsKey("dataNascimentoInicio")){
            hql.append(ServerUtil.getClausulaSql(useWhere));            
            String[] dateAux = parameter.get("dataNascimentoInicio").toString().split("/");
            hql.append("(extract (day from rev.pessoa.dataNascimento) >= ").append(dateAux[0]).append(")");
            useWhere = false;
            hql.append(ServerUtil.getClausulaSql(useWhere)); 
            hql.append("(extract (month from rev.pessoa.dataNascimento) >= ").append(dateAux[1]).append(")");
        }
        
        //DATA NASCIMENTO FINAL
        if(parameter.containsKey("dataNascimentoFim")){
            hql.append(ServerUtil.getClausulaSql(useWhere));   
            String[] dateAux = parameter.get("dataNascimentoFim").toString().split("/");     
            hql.append("(extract (day from rev.pessoa.dataNascimento) <= ").append(dateAux[0]).append(")");
            useWhere = false;
            hql.append(ServerUtil.getClausulaSql(useWhere)); 
            hql.append("(extract (month from rev.pessoa.dataNascimento) <= ").append(dateAux[1]).append(")");
        }
        
        return hql.toString();
    }
    
    /**
     * 
     * @param cpf
     * @return
     * @throws ServerException 
     */
    @Override
    public List<Revendedor> recRevendedorPorCPF(String cpf) throws ServerException {

        List<Revendedor> lstRevendedor = new ArrayList<Revendedor>();
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSession();
            StringBuilder hql = new StringBuilder();
            hql.append("FROM Revendedor r Where r.pessoa.cpf = '").append(cpf).append("'");
            Query query = sessao.createQuery(hql.toString());
            List lstResult = query.list();
            if(!lstResult.isEmpty()){
                lstRevendedor.addAll(lstResult);             
            }

        } catch (HibernateException ex) {
            throw new ServerException(ex);
        } catch (Exception exGenerica) {
            throw new ServerException(exGenerica);
        }
        return lstRevendedor;
    }
}
