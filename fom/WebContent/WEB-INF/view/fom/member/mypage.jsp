<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*,fom.vo.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/fom/css/mypage.css">
<script src="http://d3js.org/d3.v3.min.js"></script>
<script src="https://kit.fontawesome.com/e13247fad1.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- <style type="text/css">
div.bar {
   display : inline-block;
   width:20px;
   height:75px;
   background-color:teal;
   margin-right: 2px;
}

</style> -->
<style>
	#timebox{
		width:1000px;
		height:480px;
	}
</style>
</head>
<body>
<header>
		<div class="headbox">
			<div class="head">
				<ul>
					<li><a href="/mypage.do">MyPage</a></li>
					<li><a href="login.jsp">Logout</a></li>
				</ul>
			</div>
		</div>
		<div id="searchbox">
			<div id="search">
				<a href="/fom/dmainsearch.do"><!-- 로고를 누르면 검색창으로 넘어감 -->
					<h1>	
					</h1>
				</a>
				<h2>검색창</h2>
				<fieldset>
					<legend class="blind">검색</legend>
					<form action="searchresult" method="post"><!--  -->
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
					<li><a href="#">Movie</a></li>
					<li><a href="#">Actor</a></li>
					<li><a href="#">Diretor</a></li>
				</ul>
			</nav>
		</div>	
	</header>	
	<main>
		<div id="box1">
		<!-- 인물 설명-->
			<div id="imagebox">
				<i class="fas fa-user"></i>
			</div>
			<div id="memberinfo">
				<div id="editbox">
					<form action="/fom/memberUpdate.do">
						회원이름 : <input type="text" name="member_id" value="${sessionScope.user.member_id}"><br><br>
						비밀번호 : <input type="password" class="edittxt" name="password" placeholder="수정할 비밀번호 입력"
						style="position: relative; left: -23px; top: -121px; width: 274px; height: 48px;">
						<button type="submit" value="수정">수정</button>
					</form>
				</div>	
			</div>
			<div> 
			<button type="submit" value="delete" onClick="location.href='/fom/memberDelete.do?member_id=${sessionScope.user.member_id}'">탈퇴하기</button>
			</div>
			
			
		</div>
		<div id="box2">
		<div id="carousel-example-generic" class="carousel slide">
			<ol class="carousel-indicators">
				<li data-target="#carousel-example-generic" data-slide-to="0" value="1page" class="active"></li>
				<li data-target="#carousel-example-generic" data-slide-to="1" value="2page"></li>
			</ol>
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<div class="movieslide">
   						<c:if test="${empty wlistsearch}">
								<h3>위시리스트 영화가 없습니다</h3>
						</c:if>
						<c:if test="${!empty wlistsearch}">
							<c:forEach items ="${wlistsearch}" var="ob" begin="0" end="4">
								<img src="${ob.image}" class="moviepost"/>
							</c:forEach>
						</c:if>
					</div>
				</div>	
				<div class="item">
					<div class="movieslide">
							<c:forEach items ="${wlistsearch}" var="ob" begin="5" end="9">
								<img src="${ob.image}" class="moviepost"/>
							</c:forEach>
					</div>
				</div>
			</div>
			<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			</a>
			<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
				<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			</a>
		</div>
	</div>
	
	<!-- 좋아요 누른 배우 리스트 -->
		<div id="box3">
			<div id="carousel-example-generic1" class="carousel slide">
			<ol class="carousel-indicators">
				<li data-target="#carousel-example-generic1" data-slide-to="0" class="active"></li>
				<li data-target="#carousel-example-generic1" data-slide-to="1"></li>
			</ol>
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<div class="movieslide">
						<c:if test="${empty memberlikeact}">
								<h3>좋아요를 누른 배우가 없습니다</h3>
						</c:if>
						<c:if test="${!empty memberlikeact}">
							<c:forEach items ="${memberlikeact}" var="ob" begin="0" end="4">
								<img src="${ob.actor_thumbnail}" class="moviepost"/>
							</c:forEach>
						</c:if>
					</div>
				</div>	
				<div class="item">
					<div style="width:1000px; height:300px; border:1px solid blue; margin:25px auto" class="text">
						<c:if test="${!empty memberlikeact}">
							<c:forEach items ="${memberlikeact}" var="ob" begin="5" end="9">
								<img src="${ob.actor_thumbnail}" class="moviepost"/>
							</c:forEach>
						</c:if>
					</div>
				</div>
			</div>
			<a class="left carousel-control" href="#carousel-example-generic1" role="button" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			</a>
			<a class="right carousel-control" href="#carousel-example-generic1" role="button" data-slide="next">
				<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			</a>
		</div>
		</div>
		<!-- 좋아요 누른 감독 -->
		<div id="box4">
			<div id="carousel-example-generic2" class="carousel slide">
			<ol class="carousel-indicators">
				<li data-target="#carousel-example-generic2" data-slide-to="0" class="active"></li>
				<li data-target="#carousel-example-generic2" data-slide-to="1"></li>
			</ol>
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<div style="width:1000px; height:300px; border:1px solid red; margin:25px auto" class="text">
						<c:if test="${empty memberlikedir}">
								<h3>좋아요를 누른 감독이 없습니다</h3>
						</c:if>
						<c:if test="${!empty memberlikedir}">
							<c:forEach items ="${memberlikedir}" var="ob" begin="0" end="4">
								<img src="${ob.dir_thumbnail}" class="moviepost"/>
							</c:forEach>
						</c:if>	
					</div>
				</div>	
				<div class="item">
					<div style="width:1000px; height:300px; border:1px solid blue; margin:25px auto" class="text">
						<c:forEach items ="${memberlikedir}" var="ob" begin="5" end="9">
								<img src="${ob.dir_thumbnail}" class="moviepost"/>
							</c:forEach>
					</div>
				</div>
			</div>
			<a class="left carousel-control" href="#carousel-example-generic2" role="button" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			</a>
			<a class="right carousel-control" href="#carousel-example-generic2" role="button" data-slide="next">
				<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			</a>
		</div>
		</div>
		<!-- 좋아요 누른 영화들 -->
		<div id="box5">
			<div id="carousel-example-generic3" class="carousel slide">
			<ol class="carousel-indicators">
				<li data-target="#carousel-example-generic3" data-slide-to="0" class="active"></li>
				<li data-target="#carousel-example-generic3" data-slide-to="1"></li>
			</ol>
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<div style="width:1000px; height:300px; border:1px solid red; margin:25px auto" class="text">
						<c:if test="${empty memberlikemovie}">
								<h3>좋아요를 누른 영화가 없습니다</h3>
						</c:if>
						<c:if test="${!empty memberlikemovie}">
							<c:forEach items ="${memberlikemovie}" var="ob" begin="0" end="4">
								<img src="${ob.image}" class="moviepost"/>
							</c:forEach>
						</c:if>
					</div>
				</div>	
				<div class="item">
					<div style="width:1000px; height:300px; border:1px solid blue; margin:25px auto" class="text">
						<c:forEach items ="${memberlikemovie}" var="ob" begin="5" end="9">
								<img src="${ob.image}" class="moviepost"/>
							</c:forEach>
					</div>
				</div>
			</div>
			<a class="left carousel-control" href="#carousel-example-generic3" role="button" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			</a>
			<a class="right carousel-control" href="#carousel-example-generic3" role="button" data-slide="next">
				<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			</a>
		</div>
		</div>
		<script>
	$(function(){
		// 이미지 슬라이드 컨트롤를 사용하기 위해서는 carousel를 실행해야한다.
		$('#carousel-example-generic').carousel({
		// 슬리아딩 자동 순환 지연 시간
		// false면 자동 순환하지 않는다.
		interval: 2000,
		// hover를 설정하면 마우스를 가져대면 자동 순환이 멈춘다.
		pause: "hover",
		// 순환 설정, true면 1 -> 2가면 다시 1로 돌아가서 반복
		wrap: true,
		// 키보드 이벤트 설정 여부(?)
		keyboard : true
		});
		});
	
	$(function(){
		// 이미지 슬라이드 컨트롤를 사용하기 위해서는 carousel를 실행해야한다.
		$('#carousel-example-generic1').carousel({
		// 슬리아딩 자동 순환 지연 시간
		// false면 자동 순환하지 않는다.
		interval: 2000,
		// hover를 설정하면 마우스를 가져대면 자동 순환이 멈춘다.
		pause: "hover",
		// 순환 설정, true면 1 -> 2가면 다시 1로 돌아가서 반복
		wrap: true,
		// 키보드 이벤트 설정 여부(?)
		keyboard : true
		});
		});
	
	$(function(){
		// 이미지 슬라이드 컨트롤를 사용하기 위해서는 carousel를 실행해야한다.
		$('#carousel-example-generic2').carousel({
		// 슬리아딩 자동 순환 지연 시간
		// false면 자동 순환하지 않는다.
		interval: 2000,
		// hover를 설정하면 마우스를 가져대면 자동 순환이 멈춘다.
		pause: "hover",
		// 순환 설정, true면 1 -> 2가면 다시 1로 돌아가서 반복
		wrap: true,
		// 키보드 이벤트 설정 여부(?)
		keyboard : true
		});
		});
	
	$(function(){
		// 이미지 슬라이드 컨트롤를 사용하기 위해서는 carousel를 실행해야한다.
		$('#carousel-example-generic3').carousel({
		// 슬리아딩 자동 순환 지연 시간
		// false면 자동 순환하지 않는다.
		interval: 2000,
		// hover를 설정하면 마우스를 가져대면 자동 순환이 멈춘다.
		pause: "hover",
		// 순환 설정, true면 1 -> 2가면 다시 1로 돌아가서 반복
		wrap: true,
		// 키보드 이벤트 설정 여부(?)
		keyboard : true
		});
		});
	</script>
	</main>
	<footer>
	</footer>
</body>
</html>