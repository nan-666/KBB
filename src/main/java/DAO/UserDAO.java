package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.ser;
import com.mysql.jdbc.Statement;

public class UserDAO {
	
	private Connection conn = null;
	private PreparedStatement pst = null;
	
	// 定义构造函数，实例化时完成连接的注入
	public UserDAO(Connection conn){
		super();
		this.conn = conn;
	}
	
	public ser selectById(int id) throws SQLException {
		String sql = "select * from user where id=?";
		pst = conn.prepareStatement(sql);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			ser user = new ser();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setCredit(rs.getInt("credit"));
			return user;
		} else {
			return null;
		}
	}
	
	public boolean update(ser user) {
		try {
			String sql = "update user set name=?,credit=? where id=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, user.getName());
			pst.setInt(2, user.getCredit());
			pst.setInt(3, user.getId());
			pst.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public int insert(ser user){
		try {
			String sql = "insert into user(id,name,credit) values(?,?,?)";
			pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);	// 返回数据表的主key
			pst.setInt(1, user.getId());
			pst.setString(2, user.getName());
			pst.setInt(3, user.getCredit());
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();		// 获取主key
			if(rs.next()){
				return rs.getInt(1);	// 返回主key
			}else{
				return -1;		// 插入失败返回-1
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
}
