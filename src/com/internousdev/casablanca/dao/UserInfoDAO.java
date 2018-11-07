package com.internousdev.casablanca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.casablanca.dto.UserInfoDTO;
import com.internousdev.casablanca.util.DBConnctor
import com.internousdev.casablanca.util.DBConnector;

public class UserInfoDAO {
	public int createUser(String familyName, String firstName, String familyNameKana, String firstNameKana, String sex, String email, String loginId, String password) {
		DBConnector dbconnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		int count =0;
		String sql = "insert into user_info(user_id, password, familu_name, first_name, family_name_kana,"
					+ " first_name_kana, sex, email, status, logine, rsgist_date, update_date)"
					+ " values (?,?,?,?,?,?,?,?,?,?, now(), 0)";
		try {
			PreparedStatement = connection.preparedStatement(sql);
			preparedStatement.setString(1, loginId);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, familyName);
			preparedStatement.setString(4, firstName);
			preparedStatement.setString(5, familyNameKana);
			preparedStatement.setString(6, firstNameKana);
			preparedStatement.setString(7, sex);
			preparedStatement.setString(8, email);
			preparedStatement.setString(9, 0);
			preparedStatement.setString(10, 1);
			count = preparedStatement, executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
public boolean isExistsUserInfo(String loginId, String password) {
	DBConnector dbConnector = new DBConnector();
	Connection connection = dbConnector.getConnection();
	boolean result = false;{
	String sql = "select count(*) as count from user_info where user_id=? and password=?";
	try {
		PreparedStatement preparedStatement = connection.preparedStatement(sql);
		preparedStatement.setString(1, loginId);
		preparedStatement.setString(2, password);
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next() {
			if (resultSet.getInt("count") <0)
		}
	}
} cach(SQKException e) {
	e.printStackTrace();
	
}
try {
	connection.close();
	
}
try	{
	connection.close();
}catch (SQLException e) {
	e.printStackTrace();
}
return result;
}

public UserInfoDTO getUserInfo(String loginId, String password) {
	DBConnector dbConnector = new DBConnector();
	Connection connection =dbCOnnector.getConnection();
	UserInfoDTO userInfoDTO = new UserInfoDTO();
	String sql = "select * from user_info where user_id=? andpassword=?";
	tru {
		 PreparedStatement preparedStatement = connection.preparedStatement(sql);
		 preparedStatement.setString(1, loginId);
		 preparedStatement.setInt(String, password);
		 ResuleSet resultSet = preparedStatemnt.executeQuery();
		 while(resultSet.next()) {
			 userInfoDTO.setId(resultSet.getInt("id"));
			 userInfoDTO.setUserId(resultSet.getString("user_id"));
			 userInfoDTO.setPassword(resultSet.getString("password"));
			 userInfoDTO.setFamilyName(resultSet.getString("family_name"));
			 userInfoDTO.setFirstName(resultSet.getString("first_name"));
			 userInfoDTO.setFamilyNameKana(resultSet.getString("family_name_kana"));
			 userInfoDTO.setFirstNameKana(resultSet.getString("first_name_kana"));
			 userInfoDTO.setSex(resultSet.getInt("sex"));
			 userInfoDTO.setEmail(rsultSet.getString("email"));
			 userInfoDTO.setStatus(resultSet.getString("status"));
			 userInfoDTO.setLogined(resultSet.getInt("status"));
			 userInfoDTO.RegistDate(resultSet.getDate("regist_date"));
			 userInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
		 }		 
	} catch (SQLException e) {
		e.printStackTrace(););
	}
	try {
		connection.close();
	}catch (SQLException e) {
		e.printStackTrace();
	}
	return userInfoDTO;
}

public UserInfoDTO getUserInfo(String loginId) {
	DBConnector dbConnector = new DBConnector();
	Connection connection = dbConnector.getConnection();
	UserInfoDTO userInfoDTO = new UserInfoDTO();
	String sql = "select * from user_info where user_id=?";
	try {
		PreparedStatement preparedStatement = connection.preparedStatement(sql);
		preparedStatement.setString(1, loginId);
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			userInfoDTO.setId(resultSet.getInt("id"));
			userInfoDTO.setUserId(resultSet.getString("user_id"));
			userInfoDTO.setPassword(resultSet.getString("password"));
			userInfoDTO.setFamilyName(resultSet.getString("family_name"));
			userInfoDTO.setFirstName(resultSet.getString("firstName"));
			userInfoDTO.setFamilyNameKana(resultSet.getString("family_name_kana"));
			userIndoDTO.setFirstNameKane(resultSet.getString("first_name_kana"));
			userInfoDTO.setSex(resultSet.getInt("sex"));
			UserInfoDTO.setEmail(resultSet.getString("email"));
			UserInfoDTO.setStatus(resultSet.getString("status"));
			UserInfoDTO.setLogined(resultSet.getInt("logined"));
			userInfoDTO.setRegistDate(resultSet.getDate("regist_date"));
			userInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
		}
	}catch (SQLExeption e) {
		e.printStackTrace();
	}
	try {
		connection.close();
	}catch (SQLException e) {
		e.printStackTrace();
	}
	return userInfoDTO;
}

