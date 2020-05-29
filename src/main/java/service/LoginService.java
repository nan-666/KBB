package service;

import java.sql.Connection;
import java.sql.SQLException;

import util.DButil;
import dao.LoginDAO;
import dao.UserDAO;
import pojo.BaseDataPojo;
import pojo.LoginSession;
import pojo.ser;

public class LoginService {
	
	

	public BaseDataPojo<LoginSession> login(String openId, String token) {
		// 调用dao层查询数据库，是否存在此openId
		LoginSession loginSession = selectByOpenId(openId);
		if (loginSession != null) { // 数据库中已存在此openId，说明此用户已存在，只需要更新token
			loginSession.setToken(token); // 重置token
			// 更新loginsession表
			if (update(loginSession)) { // 更新成功，将新的token返回
				return new BaseDataPojo<LoginSession>("登录成功", true, loginSession);
			} else {
				return new BaseDataPojo<LoginSession>("登录失败", false, null);
			}
		} else { // 无此openId，说明没有此用户，需要在user表中插入一条新数据，并且在LoginSession表中也要插入一条数据
			ser user = new ser();
			user.setName("新用户_" + token); // 新用户的默认名称
			user.setCredit(0); // 初始积分
			int userId = addUser(user);
			if (userId != -1) { // 添加用户成功，并获取到userId
				// 将openId、token、useId插入到loginsession表中
				LoginSession loginSession2 = new LoginSession();
				loginSession2.setOpenId(openId);
				loginSession2.setToken(token);
				loginSession2.setUserId(userId);
				if(insert(loginSession2)){		// 登录表中添加数据成功，此数据关联了用户的token、userId及openId
					return new BaseDataPojo<LoginSession>("登录成功", true, loginSession2);
				}else{
					return new BaseDataPojo<LoginSession>("登录失败，添加openId级token时错误", false, null);
				}
			}else{
				return new BaseDataPojo<LoginSession>("登录失败，添加新用户时错误", false, null);
			}
		}
	}
	
	public int checkToken(String token) {
		LoginSession loginSession = selectByToken(token);
		if (loginSession != null) { // 数据库查到此token，表示token有效并返回userId
			return loginSession.getUserId();
		} else { // 数据库中没查到此token，表示token过期或者无此记录
			return -1;
		}
	}
	
	public LoginSession selectByToken(String token) {
		Connection conn = DButil.getConnection();
		LoginDAO loginDAO = new LoginDAO(conn);
		LoginSession session = null;
		try {
			session = loginDAO.selectByToken(token);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				DButil.closeConnection(conn);
			}
		}
		return session;
	}


	// 插入数据库表loginsession
	public boolean insert(LoginSession loginSession) {
		Connection conn = DButil.getConnection();
		LoginDAO loginDAO = new LoginDAO(conn);
		try {
			loginDAO.insert(loginSession);
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return false;
		} finally {
			if (conn != null) {
				DButil.closeConnection(conn);
			}
		}
	}

	// 更新数据库表loginsession
	public boolean update(LoginSession loginSession) {
		Connection conn = DButil.getConnection();
		LoginDAO loginDAO = new LoginDAO(conn);
		try {
			loginDAO.update(loginSession);
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (conn != null) {
				DButil.closeConnection(conn);
			}
		}

	}

	public int addUser(ser user) {
		Connection conn = DButil.getConnection();
		UserDAO userDAO = new UserDAO(conn);
		try {
			int id = userDAO.insert(user);
			conn.commit();
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			if (conn != null) {
				DButil.closeConnection(conn);
			}
		}
	}

	// 根据openId查询
	public LoginSession selectByOpenId(String openId) {
		Connection conn = DButil.getConnection();
		LoginDAO loginDAO = new LoginDAO(conn);
		LoginSession loginSession = null;
		try {
			loginSession = loginDAO.selectByOpenId(openId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				DButil.closeConnection(conn);
			}
		}
		return loginSession;
	}
}
