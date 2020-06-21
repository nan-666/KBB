package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.BillDAO;
import dao.OrderDAO;
import pojo.order;
import util.DButil;

public class OrderServiceDAO {
	
	public ArrayList<order> searchByType(String type,String userid) {
		Connection conn = DButil.getConnection();
		OrderDAO merchD = new OrderDAO(conn);
		try{
			ArrayList<order> rows = new ArrayList<order>();
			rows = merchD.searchByType(type,userid);
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
	public boolean deleteType(String item) {
		Connection conn = DButil.getConnection();
		OrderDAO merchD = new OrderDAO(conn);
		try{
			merchD.deleteType(item);
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
	public boolean upstateType(String id,String state) {
		Connection conn = DButil.getConnection();
		OrderDAO merchD = new OrderDAO(conn);
		try{
			merchD.upstateType(id,state);
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
