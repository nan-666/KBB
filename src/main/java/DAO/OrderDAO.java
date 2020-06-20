package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Order;

import com.mysql.jdbc.PreparedStatement;
import pojo.Content;

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
			String sql = "select `order`.id,"
					+ "`order`.userid,"
					+ "`user`.`name`,"
					+ "`order`.phone,"
					+ "`order`.time,"
					+ "`order`.address,"
					+ "`order`.`describe`,"
					+ "`order`.money,"
					+ "`order`.img_1,"
					+ "`order`.img_2,"
					+ "`order`.img_3,"
					+ "`orderstate`.state,"
					+ "`ordertype`.type"
					+ " from `order` INNER JOIN `user` on `order`.userid = `user`.id"
					+ " INNER JOIN `orderstate` on `order`.state = `orderstate`.id"
					+ " INNER JOIN `ordertype` on `order`.ordertypeid = `ordertype`.id";
			pst = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			ArrayList<Order> rows = new ArrayList<Order>();
			if(rs.next()){
				for(int i = 0; i < rs.getRow(); i++){
					Order temp = new Order();
					temp.setId(rs.getInt("id"));
					temp.setUserid(rs.getInt("userid"));
					temp.setUser(rs.getString("name"));
					temp.setPhone(rs.getString("phone"));
					temp.setTime(rs.getString("time"));
					temp.setType(rs.getString("type"));
					temp.setAddress(rs.getString("address"));
					temp.setDescribe(rs.getString("describe"));
					temp.setMoney(rs.getDouble("money"));
					temp.setImg_1(rs.getString("img_1"));
					temp.setImg_2(rs.getString("img_2"));
					temp.setImg_3(rs.getString("img_3"));
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
			String sql = "select `order`.id,"
					+ "`order`.userid,"
					+ "`user`.`name`,"
					+ "`order`.phone,"
					+ "`order`.title,"
					+ "`order`.time,"
					+ "`ordertype`.type,"
					+ "`order`.address,"
					+ "`order`.`describe`,"
					+ "`order`.money,"
					+ "`order`.img_1,"
					+ "`order`.img_2,"
					+ "`order`.img_3,"
					+ "`orderstate`.state "
					+ " from `order` INNER JOIN `user` on `order`.userid = `user`.id"
					+ " INNER JOIN `orderstate` on `order`.state = `orderstate`.id"
					+ " INNER JOIN `ordertype` on `order`.ordertypeid = `ordertype`.id"
					+ " where `order`.id=?";
			pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			ArrayList<Order> rows = new ArrayList<Order>();
			if(rs.next()){
				for(int i = 0; i < rs.getRow(); i++){
					Order temp = new Order();
					temp.setId(rs.getInt("id"));
					temp.setUserid(rs.getInt("userid"));
					temp.setUser(rs.getString("name"));
					temp.setPhone(rs.getString("phone"));
					temp.setTitle(rs.getString("title"));
					temp.setTime(rs.getString("time"));
					temp.setType(rs.getString("type"));
					temp.setAddress(rs.getString("address"));
					temp.setDescribe(rs.getString("describe"));
					temp.setMoney(rs.getDouble("money"));
					temp.setImg_1(rs.getString("img_1"));
					temp.setImg_2(rs.getString("img_2"));
					temp.setImg_3(rs.getString("img_3"));
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
			String sql = "select `order`.id,"
					+ "`order`.userid,"
					+ "`user`.`name`,"
					+ "`order`.phone,"
					+ "`order`.title,"
					+ "`order`.time,"
					+"`ordertype`.type,"
					+ "`order`.address,"
					+ "`order`.`describe`,"
					+ "`order`.money,"
					+ "`order`.img_1,"
					+"`order`.img_2,"
					+ "`order`.img_3,"
					+ "`orderstate`.state"
					+ " from `order` INNER JOIN `user` on `order`.userid = `user`.id"
					+ " INNER JOIN `orderstate` on `order`.state = `orderstate`.id"
					+ " INNER JOIN `ordertype` on `order`.ordertypeid = `ordertype`.id"
					+ " where `order`.title like '%"
					+word
					+"%' or `order`.`describe` like '%"
					+word
					+"%' or `ordertype`.type like '%"
					+word
					+"%'";
			
			pst = (PreparedStatement) conn.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			ArrayList<Order> rows = new ArrayList<Order>();
			if(rs.next()){
				for(int i = 0 ; i<rs.getRow();i++){
		    		Order temp = new Order(); 
		    		temp.setId(rs.getInt("id"));
					temp.setUserid(rs.getInt("userid"));
					temp.setUser(rs.getString("name"));
					temp.setPhone(rs.getString("phone"));
					temp.setTitle(rs.getString("title"));
					temp.setTime(rs.getString("time"));
					temp.setType(rs.getString("type"));
					temp.setAddress(rs.getString("address"));
					temp.setDescribe(rs.getString("describe"));
					temp.setMoney(rs.getDouble("money"));
					temp.setImg_1(rs.getString("img_1"));
					temp.setImg_2(rs.getString("img_2"));
					temp.setImg_3(rs.getString("img_3"));
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
			String sql = "select `order`.id,"
					+ "`order`.userid,"
					+ "`user`.`name`,"
					+ "`order`.phone,"
					+ "`order`.title,"
					+ "`order`.time,"
					+"`ordertype`.type,"
					+ "`order`.address,"
					+ "`order`.`describe`,"
					+ "`order`.money,"
					+ "`order`.img_1,"
					+"`order`.img_2,"
					+ "`order`.img_3,"
					+ "`orderstate`.state"
					+ " from `order` INNER JOIN `user` on `order`.userid = `user`.id"
					+ " INNER JOIN `orderstate` on `order`.state = `orderstate`.id"
					+ " INNER JOIN `ordertype` on `order`.ordertypeid = `ordertype`.id"
					+ " where `ordertype`.id="+id;
			pst = (PreparedStatement) conn.prepareStatement(sql);
			System.out.print(sql);
			ResultSet rs = pst.executeQuery();
			ArrayList<Order> rows = new ArrayList<Order>();
			if(rs.next()){
				for(int i = 0; i < rs.getRow(); i++){
					Order temp = new Order();
					temp.setId(rs.getInt("id"));
					temp.setUserid(rs.getInt("userid"));
					temp.setUser(rs.getString("name"));
					temp.setPhone(rs.getString("phone"));
					temp.setTitle(rs.getString("title"));
					temp.setTime(rs.getString("time"));
					temp.setType(rs.getString("type"));
					temp.setAddress(rs.getString("address"));
					temp.setDescribe(rs.getString("describe"));
					temp.setMoney(rs.getDouble("money"));
					temp.setImg_1(rs.getString("img_1"));
					temp.setImg_2(rs.getString("img_2"));
					temp.setImg_3(rs.getString("img_3"));
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
	
	public int insetOrder(Order order) {
        try{
            String sql = "insert into `order`(`userid`,`phone`,`time`,`address`,`describe`,`money`,`img_1`,`img_2`,`img_3`,`ordertypeid`,`state`) value ('";
            sql = sql+order.getUserid()+"','";
            sql = sql+order.getPhone()+"','";
            sql = sql+order.getTime()+"','";
            sql = sql+order.getAddress()+"','";
            sql = sql+order.getDescribe()+"','";
            sql = sql+order.getMoney()+"','";
            
            
            if(order.getImg_1()== null){
                sql = sql+"/"+"','";
            }else{
                sql = sql+order.getImg_1()+"','";
            }
            if(order.getImg_2() == null){
                sql = sql+"/"+"','";
            }else{
                sql = sql+order.getImg_2()+"','";
            }
            if(order.getImg_3() == null){
                sql = sql+"/"+"','";
            }else{
                sql = sql+order.getImg_3()+"','";
            }
            sql = sql+order.getOrdertypeid()+"','";
            sql = sql+order.getState()+"')";
            pst = (PreparedStatement) conn.prepareStatement(sql);
            int rs = pst.executeUpdate();
            return rs;
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
	
	public int insertOrder(Order order) {
        try{
            String sql = "insert into `order`(`userid`,`merchantid`,`phone`,`time`,`address`,`describe`,`money`,`ordertypeid`,`state`) value ('";
            sql = sql+order.getUserid()+"','";
            sql = sql+order.getMerchantid()+"','";
            sql = sql+order.getPhone()+"','";
            sql = sql+order.getTime()+"','";
            sql = sql+order.getAddress()+"','";
            sql = sql+order.getDescribe()+"','";
            sql = sql+order.getMoney()+"','";
            sql = sql+this.selectByType(order.getType())+"','";
            sql = sql+order.getState()+"')";
            pst = (PreparedStatement) conn.prepareStatement(sql);
            int rs = pst.executeUpdate();
            return rs;
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
	
	//服务商接单
	public int updateOrder(int merchantid,int id){
		try{
			String Sql = "select id from `merchant` where id="+merchantid;
			pst = (PreparedStatement) conn.prepareStatement(Sql);
			ResultSet r = pst.executeQuery();
			if(r.next()){
				String sql = "update `order` set merchantid = "
					     +merchantid
					     +",state = 2"
					     +" where id = "
					     +id;
				pst = (PreparedStatement) conn.prepareStatement(sql);
				int rs = pst.executeUpdate();
				return rs;
			}else{
				return 0;
			}
			
		}catch(Exception e){
            e.printStackTrace();
            return 0;
        }
	}
	
	//删除任务
	public boolean delete(int id) throws SQLException {
		try {
			String sql = "delete from `order` where id=?";
			pst = (PreparedStatement)conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	//获取订单总数，交易金额，用户总数，服务商总数
	public ArrayList<Content> content() {
		try{
			ArrayList<Content> rows = new ArrayList<Content>();
			Content temp = new Content();
			String sql = "select sum(money) as money from `order`";
			pst = (PreparedStatement) conn.prepareStatement(sql);
			System.out.println(sql);
		    ResultSet rs = pst.executeQuery();
		    if(rs.next()){
		    	Double figure = rs.getDouble("money");
		    	temp.setFigure(figure);
		    }
		    sql = "select count(*) as cnt from `order`";
			pst = (PreparedStatement) conn.prepareStatement(sql);
			System.out.println(sql);
		    rs = pst.executeQuery();
		    if(rs.next()){
		    	int cnt = rs.getInt("cnt");
		    	temp.setOrders(cnt);
		    }
		    sql = "select count(*) as cnt from `merchant`";
			pst = (PreparedStatement) conn.prepareStatement(sql);
			System.out.println(sql);
		    rs = pst.executeQuery();
		    if(rs.next()){
		    	int cnt = rs.getInt("cnt");
		    	temp.setMerchants(cnt);
		    }
		    sql = "select count(*) as cnt from `user`";
			pst = (PreparedStatement) conn.prepareStatement(sql);
			System.out.println(sql);
		    rs = pst.executeQuery();
		    if(rs.next()){
		    	int cnt = rs.getInt("cnt");
		    	temp.setMembers(cnt);
		    }
		    System.out.print(temp);
		    rows.add(temp);
		    
		    return rows;
		}
		catch(Exception e){
		      e.printStackTrace();
		      return null;
		}
	}
}
