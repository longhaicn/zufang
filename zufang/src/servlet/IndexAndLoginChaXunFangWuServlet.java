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
 * index.jsp与login.jsp页面上的查询功能
 * 哪个页面上的查询调用servlet，所查询的结果将会跳转至哪个页面

 * **/
@SuppressWarnings("serial")
public class IndexAndLoginChaXunFangWuServlet extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		    req.setCharacterEncoding("utf-8");
		    //获取查询的条件
			String selValue =req.getParameter("selValue");
			//接受要跳转的页面：index或者login页面
			String htm = req.getParameter("ty");
			//执行查询
			FangWuDao fwd = new FangWuDao();
		    ArrayList<FangWuEntity> fws=fwd.selValueFangWus(selValue);
			req.setAttribute("fws", fws);
			//跳回原来的页面
			req.getRequestDispatcher(htm).forward(req, resp);
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			doPost(req, resp);
	}
}
