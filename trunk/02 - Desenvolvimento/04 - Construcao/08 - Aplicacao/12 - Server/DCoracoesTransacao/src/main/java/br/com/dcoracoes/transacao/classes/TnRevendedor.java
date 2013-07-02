/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.transacao.classes;

import br.com.dcoracoes.server.bo.cadastro.AssociaPessoaBoImpl;
import br.com.dcoracoes.server.bo.cadastro.PessoaBoImpl;
import br.com.dcoracoes.server.bo.cadastro.RevendedorBo;
import br.com.dcoracoes.server.bo.cadastro.RevendedorBoImpl;
import br.com.dcoracoes.server.bo.movimento.AssociaPessoaContaBoImpl;
import br.com.dcoracoes.server.bo.pedido.PedidoBoImpl;
import br.com.dcoracoes.server.enuns.Enum_Titularidade;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.cadastro.*;
import br.com.dcoracoes.server.model.movimento.AssociaPessoaConta;
import br.com.dcoracoes.server.model.movimento.AssociaPessoaContaFK;
import br.com.dcoracoes.server.model.pedido.Pedido;
import br.com.dcoracoes.server.model.pedido.PedidoVenda;
import br.com.dcoracoes.transacao.classes.view.ViewInfComplementaresRevendedor;
import br.com.dcoracoes.transacao.classes.view.ViewRevendedor;
import br.com.dcoracoes.transacao.constantes.ConstanteTnRevendedor;
import br.com.dcoracoes.transacao.excecao.TransException;
import br.com.dcoracoes.transacao.interfaces.InterfaceTransacao;
import br.com.dcoracoes.transacao.util.TransacaoUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Robson
 */
public class TnRevendedor implements InterfaceTransacao {

    /**
     * ATRIBUTOS DA CLASSE
     */
    private ViewRevendedor viewRevendedor;
    
    public TnRevendedor() {
    }

    /**
     * METODOS ACESSORES
     * @return
     */
    public ViewRevendedor getViewRevendedor() {
        return viewRevendedor;
    }
    
    public void setViewRevendedor(ViewRevendedor viewRevendedor) {
        this.viewRevendedor = viewRevendedor;
    }

    /**
     * SALVAR REVENDEDOR
     * @param evento
     * @return
     * @throws TransacaoException
     */
    @Override
    public void salvar(String evento) throws TransException {
        try {
            if (validarDados(evento)) {

                //CONVERTER CLASSE VIEW NAS CLASSE DO SERVER
                Revendedor revendedor = viewRevendedor.getRevendedor();
                PessoaFisica conjuge = viewRevendedor.getConjugue();

                //Acerta Limite Utilizavel quando revendedor cadastrado pelo primeira vez
                if (revendedor.getId() == null) {
                    revendedor.setLimiteUtilizavel(revendedor.getLimiteCredito());
                }
                
                List<AssociaPessoa> lstAssociaPessoaRevendedor = inicializaListaAssociaPessoaRevendedor(viewRevendedor.getLstInformacoesComplementares(), revendedor.getPessoa());
                List<AssociaPessoaConta> lstAssociaPessoaConta = inicializaListaAssociaPessoaConta(viewRevendedor.getLstInformacoesComplementares());

                //INSERIR REVENDEDOR
                RevendedorBoImpl revendedorBo = (RevendedorBoImpl) TransacaoUtil.getInstanceBo(Revendedor.class);
                revendedorBo.mantemRevendedor(revendedor, conjuge, lstAssociaPessoaConta, lstAssociaPessoaRevendedor);
            }
        } catch (ServerException ex) {
            throw new TransException(ex);
        }
        
        
    }

    /**
     * VALIDAR DADOS
     * @param evento
     * @return
     * @throws TransacaoException
     */
    @Override
    public boolean validarDados(String evento) throws TransException {
        
        try {
            if (evento.equals(ConstanteTnRevendedor.NOME_EVENTO_SALVAR_REVENDEDOR)) {
                String cpf = this.validaCPF(this.getViewRevendedor().getRevendedor().getPessoa());
                
                if (cpf != null) {
                        throw new TransException(ConstanteTnRevendedor.MSG_CPF_CADASTRADO);
                }   
            }
            
        } catch (TransException ex) {
            throw ex;
        }
        
        return true;
    }

