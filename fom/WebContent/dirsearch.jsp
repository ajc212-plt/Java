<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>검색하려는 영화감독의 이름을 검색해주세요</h3>
   <hr>
   <form action="/fom/directorlistsearch.do">
      이름검색 : <input type="text" name="dir_name"> <input type="submit"
         value="검색">
   </form>
</body>
</html>