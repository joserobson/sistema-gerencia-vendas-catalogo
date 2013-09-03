/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.relatorios;

import br.com.dcoracoes.servico.service.*;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author Robson
 */
public class GerarRelatorio {

    private String caminhoArquivoJasper;
    private JRBeanCollectionDataSource dataSourceBean;
    private Map mapParametros;
    private JasperPrint jasperPrint;
    private DecimalFormat decimalFormat;
    private SimpleDateFormat dataFormat;
    private String nomeDiretorioTemp;

    /**
     * CONSTRUTOR
     */
    public GerarRelatorio() {        
        this.dataFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.decimalFormat = new DecimalFormat("#,###.00");
        nomeDiretorioTemp = System.getProperty("java.io.tmpdir");
    }

    /**
     * METODOS GETS E SETS
     * @param caminhoArquivoJasper 
     */
    public String getCaminhoArquivoJasper() {
        return caminhoArquivoJasper;
    }

    public void setCaminhoArquivoJasper(String caminhoArquivoJasper) {
        this.caminhoArquivoJasper = caminhoArquivoJasper;
    }

    public JRBeanCollectionDataSource getDataSourceBean() {
        return dataSourceBean;
    }

    public void setDataSourceBean(JRBeanCollectionDataSource dataSourceBean) {
        this.dataSourceBean = dataSourceBean;
    }

    public JasperPrint getJasperPrint() {
        return jasperPrint;
    }

    public void setJasperPrint(JasperPrint jasperPrint) {
        this.jasperPrint = jasperPrint;
    }

    public Map getMapParametros() {
        return mapParametros;
    }

    public void setMapParametros(Map mapParametros) {
        this.mapParametros = mapParametros;
    }

    /**
     * Lógica para gerar relatorio completo de compra
     * @param pedido 
     */
    public void gerarRelatorioCompletoCompra(PedidoCompra pedido) throws JRException {

        try {
            //pegar o arquivo do jasper
            this.caminhoArquivoJasper = "/jaspers/relCompletoCompra.jasper";

            //lista Relatorio
            List lstRelatorio = getListaRelatorioCompletoCompra(pedido);

            //stream jasper
            InputStream streamRel = getClass().getResourceAsStream(this.caminhoArquivoJasper);

            //instancia data source
            this.dataSourceBean = new JRBeanCollectionDataSource(lstRelatorio);

            String localPath = "/jaspers/relCompletoVenda_subRelItens.jasper";
            this.mapParametros = new HashMap();
            this.mapParametros.put("SUBREPORT_DIR", getClass().getResource(localPath));
            
            //jasper Print
            this.jasperPrint = JasperFillManager.fillReport(streamRel, this.mapParametros, this.dataSourceBean);

            //JasperViewer viewer = new JasperViewer(jasperPrint, false);
            //viewer.setVisible(true);
            //String nomeDiretorioTemp = System.getProperty("java.io.tmpdir");
            //JasperExportManager.exportReportToPdfFile(this.jasperPrint, nomeDiretorioTemp + "\\teste.pdf");
            gerarAbrirPdf(this.jasperPrint,"TempRelatorioComplCompra");


        } catch (JRException ex) {
            throw ex;
        }
    }

    /**
     * Lógica para gerar relatório completo de venda
     * @param pedido 
     */
    public void gerarRelatorioCompletoVenda(PedidoVenda pedido) throws JRException {
        try {
            //pegar o arquivo do jasper
            this.caminhoArquivoJasper = "/jaspers/relCompletoVenda.jasper";

            //lista Relatorio
            List lstRelatorio = getListaRelatorioCompletoVenda(pedido);

            //stream jasper
            InputStream streamRel = getClass().getResourceAsStream(this.caminhoArquivoJasper);

            //instancia data source
            this.dataSourceBean = new JRBeanCollectionDataSource(lstRelatorio);

            String localPath = "/jaspers/relCompletoVenda_subRelItens.jasper";
            this.mapParametros = new HashMap();
            this.mapParametros.put("SUBREPORT_DIR", getClass().getResource(localPath));
            
            //jasper Print
            this.jasperPrint = JasperFillManager.fillReport(streamRel, this.mapParametros, this.dataSourceBean);

            //JasperViewer viewer = new JasperViewer(jasperPrint, false);
            //viewer.setVisible(true);
            // JasperExportManager.exportReportToPdfFile(impressao, localPath + "teste.pdf");

            //logica para abrir o pdf            
            gerarAbrirPdf(this.jasperPrint,"TempRelatorioComplVenda");

        } catch (JRException ex) {
            throw ex;
        }
    }

