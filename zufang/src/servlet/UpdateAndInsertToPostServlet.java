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
 *ȥpost.jspҳ���servlet
 *�޸ĺ���Ӷ���Ҫȥ��post.jspҳ�棬����ͨ�����servlet
 *����Ҫ�ж����޸���post.jspҳ�棬�������ȥpost.jspҳ��
 *
 * 
 * */
@SuppressWarnings("serial")
public class UpdateAndInsertToPostServlet extends HttpServlet{
		@Override
		public void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
				HouseDao hd = new HouseDao();
				//��ȡ������Ϣ��f_id
				String f_id=req.getParameter("f_id");
			//��ȡ�������͵����ݣ��󶨵�ҳ��
			ArrayList<HouseEntity> houses=hd.selAllHouseType();
			req.setAttribute("houses", houses);
			//���f_id��Ϊ0��˵�����޸�ȥ��post.jspҳ�棬
			//���f_idΪ0��˵��������ӣ�����Ҫ�ѷ�����Ϣ�󶨵�ҳ��
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
