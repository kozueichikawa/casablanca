<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>productDetails画面</title>
</head>
<body>
<%--<jsp:include page="header.jsp" /> --%>
<div id="productDetails">
    <s:form action="AddCartAction">
    <img src="./WEB-INF/images/sample.jpg"/>
    <table border="1">
        <tr>
            <th>商品名</th>
            <td><s:property value="session.productName"/></td>
        </tr>
        <tr>
            <th>商品名かな</th>
            <td><s:property value="session.productNameKana"/></td>
        </tr>
        <tr>
            <th>値段</th>
            <td><s:property value="session.price"/></td>
        </tr>
        <tr>
            <th>購入個数</th>
            <td>
                <select name="ProductCount">
                   <option value="1" selected="selected">1</option>
                   <option value="2">2</option>
                   <option value="3">3</option>
                   <option value="4">4</option>
                   <option value="5">5</option>
               </select>
           </td>
        </tr>
        <tr>
            <th>発売会社名</th>
            <td><s:property value="session.releaseCompany"/></td>
        </tr>
        <tr>
            <th>発売年月日</th>
            <td><s:property value="session.releaseDate"/></td>
        </tr>
        <tr>
            <th>商品詳細情報</th>
            <td><s:property value="session.productDescription"/></td>
        </tr>
    </table>
    <div id="addCart">
        <s:submit value="カートに追加"/>
    </div>
    </s:form>
</div>
<div id="sameCategory">
    <s:iterator value="productInfoDTOList">
        <div id="recommend-item">
            <a href='<s:url action="ProductDetailAction"/>'>
                <s:param name="productId" value="%{productId}">
                    <img src='<s:property value="imageFilePath"/>'>
                </s:param>
            </a>
            <s:property value="productName"/>
        </div>
    </s:iterator>
</div>

<%--<s:include value="footer.jsp"/>  --%>
</body>
</html>