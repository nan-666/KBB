package DAO;

import com.mysql.jdbc.PreparedStatement;
import pojo.OrderType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class OrderTypeDAO {
    private Connection conn = null;
    private PreparedStatement pst = null;

    // 定义构造函数，实例化时完成连接的注入
    public OrderTypeDAO(Connection conn){
        super();
        this.conn = conn;
    }

    public ArrayList<OrderType> selectAll() {
        try{
            String sql = "select * from ordertype";
            pst = (PreparedStatement) conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();
            ArrayList<OrderType> rows = new ArrayList<OrderType>();
            if(rs.next()){
                for(int i = 0; i < rs.getRow(); i++){
                    OrderType temp = new OrderType();
                    temp.setId(rs.getInt("id"));
                    temp.setType(rs.getString("type"));
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
