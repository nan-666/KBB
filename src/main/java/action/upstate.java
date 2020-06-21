package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pojo.BaseDataPojo;
import pojo.order;
import pojo.LoginSession;
import service.OrderServiceDAO;

@WebServlet("/main/java/action/upstate")

public class upstate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	order  merch = new  order();
	OrderServiceDAO merchSD = new OrderServiceDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public upstate() {
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
		
		//1.(参)获取参数值，并保存到POJO对象
		//此item系userId
		String id = request.getParameter("id");//order中的id
		String state = request.getParameter("state");//order中的id

		boolean updatetype=merchSD.upstateType(id,state);
		// 将封装数据返回到小程序端
		out.print(updatetype);
		
	}

}