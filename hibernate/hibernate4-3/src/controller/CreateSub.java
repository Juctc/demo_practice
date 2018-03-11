package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import orm.Main;
import orm.MainDAO;
import orm.Sub;
import orm.SubDAO;

public class CreateSub extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          MainDAO dao =new MainDAO();
          Session session =dao.getSession();
          session.beginTransaction();
          Main m=dao.findById(new Long(3));
          Hibernate.initialize(m);
          session.getTransaction().commit();
          session.close();
          
          Sub s=new Sub();
          s.setSubContent("�����ӱ�Ĵ��ı�");
          s.setCreatetime(new Date());
          s.setMain(m);   //��һ���ܹؼ����ǽ��ӱ���������й���
          
          SubDAO subdao=new SubDAO();
          Session s1=subdao.getSession();
          s1.beginTransaction();
          s1.save(s);
          s1.getTransaction().commit();
          s1.close();
          
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

    doGet(request,response);
	}

}
