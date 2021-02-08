<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import = "java.util.*,fom.vo.DirectorVO" %>
    <%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>감독 조회</title>
</head>
<body>



<c:if test="${empty dirlist}">
	<h3>감독 정보가 없습니다</h3>
	</c:if>
	<c:if test = "${!empty dirlist}">
	<h3>**감독 정보 리스트**</h3>
	<c:forEach items = "${dirlist}" var="ob">
	<a href="<c:url value="/directorSpecificsearch.do" >               <-- 요기!!!!!-->
  		<c:param name="dir_code" value="${ob.dir_code}"></c:param>
  		</c:url>"> ${ob.dir_name} &nbsp;&nbsp;&nbsp; </a>
	 &nbsp;&nbsp;&nbsp;
	 <br/>
	</c:forEach>
</c:if><br>

<a href="/fom/index.html">홈 화면으로 이동</a>


</body>
</html>