    /**
     * Lógica para gerar relatório de expedição para pedido venda
     * @param pedido
     */
    public void gerarRelatorioExpedicaoVenda(PedidoVenda pedido) throws JRException {
        try {
            //pegar o arquivo do jasper
            this.caminhoArquivoJasper = "/jaspers/relExpedicaoVenda.jasper";

            //lista Relatorio
            List lstRelatorio = getListaRelatorioExpedicaoVenda(pedido);

            //stream jasper
            InputStream streamRel = getClass().getResourceAsStream(this.caminhoArquivoJasper);

            //instancia data source
            this.dataSourceBean = new JRBeanCollectionDataSource(lstRelatorio);

            String localPath = "/jaspers/relExpedicao_subRelItens.jasper";
            this.mapParametros = new HashMap();
            this.mapParametros.put("SUBREPORT_DIR", getClass().getResource(localPath));

            //jasper Print
            this.jasperPrint = JasperFillManager.fillReport(streamRel, this.mapParametros, this.dataSourceBean);

            //JasperViewer viewer = new JasperViewer(jasperPrint, false);
            //viewer.setVisible(true);
            // JasperExportManager.exportReportToPdfFile(impressao, localPath + "teste.pdf");
            gerarAbrirPdf(this.jasperPrint,"TempRelatorioExpedicaoVenda");

        } catch (JRException ex) {
            throw ex;            
        }
    }
    
    /**
     * Lógica para gerar relatório de expedição para pedido compra
     * @param pedido
     */
    public void gerarRelatorioExpedicaoCompra(PedidoCompra pedido) throws JRException {
        try {
            //pegar o arquivo do jasper
            this.caminhoArquivoJasper = "/jaspers/relExpedicaoCompra.jasper";

            //lista Relatorio
            List lstRelatorio = getListaRelatorioExpedicaoCompra(pedido);

            //stream jasper
            InputStream streamRel = getClass().getResourceAsStream(this.caminhoArquivoJasper);

            //instancia data source
            this.dataSourceBean = new JRBeanCollectionDataSource(lstRelatorio);

            String localPath = "/jaspers/relExpedicao_subRelItens.jasper";
            this.mapParametros = new HashMap();
            this.mapParametros.put("SUBREPORT_DIR", getClass().getResource(localPath));

            //jasper Print
            this.jasperPrint = JasperFillManager.fillReport(streamRel, this.mapParametros, this.dataSourceBean);

            //JasperViewer viewer = new JasperViewer(jasperPrint, false);
            //viewer.setVisible(true);
            // JasperExportManager.exportReportToPdfFile(impressao, localPath + "teste.pdf");
            gerarAbrirPdf(this.jasperPrint,"TempRelatorioExpedicaoCompra");

        } catch (JRException ex) {
            throw ex;            
        }
    }

    /**
     *  Inicializa relatorio completo de compra
     * @return 
     */
    public List getListaRelatorioCompletoCompra(PedidoCompra pedido) {

        RelatorioCompletoCompra relatorio = new RelatorioCompletoCompra();
        relatorio.setData(this.dataFormat.format(Calendar.getInstance().getTime()));
        relatorio.setSubTotal(decimalFormat.format(pedido.getSubTotal()));
        relatorio.setTotal(decimalFormat.format(pedido.getTotal()));
        relatorio.setFornecedor(pedido.getFornecedor().getPessoa().getNome());
        relatorio.setDescontoEmDinheiro(this.decimalFormat.format(pedido.getDescontoDinheiro()));
        relatorio.setDescontoEmPorcentagem(this.decimalFormat.format(pedido.getDescontoPorcentagem()));

        List<ItemRelatorioCompleto> lstItem = new ArrayList<ItemRelatorioCompleto>();

        int contTotalItensPedido = 0;
        //adicionando itens
        for (ItemPedido item : pedido.getListaItensPedido()) {
            lstItem.add(addItemRelatorioCompleto(item));
            contTotalItensPedido += item.getQuantidade();
        } 

        relatorio.setListaItens(lstItem);
        relatorio.setTotalItensPedido(String.valueOf(contTotalItensPedido));

        List<RelatorioCompletoCompra> lstRelatorio = new ArrayList<RelatorioCompletoCompra>();
        lstRelatorio.add(relatorio);

        return lstRelatorio;
    }

