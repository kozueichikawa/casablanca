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

<s:if test="!session.familyNameErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.familuNameErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>
<s:if test="!#session.firstNameErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
	<s:iterator value="!#session.firstNameErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>
<s:if test="!#session.familyNameKanaErrorMessageList.isEmpty()">
	<div class="error">	<div class="error-message">
	<s:iterator value="#session.familyNameKanaErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>
<s:if test="!#session.firstNameKanaErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
	<s:iterator value="!#session.firstNameKanaErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>
<s:if test="!#session.emailErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
	<s:iterator value="#session.emailErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>
<s:if test="!session.loginErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
	<s:iterator value="#session.loginErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>
<s:if test="!#session.passwordErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
	<s:iterator value="#session.passwordErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>

<s:form action="CreateUserConfirmAction">
<table class = "user-jouhou">
	<tr>

		<td><s:textfield name="familyName" value="%{#session.familyName}" label="姓" placeholder="姓" class="txt" /></td>
	</tr>

	<tr>

		<td><s:textfield name="firstName" value="%{#session.firstName}" label="名" placeholder="名" class="txt" /></td>
	</tr>

	<tr>

		<td><s:textfield name="familyNameKana" value="%{#session.familyNameKana}" label="姓ふりがな" placeholder="姓ふりがな" class="txt" /></td>
	<tr>

	<tr>

		<td><s:textfield name="firstNameKana" value="%{#session.firstNameKana}" label="名ふりがな" placeholder="名ふりがな" class="txt" /></td>
	</tr>

	<tr>
		<td>
			<label>男</label><input type="radio" value="">
			<label>女</label><input type="radio" value="">
		</td>
	</tr>

	<tr>
		<td><s:textfield name="email" value="%{#session.email}" label="メールアドレス" placeholder="メールアドレス" class="txt" /></td>
	</tr>

	<tr>
		<td><s:textfield name="loginId" value="%{#session.loginId}" label="ログインID" placeholder="ログインID" class="txt" /></td>
	</tr>

	<tr>
		<td><s:password name="password" value="" label="パスワード" class="txt" /></td>
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