/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client;

import br.com.dcoracoes.client.enuns.Enum_Permissao;
import br.com.dcoracoes.servico.service.AssociaPerfilPermissao;
import java.util.List;

/**
 *
 * @author Robson
 */
public class ControleAcesso {

    //FORNECEDOR
    public static boolean ATIVA_BTN_CADASTRAR_REVENDEDOR = false;
    public static boolean ATIVA_BTN_CONSULTAR_REVENDEDOR = false;
    public static boolean ATIVA_BTN_NOVO_REVENDEDOR = false;
    public static boolean ATIVA_BTN_SALVAR_REVENDEDOR = false;
    public static boolean ATIVA_BTN_DELETAR_REVENDEDOR = false;
    //PRODUTO
    public static boolean ATIVA_BTN_CADASTRAR_PRODUTO = false;
    public static boolean ATIVA_BTN_CONSULTAR_PRODUTO = false;
    public static boolean ATIVA_BTN_NOVO_PRODUTO = false;
    public static boolean ATIVA_BTN_SALVAR_PRODUTO = false;
    public static boolean ATIVA_BTN_DELETAR_PRODUTO = false;
    //PERFIL
    public static boolean ATIVA_BTN_CADASTRAR_PERFIL = false;
    public static boolean ATIVA_BTN_CONSULTAR_PERFIL = false;
    public static boolean ATIVA_BTN_NOVO_PERFIL = false;
    public static boolean ATIVA_BTN_SALVAR_PERFIL = false;
    public static boolean ATIVA_BTN_DELETAR_PERFIL = false;
    //USUARIO
    public static boolean ATIVA_BTN_CADASTRAR_USUARIO = false;
    public static boolean ATIVA_BTN_CONSULTAR_USUARIO = false;
    public static boolean ATIVA_BTN_NOVO_USUARIO = false;
    public static boolean ATIVA_BTN_SALVAR_USUARIO = false;
    public static boolean ATIVA_BTN_DELETAR_USUARIO = false;
    //PEDIDO VENDA
    public static boolean ATIVA_BTN_CADASTRAR_PEDIDO_VENDA = false;
    public static boolean ATIVA_BTN_CONSULTAR_PEDIDO_VENDA = false;
    //PEDIDO COMPRA
    public static boolean ATIVA_BTN_CADASTRAR_PEDIDO_COMPRA = false;
    public static boolean ATIVA_BTN_CONSULTAR_PEDIDO_COMPRA = false;
    //PROSPECCAO
    public static boolean ATIVA_BTN_CADASTRAR_PROSPECCAO = false;
    public static boolean ATIVA_BTN_CONSULTAR_PROSPECCAO = false;
    public static boolean ATIVA_BTN_NOVO_PROSPECCAO = false;
    public static boolean ATIVA_BTN_SALVAR_PROSPECCAO = false;
    public static boolean ATIVA_BTN_DELETAR_PROSPECCAO = false;

    /**
     * 
     * @param lstPermissoes 
     */
    public ControleAcesso(List<AssociaPerfilPermissao> lstPermissoes) {
        
        initializerAcess();
        
        long idPermissao;
        for (AssociaPerfilPermissao associaPerfilPermissao : lstPermissoes) {

            if (associaPerfilPermissao.isStatus()) {
                idPermissao = associaPerfilPermissao.getChaveComposta().getPermissao().getId();

                //fornecedor
                if (habilitaAcessoFornecedor(idPermissao)) {
                    continue;
                }

                //produto
                if (habilitaAcessoProduto(idPermissao)) {
                    continue;
                }

                //Perfil
                if (habilitaAcessoPerfil(idPermissao)) {
                    continue;
                }

                //Usuario
                if (habilitaAcessoUsuario(idPermissao)) {
                    continue;
                }

                //Pedido Compra
                if (habilitaAcessoPedidoCompra(idPermissao)) {
                    continue;
                }

                //Pedido Venda
                if (habilitaAcessoPedidoVenda(idPermissao)) {
                    continue;
                }

                //Prospeccao
                if (habilitaAcessoProspeccao(idPermissao)) {
                    continue;
                }
            }
        }
    }

