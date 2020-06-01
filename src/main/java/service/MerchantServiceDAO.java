package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.MerchantDAO;
import pojo.Merchant;
import util.DButil;

public class MerchantServiceDAO {
	
	public ArrayList<Merchant> searchByType(String type) {
		Connection conn = DButil.getConnection();
		MerchantDAO merchD = new MerchantDAO(conn);
		try{
			ArrayList<Merchant> rows = new ArrayList<Merchant>();
			rows = merchD.searchByType(type);
			conn.commit();
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
	
	public ArrayList<Merchant> select(Merchant merchant){
		Connection conn = DButil.getConnection();
		MerchantDAO merchantD = new MerchantDAO(conn);
		try{
			ArrayList<Merchant> rows = new ArrayList<Merchant>();
			rows = merchantD.select(merchant);
			conn.commit();
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
