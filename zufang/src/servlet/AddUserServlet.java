package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UserDao;
/***
 * 注册用户的servlet，
 * 注册成功跳转至首页
 * 注册失败留在注册页面
 * */
@SuppressWarnings("serial")
public class AddUserServlet extends HttpServlet{
		//注册用户
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
				//在页面上的转码
				resp.setContentType("text/html;charset=utf-8");
				String name =req.getParameter("u_name");
				String pass = req.getParameter("u_pass");
				UserDao ud = new UserDao();
				//获取输出流
				PrintWriter pw = resp.getWriter();
				if(ud.checkUser(name)){
					//存在
					//req.setAttribute("ts", "用户已存在");
					//跳转页面
					//req.getRequestDispatcher("reg.jsp").forward(req, resp);
					//获取输出流
								//打印
								pw.write("<script type='text/javascript'>alert('用户存在');history.go(-1);</script>");		
				}else{
					//不存在
					//调用添加的方法
					 int a = ud.addUser(name, pass);
					 //判断是否成功
					 	if(a==0){
					 		//注册失败
							//打印
							pw.write("<script type='text/javascript'>alert('注册失败');history.go(-1);</script>");
					 	}else{
							//打印
							pw.write("<script type='text/javascript'>alert('注册成功');window.location.href='AllMess';</script>");
					 	}		
				}
				//清空
				pw.flush();
				//关闭
				pw.close();	  
				
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		
	}
}
