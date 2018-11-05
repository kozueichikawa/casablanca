package com.internousdev.casablanca.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationAction extends ActionSupport implements SessionAware {
	private String categoryId;
	private static final String MAN="男性";
	private static final String WOMAN="女性";
	private String defaultSexValue=MAN;
	private String sex;
	private List<String> sexList=new ArrayList<String>();
	private Map<String,Object> session;

	public String execute(){
		String result=ERROR;
		sexList.add(MAN);
		sexList.add(WOMAN);

		session.remove("familyNameErrorMessageList");
		session.remove("firstNameErrorMessageList");
		session.remove("familyNameKanaErrorMessageList");
		session.remove("firstNameKanaErrorMessageList");
		session.remove("emailErrorMessageList");
		session.remove("telNumberErrorMessageList");
		session.remove("userAdressErrorMessageList");
		result=SUCCESS;
		return result;
	}

	public String getCategoryId(){
		return categoryId;
	}
	public void setCategoryId(String categoryId){
		this.categoryId=categoryId;
	}
	public String getSex(){
		return sex;
	}
	public void setSex(String sex){
		this.sex=sex;
	}
	public String getDefaultSexValue(){
		return defaultSexValue;
	}
	public void setDefaultSexValue(String defaultSexValue){
		this.defaultSexValue=defaultSexValue;
	}
	public List<String> getSexList(){
		return sexList;
	}
	public void setSexList(List<String> sexList){
		this.sexList=sexList;
	}
	public Map<String,Object> getSession(){
		return session;
	}public void setSession(Map<String,Object> session){
		this.session=session;
	}

}

