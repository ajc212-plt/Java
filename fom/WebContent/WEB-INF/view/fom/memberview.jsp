<%@page import="fom.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h3>** 검색된 고객의 정보 **</h3><hr/>
 	${vo.member_code} &nbsp;&nbsp;&nbsp;
	${vo.member_id} &nbsp;&nbsp;&nbsp;
	${vo.password} &nbsp;&nbsp;&nbsp;
	${vo.age} &nbsp;&nbsp;&nbsp;
	${vo.gender} &nbsp;&nbsp;&nbsp;
	<a href=></a>
	<br>
 <a href="/fom/index.html">홈 화면으로 이동</a>
 
 <a href="/fom/memberupdate.jsp">회원정보 수정</a>
 <a href="/fom/memberdelete.jsp">회원정보 삭제</a>
 
 
</body>
</html>