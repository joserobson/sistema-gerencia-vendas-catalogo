package br.com.dcoracoes.servico.beans.cadastro;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * @author robson
 * @version 1.0 @created 06-mar-2012 18:42:26
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Email implements Serializable {

    private Long id;
    private String enderecoEmail;    

    public Email() {
        super();
        this.enderecoEmail = null;        
    }

    public String getEnderecoEmail() {
        return enderecoEmail;
    }

    public void setEnderecoEmail(String enderecoEmail) {
        this.enderecoEmail = enderecoEmail;
    }
   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
