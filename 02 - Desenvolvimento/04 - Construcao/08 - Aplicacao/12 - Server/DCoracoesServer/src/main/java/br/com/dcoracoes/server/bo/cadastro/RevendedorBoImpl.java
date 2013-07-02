/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.bo.cadastro;

import br.com.dcoracoes.server.bo.movimento.AssociaPessoaContaBoImpl;
import br.com.dcoracoes.server.bo.movimento.MovimentoContaBoImpl;
import br.com.dcoracoes.server.bo.pedido.ParcelaBoImpl;
import br.com.dcoracoes.server.bo.pedido.PedidoBoImpl;
import br.com.dcoracoes.server.dao.movimento.AssociaPessoaContaDaoImpl;
import br.com.dcoracoes.server.dao.cadastro.AssociaPessoaDaoImpl;
import br.com.dcoracoes.server.dao.movimento.MovimentoContaDaoImpl;
import br.com.dcoracoes.server.dao.cadastro.PessoaDaoImpl;
import br.com.dcoracoes.server.dao.cadastro.RevendedorDao;
import br.com.dcoracoes.server.dao.pedido.ParcelaDaoImpl;
import br.com.dcoracoes.server.dao.pedido.PedidoDaoImpl;
import br.com.dcoracoes.server.enuns.Enum_Situacao;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.cadastro.AssociaPessoa;
import br.com.dcoracoes.server.model.cadastro.AssociaPessoaFK;
import br.com.dcoracoes.server.model.cadastro.Pessoa;
import br.com.dcoracoes.server.model.cadastro.Revendedor;
import br.com.dcoracoes.server.model.movimento.AssociaPessoaConta;
import br.com.dcoracoes.server.model.pedido.Parcela;
import br.com.dcoracoes.server.model.pedido.PedidoVenda;
import br.com.dcoracoes.server.util.HibernateUtil;
import br.com.dcoracoes.server.util.LogUtil;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Robson
 */
public class RevendedorBoImpl implements RevendedorBo {

    private RevendedorDao revendedorDao;

    @Override
    public void setRevendedorDao(RevendedorDao dao) {
        this.revendedorDao = dao;
    }

    @Override
    public void mantemRevendedor(Revendedor revendedor, Pessoa conjugue,
            List lstAssociaPessoaConta, List lstAssociaPessoaRevendedor) throws ServerException {

        //ABRIR LOG
        LogUtil.logInicioProcessoMetodo(RevendedorBoImpl.class, "mantemRevendedor");

        try {
            //ABRIR SESSAO
            HibernateUtil.setSession();

            //ABRIR TRANSACAO
            HibernateUtil.setTransacao();

            //SALVAR PESSOA ASSOCIADO AO REVENDEDOR
            this.salvarPessoa(revendedor.getPessoa());

            //SALVAR REVENDEDOR            
            revendedorDao.mantemRevendedor(revendedor);

            //SALVAR CONJUGUE
            if (conjugue != null) {
                this.salvarPessoa(conjugue);

                //CRIA ASSOCIACAO ENTRE PESSOA E O CONJUGUE
                this.criaAssociacaoPessoaConjugue(conjugue, revendedor.getPessoa());
            }

            //VINCULAR PESSOAS AO REVENDEDOR
            if (lstAssociaPessoaRevendedor != null
                    && lstAssociaPessoaRevendedor.size() > 0) {
                this.vinculaPessoaAoRevendedor(lstAssociaPessoaRevendedor);
            }

            //VINCULAR CONTAS AO REVENDEDOR
            if (lstAssociaPessoaConta != null
                    && lstAssociaPessoaConta.size() > 0) {
                this.vinculaContasAoRevendedor(lstAssociaPessoaConta);
            }

            //COMMIT NA TRANSACAO
            HibernateUtil.getTransacao().commit();

            //LOG SUCESSO
            LogUtil.logSucesso(RevendedorBoImpl.class, "mantemRevendedor", revendedor.getId());

        } catch (ServerException ex) {
            HibernateUtil.getTransacao().rollback();
            LogUtil.logDescricaoErro(RevendedorBoImpl.class, "ERRO AO SALVAR REVENDEDOR: " + revendedor.getId(), ex);
            throw ex;
        } catch (Exception exGenerica) {
            HibernateUtil.getTransacao().rollback();
            throw new ServerException(exGenerica);
        } finally {
            //FECHAR SESSAO
            HibernateUtil.getSession().close();

            //FECHA LOG
            LogUtil.logFimProcessoMetodo(RevendedorBoImpl.class, "mantemRevendedor");
        }
    }

