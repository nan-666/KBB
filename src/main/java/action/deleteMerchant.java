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
import pojo.Merchant;
import pojo.User;
import service.MerchantServiceDAO;
import service.UserService;

/**
 * Servlet implementation class deleteMerchant
 */
@WebServlet("/deleteMerchant")
public class deleteMerchant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Merchant merchant = new Merchant();
	MerchantServiceDAO merchantSD = new MerchantServiceDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteMerchant() {
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
		PrintWriter out = response.getWriter(); // 用PrintWriter对象将返回结果写入服务器

		int id = Integer.parseInt(request.getParameter("id"));
		merchant.setId(id);
			
		BaseDataPojo<Merchant> dataPojo = merchantSD.delete(id);
		out.print(new Gson().toJson(dataPojo));
		
	}

}
