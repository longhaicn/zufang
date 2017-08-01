package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FangWuDao;
import entity.FangWuEntity;
/**
 * ���ݵ�ǰ�û���ID����ѯ����ǰ�û������з�����Ϣ
 * ������ת��my.jspҳ��չʾ
 * 
 * */
@SuppressWarnings("serial")
public class MyAllFangWuServlet extends HttpServlet{
		@Override
		public  void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
				//��ȡ��ǰ�û���ID
				String u_id= req.getParameter("u_id");
				//���ݵ�ǰ�û���ID��ѯ����ǰ�û���ӵ�еķ�����Ϣ
			    FangWuDao fw = new FangWuDao();
			    ArrayList<FangWuEntity> fws = new ArrayList<FangWuEntity>();
			    fws=fw.selU_idToFangWuXX(u_id);
			    req.setAttribute("fws", fws);
			    req.getRequestDispatcher("my.jsp").forward(req, resp);
		}
		@Override
		public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			doPost(req, resp);
		}
}
