package com.internousdev.casablanca.action;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.casablanca.dao.DestinationInfoDAO;
import com.internousdev.casablanca.dao.UserInfoDAO;
import com.internousdev.casablanca.dto.DestinationInfoDTO;
import com.internousdev.casablanca.dto.UserInfoDTO;
import com.internousdev.casablanca.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	private String loginId;
	private String password;
	private boolean isSavedLoginId = false;
	private List<DestinationInfoDTO> destinationInfoDTOList;
	private List<String> loginIdErrorMessageList;
	private List<String> passwordErrorMessageList;
	Map<String, Object> session;

	public String execute() {
		String result = ERROR;

		/* フォーム記憶チェック結果((true/falseで渡ってくる)をセッションへ格納 */
		session.put("isSavedLoginId", isSavedLoginId);

		/* 入力チェック */
		InputChecker inputChecker = new InputChecker();
		loginIdErrorMessageList = inputChecker.doCheck("ログインID", loginId, 1, 8, true, false, false, true, false, false, false, false, false);
		passwordErrorMessageList = inputChecker.doCheck("ログインID", loginId, 1, 16, true, false, false, true, false, false, false, false, false);

		/* 入力チェックがOKだった場合、ログイン処理へ。NGの場合は即ERRORをreturn */
		if (loginIdErrorMessageList.size()==0 && passwordErrorMessageList.size()==0) {
			UserInfoDAO userInfoDAO = new UserInfoDAO();
			UserInfoDTO userInfoDTO = userInfoDAO.getLoginInfo(loginId, password);
			if (loginId.equals(userInfoDTO.getUserId()) && password.equals(userInfoDTO.getPassword())) {
				/* ログインOKだった場合、DBカラム"logined"を1にupdate。そのloginedをsessionに取得 */
				userInfoDAO.login(loginId, password);
				result = SUCCESS;
				session.put("loginId", userInfoDTO.getUserId());
				session.put("logined", "1");
				System.out.println("ログイン成功");
				/* カートの決済ボタン経由(SettlementConfirmAction)でログイン画面にきたかどうか判定。以下、"経由してきた"場合の処理 */
				if (Objects.equals(session.get("isFromCart"), "true")) {
					/* 宛先情報をsettlementConfirm.jspで表示用に生成 */
					DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();
					destinationInfoDTOList = destinationInfoDAO.getDestinationInfo(loginId);
					result = "gotosettlementconfirm";
				}
			}
		} else {
			System.out.println("ログイン失敗");
		}
		return result;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSavedLoginId(boolean isSavedLoginId) {
		this.isSavedLoginId = isSavedLoginId;
	}

	public List<String> getLoginIdErrorMessageList() {
		return loginIdErrorMessageList;
	}

	public List<String> getPasswordErrorMessageList() {
		return passwordErrorMessageList;
	}

	public List<DestinationInfoDTO> getDestinationInfoDTOList() {
		return destinationInfoDTOList;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
