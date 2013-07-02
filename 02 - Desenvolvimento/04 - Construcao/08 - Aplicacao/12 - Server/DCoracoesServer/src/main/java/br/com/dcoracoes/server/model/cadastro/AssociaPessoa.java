package br.com.dcoracoes.server.model.cadastro;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author Jose Robson
 * @version 1.0
 * @created 06-mar-2012 18:42:24
 */
@Entity
@Table(name="tb_associa_pessoa")
public class AssociaPessoa implements Serializable {    

    @EmbeddedId
    private AssociaPessoaFK chaveComposta;

    @Column(name="grau_associacao")
    private String grauParentesco;

    public AssociaPessoa() {
        super();                
        this.grauParentesco = null;
    }          

    public String getGrauParentesco() {
        return grauParentesco;
    }

    public void setGrauParentesco(String grauParentesco) {
        this.grauParentesco = grauParentesco;
    }

    public AssociaPessoaFK getChaveComposta() {
        return chaveComposta;
    }

    public void setChaveComposta(AssociaPessoaFK chaveComposta) {
        this.chaveComposta = chaveComposta;
    }   

    
}
