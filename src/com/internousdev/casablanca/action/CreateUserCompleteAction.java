package com.internousdev.casablanca.action;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.casablanca.dao.MCategoryDAO;
import com.internousdev.casablanca.dao.UserInfoDAO;
import com.internousdev.casablanca.dto.DestinationInfoDTO;
import com.internousdev.casablanca.dto.MCategoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CreateUserCompleteAction extends ActionSupport implements SessionAware{


	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String sex;
	private String email;
	private String loginId;
	private String password;
	private String result;
	private List<DestinationInfoDTO> destinationInfoDtoList;
	private Map<String, Object> session;
	public String execute(){
		String result = ERROR;
		UserInfoDAO UserInfoDao = new UserInfoDAO();
		int count = UserInfoDao.createUser(familyName, firstName, familyNameKana,firstNameKana, sex, email, loginId, password);
		if(count > 0) {
			UserInfoDao.login(loginId, password);
			session.put("loginId", loginId);
			session.put("logined", "1");
			System.out.println("登録・ログイン成功");
			result = SUCCESS;


			/* 以下、カート決済ボタン経由での新規登録かを判定 */
			if (Objects.equals(session.get("fromCart"), true)) {
				System.out.println("カート決済経由でログイン->宛先選択画面へ");

				/* 再登録後に決済画面へ遷移しないようにセッションからフラグを削除 */
				session.remove("fromCart");

				/* 宛先情報をsettlementConfirm.jspで表示用に生成 */
				result = "gotosettlementconfirm";
			}
			/* header.jspで使うカテゴリリストセッション切れ用 */
			if(!session.containsKey("mCategoryDtoList")) {
				MCategoryDAO mCategoryDAO=new MCategoryDAO();
				List<MCategoryDTO> mCategoryDtoList= mCategoryDAO.getMCategoryList();
				session.put("mCategoryDtoList", mCategoryDtoList);
			}
		}
		System.out.println(result);
		return result;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}
	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<DestinationInfoDTO> getDestinationInfoDtoList() {
		return destinationInfoDtoList;
	}
	public String getResult() {
		return result;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
