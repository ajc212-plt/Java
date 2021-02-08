<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@page import="java.util.*,fom.vo.WishtopVO,fom.vo.LiketopActVO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>조회</title>
</head>
<body>

   <c:if test="${empty realtimewishlist}">
      <h3>정보가 없습니다</h3>
   </c:if>
   <c:if test="${!empty realtimewishlist}">
      <h3>**영화 위시리스트**</h3>
      <c:forEach items="${realtimewishlist}" var="wl">
   ${wl.num} &nbsp;&nbsp;&nbsp;<br>
   ${wl.movie_code} &nbsp;&nbsp;&nbsp;<br>
   ${wl.thumbnail} &nbsp;&nbsp;&nbsp;<br>

      </c:forEach>
   </c:if>
   <br>

   <c:if test="${empty realtimeactlikelist}">
      <h3>정보가 없습니다</h3>
   </c:if>
   <c:if test="${!empty realtimeactlikelist}">
      <h3>**좋아요 배우 리스트**</h3>
      <c:forEach items="${realtimeactlikelist}" var="al">
   ${al.num} &nbsp;&nbsp;&nbsp;<br>
   ${al.actor_code} &nbsp;&nbsp;&nbsp;<br>
   ${al.actor_thumbnail} &nbsp;&nbsp;&nbsp;<br>

      </c:forEach>
   </c:if>

   <br>

   <c:if test="${empty realtimedirlikelist}">
      <h3>정보가 없습니다</h3>
   </c:if>
   <c:if test="${!empty realtimedirlikelist}">
      <h3>**좋아요 감독 리스트**</h3>
      <c:forEach items="${realtimedirlikelist}" var="dl">
   ${dl.num} &nbsp;&nbsp;&nbsp;<br>
   ${dl.dir_code} &nbsp;&nbsp;&nbsp;<br>
   ${dl.dir_thumbnail} &nbsp;&nbsp;&nbsp;<br>

      </c:forEach>
   </c:if>
   <br>

   <c:if test="${empty realtimemlikelist}">
      <h3>정보가 없습니다</h3>
   </c:if>
   <c:if test="${!empty realtimemlikelist}">
      <h3>**좋아요 영화 리스트**</h3>
      <c:forEach items="${realtimemlikelist}" var="ml">
   ${ml.num} &nbsp;&nbsp;&nbsp;<br>
   ${ml.movie_code} &nbsp;&nbsp;&nbsp;<br>
   ${ml.thumbnail} &nbsp;&nbsp;&nbsp;<br>

      </c:forEach>
   </c:if>

</body>
</html>