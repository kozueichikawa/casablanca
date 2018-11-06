package com.internousdev.casablanca.action;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.casablanca.dao.MCategoryDAO;
import com.internousdev.casablanca.dao.ProductInfoDAO;
import com.internousdev.casablanca.dto.MCategoryDTO;
import com.internousdev.casablanca.dto.ProductInfoDTO;
import com.opensymphony.xwork2.ActionSupport;
public class ProductListAction extends ActionSupport implements SessionAware{

	private ArrayList<ProductInfoDTO>productList=new ArrayList<ProductInfoDTO>();
	private List<MCategoryDTO>mCategoryList=new ArrayList<MCategoryDTO>();
	private Map<String,Object>session;


	public String execute()throws SQLException{

		String result=ERROR;

		ProductInfoDAO productInfoDAO=new ProductInfoDAO();
		productList=productInfoDAO.getProductList();

		if(!session.containsKey("mCategoryList")){
			MCategoryDAO mCategoryDAO=new MCategoryDAO();
			mCategoryList=mCategoryDAO.getMCategoryList();
			session.put("mCategoryList", mCategoryList);
		}
		result=SUCCESS;
		return result;
	}

	public ArrayList<ProductInfoDTO>getProductList(){
		return productList;
	}

	public void setProductList(ArrayList<ProductInfoDTO>productList){
		this.productList=productList;
	}

	public List<MCategoryDTO> getmCategoryList() {
		return mCategoryList;
	}

	public void setmCategoryList(List<MCategoryDTO> mCategoryList) {
		this.mCategoryList = mCategoryList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}



}
