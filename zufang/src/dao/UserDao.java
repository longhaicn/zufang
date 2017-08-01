package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import entity.UserEntity;

public class UserDao {
	/**
	 * �ж��Ƿ�����û��ķ���
	 *@author ��Mr.Huang��д
	 *@param  �������� String������
	 *@return boolean���ͣ�true��ʾ���ڣ�false��ʾ������
	 *
	 */
		public boolean checkUser(String u_name){
				Connection conn=null;
				Statement stat =null;
				ResultSet rs =null;
				try {
					conn=BaseDao.getConn();
					stat=conn.createStatement();
					rs=stat.executeQuery("select * from dbo.user_info where u_name='"+u_name+"'");
					return rs.next();
				} catch (Exception e) {
					e.printStackTrace();
					return true;
				}finally{
					//���ùر����ӵķ���
					BaseDao.getClose(rs, stat, conn);
				}
		}
		/**
		 * ����ע���û�
		 * @param �������ͣ�String,String
		 * @return int���ͣ�1��ʾ�ɹ���0��ʾʧ��
		 * @author Mr.Huang
		 */
		public int addUser(String name,String pass){
			Connection conn=null;
			Statement stat =null;
			int a =0;
			try {
				conn=BaseDao.getConn();
				stat=conn.createStatement();
				a=stat.executeUpdate("insert into user_info values('"+name+"','"+pass+"')");
				return a;
			}catch(Exception e){
				e.printStackTrace();
				return a;
			}finally{
				BaseDao.getClose(null, stat, conn);
				//fasle	//boolean bl =stat.execute("insert into user_info values('"+name+"','"+pass+"')");
	            //true  //boolean bl =stat.execute("select * from user_info");
				//false	//boolean bl =stat.execute("update user_info set u_name ='li4' where u_id=3");
				//false	//boolean bl =stat.execute("delete from user_info where u_id=3");
					//��ӡ��޸ġ�ɾ��ʹ��executeUpdate������
					//����1��ʾ�ɹ�������0��ʾʧ�ܣ�
					//ʹ��stat.execute()������ֻ��ִ�У�
					//�����ܵõ���Ӧ�Ľ����ֻ���ж��Ƿ�ִ�к����޷��ؽ����
			}
		}
	/**
	 * �жϵ�¼
	 * @param ������ String���͵�name��String���͵�pass
	 * @return ����UserEntity����������ص���null��ʾ��¼ʧ��
	 * @author Mr.Huang
	 * */
	public UserEntity getCheck(String pass,String name){
			Connection conn=null;
			Statement stat =null;
			UserEntity user = new UserEntity();
			ResultSet rs =null;
			try {
				conn=BaseDao.getConn();
				stat=conn.createStatement();
				rs=stat.executeQuery("select * from user_info where u_name='"+name+"' and u_pass='"+pass+"'");
				if(rs.next())
				{
					user.setU_id(rs.getInt("u_id"));
					user.setU_name(rs.getString("u_name"));
					user.setU_pass(rs.getString("u_pass"));
					return user;
				}else{
					return null;
				}
				
			} catch (Exception e) {
				
				e.printStackTrace();
				return null;
			}
		}
}
