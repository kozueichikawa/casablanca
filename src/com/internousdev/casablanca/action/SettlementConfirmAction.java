package com.internousdev.casablanca.action;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.casablanca.dao.DestinationInfoDAO;
import com.internousdev.casablanca.dto.DestinationInfoDTO;
import com.opensymphony.xwork2.ActionSupport;


public class SettlementConfirmAction extends ActionSupport implements SessionAware {
	List<DestinationInfoDTO> destinationInfoDTOList;
	private Map<String,Object> session;

	public String execute() {
		String result = ERROR;
		/* ログイン状態なら宛先選択画面へ宛先一覧をListで送り、未ログイン状態ならログイン画面へ */
		if(Objects.equals("logined", "1")){
			result = SUCCESS;
			DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();
			destinationInfoDTOList = destinationInfoDAO.getDestinationInfo(session.get("loginId").toString());
		}
		return result;
	}

	public List<DestinationInfoDTO> getDestinationInfoDTOList() {
		return destinationInfoDTOList;
	}

@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}


