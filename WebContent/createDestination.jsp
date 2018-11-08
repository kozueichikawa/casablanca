<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>宛先情報入力</title>
</head>
<body>
<s:include value="header.jsp"/>
<div id="contents">
<h1>宛先情報入力画面</h1>

<s:if test="!familyNameErrorMessageList.isEmpty()">
	<div class="error">
		<div class="error-message">
			<s:iterator value="familyNameErrorMessageList">
				<s:property/><br>
			</s:iterator>
		</div>
	</div>
</s:if>
<s:if test="!firstNameErrorMessageList.isEmpty()">
	<div class="error">
		<div class="error-message">
			<s:iterator value="firstNameErrorMessageList"><s:property/><br></s:iterator>
		</div>
	</div>
</s:if>
<s:if test="!familyNameKanaErrorMessageList.isEmpty()">
	<div class="error">
		<div class="error-message">
			<s:iterator value="familyNameKanaErrorMessageList"><s:property/><br></s:iterator>
		</div>
	</div>
</s:if>
<s:if test="!firstNameKanaErrorMessageList.isEmpty()">
	<div class="error">
		<div class="error-message">
			<s:iterator value="firstNameKanaErrorMessageList"><s:property/><br></s:iterator>
		</div>
	</div>
</s:if>
<s:if test="!emailErrorMessageList.isEmpty()">
	<div class="error">
		<div class="error-message">
			<s:iterator value="emailErrorMessageList"><s:property/><br></s:iterator>
		</div>
	</div>
</s:if>
<s:if test="!telNumberErrorMessageList.isEmpty()">
	<div class="error">
		<div class="error-message">
			<s:iterator value="telNumberErrorMessageList"><s:property/><br></s:iterator>
		</div>
	</div>
</s:if>
<s:if test="!userAdressErrorMessageList.isEmpty()">
	<div class="error">
		<div class="error-message">
			<s:iterator value="userAdressErrorMessageList"><s:property/><br></s:iterator>
		</div>
	</div>
</s:if>


<s:form action="CreateDestinationConfirmAction">
<table class="list-table">

<tr>
	<th scope="row">
		<s:label value="姓"/>
	</th>
	<td>
		<s:textfield name="familyName" class="txt"/>
	</td>
</tr>

<tr>
	<th scope="row">
		<s:label value="名"/>
	</th>
	<td>
		<s:textfield name="firstName" class="txt"/>
	</td>
</tr>

<tr>
 <th scope="row">
 	<s:label value="姓ふりがな"/>
 </th>
 <td>
 	<s:textfield name="familyNameKana" class="txt"/>
 </td>
</tr>

<tr>
	<th scope="row">
		<s:label value="名ふりがな"/>
	</th>
	<td>
		<s:textfield name="firstNameKana" class="txt"/>
	</td>
</tr>

<tr>
	<th scope="row">
		<s:label value="性別"/>
	</th>
	<td>
		<s:radio name="sex" list="sexList" value="defaultSexValue" label="性別" placeholder="性別"/>
	</td>
</tr>

<tr>
	<th scope="row">
	 <s:label value="住所"/>
	</th>
	<td>
		<s:textfield name="userAddress" class="txt"/>
	</td>
</tr>

<tr>
	<th scope="row">
		<s:label value="電話番号"/>
	</th>
	<td>
		<s:textfield name="telNumber" class="txt"/>
	</td>
</tr>

<tr>
	<th scope="row">
		<s:label value="メールアドレス"/>
	</th>
	<td>
		<s:textfield name="email" class="txt"/>
	</td>
</tr>
</table>
<div class="submit_btn_box">
<div id=".contents-btn-set">
<s:submit value="宛先情報確認" class="submit_btn"/>
</div>
</div>
</s:form>
</div>
<s:include value="footer.jsp"/>
</body>
</html>