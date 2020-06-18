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

import pojo.Order;
import service.OrderServiceDAO;

/**
 * Servlet implementation class screen
 */
@WebServlet("/screen")
public class screen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Order order = new Order();
	OrderServiceDAO orderSD = new OrderServiceDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public screen() {
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
				
		String type = request.getParameter("type");
		ArrayList<Order> dataPojo = orderSD.selectByTypeId(type);
		
		System.out.print(new Gson().toJson(dataPojo));
		out.print(new Gson().toJson(dataPojo));
	}

}