    /**
     * Acesso Fornecedor
     * @param idPermissao 
     */
    private boolean habilitaAcessoFornecedor(long idPermissao) {

        if (idPermissao == Enum_Permissao.CADASTRAR_REVENDEDOR.getCodigo()) {
            ATIVA_BTN_CADASTRAR_REVENDEDOR = true;
            ATIVA_BTN_NOVO_REVENDEDOR = true;
            ATIVA_BTN_SALVAR_REVENDEDOR = true;
            return true;
        }

        if (idPermissao == Enum_Permissao.CONSULTAR_REVENDEDOR.getCodigo()) {
            ATIVA_BTN_CONSULTAR_REVENDEDOR = true;
            return true;
        }

        if (idPermissao == Enum_Permissao.DELETAR_REVENDEDOR.getCodigo()) {
            ATIVA_BTN_DELETAR_REVENDEDOR = true;
            return true;
        }

        return false;

    }

    /**
     * Acesso Produto
     * @param idPermissao 
     */
    private boolean habilitaAcessoProduto(long idPermissao) {

        if (idPermissao == Enum_Permissao.CADASTRAR_PRODUTO.getCodigo()) {
            ATIVA_BTN_NOVO_PRODUTO = true;
            ATIVA_BTN_SALVAR_PRODUTO = true;
            ATIVA_BTN_CADASTRAR_PRODUTO = true;
            return true;
        }

        if (idPermissao == Enum_Permissao.CONSULTAR_PRODUTO.getCodigo()) {
            ATIVA_BTN_CONSULTAR_PRODUTO = true;
            return true;
        }

        if (idPermissao == Enum_Permissao.DELETAR_PRODUTO.getCodigo()) {
            ATIVA_BTN_DELETAR_PRODUTO = true;
            return true;
        }
        return false;
    }

    /**
     * Acesso Perfil
     * @param idPermissao 
     */
    private boolean habilitaAcessoPerfil(long idPermissao) {

        if (idPermissao == Enum_Permissao.CADASTRAR_PERFIL.getCodigo()) {
            ATIVA_BTN_NOVO_PERFIL = true;
            ATIVA_BTN_SALVAR_PERFIL = true;
            ATIVA_BTN_CADASTRAR_PERFIL = true;
            return true;
        }

        if (idPermissao == Enum_Permissao.CONSULTAR_PERFIL.getCodigo()) {
            ATIVA_BTN_CONSULTAR_PERFIL = true;
            return true;
        }

        if (idPermissao == Enum_Permissao.DELETAR_PERFIL.getCodigo()) {
            ATIVA_BTN_DELETAR_PERFIL = true;
            return true;
        }
        return false;
    }

    /**
     * Acesso Usuario
     * @param idPermissao 
     */
    private boolean habilitaAcessoUsuario(long idPermissao) {

        if (idPermissao == Enum_Permissao.CADASTRAR_USUARIO.getCodigo()) {
            ATIVA_BTN_NOVO_USUARIO = true;
            ATIVA_BTN_SALVAR_USUARIO = true;
            ATIVA_BTN_CADASTRAR_USUARIO = true;
            return true;
        }

        if (idPermissao == Enum_Permissao.CONSULTAR_USUARIO.getCodigo()) {
            ATIVA_BTN_CONSULTAR_USUARIO = true;
            return true;
        }

        if (idPermissao == Enum_Permissao.DELETAR_USUARIO.getCodigo()) {
            ATIVA_BTN_DELETAR_USUARIO = true;
            return true;
        }
        return false;
    }

    /**
     * Acesso Pedido Venda
     * @param idPermissao 
     */
    private boolean habilitaAcessoPedidoVenda(long idPermissao) {

        if (idPermissao == Enum_Permissao.CADASTRAR_PEDIDO_VENDA.getCodigo()) {
            ATIVA_BTN_CADASTRAR_PEDIDO_VENDA = true;
            return true;
        }

        if (idPermissao == Enum_Permissao.CONSULTAR_PEDIDO_VENDA.getCodigo()) {
            ATIVA_BTN_CONSULTAR_PEDIDO_VENDA = true;
            return true;
        }

        return false;
    }

