<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>決済確認</title>
</head>
<body>

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
    <input type="radio" name="id" value="1"/>
    <s:property value="familyName"/> <s:property value="firstName"/>
    <s:property value="familyNameKana"/> <s:property value="firstNameKana"/>
    <s:property value="address"/>
    <s:property value="tel"/>
    <s:property value="email"/>
</s:iterator>
</table>
<s:submit value="決済"/>
</s:form>
</s:else>
<s:form action="createDestinationAction">
<s:submit value="新規登録"/>
</s:form>
</body>
</html>