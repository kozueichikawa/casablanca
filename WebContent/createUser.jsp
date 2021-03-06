<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-text-Type" content="text/css; charset=UTF-8">
<meta http-equiv="Content-Script-Type" content="text.javascript; charset=UTF-8">
<meta name="description" content="" />
<meta name="keywords" content="" />
<title>createUser.jsp</title>

<style type="text/css">


	.user-jouhou{
		width:70%;
		background-color:lightgray;
		border-radius:50px;
		}
	.midasi{
		text-align:center;
		}
	.submit_btn{
		width:60%;
		border-radius:50px;
		background: darkblue;
		color:white;
		height:50px;
		border:none;
		}
	.submit_btn_box{
		text-align:center;
		}
	.txt{
		border-radius:50px;
		width:80%;
		height:30px;;
		}
	.hissu{
		color:white;
		background:red;
		border-radius:50px;
		}




		</style>
</head>
<body>
<%-- エラーメッセージ表示部分 --%>

<s:if test="!familyNameErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="familyNameErrorMessageList">
			<s:property /><br>
		</s:iterator>
	</div>
	</div>
</s:if>
<s:if test="!firstNameErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
	<s:iterator value="firstNameErrorMessageList">
		<s:property /><br>
	</s:iterator>
	</div>
	</div>
</s:if>
<s:if test="!familyNameKanaErrorMessageList.isEmpty()">
	<div class="error">	<div class="error-message">
	<s:iterator value="familyNameKanaErrorMessageList">
		<s:property /><br>
	</s:iterator>
	</div>
	</div>
</s:if>
<s:if test="!firstNameKanaErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
	<s:iterator value="firstNameKanaErrorMessageList">
		<s:property /><br>
	</s:iterator>
	</div>
	</div>
</s:if>
<s:if test="!emailErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
	<s:iterator value="emailErrorMessageList">
		<s:property /><br>
	</s:iterator>
	</div>
	</div>
</s:if>
<s:if test="!loginErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
	<s:iterator value="loginErrorMessageList">
		<s:property /><br>
	</s:iterator>
	</div>
	</div>
</s:if>
<s:if test="!passwordErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
	<s:iterator value="passwordErrorMessageList">
		<s:property /><br>
	</s:iterator>
	</div>
	</div>
</s:if>

<%-- エラーメッセージここまで --%>

<s:form action="CreateUserConfirmAction">
<div class = "user-jouhou">
		<div class = "midasi">姓<span class = "hissu">必須</span><br>
		<s:textfield name="familyName" value="%{familyName}" label="姓" placeholder=" 姓" class="txt" />
		</div>



		<div class = "midasi">名<span class = "hissu">必須</span><br>
		<s:textfield name="firstName" value="%{firstName}" label="名" placeholder=" 名" class="txt" />
		</div>


		<div class = "midasi">姓かな<span class = "hissu">必須</span><br>
		<s:textfield name="familyNameKana" value="%{familyNameKana}" label="姓ふりがな" placeholder=" 姓ふりがな" class="txt" />
		</div>


		<div class = "midasi">名かな<span class = "hissu">必須</span><br>
		<s:textfield name="firstNameKana" value="%{firstNameKana}" label="名ふりがな" placeholder=" 名ふりがな" class="txt" />
		</div>

		<div class = "midasi">性別<span class = "hissu">必須</span><br>
			<label>男性<input type="radio" value="0" checked="checked" name="sex"/></label>
			<label>女性<input type="radio" value="1" name="sex"/></label>
		</div>

		<div class = "midasi">メールアドレス<span class = "hissu">必須</span><br>
		<s:textfield name="email" value="%{email}" label="メールアドレス" placeholder=" メールアドレス" class="txt" />
		</div>


		<div class = "midasi">ログインID<span class = "hissu">必須</span><br>
		<s:textfield name="loginId" value="%{loginId}" label="ログインID" placeholder=" ログインID" class="txt" />
		</div>

		<div class = "midasi">パスワード<span class = "hissu">必須</span><br>
		<s:password name="password" value="" label="パスワード" class="txt" placeholder=" パスワード" />
		</div>

		<div class="submit_btn_box">
		<div id=".contents-btn-set">
		<s:submit value="登録" class="submit_btn" />
		</div>
		</div>
</div>

</s:form>


</body>
</html>