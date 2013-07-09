/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.servico.service;

import br.com.dcoracoes.servico.beans.cadastro.Pessoa;
import br.com.dcoracoes.servico.beans.cadastro.PessoaFisica;
import br.com.dcoracoes.servico.beans.cadastro.Revendedor;
import br.com.dcoracoes.servico.beans.cadastro.ViewRevendedor;
import br.com.dcoracoes.servico.beans.canalacesso.AssociaPerfilPermissao;
import br.com.dcoracoes.servico.beans.canalacesso.Perfil;
import br.com.dcoracoes.servico.beans.canalacesso.Permissao;
import br.com.dcoracoes.servico.beans.canalacesso.Usuario;
import br.com.dcoracoes.servico.beans.pedido.Pedido;
import br.com.dcoracoes.servico.beans.pedido.PedidoVenda;
import br.com.dcoracoes.servico.beans.produto.ItemProduto;
import br.com.dcoracoes.servico.beans.produto.Produto;
import br.com.dcoracoes.servico.beans.prospeccao.Alerta;
import java.util.HashMap;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Jose Robson
 */
@WebService(serviceName = "wsServiceDCoracoes")
public class wsServiceDCoracoes {

    /**
     * INICIO METODOS SERVICE PERMISSAO
     */
    @WebMethod(operationName = "salvarPermissao")
    public void salvarPermissao(@WebParam(name = "pPermissao") Permissao pPermissao) throws Exception {
        new ServicePermissao<Permissao>().salvar(pPermissao);
    }

    @WebMethod(operationName = "recTodasPemissoes")
    public List<Permissao> recTodasPemissoes() throws Exception {
        return new ServicePermissao<Permissao>().recTodos();
    }

    /**
     * INICIO METODOS SERVICE ALERTA
     */
    @WebMethod(operationName = "salvarAlerta")
    public void salvarAlerta(@WebParam(name = "pAlerta") Alerta param) throws Exception {
        new ServiceAlerta().salvar(param);
    }

    @WebMethod(operationName = "recAlertasPorPessoa")
    public List<Alerta> recAlertasPorPessoa(@WebParam(name = "pPessoa") Pessoa param) throws Exception {
        return new ServiceAlerta().recAlertasPorPessoa(param);
    }

    @WebMethod(operationName = "gerarNumeroProtocolo")
    public String gerarNumeroProcotoco() throws Exception {
        return new ServiceAlerta().gerarNumeroProtoco();
    }

    @WebMethod(operationName = "recListaAlertas")
    public List<Alerta> recListaAlertas(@WebParam(name = "pAlerta") Alerta pAlerta) throws Exception {
        return new ServiceAlerta().recTodos(pAlerta);
    }

    /**
     * INICIO METODOS SERVICE PEDIDO
     */
    @WebMethod(operationName = "salvarPedido")
    public void salvarPedido(@WebParam(name = "pPedido") Pedido pPedido) throws Exception {
        new ServicePedido<Pedido>().salvar(pPedido);
    }

    @WebMethod(operationName = "recListaPedidos")
    public List<Pedido> nome(@WebParam(name = "pPedido") Pedido pPedido) throws Exception {
        return new ServicePedido<Pedido>().recTodos(pPedido);
    }

    @WebMethod(operationName = "recCodigoOrcamento")
    public String recCodigoOrcamento() throws Exception {
        return new ServicePedido<Pedido>().recCodigoOrcamento();
    }

    @WebMethod(operationName = "removePedido")
    public Pedido removePedido(@WebParam(name = "pPedido") Pedido pPedido) throws Exception {
        return new ServicePedido<Pedido>().deletar(pPedido);
    }

    @WebMethod(operationName = "aprovarPedido")
    public boolean aprovarPedido(@WebParam(name = "pPedido") Pedido pPedido) throws Exception {
        return new ServicePedido<Pedido>().aprovarPedido(pPedido);
    }

    @WebMethod(operationName = "recRelatorioPedidosPorRevendedor")
    public List recRelatorioPedidosPorRevendedor(@WebParam(name = "param") HashMap param) throws Exception {
        return new ServicePedido<Pedido>().recRelatorioPedidosPorRevendedor(param);
    }

    /**
     * INICIO METODOS SERVICE PERFIL
     */
    @WebMethod(operationName = "salvarPerfil")
    public void salvarPerfil(@WebParam(name = "pPerfil") Perfil pPerfil, 
            @WebParam(name = "listAssociaPerfilPermissao") List<AssociaPerfilPermissao> listAssociaPerfilPermissao) throws Exception {
        new ServicePerfil<Perfil>().salvar(pPerfil, listAssociaPerfilPermissao);
    }

    @WebMethod(operationName = "recListaPerfis")
    public List<Perfil> recListaPerfis(@WebParam(name = "pPerfil") Perfil pPerfil) throws Exception {
        return new ServicePerfil<Perfil>().recTodos(pPerfil);
    }

    @WebMethod(operationName = "recPerfilPorId")
    public Perfil recPerfilPorId(@WebParam(name = "pId") Long pId) throws Exception {
        return new ServicePerfil<Perfil>().recPorId(pId);
    }

