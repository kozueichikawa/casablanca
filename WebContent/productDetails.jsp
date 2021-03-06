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
<title>商品詳細</title>
</head>
<body>
<s:include value="header.jsp" />
<div id="contents">
    <h1>商品詳細画面</h1>
<div id="productDetails">
    <s:form action="AddCartAction">
    <div class="detailBox">
    <div class="image">
        <img src='<s:property value="productInfoDTO.imageFilePath"/>/<s:property value="productInfoDTO.imageFileName"/>'width="320px" height="320px"/>
    </div>
    <div class="detailInfo">
        <table border="1">
            <tr>
                <th>商品名</th>
                <td><s:property value="productInfoDTO.productName"/></td>
            </tr>
            <tr>
                <th>商品名かな</th>
                <td><s:property value="productInfoDTO.productNameKana"/></td>
            </tr>
            <tr>
                <th>値段</th>
                <td><s:property value="productInfoDTO.price"/></td>
            </tr>
            <tr>
                <th>購入個数</th>
                <td>
                    <select name="productCount">
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
                <td><s:property value="productInfoDTO.releaseCompany"/></td>
            </tr>
            <tr>
                <th>発売年月日</th>
                <td><s:property value="productInfoDTO.releaseDate"/></td>
            </tr>
            <tr>
                <th>商品詳細情報</th>
                <td><s:property value="productInfoDTO.productDescription"/></td>
            </tr>
        </table>
    </div>
    </div>
    <div id="addCart">
        <s:hidden name="productId" value="%{productInfoDTO.productId}"/>
        <s:hidden name="imageFilePath" value="%{productInfoDTO.imageFilePath}"/>
        <s:hidden name="imageFileName" value="%{productInfoDTO.imageFileName}"/>
        <s:hidden name="productName" value="%{productInfoDTO.productName}"/>
        <s:hidden name="productNameKana" value="%{productInfoDTO.productNameKana}"/>
        <s:hidden name="price" value="%{productInfoDTO.price}"/>
        <s:hidden name="releaseCompany" value="%{productInfoDTO.releaseCompany}"/>
        <s:hidden name="releaseDate" value="%{productInfoDTO.releaseDate}"/>
        <s:hidden name="productDescription" value="%{productInfoDTO.productDescription}"/>
        <s:submit value="カートに追加"/>
    </div>
    </s:form>
</div>
<div class="recommend">
    <s:iterator value="productInfoDTOList">
        <div id="recommend-item">
            <a href='<s:url action="ProductDetailsAction">
                        <s:param name="productId" value="%{productId}"/></s:url>'>
                        <img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>'width="100px" height="100px"/></a>
            <s:property value="productName"/>
        </div>
    </s:iterator>
</div>
</div>
<s:include value="footer.jsp"/>
</html>