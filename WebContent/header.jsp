<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
<link rel="stylesheet" href="./css/casablanca.css">
</head>
<body>

<div id="top">

<div id="logo">
<p>casablanca</p>
</div>
<ul>


	<li><a href="CartAction">カート</a></li>
	<li><a href="ProductListAction">商品一覧</a></li>
	<s:if test="#session.logined==1">
		<li><a href="MyPageAction">マイページ</a></li>
	</s:if>
		<s:if test="#session.logined==1">
		<li><a href="LogoutAction">ログアウト</a></li>
	</s:if>
	<s:else>
	<li><a href="GoLoginAction">ログイン</a></li>
	</s:else>
</ul>
</div>
<div id="bottom">
	<div id="search">
	<s:form action="SearchItemAction">
	<s:select name="categoryId" class="slct" list="#session.mCategoryDtoList" listKey="categoryId" listValue="categoryName"/>
	<s:textfield name="keywords" class="slct_key" value="%{keywords}" placeholder="検索ワード" size="80%" />
	<s:submit value="商品検索" class="submit_key" />
	</s:form>
	</div>
</div>

</body>
</html>