package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FangWuDao;
import dao.HouseDao;
import entity.FangWu_houseEntity;
import entity.HouseEntity;
/**
 *去post.jsp页面的servlet
 *修改和添加都是要去往post.jsp页面，都是通过这个servlet
 *所以要判断是修改区post.jsp页面，还是添加去post.jsp页面
 *
 * 
 * */
@SuppressWarnings("serial")
public class UpdateAndInsertToPostServlet extends HttpServlet{
		@Override
		public void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
				HouseDao hd = new HouseDao();
				//获取房屋信息的f_id
				String f_id=req.getParameter("f_id");
			//获取房屋类型的数据，绑定到页面
			ArrayList<HouseEntity> houses=hd.selAllHouseType();
			req.setAttribute("houses", houses);
			//如果f_id不为0，说明是修改去往post.jsp页面，
			//如果f_id为0；说明是做添加，不需要把房屋信息绑定到页面
			if(Integer.parseInt(f_id)!=0){
				FangWuDao fwd = new FangWuDao();
				FangWu_houseEntity fw=fwd.getOneFangWu(f_id);
				req.setAttribute("fw", fw);
			}
			req.getRequestDispatcher("post.jsp").forward(req, resp);
		
		}
		@Override
		public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			doPost(req, resp);
		}
}
