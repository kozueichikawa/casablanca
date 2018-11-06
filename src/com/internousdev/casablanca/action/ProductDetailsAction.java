package com.internousdev.casablanca.action;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.casablanca.dao.ProductInfoDAO;
import com.internousdev.casablanca.dto.MCategoryDTO;
import com.internousdev.casablanca.dto.ProductInfoDTO;
import com.opensymphony.xwork2.ActionSupport;
public class ProductDetailsAction extends ActionSupport implements SessionAware{

	private Map<String,Object>session;
	private List<ProductInfoDTO>productInfoDTOList=new ArrayList<ProductInfoDTO>();
	private List<MCategoryDTO>mCategoryDTOList=new ArrayList<MCategoryDTO>();
	private int productId;
	private int cotegoryId;

	public String execute()throws SQLException{
		ProductInfoDAO productInfoDAO=new ProductInfoDAO();
		ProductInfoDTO productInfoDTO=new ProductInfoDTO();
		String result =ERROR;

		productInfoDTO=productInfoDAO.getProductInfo(productId);
		session.put("id", productInfoDTO.getId());
		session.put("productId", productInfoDTO.getProductId());
		session.put("productName", productInfoDTO.getProductName());
		session.put("productNameKana", productInfoDTO.getProductNameKana());
		session.put("productDescription", productInfoDTO.getProductDescription());
		session.put("price", productInfoDTO.getPrice());
		session.put("imageFilePath",productInfoDTO.getImageFilePath());
		session.put("imageFileName", productInfoDTO.getImageFileName());
		session.put("releaseCompany", productInfoDTO.getReleaseCompany());
		session.put("releaseDate", productInfoDTO.getRegistDate());

		productInfoDTOList=productInfoDAO.getProdctInfoListByCategoryId(productInfoDTO.getCategoryId(), productInfoDTO.getProductId(),0,3);

		return result;
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


	public List<MCategoryDTO> getmCategoryDTOList() {
		return mCategoryDTOList;
	}


	public void setmCategoryDTOList(List<MCategoryDTO> mCategoryDTOList) {
		this.mCategoryDTOList = mCategoryDTOList;
	}


	public Map<String,Object> getSession(){
		return this.session;
	}
	@Override
	public void setSession(Map<String, Object>session) {
		this.session=session;

	}




}
