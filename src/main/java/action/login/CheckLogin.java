package action.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import pojo.BaseDataPojo;
import pojo.LoginSession;
import service.LoginService;

@WebServlet("/main/java/login/CheckLogin")
public class CheckLogin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// GET请求统一有POST处理
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();		// 将响应数据写入服务器，并返回到客户端 
		
		// 获取前端发送的token
		String token = req.getParameter("token");
		System.out.print(token);
		LoginService loginService = new LoginService();
		int id = loginService.checkToken(token);
		if(id != -1){
			out.print(new Gson().toJson(new BaseDataPojo<LoginSession>("token有效"+id,true, null)));
			System.out.println("token有效"+id);
		}else{
			out.print(new Gson().toJson(new BaseDataPojo<LoginSession>("token无效",false, null)));
		}
	}
}
