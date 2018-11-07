<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>パスワード再設定</title>
</head>
<body>
<s:include value="header.jsp" />
<div id="contents">
<h1>パスワード再設定画面</h1>


	<s:if test="!loginIdErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="loginIdErrorMessageList"><s:property />
		<br></s:iterator>
		</div>
		</div>
	</s:if>

	<s:if test="!passwordErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="passwordErrorMessageList"><s:property />
		<br></s:iterator>
		</div>
		</div>
	</s:if>
	<s:if test="!passwordIncorrectErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="passwordIncorrectErrorMessageList"><s:property />
		<br></s:iterator>
		</div>
		</div>
	</s:if>

	<s:if test="!newPasswordErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="newPasswordErrorMessageList"><s:property />
		<br></s:iterator>
		</div>
		</div>
	</s:if>

	<s:if test="!reConfirmationNewPasswordErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="reConfirmationNewPasswordErrorMessageList"><s:property />
		<br></s:iterator>
		</div>
		</div>
	</s:if>
	<s:if test="!newPasswordIncorrectErrorMessageList.isEmpty()">
	<div class="error">
		<div class="error-message">
		<s:iterator value="newPasswordIncorrectErrorMessageList"><s:property />
		<br></s:iterator>
		</div>
	</div>
	</s:if>

<s:form action="ResetPasswordConfirmAction">
	<table class="vertical-list-table">
		<tr>
			<th scope="row"><s:label value="ログインID"/></th>
			<td><s:textfield name="loginId" placeholder="ログインID" class="txt" /></td>
		</tr>
		<tr>
			<th scope="row"><s:label value="現在のパスワード"/></th>
			<td><s:password name="password" placeholder="現在のパスワード" class="txt" /></td>
		</tr>

		<tr>
			<th scope="row"><s:label value="新しいパスワード"/></th>
			<td><s:password name="newPassword" placeholder="新しいパスワード" class="txt" /></td>
		<tr>
			<th scope="row"><s:label value="（再確認用）"/></th>
			<td><s:password name="reConfirmationPassword" placeholder="新しいパスワード（再確認用）" class="txt" /></td>
		</tr>
		</table>
<s:submit value="パスワード再設定" class="submit_btn" />
</s:form>
</div>
<s:include value="footer.jsp"/>
</body>
</html>