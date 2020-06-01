package DAO;



import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import pojo.Merchant;
import pojo.Order;
import pojo.BaseDataPojo;

public class MerchantDAO {
	private Connection conn = null;
	private PreparedStatement pst = null;
	
	// 定义构造函数，实例化时完成连接的注入
	public MerchantDAO(Connection conn){
		super();
		this.conn = conn;
	}
	
	//搜索服务商
	public ArrayList<Merchant> searchByType(String type){
		try{
			String sql = "select * from merchant where title like '%"
						+type
						+"%' or industry like '%"
						+type
						+"%' or type like '%"
						+"%'";
			System.out.print(sql);
			pst = (PreparedStatement) conn.prepareStatement(sql);
			//pst.setString(1, type);
			
			ResultSet rs = pst.executeQuery();
			ArrayList<Merchant> rows = new ArrayList<Merchant>();
			if(rs.next()){
				for(int i = 0 ; i<rs.getRow();i++){
		    		Merchant temp = new Merchant(); 
		    		temp.setId(rs.getInt("id"));
		    		temp.setName(rs.getString("name"));
		    		temp.setTitle(rs.getString("title"));
		    		temp.setImg(rs.getString("img"));
		    		temp.setAddress(rs.getString("address"));
		    		temp.setIndustry(rs.getString("industry"));
		    		temp.setStar(rs.getInt("star"));
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
	
	//查询服务商
	public ArrayList<Merchant> select(Merchant merchant){
		try{
			String sql = "select * from `merchant`";
			pst = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			ArrayList<Merchant> rows = new ArrayList<Merchant>();
			if(rs.next()){
				for(int i = 0; i < rs.getRow(); i++){
					Merchant temp = new Merchant();
					temp.setId(rs.getInt("id"));
					temp.setName(rs.getString("name"));
					temp.setPhone(rs.getString("phone"));
					temp.setTitle(rs.getString("title"));
					temp.setType(rs.getString("type"));
					temp.setAddress(rs.getString("address"));
					temp.setImg(rs.getString("img"));
					temp.setIndustry(rs.getString("industry"));
					temp.setStar(rs.getFloat("star"));
					
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
