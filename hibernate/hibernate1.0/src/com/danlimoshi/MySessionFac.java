package com.danlimoshi;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

final public class MySessionFac {//���ܼ̳и���
	
	 private static SessionFactory sessionFactory=null;
     private MySessionFac(){
    	 
     }
     static{      //����ģʽ����ֻ֤��һ���Ự����
    	 sessionFactory=new Configuration().configure().buildSessionFactory();
     }
     public static SessionFactory getSessionFactory(){
    	 return sessionFactory;
     }
}
