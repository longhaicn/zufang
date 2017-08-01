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
 * ɾ��������Ϣ��servlet
 * ǰ�������û���½�ɹ���������
 * ���û���ת����ҳ
 * ɾ���ɹ�ˢ��ҳ��
 * 
 * */
@SuppressWarnings("serial")
public class DeleteFangWuServlet extends HttpServlet{
		@Override
		public void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
				//��ȡҪɾ��������Ϣ������ID
				String f_id = req.getParameter("f_id");
				//�õ���ǰ�û����жϵ�ǰ�Ƿ����û���¼
				HttpSession sess = req.getSession();
				UserEntity user=(UserEntity)sess.getAttribute("user");
				int u_id = user.getU_id();
				//���û���ִ��ɾ��
				if(user!=null){
					//ʹ����ӡ�ɾ�����޸�ͨ�õķ���
					String sql ="delete from fangwu_info where f_id="+f_id;
					BaseDao.insertOrUpdateOrDelete(sql);
					//ˢ��ҳ��
					resp.sendRedirect("MyAllFangWuServlet?u_id="+u_id);
				}else
				{
					//���û���ת����ҳ
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
