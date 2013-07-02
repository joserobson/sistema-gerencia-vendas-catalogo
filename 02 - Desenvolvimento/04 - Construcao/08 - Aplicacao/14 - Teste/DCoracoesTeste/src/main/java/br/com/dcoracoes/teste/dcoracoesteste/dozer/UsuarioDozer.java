/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.teste.dcoracoesteste.dozer;

import br.com.dcoracoes.teste.dcoracoes.beans.Pessoa;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;

/**
 *
 * @author Jose Robson
 */
public class UsuarioDozer {
    protected Mapper mapper = null;
    
    public void UsuarioDozer()
    {
        this.mapper = DozerBeanMapperSingletonWrapper.getInstance();
    }   

    public void convertBeanParaModel()
    {
        Pessoa pessoaBean = new Pessoa();
        pessoaBean.setId(Long.MIN_VALUE);
        pessoaBean.setNome("JOSE");
        
        
        br.com.dcoracoes.server.model.cadastro.Pessoa pessoaModel;
    }
    
    
    public void convertModelParaBean()
    {
        
    }
}
