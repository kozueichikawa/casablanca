package com.internousdev.casablanca.action;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.casablanca.dao.MCategoryDAO;
import com.internousdev.casablanca.dao.PurchaseHistoryInfoDAO;
import com.internousdev.casablanca.dto.MCategoryDTO;
import com.internousdev.casablanca.dto.PurchaseHistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;


public class DeletePurchaseHistoryInfoAction extends ActionSupport implements SessionAware{
	private List<MCategoryDTO> mCategoryDTOList= new ArrayList<MCategoryDTO>();
	private  Map<String,Object> session;
	public String execute() {

		String result=ERROR;
		PurchaseHistoryInfoDAO purchaseHistoryInfoDAO=new PurchaseHistoryInfoDAO();
		int count=purchaseHistoryInfoDAO.deleteAll(String.valueOf(session.get("loginId")));
		if(count>0) {
			List<PurchaseHistoryInfoDTO> purchaseHistoryDTOList=purchaseHistoryInfoDAO.getPurchaseHistoryList(String.valueOf(session.get("loginId")));
			Iterator<PurchaseHistoryInfoDTO> iterator=purchaseHistoryDTOList.iterator();
			if(!(iterator.hasNext())) {

				purchaseHistoryDTOList=null;
			}
			session.put("purchaseHistoryInfoDTOList", purchaseHistoryDTOList);

			result="SUCCESS";
		}
		if(!session.containsKey("mCategoryList")) {
			MCategoryDAO mCategoryDAO=new MCategoryDAO();
			mCategoryDTOList=mCategoryDAO.getMCategoryList();
			session.put("mCategoryDTOList", mCategoryDTOList);
		}
		return result;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
