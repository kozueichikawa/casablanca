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
<s:include value="header.jsp"/>
<div id="contents">
<s:if test="destinationInfoDtoList==null || destinationInfoDtoList.size()==0">
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
<s:iterator value="destinationInfoDtoList" status="index">
<tr>
	<s:if test="#index.first">
    	<td><input type="radio" name="id" checked="checked" value='<s:property value="id"/>'/></td>
    </s:if>
    <s:else>
    	<td><input type="radio" name="id" value='<s:property value="id"/>'/></td>
    </s:else>
    <td><s:property value="familyName"/> <s:property value = "firstName"/></td>
    <td><s:property value="familyNameKana"/> <s:property value = "firstNameKana"/></td>
    <td><s:property value="userAddress"/></td>
    <td><s:property value="telNumber"/></td>
    <td><s:property value="email"/></td>
    </tr>
</s:iterator>
</table>
<s:submit value = "決済"/>
</s:form>
</s:else>
<s:form action = "CreateDestinationAction">
<s:submit value = "新規登録"/>
</s:form>
</div>
<s:include value="footer.jsp"/>
</body>
</html>