    /**
     * DELETAR REVENDEDOR
     * @param evento
     * @return
     * @throws TransacaoException
     */
    @Override
    public void deletar(String evento) throws TransException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * RECUPERA ULTIMO REVENDEDOR CADASTRADO
     * @throws TransacaoException
     */
    public void recUltimoRevendedorCadastrado() throws TransException {
        try {
            RevendedorBoImpl revendedorBo = (RevendedorBoImpl) TransacaoUtil.getInstanceBo(Revendedor.class);
            Revendedor revendedorUltCadastrado = revendedorBo.recUltimoRevendedorCadastrado();
            if (revendedorUltCadastrado != null) {
                //Atualiza dados de Crédito do Revendedor
                revendedorBo.atualizaDadosCreditoRevendedor(revendedorUltCadastrado);
                //Monta Objeto
                this.viewRevendedor = montarViewRevendedor(revendedorUltCadastrado);
            }
        } catch (ServerException ex) {
            throw new TransException(ex);
        }
    }

    /**
     * MONTA OBJETO VIEW DE RETORNO PARA REVENDEDOR
     */
    private ViewRevendedor montarViewRevendedor(Revendedor revendedor) throws ServerException {

        //INICIALIZA VIEW REVENDEDOR
        ViewRevendedor viewRev = new ViewRevendedor();

        //SETAR REVENDEDOR NA VIEW
        viewRev.setRevendedor(revendedor);

        //BUSCA PESSOAS ASSOCIADAS A PESSOA DO REVENDEDOR
        List<AssociaPessoa> lstAssociaPessoa = recPessoasAssociadasAoRevendedor(revendedor.getPessoa());

        //PROCURA CONJUGUE
        PessoaFisica conjugueRevendedor = (PessoaFisica) this.procurarConjugue(lstAssociaPessoa);
            if (conjugueRevendedor != null) {
            //SETAR CONJUGUE DA VIEW
            viewRev.setConjugue(conjugueRevendedor);
        }

        //LISTA DE PESSOAS ASSOCIADAS COM CONTA AO REVENDEDOR
        List<AssociaPessoaConta> lstAssociaPessoaContaRevendedor = new ArrayList<AssociaPessoaConta>();

        //PROCURA SE EXISTE CONTA ASSOCIADA A PESSOA DO REVENDEDOR
        AssociaPessoaConta pessoaContaRevendedor = recAssociaPessoaConta(revendedor.getPessoa());
        if (pessoaContaRevendedor != null) {
            lstAssociaPessoaContaRevendedor.add(pessoaContaRevendedor);
        }

        //PROCURA CONTAS ASSOCIADAS AS PESSOAS ASSOCIADAS AO REVENDEDOR
        if (lstAssociaPessoa != null
                && lstAssociaPessoa.size() > 0) {
            for (AssociaPessoa associaPessoa : lstAssociaPessoa) {
                AssociaPessoaConta pessoaConta = recAssociaPessoaConta(associaPessoa.getChaveComposta().getPessoaAssociada());
                if (pessoaConta != null) {
                    lstAssociaPessoaContaRevendedor.add(pessoaConta);
                }
            }

            //SETO LISTA INFORMACOES COMPLEMENTARES DA VIEW
            viewRev.setLstInformacoesComplementares(setarListaViewInformacoesComplemetares(lstAssociaPessoa, lstAssociaPessoaContaRevendedor, revendedor.getPessoa().getId()));
        }
        
        return viewRev;
    }

    /**
     * RECUPERAR PESSOAS ASSOCIADAS AO REVENDEDOR
     * @param pessoa
     * @return
     */
    private List<AssociaPessoa> recPessoasAssociadasAoRevendedor(Pessoa pessoa) throws ServerException {
        try {
            AssociaPessoaBoImpl associaPessoaBo = (AssociaPessoaBoImpl) TransacaoUtil.getInstanceBo(AssociaPessoa.class);
            return associaPessoaBo.recPessoasAssociadas(pessoa);
        } catch (ServerException ex) {
            throw ex;
        }
    }

    /**
     * PROCURA CONJUGUE DO REVENDEDOR
     * @param lstAssociaPessoa
     * @return
     */
    private Pessoa procurarConjugue(List<AssociaPessoa> lstAssociaPessoa) {
        for (AssociaPessoa associaPessoa : lstAssociaPessoa) {
            if (associaPessoa.getGrauParentesco().equals("CONJUGUE")) {
                return associaPessoa.getChaveComposta().getPessoaAssociada();
            }
        }
        
        return null;
    }

