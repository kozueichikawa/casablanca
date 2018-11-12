package com.internousdev.casablanca.action;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.casablanca.dao.DestinationInfoDAO;
import com.internousdev.casablanca.dao.MCategoryDAO;
import com.internousdev.casablanca.dto.MCategoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationCompleteAction extends ActionSupport implements SessionAware {

	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String email;
	private String sex;
	private String telNumber;
	private String userAddress;
	private Map<String,Object> session;

	public String execute(){
		String result = ERROR;
		if(Objects.equals(session.get("logined"),"1")){
			DestinationInfoDAO destinationInfoDao = new DestinationInfoDAO();
			int count = destinationInfoDao.insert(String.valueOf(session.get("loginId")),familyName,firstName,familyNameKana,firstNameKana,email,telNumber,userAddress);

			if(count > 0){
				result=SUCCESS;
			}
		}
		if(!session.containsKey("mCategoryDtoList")) {
			MCategoryDAO mCategoryDAO = new MCategoryDAO();
			List<MCategoryDTO> mCategoryDtoList = mCategoryDAO.getMCategoryList();
			session.put("mCategoryDtoList", mCategoryDtoList);
		}
		return result;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public void setFirstName(String firstName){
		this.firstName=firstName;
	}

	public void setFamilyNameKana(String familyNameKana){
		this.familyNameKana=familyNameKana;
	}

	public void setFirstNameKana(String firstNameKana){
		this.firstNameKana=firstNameKana;
	}

	public void setEmail(String email){
		this.email=email;
	}

	public void setTelNumber(String telNumber){
		this.telNumber=telNumber;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public void setSex(String sex){
		this.sex=sex;
	}

	public void setSession(Map<String,Object> session){
		this.session=session;
	}
}
