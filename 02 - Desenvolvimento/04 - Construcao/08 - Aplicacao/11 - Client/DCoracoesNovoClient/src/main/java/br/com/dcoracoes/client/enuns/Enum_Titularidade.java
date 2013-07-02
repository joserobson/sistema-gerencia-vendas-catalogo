/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dcoracoes.client.enuns;

/**
 *
 * @author Robson
 */
public enum Enum_Titularidade {

    PRIMEIRO(41),
    SEGUNDO(42);
    private final int codigo;

    private Enum_Titularidade(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo()
    {
        return this.codigo;
    }
}
