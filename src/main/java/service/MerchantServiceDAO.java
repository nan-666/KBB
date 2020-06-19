package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.MerchantDAO;
import DAO.UserDAO;
import pojo.BaseDataPojo;
import pojo.Merchant;
import pojo.User;
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
	
	public ArrayList<Merchant> selectById(int id){
		Connection conn = DButil.getConnection();
		MerchantDAO merchantD = new MerchantDAO(conn);
		try{
			ArrayList<Merchant> rows = new ArrayList<Merchant>();
			rows = merchantD.selectById(id);
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
	
	/* 删除业务 */
	public BaseDataPojo<Merchant> delete(int id) {
		Connection conn = DButil.getConnection();
		MerchantDAO merchantD = new MerchantDAO(conn);
		try {
			merchantD.delete(id);
			conn.commit();
			return new BaseDataPojo<Merchant>("删除成功", true, null);
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return new BaseDataPojo<Merchant>("删除失败", false, null);
		} finally {
			if (conn != null) {
				DButil.closeConnection(conn);
			}
		}
	}

}
