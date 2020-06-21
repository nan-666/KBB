package action.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pojo.User;
import service.UserService;

/**
 * Servlet implementation class orderDetail
 */
@WebServlet("/UpdateAdminUser")
public class UpdateUser extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserService userSD = new UserService();
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
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
        User user = new User();

        //1.(参)获取参数值，并保存到POJO对象


        int id = Integer.parseInt(request.getParameter("id"));//用户id
        String nickname = request.getParameter("nickname");//用户昵称
        String sex = request.getParameter("sex");//用户性别
        String birthday_item = request.getParameter("birthday");//用户生日
        String phone = request.getParameter("phone");//用户手机号
        String address = request.getParameter("address");//服务地址
        Double balance = Double.parseDouble(request.getParameter("balance"));//用户余额
        //2.将订单信息导入order对象中
        user.setId(id);
        user.setNickname(nickname);
        user.setSex(sex);
        Date birthday = null;
        try {
            birthday = simpleDateFormat.parse(birthday_item);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setBirthday(birthday);
        user.setAddress(address);
        user.setPhone(phone);
        user.setBalance(balance);
        System.out.println(user.toString());
        int res = userSD.updateAdminUser(user);
        //将封装数据返回到小程序端


    }

}