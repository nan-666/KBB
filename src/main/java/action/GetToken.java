package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import pojo.BaseDataPojo;
import util.QiniuUtil;
@WebServlet("/GetQiniuToken")
public class GetToken extends HttpServlet {
	
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
		
		String key = req.getParameter("key");
		String token = QiniuUtil.getToken(key);
		
	    Map<String,String> map = new HashMap<>();
	    map.put("token", token);
	    out.print(new Gson().toJson(new BaseDataPojo<Map<String, String>>("获取token成功",true, map)));
	}
}
