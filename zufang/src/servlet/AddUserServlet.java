package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UserDao;
/***
 * ע���û���servlet��
 * ע��ɹ���ת����ҳ
 * ע��ʧ������ע��ҳ��
 * */
@SuppressWarnings("serial")
public class AddUserServlet extends HttpServlet{
		//ע���û�
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
				//��ҳ���ϵ�ת��
				resp.setContentType("text/html;charset=utf-8");
				String name =req.getParameter("u_name");
				String pass = req.getParameter("u_pass");
				UserDao ud = new UserDao();
				//��ȡ�����
				PrintWriter pw = resp.getWriter();
				if(ud.checkUser(name)){
					//����
					//req.setAttribute("ts", "�û��Ѵ���");
					//��תҳ��
					//req.getRequestDispatcher("reg.jsp").forward(req, resp);
					//��ȡ�����
								//��ӡ
								pw.write("<script type='text/javascript'>alert('�û�����');history.go(-1);</script>");		
				}else{
					//������
					//������ӵķ���
					 int a = ud.addUser(name, pass);
					 //�ж��Ƿ�ɹ�
					 	if(a==0){
					 		//ע��ʧ��
							//��ӡ
							pw.write("<script type='text/javascript'>alert('ע��ʧ��');history.go(-1);</script>");
					 	}else{
							//��ӡ
							pw.write("<script type='text/javascript'>alert('ע��ɹ�');window.location.href='AllMess';</script>");
					 	}		
				}
				//���
				pw.flush();
				//�ر�
				pw.close();	  
				
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		
	}
}
