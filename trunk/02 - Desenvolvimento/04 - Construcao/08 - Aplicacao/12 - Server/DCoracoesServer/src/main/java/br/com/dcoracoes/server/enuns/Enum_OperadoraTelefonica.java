/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dcoracoes.server.enuns;

/**
 *
 * @author Robson
 */
public enum Enum_OperadoraTelefonica {
    Vivo(1),
    Tim(2),
    Claro(3),
    Oi(4);

    private final int codigo;

    private Enum_OperadoraTelefonica(int codigo) {
        this.codigo = codigo;
    }



}
