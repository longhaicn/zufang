package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BaseDao {
		/**此方法是得到数据库的链接，当前链接的数据库为：zufang
		 * @param 无参数；
		 * @return 返回一个数据库链接Connection；
		 * @author Mr.Huang编写
		 */
		public static Connection getConn(){
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				return DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DataBaseName=zufang","sa","root");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		/**此方法是关闭数据库连接的
		 * @param 参数类型： ResultSet ,Statement ,Connection ；
		 * @return 无返回
		 * @author Mr.Huang编写
		 */
		public static void getClose(ResultSet rs,Statement stat,Connection conn){
			try {
				if(rs!=null){
					rs.close();
				}
				if(stat!=null){
					stat.close();
				}
				if(conn!=null){
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/**
		 * 添加、修改、删除的通用方法
		 * @param 传入写好的SQL语句
		 * @return int类型 0表示不成功，1表示成功
		 * @author Mr.Huang
		 * */
		public static int insertOrUpdateOrDelete(String sql)
		{
			Connection conn =null;
			Statement stat =null;
			int a =0;
			try {
				conn=BaseDao.getConn();
				stat=conn.createStatement();
				System.out.println(sql);
				a=stat.executeUpdate(sql);
				return a;
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}finally{
				BaseDao.getClose(null, stat, conn);
			}
		}
		
		
		public static void main(String[] args) {
				System.out.println(BaseDao.getConn());
		}
}








