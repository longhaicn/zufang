package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/***
 * 
 * ע���Ĺ���
 * 
 * 
 *
 */
@SuppressWarnings("serial")
public class SessionCloseServlet extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			HttpSession sess= req.getSession();
						//��һ�ַ��������ָ���İ�ֵ
						sess.removeAttribute("user");
						//�ڶ��ַ������ر�session
						//sess.invalidate();
			//ע������ת����ҳ
			new SelectAllFangWuServlet().doPost(req, resp);
			
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			doPost(req, resp);
	}
}
