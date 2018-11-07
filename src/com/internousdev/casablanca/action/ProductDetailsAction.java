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
public class ProductDetailsAction extends ActionSupport implements SessionAware{

	private Map<String,Object>session;
	private List<ProductInfoDTO>productInfoDTOList=new ArrayList<ProductInfoDTO>();
	private List<MCategoryDTO>mCategoryDtoList=new ArrayList<MCategoryDTO>();
	private ProductInfoDTO productInfoDTO=new ProductInfoDTO();
	private int productId;
	private int cotegoryId;

	public String execute()throws SQLException{
		ProductInfoDAO productInfoDAO=new ProductInfoDAO();

		String result =ERROR;

		productInfoDTO=productInfoDAO.getProductInfo(productId);

		productInfoDTOList=productInfoDAO.getProdctInfoListByCategoryId(productInfoDTO.getCategoryId(), productInfoDTO.getProductId(),0,3);

		if(!session.containsKey("mCategoryList")){
			MCategoryDAO mCategoryDAO=new MCategoryDAO();
			mCategoryDtoList=mCategoryDAO.getMCategoryList();
			session.put("mCategoryDtoList", mCategoryDtoList);
		}

		result=SUCCESS;
		return result;
	}


	public ProductInfoDTO getProductInfoDTO() {
		return productInfoDTO;
	}

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCotegoryId() {
		return cotegoryId;
	}
	public void setCotegoryId(int cotegoryId) {
		this.cotegoryId = cotegoryId;
	}

	public List<ProductInfoDTO> getProductInfoDTOList() {
		return productInfoDTOList;
	}
	public void setProductInfoDTOList(List<ProductInfoDTO> productInfoDTOList) {
		this.productInfoDTOList = productInfoDTOList;
	}


	public List<MCategoryDTO> getmCategoryDtoList() {
		return mCategoryDtoList;
	}
	public void setmCategoryDtoList(List<MCategoryDTO> mCategoryDtoList) {
		this.mCategoryDtoList = mCategoryDtoList;
	}


	public Map<String,Object> getSession(){
		return this.session;
	}
	@Override
	public void setSession(Map<String, Object>session) {
		this.session=session;

	}




}
