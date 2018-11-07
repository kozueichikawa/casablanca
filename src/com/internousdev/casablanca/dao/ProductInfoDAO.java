package com.internousdev.casablanca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.casablanca.dto.ProductInfoDTO;
import com.internousdev.casablanca.util.DBConnector;

public class ProductInfoDAO {

//一覧情報取得
	public ArrayList<ProductInfoDTO>getProductList()throws SQLException{

		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();

		ArrayList<ProductInfoDTO>roductInfoDTOList=new ArrayList<ProductInfoDTO>();
		String sql="SELECT*FROM product_info order by product_id";

		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();

			while(resultSet.next()){
				ProductInfoDTO dto=new ProductInfoDTO();
				dto.setId(resultSet.getInt("id"));
				dto.setProductId(resultSet.getInt("product_id"));
				dto.setProductName(resultSet.getString("product_name"));
				dto.setProductNameKana(resultSet.getString("product_name_kana"));
				dto.setProductDescription(resultSet.getString("product_description"));
				dto.setCategoryId(resultSet.getInt("category_id"));
				dto.setPrice(resultSet.getInt("price"));
				dto.setImageFilePath(resultSet.getString("image_file_path"));
				dto.setImageFileName(resultSet.getString("image_file_name"));
				dto.setReleaseDate(resultSet.getString("release_date"));
				dto.setReleaseCompany(resultSet.getString("release_company"));
				dto.setStatus(resultSet.getInt("status"));
				dto.setRegistDate(resultSet.getString("regist_date"));
				dto.setUpdateDate(resultSet.getString("update_date"));
				roductInfoDTOList.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return roductInfoDTOList;

	}
//一覧から詳細情報を取得
	public ProductInfoDTO getProductInfo(int productId)throws SQLException{
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		ProductInfoDTO productInfoDTO=new ProductInfoDTO();

		String sql="SELECT*FROM product_info where product_id=?";

		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, productId);
			ResultSet resultSet=preparedStatement.executeQuery();

			while(resultSet.next()){
				ProductInfoDTO dto=new ProductInfoDTO();
				dto.setId(resultSet.getInt("id"));
				dto.setProductId(resultSet.getInt("product_id"));
				dto.setProductName(resultSet.getString("product_name"));
				dto.setProductNameKana(resultSet.getString("product_name_kana"));
				dto.setCategoryId(resultSet.getInt("category_id"));
				dto.setImageFilePath(resultSet.getString("image_file_path"));
				dto.setImageFileName(resultSet.getString("image_file_name"));
				dto.setPrice(resultSet.getInt("price"));
				dto.setReleaseDate(resultSet.getString("release_date"));
				dto.setReleaseCompany(resultSet.getString("release_company"));
				dto.setProductDescription(resultSet.getString("product_description"));
				dto.setStatus(resultSet.getInt("status"));
				dto.setRegistDate(resultSet.getString("regist_date"));
				dto.setUpdateDate(resultSet.getString("update_date"));

			}

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return productInfoDTO;
	}
//カテゴリによる検索
	public List<ProductInfoDTO>getProdctInfoListByCategoryId(int categoryId,int productId,int limitOddset,int limitRowCount){
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		List<ProductInfoDTO>productInfoDTOList=new ArrayList<ProductInfoDTO>();

		String sql="select*from product_info where category_id=? and product_id not in(?) order by rand() limit?,?";

		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, categoryId);
			preparedStatement.setInt(2, productId);
			preparedStatement.setInt(3, limitOddset);
			preparedStatement.setInt(4, limitRowCount);
			ResultSet resultSet=preparedStatement.executeQuery();

			while(resultSet.next()){
				ProductInfoDTO dto=new ProductInfoDTO();
				dto.setId(resultSet.getInt("id"));
				dto.setProductId(resultSet.getInt("product_id"));
				dto.setProductName(resultSet.getString("product_name"));
				dto.setProductNameKana(resultSet.getString("product_name_kana"));
				dto.setProductDescription(resultSet.getString("product_description"));
				dto.setCategoryId(resultSet.getInt("category_id"));
				dto.setPrice(resultSet.getInt("price"));
				dto.setImageFilePath(resultSet.getString("image_filr_path"));
				dto.setImageFileName(resultSet.getString("image_file_name"));
				dto.setReleaseDate(resultSet.getString("release_date"));
				dto.setReleaseCompany(resultSet.getString("release_company"));
				dto.setStatus(resultSet.getInt("status"));
				dto.setRegistDate(resultSet.getString("regist_date"));
				dto.setUpdateDate(resultSet.getString("update_date"));
				productInfoDTOList.add(dto);

			}
		}catch(SQLException e){
			e.printStackTrace();
		}try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return productInfoDTOList;

	}
