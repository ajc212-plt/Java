<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@page import="java.util.*,fom.vo.ActorVO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>영화 정보 리스트</title>
<link rel="stylesheet" href="/fom/css/management_movie.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<style>
p {
	margin: 20px 0px;
}
</style>
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
					<li class="mainmenu"><a href="/fom/movlistall.do">영화</a></li>
					<li class="mainmenu"><a href="/fom/actall.do">배우</a></li>
					<li class="mainmenu"><a href="/fom/dirlistall.do">감독</a></li>
					<li class="mainmenu"><a href="management_member.jsp">페이지관리</a></li>
				</ul>
			</nav>
		</div>
	</header>
	<main>

		<!-- <div class="container">
			<div class="row">
				<div class="col">
					<p><strong>Pagination</strong></p>
					<ul class="pagination">
						<li class="page-item">
						<a class="page-link" href="#">Previous</a>
						</li>
						<li class="page-item"><a class="page-link" href="#">1</a></li>
						<li class="page-item"><a class="page-link" href="#">2</a></li>
						<li class="page-item"><a class="page-link" href="#">3</a></li>
						<li class="page-item"><a class="page-link" href="#">4</a></li>
						<li class="page-item"><a class="page-link" href="#">5</a></li>
						<li class="page-item"><a class="page-link" href="#">Next</a></li>
					</ul>
				</div>
			</div>
		</div>
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script> -->
		
		
			<div id="movietable">
			<h2 style="padding-left: 20px; border-left:3px solid #fff;">영화 목록</h2>
		<a href="#"
			onclick="window.open('/fom/mInsertmove.do', 'minsertmove','width=1200px, height=1200px'); return false">등록</a>
		<!-- <a href="/fom/membersign.do">회원가입</a> -->
		
		<a href="#"
			onclick="window.open('/fom/mupdatemove.do', 'mupdatemove','width=1200px, height=1200px'); return false">수정</a>
		
		<a href="#"
			onclick="window.open('/fom/mdeletemove.do', 'mdeletemove','width=1200px, height=1200px'); return false">삭제</a>
		<!-- <a href="/fom/membersign.do">회원가입</a> -->
				<table border="1" width="1080px">
					<tr>
						<th>영화이름</th>
						<th>개봉일</th>
						<th>매출액</th>
						<th>관람객수</th>
						<th>나라</th>
						<th>배급사</th>
						<th>영화코드</th>
						<th>이미지</th>
						<th>제작년도</th>
						<th>감독</th>
						<th>장르</th>
						<th>평론가평점</th>
						<th>네티즌평점</th>
					</tr>
					<tr>
						<th colspan="14">스토리</th>
					</tr>
					<c:forEach items="${movlistall}" var="row">
						<tr>
						<td><img src="${row.image}"></td>
							<td>${row.name}</td>
							<!-- 회원정보 상세조회를 위해 a태그 추가 -->
							<td>${row.open_date}</td>
							<td>${row.gross}</td>
							<td>${row.viewer}</td>
							<td>${row.country}</td>
							<td>${row.distribution}</td>
							<td>${row.moviecode}</td>
							
							<td>${row.py}</td>
							<td>${row.director}</td>
							<td>${row.genres}</td>
							<td>${row.expert_score}</td>
							<td>${row.netizen_score}</td>
						</tr>
						<tr>
							<td colspan="14">${row.story}</td>
						</tr>
					</c:forEach>
				</table>
	
				<%-- <td><a href="${path}/member/view.do?userId=${row.userId}">${row.userName}</a></td> --%>
	
			</div>
		
		<%-- <div>
			<c:if test="${empty actall}">
				<h3>배우 정보가 없습니다</h3>
			</c:if>
			<c:if test="${!empty actall}">
				<h3>**배우 정보 리스트**</h3>
				<c:forEach items="${actall}" var="ob">
	${ob.actor_code} &nbsp;&nbsp;&nbsp;<br>
   ${ob.name} &nbsp;&nbsp;&nbsp;<br>
   ${ob.actor_thumbnail} &nbsp;&nbsp;&nbsp;<br>
					<br />
				</c:forEach>
			</c:if>
			<br>
		</div> --%>
	</main>
</body>
</html>