package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FangWuDao;

import entity.UserEntity;
/**
 * 添加和修改最后提交的servlet
 * 会去判断f_id是否存在数据来断定添加还是修改
 * 
 * 
 * */
@SuppressWarnings("serial")
public class UpdateAndInsertToBataDaoServlet extends HttpServlet{
		@Override
		public void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			req.setCharacterEncoding("utf-8");
			String f_id =req.getParameter("f_id");
			String f_title=req.getParameter("f_title");
			String f_money=req.getParameter("f_money");
			String f_shi=req.getParameter("f_shi");
			String f_ting=req.getParameter("f_ting");
			String h_id=req.getParameter("h_id");
			String f_tel=req.getParameter("f_tel");
			String f_people=req.getParameter("f_people");
			String f_mess=req.getParameter("f_mess");
			FangWuDao fwd = new FangWuDao();
			//得到当前用户，判断当前是否有用户登录
			HttpSession sess = req.getSession();
				UserEntity user=(UserEntity)sess.getAttribute("user");
				String u_id = user.getU_id()+"";
			/*判断是做修改还是添加
			 * 房屋ID：f_id;
			 * 当f_id没有值时，说明做的是添加
			 * 当f_id有值时，说明做的是修改
			 * */
			if(f_id==""||f_id.equals("")){
				//添加操作
				if(user==null){
					//无用户跳转至首页
					new SelectAllFangWuServlet().doPost(req, resp);
				}else{
					//设置格式
					SimpleDateFormat sf = 
						new SimpleDateFormat("yyyy-MM-dd");
					//得到当前时间
					Date dt = new Date();
					//格式化时间
							String f_date =sf.format(dt);
						//添加操作
					   fwd.inertFangWuXX(f_title, f_money, f_ting, f_shi, h_id, f_people, f_tel, f_mess, f_date, u_id);
					   //跳转至My.jsp页面
					   resp.sendRedirect("MyAllFangWuServlet?u_id="+u_id);
				}
				
			}else{
				//修改操作
				if(user==null){
					//无用户跳转至首页
					new SelectAllFangWuServlet().doPost(req, resp);
				}else{
					//修改操作
					fwd.updateFangWuXX(f_id, f_title, f_money, f_ting, f_shi, h_id, f_people, f_tel, f_mess);
					 //跳转至My.jsp页面
					resp.sendRedirect("MyAllFangWuServlet?u_id="+u_id);
				}
			}
			
		}
		@Override
		public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
				doPost(req, resp);
		}
}