    /**
     * METODO PARA SALVAR PESSOA
     * @param pessoa
     */
    private void salvarPessoa(Pessoa pessoa) throws ServerException {
        try {
            PessoaBoImpl pessoaBo = new PessoaBoImpl();
            PessoaDaoImpl pessoaDao = new PessoaDaoImpl();
            pessoaBo.setPessoaDao(pessoaDao);
            pessoaBo.mantemPessoa(pessoa);
        } catch (ServerException ex) {
            throw ex;
        }
    }

    /**
     * METODO PARA ASSOCIAR PESSOA(REVENDEDOR) COM O SEU CONJUGUE
     * @param conjugue
     * @param pessoa
     */
    private void criaAssociacaoPessoaConjugue(Pessoa conjugue, Pessoa pessoa) throws ServerException {
        try {
            AssociaPessoaFK associaPessoFK = new AssociaPessoaFK();
            associaPessoFK.setPessoaAssociada(conjugue);
            associaPessoFK.setPessoaAssociante(pessoa);
            AssociaPessoa associaPessoa = new AssociaPessoa();
            associaPessoa.setChaveComposta(associaPessoFK);
            associaPessoa.setGrauParentesco("CONJUGUE");
            //SALVAR ASSOCIACAO PESSOA
            AssociaPessoaBoImpl associaPessoaBo = new AssociaPessoaBoImpl();
            AssociaPessoaDaoImpl associaPessoaDao = new AssociaPessoaDaoImpl();
            associaPessoaBo.setAssociaPessoaDao(associaPessoaDao);
            associaPessoaBo.mantemAssociaPessoa(associaPessoa);
        } catch (ServerException ex) {
            throw ex;
        }
    }

    /**
     * METODO PARA ASSOCIAR CONTAS COM A PESSOA DO REVENDEDOR
     * @param lstAssociaPessoaConta
     */
    private void vinculaContasAoRevendedor(List lstAssociaPessoaConta) throws ServerException {
        if (lstAssociaPessoaConta != null
                && lstAssociaPessoaConta.size() > 0) {
            for (Object item : lstAssociaPessoaConta) {
                try {
                    AssociaPessoaConta associa = (AssociaPessoaConta) item;
                    //SALVAR PESSOA ASSOCIADA A CONTA CORRENTE
                    //VERIFICO SE ELA EXISTE
                    Pessoa pessoaConta = associa.getAssociaPessoaFK().getPessoa();
                    if (pessoaConta.getId() == null) {
                        this.salvarPessoa(pessoaConta);
                    }
                    MovimentoContaBoImpl movimentoBo = new MovimentoContaBoImpl();
                    MovimentoContaDaoImpl movimentoDao = new MovimentoContaDaoImpl();
                    movimentoBo.setMovimentoContaDao(movimentoDao);
                    movimentoBo.mantemMovimentoConta(associa.getAssociaPessoaFK().getConta());
                    //SALVAR ASSOCIACAO PESSOA CONTA CORRENTE
                    AssociaPessoaContaBoImpl associaPessoaContaBo = new AssociaPessoaContaBoImpl();
                    AssociaPessoaContaDaoImpl associaPessoaContaDao = new AssociaPessoaContaDaoImpl();
                    associaPessoaContaBo.setAssociaPessoaContaDao(associaPessoaContaDao);
                    associaPessoaContaBo.mantemAssociaPessoaConta(associa);
                } catch (ServerException ex) {
                    throw ex;
                }
            }
        }
    }

