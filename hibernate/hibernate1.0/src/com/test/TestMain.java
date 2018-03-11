package com.test;
import com.danlimoshi.*;

import java.util.Date;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.*;

import com.danlimoshi.MySessionFac;
import com.domain.Employee;
public class TestMain {
     public static void main(String[] agrs){
         
          
    	 addEmployee() ;
    	 
    	 
     }
     
	public static void testQuery() {
		Session session=MySessionFac.getSessionFactory().getCurrentSession();
          Transaction T=null;
          try{
        	   T=session.beginTransaction();
        	   Query query=session.createQuery("from Employee where id=3");//hql���
        	   List<Employee> list =query.list();
        	   for(Employee cc:list){
        		   System.out.println(cc.getId());
        	   }
        	   T.commit();
          }
          catch(Exception e){
        	  if(T!=null){
        		  T.rollback();
        	  }
          }
          finally{
        	  session.close();
        	  
          }
	}
	public static void testOpenSessionAndCurrentSession() {
		  Session s1=MySessionFac.getSessionFactory().getCurrentSession();
          Session s2=MySessionFac.getSessionFactory().getCurrentSession();
          System.out.println("s1:"+s1.hashCode()+" "+"s2:"+s2.hashCode());
          s1.close();
          //s2.close();
	
	}
	public static void deleteEmployee() {
		//ɾ���û�
    	  Session session=MySessionFac.getSessionFactory().openSession();
    	  Transaction T=session.beginTransaction();
    	  Employee emp=(Employee) session.load(Employee.class, 2);
    	  session.delete(emp);
    	  T.commit();
    	  session.close();
	}

	public static void updateEmployee() {    //�޸��û�
		//ģ��
		//��ȡһ���Ự
		  Session session=MySessionFac.getSessionFactory().openSession();
		 //ʹ�������ύ
    	  Transaction T=null;
    	 //��ȡһ������ʵ��
    	 try{
         T=session.beginTransaction();
    	 Employee emp=(Employee)session.load(Employee.class, 2); //select * from employee where id=?
    	 emp.setName("haha12");
    	   int i=4/0;
    	 T.commit();
    	 }
    	catch(Exception e){
    	if(T!=null){
    		T.rollback();
    	}
    	   System.out.println("�����쳣"); 
    	}
    	 finally{
    		 session.close();
    	 }
	
	}
	public static void addEmployee() {
		/*
		//��ȡhibernate.cfg.xml
    	 Configuration configuration=new Configuration().configure();
    	 //����SessionFactory[����һ���Ự��������һ���������Ķ���]
    	SessionFactory sessionFactory=configuration.buildSessionFactory();
    	//����session 
    	Session session=sessionFactory.openSession();  
    	*/    
		
		
		Session session=MySessionFac.getSessionFactory().openSession();
    	Transaction T=session.beginTransaction();
    	
    	Employee emp=new Employee();
    	emp.setName("wangchuan");
    	emp.setEmail("2402873932@qq.com");
    	emp.setHirdate(new Date());
    	session.save(emp);//�����˳־û��ö��󣬱��浽���ݿ���
    	T.commit();
    	session.close();
	}
	//����get��load
	public static void testGetAndLoad(){
		Session session=MySessionFac.getSessionFactory().openSession();
		Employee emp1=(Employee) session.load(Employee.class, 1);
	    System.out.println(emp1.getName());
	    Employee emp2=(Employee) session.load(Employee.class, 1);
	    System.out.println(emp2.getEmail());
	    Employee emp3=(Employee) session.get(Employee.class, 2);
	    System.out.println(emp3.getHirdate());
	    session.close();
	}
}
