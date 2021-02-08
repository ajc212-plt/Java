<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>검색하려는 영화의 코드를 입력해 주세요...</h3>
   <hr>
   <form action="/fom/movieSearch.do">
      CODE : <input type="number" name="moviecode"> <input type="submit" value="검색">
   </form>
</body>
</html>