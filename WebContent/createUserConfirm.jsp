<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KJDSFLALKFJ</title>
</head>
<body>
	<s:form action="CreateUserCompleteAction">
		<table>
			<tr>
				<td><s:property value="familyName" /></td>
			</tr>
			<tr>
				<td><s:property value="firstName" /></td>
			</tr>
			<tr>
				<td><s:property value="familyNameKana" /></td>
			</tr>
			<tr>
				<td><s:property value="firstNameKana" /></td>
			</tr>
			<tr>
				<td><s:property value="sex" /></td>
			</tr>
			<tr>
				<td><s:property value="email" /></td>
			</tr>
			<tr>
					<td><s:property value="loginId" /></td>
			</tr>
			<tr>
				<td><s:property value="password" /></td>
			</tr>
			</table>

			<s:submit value="登録"/>
			<s:hidden name="loginId" value="%{loginId}" />
			<s:hidden name="password" value="%{password}" />
			<s:hidden name="familyName"value="%{familyName}" />
			<s:hidden name="firstName" value="%{firstName}" />
			<s:hidden name="familyNameKana" value="%{familyNameKana}" />
			<s:hidden name="firstNameKana" value="%{firstNameKana}" />
			<s:if test='sex.equals("男性")'>;
			<s:hidden name="sex" value="0" />
			</s:if>
			<s:if test='sex.equals("女性")'>;
			<s:hidden name="sex" value="1" />
			</s:if>
			<s:hidden name="email" value="%{email}"/>
	</s:form>
</body>
</html>