    /**
     * METODO PARA ASSOCIAR PESSOAS COM A PESSOA DO REVENDEDOR
     * @param lstAssociaPessoaConta
     */
    private void vinculaPessoaAoRevendedor(List lstAssociaPessoaRevendedor) throws ServerException {
        if (lstAssociaPessoaRevendedor != null
                && lstAssociaPessoaRevendedor.size() > 0) {
            for (Object item : lstAssociaPessoaRevendedor) {
                try {
                    AssociaPessoa associa = (AssociaPessoa) item;
                    //SALVAR PESSOA ASSOCIADA A PESSOA DO REVENDEDOR
                    //VERIFICO SE ELA EXISTE
                    Pessoa pessoaAssociada = associa.getChaveComposta().getPessoaAssociada();
                    if (pessoaAssociada.getId() == null) {
                        this.salvarPessoa(pessoaAssociada);
                    }
                    this.salvarPessoa(associa.getChaveComposta().getPessoaAssociada());
                    //SALVAR ASSOCIACAO PESSOA COM PESSOA DO REVENDEDOR
                    AssociaPessoaBoImpl associaPessoaBo = new AssociaPessoaBoImpl();
                    AssociaPessoaDaoImpl associaPessoaDao = new AssociaPessoaDaoImpl();
                    associaPessoaBo.setAssociaPessoaDao(associaPessoaDao);
                    associaPessoaBo.mantemAssociaPessoa(associa);
                } catch (ServerException ex) {
                    throw ex;
                }
            }
        }
    }

    @Override
    public Revendedor recUltimoRevendedorCadastrado() throws ServerException {

        try {
            //ABRIR SESSAO
            HibernateUtil.setSession();
            return revendedorDao.recUltimoRevendedorCadastrado();

        } catch (ServerException ex) {
            throw new ServerException(ex);
        } catch (Exception exGenerica) {
            throw new ServerException(exGenerica);
        } finally {
            //FECHAR SESSAO
            HibernateUtil.getSession().close();
        }
    }

    @Override
    public int recCodigoSequencial() throws ServerException {
        try {
            //ABRIR SESSAO
            HibernateUtil.setSession();

            return revendedorDao.recCodigoSequencial();

        } catch (ServerException ex) {
            throw ex;
        } catch (Exception exGenerica) {
            throw new ServerException(exGenerica);
        } finally {
            //FECHAR SESSAO
            HibernateUtil.getSession().close();
        }
    }

    @Override
    public List recRevendedor(Revendedor revendedor) throws ServerException {
        try {
            //Abrir Sessao
            HibernateUtil.setSession();

            //Chamada metodo consulta
            return this.revendedorDao.recRevendedor(revendedor);

        } catch (ServerException ex) {
            throw ex;
        } catch (Exception exGenerica) {
            throw new ServerException(exGenerica);
        } finally {
            HibernateUtil.getSession().close();
        }
    }

