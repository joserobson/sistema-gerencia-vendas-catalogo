/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.enuns;

/**
 *
 * @author Cléberson
 */
public enum Enum_UF_1 {
    selecione ("selecione"),
    AC ("AC"),
    AL ("AL"),
    AM ("AM"),
    AP ("AP"),
    BA ("BA"),
    CE ("CE"),
    DF ("DF"),
    ES ("ES"),
    GO ("GO"),
    MA ("MA"),
    MG ("MG"),
    MS ("MS"),
    MT ("MT"),
    PA ("PA"),
    PB ("PB"),
    PE ("PE"),
    PI ("PI"),
    PR ("PR"),
    RJ ("RJ"),
    RN ("RN"),
    RO ("RO"),
    RR ("RR"),
    RS ("RS"),
    SC ("SC"),
    SE ("SE"),
    SP ("SP"),
    TO ("TO");

    private final String estado;

    private Enum_UF_1(String estado) {
        this.estado = estado;
    }

    public String getEstado()
    {
        return this.estado;
    }
    
    public static Enum_UF getType(String estado){
        if(Enum_UF.AC.getEstado().equals(estado))
            return Enum_UF.AC;
        if(Enum_UF.AL.getEstado().equals(estado))
            return Enum_UF.AL;
        if(Enum_UF.AM.getEstado().equals(estado))
            return Enum_UF.AM;
        if(Enum_UF.AP.getEstado().equals(estado))
            return Enum_UF.AP;
        if(Enum_UF.BA.getEstado().equals(estado))
            return Enum_UF.BA;
        if(Enum_UF.CE.getEstado().equals(estado))
            return Enum_UF.CE;
        if(Enum_UF.DF.getEstado().equals(estado))
            return Enum_UF.DF;
        if(Enum_UF.ES.getEstado().equals(estado))
            return Enum_UF.ES;        
        if(Enum_UF.GO.getEstado().equals(estado))
            return Enum_UF.GO;
        if(Enum_UF.MA.getEstado().equals(estado))
            return Enum_UF.MA;
        if(Enum_UF.MG.getEstado().equals(estado))
            return Enum_UF.MG;
        if(Enum_UF.MS.getEstado().equals(estado))
            return Enum_UF.MS;
        if(Enum_UF.MT.getEstado().equals(estado))
            return Enum_UF.MT;
        if(Enum_UF.PA.getEstado().equals(estado))
            return Enum_UF.PA;
        if(Enum_UF.PB.getEstado().equals(estado))
            return Enum_UF.PB;
        if(Enum_UF.PE.getEstado().equals(estado))
            return Enum_UF.PE;        
        if(Enum_UF.PI.getEstado().equals(estado))
            return Enum_UF.PI;
        if(Enum_UF.PR.getEstado().equals(estado))
            return Enum_UF.PR;
        if(Enum_UF.RJ.getEstado().equals(estado))
            return Enum_UF.RJ;
        if(Enum_UF.RN.getEstado().equals(estado))
            return Enum_UF.RN;
        if(Enum_UF.RO.getEstado().equals(estado))
            return Enum_UF.RO;
        if(Enum_UF.RR.getEstado().equals(estado))
            return Enum_UF.RR;
        if(Enum_UF.RS.getEstado().equals(estado))
            return Enum_UF.RS;
        if(Enum_UF.SC.getEstado().equals(estado))
            return Enum_UF.SC;
        if(Enum_UF.SE.getEstado().equals(estado))
            return Enum_UF.SE;
        if(Enum_UF.SP.getEstado().equals(estado))
            return Enum_UF.SP;
        if(Enum_UF.TO.getEstado().equals(estado))
            return Enum_UF.TO;
        
        return Enum_UF.selecione;
    }
}
