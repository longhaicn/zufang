package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BaseDao {
		/**�˷����ǵõ����ݿ�����ӣ���ǰ���ӵ����ݿ�Ϊ��zufang
		 * @param �޲�����
		 * @return ����һ�����ݿ�����Connection��
		 * @author Mr.Huang��д
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
		/**�˷����ǹر����ݿ����ӵ�
		 * @param �������ͣ� ResultSet ,Statement ,Connection ��
		 * @return �޷���
		 * @author Mr.Huang��д
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
		 * ��ӡ��޸ġ�ɾ����ͨ�÷���
		 * @param ����д�õ�SQL���
		 * @return int���� 0��ʾ���ɹ���1��ʾ�ɹ�
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








