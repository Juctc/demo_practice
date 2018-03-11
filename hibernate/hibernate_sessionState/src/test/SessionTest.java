package test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import orm.HibernateSessionFactory;
import orm.Hibernate_sessionState_table;

public class SessionTest {
     @Test
     public void test1(){
    	 Session session=null;
    	 Transaction t=null;
    	 Hibernate_sessionState_table h=null;
    	 try{
    		 session=HibernateSessionFactory.getSession();
    		 t=session.beginTransaction();
    		 //˲ʱ̬��
    		 h=new Hibernate_sessionState_table();
    		 h.setName("����");
    		 h.setPasswd("123");
    		 h.setDate(new Date());
    		 //�־�̬
    		 session.save(h);
    		 
    		 h.setName("����");
    		 t.commit();
    	 }
    	 catch(Exception e){
    		  e.printStackTrace();
    		  t.rollback();
    	 }
    	 finally{
    		  if(session.isOpen()){
    			   session.close();
    		  }
    	 }
     }
}
