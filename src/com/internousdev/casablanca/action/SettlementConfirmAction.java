package com.internousdev.casablanca.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.casablanca.dao.DestinationInfoDAO;
import com.internousdev.casablanca.dao.MCategoryDAO;
import com.internousdev.casablanca.dto.DestinationInfoDTO;
import com.internousdev.casablanca.dto.MCategoryDTO;
import com.internousdev.casablanca.dto.PurchaseHistoryInfoDTO;
import com.internousdev.casablanca.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class SettlementConfirmAction extends ActionSupport implements SessionAware{

	private List<DestinationInfoDTO> destinationInfoDtoList;
	private String productId;
	private String productName;
	private String productNameKana;
	private String imageFilePath;
	private String imageFileName;
	private String price;
	private String releaseCompany;
	private String releaseDate;
	private String productCount;
	private String subtotal;
	private Map<String, Object> session;
	public String execute() {
		String result = ERROR;

		/* ログイン状態か否かを判定 */
		if(Objects.equals(session.get("logined"), "1")) {
			/* ログイン状態であれば、まず宛先情報をListにしてValueStackへ積む */
			DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();
			destinationInfoDtoList = new ArrayList<>();
			destinationInfoDtoList = destinationInfoDAO.getDestinationInfo((session.get("loginId").toString()));
			if (destinationInfoDtoList.size() == 0) {
				destinationInfoDtoList = null;
			}
			result = SUCCESS;
		} else {
			/* ログイン状態でなければ、loginAction分岐用にカートフラグを立てる */
			session.put("fromCart", true);
			System.out.println("未ログイン状態");
		}
		/* cart.jspに入っていた注文リストをSettlementCompleteActionへ送るためのListを生成する */
		List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDtoList = new ArrayList<PurchaseHistoryInfoDTO>();

		/* cart.jspから[xx, xx, xx]というStringで渡ってくる各値をCommonUtilityで,(カンマ)区切りで配列に変換する */
		CommonUtility commonUtility = new CommonUtility();
		String[] productIdList = commonUtility.parseArrayList(productId);
		String[] productNameList = commonUtility.parseArrayList(productName);
		String[] productNameKanaList = commonUtility.parseArrayList(productNameKana);
		String[] imageFilePathList = commonUtility.parseArrayList(imageFilePath);
		String[] imageFileNameList = commonUtility.parseArrayList(imageFileName);
		String[] priceList = commonUtility.parseArrayList(price);
		String[] releaseCompanyList = commonUtility.parseArrayList(releaseCompany);
		String[] releaseDateList = commonUtility.parseArrayList(releaseDate);
		String[] productCountList = commonUtility.parseArrayList(productCount);
		String[] subtotalList = commonUtility.parseArrayList(subtotal);

		/* 購入する品物数分のDTOを生成しそのDTOをListに格納していく。
		 * ▼ cart.jspに4つの品物を入れた状態で決済ボタンを押した時の、for文を終えた時のListイメージ
		 * |_dto_|_dto_|_dto_|_dto_|　←DTO１つ対し１つに商品情報がそれぞれ詰まっている
		 *    0     1     2     3                                  */
		for(int i=0;i<productIdList.length;i++) {
			PurchaseHistoryInfoDTO purchaseHistoryInfoDTO = new PurchaseHistoryInfoDTO();
			purchaseHistoryInfoDTO.setUserId(String.valueOf(session.get("loginId")));
			purchaseHistoryInfoDTO.setProductId(Integer.parseInt(String.valueOf(productIdList[i])));
			purchaseHistoryInfoDTO.setProductName(String.valueOf(productNameList[i]));
			purchaseHistoryInfoDTO.setProductNameKana(String.valueOf(productNameKanaList[i]));
			purchaseHistoryInfoDTO.setImageFilePath(String.valueOf(imageFilePathList[i]));
			purchaseHistoryInfoDTO.setImageFileName(String.valueOf(imageFileNameList[i]));
			purchaseHistoryInfoDTO.setPrice(Integer.parseInt(String.valueOf(priceList[i])));
			purchaseHistoryInfoDTO.setReleaseCompany(String.valueOf(releaseCompanyList[i]));
			try {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
				purchaseHistoryInfoDTO.setReleaseDate(simpleDateFormat.parse(String.valueOf(releaseDateList[i])));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			purchaseHistoryInfoDTO.setProductCount(Integer.parseInt(String.valueOf(productCountList[i])));
			purchaseHistoryInfoDTO.setSubtotal(Integer.parseInt(String.valueOf(subtotalList[i])));
			purchaseHistoryInfoDtoList.add(purchaseHistoryInfoDTO);
		}

		/* 出来上がったListをセッションへ格納し、SettlementCompleteActionでgetできるようにする */
		session.put("purchaseHistoryInfoDtoList", purchaseHistoryInfoDtoList);

		/* カテゴリリストのセッションが切れてしまい次ページでカテゴリが表示されない事象を防ぐため */
		if(!session.containsKey("mCategoryList")) {
			MCategoryDAO mCategoryDAO=new MCategoryDAO();
			List<MCategoryDTO> mCategoryDtoList= mCategoryDAO.getMCategoryList();
			session.put("mCategoryDtoList", mCategoryDtoList);
		}

		/* ログイン状態で本Actionが実行されればSUCCESS(settlementConfirm.jsp)、未ログイン状態ならERROR(login.jsp) */
		return result;
	}

	public List<DestinationInfoDTO> getDestinationInfoDtoList() {
		return destinationInfoDtoList;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductNameKana(String productNameKana) {
		this.productNameKana = productNameKana;
	}

	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setReleaseCompany(String releaseCompany) {
		this.releaseCompany = releaseCompany;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public void setProductCount(String productCount) {
		this.productCount = productCount;
	}

	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}
}
