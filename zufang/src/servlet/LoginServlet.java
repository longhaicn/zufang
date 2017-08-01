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
 * 验证登录的servlet
 * 登陆成功，把登录的用户保存到session
 * 登录失败返回登陆页面
 * **/
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet{
		@Override
		public void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
				resp.setContentType("text/html;charset=utf-8");
				//获取登录者输入的用户和密码
			    String name = req.getParameter("name");
				String pass = req.getParameter("pass");
				//判断数据库中是否存在该用户
				UserDao ud = new UserDao();
				UserEntity user = ud.getCheck(pass, name);
				PrintWriter pw = resp.getWriter();
				if(user==null){
					//无此用户的操作
					pw.write("<script type='text/javascript'>alert('用户账号或密码错误，请重新登录');window.location.href='AllMess';</script>");
				}else{
					/*登录成功绑定登录者的信息到session
						并且跳转至login页面
					*/
					HttpSession ses = req.getSession();
					ses.setAttribute("user", user);
					//绑定房屋信息的集合
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
