<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import ="fom.vo.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="font-size: 2.0em; margin: 150px 150px 150px 150px;">
<c:if test="${empty list}">
	<h3>고객 정보가 없습니다</h3>
</c:if>
<c:if test="${!empty list}">
	<h3>**고객 정보 리스트**</h3><hr>
	<c:forEach items="${list}" var="list">
	${list.title}<br>
	${list.open_date}<br>
	${list.gross}<br>
	${list.viewer}<br>
	${list.country}<br>
	${list.distribution}<br>
	${list.link}<br>
	${list.moviecode}<br>
	${list.image}<br>
	${list.py}<br>
	${list.director}<br>
	${list.genres}<br>
	${list.expert_score}<br>
	${list.netizen_score}<br>
	</c:forEach>
</c:if><br/>
<a href="/fomoriginal/index.html">홈 화면으로 이동</a>
</body>
</html>