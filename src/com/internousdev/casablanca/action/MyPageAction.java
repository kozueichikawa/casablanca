package com.internousdev.casablanca.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.casablanca.dao.MCategoryDAO;
import com.internousdev.casablanca.dao.UserInfoDAO;
import com.internousdev.casablanca.dto.MCategoryDTO;
import com.internousdev.casablanca.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;


public class MyPageAction extends ActionSupport implements SessionAware{

	private List<MCategoryDTO> mCategoryDtoList=new ArrayList<MCategoryDTO>();

	private Map<String,Object> session;

	public String execute() {
		String result=ERROR;
		UserInfoDAO userInfoDAO= new UserInfoDAO();
		UserInfoDTO userInfoDTO=new UserInfoDTO();
		userInfoDTO=userInfoDAO.getUserInfo(String.valueOf(session.get("loginId")));
		session.put("familyName", userInfoDTO.getFamilyName());
		session.put("firstName", userInfoDTO.getFirstName());
		session.put("familyNameKana", userInfoDTO.getFamilyNameKana());
		session.put("firstNameKana",userInfoDTO.getFirstNameKana());
		session.put("sex", userInfoDTO.getSex());
		session.put("email",userInfoDTO.getFirstNameKana());
		result =SUCCESS;


	return result;




	if(!session.containsKey("mCategoryList")) {
		MCategoryDAO mCategoryDAO=new MCategoryDAO();
		mCategoryDtoList= mCategoryDAO.getMCategoryList();
		session.put("mCategoryDtoList", mCategoryDtoList);
	}


	}

	public List<MCategoryDTO> getmCategoryDTOList() {
		return mCategoryDtoList;
	}

	public void setmCategoryDTOList(List<MCategoryDTO> mCategoryDTOList) {
		this.mCategoryDtoList = mCategoryDTOList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}

