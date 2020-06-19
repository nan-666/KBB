package action;

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
 * Servlet implementation class takeOrder
 */
@WebServlet("/takeOrder")
public class takeOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderServiceDAO orderSD = new OrderServiceDAO(); 
    private BaseDataPojo<Order> dataPojo = new BaseDataPojo<>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public takeOrder() {
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
		
		int merchantid = Integer.parseInt(request.getParameter("merchantid"));
		int id = Integer.parseInt(request.getParameter("id"));
		
		if(orderSD.updateOrder(merchantid, id) == 1){
			dataPojo.setSuccess(true);
			dataPojo.setMsg("接单成功");
		}
		else{
			dataPojo.setSuccess(false);
			dataPojo.setMsg("您不是服务商，接单失败");
		}
		
		//将封装数据返回到小程序端
		System.out.print(new Gson().toJson(dataPojo));
		out.print(new Gson().toJson(dataPojo));
	}

}