    /**
     * RECUPERAR ASSOCIA PESSOA CONTA PASSANDO A PESSOA ASSOCIADA
     * @param pessoaAssociada
     * @return
     */
    private AssociaPessoaConta recAssociaPessoaConta(Pessoa pessoaAssociada) throws ServerException {
        try {
            AssociaPessoaContaBoImpl associaBo = (AssociaPessoaContaBoImpl) TransacaoUtil.getInstanceBo(AssociaPessoaConta.class);
            return associaBo.recAssociaPessoaConta(pessoaAssociada);
        } catch (ServerException ex) {
            throw ex;
        }
    }

    /**
     *INICIALIZA LISTA DE PESSOAS QUE TEM CONTA ASSOCIADA A PESSOA DO REVENDEDOR
     * @param lstInformacoesComplementares
     * @return
     */
    private List<AssociaPessoaConta> inicializaListaAssociaPessoaConta(List<ViewInfComplementaresRevendedor> lstInformacoesComplementares) {
        List<AssociaPessoaConta> lstPessoaConta = new ArrayList<AssociaPessoaConta>();
        
        if (lstInformacoesComplementares != null
                && lstInformacoesComplementares.size() > 0) {
            for (ViewInfComplementaresRevendedor view : lstInformacoesComplementares) {

                //SETA PRIMEIRO TITULAR
                AssociaPessoaConta associaPrimeiroTitular = new AssociaPessoaConta();
                AssociaPessoaContaFK associaFKPrimeiroTitular = new AssociaPessoaContaFK();
                associaFKPrimeiroTitular.setConta(view.getContaBancaria());
                associaFKPrimeiroTitular.setPessoa(view.getPrimeiroTitular());
                associaPrimeiroTitular.setAssociaPessoaFK(associaFKPrimeiroTitular);
                associaPrimeiroTitular.setTitularidade(Enum_Titularidade.PRIMEIRO.getCodigo());
                lstPessoaConta.add(associaPrimeiroTitular);

                //SETA SEGUNDO TITULAR SE EXISTIR
                if (view.getSegundoTitular() != null) {
                    AssociaPessoaConta associaSegundoTitular = new AssociaPessoaConta();
                    AssociaPessoaContaFK associaFKSegundoTitular = new AssociaPessoaContaFK();
                    associaFKSegundoTitular = new AssociaPessoaContaFK();
                    associaFKSegundoTitular.setConta(view.getContaBancaria());
                    associaFKSegundoTitular.setPessoa(view.getSegundoTitular());
                    associaSegundoTitular.setAssociaPessoaFK(associaFKSegundoTitular);
                    associaSegundoTitular.setTitularidade(Enum_Titularidade.SEGUNDO.getCodigo());
                    lstPessoaConta.add(associaSegundoTitular);
                    
                }
                
            }
        }
        
        return lstPessoaConta;
    }

    /**
     * INICIALIZA LISTA DE PESSOAS ASSOCIADAS A PESSOA DO REVENDEDOR
     * @param lstInformacoesComplementares
     * @param pessoaRevendedor
     * @return
     */
    private List<AssociaPessoa> inicializaListaAssociaPessoaRevendedor(List<ViewInfComplementaresRevendedor> lstInformacoesComplementares, Pessoa pessoaRevendedor) {
        List<AssociaPessoa> lstAssociaPessoaRevendedor = new ArrayList<AssociaPessoa>();
        if (lstInformacoesComplementares != null
                && lstInformacoesComplementares.size() > 0) {
            for (ViewInfComplementaresRevendedor view : lstInformacoesComplementares) {
                
                if (!view.getGrauParentescoPrimeiroTitular().equals("-1")) {
                    //ASSOCIA PESSOA PARA PRIMEIRO TITULAR
                    AssociaPessoa associaPessoaPrimTitular = new AssociaPessoa();
                    AssociaPessoaFK associaPessoaFKPrimTitular = new AssociaPessoaFK();
                    associaPessoaFKPrimTitular.setPessoaAssociante(pessoaRevendedor);
                    associaPessoaFKPrimTitular.setPessoaAssociada(view.getPrimeiroTitular());
                    associaPessoaPrimTitular.setChaveComposta(associaPessoaFKPrimTitular);
                    associaPessoaPrimTitular.setGrauParentesco(view.getGrauParentescoPrimeiroTitular());
                    lstAssociaPessoaRevendedor.add(associaPessoaPrimTitular);
                }

                //ASSOCIA PESSOA SEGUNDO TITULAR, SE EXISTIR
                if (view.getSegundoTitular() != null) {
                    if (!view.getGraulParentescoSegundoTitular().equals("-1")) {
                        AssociaPessoa associaPessoaSegTitular = new AssociaPessoa();
                        AssociaPessoaFK associaPessoaFKSegTitular = new AssociaPessoaFK();
                        associaPessoaFKSegTitular.setPessoaAssociante(pessoaRevendedor);
                        associaPessoaFKSegTitular.setPessoaAssociada(view.getSegundoTitular());
                        associaPessoaSegTitular.setChaveComposta(associaPessoaFKSegTitular);
                        associaPessoaSegTitular.setGrauParentesco(view.getGraulParentescoSegundoTitular());
                        lstAssociaPessoaRevendedor.add(associaPessoaSegTitular);
                    }
                }
            }
        }
        return lstAssociaPessoaRevendedor;
    }

