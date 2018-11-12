package com.internousdev.casablanca.action;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.casablanca.dao.MCategoryDAO;
import com.internousdev.casablanca.dao.UserInfoDAO;
import com.internousdev.casablanca.dto.MCategoryDTO;
import com.internousdev.casablanca.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;


public class MyPageAction extends ActionSupport implements SessionAware{

	private UserInfoDTO userInfoDTO;
	private Map<String,Object> session;

	public String execute() {
		String result=ERROR;
		if(Objects.equals(session.get("logined"),"1")) {
		UserInfoDAO userInfoDAO= new UserInfoDAO();
		userInfoDTO=userInfoDAO.getUserInfo(String.valueOf(session.get("loginId")));
		result =SUCCESS;
		} else {
			System.out.println("セッションタイムアウト");
		}
		if(!session.containsKey("mCategoryList")) {
			MCategoryDAO mCategoryDAO=new MCategoryDAO();
			List<MCategoryDTO> mCategoryDtoList= mCategoryDAO.getMCategoryList();
			session.put("mCategoryDtoList", mCategoryDtoList);
		}
		return result;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public UserInfoDTO getUserInfoDTO() {
		return userInfoDTO;
	}

}

