<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="Content-Script-Type" content="text/javascript" />
	<meta http-equiv="imagetoolbar" content="no" />
	<meta name="description" content="" />
	<meta name="keywords" content="" />



<title>Cart</title>

<script type="text/javascript">

function goDeleteCartAction(){
	document.getElementById("form").action='DeleteCartAction';
}
</script>
</head>
<body>

<s:include value="header.jsp" />
<br>
<div id="title">
<h2>カート画面</h2>
</div>

<s:if test="checkListErrorMessageList!=null">
	<div class="error">
		<div class="error-message">
		<s:iterator value="checkListErrorMessageList">
		<s:property />
		</s:iterator>
		</div>
</div>
</s:if>

<s:if test="cartInfoDtoList.size()>0">
<s:form id="form" action="SettlementConfirmAction">


<table class="horizontal-list-table">
<thead>
<tr>
<th><s:label value="#" /></th>
<th><s:label value="商品名" /></th>
<th><s:label value="ふりがな" /></th>
<th><s:label value="商品画像" /></th>
<th><s:label value="値段" /></th>
<th><s:label value="発売会社名" /></th>
<th><s:label value="発売年月日" /></th>
<th><s:label value="購入個数" /></th>
<th><s:label value="合計金額" /></th>
</tr>
</thead>
<tbody>
<s:iterator value="cartInfoDtoList">
<tr>
	<td><s:checkbox name="checkList" value="checked" fieldValue="%{id}" /> </td>
	<s:hidden name="productId" value="%{productId}" />
	<td><s:property value="productName" /></td>
	<td><s:property value="productNameKana" /></td>
	<td><img src='<s:property value="imageFilePath" />/
	<s:property value="imageFileName" />' width="50px" height="50px" /></td>
	<td><s:property value="price" />円</td>
	<td><s:property value="releaseCompany" /></td>
	<td><s:property value="releaseDate" /></td>
	<td><s:property value="productCount" /></td>
	<td><s:property value="subtotal" />円</td>
</tr>
<s:hidden name="productName" value="%{productName}" />
<s:hidden name="productNameKana" value="%{productNameKana}" />
<s:hidden name="imageFilePath" value="%{imageFilePath}" />
<s:hidden name="imageFileName" value="%{imageFileName}" />
<s:hidden name="price" value="%{price}" />
<s:hidden name="releaseCompany" value="%{releaseCompany}" />
<s:hidden name="releaseDate" value="%{releaseDate}" />
<s:hidden name="productCount" value="%{productCount}" />
<s:hidden name="subtotal" value="%{subtotal}" />

</s:iterator>
</tbody>
</table>

<h2><s:label value="カート合計金額 :"/><s:property value="totalPrice" />円</h2>
<div class="submit_btn_box">
	<div id=".contents-btn-set">
	<s:submit value="決済" class="submit_btn" />
	</div>
</div>


<div class="submit_btn_box">
<div id=".contents-btn-set">
<s:submit value="削除" class="submit_btn" onclick="this.form.action='DeleteCartAction';" />

</div>
</div>
</s:form>
</s:if>
<s:else>
<div class="info">
カート情報はありません。
</div>
</s:else>
<div id="footer">
<s:include value="footer.jsp" />
</div>
</body>
</html>