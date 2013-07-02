/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.enuns;

/**
 *
 * @author Robson
 */
public enum Enum_GrauParentesco {

    Marido(1),
    Esposa(2),
    Filho(3),
    Irmao(4),
    Pai(5),
    Mae(6);
    private final int codigo;

    private Enum_GrauParentesco(int codigo) {
        this.codigo = codigo;
    }
}