    /**
     *  Inicializa relatorio completo de venda
     * @return 
     */
    public List getListaRelatorioCompletoVenda(PedidoVenda pedido) {

        RelatorioCompletoVenda relatorio = new RelatorioCompletoVenda();

        relatorio.setCep(pedido.getRevendedor().getPessoa().getEndereco().getCep());
        relatorio.setCidadeEstado(pedido.getRevendedor().getPessoa().getEndereco().getCidade() + "/"
                + pedido.getRevendedor().getPessoa().getEndereco().getEstado());
        relatorio.setCodigoConFiscal(String.valueOf(pedido.getRevendedor().getCodigoConFiscal()));
        relatorio.setCodigoConsultora(String.valueOf(pedido.getRevendedor().getCodigo()));
        relatorio.setCpf(((PessoaFisica) pedido.getRevendedor().getPessoa()).getCpf());
        relatorio.setDesconto25(decimalFormat.format(pedido.getDescontoDinheiro()));
        relatorio.setEndereco(pedido.getRevendedor().getPessoa().getEndereco().getRua());
        relatorio.setNome(pedido.getRevendedor().getPessoa().getNome());
        relatorio.setNotaFiscal(pedido.getRevendedor().getNumeroNotaFiscal());
        relatorio.setNumeroOrcamento(pedido.getCodigo());
        relatorio.setData(this.dataFormat.format(Calendar.getInstance().getTime()));
        relatorio.setSubTotal(decimalFormat.format(pedido.getSubTotal()));
        relatorio.setTotal(decimalFormat.format(pedido.getTotal()));
        relatorio.setDesconto25(decimalFormat.format(pedido.getDescontoPorcentagem()));

        List<ItemRelatorioCompleto> lstItem = new ArrayList<ItemRelatorioCompleto>();

        int contTotalItensPedido = 0;
        //adicionando itens
        for (ItemPedido item : pedido.getListaItensPedido()) {
            lstItem.add(addItemRelatorioCompleto(item));
            contTotalItensPedido += item.getQuantidade();
        } 

        relatorio.setListaItens(lstItem);
        relatorio.setTotalItensPedido(String.valueOf(contTotalItensPedido));

        List<RelatorioCompletoVenda> lstRelatorio = new ArrayList<RelatorioCompletoVenda>();
        lstRelatorio.add(relatorio);

        return lstRelatorio;
    }
    
    /**
     * Inicializa realtorio de expedicao
     * @param pedidoVenda
     * @param relatorio
     * @return 
     */
    private void getListaRelatorioExpedicao(Pedido pedido, RelatorioExpedicao relatorio) {
        
        relatorio.setData(this.dataFormat.format(Calendar.getInstance().getTime()));

        List<ItemRelatorioExpedicao> lstItem = new ArrayList<ItemRelatorioExpedicao>();

        int contTotalItensPedido = 0;
        //adicionando itens
        for (ItemPedido item : pedido.getListaItensPedido()) {
            lstItem.add(addItemRelatorioExpedicao(item));
            contTotalItensPedido += item.getQuantidade();
        }

        relatorio.setListaItens(lstItem);
        relatorio.setTotalItensPedido(String.valueOf(contTotalItensPedido));
        
    }

    /**
     * Inicializa realtorio de expedicao venda
     * @param pedidoVenda
     * @return 
     */
    private List getListaRelatorioExpedicaoVenda(PedidoVenda pedido) {
        RelatorioExpedicaoVenda relatorio = new RelatorioExpedicaoVenda();

        relatorio.setCep(pedido.getRevendedor().getPessoa().getEndereco().getCep());
        relatorio.setCidadeEstado(pedido.getRevendedor().getPessoa().getEndereco().getCidade() + "/"
                + pedido.getRevendedor().getPessoa().getEndereco().getEstado());
        relatorio.setCpf(((PessoaFisica) pedido.getRevendedor().getPessoa()).getCpf());
        relatorio.setEndereco(pedido.getRevendedor().getPessoa().getEndereco().getRua());
        relatorio.setNome(pedido.getRevendedor().getPessoa().getNome());
        relatorio.setCodigoConsultor(String.valueOf(pedido.getRevendedor().getCodigo()));
        relatorio.setCodigoConFiscal(String.valueOf(pedido.getRevendedor().getCodigoConFiscal()));
        relatorio.setCodigoNotaFiscal(String.valueOf(pedido.getRevendedor().getNumeroNotaFiscal()));
        relatorio.setNumeroOrcamento(pedido.getCodigo());

        getListaRelatorioExpedicao(pedido, relatorio);

        List<RelatorioExpedicao> lstRelatorio = new ArrayList<RelatorioExpedicao>();
        lstRelatorio.add(relatorio);

        return lstRelatorio;
    }
    
