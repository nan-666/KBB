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

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import pojo.User;
import service.SettingmsgServiceDAO;

@WebServlet("/main/java/action/settingmsg")
/**
 * Servlet implementation class search
 */
public class settingmsg extends HttpServlet {
	private static final long serialVersionUID = 1L;
	User  merch = new  User();
	SettingmsgServiceDAO merchSD = new SettingmsgServiceDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public settingmsg() {
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
		
		String item = request.getParameter("userid");//userid
		System.out.println(item);
		String nickName=request.getParameter("nickName");
		String avatarUrl=request.getParameter("avatarUrl");
		String gender=request.getParameter("gender");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		System.out.println(address);
		
		
		boolean updatetype=merchSD.updateByType(item,nickName,avatarUrl,gender,phone,address);
		// 将封装数据返回到小程序端
		out.print(updatetype);
		
	}

}