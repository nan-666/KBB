package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import pojo.Order;

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
					temp.setState(rs.getInt("state")+"");
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
					temp.setState(rs.getInt("state")+"");
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

	//查询订单状态
	public String selectState(int id){
		try{
			String sql = "select * from `orderstate` where id =?";
			pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			if(rs.next()){
				return rs.getString("state");
			} else {
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	//搜索任务
	public ArrayList<Order> searchByWord(String word){
		try{
			String sql = "select * from `order` where title like '%"
					+word
					+"%' or `describe` like '%"
					+word
					+"%' or type like '%"
					+word
					+"%'";
			System.out.print(sql);
			pst = (PreparedStatement) conn.prepareStatement(sql);
			//pst.setString(1, type);

			ResultSet rs = pst.executeQuery();
			ArrayList<Order> rows = new ArrayList<Order>();
			if(rs.next()){
				for(int i = 0 ; i<rs.getRow();i++){
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
					temp.setState(rs.getInt("state")+"");
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

	//根据type查询任务类型id
	public int selectByType(String type){
		try{
			String sql = "select id from `ordertype` where type=?";
			pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setString(1, type);
			ResultSet rs = pst.executeQuery();

			if(rs.next()){
				return rs.getInt("id");
			} else {
				return 0;
			}

		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	//根据type类型查询任务
	public ArrayList<Order> selectByTypeId(String type){
		try{
			int id = this.selectByType(type);
			String sql = "select * from `order` where ordertypeid="+id;
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
					temp.setState(rs.getInt("state")+"");
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
    public int insetOrder(Order order) {
        try{
            String sql = "insert into `order`(`userid`,`phone`,`time`,`address`,`describe`,`type`,`money`,`img_1`,`img_2`,`img_3`,`state`) value ('";
            sql = sql+order.getUserid()+"','";
            sql = sql+order.getPhone()+"','";
            sql = sql+order.getTime()+"','";
            sql = sql+order.getAddress()+"','";
            sql = sql+order.getDescribe()+"','";
            sql = sql+order.getType()+"','";
            sql = sql+order.getMoney()+"','";
            if(order.getImg_1().equals(null)){
                sql = sql+"/"+"','";
            }else{
                sql = sql+order.getImg_1()+"','";
            }
            if(order.getImg_2().equals(null)){
                sql = sql+"/"+"','";
            }else{
                sql = sql+order.getImg_2()+"','";
            }
            if(order.getImg_3().equals(null)){
                sql = sql+"/"+"','";
            }else{
                sql = sql+order.getImg_3()+"','";
            }
            sql = sql+order.getState()+"')";
            System.out.println(sql);
            pst = (PreparedStatement) conn.prepareStatement(sql);
            int rs = pst.executeUpdate();
            return rs;
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
}
