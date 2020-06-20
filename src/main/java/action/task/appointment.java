package action.task;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pojo.BaseDataPojo;
import pojo.Order;
import service.OrderServiceDAO;

/**
 * Servlet implementation class appointment
 */
@WebServlet("/appointment")
public class appointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderServiceDAO orderSD = new OrderServiceDAO(); 
    private BaseDataPojo<Order> dataPojo = new BaseDataPojo<>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public appointment() {
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
		
		String type = request.getParameter("type");//类型
		int userId = Integer.parseInt(request.getParameter("userId"));//用户id
		int merchantId = Integer.parseInt(request.getParameter("merchantid"));//用户id
		String requirement = request.getParameter("requirement");//订单要求
		String phone = request.getParameter("phone");//用户手机号
		String date = request.getParameter("date");//服务时间
		String region = request.getParameter("region");//服务地址
		Double money = Double.parseDouble(request.getParameter("money"));//佣金
		//2.处理相关数组
		String address = region;
		
		//3.将订单信息导入order对象中
		
		order.setUserid(userId);
		order.setMerchantid(merchantId);
		order.setType(type);
		order.setDescribe(requirement);
		order.setPhone(phone);
		order.setAddress(address);
		order.setTime(date);
		order.setMoney(money);
		order.setState("2");
		if(orderSD.insertOrder(order)==1){
			dataPojo.setSuccess(true);
			dataPojo.setMsg("订单创建成功");
		}
		else{
			dataPojo.setSuccess(false);
			dataPojo.setMsg("订单创建失败");
		}
				
		 //将封装数据返回到小程序端
		System.out.print(new Gson().toJson(dataPojo));
		out.print(new Gson().toJson(dataPojo));
	}

}
