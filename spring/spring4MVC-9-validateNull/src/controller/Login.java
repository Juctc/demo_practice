package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Login {
      @RequestMapping("/login")
      public String validateLogin(String username,String password,Model model){
    	   Map errorMap=new HashMap();
    	   if(username==null||"".equals(username)){
    		   errorMap.put("u", "�û���Ϊ��");
    	   }
    	   if(username==null||"".equals(password)){
    		   errorMap.put("p", "����Ϊ��");
    	   }
    	   
    	   if(errorMap.size()>0){
    		   model.addAttribute("errorInfo",errorMap);
    		   return "login.jsp";
    	   }
    	   return "index.jsp";
      }
}
