package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.BillDAO;
import pojo.Bill;
import util.DButil;

public class BillServiceDAO {
	
	public ArrayList<Bill> searchByType(String item) {
		Connection conn = DButil.getConnection();
		BillDAO merchD = new BillDAO(conn);
		try{
			ArrayList<Bill> rows = new ArrayList<Bill>();
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
	public boolean updateByType(String item,String balance) {
		Connection conn = DButil.getConnection();
		BillDAO merchD = new BillDAO(conn);
		try{
			merchD.updateByType(item,balance);
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

}