//キーワードによる検索
	public List<ProductInfoDTO>getProductInfoListAll(String[]keywordsList){
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		List<ProductInfoDTO>productInfoDTOList=new ArrayList<ProductInfoDTO>();

		String sql="SELECT*FROM product_info where";
		boolean initializeFlag=true;
		for(String keyword:keywordsList){
			if(initializeFlag){
				sql += "(product_name like '%" + keyword + "%' or product_name_kana like '%" + keyword + "%')";
				initializeFlag=false;
			}else{
				sql += "or (product_name like '%" + keyword + "%' or product_name_kana like '%" + keyword + "%')";
			}
		}
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();

			while(resultSet.next()){
				ProductInfoDTO dto=new ProductInfoDTO();
				dto.setId(resultSet.getInt("id"));
				dto.setProductId(resultSet.getInt("product_id"));
				dto.setProductName(resultSet.getString("product_name"));
				dto.setProductNameKana(resultSet.getString("product_name_kana"));
				dto.setProductDescription(resultSet.getString("product_description"));
				dto.setCategoryId(resultSet.getInt("category_id"));
				dto.setPrice(resultSet.getInt("price"));
				dto.setImageFilePath(resultSet.getString("image_filr_path"));
				dto.setImageFileName(resultSet.getString("image_file_name"));
				dto.setReleaseDate(resultSet.getString("release_date"));
				dto.setReleaseCompany(resultSet.getString("release_company"));
				dto.setStatus(resultSet.getInt("status"));
				dto.setRegistDate(resultSet.getString("regist_date"));
				dto.setUpdateDate(resultSet.getString("update_date"));
				productInfoDTOList.add(dto);

			}
		}catch(SQLException e){
			e.printStackTrace();
		}try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return productInfoDTOList;

	}
//キーワードとカテゴリによる検索
	public List<ProductInfoDTO>getProductInfoListByKeywords(String[]keywordsList,String categoryId){
		DBConnector dbConnector=new DBConnector();
		Connection connection =dbConnector.getConnection();
		List<ProductInfoDTO>productInfoDTOList=new ArrayList<ProductInfoDTO>();
		String sql="SELECT*FROM product_info where";
		boolean initializeFlag=true;
		for(String keyword: keywordsList){
			if(initializeFlag){
				sql += "category_id="+ categoryId +" and((produt_name like '%" + keyword + "%' or product_name_kana like '%" + keyword + "%')";
				initializeFlag=false;
			}else{
				sql += "or (product_name like '%" + keyword + "%' or product_name_kana like '%" + keyword + "%')";
			}
		}
			sql +=")";
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();

			while(resultSet.next()){
				ProductInfoDTO dto=new ProductInfoDTO();
				dto.setId(resultSet.getInt("id"));
				dto.setProductId(resultSet.getInt("product_id"));
				dto.setProductName(resultSet.getString("product_name"));
				dto.setProductNameKana(resultSet.getString("product_name_kana"));
				dto.setProductDescription(resultSet.getString("product_description"));
				dto.setCategoryId(resultSet.getInt("category_id"));
				dto.setPrice(resultSet.getInt("price"));
				dto.setImageFilePath(resultSet.getString("image_filr_path"));
				dto.setImageFileName(resultSet.getString("image_file_name"));
				dto.setReleaseDate(resultSet.getString("release_date"));
				dto.setReleaseCompany(resultSet.getString("release_company"));
				dto.setStatus(resultSet.getInt("status"));
				dto.setRegistDate(resultSet.getString("regist_date"));
				dto.setUpdateDate(resultSet.getString("update_date"));
				productInfoDTOList.add(dto);

			}
		}catch(SQLException e){
			e.printStackTrace();
		}try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return productInfoDTOList;
	}
}
