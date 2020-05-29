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

import pojo.Merchant;
import pojo.BaseDataPojo;
import service.MerchantServiceDAO;

/**
 * Servlet implementation class search
 */
@WebServlet("/merchant/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Merchant  merch = new  Merchant();
	MerchantServiceDAO merchSD = new MerchantServiceDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public search() {
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
		String type = request.getParameter("type");
		ArrayList<Merchant> dataPojo = merchSD.searchByType(type);
				
		// 将封装数据返回到小程序端
		System.out.print(new Gson().toJson(dataPojo));
		out.print(new Gson().toJson(dataPojo));
		
	}

}
