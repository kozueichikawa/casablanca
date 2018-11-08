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
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

//一覧情報取得
	public ArrayList<ProductInfoDTO>getProductList()throws SQLException{

		DBConnector db=new DBConnector();
		con=db.getConnection();

		ArrayList<ProductInfoDTO>productInfoDtoList=new ArrayList<ProductInfoDTO>();
		String sql="SELECT*FROM product_info order by product_id";

		try{
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();

			while(rs.next()){
				ProductInfoDTO dto=new ProductInfoDTO();
				dto.setId(rs.getInt("id"));
				dto.setProductId(rs.getInt("product_id"));
				dto.setProductName(rs.getString("product_name"));
				dto.setProductNameKana(rs.getString("product_name_kana"));
				dto.setProductDescription(rs.getString("product_description"));
				dto.setCategoryId(rs.getInt("category_id"));
				dto.setPrice(rs.getInt("price"));
				dto.setImageFilePath(rs.getString("image_file_path"));
				dto.setImageFileName(rs.getString("image_file_name"));
				dto.setReleaseDate(rs.getString("release_date"));
				dto.setReleaseCompany(rs.getString("release_company"));
				dto.setStatus(rs.getInt("status"));
				dto.setRegistDate(rs.getString("regist_date"));
				dto.setUpdateDate(rs.getString("update_date"));
				productInfoDtoList.add(dto);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return productInfoDtoList;

	}
//一覧から詳細情報を取得
	public ProductInfoDTO getProductInfo(int productId)throws SQLException{
		DBConnector db=new DBConnector();
		con=db.getConnection();
		ProductInfoDTO dto=new ProductInfoDTO();

		String sql="SELECT*FROM product_info where product_id=?";

		try{
			ps=con.prepareStatement(sql);
			ps.setInt(1, productId);
			rs=ps.executeQuery();

			if(rs.next()){
				dto.setId(rs.getInt("id"));
				dto.setProductId(rs.getInt("product_id"));
				dto.setProductName(rs.getString("product_name"));
				dto.setProductNameKana(rs.getString("product_name_kana"));
				dto.setCategoryId(rs.getInt("category_id"));
				dto.setImageFilePath(rs.getString("image_file_path"));
				dto.setImageFileName(rs.getString("image_file_name"));
				dto.setPrice(rs.getInt("price"));
				dto.setReleaseDate(rs.getString("release_date"));
				dto.setReleaseCompany(rs.getString("release_company"));
				dto.setProductDescription(rs.getString("product_description"));
				dto.setStatus(rs.getInt("status"));
				dto.setRegistDate(rs.getString("regist_date"));
				dto.setUpdateDate(rs.getString("update_date"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
//カテゴリによる検索
	public List<ProductInfoDTO>getProdctInfoListByCategoryId(int categoryId,int productId,int limitOddset,int limitRowCount){
		DBConnector db=new DBConnector();
		con=db.getConnection();
		List<ProductInfoDTO>productInfoDtoList=new ArrayList<ProductInfoDTO>();

		String sql="select*from product_info where category_id=? and product_id not in(?) order by rand() limit ?,?";

		try{
			ps=con.prepareStatement(sql);
			ps.setInt(1, categoryId);
			ps.setInt(2, productId);
			ps.setInt(3, limitOddset);
			ps.setInt(4, limitRowCount);
			rs=ps.executeQuery();

			while(rs.next()){
				ProductInfoDTO dto=new ProductInfoDTO();
				dto.setId(rs.getInt("id"));
				dto.setProductId(rs.getInt("product_id"));
				dto.setProductName(rs.getString("product_name"));
				dto.setProductNameKana(rs.getString("product_name_kana"));
				dto.setProductDescription(rs.getString("product_description"));
				dto.setCategoryId(rs.getInt("category_id"));
				dto.setPrice(rs.getInt("price"));
				dto.setImageFilePath(rs.getString("image_file_path"));
				dto.setImageFileName(rs.getString("image_file_name"));
				dto.setReleaseDate(rs.getString("release_date"));
				dto.setReleaseCompany(rs.getString("release_company"));
				dto.setStatus(rs.getInt("status"));
				dto.setRegistDate(rs.getString("regist_date"));
				dto.setUpdateDate(rs.getString("update_date"));
				productInfoDtoList.add(dto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return productInfoDtoList;
	}

//キーワードによる検索
	public List<ProductInfoDTO>getProductInfoListAll(String[]keywordsList){
		DBConnector db=new DBConnector();
		con=db.getConnection();
		List<ProductInfoDTO>productInfoDtoList=new ArrayList<ProductInfoDTO>();

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
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();

			while(rs.next()){
				ProductInfoDTO dto=new ProductInfoDTO();
				dto.setId(rs.getInt("id"));
				dto.setProductId(rs.getInt("product_id"));
				dto.setProductName(rs.getString("product_name"));
				dto.setProductNameKana(rs.getString("product_name_kana"));
				dto.setProductDescription(rs.getString("product_description"));
				dto.setCategoryId(rs.getInt("category_id"));
				dto.setPrice(rs.getInt("price"));
				dto.setImageFilePath(rs.getString("image_file_path"));
				dto.setImageFileName(rs.getString("image_file_name"));
				dto.setReleaseDate(rs.getString("release_date"));
				dto.setReleaseCompany(rs.getString("release_company"));
				dto.setStatus(rs.getInt("status"));
				dto.setRegistDate(rs.getString("regist_date"));
				dto.setUpdateDate(rs.getString("update_date"));
				productInfoDtoList.add(dto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return productInfoDtoList;

	}
//キーワードとカテゴリによる検索
	public List<ProductInfoDTO>getProductInfoListByKeywords(String[]keywordsList,String categoryId){
		DBConnector db=new DBConnector();
		con =db.getConnection();
		List<ProductInfoDTO>productInfoDtoList=new ArrayList<ProductInfoDTO>();
		String sql="SELECT*FROM product_info where";
		boolean initializeFlag=true;
		for(String keyword: keywordsList){
			if(initializeFlag){
				sql += " category_id="+ categoryId +" and((product_name like '%" + keyword + "%' or product_name_kana like '%" + keyword + "%')";
				initializeFlag=false;
			}else{
				sql += "or (product_name like '%" + keyword + "%' or product_name_kana like '%" + keyword + "%')";
			}
		}
			sql +=")";
		try{
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();

			while(rs.next()){
				ProductInfoDTO dto=new ProductInfoDTO();
				dto.setId(rs.getInt("id"));
				dto.setProductId(rs.getInt("product_id"));
				dto.setProductName(rs.getString("product_name"));
				dto.setProductNameKana(rs.getString("product_name_kana"));
				dto.setProductDescription(rs.getString("product_description"));
				dto.setCategoryId(rs.getInt("category_id"));
				dto.setPrice(rs.getInt("price"));
				dto.setImageFilePath(rs.getString("image_file_path"));
				dto.setImageFileName(rs.getString("image_file_name"));
				dto.setReleaseDate(rs.getString("release_date"));
				dto.setReleaseCompany(rs.getString("release_company"));
				dto.setStatus(rs.getInt("status"));
				dto.setRegistDate(rs.getString("regist_date"));
				dto.setUpdateDate(rs.getString("update_date"));
				productInfoDtoList.add(dto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return productInfoDtoList;
	}
}
