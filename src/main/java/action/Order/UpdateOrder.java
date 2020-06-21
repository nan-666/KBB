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
import service.OrderServiceDAO;

/**
 * Servlet implementation class orderDetail
 */
@WebServlet("/UpdateOrder")
public class UpdateOrder extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Order order = new Order();
    OrderServiceDAO orderSD = new OrderServiceDAO();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOrder() {
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
        Order order = new Order();

        //1.(参)获取参数值，并保存到POJO对象

        int type = Integer.parseInt(request.getParameter("type"));//类型id
        int id = Integer.parseInt(request.getParameter("id"));//订单id
        String describe = request.getParameter("describe");//订单要求
        String phone = request.getParameter("phone");//用户手机号
        String address = request.getParameter("address");//服务地址
        Double money = Double.parseDouble(request.getParameter("money"));//佣金
        //2.处理相关数组



        //3.将订单信息导入order对象中
        order.setId(id);
        order.setOrdertypeid(type);
        order.setDescribe(describe);
        order.setPhone(phone);
        order.setAddress(address);
        order.setMoney(money);

        int res = orderSD.updateAdminOrder(order);
        //将封装数据返回到小程序端


    }

}