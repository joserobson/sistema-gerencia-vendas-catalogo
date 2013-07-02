/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.relatorios;

import br.com.dcoracoes.server.enuns.Enum_Tipo_Codigo;
import br.com.dcoracoes.server.model.cadastro.Endereco;
import br.com.dcoracoes.server.model.cadastro.PessoaFisica;
import br.com.dcoracoes.server.model.cadastro.PessoaJuridica;
import br.com.dcoracoes.server.model.cadastro.Revendedor;
import br.com.dcoracoes.server.model.pedido.CodigoItem;
import br.com.dcoracoes.server.model.pedido.ItemPedido;
import br.com.dcoracoes.server.model.pedido.PedidoCompra;
import br.com.dcoracoes.server.model.pedido.PedidoVenda;
import br.com.dcoracoes.server.model.produto.Fornecedor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Robson
 */
public class testeRelatorio {

    public void exibirRelatorioCompletoVenda() {
        //caminho
        /*String caminho = "/jaspers/relCompletoVenda.jasper";
        
        //lista beans
        List lstRelatorio = getListaRelatorioCompletoVenda();
        
        //stream jasper
        InputStream relJasper = getClass().getResourceAsStream(caminho);
        
        JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(lstRelatorio);
        
        Map mapParametros = new HashMap();
        
        String localPath = System.getProperty("user.dir") + "\\src\\main\\resources\\jaspers\\";
        
        mapParametros.put("SUBREPORT_DIR", localPath);
        
        JasperPrint impressao = null;
        
        try {
        impressao = JasperFillManager.fillReport(relJasper, mapParametros, ds);
        
        //JasperViewer viewer = new JasperViewer(impressao, true);
        //viewer.setVisible(true);
        JasperExportManager.exportReportToPdfFile(impressao, localPath + "teste.pdf");
        } catch (JRException ex) {
        System.out.println(ex.getMessage());
        }*/

        try {
            PedidoVenda pedido = new PedidoVenda();
            pedido.setCodigo("00012");
            pedido.setDataPedido(Calendar.getInstance().getTime());
            pedido.setDescontoDinheiro(Float.valueOf("50.00"));
            pedido.setDescontoPorcentagem(Float.valueOf(10));
            pedido.setSubTotal(Float.valueOf("52.00"));
            pedido.setTotal(Float.valueOf("2000.50"));

            Revendedor rev = new Revendedor();
            rev.setCodigoConFiscal("123123123");
            rev.setNumeroNotaFiscal("123123123123123");
            PessoaFisica p = new PessoaFisica();
            p.setNome("Jose Robson de Assis");
            p.setCpf("065.420.456-00");
            Endereco end = new Endereco();
            end.setCep("36340-000");
            end.setCidade("Resende Costa");
            end.setEstado("MG");
            end.setRua("Rua sete de setembro");
            p.setEndereco(end);
            rev.setPessoa(p);
            pedido.setRevendedor(rev);

            List<ItemPedido> lst = new ArrayList<ItemPedido>();
            for (int i = 0; i < 10; i++) {
                lst.add(addItemPedido());
            }
            pedido.setListaItensPedido(lst);

            GerarRelatorio gerar = new GerarRelatorio();
            gerar.gerarRelatorioCompletoVenda(pedido);

        } catch (JRException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void exibirRelatorioCompletoCompra() {
        //caminho
        /*String caminho = "/jaspers/relCompletoCompra.jasper";
        
        //lista beans
        List lstRelatorio = getListaRelatorioCompletoCompra();
        
        //stream jasper
        InputStream relJasper = getClass().getResourceAsStream(caminho);
        
        JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(lstRelatorio);
        
        Map mapParametros = new HashMap();
        
        String localPath = System.getProperty("user.dir") + "\\src\\main\\resources\\jaspers\\";
        
        mapParametros.put("SUBREPORT_DIR", localPath);
        
        JasperPrint impressao = null;
        
        try {
        impressao = JasperFillManager.fillReport(relJasper, mapParametros, ds);
        
        //JasperViewer viewer = new JasperViewer(impressao, true);
        //viewer.setVisible(true);
        JasperExportManager.exportReportToPdfFile(impressao, localPath + "teste.pdf");
        } catch (JRException ex) {
        System.out.println(ex.getMessage());
        }*/

        try {
            PedidoCompra pedidoCompra = new PedidoCompra();
            pedidoCompra.setCodigo("00012");
            pedidoCompra.setDataPedido(Calendar.getInstance().getTime());
            pedidoCompra.setDescontoDinheiro(Float.valueOf("50.00"));
            pedidoCompra.setDescontoPorcentagem(Float.valueOf(10));
            pedidoCompra.setSubTotal(Float.valueOf("52.00"));
            pedidoCompra.setTotal(Float.valueOf("2000.50"));

            Fornecedor f = new Fornecedor();
            PessoaJuridica p = new PessoaJuridica();
            p.setNome("Loja tau tau tauasssssssssssssssssssssssssssssssssss");
            f.setPessoa(p);
            pedidoCompra.setFornecedor(f);

            List<ItemPedido> lst = new ArrayList<ItemPedido>();
            for (int i = 0; i < 10; i++) {
                lst.add(addItemPedido());
            }
            pedidoCompra.setListaItensPedido(lst);

            GerarRelatorio gerar = new GerarRelatorio();
            gerar.gerarRelatorioCompletoCompra(pedidoCompra);

        } catch (JRException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void exibirRelatorioExpedicao() {
        //caminho
       /* String caminho = "/jaspers/relExpedicao.jasper";
        
        //lista beans
        List lstRelatorio = getListaRelatorioCompletoVenda();
        
        //stream jasper
        InputStream relJasper = getClass().getResourceAsStream(caminho);
        
        JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(lstRelatorio);
        
        Map mapParametros = new HashMap();
        
        String localPath = System.getProperty("user.dir") + "\\src\\main\\resources\\jaspers\\";
        
        mapParametros.put("SUBREPORT_DIR", localPath);
        
        JasperPrint impressao = null;
        
        try {
        impressao = JasperFillManager.fillReport(relJasper, mapParametros, ds);
        
        //JasperViewer viewer = new JasperViewer(impressao, true);
        //viewer.setVisible(true);
        JasperExportManager.exportReportToPdfFile(impressao, localPath + "teste.pdf");
        } catch (JRException ex) {
        System.out.println(ex.getMessage());
        }*/
        try {
            PedidoVenda pedido = new PedidoVenda();
            pedido.setCodigo("00012");
            pedido.setDataPedido(Calendar.getInstance().getTime());
            pedido.setDescontoDinheiro(Float.valueOf("50.00"));
            pedido.setDescontoPorcentagem(Float.valueOf(10));
            pedido.setSubTotal(Float.valueOf("52.00"));
            pedido.setTotal(Float.valueOf("2000.50"));

            Revendedor rev = new Revendedor();
            rev.setCodigoConFiscal("123123123");
            rev.setNumeroNotaFiscal("123123123123123");
            rev.setCodigo(123);
            PessoaFisica p = new PessoaFisica();
            p.setNome("Jose Robson de Assis");
            p.setCpf("065.420.456-00");
            Endereco end = new Endereco();
            end.setCep("36340-000");
            end.setCidade("Resende Costa");
            end.setEstado("MG");
            end.setRua("Rua sete de setembro");
            p.setEndereco(end);
            rev.setPessoa(p);
            pedido.setRevendedor(rev);

            List<ItemPedido> lst = new ArrayList<ItemPedido>();
            for (int i = 0; i < 10; i++) {
                lst.add(addItemPedido());
            }
            pedido.setListaItensPedido(lst);

            GerarRelatorio gerar = new GerarRelatorio();
            gerar.gerarRelatorioExpedicaoVenda(pedido);

        } catch (JRException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public List getListaRelatorioCompletoVenda() {
        RelatorioCompletoVenda relatorio = new RelatorioCompletoVenda();
        relatorio.setCep("123");
        relatorio.setCidadeEstado("Resende Costa / MG");
        relatorio.setCodigoConFiscal("123");
        relatorio.setCodigoConsultora("0001");
        relatorio.setCpf("065.420.456-00");
        relatorio.setData("12/12/2012");
        relatorio.setDesconto25("24,00");
        relatorio.setEndereco("Rua sete de Setembro");
        relatorio.setNome("JOse RObson de Assis");
        relatorio.setNotaFiscal("123123123");
        relatorio.setNumeroOrcamento("123123123123");
        relatorio.setSubTotal("500.00");
        relatorio.setTotal("450.00");

        List<ItemRelatorioCompleto> lstItem = new ArrayList<ItemRelatorioCompleto>();

        for (int i = 0; i < 40; i++) {
            lstItem.add(addItem());
        }


        relatorio.setListaItens(lstItem);

        List<RelatorioCompletoVenda> lstRelatorio = new ArrayList<RelatorioCompletoVenda>();
        lstRelatorio.add(relatorio);

        return lstRelatorio;
    }

    public List getListaRelatorioCompletoCompra() {
        RelatorioCompletoCompra relatorio = new RelatorioCompletoCompra();
        relatorio.setData("12/12/2012");
        relatorio.setSubTotal("500.00");
        relatorio.setTotal("450.00");
        relatorio.setFornecedor("Fornecedor");
        relatorio.setDescontoEmDinheiro("12.20");
        relatorio.setDescontoEmPorcentagem("12");

        List<ItemRelatorioCompleto> lstItem = new ArrayList<ItemRelatorioCompleto>();

        for (int i = 0; i < 40; i++) {
            lstItem.add(addItem());
        }
        relatorio.setListaItens(lstItem);
        List<RelatorioCompletoCompra> lstRelatorio = new ArrayList<RelatorioCompletoCompra>();
        lstRelatorio.add(relatorio);

        return lstRelatorio;
    }

    public List getListaRelatorioExpedicao() {
        RelatorioExpedicaoVenda relatorio = new RelatorioExpedicaoVenda();
        relatorio.setCep("123");
        relatorio.setCidadeEstado("Resende Costa / MG");
        relatorio.setCpf("065.420.456-00");
        relatorio.setData("12/12/2012");
        relatorio.setEndereco("Rua sete de Setembro");
        relatorio.setNome("JOse RObson de Assis");
        relatorio.setNumeroOrcamento("123123123123");
        relatorio.setCodigoConsultor("123");
        List<ItemRelatorioExpedicao> lstItem = new ArrayList<ItemRelatorioExpedicao>();

        for (int i = 0; i < 40; i++) {
           // lstItem.add(addItem());
        }


        relatorio.setListaItens(lstItem);

        List<RelatorioExpedicao> lstRelatorio = new ArrayList<RelatorioExpedicao>();
        lstRelatorio.add(relatorio);

        return lstRelatorio;
    }

    public ItemRelatorioCompleto addItem() {
        ItemRelatorioCompleto item = new ItemRelatorioCompleto();
        item.setReferenciaCatalogo("1234");
        item.setCodigoFiscal("123123");
        item.setCor("02");
        item.setQuantidade("10");
        item.setDescricao("Produto teste");
        item.setValorUnitario("50.00");
        item.setValorTotal("500.00");
       // item.setCorPorExtenso("Azul vermelho");
        return item;

    }

    public ItemPedido addItemPedido() {

        ItemPedido item = new ItemPedido();
        CodigoItem codigo = new CodigoItem();
        codigo.setTipo(Enum_Tipo_Codigo.REFERENCIA_CATALOGO.getCodigo());
        codigo.setCodigo("123456");
        item.setCodigo(codigo);
        item.setCodigoFiscal("1234");
        item.setCor("001");
        item.setCorPorExtenso("Azul borboleta");
        item.setDescricao("produto teste produto teste");
        item.setQuantidade(12);
        item.setValorUnitario(Float.valueOf(10));
        item.setValorTotal(Long.valueOf(120));
        return item;

    }
}
