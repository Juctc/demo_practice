package com.dao.bean;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBcon {
	Connection con=null;
	String url="jdbc:oracle:thin:@127.0.0.1:1521:myoracle";
	String name="scott";
	String pass="tiger";
    String className="oracle.jdbc.driver.OracleDriver";
	
	//ʹ�ù���ģʽ�õ�(����)����
	
	public  Connection getConnection(){
		
		try{
			//1.�������ݿ�����
			Class.forName(className);
			//2.�õ�����
			con=DriverManager.getConnection(url, name, pass);
			return con;
			
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
		
	}
	public void close(){
		try{
		  if(con!=null){
		      con.close();	  
		  }
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		 con=null;   //ʹ���������ջ���
	}
	

}
