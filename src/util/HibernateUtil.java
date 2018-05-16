/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author aluno
 */
public class HibernateUtil {
    
    private static SessionFactory sessionFactory;
    
    static{
        try{
            Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
            StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
            sb.applySettings(cfg.getProperties());
            StandardServiceRegistry stan = sb.build();
            sessionFactory = cfg.buildSessionFactory(stan);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
}
    
}
