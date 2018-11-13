<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="Content-Style-Type" content="text/css"/>
<meta http-equiv="Content-Script-Type" content="text/javascript"/>
<meta http-equiv="imagetoolbar" content="no"/>
<meta name="description" content=""/>
<meta name="keywords" content=""/>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<title>商品一覧</title>
</head>

<body>
<s:include value="header.jsp" />
<div id="contents">
    <h1>商品一覧画面</h1>

<s:if test="productInfoDtoList==null">
    <div id="NoResult">
        <h3>検索結果はありません</h3>
    </div>

    <s:if test="keywordsErrorMessageList!=null">
        <div id="ErrorMessage">
        <s:iterator value="keywordsErrorMessageList">
            <h3><s:property/></h3>
        </s:iterator>
        </div>
    </s:if>

</s:if>

<s:if test="productInfoDtoList!=null">
<div id="productList">
    <s:iterator value="productInfoDtoList">
    <div id="productBox">
        <a href='<s:url action="ProductDetailsAction">
                 <s:param name="productId" value="%{productId}"/></s:url>'>
                 <img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' width="200px" height="200px"/></a>
        <br>
        <s:property value="productName"/>
        <br>
        <s:property value="productNameKana"/>
        <br>
        <s:property value="price"/><span>円</span>
    </div>
    </s:iterator>
</div>
</s:if>
</div>
<s:include value="footer.jsp"/>
</body>
</html>