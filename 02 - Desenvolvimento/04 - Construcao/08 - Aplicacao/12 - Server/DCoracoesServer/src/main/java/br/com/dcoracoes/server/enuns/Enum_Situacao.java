package br.com.dcoracoes.server.enuns;

/**
 * @author robson
 * @version 1.0
 * @created 06-mar-2012 18:43:30
 */
public enum Enum_Situacao {

    ATIVO(21),
    INATIVO(22);
    private final int codigo;

    private Enum_Situacao(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo()
    {
        return this.codigo;
    }
}
