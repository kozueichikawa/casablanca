package com.internousdev.casablanca.action;

import java.util.Map;
import java.util.Objects;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.casablanca.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;

	public String execute() {
		String result = SUCCESS;

		/* ログイン状態であるかチェック。セッションが切れていれば即return SUCCESSする
		 * (null値をlogoutメソッドへ渡してNullPointerErrorが出ることを回避) */
		if (Objects.equals(session.get("logined"), "1")) {
			UserInfoDAO userInfoDAO = new UserInfoDAO();

			/* loginedカラムを"0"にupdate */
			userInfoDAO.logout(session.get("loginId").toString());
			session.put("logined", "0");
			System.out.println("ログアウトしました。");
		}
		return result;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
