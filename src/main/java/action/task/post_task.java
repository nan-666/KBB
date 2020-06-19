package action.task;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pojo.BaseDataPojo;
import pojo.Merchant;
import pojo.Order;
import service.OrderServiceDAO;

/**
 * Servlet implementation class post_task
 */
@WebServlet("/task/post_task")
public class post_task extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private OrderServiceDAO orderSD = new OrderServiceDAO(); 
    private BaseDataPojo<Order> dataPojo = new BaseDataPojo<>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public post_task() {
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
				
				String type = request.getParameter("num");//用户id
				int userId = Integer.parseInt(request.getParameter("userId"));//用户id
				String requirement = request.getParameter("requirement");//订单要求
				String phone = request.getParameter("phone");//用户手机号
				String date = request.getParameter("date");//服务时间
				String region = request.getParameter("region");//服务地址
				String[] image = request.getParameterValues("images");//服务地址
				Double money = Double.parseDouble(request.getParameter("money"));//佣金
				//2.处理相关数组
				String address = region;
				String image1 = image[0];
				String images[] = image1.split(",");
				if(images.length>=1){
					String img_1 = images[0];
					order.setImg_1(img_1);
					}
				if(images.length>=2){
				String img_2 = images[1];
				order.setImg_2(img_2);
				}
				if(images.length>=3){
				String img_3 = images[2];
				order.setImg_3(img_3);
				}
				
				//3.将订单信息导入order对象中
				
				order.setUserid(userId);
				order.setType(type);
				order.setDescribe(requirement);
				order.setPhone(phone);
				order.setAddress(address);
				order.setTime(date);
				order.setMoney(money);
				order.setState("1");
				if(orderSD.insetOrder(order)==1){
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
