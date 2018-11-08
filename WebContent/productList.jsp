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
<link rel="stylesheet" href="./css/style.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<title>商品一覧</title>
<script type="text/javascript">
function loop(){
for(var a = 1; a <=10 ; a++){
	for(var b = 1; b <= 3; b++){
	document.write($('productList'));
	}
	document.write("<br>");
	}}
</script>
</head>
<body>
<s:include value="header.jsp" />
<div id="contents">
    <h1>商品一覧画面</h1>
        <s:if test='<s:property value="productInfoDtoList=null"/>'>
        <div id="SearchResult">
            <h3>検索結果はありません</h3>
        </div>
        </s:if>

        <s:elseif test='<s:property value="keywordsErrorMessageList!=null"/>'>
            <h3>検索結果はありません。</h3>
            <h3><s:property value="keywordsErrorMessageList"/></h3>
        </s:elseif>

<s:else>
<div id="productList">
        <s:iterator value="productInfoDtoList">
            <tr>
                <td>
                    <a href='<s:url action="ProductDetailsAction">
                        <s:param name="productId" value="%{productId}"/></s:url>'>
                            <img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' width="50px" height="50px"/>
                    </a>
                </td>
                <td><s:property value="productName"/></td>
                <td><s:property value="productNameKana"/></td>
                <td><s:property value="price"/><span>円</span></td>
            </tr>
        </s:iterator>
</div>
</s:else>
</div>
<s:include value="footer.jsp"/>
</body>
</html>