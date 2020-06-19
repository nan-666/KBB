package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import pojo.Admin;

public class AdminLoginDao {
	private Connection conn = null;
	private PreparedStatement pst = null;
	
	// 定义构造函数，实例化时完成连接的注入
	public AdminLoginDao(Connection conn){
		super();
		this.conn = conn;
	}
	
	public Admin select(Admin admin){
		try {
			String sql = "select * from admin where name=? and password=?";
			pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setString(1, admin.getName());  
			pst.setString(2, admin.getPassword());  
			ResultSet rs = pst.executeQuery();	// 执行sql语句
			if(rs.next()){			// 查询成功
				Admin admin1 = new Admin();
				admin1.setId(rs.getInt("id"));
				admin1.setName(rs.getString("name"));
				admin1.setPassword(rs.getString("password"));
				admin1.setAvatar(rs.getString("avatar"));
				admin1.setNickname(rs.getString("nickname"));
				admin1.setEmail(rs.getString("email"));
				return admin1;
			}else{			// 查询失败
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
