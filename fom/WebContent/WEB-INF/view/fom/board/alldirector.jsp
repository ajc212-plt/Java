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
				<a href="mainsearch.jsp"><!-- �ΰ� ������ �˻�â���� �Ѿ -->
					<h1>	
					</h1>
				</a>
				<h2>�˻�â</h2>
				<fieldset>
					<legend class="blind">�˻�</legend>
					<form action="searchresult" method="post"><!--  -->
					<select>
						<option>��ȭ</option>
						<option>���</option>
						<option>����</option>
					</select>
					<input type="text" class="searchtxt" placeholder="Ű���� �˻�">
					<button type="submit">
							<span>�˻�</span>
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