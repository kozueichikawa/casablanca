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
<jsp:include page="header.jsp"/>
<div id="contents">
<h1>商品購入履歴</h1>
<s:if test="#session.purchaseHistoryInfoDTOList.size()>0">
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
<s:iterator value="#session.purchaseHistoryInfoDTOList">
<tr>
	<td><s:property value="productName"/></td>
	<td><s:property value="productNameKana"/></td>
	<td><img src='<s:propery value="imageFilePath"/>/<s:property value=

</tr>
</s:iterator>
</tbody>
</thead>
</table>

</s:if>
</div>

</body>
</html>