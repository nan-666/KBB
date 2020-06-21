package action.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import pojo.BaseDataPojo;
import pojo.LoginSession;
import service.LoginService;
import util.HttpUtil;

@WebServlet("/main/java/action/login/Login")

public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// GET请求统一有POST处理
		doPost(req, resp);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();		// 将响应数据写入服务器，并返回到客户端 
		
		// 小程序的appId、appSecret
		String appId = "wxf9209f89660b3a5c";
		String appSecret = "63bd4a7ae494f6a8831fbf4818bc70a7";	
		// 获取前端发送的code
		String code = req.getParameter("code");
		System.out.println(code);
		System.out.println(code);
		
		// 调用微信接口请求用的openId、session_key等信息
		String url = "https://api.weixin.qq.com/sns/jscode2session" + "?appid=" + appId + "&secret=" + appSecret + "&js_code=" + code +
				"&grant_type=authorization_code";
		// 在服务端发送请求
		HttpUtil httpUtil = new HttpUtil();
		Map<String,String> map = new HashMap<>();
		String str = httpUtil.doGet(url, map);	// 返回jsonstring形式的结果
		// 解析json字符串，获取openId
		map = new Gson().fromJson(str, Map.class);
		System.out.println(map.toString());
		// 生成token，这里使用时间戳生成token，实际开发中建议使用更加成熟的机制生成token
		String token = "token_" + new Date().getTime();
		System.out.println("openId=" + map.get("openid") + ", token=" + token);
		LoginService loginService = new LoginService();
		BaseDataPojo<LoginSession> dataPojo = loginService.login(map.get("openid"), token);
		// 将封装数据返回到小程序端
		System.out.println(new Gson().toJson(dataPojo).toString());
		out.print(new Gson().toJson(dataPojo));
	}
}
