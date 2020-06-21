package service;

import DAO.OrderDAO;
import DAO.OrderTypeDAO;
import pojo.OrderType;
import util.DButil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderTypeServiceDAO {
    public ArrayList<OrderType> selectAll() {
        Connection conn = DButil.getConnection();
        OrderTypeDAO orderTypeD = new OrderTypeDAO(conn);
        try{

            ArrayList<OrderType> data = orderTypeD.selectAll();
            return data;
        }catch(Exception e){
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
            return null;
        }finally{
            if(conn != null){
                DButil.closeConnection(conn);
            }
        }
    }



}
