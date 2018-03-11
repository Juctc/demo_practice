package com.sessionFac;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


final public class MySessionFactory {
         private MySessionFactory(){
        	 
         }
         private static SessionFactory sessionFactory=null;
        
         //����ģʽ����Ϊ�Ự������һ�����������࣬�ķ��ڴ棬���Ա�ֻ֤��һ���Ự����
         static{            
        	sessionFactory= new Configuration().configure().buildSessionFactory();
         }
         public static SessionFactory getSessionFactory(){
        	  return sessionFactory;
         }
}
