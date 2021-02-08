<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*,fom.vo.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	}
}
// 세션값 가져오기
String member_id = (String) session.getAttribute("member_id"); // Object 타입이므로 다운캐스팅
%>
<h3> 위시리스트 확인 </h3>
<a href="/fom/mainsearch.jsp">홈 화면으로 이동</a>
	<c:if test="${empty wlistsearch}">
			<h3>위시리스트 영화가 없습니다</h3>
	</c:if>
	<c:if test="${!empty wlistsearch}">
	<h3>**위시리스트**</h3>
		<c:forEach items ="${wlistsearch}" var="ob">
			영화제목 : ${ob.name} <br/>
			개봉일 : ${ob.open_date} <br/>
			이미지 <br>
			<img src="${ob.image}" /><br/>
			 네티즌평점 : ${ob.netizen_score} <br/>
		</c:forEach>
	
	</c:if>
<br>


</body>
</html>