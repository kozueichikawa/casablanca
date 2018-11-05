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


	public ArrayList<ProductInfoDTO>getProductList()throws SQLException{

		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();

		ArrayList<ProductInfoDTO>productListDTO=new ArrayList<ProductInfoDTO>();
		String sql="SELECT*FROM product_info";

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
				productListDTO.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return productListDTO;

	}

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
				dto.setImageFilePath(resultSet.getString("image_filr_path"));
				dto.setImageFileName(resultSet.getString("image_file_name"));
				dto.setPrice(resultSet.getInt("price"));
				dto.setReleaseDate(resultSet.getString("release_date"));
				dto.setReleaseCompany(resultSet.getString("release_company"));
				dto.setProductDescription(resultSet.getString("product_description"));

			}

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return productInfoDTO;
	}

	public List<ProductInfoDTO>getProdctInfoListByCategoryId(int categoryId,int productId,int limitOddset,int limitRowCount){
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		List<ProductInfoDTO>productInfoDTOList=new ArrayList<ProductInfoDTO>();

		return productInfoDTOList;

	}

}