    /**
     * Acesso Pedido Compra
     * @param idPermissao 
     */
    private boolean habilitaAcessoPedidoCompra(long idPermissao) {

        if (idPermissao == Enum_Permissao.CADASTRAR_PEDIDO_COMPRA.getCodigo()) {
            ATIVA_BTN_CADASTRAR_PEDIDO_COMPRA = true;
            return true;
        }

        if (idPermissao == Enum_Permissao.CONSULTAR_PEDIDO_COMPRA.getCodigo()) {
            ATIVA_BTN_CONSULTAR_PEDIDO_COMPRA = true;
            return true;
        }

        return false;
    }

    /**
     * Acesso Prospeccao
     * @param idPermissao 
     */
    private boolean habilitaAcessoProspeccao(long idPermissao) {

        if (idPermissao == Enum_Permissao.CADASTRAR_PROSPECCAO.getCodigo()) {
            ATIVA_BTN_NOVO_PROSPECCAO = true;
            ATIVA_BTN_SALVAR_PROSPECCAO = true;
            ATIVA_BTN_CADASTRAR_PROSPECCAO = true;
            return true;
        }

        if (idPermissao == Enum_Permissao.CONSULTAR_PROSPECCAO.getCodigo()) {
            ATIVA_BTN_CONSULTAR_PROSPECCAO = true;
            return true;
        }

        if (idPermissao == Enum_Permissao.DELETAR_REVENDEDOR.getCodigo()) {
            ATIVA_BTN_DELETAR_PROSPECCAO = true;
            return true;
        }
        return false;
    }
    
    /**
     * Inicializa as variaveis de controle de acesso
     */
    private void initializerAcess(){
        //FORNECEDOR
        ATIVA_BTN_CADASTRAR_REVENDEDOR = false;
        ATIVA_BTN_CONSULTAR_REVENDEDOR = false;
        ATIVA_BTN_NOVO_REVENDEDOR = false;
        ATIVA_BTN_SALVAR_REVENDEDOR = false;
        ATIVA_BTN_DELETAR_REVENDEDOR = false;
        //PRODUTO
        ATIVA_BTN_CADASTRAR_PRODUTO = false;
        ATIVA_BTN_CONSULTAR_PRODUTO = false;
        ATIVA_BTN_NOVO_PRODUTO = false;
        ATIVA_BTN_SALVAR_PRODUTO = false;
        ATIVA_BTN_DELETAR_PRODUTO = false;
        //PERFIL
        ATIVA_BTN_CADASTRAR_PERFIL = false;
        ATIVA_BTN_CONSULTAR_PERFIL = false;
        ATIVA_BTN_NOVO_PERFIL = false;
        ATIVA_BTN_SALVAR_PERFIL = false;
        ATIVA_BTN_DELETAR_PERFIL = false;
        //USUARIO
        ATIVA_BTN_CADASTRAR_USUARIO = false;
        ATIVA_BTN_CONSULTAR_USUARIO = false;
        ATIVA_BTN_NOVO_USUARIO = false;
        ATIVA_BTN_SALVAR_USUARIO = false;
        ATIVA_BTN_DELETAR_USUARIO = false;
        //PEDIDO VENDA
        ATIVA_BTN_CADASTRAR_PEDIDO_VENDA = false;
        ATIVA_BTN_CONSULTAR_PEDIDO_VENDA = false;
        //PEDIDO COMPRA
        ATIVA_BTN_CADASTRAR_PEDIDO_COMPRA = false;
        ATIVA_BTN_CONSULTAR_PEDIDO_COMPRA = false;
        //PROSPECCAO
        ATIVA_BTN_CADASTRAR_PROSPECCAO = false;
        ATIVA_BTN_CONSULTAR_PROSPECCAO = false;
        ATIVA_BTN_NOVO_PROSPECCAO = false;
        ATIVA_BTN_SALVAR_PROSPECCAO = false;
        ATIVA_BTN_DELETAR_PROSPECCAO = false;
    }
}
