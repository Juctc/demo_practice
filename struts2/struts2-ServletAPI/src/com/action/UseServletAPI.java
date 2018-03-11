package com.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class UseServletAPI {
         public String use(){
        	 //0:��ȡActionContext����
        	 ActionContext actionContext=ActionContext.getContext(); //��̬��������
        	 //1:��ȡapplication��Ӧ��map
        	 Map<String,Object> applicationMap=actionContext.getApplication();
        	 //��������
        	 applicationMap.put("applicationKey", "applicationValue");
        	 //��ȡ����
        	 Object date=applicationMap.get("date");
        	 System.out.println("date:"+date);
        	 //2:��ȡsession��Ӧ��map
        	 Map<String,Object> sessionMap=actionContext.getSession();
        	 sessionMap.put("sessionKey","sessionValue");
        	 //3:��ȡrequest��Ӧ��map
        	 Map<String,Object> requestMap=(Map<String, Object>) actionContext.get("request");
        	 requestMap.put("requestKey", "requestValue");
        	 //4:��ȡ�������map
        	 //  ֻ�ܶ�����д��
        	 Map<String,Object> parameters=actionContext.getParameters();
        	 String name=((String[])parameters.get("name"))[0];//���ص���һ������
        	 System.out.println("name:"+name);
        	 return "success";
         }
}
