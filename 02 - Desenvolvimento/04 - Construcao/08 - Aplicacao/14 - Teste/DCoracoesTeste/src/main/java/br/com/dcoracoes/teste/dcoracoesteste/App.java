package br.com.dcoracoes.teste.dcoracoesteste;

import br.com.dcoracoes.server.model.canalacesso.AssociaPerfilPermissao;
import br.com.dcoracoes.teste.dcoracoesteste.dozer.*;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        //convertAlerta();
        //convertPedido();
        convertPerfil();
        //convertPermissao()
        //convertProduto();
        //convertAssociaPerfilPermissao();
    }

    private static void convertAlerta() {
        AlertaDozer dozer = new AlertaDozer();
        dozer.convertBeanParaModel();
        dozer.convertModelParaBean();
    }

    private static void convertPedido() {
        PedidoDozer dozer = new PedidoDozer();
        dozer.convertBeanParaModel();
        dozer.convertModelParaBean();
    }

    private static void convertProduto() {
        ProdutoDozer dozer = new ProdutoDozer();
        dozer.convertBeanParaModel();
        dozer.convertModelParaBean();
    }

    private static void convertAssociaPerfilPermissao() {
        AssociaPerfilPermissaoDozer dozer = new AssociaPerfilPermissaoDozer();
        dozer.convertBeanParaModel();
        dozer.convertModelParaBean();
    }

    private static void convertPerfil() {
        PerfilDozer dozer = new PerfilDozer();
        dozer.convertBeanParaModel();
        dozer.convertModelParaBean();
    }
}
