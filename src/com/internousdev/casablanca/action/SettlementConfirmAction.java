package com.internousdev.casablanca.action;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.casablanca.dao.DestinationInfoDAO;
import com.internousdev.casablanca.dao.MCategoryDAO;
import com.internousdev.casablanca.dao.PurchaseHistoryInfoDAO;
import com.internousdev.casablanca.dto.DestinationInfoDTO;
import com.internousdev.casablanca.dto.MCategoryDTO;
import com.internousdev.casablanca.dto.PurchaseHistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;


public class SettlementConfirmAction extends ActionSupport implements SessionAware {
	List<DestinationInfoDTO> destinationInfoDtoList;
	private Map<String,Object> session;

	public String execute() {
		String result = ERROR;
		/* ログイン状態なら宛先選択画面へ宛先一覧をListで送り、未ログイン状態ならログイン画面へ */
		if(Objects.equals(session.get("logined"), "1")){
			result = SUCCESS;
			DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();
			destinationInfoDtoList = destinationInfoDAO.getDestinationInfo(session.get("loginId").toString());

			PurchaseHistoryInfoDAO purchaseHistoryInfoDAO = new PurchaseHistoryInfoDAO();
			List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDtoList = purchaseHistoryInfoDAO.getPurchaseHistoryList(session.get("loginId").toString());
			session.put("purchaseHistoryInfoDtoList", purchaseHistoryInfoDtoList);
		} else {
			session.put("fromCart", true);
		}
		if(!session.containsKey("mCategoryList")) {
			MCategoryDAO mCategoryDAO=new MCategoryDAO();
			List<MCategoryDTO> mCategoryDtoList= mCategoryDAO.getMCategoryList();
			session.put("mCategoryDtoList", mCategoryDtoList);
		}
		return result;
	}

	public List<DestinationInfoDTO> getDestinationInfoDtoList() {
		return destinationInfoDtoList;
	}

@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}