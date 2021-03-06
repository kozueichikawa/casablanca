package com.internousdev.casablanca.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.casablanca.dao.MCategoryDAO;
import com.internousdev.casablanca.dao.ProductInfoDAO;
import com.internousdev.casablanca.dto.MCategoryDTO;
import com.internousdev.casablanca.dto.ProductInfoDTO;
import com.internousdev.casablanca.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;


public class SearchItemAction extends ActionSupport implements SessionAware{
	private String categoryId;
	private String keywords;
	private List<String> keywordsErrorMessageList = new ArrayList<String>();
	private List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();
	private Map<String,Object> session;

	public String execute(){
		String result = ERROR;

	InputChecker inputChecker = new InputChecker();
	if(keywords==null){
		keywords="";
	}
	keywordsErrorMessageList =inputChecker.doCheck("検索ワード",keywords,0,16,true,true,true,true,false,true,false,false,true);

	ProductInfoDAO productInfoDAO = new ProductInfoDAO();

	switch(categoryId){
		case "1":
			productInfoDtoList = productInfoDAO.getProductInfoListAll(keywords.replaceAll("　"," ").split(" "));
			result = SUCCESS;
			break;
		default:
			productInfoDtoList = productInfoDAO.getProductInfoListByKeywords(keywords.replaceAll("　", " ").split(" "),categoryId);
			result = SUCCESS;
			break;
	}

	Iterator<ProductInfoDTO> iterator = productInfoDtoList.iterator();
	if(!(iterator.hasNext())){
		productInfoDtoList = null;
	}
	if(!session.containsKey("mCategoryList")){
		MCategoryDAO mCategoryDAO = new MCategoryDAO();
		List<MCategoryDTO> mCategoryDtoList = mCategoryDAO.getMCategoryList();
		session.put("mCategoryDtoList", mCategoryDtoList);
	}
	return result;
}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords){
		this.keywords = keywords;
	}
	public List<String> getKeywordsErrorMessageList(){
		return keywordsErrorMessageList;
	}
	public List<ProductInfoDTO> getProductInfoDtoList(){
		return productInfoDtoList;
	}
	public void setSession(Map<String,Object> session){
		this.session = session;
	}
}