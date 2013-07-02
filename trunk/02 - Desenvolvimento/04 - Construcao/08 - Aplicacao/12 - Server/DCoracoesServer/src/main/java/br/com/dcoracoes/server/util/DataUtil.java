/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.util;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Robson
 */
public class DataUtil {

    /** Método que retorna uma data incial para uma consulta HQL, usando na clásula between  
     * para obter os resultados corretos por conta dos campos do tipo datetime. 
     * @param data 
     * @return retorna a dataInicial preenchiada com horário default para consulta  
     */
    public static Date getDataInicial(Date data) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    /** 
     * Método que retorna uma data final para uma consulta HQL, usando na clásula between  
     * para obter os resultados corretos por conta dos campos do tipo datetime. 
     * @param data 
     * @return retorna a dataFinal preenchiada com horário default para consulta 
     */
    public static Date getDataFinal(Date data) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }
}
