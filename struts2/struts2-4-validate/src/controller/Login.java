package controller;

import service.UserinfoService;

import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport{
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
            
            public void validate(){
            	 if("".equals(this.username)){
            		  this.addFieldError("username","�Բ����û���������Ϊ�գ�");
            	 }
            	 if("".equals(this.password)){
            		 this.addFieldError("password","�Բ������벻����Ϊ�գ�");
            	 }
            }
            public String execute(){
            	 UserinfoService us=new UserinfoService();
            	 if(us.login(username, password)){
            		   return "success";
            		   
            	 }
            	      System.out.println(username);
                       return "error";
                       
            	  
            }
            
}
