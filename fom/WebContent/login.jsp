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
<!-- ���Ʒ� ������ -->
	<div class="blank"></div>
	<div class="blank2"></div>
	<!--  -->
	<section class="logo">
		<img src="images/mainlogo.png">
	</section>	
	<section class="loginbox">
		<h2>�α���</h2>
		<form action="/fom/memberlogin.do" method="post">
			<ul>
				<li><input type="text" placeholder="���̵�" title="���̵� �Է�" name = "member_id"></li>
				<li><input type="password" placeholder="��й�ȣ" title="��й�ȣ �Է�" name = "password"></li>
				<li><button type="submit">�α���</button></li>
			</ul>
		</form>
			<div id="member">
				<a href="#" onclick="window.open('/fom/membersign.do', 'sign','width=500px, height=500px'); return false">ȸ������</a>
				<!-- <a href="/fom/membersign.do">ȸ������</a> -->
			</div>
		</section>
		
</main>
<footer>
</footer>
</body>
</html>