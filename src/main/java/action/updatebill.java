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
import pojo.Bill;
import pojo.LoginSession;
import service.BillServiceDAO;

@WebServlet("/main/java/action/updatebill")

public class updatebill extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Bill  merch = new  Bill();
	BillServiceDAO merchSD = new BillServiceDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatebill() {
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
		String item = request.getParameter("userid");
		String balance = request.getParameter("inputmoney");
		boolean updatetype=merchSD.updateByType(item,balance);
		// 将封装数据返回到小程序端
		out.print(updatetype);
		
	}

}