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
import service.MerchantServiceDAO;

/**
 * Servlet implementation class MerchantGet
 */
@WebServlet("/MerchantGet")
public class MerchantGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Merchant merchant = new Merchant();
	MerchantServiceDAO merchantSD = new MerchantServiceDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MerchantGet() {
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
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();		// 将响应数据写入服务器，并返回到客户端
		
		ArrayList<Merchant> dataPojo = merchantSD.select(merchant);
		
		System.out.print(new Gson().toJson(dataPojo));
		out.print(new Gson().toJson(dataPojo));
	}

}