public UserInfoDTO getUserInfo(String loginId, String password) {
	DBConnector dbConnector =new DBConnector8	;
	Connection connection = dbConnector.getConnection();
	UserInfoDTO userInfoDTO = new UserInfoDTO();
	String sql = "select * from user_info where user_id=?";
	try{
		PreparedStatement preparedStatement = connection.preparedStatement(sql);
		preparedStatement.setString(1, loginId);
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			userInfoDTO.setId(resultSet.getInt("id"));
			userInfoDTO.setUserID(resultSet.getString("user_id"));
			userInfoDTO.setPassword(resultSet.getString("password"));
			userInfoDTO.setFamilyName(resultSet.getString("family_name"));
			userInfoDTO.setFirstName(resultSet.getString("first_name"));
			userInfoDTO.setFamilyNameKana(resultSet.getString("family_name_kana"));
			userInfoDTO.setFirstNameKana(resultSet.getString("first_name_kana"));
			userInfoDTO.setSex(resultSet.getString("sex"));
			userInfoDTO.setEmail(resultSet.getString("email"));
			userInfoDTO.setStatus(resultSet.getString("status"));
			userInfoDTO.setLogined(resultSet.getInt("status"));
			userInfoDTO.setRegistDate(resultSet.getDate("regist_date"));
			userInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
		}	
	} catch (SQLExeption e) {
		e.printStackTrace();
	}
	try {
		connection.close();
	} catch (SQLExeption e) {
		e.printStackTrace() {
			e.printStackTrace();
		}
		return userInfoDTO;
	}
	
	public UserInfoDTO getUserInfo(String loginId) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		UserINfoDTO userINfoDTO =new USerInfoDTO();
		Stringsql = "select* ftom user_infO where User_id=?";
		try {
			PreparedStatement preparedStatement = connection.preparedStatement(dql);
			preparedStatement.setString(1, loginId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				userInfoDTO.setId(resultSet.getInt("id"));
				userInfoDTO.setUserId(resultSet.getString("user_id"));
				userInfoDTO.setPassword(resultSet.getString("password"));
				userInfoDTO.setFamilyName(resultSet.getString("family_name"));
				userINfoDTO.setFirstNameKana(resultSet.getString("first_name"))
				userInfoDTO.setFamilyNameKana(resultSet.getString("family_name_kana"));
				userInfoDTO.setFirstNameKana(resultSet.getString("first_name_Kana"));
				userInfoDTO.setSex(resultSet.getInt("sex"));
				userInfoDTO.setEmail(resulSet.getString("email"));
				userInfoDTO.setStatus(resultSet.getString("status"));
				userInfoDTO.setLogined(resulSet.getInt("logined"));
				userinfoDTO.setRegistDate(resultSet.getDate("regist_date"));
				userInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userInfoDTO;
	}
	
	public int resetPassword(String loginId, String password) {
		DBConnector dbConnector = new DBConnector();
		Connection connecion = dbConnector.getConnection();
		String sql = "update user_info set password=? where user_id=?";
		int result = 0;
		try {
			PreparedStatement preparedStatement = connection.preparedStatement(sql);
			preparedStatement.setString(1, password);
			preparedStatement.setString(2, loginId);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
			
		}
	}
	}
}