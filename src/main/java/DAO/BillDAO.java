package DAO;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import pojo.Bill;

public class BillDAO {
	private Connection conn = null;
	private java.sql.PreparedStatement pst = null;
	
	// 定义构造函数，实例化时完成连接的注入
	public BillDAO(Connection conn){
		super();
		this.conn = conn;
	}
	
	//获取用户账户
	public ArrayList<Bill> searchByType(String item){
		String sql="";
		try{
			
			sql = "select balance from `user` where id like '%"
						+item
						+"%'";
			
			System.out.print(sql);
			pst = (PreparedStatement) conn.prepareStatement(sql);
			//pst.setString(1, type);
			
			ResultSet rs = pst.executeQuery();
			ArrayList<Bill> rows = new ArrayList<Bill>();
			if(rs.next()){
				for(int i = 0 ; i<rs.getRow();i++){
		    		Bill temp = new Bill(); 
		    		temp.setBalance(rs.getInt("balance"));
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
	public boolean updateByType(String item,String balance){
		String sql="";
		try{
			
			sql = "update `user` set balance= "
						+balance
						+" where id="
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

}