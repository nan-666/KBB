package service;

import java.sql.Connection;

import com.google.gson.Gson;

import DAO.AdminLoginDao;
import pojo.Admin;
import pojo.BaseDataPojo;
import util.DButil;

public class AdminService {

		// 处理登录业务
		public BaseDataPojo<Admin> login(Admin admin) {
			Admin admin1 = select(admin);
			if (admin1 != null) { 
				return new BaseDataPojo<Admin>("登录成功", true, admin1);
			} else { 
				return new BaseDataPojo<Admin>("登录失败，用户名或密码错误", false, null);
			}
		}

		// 根据Id查询
		public Admin select(Admin admin) {
			Connection conn = DButil.getConnection();
			AdminLoginDao loginD = new AdminLoginDao(conn);
			Admin admin1 = null;
			try {
				admin1 = loginD.select(admin);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (conn != null) {
					DButil.closeConnection(conn);
				}
			}
			return admin1;
		}
}
