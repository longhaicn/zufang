package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BaseDao;
import entity.UserEntity;
/***
 * 删除房屋信息的servlet
 * 前提是在用户登陆成功的条件下
 * 无用户跳转至首页
 * 删除成功刷新页面
 * 
 * */
@SuppressWarnings("serial")
public class DeleteFangWuServlet extends HttpServlet{
		@Override
		public void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
				//获取要删除房屋信息的主键ID
				String f_id = req.getParameter("f_id");
				//得到当前用户，判断当前是否有用户登录
				HttpSession sess = req.getSession();
				UserEntity user=(UserEntity)sess.getAttribute("user");
				int u_id = user.getU_id();
				//有用户，执行删除
				if(user!=null){
					//使用添加、删除、修改通用的方法
					String sql ="delete from fangwu_info where f_id="+f_id;
					BaseDao.insertOrUpdateOrDelete(sql);
					//刷新页面
					resp.sendRedirect("MyAllFangWuServlet?u_id="+u_id);
				}else
				{
					//无用户跳转至首页
					SelectAllFangWuServlet sfs =new SelectAllFangWuServlet();
										sfs.doPost(req, resp);
				}
		}
		@Override
		public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			doPost(req, resp);
		}
}