    /**
     * Inicializa realtorio de expedicao compra
     * @param pedidoCompra
     * @return 
     */
    private List getListaRelatorioExpedicaoCompra(PedidoCompra pedido) {
        RelatorioExpedicaoCompra relatorio = new RelatorioExpedicaoCompra();

        relatorio.setFornecedor(pedido.getFornecedor().getPessoa().getNome());

        getListaRelatorioExpedicao(pedido, relatorio);

        List<RelatorioExpedicao> lstRelatorio = new ArrayList<RelatorioExpedicao>();
        lstRelatorio.add(relatorio);

        return lstRelatorio;
    }

    /**
     * Instancia um itemRelatorio completo
     * @param item
     * @return 
     */
    private ItemRelatorioCompleto addItemRelatorioCompleto(ItemPedido itemPedido) {
        ItemRelatorioCompleto item = new ItemRelatorioCompleto();
        item.setReferenciaCatalogo(itemPedido.getCodigo().getCodigo());
        item.setCodigoFiscal(itemPedido.getCodigoFiscal());
        item.setCor(itemPedido.getCor());
        item.setQuantidade(String.valueOf(itemPedido.getQuantidade()));
        item.setDescricao(itemPedido.getDescricao());
        item.setValorUnitario(decimalFormat.format(itemPedido.getValorUnitario()));
        item.setValorTotal(decimalFormat.format(itemPedido.getValorTotal()));
        return item;
    }

    /**
     * Instancia e retorna um item para relatorio expedicao
     * @param itemPedido
     * @return
     */
    private ItemRelatorioExpedicao addItemRelatorioExpedicao(ItemPedido itemPedido) {
        ItemRelatorioExpedicao item = new ItemRelatorioExpedicao();
        item.setReferenciaCatalogo(itemPedido.getCodigo().getCodigo());
        item.setCor(itemPedido.getCor());
        item.setQuantidade(String.valueOf(itemPedido.getQuantidade()));
        item.setDescricao(itemPedido.getDescricao());
        item.setCorPorExtenso(itemPedido.getCorPorExtenso());
        return item;
    }

