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
	<s:form action="LoginAction">
	<s:if test="#session.savedLoginId==true">
		<s:textfield name="loginId" value="%{session.loginId}"/>
	</s:if>
	<s:else>
		<s:textfield name="loginId"/>
	</s:else>
		<s:password name="password"/>
		<s:checkbox name="savedLoginId"/>
	<s:submit value="ログイン"/>
	</s:form>
</body>
</html>