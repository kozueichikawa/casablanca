package com.internousdev.casablanca.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;


public class SettlementConfirmAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;

public String execute() {
 String result = "login";

if(session.containsKey("loginId")){
	DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO;
	ArrayList<DestnationInfoDTO> destinationInfoDTOList = destinationInfoDAO.getDestinationInfo();
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

