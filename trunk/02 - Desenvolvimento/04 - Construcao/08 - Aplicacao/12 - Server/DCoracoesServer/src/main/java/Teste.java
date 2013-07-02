
import br.com.dcoracoes.server.bo.canalacesso.AssociaPerfilPermissaoBo;
import br.com.dcoracoes.server.bo.canalacesso.AssociaPerfilPermissaoBoImpl;
import br.com.dcoracoes.server.bo.canalacesso.PerfilBoImpl;
import br.com.dcoracoes.server.bo.produto.ProdutoBoImpl;
import br.com.dcoracoes.server.dao.canalacesso.AssociaPerfilPermissaoDaoImpl;
import br.com.dcoracoes.server.dao.canalacesso.PerfilDaoImpl;
import br.com.dcoracoes.server.dao.produto.ProdutoDaoImpl;
import br.com.dcoracoes.server.enuns.Enum_EstadoCivil;
import br.com.dcoracoes.server.enuns.Enum_Situacao;
import br.com.dcoracoes.server.enuns.Enum_TipoTelefone;
import br.com.dcoracoes.server.enuns.Enum_Titularidade;
import br.com.dcoracoes.server.excecao.ServerException;
import br.com.dcoracoes.server.model.cadastro.AssociaPessoa;
import br.com.dcoracoes.server.model.cadastro.AssociaPessoaFK;
import br.com.dcoracoes.server.model.cadastro.Email;
import br.com.dcoracoes.server.model.cadastro.Endereco;
import br.com.dcoracoes.server.model.cadastro.Pessoa;
import br.com.dcoracoes.server.model.cadastro.PessoaFisica;
import br.com.dcoracoes.server.model.cadastro.Revendedor;
import br.com.dcoracoes.server.model.cadastro.Telefone;
import br.com.dcoracoes.server.model.canalacesso.AssociaPerfilPermissao;
import br.com.dcoracoes.server.model.canalacesso.Perfil;
import br.com.dcoracoes.server.model.movimento.AssociaPessoaConta;
import br.com.dcoracoes.server.model.movimento.AssociaPessoaContaFK;
import br.com.dcoracoes.server.model.movimento.ContaCorrente;
import br.com.dcoracoes.server.model.produto.Cor;
import br.com.dcoracoes.server.model.produto.Fornecedor;
import br.com.dcoracoes.server.model.produto.ItemProduto;
import br.com.dcoracoes.server.model.produto.Produto;
import br.com.dcoracoes.server.util.HibernateUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Robson
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // testeInserirPessoa();
       // testeAssociacaoPessoa();
       //testeInserirContaCorrente();

       // associaPessoaConta();
        //testeRevendedor();
       //testeInserirProduto();
      //recPermissoesPorPerfil();
       
    }

    public static void testeInserirPessoa() {
        Session sessao = null;
        Transaction transacao = null;

        try {
            PessoaFisica pessoa = new PessoaFisica();
            pessoa.setNome("Cleberson");
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

            sessao = HibernateUtil.getSession();
            transacao = sessao.beginTransaction();
            sessao.saveOrUpdate(pessoa);
            transacao.commit();


        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            transacao.rollback();
        } finally {
            sessao.close();

        }
    }

    public static void testeAssociacaoPessoa() {
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = HibernateUtil.getSession();
            transacao = sessao.beginTransaction();
            PessoaFisica p1 = (PessoaFisica) sessao.get(PessoaFisica.class, Long.valueOf(2));
            PessoaFisica p2 = (PessoaFisica) sessao.get(PessoaFisica.class, Long.valueOf(3));

            AssociaPessoaFK fk = new AssociaPessoaFK();
            fk.setPessoaAssociada(p1);
            fk.setPessoaAssociante(p2);

            AssociaPessoa ap = new AssociaPessoa();
            ap.setChaveComposta(fk);
            ap.setGrauParentesco("Irmao");

            sessao.save(ap);
            transacao.commit();

        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, ex.getMessage());

            transacao.rollback();

        } finally {
            sessao.close();
        }

    }

    public static void testeInserirContaCorrente() {
        Session sessao = null;
        Transaction transacao = null;

        try {
            ContaCorrente conta = new ContaCorrente();
            conta.setAgencia("2522-5");
            conta.setBanco("1234");
            conta.setNumero("100202-x");

            sessao = HibernateUtil.getSession();
            transacao = sessao.beginTransaction();
            sessao.saveOrUpdate(conta);
            transacao.commit();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            transacao.rollback();
        } finally {
            sessao.close();
        }
    }

    public static void associaPessoaConta() {
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = HibernateUtil.getSession();
            transacao = sessao.beginTransaction();
            PessoaFisica p1 = (PessoaFisica) sessao.get(PessoaFisica.class, Long.valueOf(2));
            ContaCorrente c1 = (ContaCorrente) sessao.get(ContaCorrente.class, Long.valueOf(1));

            AssociaPessoaContaFK fk = new AssociaPessoaContaFK();
            fk.setPessoa(p1);
            fk.setConta(c1);

            AssociaPessoaConta ap = new AssociaPessoaConta();
            ap.setAssociaPessoaFK(fk);
            ap.setTitularidade(Enum_Titularidade.SEGUNDO.getCodigo());

            sessao.save(ap);
            transacao.commit();

        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, ex.getMessage());

            transacao.rollback();

        } finally {
            sessao.close();
        }
    }

    public static void testeRevendedor()
    {
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = HibernateUtil.getSession();
            transacao = sessao.beginTransaction();
            PessoaFisica p1 = (PessoaFisica) sessao.get(PessoaFisica.class, Long.valueOf(2));
            Revendedor rev = (Revendedor)sessao.get(Revendedor.class, Long.valueOf(1));

            //Revendedor rev = new Revendedor();
            rev.setCodigo(123);
            rev.setCodigoConFiscal("123");
            rev.setDataCadastro(Calendar.getInstance().getTime());
            rev.setDataUltimaCompra(Calendar.getInstance().getTime());
            rev.setLimiteCredito(12);
            rev.setLimiteEmUso(11);
            rev.setLimiteUtilizavel(Float.valueOf("12.34"));
            rev.setNumeroNotaFiscal("23");
            rev.setObservacoes("12312312");
            rev.setPessoa(p1);
            rev.setSituacao(Enum_Situacao.ATIVO.getCodigo());

            sessao.save(rev);
            transacao.commit();

        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, ex.getMessage());

            transacao.rollback();

        } finally {
            sessao.close();
        }
    }
    
    
    public static void testeInserirProduto()
    {
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
        
        try
        {
            ProdutoBoImpl produtoBo = new ProdutoBoImpl();
            ProdutoDaoImpl produtoDao = new ProdutoDaoImpl();
            produtoBo.setProdutoDao(produtoDao);
            produtoBo.mantemProduto(p);
        }catch(ServerException ex)
        {
            
        }
    }

    private static void recPermissoesPorPerfil() {
        
        Perfil p = new Perfil();
        p.setId(Long.valueOf(1));
        
        AssociaPerfilPermissaoBoImpl associaBo = new AssociaPerfilPermissaoBoImpl();
        AssociaPerfilPermissaoDaoImpl associaDao = new AssociaPerfilPermissaoDaoImpl();
        associaBo.setDao(associaDao);
            
        List<AssociaPerfilPermissao> lst = null;
        try
        {
            lst = associaBo.recPermissoesPorPerfil(p);
        }catch(ServerException ex)
        {
            System.console().writer().append(ex.getMessage());
        }
        
    }
}
