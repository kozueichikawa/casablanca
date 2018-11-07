<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>パスワード再設定画面</title>
</head>
<body>
<s:include value="header.jsp"/>
<div id="content">
<h1>パスワード再設定画面</h1>
<s:form action="ResetPasswordCompleteAction">
<s:property value="#session.loginId"/><br>
<s:property value="#session.concealedPassword"/><br>
<s:submit value="再設定" class="submit_btn"/>
</s:form>
</div>
<s:include value="footer.jsp"/>
</body>
</html>