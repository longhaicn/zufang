package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/***
 * 
 * 注销的功能
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
						//第一种方法：清除指定的绑定值
						sess.removeAttribute("user");
						//第二种方法：关闭session
						//sess.invalidate();
			//注销后跳转至首页
			new SelectAllFangWuServlet().doPost(req, resp);
			
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			doPost(req, resp);
	}
}
