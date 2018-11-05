package com.internousdev.casablanca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.casablanca.dto.PurchaseHistoryInfoDTO;
import com.internousdev.casablanca.util.DBConnector;

public class PurchaseHistoryInfoDAO {
	public List<PurchaseHistoryInfoDTO> getPurchaseHistoryList(String loginId){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTOList=new ArrayList<PurchaseHistoryInfoDTO>();

		String sql="select"
				+ "phi.id as id," /*ID*/
				+ "phi.user_id as user_id,"/*ユーザーID*/
				+ "phi.product_count as product_count,"/*個数*/
				+ "pi.product_id as product_id,"/*商品ID*/
				+ "pi.product_name as product_name,"/*商品名*/
				+ "pi.product_name_kana as product_name_kana,"/*商品名かな*/
				+ "pi.product_description as product_description,"/*商品詳細*/
				+ "pi.category_id as category_id,"/*カテゴリID*/
				+ "pi.price"/*価格*/
				+ "pi.image_file_name as image_file_name,"/*画像ファイル名*/
				+ "pi.image_file_path as image_file_path,"/*画像ファイルパス*/
				+ "pi.release_company,"/*発売会社名*/
				+ "pi.release_date,"/*発売年月名*/
				+ "phi.price as price,"/*値段*/
				+ "phi.regist_date as regist_date,"/*登録名*/
				+ "phi.update_date as update_date,"/*更新名*/
				+ "di.family_name as family_name,"/*姓*/
				+ "di.first_name as first_name,"/*名*/
				+ "di.family_name_kana as family_name_kana,"/*姓かな*/
				+ "di.first_name_kana as first_name_kana,"/*名かな*/
				+ "di.email as email,"/*メールアドレス*/
				+ "di.tel_number as tel_number,"/*電話番号*/
				+ "di.user_address as user_address,"
				+ "FROM purchase_history_info as phi"
				+ "LEFT JOIN product_info as pi"
				+ "ON phi.product_id=pi.droduct_id"
				+ "LEFT JOIN destination_info as di"
				+ "ON phi.destination_id=di.id"
				+ "WHERE phi.user_id=?"
				+ "ORDER BY regist_date DESC";

		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,loginId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				PurchaseHistoryInfoDTO purchaseHistoryInfoDTO=new PurchaseHistoryInfoDTO();
				purchaseHistoryInfoDTO.setId(rs.getInt("id"));
				purchaseHistoryInfoDTO.setUserId(rs.getString("user_id"));
				purchaseHistoryInfoDTO.setProductId(rs.getInt("product_id"));
				purchaseHistoryInfoDTO.setProductCount(rs.getInt("product_count"));
				purchaseHistoryInfoDTO.setPrice(rs.getInt("price"));
				purchaseHistoryInfoDTO.setRegistDate(rs.getDate("regist_date"));
				purchaseHistoryInfoDTO.setUpdateDate(rs.getDate("update_date"));
				purchaseHistoryInfoDTO.setProductName(rs.getString("product_name"));
				purchaseHistoryInfoDTO.setProductNameKana(rs.getString("product_name_kana"));
				purchaseHistoryInfoDTO.setProductDescription(rs.getString("productDescription"));
				purchaseHistoryInfoDTO.setCategoryId(rs.getInt("category_id"));
				purchaseHistoryInfoDTO.setImageFileName(rs.getString("image_file_name"));
				purchaseHistoryInfoDTO.setImageFilePath(rs.getString("image_file_path"));
				purchaseHistoryInfoDTO.setReleaseCompany(rs.getString("release_company"));
				purchaseHistoryInfoDTO.setReleaseDate(rs.getDate("release_date"));
				purchaseHistoryInfoDTO.setFamilyName(rs.getString("family_name"));
				purchaseHistoryInfoDTO.setFirstName(rs.getString("family_name"));
				purchaseHistoryInfoDTO.setFamilyNameKana(rs.getString("family_name_kana"));
				purchaseHistoryInfoDTO.setFirstNameKana(rs.getString("first_name_kana"));
				purchaseHistoryInfoDTO.setEmail(rs.getString("email"));
				purchaseHistoryInfoDTO.setTelNumber(rs.getString("tel_number"));
				purchaseHistoryInfoDTO.setUserAddress(rs.getString("user_address"));
				purchaseHistoryInfoDTOList.add(purchaseHistoryInfoDTO);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return purchaseHistoryInfoDTOList;
		}
	public int regist(String loginId,int productId,int productCount,int destinationId,int price) {
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		String sql="insert into purchase_historty_info(user_id,product_id,product_count,price,destination_id,regist_date,update_date)"
				+ "values(?,?,?,?,?,now(),'0000-01-01)";


		int count=0;
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,loginId);
			ps.setInt(2, productId);
			ps.setInt(3, productCount);
			ps.setInt(4, price);
			ps.setInt(5, destinationId);

			count=ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return count;

	}
	public int deleteAll(String loginId) {
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		String sql="delete from purchase_history_info where user_id=?";
		int count=0;
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, loginId);
			count=ps.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return count;

	}

	}

