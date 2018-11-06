<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css" >
<title>決済確認</title>
</head>
<body>
<jsp:include page="header.jsp">
<div id="contents">
<s:if test="--list == null">
   <h3>宛先情報はありません</h3>
</s:if>
<s:else>
<h3>送り先情報を選択してください</h3>
<s:form action="SettlementCompleteAction">
<table border="1">
<tr>
<th>#</th>
<th>名前</th>
<th>ふりがな</th>
<th>住所</th>
<th>電話番号</th>
<th>メールアドレス</th>
</tr>
<s:iterator value="--list">
    <input type="radio" name="id" checked="checked" value = "<s:property value= 'id'/>"/>
    <s:property value="familyName"/> <s:property value = "firstName"/>
    <s:property value="familyNameKana"/> <s:property value = "firstNameKana"/>
    <s:property value="address"/>
    <s:property value="tel"/>
    <s:property value="email"/>
</s:iterator>
</table>
<s:submit value = "決済"/>
</s:form>
</s:else>
<s:form action = "createDestinationAction">
<s:submit value = "新規登録"/>
</s:form>
</div>
<div id="footer">
<jsp:include page="footer.jsp">
</div>

</body>
</html>
