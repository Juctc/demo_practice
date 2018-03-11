package com.controller;

import com.bean.Users;
import com.dao.UsersDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport { 
       private String username;
       private String password;
       private ActionContext ac=ActionContext.getContext();
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
     public String login() throws Exception{
    	  Users users=new Users();
    	  users.setUsername(username);
    	  users.setPassword(password);
    	  UsersDAO dao=new UsersDAO();
    	  boolean flag=dao.login(users);
    	  if(flag){
    		
    		  ac.getSession().put("username", username);  //���û�������session��
    		
    		    //1.��ȡ��ǰ������������Application�л�ȡ
    		      
    		    Integer count=(Integer)ac.getApplication().get("count");
    		    if(count==null){
    		      count=0;
    		    }
    		    
    		    //ʹ��ǰ�������� +1
    		    count++;
    		    ac.getApplication().put("count", count);

    		  return "success";
    	  }
    	  else{
    		  return INPUT; 
    	  }
     }
     

}














