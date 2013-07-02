/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.enuns;

/**
 * FORMAS DE PAGAMENTO DE UM PEDIDO
 * PARTICULARES PARA O SISTEMA
 * @author Robson
 */
public enum Enum_Forma_Pagamento {

    AVISTA(61),
    APRAZO(62), // COM¨60 ou 90 dias
    APRAZOCOMCOMPLEMENTO(63);// REVENDEDOR COMPLEMENTO PAGAMENTO COM DINHEIRO CASO SEU CRÉDITO NÃO COBRA.
    private final int codigo;

    private Enum_Forma_Pagamento(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
