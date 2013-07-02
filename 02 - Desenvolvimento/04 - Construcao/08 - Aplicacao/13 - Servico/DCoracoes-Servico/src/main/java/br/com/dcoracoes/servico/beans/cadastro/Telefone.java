package br.com.dcoracoes.servico.beans.cadastro;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * @author Jose Robson
 * @version 1.0 @created 06-mar-2012 18:42:30
 */
public class Telefone implements Serializable {

    private Long id;
    private String numero;
    private String operadora;
    private int tipoTelefone;

    public Telefone() {
        this.numero = null;
        this.operadora = null;
        this.tipoTelefone = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    public int getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(int tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }
}
