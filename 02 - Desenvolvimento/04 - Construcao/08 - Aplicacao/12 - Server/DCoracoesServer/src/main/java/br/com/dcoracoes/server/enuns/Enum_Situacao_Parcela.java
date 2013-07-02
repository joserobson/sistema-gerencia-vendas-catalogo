/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.enuns;

/**
 *
 * @author Robson
 */
public enum Enum_Situacao_Parcela {

    PENDENTE(71),
    QUITADA(72);
    private final int codigo;

    private Enum_Situacao_Parcela(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
