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
	<s:if test="!passwordIncorrectErrorMessage.isEmpty()">
			<s:property value="passwordIncorrectErrorMessage"/>
	</s:if>

	<s:form action="LoginAction">
	<s:if test="#session.saveLoginStatus">
		<label>ユーザー名</label>
		<s:textfield name="loginId" value="%{#session.loginIdTemp}"/>
	</s:if>
	<s:else>
		<label>ユーザー名</label>
		<s:textfield name="loginId" label="ユーザー名"/>
	</s:else>
		<label>パスワード</label>
		<s:password name="password" label="パスワード"/>
	<s:if test="#session.saveLoginStatus">
		<label>ログインID保存</label>
		<s:checkbox name="saveLoginStatus" checked="checked"/>
	</s:if>
	<s:else>
		<label>ログインID保存</label>
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