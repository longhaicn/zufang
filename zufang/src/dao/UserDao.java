package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import entity.UserEntity;

public class UserDao {
	/**
	 * 判断是否存在用户的方法
	 *@author 由Mr.Huang编写
	 *@param  参数类型 String的数字
	 *@return boolean类型，true表示存在，false表示不存在
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
					//调用关闭链接的方法
					BaseDao.getClose(rs, stat, conn);
				}
		}
		/**
		 * 用于注册用户
		 * @param 参数类型：String,String
		 * @return int类型，1表示成功，0表示失败
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
					//添加、修改、删除使用executeUpdate方法，
					//返回1表示成功，返回0表示失败，
					//使用stat.execute()方法，只是执行，
					//但不能得到相应的结果，只能判断是否执行后有无返回结果集
			}
		}
	/**
	 * 判断登录
	 * @param 参数是 String类型的name和String类型的pass
	 * @return 返回UserEntity对象，如果返回的是null表示登录失败
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
