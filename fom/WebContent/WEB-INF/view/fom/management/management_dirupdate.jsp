<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.*,fom.vo.MovieVO2"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>수정하려는 감독의 코드를 입력해주세요</h3>
   <hr>
   <form action="/fom/directorUpdateSearch.do" >
      코드검색 : <input type="number" name="dir_code"> 
      <input type="submit" value="검색">
   </form>
</body>
</html>