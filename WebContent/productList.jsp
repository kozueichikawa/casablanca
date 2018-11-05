<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>productList画面</title>
</head>
<body>
<div id="productList">
        <s:iterator value="productList">
            <tr>
                <td>
                    <a href='<s:url action="ProductDetailAction"/>'><img src='<s:property value="imageFilePath"/>'></a>
                </td>
                <td><s:property value="productName"/></td>
                <td><s:property value="productNameKana"/></td>
                <td><s:property value="price"/><span>円</span></td>
            </tr>
        </s:iterator>
</div>
</body>
</html>