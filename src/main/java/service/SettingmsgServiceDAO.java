package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.BillDAO;
import dao.SettingmsgDAO;
import pojo.Bill;
import pojo.User;
import util.DButil;

public class SettingmsgServiceDAO {
	
	public boolean updateByType(String item,String nickName,String avatarUrl,String gender,String phone) {
		Connection conn = DButil.getConnection();
		SettingmsgDAO merchD = new SettingmsgDAO(conn);
		try{
			merchD.updateByType(item,nickName,avatarUrl,gender,phone);
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (conn != null) {
				DButil.closeConnection(conn);
			}
		}
	}
	public ArrayList<User> searchByType(String item) {
		Connection conn = DButil.getConnection();
		SettingmsgDAO merchD = new SettingmsgDAO(conn);
		try{
			ArrayList<User> rows = new ArrayList<User>();
			rows = merchD.searchByType(item);
			return rows;
		}catch(Exception e){
		      try {
			        conn.rollback();
			      } catch (SQLException e1) {
			        e1.printStackTrace();
			      }
			      e.printStackTrace();
			      return null;
			    }finally{
			      if(conn != null){
			        DButil.closeConnection(conn);
			      }
		}
	}

}
