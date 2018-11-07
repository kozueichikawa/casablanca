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
		/* ヘッダーのカテゴリ表示用セッションが切れた場合のみDAO実行 */
		if (!session.containsKey("mCategoryList")) {
			MCategoryDAO mCategoryDao = new MCategoryDAO();
			List<MCategoryDTO> mCategoryList = mCategoryDao.getMCategoryList();
			session.put("mCategoryDTOList", mCategoryList);
		}
		return SUCCESS;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
