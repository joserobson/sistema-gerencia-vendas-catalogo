/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.enuns;

/**
 *
 * @author Robson
 */
public enum Enum_Situacao_Alerta {
    
    RESOLVIDO(51),
    EMABERTO(52);
    private final int codigo;

    private Enum_Situacao_Alerta(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo()
    {
        return this.codigo;
    }
}
