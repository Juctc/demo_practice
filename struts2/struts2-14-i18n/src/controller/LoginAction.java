package controller;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
          private String username;
          
          public String getUsername(){
        	  return username;
          }
          public void setUsername(String username){
        	   this.username=username;
          }
          
          public void validate(){
        	  List paramValue=new ArrayList();
        	  paramValue.add("����һ������ֵ");
        	  
        	  if("".equals(username)){
        		    this.addFieldError("usernameKey1", this.getText("usernameNULL1",paramValue));
        		    
        	  }
        	  if("".equals(username)){
        		    this.addFieldError("usernameKey2", this.getText("usernameNULL2",paramValue));
        	  }
        	  
          }
}
