<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.util.*,fom.vo.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>감독 조회</title>

</head>
<body>



	<%-- <%
 List<ActorVO> list=(List<ActorVO>) request.getAttribute("als");
%> --%>
<a href="/fomoriginal/index.html">홈 화면으로 이동</a>

	
	
	<c:if test="${empty dirfilmo}">
		<h3>감독 정보가 없습니다</h3>
	</c:if>
	<c:if test="${!empty dirfilmo}">
		<h3>**감독 필모 리스트**</h3>
		<c:forEach items = "${dirfilmo}" var="ob">
	${ob.dir_code} &nbsp;&nbsp;&nbsp;
	${ob.moviecode} &nbsp;&nbsp;&nbsp;
	${ob.title} &nbsp;&nbsp;&nbsp;
	${ob.open_date} &nbsp;&nbsp;&nbsp;
	${ob.gross} &nbsp;&nbsp;&nbsp;
	${ob.viewer} &nbsp;&nbsp;&nbsp;
	${ob.netizen_score} &nbsp;&nbsp;&nbsp;
	${ob.expert_score} &nbsp;&nbsp;&nbsp;
	</c:forEach>
	
	
	
	
	<br>
	</c:if>
	<br>

	

</body>
</html>