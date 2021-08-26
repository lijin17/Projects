/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.dao;

import com.neu.pojo.Bed;
import com.neu.pojo.BodyStatus;
import com.neu.pojo.Elder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author lijin
 */
public class BodyStatusDao {

    private SessionFactory sessionFactory;
    private static Session session;

    protected SessionFactory setUp() throws Exception {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();
        try {
            this.sessionFactory = configuration.buildSessionFactory(registry);

        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }

        return sessionFactory;
    }

    public Session getSession() throws Exception {
        if (session == null) {
            session = setUp().openSession();
        }
        return session;
    }

    private void beginTransaction() throws Exception {
        getSession().beginTransaction();
    }

    private void commit() throws Exception {
        getSession().getTransaction().commit();;
    }

    private void close() throws Exception {
        getSession().close();
    }

    private void rollbackTransaction() throws Exception {
        getSession().getTransaction().rollback();
    }

    public List<BodyStatus> getAllBodyStatus(int elderid) {
        List<BodyStatus> bs = new ArrayList<>();
        int result=0;
        try {
            beginTransaction();
            String id=String.valueOf(elderid);
            Session session = getSession();
            Query q = session.createQuery("FROM BodyStatus WHERE elderid = ?");
            q.setParameter(0, elderid);
            String s = q.toString();
            bs = q.list();
            System.out.println(q.toString());
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            try {
                rollbackTransaction();
            } catch (Exception ex) {
                Logger.getLogger(BodyStatusDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(BodyStatusDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                //close();
            } catch (Exception ex) {
                Logger.getLogger(BodyStatusDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return bs;
    }


    public int addBodyStatus(String HR, String SP, String DP, String SPO2, String TE, String RE, Elder elder) {
        int result = 0;
        try {
            beginTransaction();
            BodyStatus bs=new BodyStatus();
            bs.setHR(HR);
            bs.setSP(SP);
            bs.setDP(DP);
            bs.setSPO2(SPO2);
            bs.setTE(TE);
            bs.setRE(RE);
            bs.setElder(elder);
            Date now=new Date();
            SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String s=dateFormat.format(now);
            bs.setT(s);
            Session session = getSession();
            session.save(bs);
            commit();
            result = 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            try {
                rollbackTransaction();
            } catch (Exception ex) {
                Logger.getLogger(BodyStatusDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(BodyStatusDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                //close();
            } catch (Exception ex) {
                Logger.getLogger(BodyStatusDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return result;
    }

}
