package com.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pojo.Student;
import com.sessionFac.MySessionFactory;

public class Test {
      public static void main(String[] args){
       testUniqueResult();
      }

	public static void testUniqueResult() {
		Session session=null;
		   Transaction t=null;
		   try{
			     session=MySessionFactory.getSessionFactory().openSession();
			     t=session.beginTransaction();
			     Student s=(Student)session.createQuery("from Student where sid=1").uniqueResult();
			     System.out.println(s.getSname());
			     t.commit();
		   }
		   catch(Exception e){
			   if(t!=null){
				   t.rollback();
			   }
		   }
		   finally{
			   if(session!=null){
				   session.close();
			   }
			    
		  }
	}

	public static void query2() {
		   Session session=null;
    	   Transaction t=null;
    	   try{
    		     session=MySessionFactory.getSessionFactory().openSession();
    		     t=session.beginTransaction();
    		     List<Student> list=session.createQuery("from Student").list();
    		     for(Student s:list){
    		    	 System.out.println(s.getSname()+"ѡ��"+s.getStudcourses().size()+"�ſ�");
    		    	
    		     }
    		     
    	   }
    	   catch(Exception e){
    		   if(t!=null){
    			   t.rollback();
    		   }
    	   }
    	   finally{
    		   if(session!=null){
    			   session.close();
    		   }
    	   }
	}

	public static void query1() {
		Session session=null;
		Transaction t=null;
		try{
			session=MySessionFactory.getSessionFactory().openSession();
			t=session.beginTransaction();
			//����������ѧ��
			List<Student> list=session.createQuery("from Student").list();
			//1.ʹ��forѭ�� ȡ��ѧ����Ϣ
			for(Student c:list){
				System.out.println(c.getSname()+" "+c.getAadress());
			}
			System.out.println("*********");
			//2 ʹ�õ�����ѭ��ȡ��ѧ����Ϣ
			Iterator<Student> ite=list.iterator();
			while(ite.hasNext()){
				Student stu=ite.next();
				System.out.println(stu.getSname()+" "+stu.getAadress());
			}
			t.commit();
		}
		catch(Exception e){
			if(t!=null){
				t.rollback();
			}
		}
		finally{
			if(session!=null){
				session.close();
			}
		}
	}
}
