package dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import orm.HibernateSessionFactory;

public class PageSearch {
	/**
	 * 
	 * @param pageIndex  ��ǰҳ��
	 * @param pageSize   ҳ���С
	 */
   public void pageSearch(int pageIndex,int pageSize){
	      Session session=HibernateSessionFactory.getSession();
	      String hql="from Object as O order by O.param asc";
	      Query query=session.createQuery(hql);
	      int startIndex=(pageSize-1)*pageSize;
	      query.setFirstResult(startIndex);   //��startIndex������ʼ��ѯ
	      query.setMaxResults(pageSize);      //�Ӳ�ѯ�����һ�η���pageSize������
	      List list=query.list();
	      Iterator it=list.iterator();
	      while(it.hasNext()){
	    	    Object o=it.next();
	    	    System.out.println();
	      }
   }
}
