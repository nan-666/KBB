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
import util.TLSSigAPIv2;

@WebServlet("/GetUserSig")
public class GetUserSig extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * 腾讯云 SDKAppId，需要替换为您自己账号下的 SDKAppId。
	 * 进入腾讯云云通信[控制台](https://console.cloud.tencent.com/avc ) 创建应用，即可看到 SDKAppId，
	 * 它是腾讯云用于区分客户的唯一标识。
	 */
	public static final long SDKAPPID = 1400374895L;

	/**
	 * 计算签名用的加密密钥，获取步骤如下： step1.
	 * 进入腾讯云云通信[控制台](https://console.cloud.tencent.com/avc ) ，如果还没有应用就创建一个，
	 * step2. 单击“应用配置”进入基础配置页面，并进一步找到“帐号体系集成”部分。 step3. 点击“查看密钥”按钮，就可以看到计算
	 * UserSig 使用的加密的密钥了。
	 */
	private static final String SECRETKEY = "976e3833ed80630528a63910cbcc10e62db5075ed52e894c99cc38226fbc848d";

	/**
	 * 签名过期时间，建议不要设置的过短 时间单位：秒 默认时间：7 x 24 x 60 x 60 = 604800 = 7 天
	 */
	private static final int EXPIRETIME = 604800;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); // 用PrintWriter对象将返回结果写入服务器

		String userId = request.getParameter("userId");
		TLSSigAPIv2 tls = new TLSSigAPIv2(SDKAPPID, SECRETKEY);
		String userSig = tls.genSig(userId, EXPIRETIME);
		Map<String, String> map = new HashMap<>();
		map.put("userSig", userSig);
		if(userSig != null){
		 out.print(new Gson().toJson(new BaseDataPojo<Map<String,String>>("获取userSig成功", true, map)));
		}else {
		 out.print(new Gson().toJson(new BaseDataPojo<Map<String,String>>("获取userSig失败", false, map)));
		}
	}
}

