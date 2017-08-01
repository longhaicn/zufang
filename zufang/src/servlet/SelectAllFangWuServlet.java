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
 * 首页的房屋信息展示
 * **/
@SuppressWarnings("serial")
public class SelectAllFangWuServlet extends HttpServlet{
			@Override
			public void doPost(HttpServletRequest req, HttpServletResponse resp)
					throws ServletException, IOException {
				/*Request 请求  客服端发送请求到服务端
				 *Response 响应  服务端响应到客服端
				 * 
				 * */
				//转码
				resp.setContentType("text/html;charset=utf-8");
					//查询全部的房屋信息
					FangWuDao fw = new FangWuDao();
					ArrayList<FangWuEntity>	fws=fw.getAllFangWu();
					req.setAttribute("fws", fws);
					req.getRequestDispatcher("index.jsp").forward(req, resp);
			}
			@Override
			public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
				doPost(req, resp);
			}
}
