/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.teste.dcoracoesteste.dozer;

import br.com.dcoracoes.teste.dcoracoes.beans.Endereco;
import br.com.dcoracoes.teste.dcoracoes.beans.Pessoa;
import org.dozer.Mapper;

/**
 *
 * @author Jose Robson
 */
public class PessoaDozer extends BaseDozer{

    protected Mapper mapper = null;

    public PessoaDozer() {
        super();
    }

    public void convertBeanParaModel() {
        
        br.com.dcoracoes.server.model.cadastro.Pessoa pessoaModel = null;        
                
        try {
            Pessoa pessoaBean = new Pessoa();            
            pessoaBean.setId(Long.MIN_VALUE);
            pessoaBean.setNome("JOSE");
            
            Endereco enderecoModel = new Endereco();
            enderecoModel.setId(Long.MAX_VALUE);
            enderecoModel.setCep("354645646");
            enderecoModel.setRua("123");

            pessoaBean.setEndereco(enderecoModel);

            pessoaModel = this.mapper.map(pessoaBean, br.com.dcoracoes.server.model.cadastro.Pessoa.class);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        if (pessoaModel != null)
        {
            System.out.println("CONVERTIDO COM SUCESSO!!!");
        }
    }

    public void convertModelParaBean() {
    }
}
