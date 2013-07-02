/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.enuns;

/**
 *
 * @author Cléberson
 */
public enum Enum_Forma_Pagamento {
    AVISTA (61,"A Vista"),
    APRAZO (62,"A Prazo"),
    APRAZOCOMCOMPLEMENTO (63,"A Prazo Comp.");

    private final int tipo;
    private final String formaPagamento;

    private Enum_Forma_Pagamento(int tipo, String formaPagamento) {
        this.tipo = tipo;
        this.formaPagamento = formaPagamento;
    }

    public int getTipo() {
        return tipo;
    }

    public String getFormaPagamento()
    {
        return this.formaPagamento;
    }
    
    public static Enum_Forma_Pagamento getType(String tipo){
        if(Enum_Forma_Pagamento.AVISTA.getFormaPagamento().equals(tipo))
            return Enum_Forma_Pagamento.AVISTA;
        if(Enum_Forma_Pagamento.APRAZO.getFormaPagamento().equals(tipo))
            return Enum_Forma_Pagamento.APRAZO;
        return Enum_Forma_Pagamento.APRAZOCOMCOMPLEMENTO;
    }
    
    public static int getByte(int tipo){
        if(Enum_Forma_Pagamento.AVISTA.getTipo() == tipo)
            return 0;
        if(Enum_Forma_Pagamento.APRAZO.getTipo() == tipo)
            return 1;
        return 2    ;
    }
}
