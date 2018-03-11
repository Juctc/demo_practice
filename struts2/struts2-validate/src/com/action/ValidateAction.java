package com.action;

import com.opensymphony.xwork2.ActionSupport;



public class ValidateAction extends ActionSupport{
     private String username;
     private String password;
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
     public String execute(){
    	  return "success";
     }
     public void validate(){
    	 if(username==null || username.length()<6 ||username.length()>=15){
    		  addFieldError("username","�û������ĳ��Ȳ�����Ҫ��");
    		  
    	 }
    	 if(password==null || password.length()<8 || password.length()>20){
    		 addFieldError("password", "�û�����ĳ��Ȳ�����Ҫ��");
    	 }
     }
}