    /**
     * Atualiza dados de Crédito do Revendedor passando um pedido
     * Lógica usada depois que um revendedor faz um pedido
     * @param pedido
     * @throws ServerException 
     */
    @Override
    public void atualizaDadosCreditoRevendedor(PedidoVenda pedido) throws ServerException {

        try {
            //Seta Revendedor
            Revendedor revendedor = pedido.getRevendedor();

            //Atualizar Limite Utilizavel
            // float valorALiberar = calculaValorALiberar(revendedor);

            //Atualiza Limite Utilizavel
            float limiteUtilizavel = revendedor.getLimiteUtilizavel() - pedido.getPagamento().getValor();
            //limiteUtilizavel = +valorALiberar;

            //Atualiza Limite em Uso
            float limiteEmUso = revendedor.getLimiteCredito() - limiteUtilizavel;

            //ATUALIZA DADOS EM REVENDEDOR
            revendedor.setLimiteUtilizavel(limiteUtilizavel);
            revendedor.setLimiteEmUso(limiteEmUso);

            //Abrir Sessao
            HibernateUtil.setSession();

            //Abrir Transacao
            HibernateUtil.setTransacao();
            
            //Chamada do Server
            this.revendedorDao.mantemRevendedor(revendedor);

            //Commit
            HibernateUtil.getTransacao().commit();

            //Log
            LogUtil.logSucesso(Revendedor.class, "atualizaDadosCreditoRevendedor");
        } catch (ServerException ex) {
            HibernateUtil.getTransacao().rollback();
            LogUtil.logDescricaoErro(Revendedor.class, "ERRO AO ATUALIZAR DADOS DE CREDITO REVENDEDOR", ex);
            throw ex;
        } catch (Exception exGenerica) {
            HibernateUtil.getTransacao().rollback();
            LogUtil.logDescricaoErro(Revendedor.class, "ERRO AO ATUALIZAR DADOS DE CREDITO REVENDEDOR", exGenerica);
            throw new ServerException(exGenerica);
        } finally {
            HibernateUtil.getSession().close();
            LogUtil.logFimProcessoMetodo(Revendedor.class, "atualizaDadosCreditoRevendedor");
        }
    }

    /**
     * LOGICA PARA CALCULAR O VALOR A LIBERAR SE EXISTIR DE ACORDO COM OS
     * PEDIDOS CADASTRADOS E COM A DATA ATUAL
     * @param revendedor
     * @return 
     */
    public float calculaValorALiberar(Revendedor revendedor) throws ServerException {

        float valorALiberar = 0;
        try {
            //consultar todas as parcelas do revendedor que estão pendentes
            //e que a datavencimento é menor ou igual a data atual
            ParcelaBoImpl parcelaBo = new ParcelaBoImpl();
            ParcelaDaoImpl parcelaDao = new ParcelaDaoImpl();
            parcelaBo.setParcelaDao(parcelaDao);
            List<Parcela> lstParcelas = parcelaBo.recParcelasALiberar(revendedor.getId());

            if (lstParcelas != null
                    && lstParcelas.size() > 0) {
                for (Parcela parcela : lstParcelas) {
                    valorALiberar += parcela.getValor();
                }

                //alterar status das parcelas
                quitarParcela(lstParcelas);
            }

        } catch (ServerException ex) {
            throw ex;
        }

        return valorALiberar;
    }

    /**
     * METODO PARA ALTERAR STATUS DAS PARCELAS PARA QUITADA
     * @param parcela
     * @throws ServerException 
     */
    private void quitarParcela(List<Parcela> lstParcelas) throws ServerException {
        try {
            ParcelaBoImpl parcelaBo = new ParcelaBoImpl();
            ParcelaDaoImpl parcelaDao = new ParcelaDaoImpl();
            parcelaBo.setParcelaDao(parcelaDao);
            parcelaBo.quitarParcelas(lstParcelas);
        } catch (ServerException ex) {
            throw ex;
        }
    }

