/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.servico.beans.relatorio;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Robson
 */
public class ModelRelatorioPedidoRevendedor implements Serializable {
    
    private Date dataPedidoInicio;
    private Date dataPedidoFim;
    private String codigoRevendedor;

    public String getCodigoRevendedor() {
        return codigoRevendedor;
    }

    public void setCodigoRevendedor(String codigoRevendedor) {
        this.codigoRevendedor = codigoRevendedor;
    }

    public Date getDataPedidoFim() {
        return dataPedidoFim;
    }

    public void setDataPedidoFim(Date dataPedidoFim) {
        this.dataPedidoFim = dataPedidoFim;
    }

    public Date getDataPedidoInicio() {
        return dataPedidoInicio;
    }

    public void setDataPedidoInicio(Date dataPedidoInicio) {
        this.dataPedidoInicio = dataPedidoInicio;
    }
}
