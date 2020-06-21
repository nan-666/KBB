package action.Merchant;


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
import pojo.Merchant;
import service.MerchantServiceDAO;


/**
 * Servlet implementation class orderDetail
 */
@WebServlet("/UpdateAdminMerchant")
public class UpdateMerchant extends HttpServlet {
    private static final long serialVersionUID = 1L;
    MerchantServiceDAO merchantSD = new MerchantServiceDAO();
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMerchant() {
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
        Merchant merchant = new Merchant();

        //1.(参)获取参数值，并保存到POJO对象


        int id = Integer.parseInt(request.getParameter("id"));//用户id
        String name = request.getParameter("name");//用户姓名
        String phone = request.getParameter("phone");//用户手机号
        String title = request.getParameter("title");//店铺名称
        String type = request.getParameter("type");//类型
        String img = request.getParameter("img");//类型
        String address = request.getParameter("address");//服务地址
        String industry = request.getParameter("industry");//本店囊括
        Float balance = Float.parseFloat(request.getParameter("balance"));//用户余额
        //2.将订单信息导入order对象中
        merchant.setId(id);
        merchant.setName(name);
        merchant.setAddress(address);
        merchant.setPhone(phone);
        merchant.setTitle(title);
        merchant.setType(type);
        merchant.setImg(img);
        merchant.setIndustry(industry);
        merchant.setBalance(balance);
        System.out.println(merchant.toString());
        int res = merchantSD.updateAdminMerchant(merchant);
        //将封装数据返回到小程序端


    }

}