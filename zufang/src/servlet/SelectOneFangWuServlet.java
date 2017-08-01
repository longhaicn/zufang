package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FangWuDao;
import entity.FangWu_houseEntity;
/**
 * ��ѯ�����ķ�����Ϣ������չʾ��detail.jsp
 * 
 * 
 * */
@SuppressWarnings("serial")
public class SelectOneFangWuServlet extends HttpServlet{
		@Override
		public void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
				//��ȡ������Ϣ��ID
				String f_id=req.getParameter("id");
				System.out.println(f_id);
				//���ݷ�����Ϣ��ID��ѯ��������Ϣ����
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
