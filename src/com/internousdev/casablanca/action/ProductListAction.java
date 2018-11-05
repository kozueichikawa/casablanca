package com.internousdev.casablanca.action;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.casablanca.dao.ProductInfoDAO;
import com.internousdev.casablanca.dto.ProductInfoDTO;
import com.opensymphony.xwork2.ActionSupport;
public class ProductListAction extends ActionSupport{

	private ProductInfoDAO productInfoDAO=new ProductInfoDAO();
	private ArrayList<ProductInfoDTO>productList=new ArrayList<ProductInfoDTO>();

	public String execute()throws SQLException{
		String result=ERROR;

		productList=productInfoDAO.getProductList();

		result=SUCCESS;

		return result;
	}

	public ArrayList<ProductInfoDTO>getProductList(){
		return productList;
	}

	public void setProductInfo(ArrayList<ProductInfoDTO>productList){
		this.productList=productList;
	}

}
