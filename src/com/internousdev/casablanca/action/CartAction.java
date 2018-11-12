package com.internousdev.casablanca.action;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.casablanca.dao.CartInfoDAO;
import com.internousdev.casablanca.dao.MCategoryDAO;
import com.internousdev.casablanca.dto.CartInfoDTO;
import com.internousdev.casablanca.dto.MCategoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	public String execute(){
		String result = ERROR;
		String userId = null;
		CartInfoDAO cartInfoDao = new CartInfoDAO();
		List<CartInfoDTO> cartInfoDtoList = new ArrayList<CartInfoDTO>();

		if(session.containsKey("loginId")){
			userId = String.valueOf(session.get("loginId"));
		}else if(session.containsKey("tempUserId")){
			userId = String.valueOf(session.get("tempUserId"));
		}
		cartInfoDtoList = cartInfoDao.getCartInfoDtoList(userId);
		Iterator<CartInfoDTO> iterator = cartInfoDtoList.iterator();
		if(!(iterator.hasNext())){
			cartInfoDtoList = null;
		}
		session.put("cartInfoDtoList", cartInfoDtoList);

		int totalPrice = Integer.parseInt(String.valueOf(cartInfoDao.getTotalPrice(userId)));
		session.put("totalPrice", totalPrice);
		result = SUCCESS;
		if(!session.containsKey("mCategoryList")){
			MCategoryDAO mCategoryDao = new MCategoryDAO();
			List<MCategoryDTO> mCategoryDtoList = mCategoryDao.getMCategoryList();
			session.put("mCategoryDtoList", mCategoryDtoList);
		}
		return result;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


}
