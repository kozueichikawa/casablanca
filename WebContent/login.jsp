<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
	<s:if test="!loginIdErrorMessageList.isEmpty()">
		<s:iterator value="loginIdErrorMessageList">
			<s:property/>
		</s:iterator>
	</s:if>
	<s:if test="!passwordErrorMessageList.isEmpty()">
		<s:iterator value="passwordErrorMessageList">
			<s:property/>
		</s:iterator>
	</s:if>
	<s:form action="LoginAction">
	<s:if test="#session.isSavedLoginId">
		<s:textfield name="loginId" value="#session.loginId"/>
	</s:if>
	<s:else>
		<s:textfield name="loginId"/>
	</s:else>
		<s:password name="password"/>
		<s:checkbox name="isSavedLoginId"/>
	<s:submit value="ログイン"/>
	</s:form>
	<s:form action="CreateUserAction">
		<s:submit value="新規登録"/>
	</s:form>
	<s:form action="ResetPasswordAction">
		<s:submit value="パスワード再設定"/>
	</s:form>
</body>
</html>