    /**
     *
     * @param lstAssociaPessoa
     * @param lstAssociaPessoaconta
     * @return
     */
    private List<ViewInfComplementaresRevendedor> setarListaViewInformacoesComplemetares(List<AssociaPessoa> lstAssociaPessoa, List<AssociaPessoaConta> lstAssociaPessoaconta, Long idPessoaRevendedor) throws ServerException {
        
        List<ViewInfComplementaresRevendedor> lstViewInfoCompl = new ArrayList<ViewInfComplementaresRevendedor>();
        
        for (AssociaPessoaConta itemPessoaConta : lstAssociaPessoaconta) {
            
            ViewInfComplementaresRevendedor viewInfo = new ViewInfComplementaresRevendedor();
            
            if (itemPessoaConta.getTitularidade() == Enum_Titularidade.PRIMEIRO.getCodigo()) {

                //SETA CONTA BANCARIA
                viewInfo.setContaBancaria(itemPessoaConta.getAssociaPessoaFK().getConta());

                //SETA PRIMEIRO TITULAR
                PessoaFisica primeiroTitular = (PessoaFisica) itemPessoaConta.getAssociaPessoaFK().getPessoa();
                
                viewInfo.setPrimeiroTitular(primeiroTitular);

                //PROCURA GRAU PARENTESCO PRIMEIRO TITULAR
                viewInfo.setGrauParentescoPrimeiroTitular(procuraGrauParentesco(lstAssociaPessoa, idPessoaRevendedor, itemPessoaConta.getAssociaPessoaFK().getPessoa()));

                //PROCURAR SEGUNDO TITULAR
                Pessoa segundoTitular = procuraSegundoTitular(lstAssociaPessoaconta, itemPessoaConta.getAssociaPessoaFK().getConta().getId());
                if (segundoTitular != null) {
                    viewInfo.setSegundoTitular(segundoTitular);
                }

                //PROCURA GRAU PARENTESCO SEGUNDO TITULAR SE EXISTE
                if (viewInfo.getSegundoTitular() != null) {
                    viewInfo.setGraulParentescoSegundoTitular(procuraGrauParentesco(lstAssociaPessoa, idPessoaRevendedor, viewInfo.getSegundoTitular()));
                }

                //ADD LISTA
                lstViewInfoCompl.add(viewInfo);
            }
        }
        return lstViewInfoCompl;
        
    }

    /**
     * PROCURA GRAU PARENTESCO SEGUNDO PARAMETROS
     * @param lstAssociaPessoa
     * @param pessoa
     * @return
     */
    private String procuraGrauParentesco(List<AssociaPessoa> lstAssociaPessoa, Long idPessoaRevendedor, Pessoa pessoaAssociada) {
        //PROCURAR PARENTESCO
        for (AssociaPessoa itemPessoa : lstAssociaPessoa) {
            if (itemPessoa.getChaveComposta().getPessoaAssociante().getId().equals(idPessoaRevendedor)
                    && itemPessoa.getChaveComposta().getPessoaAssociada().getId().equals(pessoaAssociada.getId())) {
                return itemPessoa.getGrauParentesco();
            }
        }
        
        return null;
    }

    /**
     * PROCURA SEGUNDO TITULAR
     * @param lstAssociaPessoaconta
     * @param conta
     * @return
     */
    private Pessoa procuraSegundoTitular(List<AssociaPessoaConta> lstAssociaPessoaconta, Long idConta) {
        for (AssociaPessoaConta associaPessoaConta : lstAssociaPessoaconta) {
            if (associaPessoaConta.getAssociaPessoaFK().getConta().getId().equals(idConta)
                    && associaPessoaConta.getTitularidade() == Enum_Titularidade.SEGUNDO.getCodigo()) {
                return associaPessoaConta.getAssociaPessoaFK().getPessoa();
            }
        }
        return null;
    }