    @WebMethod(operationName = "recPermissoesPorPerfil")
    public List<AssociaPerfilPermissao> recPermissoesPorPerfil(@WebParam(name = "pPerfil") Perfil pPerfil) throws Exception {
        return new ServicePerfil<Perfil>().recPermissoesPorPerfil(pPerfil);
    }

    /**
     * INICIO METODOS SERVICE PRODUTO
     */
    @WebMethod(operationName = "salvarProduto")
    public void salvarProduto(@WebParam(name = "pProduto") Produto pProduto) throws Exception {
        new ServiceProduto<Produto>().salvar(pProduto);
    }

    @WebMethod(operationName = "recProdutos")
    public List<Produto> recProdutos(@WebParam(name = "pProduto") Produto pProduto, @WebParam(name = "useLike") boolean useLike) throws Exception {
        return new ServiceProduto<Produto>().recTodos(pProduto, useLike);
    }

    @WebMethod(operationName = "removeItemProduto")
    public void removeItemProduto(@WebParam(name = "pItemProduto") ItemProduto pItemProduto) throws Exception {
        new ServiceProduto<Produto>().removeItemProduto(pItemProduto);
    }

    @WebMethod(operationName = "removeProduto")
    public Produto removeProduto(@WebParam(name = "pProduto") Produto pProduto) throws Exception {
        return new ServiceProduto<Produto>().deletar(pProduto);
    }

    /**
     * INICIO METODOS SERVICE REVENDEDOR
     */
    @WebMethod(operationName = "salvarRevendedor")
    public void salvarRevendedor(@WebParam(name = "pViewRevendedor") ViewRevendedor pViewRevendedor) throws Exception {
        new ServiceRevendedor<ViewRevendedor>().salvar(pViewRevendedor);
    }

    @WebMethod(operationName = "recUltimoRevendedorCadastro")
    public ViewRevendedor recUltimoRevendedorCadastro() throws Exception {
        return new ServiceRevendedor<ViewRevendedor>().recUltimoRevendedorCadastro();
    }

    @WebMethod(operationName = "recCodigoSequencia")
    public int recCodigoSequencia() throws Exception {
        return new ServiceRevendedor<ViewRevendedor>().recCodigoSequencia();
    }

    @WebMethod(operationName = "recListaViewRevendedor")
    public List<ViewRevendedor> recListaViewRevendedor(@WebParam(name = "pViewRevendedor") ViewRevendedor pViewRevendedor) throws Exception {
        return new ServiceRevendedor<ViewRevendedor>().recTodos(pViewRevendedor);
    }

    @WebMethod(operationName = "validaCPF")
    public String validaCPF(@WebParam(name = "pPessoa") PessoaFisica pPessoa) throws Exception {
        return new ServiceRevendedor<ViewRevendedor>().validaCPF(pPessoa);
    }

    @WebMethod(operationName = "recUltimoPedidoVenda")
    public PedidoVenda recUltimoPedidoVenda(@WebParam(name = "pRevendedor") Revendedor pRevendedor) throws Exception {
        return new ServiceRevendedor<ViewRevendedor>().recUltimoPedidoVenda(pRevendedor);
    }

    @WebMethod(operationName = "recRevendedorEtiqueta")
    public List<Pessoa> recRevendedorEtiqueta(@WebParam(name = "parameter") HashMap parameter) throws Exception {
        return new ServiceRevendedor<ViewRevendedor>().recRevendedorEtiqueta(parameter);
    }

    @WebMethod(operationName = "recPessoaPorId")
    public Pessoa recPessoaPorId(@WebParam(name = "id") Long id) throws Exception {
        return new ServiceRevendedor<ViewRevendedor>().recPessoaPorId(id);
    }

    /**
     * INICIO METODOS SERVICE Usuario
     */
    @WebMethod(operationName = "salvarUsuario")
    public void salvarUsuario(@WebParam(name = "pUsuario") Usuario pUsuario) throws Exception {
        new ServiceUsuario<Usuario>().salvar(pUsuario);
    }
    
    @WebMethod(operationName = "salvarUsuarioComRetorno")
    public Usuario salvarUsuarioComRetorno(@WebParam(name = "pUsuario") Usuario pUsuario) throws Exception {       
        ServiceUsuario service = new ServiceUsuario<Usuario>();
        return (Usuario)service.salvarComRetorno(pUsuario);
    }
    
    @WebMethod(operationName = "recListaUsuario")
    public List<Usuario> recListaUsuario(@WebParam(name = "pUsuario") Usuario pUsuario) throws Exception {
        return new ServiceUsuario<Usuario>().recTodos(pUsuario);
    }

    @WebMethod(operationName = "recUsuarioPorId")
    public Usuario recUsuarioPorId(@WebParam(name = "id") Long id) throws Exception {
        return new ServiceUsuario<Usuario>().recPorId(id);
    }

    /**
     * INICO METODO SERVICE UTIL
     * @return
     * @throws Exception 
     */
    public boolean verificarConexaoComBanco() throws Exception {
        return new ServiceUtil().verificaConexaoComBanco();
    }
}
