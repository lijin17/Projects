/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.dao;

import com.neu.pojo.Bed;
import com.neu.pojo.Elder;
import com.neu.pojo.Movie;
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
public class ElderDao {

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

    public List<Elder> getElders(int searchid, String searchType) {
        List<Elder> elders = new ArrayList<>();
        try {
            beginTransaction();
            Session session = getSession();
            Query q = session.createQuery("FROM Elder WHERE " + searchType + " = ?");
            q.setParameter(0, searchid);
            String s = q.toString();
            elders = q.list();
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
        return elders;
    }

    public List<Elder> getAllElders() {
        List<Elder> elders = new ArrayList<>();
        try {
            beginTransaction();
            Session session = getSession();
            Query q = session.createQuery("FROM Elder");
            String s = q.toString();
            elders = q.list();
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
        return elders;
    }

    public int ModifyElder(int id, String name, String phoneNum, String address, String password, String gender, String brithday) {
        int result = 0;
        try {
            Elder elder = getElders(id, "id").get(0);
            elder.setName(name);
            elder.setPhoneNum(phoneNum);
            elder.setBirthday(brithday);
            elder.setGender(gender);
            elder.setAddress(address);
            elder.setPassword(password);
            Bed bed = new Bed();
            bed.setStatus("using");
            elder.setBed(bed);
            beginTransaction();

            Session session = getSession();
            session.save(elder);
            commit();
            result = 1;
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

    public int deleteElders(int id) {
        int result = 0;
        try {
            Transaction trans = session.beginTransaction();
            Elder elder = (Elder)session.get(Elder.class, id);            
            session.delete(elder);
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

    public int addElder(String name, String phoneNum, String address, String password, String gender, String brithday) {
        int result = 0;
        try {
            Elder elder = new Elder();
            elder.setName(name);
            elder.setPhoneNum(phoneNum);
            elder.setBirthday(brithday);
            elder.setGender(gender);
            elder.setAddress(address);
            elder.setPassword(password);
            Bed bed = new Bed();
            bed.setStatus("using");
            elder.setBed(bed);
            beginTransaction();

            Session session = getSession();
            session.save(elder);
            commit();
            result = 1;
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

}
