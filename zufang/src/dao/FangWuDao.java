package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entity.FangWuEntity;
import entity.FangWu_houseEntity;

public class FangWuDao {
	/**
	 * ��ѯȫ���ķ�����Ϣ����
	 * @param �޲���
	 * @return ����һ�����ݵļ���
	 * @author Mr.Huang
	 * */
public ArrayList<FangWuEntity> getAllFangWu(){
	Connection conn =null;
	Statement stat =null;
	ResultSet rs =null;
	ArrayList<FangWuEntity> fws = new ArrayList<FangWuEntity>();
	try {
		conn=BaseDao.getConn();
		stat=conn.createStatement();
		rs=stat.executeQuery("select * from fangwu_info order by f_id desc");
		while(rs.next()){
			FangWuEntity fw = new FangWuEntity();
					fw.setF_date(rs.getString("f_date"));
					fw.setF_id(rs.getInt("f_id"));
					fw.setF_mess(rs.getString("f_mess"));
					fw.setF_money(rs.getString("f_money"));
					fw.setF_people(rs.getString("f_people"));
					fw.setF_shi(rs.getInt("f_shi"));
					fw.setF_tel(rs.getString("f_tel"));
					fw.setF_ting(rs.getInt("f_ting"));
					fw.setF_title(rs.getString("f_title"));
					fw.setH_id(rs.getInt("h_id"));
					fw.setU_id(rs.getInt("u_id"));
					fws.add(fw);
		}
		return fws;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}finally{
		BaseDao.getClose(rs, stat, conn);
	}
}
	/**
	 * ��ѯ�����ķ�����Ϣ
	 * @param ���ݵ�ID
	 * @return ���ص����ķ�����Ϣ��
	 * @author Mr.Huang
	 * */
	public FangWu_houseEntity getOneFangWu(String f_id){
		Connection conn =null;
		Statement stat =null;
		ResultSet rs =null;
		FangWu_houseEntity fw = new FangWu_houseEntity();
		try {
			conn=BaseDao.getConn();
			stat=conn.createStatement();
			rs=stat.executeQuery("select * from fangwu_info f inner join house_info h on f.h_id=h.h_id where f.f_id="+f_id);
			while(rs.next()){
						fw.setF_date(rs.getString("f_date"));
						fw.setF_id(rs.getInt("f_id"));
						fw.setF_mess(rs.getString("f_mess"));
						fw.setF_money(rs.getString("f_money"));
						fw.setF_people(rs.getString("f_people"));
						fw.setF_shi(rs.getInt("f_shi"));
						fw.setF_tel(rs.getString("f_tel"));
						fw.setF_ting(rs.getInt("f_ting"));
						fw.setF_title(rs.getString("f_title"));
						fw.setH_name(rs.getString("h_name"));
						fw.setU_id(rs.getInt("u_id"));
						fw.setH_id(rs.getInt("h_id"));
			}
			return fw;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			BaseDao.getClose(rs, stat, conn);
		}
		
	}
	/**
	 * ����������ѯ��ȫ���ķ�����Ϣ����
	 * @param String����
	 * @return ����һ�����ݵļ���
	 * @author Mr.Huang
	 * */
public ArrayList<FangWuEntity> selValueFangWus(String selValue){
	Connection conn =null;
	Statement stat =null;
	ResultSet rs =null;
	ArrayList<FangWuEntity> fws = new ArrayList<FangWuEntity>();
	try {
		conn=BaseDao.getConn();
		stat=conn.createStatement();
		rs=stat.executeQuery("select * from fangwu_info where f_title like'%"+selValue+"%' or f_money like'%"+selValue+"%' order by f_id desc");
		while(rs.next()){
			FangWuEntity fw = new FangWuEntity();
					fw.setF_date(rs.getString("f_date"));
					fw.setF_id(rs.getInt("f_id"));
					fw.setF_mess(rs.getString("f_mess"));
					fw.setF_money(rs.getString("f_money"));
					fw.setF_people(rs.getString("f_people"));
					fw.setF_shi(rs.getInt("f_shi"));
					fw.setF_tel(rs.getString("f_tel"));
					fw.setF_ting(rs.getInt("f_ting"));
					fw.setF_title(rs.getString("f_title"));
					fw.setH_id(rs.getInt("h_id"));
					fw.setU_id(rs.getInt("u_id"));
					fws.add(fw);
		}
		return fws;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}finally{
		BaseDao.getClose(rs, stat, conn);
	}
}
/**
 * �����û�ID��ѯ�����ڸ��û���ȫ��������Ϣ
 * @param �������û���ID
 * @return ���ظ��û���ȫ��������Ϣ
 * @author Mr.Huang
 * */
	public ArrayList<FangWuEntity> selU_idToFangWuXX(String u_id){
		Connection conn =null;
		Statement stat =null;
		ResultSet rs =null;
		ArrayList<FangWuEntity> fws = new ArrayList<FangWuEntity>();
		try {
			conn=BaseDao.getConn();
			stat=conn.createStatement();
			rs=stat.executeQuery("select * from fangwu_info where u_id="+u_id+" order by f_id desc");
			while(rs.next()){
				FangWuEntity fw = new FangWuEntity();
						fw.setF_date(rs.getString("f_date"));
						fw.setF_id(rs.getInt("f_id"));
						fw.setF_mess(rs.getString("f_mess"));
						fw.setF_money(rs.getString("f_money"));
						fw.setF_people(rs.getString("f_people"));
						fw.setF_shi(rs.getInt("f_shi"));
						fw.setF_tel(rs.getString("f_tel"));
						fw.setF_ting(rs.getInt("f_ting"));
						fw.setF_title(rs.getString("f_title"));
						fw.setH_id(rs.getInt("h_id"));
						fw.setU_id(rs.getInt("u_id"));
						fws.add(fw);
			}
			return fws;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			BaseDao.getClose(rs, stat, conn);
		}
	}
	/**
	 * ��ӷ�����Ϣ
	 * @param ���ݵĻ�����Ϣ����
	 * @return int���ͣ�0��ʾû�ɹ���1��ʾ�ɹ�
	 * @author Mr.Huang
	 * */
	public int inertFangWuXX(String f_title,String f_money,
			String f_ting,String f_shi,String h_id,
			String f_people,String f_tel,String f_mess,
			String f_date,String u_id){
		Connection conn =null;
		Statement stat =null;
		int a =0;
		try {
			conn=BaseDao.getConn();
			stat=conn.createStatement();
			String sql ="insert into fangwu_info values('"+f_date+"','"+f_mess+"','"+f_money+"','"+f_people+"','"+f_shi+"','"+f_tel+"','"+f_ting+"','"+f_title+"','"+h_id+"','"+u_id+"');";
			a=stat.executeUpdate(sql);
			return a;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally{
			BaseDao.getClose(null, stat, conn);
		}
	}
	/**
	 * �޸ķ�����Ϣ
	 * @param ������Ϣ������
	 * @return int 0��ʾû�ɹ���1��ʾ�ɹ�
	 * @author Mr.Huang
	 * **/
	public int updateFangWuXX(String f_id,String f_title,String f_money,
			String f_ting,String f_shi,String h_id,
			String f_people,String f_tel,String f_mess){
		Connection conn =null;
		Statement stat =null;
		int a =0;
		try {
			conn=BaseDao.getConn();
			stat=conn.createStatement();
			String sql ="update fangwu_info set f_title='"+f_title+"',f_money='"+f_money+"',f_ting='"+f_ting+"',f_shi='"+f_shi+"',h_id='"+h_id+"',f_people='"+f_people+"',f_tel='"+f_tel+"',f_mess='"+f_mess+"' where f_id="+f_id;
			a=stat.executeUpdate(sql);
			return a;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally{
			BaseDao.getClose(null, stat, conn);
		}
	}
	/**
	 * ���ݷ���f_idɾ��������Ϣ
	 * @param ���ݵ�ID
	 * @return int  0��ʾû�ɹ���1��ʾ�ɹ�
	 * @author Mr.Huang
	 * */
	public int deleteFangWuXX(String f_id)
	{
		Connection conn =null;
		Statement stat =null;
		int a =0;
		try {
			conn=BaseDao.getConn();
			stat=conn.createStatement();
			String sql ="delete from fangwu_info where f_id="+f_id;
			a=stat.executeUpdate(sql);
			return a;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally{
			BaseDao.getClose(null, stat, conn);
		}
	}
}
