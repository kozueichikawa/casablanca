package com.internousdev.casablanca.dto;

public class ProductInfoDTO {

	private int id;
	private int productId;
	private String productName;
	private String productNameKana;
	private String productDescription;
	private int categoryId;
	private int price;
	private String imageFilePath;
	private String imageFileName;
	private String releaseCompany;
	private String releaseDate;
	private int status;
	private String registDate;
	private String updateDate;

	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}

	public int getProductId(){
		return productId;
	}
	public void setProductId(int productId){
		this.productId=productId;
	}

	public String getProductName(){
		return productName;
	}
	public void setProductName(String productName){
		this.productName=productName;
	}

	public String getProductNameKana(){
		return productNameKana;
	}
	public void setProductNameKana(String productNameKana){
		this.productNameKana=productNameKana;
	}

	public String getProductDescription(){
		return productDescription;
	}
	public void setProductDescription(String productDescription){
		this.productDescription=productDescription;
	}

	public int getCategoryId(){
		return categoryId;
	}
	public void setCategoryId(int categoryId){
		this.categoryId=categoryId;
	}

	public int getPrice(){
		return price;
	}
	public void setPrice(int price){
		this.price=price;
	}

	public String getImageFilePath(){
		return imageFilePath;
	}
	public void setImageFilePath(String imageFilePath){
		this.imageFilePath=imageFilePath;
	}

	public String getImageFileName(){
		return imageFileName;
	}
	public void setImageFileName(String imageFileName){
		this.imageFileName=imageFileName;
	}

	public String getReleaseCompany(){
		return releaseCompany;
	}
	public void setReleaseCompany(String releaseCompany){
		this.releaseCompany=releaseCompany;
	}

	public String getReleaseDate(){
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate){
		this.releaseDate=releaseDate;
	}

	public int getStatus(){
		return status;
	}
	public void setStatus(int status){
		this.status=status;
	}

	public String getRegistDate(){
		return registDate;
	}
	public void setRegistDate(String registDate){
		this.registDate=registDate;
	}

	public String getUpdateDate(){
		return updateDate;
	}
	public void setUpdateDate(String updateDate){
		this.updateDate=updateDate;
	}



}
