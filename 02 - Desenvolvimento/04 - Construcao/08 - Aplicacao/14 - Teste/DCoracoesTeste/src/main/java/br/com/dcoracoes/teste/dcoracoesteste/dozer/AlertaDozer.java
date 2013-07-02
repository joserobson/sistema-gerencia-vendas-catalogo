/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.teste.dcoracoesteste.dozer;

import br.com.dcoracoes.teste.dcoracoes.beans.Alerta;
import java.util.Date;

/**
 *
 * @author Jose Robson
 */
public class AlertaDozer extends BaseDozer{

    @Override
    public void convertBeanParaModel() {
        
        br.com.dcoracoes.server.model.prospeccao.Alerta model = null;
        
        try
        {
            Alerta alertaBean = (Alerta) getBean();
            model = this.mapper.map(alertaBean,br.com.dcoracoes.server.model.prospeccao.Alerta.class);
            
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        isConvertOk(model);
    }

    @Override
    public void convertModelParaBean() {
        
        Alerta bean = null;
        
        try
        {
            br.com.dcoracoes.server.model.prospeccao.Alerta model = 
                    (br.com.dcoracoes.server.model.prospeccao.Alerta) getModel();
            bean = this.mapper.map(model,Alerta.class);
            
            
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        isConvertOk(bean);
    }

    @Override
    public Object getBean() {
        Alerta alertaBean = new Alerta();
        alertaBean.setId(Long.MIN_VALUE);
        alertaBean.setAssunto("TESTE");
        alertaBean.setDescricao("TESTE");
        alertaBean.setProtocolo("123123");
        alertaBean.setSituacaoAlerta(1);
        alertaBean.setDataAlerta(new Date());
        
        alertaBean.setPessoa(UtilDozer.getPessoaFisicaBean());                        
        alertaBean.setAtendente(UtilDozer.getUsuarioBean());
        
        return alertaBean;
    }

    @Override
    public Object getModel() {
        
        br.com.dcoracoes.server.model.prospeccao.Alerta alertaModel = new 
                br.com.dcoracoes.server.model.prospeccao.Alerta();
        
        alertaModel.setId(Long.MIN_VALUE);
        alertaModel.setAssunto("TESTE");
        alertaModel.setDescricao("TESTE");
        alertaModel.setProtocolo("123123");
        alertaModel.setSituacaoAlerta(1);
        alertaModel.setDataAlerta(new Date());
        
        alertaModel.setPessoa(UtilDozer.getPessoaFisicaModel());                        
        alertaModel.setAtendente(UtilDozer.getUsuarioModel());
        
        return alertaModel;
    }

    
    
    
    
}
