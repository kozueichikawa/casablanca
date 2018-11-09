<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>宛先情報完了</title>



</head>

<body>

<s:include value="header.jsp"/>

<div id="contents">
<h1>宛先情報完了画面</h1>
<div class="success">
宛先情報の登録が完了しました。
<s:form action="SettlementConfirmAction" name="back">
	<s:iterator value="#session.cartInfoDtoList">
		<s:hidden name="productName" value="%{productName}"/>
		<s:hidden name="productNameKana" value="%{productNameKana}"/>
		<s:hidden name="imageFilePath" value="%{imageFilePath}"/>
		<s:hidden name="imageFileName" value="%{imageFileName}"/>
		<s:hidden name="price" value="%{price}"/>
		<s:hidden name="releaseCompany" value="%{releaseCompany}"/>
		<s:hidden name="releaseDate" value="%{releaseDate}"/>
		<s:hidden name="productCount" value="%{productCount}"/>
		<s:hidden name="subtotal" value="%{subtotal}"/>
		<s:hidden name="productId" value="%{productId}"/>
	</s:iterator>
</s:form>
</div>
</div>

<s:include value="footer.jsp"/>

</body>
</html>