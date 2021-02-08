<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/login.css">

</head>
<body>
<main>
<!-- 위아래 검은줄 -->
	<div class="blank"></div>
	<div class="blank2"></div>
	<!--  -->
	<section class="logo">
		<img src="images/mainlogo.png">
	</section>	
	<section class="loginbox">
		<h2>로그인</h2>
		<form action="/fom/memberlogin.do" method="post">
			<ul>
				<li><input type="text" placeholder="아이디" title="아이디 입력" name = "member_id"></li>
				<li><input type="password" placeholder="비밀번호" title="비밀번호 입력" name = "password"></li>
				<li><button type="submit">로그인</button></li>
			</ul>
		</form>
			<div id="member">
				<a href="#" onclick="window.open('/fom/membersign.do', 'sign','width=500px, height=500px'); return false">회원가입</a>
				<!-- <a href="/fom/membersign.do">회원가입</a> -->
			</div>
		</section>
		
</main>
<footer>
</footer>
</body>
</html>