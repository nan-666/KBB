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

import pojo.Admin;
import pojo.User;
import service.AdminService;
import service.UserService;

/**
 * Servlet implementation class getUser
 */
@WebServlet("/getUser")
public class getUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	User user = new User();
	UserService userSD = new UserService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getUser() {
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
		PrintWriter out = response.getWriter();		// 用PrintWriter对象返回数据
		
		
		ArrayList<User> dataPojo = userSD.select(user);
		
		out.print(new Gson().toJson(dataPojo));
	}

}
