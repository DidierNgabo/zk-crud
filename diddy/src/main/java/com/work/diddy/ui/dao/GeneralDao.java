package com.work.diddy.ui.dao;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.work.diddy.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author diddy
 */
public class GeneralDao<X> {
    Class<X> type;

    public GeneralDao(Class<X> type) {
        this.type = type;
    }
    
    public void create(X obj){
     Session ss = DbUtil.getSessionFactory().openSession();
     ss.beginTransaction();
     ss.save(obj);
     ss.getTransaction().commit();
     ss.close();
     
    }
    
    public String update(X obj){
     Session ss = DbUtil.getSessionFactory().openSession();
     ss.beginTransaction();
     ss.update(obj);
     ss.getTransaction().commit();
     ss.close();
     return "successfully updated";
    }
    
    public List<X> findAll(){
       Session ss = DbUtil.getSessionFactory().openSession();
       Transaction tr = ss.beginTransaction();
       List<X> list = ss.createQuery("from "+ type.getName()).list();
       ss.close();
       return list;
       
    }
    
    public X findById(int id){
     Session ss = DbUtil.getSessionFactory().openSession();
     X item = (X) ss.get(type.getName(), id);
      ss.close();
     return item;
    }
    
    public X findByName(String name){
     Session ss = DbUtil.getSessionFactory().openSession();
     X item = (X) ss.get(type.getName(), name);
      ss.close();
     return item;
    }
    
    public void delete(int id){
     Session ss = DbUtil.getSessionFactory().openSession();
     ss.beginTransaction();
     X item = (X) ss.get(type.getName(), id);
     ss.delete(item);
     ss.getTransaction().commit();
     ss.close();
    
    }
}
