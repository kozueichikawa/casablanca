<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<script>
</script>
</head>
<body>
<s:include value="header.jsp"/>
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
	<s:if test="#session.saveLoginStatus">
		<s:textfield name="loginId" value="%{#session.loginId}"/>
	</s:if>
	<s:else>
		<s:textfield name="loginId"/>
	</s:else>
		<s:password name="password"/>
	<s:if test="#session.saveLoginStatus">
		<s:checkbox name="saveLoginStatus" checked="checked"/>
	</s:if>
	<s:else>
	<s:checkbox name="saveLoginStatus"/>
	</s:else>
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