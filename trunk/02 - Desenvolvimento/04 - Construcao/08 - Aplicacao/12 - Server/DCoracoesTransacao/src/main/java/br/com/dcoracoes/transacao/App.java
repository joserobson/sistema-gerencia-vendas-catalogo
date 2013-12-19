package br.com.dcoracoes.transacao;

import br.com.dcoracoes.server.enuns.Enum_EstadoCivil;
import br.com.dcoracoes.server.enuns.Enum_Forma_Pagamento;
import br.com.dcoracoes.server.enuns.Enum_Situacao;
import br.com.dcoracoes.server.enuns.Enum_Situacao_Alerta;
import br.com.dcoracoes.server.enuns.Enum_TipoTelefone;
import br.com.dcoracoes.server.enuns.Enum_Tipo_Codigo;
import br.com.dcoracoes.server.model.cadastro.Email;
import br.com.dcoracoes.server.model.cadastro.Endereco;
import br.com.dcoracoes.server.model.cadastro.Pessoa;
import br.com.dcoracoes.server.model.cadastro.PessoaFisica;
import br.com.dcoracoes.server.model.cadastro.Revendedor;
import br.com.dcoracoes.server.model.cadastro.Telefone;
import br.com.dcoracoes.server.model.canalacesso.Usuario;
import br.com.dcoracoes.server.model.movimento.ContaCorrente;
import br.com.dcoracoes.server.model.pedido.CodigoItem;
import br.com.dcoracoes.server.model.pedido.ItemPedido;
import br.com.dcoracoes.server.model.pedido.Pagamento;
import br.com.dcoracoes.server.model.pedido.Pedido;
import br.com.dcoracoes.server.model.pedido.PedidoCompra;
import br.com.dcoracoes.server.model.pedido.PedidoVenda;
import br.com.dcoracoes.server.model.produto.Cor;
import br.com.dcoracoes.server.model.produto.Fornecedor;
import br.com.dcoracoes.server.model.produto.ItemProduto;
import br.com.dcoracoes.server.model.produto.Produto;
import br.com.dcoracoes.server.model.prospeccao.Alerta;
import br.com.dcoracoes.server.util.HibernateUtil;
import br.com.dcoracoes.transacao.classes.TnAlerta;
import br.com.dcoracoes.transacao.classes.TnPedido;
import br.com.dcoracoes.transacao.classes.TnProduto;
import br.com.dcoracoes.transacao.classes.TnRevendedor;
import br.com.dcoracoes.transacao.classes.view.ViewInfComplementaresRevendedor;
import br.com.dcoracoes.transacao.classes.view.ViewRevendedor;
import br.com.dcoracoes.transacao.constantes.ConstanteTnPedido;
import br.com.dcoracoes.transacao.constantes.ConstanteTnProduto;
import br.com.dcoracoes.transacao.excecao.TransException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws TransException {

//        testeRevendedor();
//        testeInserirProduto();
//        testeAlertas();
        testeConsultaRevendedor();
//        testeConsultaProduto();
//        testeConsultaPedido();
//        TestePedidoPrazo();
//        testePedidoVista();
//        testeCodigoOrcamento();
        // testePedidoCompra();
        //testeConsultarPedidoVenda();
    }

    public static void testeRevendedor() {
        //PESSOA ASSOCIANTE
        PessoaFisica pessoa = new PessoaFisica();
        pessoa.setNome("ANA");
        pessoa.setEstadoCivil(Enum_EstadoCivil.CASADO.getCodigo());

        Endereco end = new Endereco();
        end.setCep("123");
        end.setCidade("BH");
        end.setComplemento("123");
        end.setEstado("MG");
        end.setNumero("23");
        end.setRua("123");
        end.setPessoa(pessoa);
        pessoa.setEndereco(end);

        Email email = new Email();
        email.setEnderecoEmail("robsbq@hotmail.com");
        email.setPessoa(pessoa);
        List<Email> lstEmail = new ArrayList<Email>();
        lstEmail.add(email);
        pessoa.setEmails(lstEmail);

        Telefone tel = new Telefone();
        tel.setPessoa(pessoa);
        tel.setNumero("33541368");
        tel.setOperadora("Claro");
        tel.setTipoTelefone(Enum_TipoTelefone.CELULAR.getCodigo());
        List<Telefone> lstTel = new ArrayList<Telefone>();
        lstTel.add(tel);
        pessoa.setTelefones(lstTel);

        //REVENDEDOR
        Revendedor rev = new Revendedor();
        rev.setCodigo(123);
        rev.setCodigoConFiscal("123");
        rev.setDataCadastro(Calendar.getInstance().getTime());
        rev.setDataUltimaCompra(Calendar.getInstance().getTime());
        rev.setLimiteCredito(12);
        rev.setLimiteEmUso(11);
        rev.setLimiteUtilizavel(Float.valueOf("12.34"));
        rev.setNumeroNotaFiscal("23");
        rev.setObservacoes("12312312");
        rev.setSituacao(Enum_Situacao.ATIVO.getCodigo());
        rev.setPessoa(pessoa);

        //CONJUGUE - PESSOA ASSOCIADA
        PessoaFisica pessoaConjugue = new PessoaFisica();
        pessoaConjugue.setNome("ROBSON");
        pessoaConjugue.setEstadoCivil(Enum_EstadoCivil.DIVORCIADO.getCodigo());

        Endereco end1 = new Endereco();
        end1.setCep("123");
        end1.setCidade("BH");
        end1.setComplemento("123");
        end1.setEstado("1");
        end1.setNumero("23");
        end1.setRua("123");
        end1.setPessoa(pessoaConjugue);
        pessoaConjugue.setEndereco(end1);

        Email email1 = new Email();
        email1.setEnderecoEmail("robsbq@hotmail.com");
        email1.setPessoa(pessoaConjugue);
        List<Email> lstEmail1 = new ArrayList<Email>();
        lstEmail1.add(email1);
        pessoaConjugue.setEmails(lstEmail1);

        Telefone tel1 = new Telefone();
        tel1.setPessoa(pessoaConjugue);
        tel1.setNumero("33541368");
        tel1.setOperadora("Claro");
        tel1.setTipoTelefone(Enum_TipoTelefone.CELULAR.getCodigo());
        List<Telefone> lstTel1 = new ArrayList<Telefone>();
        lstTel1.add(tel1);
        pessoaConjugue.setTelefones(lstTel1);

        ViewRevendedor view = new ViewRevendedor();
        view.setRevendedor(rev);
        view.setConjugue(pessoaConjugue);

        ContaCorrente conta = new ContaCorrente();
        conta.setAgencia("2522-5");
        conta.setBanco("1234");
        conta.setNumero("100202-x");

        //PrimeiroTitular
        PessoaFisica pessoaTitular = new PessoaFisica();
        pessoaTitular.setNome("LUCAS");
        pessoaTitular.setEndereco(end1);
        pessoaTitular.setTelefones(lstTel);

        ViewInfComplementaresRevendedor viewInfo = new ViewInfComplementaresRevendedor();
        viewInfo.setContaBancaria(conta);
        viewInfo.setPrimeiroTitular(pessoaConjugue);
        viewInfo.setSegundoTitular(pessoaTitular);
        viewInfo.setGrauParentescoPrimeiroTitular("-1");
        viewInfo.setGraulParentescoSegundoTitular("IRMAO");
        List<ViewInfComplementaresRevendedor> lstViewInfo = new ArrayList<ViewInfComplementaresRevendedor>();
        lstViewInfo.add(viewInfo);
        view.setLstInformacoesComplementares(lstViewInfo);

        TnRevendedor tnRevendedor = new TnRevendedor();
        tnRevendedor.setViewRevendedor(view);
        try {
            tnRevendedor.salvar("SALVAR_REVENDEDOR");
        } catch (Exception ex) {
            String erro = ex.getMessage();
        }

        // try {
        //   TnRevendedor tn = new TnRevendedor();
        //  tn.recUltimoRevendedorCadastrado();
        //} catch (TransException ex) {
        //}

        //ViewRevendedor resp = tn.getViewRevendedor();
        //Revendedor rev = tn.getRevendedor();
        //PessoaFisica conjugue = tn.getConjuge();
        //List<AssociaPessoaConta> lst = tn.getLstAssociaPessoaConta();
    }

    public static void testeAlertas() {
        TnAlerta tn = new TnAlerta();
        try {
            //String protocolo = tn.gerarNumeroProtocolo();
            Alerta alerta = new Alerta();
            alerta.setDataAlerta(Calendar.getInstance().getTime());

            alerta.setAssunto("123");
            alerta.setProtocolo("123");

            Usuario usu = new Usuario();
            Pessoa pUsu = new Pessoa();
            pUsu.setNome("23");
            usu.setPessoa(pUsu);
            alerta.setAtendente(usu);

            Pessoa p = new Pessoa();
            p.setNome("asd");
            alerta.setPessoa(p);

            alerta.setSituacaoAlerta(Enum_Situacao_Alerta.EMABERTO.getCodigo());

            List<Alerta> lst = tn.recListaAlertas(alerta);

            if (lst != null) {
            }
        } catch (TransException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void testeConsultaRevendedor() {
        try {
            Revendedor rev = new Revendedor();
            rev.setCodigo(123);
            PessoaFisica pf = new PessoaFisica();
            pf.setNome("A");
            rev.setPessoa(pf);
            //pf.setCpf("123");

            TnRevendedor tn = new TnRevendedor();
            List<ViewRevendedor> lst = tn.recListaViewRevendedor(rev);

            if (lst != null
                    && lst.size() > 0) {
            }

        } catch (TransException ex) {
        }
    }

    private static void testeConsultaProduto() {
        try {
            TnProduto tn = new TnProduto();
            Produto p = new Produto();
            p.setDescricao("ti");
            List<Produto> lst = tn.recProdutos(p, true);
        } catch (TransException ex) {
        }
    }

    public static void testeConsultaPedido() {
        try {
            TnPedido tn = new TnPedido();
//           // Pedido p = new Pedido();
            //p.setCodigo("0001");
            //tn.recPedidos(p);
            tn.recCodigoOrcamento();
        } catch (TransException ex) {
        }
    }

    public static void testeInserirProduto() {
        Produto p = new Produto();
        p.setCodigoBarra("123");
        p.setCodigoForFiscal("123");
        p.setCodigoProFiscal("123");
        p.setDescricao("Teste");
        p.setEstoqueTotal(1);

        Fornecedor f = new Fornecedor();
        f.setCodigo("12");
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("teste Fornecedor");
        f.setPessoa(pessoa);
        p.setFornecedor(f);

        p.setReferenciaCatalogo("1233");

        //ItemProduto
        ItemProduto item = new ItemProduto();
        item.setEstoqueAtual(1);
        item.setEstoqueMinimo(2);

        Cor cor = new Cor();
        cor.setDescricao("Azul");
        cor.setCodigo("12");
        item.setCor(cor);

        List<ItemProduto> lst = new ArrayList<ItemProduto>();
        lst.add(item);
        p.setListaItensProduto(lst);

        try {
            TnProduto tn = new TnProduto(p);
            tn.salvar(ConstanteTnProduto.NOME_EVENTO_SALVAR_PRODUTO);
        } catch (TransException ex) {
        }
    }

    public static void TestePedidoPrazo() {
        try {
            PedidoVenda pVenda = new PedidoVenda();
            pVenda.setCodigo("12");
            pVenda.setDataPedido(Calendar.getInstance().getTime());
            pVenda.setSubTotal(100);
            pVenda.setTotal(75);
            pVenda.setValorPedidoEscrito(75);

            Pagamento pag = new Pagamento();
            pag.setFormaPagamento(Enum_Forma_Pagamento.APRAZO.getCodigo());
            pag.setValor(pVenda.getTotal());
            pVenda.setPagamento(pag);

            TnRevendedor tnRevendedor = new TnRevendedor();
            tnRevendedor.recUltimoRevendedorCadastrado();
            pVenda.setRevendedor(tnRevendedor.getViewRevendedor().getRevendedor());

            ItemPedido itemPedido = new ItemPedido();

            CodigoItem cod = new CodigoItem();
            cod.setCodigo("12");
            cod.setTipo(Enum_Tipo_Codigo.REFERENCIA_CATALOGO.getCodigo());
            itemPedido.setCodigo(cod);
            itemPedido.setCor("12");
            itemPedido.setDescricao("Azul");
            itemPedido.setQuantidade(1);
            itemPedido.setValorUnitario(100);
            itemPedido.setIdItemProduto(1);

            List<ItemPedido> lstItens = new ArrayList<ItemPedido>();
            lstItens.add(itemPedido);

            pVenda.setListaItensPedido(lstItens);


            TnPedido tn = new TnPedido(pVenda);
            if (tn.aprovarPedido(ConstanteTnPedido.NOME_EVENTO_APROVAR_PEDIDO)) {
                tn.salvar(ConstanteTnPedido.NOME_EVENTO_SALVAR_PEDIDO);
            }

        } catch (TransException ex) {
        }

    }

    public static void testePedidoVista() {
        try {
            PedidoVenda pVenda = new PedidoVenda();
            pVenda.setCodigo("12");
            pVenda.setDataPedido(Calendar.getInstance().getTime());
            pVenda.setSubTotal(100);
            pVenda.setTotal(75);
            pVenda.setValorPedidoEscrito(75);

            Pagamento pag = new Pagamento();
            pag.setFormaPagamento(Enum_Forma_Pagamento.AVISTA.getCodigo());
            pag.setValor(pVenda.getTotal());
            pVenda.setPagamento(pag);

            TnRevendedor tnRevendedor = new TnRevendedor();
            tnRevendedor.recUltimoRevendedorCadastrado();
            pVenda.setRevendedor(tnRevendedor.getViewRevendedor().getRevendedor());

            ItemPedido itemPedido = new ItemPedido();

            CodigoItem cod = new CodigoItem();
            cod.setCodigo("12");
            cod.setTipo(Enum_Tipo_Codigo.REFERENCIA_CATALOGO.getCodigo());
            itemPedido.setCodigo(cod);
            itemPedido.setCor("12");
            itemPedido.setDescricao("Azul");
            itemPedido.setQuantidade(1);
            itemPedido.setValorUnitario(100);
            itemPedido.setIdItemProduto(1);

            List<ItemPedido> lstItens = new ArrayList<ItemPedido>();
            lstItens.add(itemPedido);

            pVenda.setListaItensPedido(lstItens);


            TnPedido tn = new TnPedido(pVenda);
            if (tn.aprovarPedido(ConstanteTnPedido.NOME_EVENTO_APROVAR_PEDIDO)) {
                tn.salvar(ConstanteTnPedido.NOME_EVENTO_SALVAR_PEDIDO);
            }

        } catch (TransException ex) {
        }
    }

    private static void testeCodigoOrcamento() {
        try {

            TnPedido tn = new TnPedido();
            String codigo = tn.recCodigoOrcamento();
        } catch (TransException ex) {
        }
    }

    private static void testePedidoCompra() {
        try {
            PedidoCompra pedido = new PedidoCompra();
            pedido.setCodigo("14");
            pedido.setDataPedido(Calendar.getInstance().getTime());
            pedido.setSubTotal(50);
            pedido.setDescontoDinheiro(10);
            pedido.setDescontoPorcentagem(10);
            pedido.setTotal(45);

            ItemPedido itemPedido = new ItemPedido();

            CodigoItem cod = new CodigoItem();
            cod.setCodigo("12");
            cod.setTipo(Enum_Tipo_Codigo.REFERENCIA_CATALOGO.getCodigo());
            itemPedido.setCodigo(cod);
            itemPedido.setCor("12");
            itemPedido.setDescricao("Azul");
            itemPedido.setQuantidade(1);
            itemPedido.setValorUnitario(100);
            itemPedido.setIdItemProduto(1);

            CodigoItem cod1 = new CodigoItem();
            cod1.setCodigo("13");
            cod1.setTipo(Enum_Tipo_Codigo.CODIGO_PROFISCAL.getCodigo());
            ItemPedido item1 = new ItemPedido();
            item1.setCodigo(cod1);
            item1.setCor("13");
            item1.setDescricao("Vermelho");
            item1.setQuantidade(1);
            item1.setValorUnitario(100);
            item1.setIdItemProduto(1);

            List<ItemPedido> lstItens = new ArrayList<ItemPedido>();
            lstItens.add(itemPedido);
            lstItens.add(item1);

            pedido.setListaItensPedido(lstItens);

            HibernateUtil.setSession();
            Fornecedor f = (Fornecedor) HibernateUtil.getSession().get(Fornecedor.class, Long.valueOf(1));
            HibernateUtil.getSession().close();
            pedido.setFornecedor(f);

            TnPedido tn = new TnPedido(pedido);
            tn.salvar(ConstanteTnPedido.NOME_EVENTO_SALVAR_PEDIDO);

        } catch (TransException ex) {
        }
    }

    private static void testeConsultarPedidoVenda() {
        try {
            PedidoVenda pedido = new PedidoVenda();
            TnPedido tn = new TnPedido(pedido);
            List<PedidoVenda> lst = tn.recPedidosVenda(pedido);
        } catch (TransException ex) {
        }
    }
}
