package bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Person implements BeanNameAware,BeanFactoryAware,ApplicationContextAware,InitializingBean{
      private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("set method execute......");
	}
     public Person(){
    	   System.out.println("Person constructor.......");
     }
     public void go(){
    	  System.out.println("go()  execute......");
     }

	@Override
	public void setBeanName(String arg0) {
		  System.out.println("�õ����õ�id��BeanName: "+arg0);
	}

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		  System.out.println("�õ�BeanFactory����"+arg0);
		
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		 System.out.println("�õ�ApplicationContext����"+arg0);
		
	}
     //�ں��ô�����before ��after֮��ִ�еķ�����
	@Override
	public void afterPropertiesSet() throws Exception {
		 System.out.println("afterPropertiesSet()....");
	}
	public void init(){
		 System.out.println("ִ�ж��Ʒ���.....");
	}
}
