package com.internousdev.casablanca.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.casablanca.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;


public class SearchItemAction extends ActionSupport implements SessionAware{
	private String categoryId;
	private String keywords;
	private List<MCategoryDTO> mCategoryDTOList = new ArrayList<MCategoryDTO>();
	private List<String> keywordsErrorMessageList = new ArrayList<String>();
	private List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
	private Map<String,Object> session;

	public String execute(){
		String result = ERROR;

	InputChecker inputChecker = new InputChecker();
	if(keywords==null){
		keywords="";
	}
	keywordsErrorMessageList =inputChecker.doCheck("検索ワード",keywords,0,16,true,true,true,true,false,true,false);

	ProductInfoDAO productInfoDAO = new ProductInfoDAO();

	switch(categoryId){
		case "1":
			productInfoDTOList = productInfoDAO.getProductInfoListAll(keywords.replaceAll("　"," ").split(" "));
			result = SUCCESS;
			break;

		default:
			productInfoDTOList = productInfoDAO.getProductInfoListByKeywords(keywords.replaceAll("　", " ").split(" "));
			result = SUCCESS;
			break;
	}
	Iterator<ProductInfoDTO> iterator = productInfoDTOList.iterator();
	if(!(iterator.hasNext())){
		productInfoDTOList = null;
	}
	session.put("keywordsErrorMessageList",keywordsErrorMessageList);

	if(!session.containsKey("mCategoryList")){
		MCategoryDAO mCategoryDAO = new MCategoryDAO();
		mCategoryDTOList = mCategoryDAO.getMCategoryList();
		session.put("mCategoryDTOList", mCategoryDTOList);
	}
	return result;
}

	public List<MCategoryDTO> getmCategoryDTOList(){
		return mCategoryDTOList;
	}

	public void setmCategoryDTOList(List<MCategoryDTO> mCategoryDTOList){
		this.mCategoryDTOList = mCategoryDTOList;
	}
	public String getCategoryId(){
		return categoryId;
	}
	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}
	public String getKeywords(){
		return keywords;
	}
	public void setKeywords(String keywords){
		this.keywords = keywords;
	}
	public List<String> getKeywordsErrorMessageList(){
		return keywordsErrorMessageList;
	}
	public void setKeywordsErrorMessageList(List<String> keywordsErrorMessageList){
		this.keywordsErrorMessageList = keywordsErrorMessageList;
	}
	public List<ProductInfoDTO> getProductInfoDTOList(){
		return productInfoDTOList;
	}
	public void setProductInfoDTOList(List<ProductInfoDTO>productInfoDTOList){
		this.productInfoDTOList = productInfoDTOList;
	}
	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session){
		this.session = session;
	}

}