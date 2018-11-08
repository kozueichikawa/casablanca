<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>



<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-text-Type" content="text/css; charset=UTF-8">
<meta http-equiv="Content-Script-Type" content="text.javascript; charset=UTF-8">
<meta name="description" content="" />
<meta name="keywords" content="" />

<title>createUser.jsp</title>

</head>
<body>

<s:if test="!familyNameErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.familuNameErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>
<s:if test="!firstNameErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
	<s:iterator value="firstNameErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>
<s:if test="!familyNameKanaErrorMessageList.isEmpty()">
	<div class="error">	<div class="error-message">
	<s:iterator value="#session.familyNameKanaErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>
<s:if test="!firstNameKanaErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
	<s:iterator value="firstNameKanaErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>
<s:if test="!emailErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
	<s:iterator value="emailErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>
<s:if test="!loginErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
	<s:iterator value="loginErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>
<s:if test="!passwordErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
	<s:iterator value="passwordErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>

<s:form action="CreateUserConfirmAction">
<table class = "user-jouhou">
	<tr>
		<td>姓</td>
		<td><s:textfield name="familyName" value="%{#session.familyName}" label="姓" placeholder="姓" class="txt" /></td>
	</tr>

	<tr>
		<td>名</td>
		<td><s:textfield name="firstName" value="%{#session.firstName}" label="名" placeholder="名" class="txt" /></td>
	</tr>

	<tr>
		<td>姓かな</td>
		<td><s:textfield name="familyNameKana" value="%{#session.familyNameKana}" label="姓ふりがな" placeholder="姓ふりがな" class="txt" /></td>
	<tr>

	<tr>
		<td>名かな</td>
		<td><s:textfield name="firstNameKana" value="%{#session.firstNameKana}" label="名ふりがな" placeholder="名ふりがな" class="txt" /></td>
	</tr>

	<tr>
		<td>
			<label>男性</label><input type="radio" value="0" name="sex"/>
			<label>女性</label><input type="radio" value="1" name="sex"/>
		</td>
	</tr>

	<tr>
		<td>メールアドレス</td>
		<td><s:textfield name="email" value="%{#session.email}" label="メールアドレス" placeholder="メールアドレス" class="txt" /></td>
	</tr>

	<tr>
		<td>ログインID</td>
		<td><s:textfield name="loginId" value="%{#session.loginId}" label="ログインID" placeholder="ログインID" class="txt" /></td>
	</tr>

	<tr>
		<td>パスワード</td>
		<td><s:password name="password" value="" label="パスワード" class="txt" placeholder="パスワード" /></td>
	</tr>
</table>
<div class="submit_btn_box">
<div id=".contents-btn-set">
<s:submit value="登録" class="submit_btn" />
</div>
</div>
</s:form>


</body>
</html>