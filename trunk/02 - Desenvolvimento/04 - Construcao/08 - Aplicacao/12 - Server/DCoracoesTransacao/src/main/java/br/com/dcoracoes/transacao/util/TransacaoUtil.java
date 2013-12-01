/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.transacao.util;

import br.com.dcoracoes.server.bo.prospeccao.AlertaBoImpl;
import br.com.dcoracoes.server.bo.cadastro.AssociaPessoaBoImpl;
import br.com.dcoracoes.server.bo.movimento.AssociaPessoaContaBoImpl;
import br.com.dcoracoes.server.bo.produto.ItemProdutoBoImpl;
import br.com.dcoracoes.server.bo.canalacesso.PerfilBoImpl;
import br.com.dcoracoes.server.bo.cadastro.PessoaBoImpl;
import br.com.dcoracoes.server.bo.produto.ProdutoBoImpl;
import br.com.dcoracoes.server.bo.cadastro.RevendedorBoImpl;
import br.com.dcoracoes.server.bo.canalacesso.AssociaPerfilPermissaoBoImpl;
import br.com.dcoracoes.server.bo.canalacesso.PermissaoBoImpl;
import br.com.dcoracoes.server.bo.canalacesso.UsuarioBoImpl;
import br.com.dcoracoes.server.bo.pedido.ItemPedidoBoImpl;
import br.com.dcoracoes.server.bo.pedido.ParcelaBoImpl;
import br.com.dcoracoes.server.bo.pedido.PedidoBoImpl;
import br.com.dcoracoes.server.dao.prospeccao.AlertaDaoImpl;
import br.com.dcoracoes.server.dao.movimento.AssociaPessoaContaDaoImpl;
import br.com.dcoracoes.server.dao.cadastro.AssociaPessoaDaoImpl;
import br.com.dcoracoes.server.dao.produto.ItemProdutoDaoImpl;
import br.com.dcoracoes.server.dao.canalacesso.PerfilDaoImpl;
import br.com.dcoracoes.server.dao.cadastro.PessoaDaoImpl;
import br.com.dcoracoes.server.dao.produto.ProdutoDaoImpl;
import br.com.dcoracoes.server.dao.cadastro.RevendedorDaoImpl;
import br.com.dcoracoes.server.dao.canalacesso.AssociaPerfilPermissaoDaoImpl;
import br.com.dcoracoes.server.dao.canalacesso.PermissaoDaoImpl;
import br.com.dcoracoes.server.dao.canalacesso.UsuarioDaoImpl;
import br.com.dcoracoes.server.dao.pedido.ItemPedidoDaoImpl;
import br.com.dcoracoes.server.dao.pedido.ParcelaDaoImpl;
import br.com.dcoracoes.server.dao.pedido.PedidoDaoImpl;
import br.com.dcoracoes.server.model.cadastro.AssociaPessoa;
import br.com.dcoracoes.server.model.cadastro.PessoaFisica;
import br.com.dcoracoes.server.model.cadastro.Revendedor;
import br.com.dcoracoes.server.model.canalacesso.AssociaPerfilPermissao;
import br.com.dcoracoes.server.model.canalacesso.Perfil;
import br.com.dcoracoes.server.model.canalacesso.Permissao;
import br.com.dcoracoes.server.model.canalacesso.Usuario;
import br.com.dcoracoes.server.model.movimento.AssociaPessoaConta;
import br.com.dcoracoes.server.model.pedido.ItemPedido;
import br.com.dcoracoes.server.model.pedido.Parcela;
import br.com.dcoracoes.server.model.pedido.Pedido;
import br.com.dcoracoes.server.model.produto.ItemProduto;
import br.com.dcoracoes.server.model.produto.Produto;
import br.com.dcoracoes.server.model.prospeccao.Alerta;
import br.com.dcoracoes.server.util.HibernateUtil;
import br.com.dcoracoes.server.util.LogUtil;
import br.com.dcoracoes.transacao.excecao.TransException;
import org.hibernate.HibernateException;

/**
 *
 * @author Robson
 */
public class TransacaoUtil {

