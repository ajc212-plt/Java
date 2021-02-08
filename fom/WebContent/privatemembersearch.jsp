<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>검색하려는 회원의 코드를 입력해주세요</h3>
   <hr>
   <form action="/fom/privatemembersearch.do">
      코드검색 : <input type="number" name="member_code"> <input type="submit"
         value="검색">
   </form>
</body>
</html>