package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import DAO.UserDAO;
import pojo.BaseDataPojo;
import pojo.Order;
import pojo.User;
import pojo.ser;
import com.google.gson.Gson;
import util.DButil;

public class UserService {
	
	public static void main(String[] args) {
		UserService userService = new UserService();
		BaseDataPojo<Map<String, Object>> dataPojo = userService.getCredit(1);
		System.out.println(new Gson().toJson(dataPojo));
	}

	public BaseDataPojo<Map<String, Object>> getCredit(int id) {
		ser user = selectById(id);
		Map<String, Object> map = new HashMap<>();
		if (user != null) {
			map.put("credit", user.getCredit());
			return new BaseDataPojo<Map<String, Object>>("获取积分成功", true, map);
		} else {
			return new BaseDataPojo<Map<String, Object>>("获取积分失败", false, null);
		}
	}

	public ser selectById(int id) {
		Connection conn = DButil.getConnection();
		UserDAO userDAO = new UserDAO(conn);
		ser user = null;
		try {
			user = userDAO.selectById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				DButil.closeConnection(conn);
			}
		}
		return user;
	}
	
	public ArrayList<User> select(User user){
		Connection conn = DButil.getConnection();
		UserDAO userD = new UserDAO(conn);
		try{
			ArrayList<User> rows = new ArrayList<User>();
			rows = userD.select(user);
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
	
	public ArrayList<User> searchById(int id) {
		Connection conn = DButil.getConnection();
		UserDAO userDAO = new UserDAO(conn);
		ArrayList<User> rows = new ArrayList<User>();
		try {
			rows = userDAO.searchById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				DButil.closeConnection(conn);
			}
		}
		return rows;
	}
	
	public ArrayList<User> searchByName(String name) {
		Connection conn = DButil.getConnection();
		UserDAO userDAO = new UserDAO(conn);
		ArrayList<User> rows = new ArrayList<User>();
		try {
			rows = userDAO.searchByName(name);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				DButil.closeConnection(conn);
			}
		}
		return rows;
	}
	
	/* 删除业务 */
	public BaseDataPojo<User> delete(int id) {
		Connection conn = DButil.getConnection();
		UserDAO userD = new UserDAO(conn);
		try {
			userD.delete(id);
			conn.commit();
			return new BaseDataPojo<User>("删除成功", true, null);
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return new BaseDataPojo<User>("删除失败", false, null);
		} finally {
			if (conn != null) {
				DButil.closeConnection(conn);
			}
		}
	}

}
