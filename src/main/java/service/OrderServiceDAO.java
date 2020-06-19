package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


import pojo.Content;

import DAO.MerchantDAO;
import DAO.OrderDAO;
import pojo.BaseDataPojo;
import pojo.Merchant;
import pojo.Order;
import util.DButil;

public class OrderServiceDAO {
	public ArrayList<Order> select(Order order){
		Connection conn = DButil.getConnection();
		OrderDAO orderD = new OrderDAO(conn);
		try{
			ArrayList<Order> rows = new ArrayList<Order>();
			rows = orderD.select(order);
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
	
	public ArrayList<Order> selectById(int id){
		Connection conn = DButil.getConnection();
		OrderDAO orderD = new OrderDAO(conn);
		try{
			ArrayList<Order> rows = new ArrayList<Order>();
			rows = orderD.selectById(id);
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
	
	public String selectState(int id){
		Connection conn = DButil.getConnection();
		OrderDAO orderD = new OrderDAO(conn);
		try{
			String state = orderD.selectState(id);
			conn.commit();
			return state;
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
	
	public ArrayList<Order> searchByword(String word){
		Connection conn = DButil.getConnection();
		OrderDAO orderD = new OrderDAO(conn);
		try{
			ArrayList<Order> rows = new ArrayList<Order>();
			rows = orderD.searchByWord(word);
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
	
	public ArrayList<Order> selectByTypeId(String type){
		Connection conn = DButil.getConnection();
		OrderDAO orderD = new OrderDAO(conn);
		try{
			ArrayList<Order> rows = new ArrayList<Order>();
			rows = orderD.selectByTypeId(type);
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
	
	/**
	 * 发布任务，提交订单
	 * @param order
	 * @return
	 */
	public int insetOrder(Order order){
		Connection conn = DButil.getConnection();
		OrderDAO orderD = new OrderDAO(conn);
		try{

			int res = orderD.insetOrder(order);
			conn.commit();
			return res;
		}catch(Exception e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return 0;
		}finally{
			if(conn != null){
				DButil.closeConnection(conn);
			}
		}

	}
	
	//服务商接单
	public int updateOrder(int merchantid,int id){
		Connection conn = DButil.getConnection();
		OrderDAO orderD = new OrderDAO(conn);
		try{

			int res = orderD.updateOrder(merchantid,id);
			conn.commit();
			return res;
		}catch(Exception e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return 0;
		}finally{
			if(conn != null){
				DButil.closeConnection(conn);
			}
		}
	}
	
	/* 删除业务 */
	public BaseDataPojo<Order> delete(int id) {
		Connection conn = DButil.getConnection();
		OrderDAO orderD = new OrderDAO(conn);
		try {
			orderD.delete(id);
			conn.commit();
			return new BaseDataPojo<Order>("删除成功", true, null);
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return new BaseDataPojo<Order>("删除失败", false, null);
		} finally {
			if (conn != null) {
				DButil.closeConnection(conn);
			}
		}
	}
	
	//获取总数
	public ArrayList<Content> content() {
		Connection conn = DButil.getConnection();
		OrderDAO orderD = new OrderDAO(conn);
		ArrayList<Content> rows = null;
		try{
			rows = orderD.content();
			return rows;
		}
		catch(Exception e){
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
	public ArrayList<Order> searchByType(String type,String userid) {
		Connection conn = DButil.getConnection();
		OrderDAO merchD = new OrderDAO(conn);
		try{
			ArrayList<Order> rows = new ArrayList<Order>();
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
}
