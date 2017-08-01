package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FangWuDao;
import entity.FangWu_houseEntity;
/**
 * 查询单个的房屋信息，并且展示在detail.jsp
 * 
 * 
 * */
@SuppressWarnings("serial")
public class SelectOneFangWuServlet extends HttpServlet{
		@Override
		public void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
				//获取房屋信息的ID
				String f_id=req.getParameter("id");
				System.out.println(f_id);
				//根据房屋信息的ID查询出房屋信息详情
				FangWuDao fwd = new FangWuDao();
			    FangWu_houseEntity fhe=fwd.getOneFangWu(f_id);
				req.setAttribute("fhe", fhe);
				req.getRequestDispatcher("detail.jsp").forward(req, resp);
		}
		@Override
		public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			doPost(req, resp);
		}
}
