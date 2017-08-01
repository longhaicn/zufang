package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FangWuDao;
import entity.FangWuEntity;
/***
 * index.jsp��login.jspҳ���ϵĲ�ѯ����
 * �ĸ�ҳ���ϵĲ�ѯ����servlet������ѯ�Ľ��������ת���ĸ�ҳ��

 * **/
@SuppressWarnings("serial")
public class IndexAndLoginChaXunFangWuServlet extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		    req.setCharacterEncoding("utf-8");
		    //��ȡ��ѯ������
			String selValue =req.getParameter("selValue");
			//����Ҫ��ת��ҳ�棺index����loginҳ��
			String htm = req.getParameter("ty");
			//ִ�в�ѯ
			FangWuDao fwd = new FangWuDao();
		    ArrayList<FangWuEntity> fws=fwd.selValueFangWus(selValue);
			req.setAttribute("fws", fws);
			//����ԭ����ҳ��
			req.getRequestDispatcher(htm).forward(req, resp);
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			doPost(req, resp);
	}
}