    public static Object getInstanceBo(Class cls) {
        //PESSOA FISICA
        if (cls.equals(PessoaFisica.class)) {
            PessoaBoImpl pessoBo = new PessoaBoImpl();
            PessoaDaoImpl pessoDao = new PessoaDaoImpl();
            pessoBo.setPessoaDao(pessoDao);
            return pessoBo;
        }

        //REVENDEDOR
        if (cls.equals(Revendedor.class)) {
            RevendedorBoImpl revendedorBo = new RevendedorBoImpl();
            RevendedorDaoImpl revendedorDao = new RevendedorDaoImpl();
            revendedorBo.setRevendedorDao(revendedorDao);
            return revendedorBo;
        }

        //ASSOCIA PESSOA
        if (cls.equals(AssociaPessoa.class)) {
            AssociaPessoaBoImpl associaBo = new AssociaPessoaBoImpl();
            AssociaPessoaDaoImpl associaDao = new AssociaPessoaDaoImpl();
            associaBo.setAssociaPessoaDao(associaDao);
            return associaBo;
        }

        //ASSOCIA PESSOA CONTA
        if (cls.equals(AssociaPessoaConta.class)) {
            AssociaPessoaContaBoImpl associaBo = new AssociaPessoaContaBoImpl();
            AssociaPessoaContaDaoImpl associaDao = new AssociaPessoaContaDaoImpl();
            associaBo.setAssociaPessoaContaDao(associaDao);
            return associaBo;
        }

        //USUARIO
        if (cls.equals(Usuario.class)) {
            UsuarioBoImpl usuarioBo = new UsuarioBoImpl();
            UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();
            usuarioBo.setUsuarioDao(usuarioDao);
            return usuarioBo;
        }

        //PERFIL
        if (cls.equals(Perfil.class)) {
            PerfilBoImpl perfilBo = new PerfilBoImpl();
            PerfilDaoImpl perfilDao = new PerfilDaoImpl();
            perfilBo.setPerfilDao(perfilDao);
            return perfilBo;
        }

        //PARCELA
        if (cls.equals(Parcela.class)) {
            ParcelaBoImpl parcelaBo = new ParcelaBoImpl();
            ParcelaDaoImpl parcelaDao = new ParcelaDaoImpl();
            parcelaBo.setParcelaDao(parcelaDao);
            return parcelaBo;
        }
        
        //ALERTA
        if (cls.equals(Alerta.class)) {
            AlertaBoImpl alertaBo = new AlertaBoImpl();
            AlertaDaoImpl alertaDao = new AlertaDaoImpl();
            alertaBo.setAlertaDao(alertaDao);
            return alertaBo;
        }

        //PRODUTO
        if (cls.equals(Produto.class)) {
            ProdutoBoImpl produtoBo = new ProdutoBoImpl();
            ProdutoDaoImpl produtoDao = new ProdutoDaoImpl();
            produtoBo.setProdutoDao(produtoDao);
            return produtoBo;
        }

        //ITEMPRODUTO
        if (cls.equals(ItemProduto.class)) {
            ItemProdutoBoImpl itemBo = new ItemProdutoBoImpl();
            ItemProdutoDaoImpl itemDao = new ItemProdutoDaoImpl();
            itemBo.setItemProdutoDao(itemDao);
            return itemBo;
        }

        //PEDIDO
        if (cls.equals(Pedido.class)) {
            PedidoBoImpl bo = new PedidoBoImpl();
            PedidoDaoImpl dao = new PedidoDaoImpl();
            bo.setPedidoDao(dao);
            return bo;
        }

        //ITEMPEDIDO
        if (cls.equals(ItemPedido.class)) {
            ItemPedidoBoImpl bo = new ItemPedidoBoImpl();
            ItemPedidoDaoImpl dao = new ItemPedidoDaoImpl();
            bo.setItemPedidoDao(dao);
            return bo;
        }

        //ASSOCIAPERFILPERMISSAO
        if (cls.equals(AssociaPerfilPermissao.class)) {
            AssociaPerfilPermissaoBoImpl bo = new AssociaPerfilPermissaoBoImpl();
            AssociaPerfilPermissaoDaoImpl dao = new AssociaPerfilPermissaoDaoImpl();
            bo.setDao(dao);
            return bo;
        }
        
        //PERMISSAO
        if (cls.equals(Permissao.class))
        {
            PermissaoBoImpl permissaoBo = new PermissaoBoImpl();
            PermissaoDaoImpl permissaoDao = new PermissaoDaoImpl();
            permissaoBo.setPermissaoDao(permissaoDao);
            return permissaoBo;
        }

        return null;
    }

    /**
     * Verifica conexao com banco
     * @return
     * @throws TransException 
     */
    public static boolean verificaConexaoComBanco() {
        boolean retorno = true;
        try {
            HibernateUtil.setSession();
            HibernateUtil.getSession().beginTransaction();
        } catch(Exception ex) {
            LogUtil.logDescricaoErro(TransacaoUtil.class, "ERRRO", ex);
            HibernateUtil.getSession().close();
            return false;
        }
        
        return retorno;

    }
}
