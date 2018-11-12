package com.internousdev.casablanca.action;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.casablanca.dao.MCategoryDAO;
import com.internousdev.casablanca.dao.UserInfoDAO;
import com.internousdev.casablanca.dto.MCategoryDTO;
import com.opensymphony.xwork2.ActionSupport;
public class ResetPasswordCompleteAction extends ActionSupport implements SessionAware {

	private String categoryId;
	private String loginId;
	private String password;
	private Map<String,Object>session;

	public String execute(){
		String result=ERROR;
		UserInfoDAO userInfoDAO=new UserInfoDAO();
		int count=userInfoDAO.resetPassword(String.valueOf(session.get("loginId")),String.valueOf(session.get("newPassword")));
		if(count>0){
			result=SUCCESS;
		}
		if(!session.containsKey("mCategoryList")) {
			MCategoryDAO mCategoryDAO=new MCategoryDAO();
			List<MCategoryDTO> mCategoryDtoList= mCategoryDAO.getMCategoryList();
			session.put("mCategoryDtoList", mCategoryDtoList);
		}
		return result;
	}
	public String getCategoryId(){
		return categoryId;
	}
	public void setCategoryId(String categoryId){
		this.categoryId=categoryId;
	}
	public String getLoginId(){
		return loginId;
	}
	public void setLoginId(String loginId){
		this.loginId=loginId;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public Map<String,Object>getSession(){
		return session;
	}
	public void setSession(Map<String,Object>session){
		this.session=session;
	}
}
