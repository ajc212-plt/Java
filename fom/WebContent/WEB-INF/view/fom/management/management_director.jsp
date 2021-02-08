<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@page import="java.util.*,fom.vo.ActorVO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>감독 정보 리스트</title>
<link rel="stylesheet" href="/fom/css/management.css">
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
					<li class="mainmenu"><a href="/fom/memberall.do">회원관리</a></li>
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
		<h2>감독 목록</h2>
		<a href="#"
			onclick="window.open('/fom/dirInsertmove.do', 'dirinsertmove','width=900px, height=900px'); return false">등록</a>
		<!-- <a href="/fom/membersign.do">회원가입</a> -->
		<a href="#"
			onclick="window.open('/fom/dupdatemove.do', 'dirupdatemove','width=900px, height=900px'); return false">수정</a>
		<a href="#"
			onclick="window.open('/fom/dirdeletemove.do', 'dirinsertmove','width=900px, height=900px'); return false">삭제</a>
		<!-- <a href="/fom/membersign.do">회원가입</a> -->
		<div>
			<table border="1" width="700px">
				<tr>
					<th>감독코드</th>
					<th>감독이름</th>
					<th>이미지</th>
				</tr>
				<c:forEach items="${dirlistall}" var="row">
					<tr>
						<td><img src="${row.dir_thumbnail}"></td>
						<td>${row.dir_code}</td>
						<!-- 회원정보 상세조회를 위해 a태그 추가 -->
						<td>${row.name}</td>

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