/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.dao;

import com.neu.pojo.Administrator;
import com.neu.pojo.NursingWorker;
import java.util.ArrayList;
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
public class NursingWorkerDao {
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

    public List<NursingWorker> getNursing(int searchid, String searchType) {
        List<NursingWorker> ns = new ArrayList<>();
        try {
            beginTransaction();
            Session session = getSession();
            Query q = session.createQuery("FROM NursingWorker WHERE "+searchType+"= ?");
            q.setParameter(0, searchid);
            String s=q.toString();           
            ns = q.list();
            System.out.println(q.toString());
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            try {
                rollbackTransaction();
            } catch (Exception ex) {
                Logger.getLogger(NursingWorkerDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(NursingWorkerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                //close();
            } catch (Exception ex) {
                Logger.getLogger(NursingWorkerDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ns;
    }
    
    public int deleteNurse(int id) {
        int result = 0;
        try {
            Transaction trans = session.beginTransaction();
            NursingWorker ns = (NursingWorker)session.get(NursingWorker.class, id);            
            session.delete(ns);
            trans.commit();
            result=1;
        } catch (HibernateException e) {
            e.printStackTrace();
            try {
                rollbackTransaction();
            } catch (Exception ex) {
                Logger.getLogger(ElderDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(ElderDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                //close();
            } catch (Exception ex) {
                Logger.getLogger(ElderDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public List<NursingWorker> getAllNursingWorkers() {
        List<NursingWorker> ns = new ArrayList<>();
        try {
            beginTransaction();
            Session session = getSession();
            Query q = session.createQuery("FROM NursingWorker");
            String s=q.toString();           
            ns = q.list();
            System.out.println(q.toString());
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            try {
                rollbackTransaction();
            } catch (Exception ex) {
                Logger.getLogger(ElderDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(ElderDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                //close();
            } catch (Exception ex) {
                Logger.getLogger(ElderDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ns;
    }
    
    public int addWoker(String name, String phoneNum, String address, String password, String gender, String email,String type) {
        int result = 0;
        try {
            NursingWorker ns=new NursingWorker();
            ns.setName(name);
            ns.setPhoneNum(phoneNum);
            ns.setAddress(address);
            ns.setEmail(email);
            ns.setPassword(password);
            ns.setGender(gender);
            ns.setType(type);
            
            beginTransaction();
            
            Session session = getSession();
            session.save(ns);
            commit();
            result = 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            try {
                rollbackTransaction();
            } catch (Exception ex) {
                Logger.getLogger(NursingWorkerDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(NursingWorkerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                //close();
            } catch (Exception ex) {
                Logger.getLogger(NursingWorkerDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return result;
    }

}
