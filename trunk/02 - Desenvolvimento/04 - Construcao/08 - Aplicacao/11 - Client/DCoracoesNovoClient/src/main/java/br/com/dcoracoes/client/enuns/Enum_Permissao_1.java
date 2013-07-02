/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.enuns;

/**
 *
 * @author Robson
 */
public enum Enum_Permissao_1 {

    CADASTRAR_REVENDEDOR(1),
    CONSULTAR_REVENDEDOR(2),
    DELETAR_REVENDEDOR(3),
    
    CADASTRAR_PRODUTO(4),
    CONSULTAR_PRODUTO(5),
    DELETAR_PRODUTO(6),
    
    CADASTRAR_PERFIL(7),
    CONSULTAR_PERFIL(8),
    DELETAR_PERFIL(9),
        
    CADASTRAR_USUARIO(10),
    CONSULTAR_USUARIO(11),
    DELETAR_USUARIO(12),
    
    CADASTRAR_PEDIDO_VENDA(13),
    CONSULTAR_PEDIDO_VENDA(14),
    
    CADASTRAR_PEDIDO_COMPRA(15),
    CONSULTAR_PEDIDO_COMPRA(16),
    
    CADASTRAR_PROSPECCAO(17),
    CONSULTAR_PROSPECCAO(18),
    DELETAR_PROSPECCAO(19);
    
    private final int codigo;

    private Enum_Permissao_1(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
