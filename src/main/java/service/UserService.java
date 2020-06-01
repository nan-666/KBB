package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import DAO.UserDAO;
import pojo.BaseDataPojo;
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
}
