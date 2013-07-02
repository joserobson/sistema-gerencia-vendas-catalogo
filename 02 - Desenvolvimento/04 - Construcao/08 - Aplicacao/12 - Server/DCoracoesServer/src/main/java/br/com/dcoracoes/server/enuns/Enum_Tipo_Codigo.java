/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.enuns;

/**
 *
 * @author Robson
 */
public enum Enum_Tipo_Codigo {

    REFERENCIA_CATALOGO(81),
    CODIGO_PROFISCAL(82),
    CODIGO_FORNECEDOR(83),
    CODIGO_FORFISCAL(84),
    CODIGO_BARRAS(85);
    private final int codigo;

    private Enum_Tipo_Codigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return this.codigo;
    }
}
