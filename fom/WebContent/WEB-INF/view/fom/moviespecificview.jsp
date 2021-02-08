<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.util.*,fom.vo.*,  java.util.Map.*,  org.json.simple.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>영화 조회</title>

</head>
<body>
<%
Cookie[] c = request.getCookies();
if (c != null) {
	for (Cookie cf : c) {
		if (cf.getName().equals("member_id")){
			String ids = cf.getValue();
			session.setAttribute("member_id", ids);
		}
		if (cf.getName().equals("password")){
			String pw = cf.getValue();
			session.setAttribute("password", pw);
		}
	}
}
// 세션값 가져오기
String member_id = (String) session.getAttribute("member_id"); // Object 타입이므로 다운캐스팅
String password = (String) session.getAttribute("password");
%>
<a href="/fom/mainsearch.jsp">홈 화면으로 이동</a>



	<c:if test="${empty moviesearch}">
		<h3>영화 정보가 없습니다</h3>
	</c:if>
	<c:if test="${!empty moviesearch}">
		<h3>**영화 정보 리스트**</h3>
		영화제목 : ${moviesearch.name} <br/>
		   개봉일 : ${moviesearch.open_date} <br/>
		   
		   배급사 : ${moviesearch.distribution} <br/>
		   이미지 <br>
		   <img src="${moviesearch.image}" /><br/>
		   감독 : ${moviesearch.director} <br/>
		   장르 : ${moviesearch.genres} <br/>
		   
		   스토리 : ${moviesearch.story} <br/>
		   매출액 : ${moviesearch.gross} <br/>
		   관람객수 : ${moviesearch.viewer} <br/>
		   평론가평점 : ${moviesearch.expert_score} <br/>
		   네티즌평점 : ${moviesearch.netizen_score} <br/>
	<br>
	</c:if>
	<br>
	
	<div>
	위시리스트 추가하기
	<button type="submit" value="추가" onClick="location.href='/fom/wishlistInsert.do?member_id=<%=member_id%>&movie_code=${moviesearch.moviecode}'">추가</button>
	</div>

</body>
</html>