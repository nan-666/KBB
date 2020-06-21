package action.Order;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pojo.Order;
import pojo.OrderType;
import service.OrderServiceDAO;
import service.OrderTypeServiceDAO;

/**
 * Servlet implementation class orderDetail
 */
@WebServlet("/GetOrderTypeAll")
public class GetOrderTypeAll extends HttpServlet {
    private static final long serialVersionUID = 1L;
    OrderType orderType = new OrderType();
    OrderTypeServiceDAO orderTypeSD = new OrderTypeServiceDAO();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOrderTypeAll() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //初始化
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();		// 将响应数据写入服务器，并返回到客户端
        ArrayList<OrderType> data = orderTypeSD.selectAll();
        System.out.println(data);
        out.print(new Gson().toJson(data));
    }

}