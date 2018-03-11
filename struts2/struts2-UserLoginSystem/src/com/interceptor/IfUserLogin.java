package com.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class IfUserLogin extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ac=invocation.getInvocationContext();//��������ActionContextʵ��
		Map  session=ac.getSession();
		String username=(String) session.get("username");
		if(username!=null){
			System.out.println("����ͨ��");
			return invocation.invoke();   //��ʾ����ִ��
		}
		else{
			System.out.println("��¼���أ�");
			ac.put("tip","���ȵ�¼��");
			
            return Action.LOGIN;			
		}
	    
	}
                            
}
