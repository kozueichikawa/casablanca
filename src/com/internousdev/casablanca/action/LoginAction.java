package com.internousdev.casablanca.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.casablanca.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	private String loginId;
	private String password;
	private boolean savedLoginId = false;
	Map<String, Object> session;

	public String execute() {
		String result = ERROR;
		session.put("savedLoginId", savedLoginId);
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		boolean loginFlg = userInfoDAO.getUserInfo(loginId, password);
		if (loginFlg) {
			if (カートの決済ボタン経由でログイン画面にきたかどうか判定) {
				result = "gotocart";
			}
			result = SUCCESS;
		}
		return result;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setSavedLoginId(boolean savedLoginId) {
		this.savedLoginId = savedLoginId;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
