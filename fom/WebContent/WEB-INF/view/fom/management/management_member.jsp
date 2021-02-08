<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*,fom.vo.ActorVO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/fom/css/management_member.css">
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
				<a href="mainsearch.jsp">
					<h1>	
					
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
	<div id="boxconfig">
		<div class="box1">
			<p>회원 현황</p>
			<table>
			<tr>
				<td class="edit1">회원번호</td>
				<td class="edit2">아이디</td>
				<td class="edit1">나이</td>
				<td class="edit2">성별</td>
                <td class="edit1">삭제</td>
			</tr>
			<c:forEach items="${memberall}" var="row">
			<tr>
				<td class="edit1">${row.member_code}</td>
				<td class="edit2">${row.member_id}</td>		
				<%-- <td>${row.password}</td> --%>
				<td class="edit1">${row.age}</td>
				<td class="edit2">${row.gender}</td>
                <td class="edit1"><button type="button"><a href="#">삭제</a></button></td>
			</tr>
			</c:forEach>
			</table>
		</div>
		<div class="box2">
		
		</div>
	</div>
	</main>
</body>
</html>