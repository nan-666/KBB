package dao;



import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import pojo.order;

public class OrderDAO {
	private Connection conn = null;
	private PreparedStatement pst = null;
	
	// 定义构造函数，实例化时完成连接的注入
	public OrderDAO(Connection conn){
		super();
		this.conn = conn;
	}
	
	//查询全部订单
	public ArrayList<order> searchByType(String item,String userid){
		String sql;
		try{
			if(item.equals("0")){
				sql = "select * from `order` where userid like '%"
						+userid
						+"%'"
						;
			}else{
			sql = "select * from `order` where userid like '%"
						+userid
						+"%'"
						+"and state like '%"
						+item
						+"%'"
						;
			}
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
		    		temp.setType(rs.getString("type"));
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
}