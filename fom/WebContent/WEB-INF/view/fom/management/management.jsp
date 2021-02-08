<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/fom/css/management.css">
</head>
<body>
	<header>
		<div class="headbox">
			<div class="head">
				<ul>
					<li><a href="login.jsp">Logout</a></li>
				</ul>
			</div>
		</div>
		<div id="searchbox">
			<div id="search">
				<a href="#">
					<h1>	
					<span>Forest of Movie</span>
					</h1>
				</a>
			</div>
		</div>
		<div id="menubox">
			<nav>
				<ul>
					<li class="mainmenu"><a href="/fom/memberall.do">회원관리</a> 
					</li>
					<li class="mainmenu"><a href="/fom/movlistall.do">영화</a>
						
				 	</li>
					<li class="mainmenu"><a href="/fom/actall.do">배우</a>
						
					</li>
					<li class="mainmenu"><a href="/fom/dirlistall.do">감독</a>
						
					</li>	
					<li class="mainmenu"><a href="management_member.jsp">페이지관리</a></li>
				</ul>
			</nav>
		</div>	
	</header>	
	<main>
	<div id="boxconfig">
		<div class="box1">
			<p>Today</p>
			<p class="count">1<!-- 접속자 수 코드 넣어야함. --></p>
		</div>
		<div class="box1">
			<p>Like</p>
			<p class="count">1<!-- 접속자 수 코드 넣어야함. --></p>
		</div>
		<div class="box1">
			<p>wish</p>
			<p class="count">1<!-- 접속자 수 코드 넣어야함. --></p>
		</div>
		<div id="box2">
			<p>그래프</p>
		</div>
	</div>
	</main>
</body>
</html>