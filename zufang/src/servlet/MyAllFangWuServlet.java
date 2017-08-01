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
 * 根据当前用户的ID，查询出当前用户的所有房屋信息
 * 并且跳转至my.jsp页面展示
 * 
 * */
@SuppressWarnings("serial")
public class MyAllFangWuServlet extends HttpServlet{
		@Override
		public  void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
				//获取当前用户的ID
				String u_id= req.getParameter("u_id");
				//根据当前用户的ID查询出当前用户所拥有的房屋信息
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
