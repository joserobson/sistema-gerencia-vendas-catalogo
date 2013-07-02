package br.com.dcoracoes.server.model.movimento;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author Jose Robson
 * @version 1.0
 * @created 06-mar-2012 18:43:14
 */
@Entity
@Table(name = "tb_movimento_financeiro")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "classe_name", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("MovimentoFinanceiro")
public class MovimentoFinanceiro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public MovimentoFinanceiro() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
}
