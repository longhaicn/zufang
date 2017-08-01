package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entity.HouseEntity;

public class HouseDao {
	/**
	 * ��ȡȫ���ķ�����Ϣ
	 * @param �޲���
	 * @return ���ط������͵ļ���
	 * @author Mr.Huang
	 * */
	public ArrayList<HouseEntity> selAllHouseType(){
		ArrayList<HouseEntity> houses = new ArrayList<HouseEntity>();
		Connection conn =null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn=BaseDao.getConn();
			stat=conn.createStatement();
			rs=stat.executeQuery("select * from house_info");
			while(rs.next())
			{
				HouseEntity he= new HouseEntity();
							he.setH_id(rs.getInt("h_id"));
							he.setH_name(rs.getString("h_name"));
						houses.add(he);			
			}
			return houses;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			BaseDao.getClose(rs, stat, conn);
		}
	}
	
}
