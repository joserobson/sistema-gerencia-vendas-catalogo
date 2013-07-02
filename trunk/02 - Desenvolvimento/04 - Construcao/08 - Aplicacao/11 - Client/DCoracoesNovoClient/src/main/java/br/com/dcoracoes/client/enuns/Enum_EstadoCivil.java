package br.com.dcoracoes.client.enuns;

/**
 * @author robson
 * @version 1.0
 * @created 06-mar-2012 18:43:30
 */
public enum Enum_EstadoCivil {
	CASADO (31),
	SOLTEIRO (32),
	SEPARADO (33),
	DIVORCIADO(34),
        UNIAOESTAVEL(35);

    private final int codigo;

    private Enum_EstadoCivil(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo()
    {
        return this.codigo;
    }
    
}