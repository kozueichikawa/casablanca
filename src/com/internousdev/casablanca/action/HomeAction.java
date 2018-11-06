package com.internousdev.casablanca.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.casablanca.dao.MCategoryDAO;
import com.internousdev.casablanca.dto.MCategoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{
	private Map<String, Object> session;

	public String execute() {
		MCategoryDAO mCategoryDao = new MCategoryDAO();
		List<MCategoryDTO> mCategoryDTOList = mCategoryDao.getMCategoryList();
		session.put("mCategoryDTOList", mCategoryDTOList);
		return SUCCESS;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
