/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.teste.dcoracoesteste.dozer;

/**
 *
 * @author Jose Robson
 */
interface IBaseDozer {

    public void convertBeanParaModel();
    
    public void convertModelParaBean();
    
    public Object getBean();
    
    public Object getModel();
}
