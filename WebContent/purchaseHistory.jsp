<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>商品購入履歴</title>
</head>
<body>
<s:include value="header.jsp"/>
<div id="contents">
<h1>商品購入履歴</h1>
<s:if test="purchaseHistoryInfoDtoList==null">
<div class="info">
商品購入情報はありません
</div>
</s:if>
<s:else>
<table class="horizontal-list-table">
<thead>
<tr>
	<th><s:label value="商品名"/></th>
	<th><s:label value="ふりがな"/></th>
	<th><s:label value="商品画像"/></th>
	<th><s:label value="値段"/></th>
	<th><s:label value="発売会社"/></th>
	<th><s:label value="発売年月日"/></th>

</tr>
<tbody>
<s:iterator value="purchaseHistoryInfoDtoList">
<tr>
	<td><s:property value="productName"/></td>
	<td><s:property value="productNameKana"/></td>
	<td><img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' width="50px" height="50px"/></td>
	<td><s:property value="price"/>円</td>
	<td><s:property value="releaseCompany"/></td>
	<td><s:property value="releaseDate"/></td>

</tr>
</s:iterator>
</tbody>
</table>
<div class="submit_btn_box">
<div id=".content-btn-set">
<s:form action="DeletePurchaseHistoryAction">
	<s:submit value="削除" class="submit_btn"/>
</s:form>
</div>
</div>


</s:else>
</div>
<s:include value="footer.jsp"/>

</body>
</html>