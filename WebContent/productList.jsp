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
<%--<jsp:include page="header.jsp" /> --%>

<s:if test='<s:property value="productInfoDTOList=null"/>'>
    <div id="SearchResult">
      <h3>検索結果はありません</h3>
    </div>
</s:if>

<s:elseif test='<s:property value="keywordsErrorMessageList!=null"/>'>
     <h3>検索結果はありません。</h3>
     <h3><s:property value="productInfoDTOList"/></h3>
</s:elseif>

<s:else>
<div id="productList">
        <s:iterator value="productList">
            <tr>
                <td>
                    <a href='<s:url action="ProductDetailAction"/>'>
                        <s:param name="productId" value="%{productId}">
                            <img src='<s:property value="imageFilePath"/>'>
                        </s:param>
                    </a>
                </td>
                <td><s:property value="productName"/></td>
                <td><s:property value="productNameKana"/></td>
                <td><s:property value="price"/><span>円</span></td>
            </tr>
        </s:iterator>
</div>
</s:else>
<%--<s:include value="footer.jsp"/>  --%>
</body>
</html>