<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
@import url("/fom/css/mainsearch.css");
</style>
</head>
<body>
	<div align="center">
		 ${sessionScope.user.member_id}님이 로그인하였습니다.<br />
	</div>
	
	<div class="blank"></div>
	<div class="blank2"></div>
	<div id="logo">
		<img src="/fom/images/minilogo.png">
	</div>
	<div id="searchbox">
		<div id="search">
			<fieldset>
				<legend class="blind">검색</legend>
				<form action="/fom/actorlistsearch.do">
					<input type="text" class = "searchtxt" name="name">
					<button type="submit">
						<span>검색</span>
					</button>
				</form>
			</fieldset>
		</div>
	</div>
</body>
</html>