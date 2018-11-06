package com.internousdev.casablanca.action;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.casablanca.dao.DestinationInfoDAO;
import com.internousdev.casablanca.dao.UserInfoDAO;
import com.internousdev.casablanca.dto.DestinationInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	private String loginId;
	private String password;
	private boolean savedLoginId = false;
	private List<DestinationInfoDTO> destinationInfoDTOList;
	Map<String, Object> session;

	public String execute() {
		String result = ERROR;
		session.put("savedLoginId", savedLoginId);
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		boolean loginFlg = userInfoDAO.getUserInfo(loginId, password);
		if (loginFlg) {
			/* カートの決済ボタン経由でログイン画面にきたかどうか判定。以下、"経由してきた"場合の処理 */
			if ((boolean)session.get("fromCartFlg")) {
				/* 宛先情報をsettlementConfirm.jspで表示用に生成 */
				DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();
				destinationInfoDTOList = destinationInfoDAO.getDestinationInfo(loginId);
				result = "gotocart";
			/* カート経由の場合 */
			}
			result = SUCCESS;
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

	public boolean isSavedLoginId() {
		return savedLoginId;
	}

	public void setSavedLoginId(boolean savedLoginId) {
		this.savedLoginId = savedLoginId;
	}

	public List<DestinationInfoDTO> getDestinationInfoDTOList() {
		return destinationInfoDTOList;
	}

	public void setDestinationInfoDTOList(List<DestinationInfoDTO> destinationInfoDTOList) {
		this.destinationInfoDTOList = destinationInfoDTOList;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}



}
