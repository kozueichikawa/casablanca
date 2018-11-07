package com.internousdev.casablanca.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.casablanca.dao.DestinationInfoDAO;
import com.internousdev.casablanca.dto.DestinationInfoDTO;
import com.opensymphony.xwork2.ActionSupport;


public class SettlementConfirmAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;

public String execute() {
 String result = "login";

if(session.containsKey("loginId")){
	DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();
	ArrayList <DestinationInfoDTO> destinationInfoDTOList = destinationInfoDAO.getDestinationInfo();
	session.put("destinationInfoDTOList",destinationInfoDTOList);

 return SUCCESS;

	}else{
      return ERROR;
}
return result;
}
@Override
public void setSession(Map<String, Object> session) {
this.session = session;
}
}


