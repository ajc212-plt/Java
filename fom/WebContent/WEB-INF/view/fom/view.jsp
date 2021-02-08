<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>** 검색된 영화의 정보**</h3><hr>
제목:${moviecode.title}<br>
개봉일자:${moviecode.open_date}<br>
매출액:${moviecode.gross}<br>
관객수:${moviecode.viewer}<br>
국가:${moviecode.country}<br>
배급사:${moviecode.distribution}<br>
링크:${moviecode.link}<br>
영화코드:${moviecode.moviecode}<br>
이미지:${moviecode.image}<br>
제작년도:${moviecode.py}<br>
감독:${moviecode.director}<br>
장르:${moviecode.genres}<br>
전문가평점:${moviecode.expert_score}<br>
네티즌평점:${moviecode.netizen_score}<br>

<a href="/fom/index.html">홈 화면으로 이동</a>
</body>
</html>