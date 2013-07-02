package br.com.dcoracoes.server.enuns;

/**
 * @author robson
 * @version 1.0
 * @created 06-mar-2012 18:43:31
 */
public enum Enum_TipoTelefone {

    RESIDENCIAL(11),
    COMERCIAL(12),
    CELULAR(13);
    private final int codigo;

    private Enum_TipoTelefone(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo()
    {
        return this.codigo;
    }
}
