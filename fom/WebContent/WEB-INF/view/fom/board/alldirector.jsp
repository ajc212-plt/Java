<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="alldirector.css">
</head>
<body>
<body>
	<header>
		<div class="headbox">
			<div class="head">
				<ul>
					<li><a href="/fom/wishlistSearch.do?member_id=${sessionScope.user.member_id}">MyPage</a></li>
					<li><a href="login.jsp">Logout</a></li>
				</ul>
			</div>
		</div>
		<div id="searchbox">
			<div id="search">
				<a href="mainsearch.jsp"><!-- 로고를 누르면 검색창으로 넘어감 -->
					<h1>	
					</h1>
				</a>
				<h2>검색창</h2>
				<fieldset>
					<legend class="blind">검색</legend>
					<form action="searchresult" method="post"><!--  -->
					<select>
						<option>영화</option>
						<option>배우</option>
						<option>감독</option>
					</select>
					<input type="text" class="searchtxt" placeholder="키워드 검색">
					<button type="submit">
							<span>검색</span>
					</button>
					</form>	
				</fieldset>
			</div>
		</div>
		<div id="menubox">
			<nav>
				<ul>
					<li><a href="allmovie.jsp">MOVIE</a></li>
					<li><a href="allactor.jsp">ACTOR</a></li>
					<li><a href="alldirector.jsp">DIRECTOR</a></li>
				</ul>
			</nav>
		</div>	
	</header>
	<main>
		<div class="list">
			<div class="listimage">
				<img src="#">
				<img src="#">
				<img src="#">
				<img src="#">
				<img src="#">
			</div>
		</div>
	</main>

</body>
</html>