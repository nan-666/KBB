package dao;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import pojo.order;

public class OrderDAO {
	private Connection conn = null;
	private java.sql.PreparedStatement pst = null;
	
	// 定义构造函数，实例化时完成连接的注入
	public OrderDAO(Connection conn){
		super();
		this.conn = conn;
	}
	
	//查询全部订单
	public ArrayList<order> searchByType(String item,String userid){
		String sql;
		try{
			
			sql = "select * from `order` where userid like '%"
						+userid
						+"%'"
						+"and state like '%"
						+item
						+"%'"
						;
			
			System.out.print(sql);
			pst = (PreparedStatement) conn.prepareStatement(sql);
			//pst.setString(1, type);
			
			ResultSet rs = pst.executeQuery();
			ArrayList<order> rows = new ArrayList<order>();
			if(rs.next()){
				for(int i = 0 ; i<rs.getRow();i++){
		    		order temp = new order(); 
		    		temp.setId(rs.getInt("id"));
		    		temp.setUserid(rs.getInt("userid"));
		    		temp.setPhone(rs.getString("phone"));
		    		temp.setIcon(rs.getString("icon"));
		    		temp.setTime(rs.getTime("time"));
		    		temp.setAddress(rs.getString("address"));
		    		temp.setTitle(rs.getString("title"));
		    		temp.setType(rs.getString("ordertypeid"));
		    		temp.setMoney(rs.getInt("money"));
		    		temp.setImg_1(rs.getString("img_1"));
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
	public boolean deleteType(String item){
		String sql="";
		try{
			
			sql = "delete from `order` where id= "
						+item
						;
			
			System.out.print(sql);
			pst = conn.prepareStatement(sql);
			//pst.setString(1, type);
			
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean upstateType(String id,String state){
		String sql="";
		try{
			
			sql = "update `order` set state= "
						+state
						+" where id="
						+id
						;
			
			System.out.print(sql);
			pst = conn.prepareStatement(sql);
			//pst.setString(1, type);
			
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
}