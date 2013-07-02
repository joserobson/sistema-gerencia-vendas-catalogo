/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.server.util;

import java.util.Date;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Robson
 */
public class HibernateUtil {

    private static SessionFactory factory;
    private static Transaction transacao;
    private static Session sessao;

    static {
        try {
            Configuration conf = new AnnotationConfiguration();
            factory = conf.configure().buildSessionFactory();
        } catch (HibernateException ex) {            
            Logger log = Logger.getLogger(HibernateUtil.class);
            log.error(new Date() + " - ERRO: " + ex.getMessage());
            factory = null;
            LogUtil.logDescricaoErro(HibernateUtil.class, ex.getMessage(), ex);
            throw ex;
        }
    }

    public static void setSession()
    {
        sessao = factory.openSession();
    }

    public static Session getSession() {
        return sessao;
    }

    public static void setTransacao() {
        if (getSession() != null) {
            if (transacao != null) {
                transacao = null;
            }
            transacao = getSession().beginTransaction();
        }
    }

    public static Transaction getTransacao() {
        return transacao;
    }
}
