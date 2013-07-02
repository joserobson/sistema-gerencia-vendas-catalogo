/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.util;

/**
 *
 * @author Robson
 */
public class ServerUtil {
    
    /**
     * METODO USADO PARA MONTAR CONSULTA HQL NO SERVER
     * @param useWhere
     * @return 
     */
    public static String getClausulaSql(boolean useWhere) {
        StringBuilder hql = new StringBuilder();
        if (useWhere) {
            hql.append(" ").append("WHERE").append(" ");
        } else {
            hql.append(" ").append("AND").append(" ");
        }
        return hql.toString();
    }
}
