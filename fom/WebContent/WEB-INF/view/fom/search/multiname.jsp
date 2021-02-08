<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
       <%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
@import url("/fom/css/multiname.css");
</style>
</head>
<body>
<body>


	<header>
		<div class="headbox">
			<div class="head">
				<ul>
					<li><button type="submit" value="위시리스트확인" onClick="location.href='/fom/wishlistSearch.do?member_id=${sessionScope.user.member_id}'">MyPage</button></li>
					<li><a href="login.jsp">Logout</a></li>
				</ul>
			</div>
		</div>
		<div id="searchbox">
			<div id="search">
				<a href="search.jsp"><!-- 로고를 누르면 검색창으로 넘어감 -->
					<h1>	
					<span>Forest of Movie</span>
					</h1>
				</a>
				<h2>검색창</h2>
				<fieldset>
					<legend class="blind">검색</legend>
					<form action="/fom/actorlistsearch.do">
					<input type="text" class = "searchtxt"  name="name">
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
					<li><a href="#">Movie</a></li>
					<li><a href="#">Actor</a></li>
					<li><a href="#">Diretor</a></li>
					<li><a href="#">Genre</a></li>
				</ul>
			</nav>
		</div>	
	</header>
	<main>
	<div id="boxconfig">
		
			<c:if test="${empty actlist}">
				<h3>배우  정보가 없습니다</h3>
			</c:if>
			<c:if test = "${!empty actlist}">
				<c:forEach items = "${actlist}" var="ob">
				<div class="box1">
					<a href="<c:url value="/actorSpecificsearch.do" >              
				  		<c:param name="actor_code" value="${ob.actor_code}"></c:param>
				  		</c:url>"><img src="${ob.actor_thumbnail}"> <p>${ob.name}</p></a>
					 &nbsp;&nbsp;&nbsp;
				</div>
				</c:forEach>
			</c:if><br>
			<c:if test="${empty dirlist}">
					<h3>감독 정보가 없습니다</h3>
					</c:if>
					<c:if test = "${!empty dirlist}">
					<c:forEach items = "${dirlist}" var="ob">
					<div class="box1">
					<a href="<c:url value="/directorSpecificsearch.do" >              
				  		<c:param name="dir_code" value="${ob.dir_code}"></c:param>
				  		</c:url>"><img src="${ob.dir_thumbnail}"><p>${ob.name}</p></a>
					 <br/>
					 </div>
					</c:forEach>
				</c:if><br>
					
				   <c:if test="${empty movielist}">
					<h3>영화 정보가 없습니다</h3>
					</c:if>
					<c:if test = "${!empty movielist}">
					<c:forEach items = "${movielist}" var="ob">
					<div class="box1">
					<a href="<c:url value="/movieSpecificsearch.do" >              
				  		<c:param name="moviecode" value="${ob.moviecode}"></c:param>
				  		</c:url>"><img src="${ob.image}"><p>${ob.name}</p></a>
					</div>
					</c:forEach>
				</c:if><br>		
	</div>
	</main>
	
					
					
					
</body>
</html>