    /**
     * METODO PARA GERAR E ABRIR PDF
     * @param jasperPrint
     * @throws JRException 
     */
    private void gerarAbrirPdf(JasperPrint jasperPrint, String nomeRelatorio) throws JRException {
        String caminhoRelatorio = nomeDiretorioTemp + "\\" + nomeRelatorio + ".pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint, caminhoRelatorio);
        try {
            Runtime.getRuntime().exec("cmd.exe /C ".concat(caminhoRelatorio));
        } catch (IOException ex) {
            Logger.getLogger(GerarRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /***************************************************************
     * Relatorio Etiqueta
     ***************************************************************/
    /**
     * Lógica para gerar etiquetas com nome e endereco
     * @param Pessoa
     */
    public void gerarRelatorioEtiqueta(List<Pessoa> list) throws JRException {
        try {
            //pegar o arquivo do jasper
            this.caminhoArquivoJasper = "/jaspers/relEtiqueta.jasper";

            //lista Relatorio
            List lstRelatorio = getListaRelatorioEtiqueta(list);

            //stream jasper
            InputStream streamRel = getClass().getResourceAsStream(this.caminhoArquivoJasper);

            //instancia data source
            this.dataSourceBean = new JRBeanCollectionDataSource(lstRelatorio);

            String localPath = "/jaspers/relEtiqueta_subRelItens.jasper";
            this.mapParametros = new HashMap();
            this.mapParametros.put("SUBREPORT", getClass().getResource(localPath));

            //jasper Print
            this.jasperPrint = JasperFillManager.fillReport(streamRel, this.mapParametros, this.dataSourceBean);

            gerarAbrirPdf(this.jasperPrint,"TempRelatorioEtiquetaVenda");

        } catch (JRException ex) {
            throw ex;            
        }
    }
    
    /**
     * Inicializa realtorio de etiquetas
     * @param Pessoa
     * @return 
     */
    private List getListaRelatorioEtiqueta(List<Pessoa> list) {
        RelatorioEtiqueta relatorio = new RelatorioEtiqueta();

        List<ItemRelatorioEtiqueta> lstItem = new ArrayList<ItemRelatorioEtiqueta>();

        //adicionando itens
        for (Pessoa item : list) {
            lstItem.add(addItemRelatorioEtiqueta(item));
        }

        relatorio.setListaItens(lstItem);        
        

        List<RelatorioEtiqueta> lstRelatorio = new ArrayList<RelatorioEtiqueta>();
        lstRelatorio.add(relatorio);

        return lstRelatorio;
    }
    
    /**
     * Instancia e retorna um item para relatorio etiqueta
     * @param Pessoa
     * @return
     */
    private ItemRelatorioEtiqueta addItemRelatorioEtiqueta(Pessoa pessoa) {
        ItemRelatorioEtiqueta item = new ItemRelatorioEtiqueta();
        //Nome Revendedor
        item.setNome("Nome: " + pessoa.getNome());
        
        //******ENDERECO******
        StringBuilder end = new StringBuilder();
        //Rua
        end.append(pessoa.getEndereco().getRua().trim());
        //Numero
        if(pessoa.getEndereco().getNumero() != null)
            if(!pessoa.getEndereco().getNumero().trim().isEmpty())
                end.append(", ").append(pessoa.getEndereco().getNumero().trim());
        //Bairro
            if(pessoa.getEndereco().getBairro() != null)
                if(!pessoa.getEndereco().getBairro().trim().isEmpty())
                    end.append(" - ").append(pessoa.getEndereco().getBairro().trim());
        //Complemento
        if(pessoa.getEndereco().getComplemento() != null)
            if(!pessoa.getEndereco().getComplemento().trim().isEmpty())
                end.append(" - ").append(pessoa.getEndereco().getComplemento().trim());
        //Cidade
        end.append(", ").append(pessoa.getEndereco().getCidade().trim());
        //Estado
        end.append(" - ").append(pessoa.getEndereco().getEstado().trim());
        //CEP
        if(pessoa.getEndereco().getCep() != null)
            if(!pessoa.getEndereco().getCep().trim().isEmpty())
                end.append(" - CEP: ").append(pessoa.getEndereco().getCep().trim());
        //Ponto de Referencia
            if(pessoa.getEndereco().getReferencia() != null)
                if(!pessoa.getEndereco().getReferencia().trim().isEmpty())
                    end.append(", ").append("REFERÊNCIA: ").append(pessoa.getEndereco().getReferencia().trim());
                
        item.setEndereco(end.toString());
        
        return item;
    }
    
    /***************************************************************
     * Relatorio Venda por Revendedor
     ***************************************************************/
    /**
     * Lógica para gerar relatorio de venda por revendedor
     * @param pedido
     */
    public void gerarRelatorioVendaPorRevendedor(List<PedidoVenda> list) throws JRException {
        try {
            //pegar o arquivo do jasper
            this.caminhoArquivoJasper = "/jaspers/relVendaPorRevendedor.jasper";

            //lista Relatorio
            List lstRelatorio = getListaRelatorioVendaPorRevendedor(list);

            //stream jasper
            InputStream streamRel = getClass().getResourceAsStream(this.caminhoArquivoJasper);

            //instancia data source
            this.dataSourceBean = new JRBeanCollectionDataSource(lstRelatorio);

            String localPath = "/jaspers/relVendaPorRevendedor_subRelItens.jasper";
            this.mapParametros = new HashMap();
            this.mapParametros.put("SUBREPORT", getClass().getResource(localPath));

            //jasper Print
            this.jasperPrint = JasperFillManager.fillReport(streamRel, this.mapParametros, this.dataSourceBean);

            gerarAbrirPdf(this.jasperPrint,"TempRelatorioVendaPorRevendedor");

        } catch (JRException ex) {
            throw ex;            
        }
    }
    
    /**
     * Inicializa realtorio de venda por revendedor
     * @param pedidoVenda
     * @return 
     */
    private List getListaRelatorioVendaPorRevendedor(List<PedidoVenda> list) {
        RelatorioVendaPorRevendedor relatorio = new RelatorioVendaPorRevendedor();

        List<ItemRelatorioVendaPorRevendedor> lstItem = new ArrayList<ItemRelatorioVendaPorRevendedor>();

        //adicionando itens
        for (PedidoVenda item : list) {
            lstItem.add(addItemRelatorioVendaPorRevendedor(item));
        }

        relatorio.setListaItens(lstItem);        
        

        List<RelatorioVendaPorRevendedor> lstRelatorio = new ArrayList<RelatorioVendaPorRevendedor>();
        lstRelatorio.add(relatorio);

        return lstRelatorio;
    }
    
    /**
     * Instancia e retorna um item para relatorio venda por produto
     * @param PedidoVenda
     * @return
     */
    private ItemRelatorioVendaPorRevendedor addItemRelatorioVendaPorRevendedor(PedidoVenda pedidoVenda) {
        ItemRelatorioVendaPorRevendedor item = new ItemRelatorioVendaPorRevendedor();
        //Codigo Revendedor
        item.setCodigo(pedidoVenda.getRevendedor().getCodigo()+"");
        //Nome Revendedor
        item.setNome(pedidoVenda.getRevendedor().getPessoa().getNome());
        //valor total
        item.setValor(pedidoVenda.getTotal()+"");
        
        return item;
    }
    
    
    /***************************************************************
     * Relatorio de Produtos
     ***************************************************************/
    /**
     * Lógica para gerar relatorio de produtos
     * @param pedido
     */
    public void gerarRelatorioProdutos(List<Produto> list) throws JRException {
        try {
            //pegar o arquivo do jasper
            this.caminhoArquivoJasper = "/jaspers/relProduto_subRelProdutos.jasper";

            //lista Relatorio
            List lstRelatorio = getListaProduto(list);

            //stream jasper
            InputStream streamRel = getClass().getResourceAsStream(this.caminhoArquivoJasper);

            //instancia data source
            this.dataSourceBean = new JRBeanCollectionDataSource(lstRelatorio);

            String localPathItensProduto = "/jaspers/relProduto_subRelItensProduto.jasper";
            this.mapParametros = new HashMap();
            this.mapParametros.put("SUBREPORT_ITENSPRODUTO", getClass().getResource(localPathItensProduto));

            //jasper Print
            this.jasperPrint = JasperFillManager.fillReport(streamRel, this.mapParametros, this.dataSourceBean);

            gerarAbrirPdf(this.jasperPrint,"TempRelatorioProdutoEstoque");

        } catch (JRException ex) {
            throw ex;            
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }
    
    /**
     * Inicializa realtorio de produtos
     * @param pedidoVenda
     * @return 
     */
    private List getListaProduto(List<Produto> list) {
        List<ItemRelatorioProduto> lstItem = new ArrayList<ItemRelatorioProduto>();

        //adicionando itens
        for (Produto item : list) {
            lstItem.add(addItemRelatorioProduto(item));
        }

        return lstItem;
    }
    
    /**
     * Instancia e retorna um item para relatorio produto
     * @param Produto
     * @return
     */
    private ItemRelatorioProduto addItemRelatorioProduto(Produto produto) {
        ItemRelatorioProduto itemRelatorioProduto = new ItemRelatorioProduto();
        //Total Itens Produto
        itemRelatorioProduto.setTotalItensProduto(produto.getEstoqueTotal()+"");
        
        //adicionando itens
        itemRelatorioProduto.setListaItensProduto(addItemRelatorioItensProduto(produto));
        
        return itemRelatorioProduto;
    }
    
    /**
     * Instancia e retorna um itemProduto para relatorio produto
     * @param ItemProduto
     * @return
     */
    private List<ItemRelatorioItensProduto> addItemRelatorioItensProduto(Produto produto) {
        List<ItemRelatorioItensProduto> lstItensProduto = new ArrayList<ItemRelatorioItensProduto>();
        
        for (ItemProduto itemProduto : produto.getListaItensProduto()) {
            ItemRelatorioItensProduto itemRelatorioItensProduto = new ItemRelatorioItensProduto();

            //Descricao Produto
            itemRelatorioItensProduto.setDescricaoProduto(produto.getDescricao());
            //Fornecedor
            itemRelatorioItensProduto.setFornecedor(produto.getFornecedor().getPessoa().getNome());
            //Referencia Catalogo
            itemRelatorioItensProduto.setReferenciaCatalogo(produto.getReferenciaCatalogo());        
            //Cor
            itemRelatorioItensProduto.setCor(itemProduto.getCor().getCodigo());
            //Descricao Cor
            itemRelatorioItensProduto.setDescricaoCor(itemProduto.getCor().getDescricao());
            //Referencia Minimo
            itemRelatorioItensProduto.setEstoqueMinimo(itemProduto.getEstoqueMinimo()+"");
            //Estoque Atual
            itemRelatorioItensProduto.setEstoqueAtual(itemProduto.getEstoqueAtual()+"");
            
            lstItensProduto.add(itemRelatorioItensProduto);
        }
        
        
        return lstItensProduto;
    }
}
