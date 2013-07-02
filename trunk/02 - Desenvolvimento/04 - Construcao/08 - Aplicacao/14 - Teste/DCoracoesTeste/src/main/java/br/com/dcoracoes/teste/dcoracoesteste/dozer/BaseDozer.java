/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.teste.dcoracoesteste.dozer;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;

/**
 *
 * @author Jose Robson
 */
public abstract class BaseDozer implements IBaseDozer {

    protected Mapper mapper = null;

    public BaseDozer() {
        System.out.println("=============INICIO CONVERSAO====================");
        this.mapper = DozerBeanMapperSingletonWrapper.getInstance();
    }

    @Override
    public void convertBeanParaModel() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void convertModelParaBean() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object getBean() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object getModel() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void isConvertOk(Object model) {
        if (model == null)
            System.out.println("ERRO AO CONVERVER: " + model.getClass().getName());
        else
            System.out.println("CONVERTIDO COM SUCESSO: " + model.getClass().getName());
    }
}