    /**
     * Metodo usado toda vez que o usuario acessar a tela de cadastro do Revendedor
     * Deixa os dados de Credito atualizados.
     * @param revendedor
     * @throws ServerException 
     */
    @Override
    public void atualizaDadosCreditoRevendedor(Revendedor revendedor) throws ServerException {
        try {

            //Atualizar Limite Utilizavel
            float valorALiberar = calculaValorALiberar(revendedor);

            if (valorALiberar > 0) {
                //Atualiza Limite Utilizavel
                float limiteUtilizavel = revendedor.getLimiteUtilizavel();
                limiteUtilizavel +=valorALiberar;

                //Atualiza Limite em Uso
                float limiteEmUso = revendedor.getLimiteCredito() - limiteUtilizavel;

                //ATUALIZA DADOS EM REVENDEDOR
                revendedor.setLimiteUtilizavel(limiteUtilizavel);
                revendedor.setLimiteEmUso(limiteEmUso);

                //Abrir Sessao
                HibernateUtil.setSession();

                //Abrir Transacao
                HibernateUtil.setTransacao();

                //Chamada do Server
                this.revendedorDao.mantemRevendedor(revendedor);

                //Commit
                HibernateUtil.getTransacao().commit();

                //Log
                LogUtil.logSucesso(Revendedor.class, "atualizaDadosCreditoRevendedor");
            }
        } catch (ServerException ex) {
            HibernateUtil.getTransacao().rollback();
            LogUtil.logDescricaoErro(Revendedor.class, "ERRO AO ATUALIZAR DADOS DE CREDITO REVENDEDOR", ex);
            throw ex;
        } catch (Exception exGenerica) {
            HibernateUtil.getTransacao().rollback();
            LogUtil.logDescricaoErro(Revendedor.class, "ERRO AO ATUALIZAR DADOS DE CREDITO REVENDEDOR", exGenerica);
            throw new ServerException(exGenerica);
        } finally {
            if (HibernateUtil.getSession().isOpen()) {
                HibernateUtil.getSession().close();
            }
            LogUtil.logFimProcessoMetodo(Revendedor.class, "atualizaDadosCreditoRevendedor");
        }
    }

    /**
     * Altera situação do revendedor seguindo a seguinte regra:
     * Caso a data da última compra for superior a 6 meses o cliente tornasse 
     * automaticamente inativo
     * @param revendedor
     * @throws ServerException 
     */
    @Override
    public void atualizaSituacaoRevendedor(Revendedor revendedor) throws ServerException {
        try
        {
            //instancia pedido
            PedidoBoImpl pedidoBo = new PedidoBoImpl();
            PedidoDaoImpl pedidoDao = new PedidoDaoImpl();
            pedidoBo.setPedidoDao(pedidoDao);
            
            //recupera ultimo pedido venda do fornecedor
            PedidoVenda pv = pedidoBo.recUltimoPedidoVenda(revendedor);
            
            //lógica para atualizar situacao do revendedor
            if (pv != null)
            {
                Calendar calendar = Calendar.getInstance();       
                calendar.add(Calendar.MONTH, -6);                
                
                if (pv.getDataPedido().getTime() < calendar.getTimeInMillis())
                {
                    revendedor.setSituacao(Enum_Situacao.INATIVO.getCodigo());
                    this.mantemRevendedor(revendedor, null, null, null);
                }
            }
            
        }catch(ServerException ex)
        {
            throw ex;
        }
    }

    @Override
    public List<Pessoa> recRevendedorEtiqueta(HashMap parameter) throws ServerException {
        //Abrir Sessao
        HibernateUtil.setSession();

        //Chamada metodo consulta
        return this.revendedorDao.recRevendedorEtiqueta(parameter);
    }
    
    @Override
    public List<Revendedor> recRevendedorPorCPF(String cpf) throws ServerException {

        //ABRIR LOG
        LogUtil.logInicioProcessoMetodo(Revendedor.class, "recPessoaPorCPF");

        List<Revendedor> lstRevendedor = null;
        try {

            //ABRIR SESSAO
            HibernateUtil.setSession();

            //CONSULTA
            lstRevendedor = revendedorDao.recRevendedorPorCPF(cpf);

            //LOG
            LogUtil.logSucesso(Revendedor.class, "recPessoaPorCPF");
        } catch (ServerException ex) {
            //LOG
            LogUtil.logDescricaoErro(Revendedor.class, "ERRO AO CONSULTAR CPF", ex);
            throw ex;
        } catch (Exception exGenerica) {
            //LOG
            LogUtil.logDescricaoErro(Revendedor.class, "ERRO AO CONSULTAR CPF", exGenerica);
            throw new ServerException(exGenerica);
        } finally {
            //FECHAR SESSAO            
            HibernateUtil.getSession().close();
            //FECHA LOG
            LogUtil.logFimProcessoMetodo(RevendedorBoImpl.class, "recPessoaPorCPF");
        }
        return lstRevendedor;
    }
}
