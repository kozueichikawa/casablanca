<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
</head>
<body>
<ul>
	<s:form action="SearchItemAction">
	<li><s:select name="categoryId" list="#session.mCategoryList" listKey="categoryId" listValue="categoryName"/></li>
	<li><s:textfield name="keywords" value="%{keywords}" placeholder="検索ワード"/></li>
	<li><s:submit value="商品検索"/></li>
	</s:form>
	<s:if test="#session.logined==1">
		<s:form action="LogoutAction">
			<s:submit value="ログアウト"/>
		</s:form>
	</s:if>
	<s:else>
	<li><s:form action="GoLoginAction">
		<s:submit value="ログイン"/>
	</s:form></li>
	</s:else>
	<li><s:form action="CartAction">
		<s:submit value="カート"/>
	</s:form></li>
	<li><s:form action="ProductListAction">
		<s:submit value="商品一覧"/>
	</s:form></li>
	<s:if test="#session.logined==1">
		<li><s:form>
			<li><s:submit value="マイページ"/>
		</s:form></li>
	</s:if>
</ul>
</body>
</html>