    /**
     * RECUPERAR CODIGO SEGUENCIAL PARA REVENDEDOR
     * @return
     * @throws Exception
     */
    public int recCodigoSequencial() throws TransException {
        try {
            RevendedorBoImpl revBo = (RevendedorBoImpl) TransacaoUtil.getInstanceBo(Revendedor.class);
            return revBo.recCodigoSequencial();
        } catch (ServerException ex) {
            throw new TransException(ex);
        }
    }

    /**
     * METODO PARA RECUPERAR UMA LISTA DE VIEWREVENDEDORES
     * METODO MONTA PARAMETROS DINAMICAMENTE
     * @param revendedor
     * @return 
     */
    public List<ViewRevendedor> recListaViewRevendedor(Revendedor revendedor) throws TransException {
        List<ViewRevendedor> retListaRevendedor = null;
        try {
            RevendedorBoImpl revendedorBo = (RevendedorBoImpl) TransacaoUtil.getInstanceBo(Revendedor.class);
            List<Revendedor> lstRevendedores = revendedorBo.recRevendedor(revendedor);
            
            if (lstRevendedores != null) {
                retListaRevendedor = new ArrayList<ViewRevendedor>();
                for (Revendedor rev : lstRevendedores) {

                    //Atualiza dados de Crédito do Revendedor
                    revendedorBo.atualizaDadosCreditoRevendedor(rev);
                    
                    ViewRevendedor view = montarViewRevendedor(rev);
                    if (view != null) {
                        retListaRevendedor.add(view);
                    }
                }
                
            }
            
        } catch (ServerException ex) {
            throw new TransException(ex);
        }
        return retListaRevendedor;
    }

    /**
     * Consulta CPF pela pessoa passada como parametro
     * @param pessoa
     * @return 
     */
    public String validaCPF(Pessoa pessoa) throws TransException {
        
        String retorno = null;
        try 
          {                                                               
            int cont = this.buscaCPF(pessoa);                                    
            
            if (cont > 1)
                return "";
            
            if (pessoa.getId() == null && cont > 0)
                return ""; 
            
            if (pessoa.getId()!= null && cont == 1)
            {
                PessoaFisica p = (PessoaFisica)this.recPessoaPorId(pessoa.getId());
                String cpfAnt = p.getCpf();
                String cpfAtual = ((PessoaFisica) pessoa).getCpf();
                
                if (!cpfAnt.equals(cpfAtual))                
                    return "";
            }
                        
        } catch (TransException ex) {
            throw ex;
        }
        return retorno;
    }

    /**
     * Consulta CPF pela pessoa passada como parametro
     * @param pessoa
     * @return 
     */
    private int buscaCPF(Pessoa pessoa) throws TransException {
        
        int retorno = 0;
        try {
            RevendedorBoImpl bo = (RevendedorBoImpl) TransacaoUtil.getInstanceBo(Revendedor.class);
            String cpf = ((PessoaFisica) pessoa).getCpf();
            List<Revendedor> lst = (List) bo.recRevendedorPorCPF(cpf);
            retorno = lst.size();
            
        } catch (ServerException ex) {
            throw new TransException(ex);
        }
        return retorno;
    }

    /**
     * Metodo para recuperar o último pedido venda do revendedor 
     * @return
     * @throws TransException 
     */
    public PedidoVenda recUltimoPedidoVenda() throws TransException {
        try {
            PedidoBoImpl pedidoBo = (PedidoBoImpl) TransacaoUtil.getInstanceBo(Pedido.class);
            return pedidoBo.recUltimoPedidoVenda(this.viewRevendedor.getRevendedor());
        } catch (ServerException ex) {
            throw new TransException(ex);
        }
    }
    
    public List<Pessoa> recRevendedorEtiqueta(HashMap<String, Object> parameter) throws TransException {
        try {
            RevendedorBo revendedorBo = (RevendedorBoImpl) TransacaoUtil.getInstanceBo(Revendedor.class);
            return revendedorBo.recRevendedorEtiqueta(parameter);
        } catch (ServerException ex) {
            throw new TransException(ex);
        }
    }

    public Pessoa recPessoaPorId(Long id) throws TransException {
        
        Pessoa retorno = null;
        try {
            PessoaBoImpl pessoaBo = (PessoaBoImpl) TransacaoUtil.getInstanceBo(PessoaFisica.class);            
            PessoaFisica pf = (PessoaFisica) pessoaBo.recPessoPorId(id);
            if (pf != null) {
                retorno = pf;
            }
            
        } catch (ServerException ex) {
            throw new TransException(ex);
        }
        return retorno;
    }
}
