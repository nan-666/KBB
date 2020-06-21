package DAO;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import pojo.User;
import pojo.ser;
import com.mysql.jdbc.Statement;

public class UserDAO {
	
	private Connection conn = null;
	private PreparedStatement pst = null;
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
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
	
	public ArrayList<User> select(User user){
		try{
			String sql = "select * from `user`";
			pst = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			ArrayList<User> rows = new ArrayList<User>();
			if(rs.next()){
				for(int i = 0; i < rs.getRow(); i++){
					User temp = new User();
					temp.setId(rs.getInt("id"));
					temp.setName(rs.getString("name"));
					temp.setPassword(rs.getString("password"));
					temp.setPhone(rs.getString("phone"));
					temp.setSex(rs.getString("sex"));
					temp.setBirthday(rs.getDate("birthday"));
					temp.setNickname(rs.getString("nickname"));
					temp.setAddress(rs.getString("address"));
					temp.setBalance(rs.getDouble("balance"));
					temp.setAvatarUrl(rs.getString("avatarUrl"));
					rows.add(temp);	
			    	rs.next();
				}	
			}
			return rows;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<User> searchById(int id) throws SQLException, ParseException {
		String sql = "select * from user where id=?";
		pst = conn.prepareStatement(sql);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		ArrayList<User> rows = new ArrayList<User>();
		if (rs.next()) {
			for(int i = 0; i < rs.getRow(); i++){
				User temp = new User();
				temp.setId(rs.getInt("id"));
				temp.setName(rs.getString("name"));
				temp.setPassword(rs.getString("password"));
				temp.setPhone(rs.getString("phone"));
				temp.setSex(rs.getString("sex"));
				temp.setBirthday(rs.getDate("birthday"));
				temp.setNickname(rs.getString("nickname"));
				temp.setAddress(rs.getString("address"));
				temp.setBalance(rs.getDouble("balance"));
				temp.setAvatarUrl(rs.getString("avatarUrl"));
				rows.add(temp);	
		    	rs.next();
			}	
			return rows;
		} else {
			return null;
		}
	}
	
	public ArrayList<User> searchByName(String name) throws SQLException {
		String sql = "select * from user where name=?";
		pst = conn.prepareStatement(sql);
		pst.setString(1, name);
		ResultSet rs = pst.executeQuery();
		ArrayList<User> rows = new ArrayList<User>();
		if (rs.next()) {
			for(int i = 0; i < rs.getRow(); i++){
				User temp = new User();
				temp.setId(rs.getInt("id"));
				temp.setName(rs.getString("name"));
				temp.setPassword(rs.getString("password"));
				temp.setPhone(rs.getString("phone"));
				temp.setSex(rs.getString("sex"));
				temp.setBirthday(rs.getDate("birthday"));
				temp.setNickname(rs.getString("nickname"));
				temp.setAddress(rs.getString("address"));
				temp.setBalance(rs.getDouble("balance"));
				temp.setAvatarUrl(rs.getString("avatarUrl"));
				rows.add(temp);	
		    	rs.next();
			}	
			return rows;
		} else {
			return null;
		}
	}
	
	//删除用户
	public boolean delete(int id) throws SQLException {
		try {
			String sql = "delete from user where id=?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public int updateAdminUser(User user) {
		try {
			Date birthday = new java.sql.Date( user.getBirthday().getTime());
			String sql = "update `user` set  nickname = '"
					+ user.getNickname()
					+ "',sex ='"
					+ user.getSex()
					+ "',birthday ='"
					+ birthday
					+ "',address ='"
					+user.getAddress()
					+"',phone ='"
					+user.getPhone()
					+"',balance ="
					+user.getBalance()
					+" where id = "
					+user.getId();
			pst = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);
			int rs = pst.executeUpdate();
			return rs;


		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
