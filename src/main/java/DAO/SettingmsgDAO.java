package dao;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import pojo.Bill;
import pojo.User;

public class SettingmsgDAO {
	private Connection conn = null;
	private java.sql.PreparedStatement pst = null;
	
	// 定义构造函数，实例化时完成连接的注入
	public SettingmsgDAO(Connection conn){
		super();
		this.conn = conn;
	}
	
	public boolean updateByType(String item,String nickName,String avatarUrl,String gender,String phone,String birthday,String information,String sort,String work){
		String sql="";
		if(Integer.parseInt(gender)==0){
			gender="男";
		}else{
			gender="女";
		}
		try{
			
			sql = "update `user` set nickname= '"
						+nickName
						+"'"
						+",avatarUrl='"
						+avatarUrl
						+"'"
						+",sex='"
						+gender
						+"'"
						+",phone='"
						+phone
						+"'"
						+",birthday='"
						+birthday
						+"'"
						+",tag='"
						+information
						+"'"
						+",type='"
						+sort
						+"'"
						+",industry='"
						+work
						+"'"
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
	//获取用户信息
		public ArrayList<User> searchByType(String item){
			String sql="";
			try{
				
				sql = "select * from `user` where id like '%"
							+item
							+"%'";
				
				System.out.print(sql);
				pst = (PreparedStatement) conn.prepareStatement(sql);
				//pst.setString(1, type);
				
				ResultSet rs = pst.executeQuery();
				ArrayList<User> rows = new ArrayList<User>();
				if(rs.next()){
					for(int i = 0 ; i<rs.getRow();i++){
			    		User temp = new User(); 
			    		temp.setNickname(rs.getString("nickname"));
			    		temp.setAvatarUrl(rs.getString("avatarUrl"));
			    		temp.setSex(rs.getString("sex"));
			    		temp.setPhone(rs.getString("phone"));
			    		temp.setBirthday(rs.getDate("birthday"));
			    		temp.setTag(rs.getString("tag"));
			    		temp.setType(rs.getString("type"));
			    		temp.setIndustry(rs.getString("industry"));
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