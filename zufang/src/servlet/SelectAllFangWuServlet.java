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
 * ��ҳ�ķ�����Ϣչʾ
 * **/
@SuppressWarnings("serial")
public class SelectAllFangWuServlet extends HttpServlet{
			@Override
			public void doPost(HttpServletRequest req, HttpServletResponse resp)
					throws ServletException, IOException {
				/*Request ����  �ͷ��˷������󵽷����
				 *Response ��Ӧ  �������Ӧ���ͷ���
				 * 
				 * */
				//ת��
				resp.setContentType("text/html;charset=utf-8");
					//��ѯȫ���ķ�����Ϣ
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
