package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.OrderDAO;
import pojo.Order;
import pojo.User;
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
}
