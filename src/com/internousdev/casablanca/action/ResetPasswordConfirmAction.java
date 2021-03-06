package com.internousdev.casablanca.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.casablanca.dao.MCategoryDAO;
import com.internousdev.casablanca.dao.UserInfoDAO;
import com.internousdev.casablanca.dto.MCategoryDTO;
import com.internousdev.casablanca.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordConfirmAction extends ActionSupport implements SessionAware{
	private String loginId;
	private String password;
	private String newPassword;
	private String reConfirmationPassword;

	private List<String> loginIdErrorMessageList = new ArrayList<String>();
	private List<String> passwordErrorMessageList = new ArrayList<String>();
	private List<String> passwordIncorrectErrorMessageList = new ArrayList<String>();
	private List<String> newPasswordErrorMessageList = new ArrayList<String>();
	private List<String> reConfirmationNewPasswordErrorMessageList = new ArrayList<String>();
	private List<String> newPasswordIncorrectErrorMessageList = new ArrayList<String>();

	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;
		InputChecker inputChecker = new InputChecker();

		loginIdErrorMessageList = inputChecker.doCheck("ログインID", loginId, 1, 8, true, false, false, true, false, false, false, false, false);
		passwordErrorMessageList = inputChecker.doCheck("現在のパスワード", password, 1, 16, true, false, false, true, false, false, false, false, false);
		newPasswordErrorMessageList = inputChecker.doCheck("新しいパスワード", newPassword, 1, 16, true, false, false, true, false, false, false, false, false);
		reConfirmationNewPasswordErrorMessageList = inputChecker.doCheck("新しいパスワード（再確認）", reConfirmationPassword, 1, 16, true, false, false, true, false, false, false, false, false);

		newPasswordIncorrectErrorMessageList = inputChecker.doPasswordCheck(newPassword, reConfirmationPassword);

		if(loginIdErrorMessageList.size()==0
		&& passwordErrorMessageList.size()==0
		&& newPasswordErrorMessageList.size()==0
		&& reConfirmationNewPasswordErrorMessageList.size()==0
		&& newPasswordIncorrectErrorMessageList.size()==0) {

			UserInfoDAO userInfoDAO = new UserInfoDAO();
			if(userInfoDAO.isExistsUserInfo(loginId, password)) {
				String concealedPassword = userInfoDAO.concealPassword(password);
				session.put("loginId", loginId);
				session.put("newPassword", newPassword);
				session.put("concealedPassword", concealedPassword);
				result = SUCCESS;
			}else{
				passwordIncorrectErrorMessageList.add("入力されたパスワードが異なります。");
			}
		}
		if(!session.containsKey("mCategoryList")) {
			MCategoryDAO mCategoryDAO=new MCategoryDAO();
			List<MCategoryDTO> mCategoryDtoList= mCategoryDAO.getMCategoryList();
			session.put("mCategoryDtoList", mCategoryDtoList);
		}
		return result;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public String getReConfirmationPassword() {
		return reConfirmationPassword;
	}

	public List<String> getLoginIdErrorMessageList() {
		return loginIdErrorMessageList;
	}

	public List<String> getPasswordErrorMessageList() {
		return passwordErrorMessageList;
	}

	public List<String> getPasswordIncorrectErrorMessageList() {
		return passwordIncorrectErrorMessageList;
	}

	public List<String> getNewPasswordErrorMessageList() {
		return newPasswordErrorMessageList;
	}

	public List<String> getReConfirmationNewPasswordErrorMessageList() {
		return reConfirmationNewPasswordErrorMessageList;
	}

	public List<String> getNewPasswordIncorrectErrorMessageList() {
		return newPasswordIncorrectErrorMessageList;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}