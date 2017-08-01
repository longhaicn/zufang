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
 * ��Ӻ��޸�����ύ��servlet
 * ��ȥ�ж�f_id�Ƿ�����������϶���ӻ����޸�
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
			//�õ���ǰ�û����жϵ�ǰ�Ƿ����û���¼
			HttpSession sess = req.getSession();
				UserEntity user=(UserEntity)sess.getAttribute("user");
				String u_id = user.getU_id()+"";
			/*�ж������޸Ļ������
			 * ����ID��f_id;
			 * ��f_idû��ֵʱ��˵�����������
			 * ��f_id��ֵʱ��˵���������޸�
			 * */
			if(f_id==""||f_id.equals("")){
				//��Ӳ���
				if(user==null){
					//���û���ת����ҳ
					new SelectAllFangWuServlet().doPost(req, resp);
				}else{
					//���ø�ʽ
					SimpleDateFormat sf = 
						new SimpleDateFormat("yyyy-MM-dd");
					//�õ���ǰʱ��
					Date dt = new Date();
					//��ʽ��ʱ��
							String f_date =sf.format(dt);
						//��Ӳ���
					   fwd.inertFangWuXX(f_title, f_money, f_ting, f_shi, h_id, f_people, f_tel, f_mess, f_date, u_id);
					   //��ת��My.jspҳ��
					   resp.sendRedirect("MyAllFangWuServlet?u_id="+u_id);
				}
				
			}else{
				//�޸Ĳ���
				if(user==null){
					//���û���ת����ҳ
					new SelectAllFangWuServlet().doPost(req, resp);
				}else{
					//�޸Ĳ���
					fwd.updateFangWuXX(f_id, f_title, f_money, f_ting, f_shi, h_id, f_people, f_tel, f_mess);
					 //��ת��My.jspҳ��
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
