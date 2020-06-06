package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import pojo.Order;
import pojo.User;

import com.mysql.jdbc.PreparedStatement;

public class OrderDAO {
	private Connection conn = null;
	private PreparedStatement pst = null;
	
	// 定义构造函数，实例化时完成连接的注入
	public OrderDAO(Connection conn){
		super();
		this.conn = conn;
	}
	
	//查询任务
	public ArrayList<Order> select(Order order){
		try{
			String sql = "select * from `order`";
			pst = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			ArrayList<Order> rows = new ArrayList<Order>();
			if(rs.next()){
				for(int i = 0; i < rs.getRow(); i++){
					Order temp = new Order();
					temp.setId(rs.getInt("id"));
					temp.setUserid(rs.getInt("userid"));
					temp.setPhone(rs.getString("phone"));
					temp.setIcon(rs.getString("icon"));
					temp.setTime(rs.getString("time"));
					temp.setAddress(rs.getString("address"));
					temp.setTitle(rs.getString("title"));
					temp.setDescribe(rs.getString("describe"));
					temp.setType(rs.getString("type"));
					temp.setMoney(rs.getDouble("money"));
					temp.setImg_1(rs.getString("img_1"));
					temp.setImg_2(rs.getString("img_2"));
					temp.setImg_3(rs.getString("img_3"));
					temp.setImg_4(rs.getString("img_4"));
					temp.setImg_5(rs.getString("img_5"));
					temp.setState(rs.getString("state"));
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
	
	//根据任务id查询任务详情
	public ArrayList<Order> selectById(int id){
		try{
			String sql = "select * from `order` where id =?";
			pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			ArrayList<Order> rows = new ArrayList<Order>();
			if(rs.next()){
				for(int i = 0; i < rs.getRow(); i++){
					Order temp = new Order();
					temp.setId(rs.getInt("id"));
					temp.setUserid(rs.getInt("userid"));
					temp.setPhone(rs.getString("phone"));
					temp.setTime(rs.getString("time"));
					temp.setAddress(rs.getString("address"));
					temp.setTitle(rs.getString("title"));
					temp.setDescribe(rs.getString("describe"));
					temp.setType(rs.getString("type"));
					temp.setMoney(rs.getDouble("money"));
					temp.setImg_1(rs.getString("img_1"));
					temp.setImg_2(rs.getString("img_2"));
					temp.setState(rs.getString("state"));
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
}
