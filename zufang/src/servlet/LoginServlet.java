package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FangWuDao;
import dao.UserDao;
import entity.FangWuEntity;
import entity.UserEntity;
/**
 * ��֤��¼��servlet
 * ��½�ɹ����ѵ�¼���û����浽session
 * ��¼ʧ�ܷ��ص�½ҳ��
 * **/
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet{
		@Override
		public void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
				resp.setContentType("text/html;charset=utf-8");
				//��ȡ��¼��������û�������
			    String name = req.getParameter("name");
				String pass = req.getParameter("pass");
				//�ж����ݿ����Ƿ���ڸ��û�
				UserDao ud = new UserDao();
				UserEntity user = ud.getCheck(pass, name);
				PrintWriter pw = resp.getWriter();
				if(user==null){
					//�޴��û��Ĳ���
					pw.write("<script type='text/javascript'>alert('�û��˺Ż�������������µ�¼');window.location.href='AllMess';</script>");
				}else{
					/*��¼�ɹ��󶨵�¼�ߵ���Ϣ��session
						������ת��loginҳ��
					*/
					HttpSession ses = req.getSession();
					ses.setAttribute("user", user);
					//�󶨷�����Ϣ�ļ���
					FangWuDao fwd = new FangWuDao();
				    ArrayList<FangWuEntity> fws = fwd.getAllFangWu();
				    req.setAttribute("fws", fws);
					req.getRequestDispatcher("login.jsp").forward(req, resp);
				}
				pw.flush();
				pw.close();
		}
		@Override
		public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			doPost(req, resp);
		}
}
