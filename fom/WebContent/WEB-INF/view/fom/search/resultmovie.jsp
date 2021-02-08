<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*,fom.vo.*, fom.biz.*, java.util.Map.*, org.json.simple.*"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/fom/css/resultmovie.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.css"/>
<script src="https://kit.fontawesome.com/e13247fad1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.bundle.js"></script>
</head>
<body>
<%
Cookie[] c = request.getCookies();
if (c != null) {
	for (Cookie cf : c) {
		if (cf.getName().equals("member_id")){
			String ids = cf.getValue();
			session.setAttribute("member_id", ids);
		}
	}
}
// 세션값 가져오기
String member_id = (String) session.getAttribute("member_id"); // Object 타입이므로 다운캐스팅
%>
	<header>
		<div class="headbox">
			<div class="head">
				<ul>
					<li><a href="/fom/wishlistSearch.do?member_id=${sessionScope.user.member_id}">MyPage</a></li>
					<li><a href="login.jsp">Logout</a></li>
				</ul>
			</div>
		</div>
		<div id="searchbox">
			<div id="search">
				<a href="mainsearch.jsp">
					<h1>	
					<span>Forest of Movie</span>
					</h1>
				</a>
				<h2>검색창</h2>
				<fieldset>
					<legend class="blind">검색</legend>
					<form action="/fom/actorlistsearch.do">
					<input type="text" class="searchtxt" name="name"placeholder="키워드 검색">
						<button type="submit">
							<span>검색</span>
						</button>
					</form>	
				</fieldset>
			</div>
		</div>
		<div id="menubox">
			<nav>
				<ul>
					<li><a href="#">Movie</a></li>
					<li><a href="#">Actor</a></li>
					<li><a href="#">Diretor</a></li>
					<li><a href="#">Genre</a></li>
				</ul>
			</nav>
		</div>	
	</header>	
	<c:if test="${empty moviesearch}">
      		<h3>영화 정보가 없습니다</h3>
   		</c:if>
	<main>
		<c:if test="${!empty moviesearch}">
		<div id="box1">
		
			<div class="clearfix">
				<p>영화</p>
				<div id="image">
					<img src="${moviesearch.image}">
					<div class="container">
						<i onclick="Toggle()" id="btn" class="far fa-heart"></i>
					</div>
					<script>
						var btn = document.getElementById('btn');
						
						function Toggle(){
							if(btn.classList.contains("far")){
								btn.classList.remove("far");
								btn.classList.add("fas");
								location.href = "/fom/m_movieInsert.do?member_id=<%=member_id%>&movie_code=${moviesearch.moviecode}";
							}else{
								btn.classList.remove("fas");
								btn.classList.add("far");
							}
						}	
					</script>
					<div class="container1">
						<i onclick="Toggle1()" id="btn1" class="far fa-star"></i>
					</div>
	<script>
		var btn1 = document.getElementById('btn1');
		
		function Toggle1(){
			if(btn1.classList.contains("far")){
				btn1.classList.remove("far");
				btn1.classList.add("fas");
				location.href = "/fom/wishlistInsert.do?member_id=<%=member_id%>&movie_code=${moviesearch.moviecode}";

			}else{
				btn1.classList.remove("fas");
				btn1.classList.add("far");
			}
		}	
	</script>
	
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script>
	    $(function(){
	        var responseMessage = "<c:out value="${message}" />";
	        if(responseMessage != ""){
	            alert(responseMessage)
	        }
	    }) 
	</script>
	

					
				</div>
				<div class="desc">
					<div id="title">
						<p>${moviesearch.name}</p>
					</div>
					<hr>
					<div id="viewscore">
						<p>네티즌평점:${moviesearch.netizen_score}</p>
					</div>
					<div id="expertscore">
						<p>전문가평점:${moviesearch.expert_score}</p>
					</div>
					<br>
					<hr>
					<div id="genre">
						<p>장르:${moviesearch.genres}</p>
					</div>
					<div id="country">
						<p>한국</p>
					</div>
					<div id="opendate">
						<p>${moviesearch.open_date}개봉</p>
					</div>
					<div id="director">
						<p>감독:${moviesearch.director}</p>
					</div>
					<div id="distribution">	
						<p>배급사:${moviesearch.distribution}</p>
					</div>
					<div id="viewer">
						<p>누적관객:${moviesearch.viewer}명</p>
					</div>
					<div id="gross">	
						<p>매출액:${moviesearch.gross}원</p>
					</div>
					<div>
						${moviesearch.netizen_score}
					</div>
				</div>
			</div>
			
		</div>
		<div id="box2">
			<div id="story">
				<h4>줄거리</h4>
				<p>${moviesearch.story}</p>
			</div>
		</div>
		</c:if>
		
		
		
	</main>
	
	<!-- 위시리스트에 추가한 회원의 성비 파이 그래프 -->
	<div id="box3">
			<div id="ChartDIv">
				<canvas id="myChart" position="relative" top="15%" width="600" height="400"></canvas>
					<c:if test="${empty gender_map}">
							<h3>위시리스트에 추가한 회원이 없습니다</h3>
					</c:if>
					<c:if test="${!empty gender_map}">
						<c:set var="gender_map" value="${gender_map}"/>
					
					
					<%
					List<HashMap<String, Integer>> gender_map = (List<HashMap<String, Integer>>) pageContext.getAttribute("gender_map") ;
					
					JSONObject member_gender_df = new JSONObject();
					JSONArray member_genderArray = new JSONArray();
					
						
					for (HashMap<String, Integer> map : gender_map) {
							JSONObject member_gender_json = new JSONObject();
							for( String key : map.keySet()){
						        member_gender_json.put("labels", key);
								member_gender_json.put("data", map.get(key));
								member_genderArray.add(member_gender_json);
						     }
							
					}
					
					member_gender_df.put("gender_map",member_genderArray.toString());
					
					String member_gender_df_re = member_gender_df.toString().replaceAll("\"\\[" ,"\\[").replaceAll("\\]\"" ,"\\]").replaceAll("\\\\" ,"");
					System.out.println(member_gender_df_re);
					%>
					
					<script type="text/javascript">
						var dataset = <%=member_gender_df_re%>;
						var labels = dataset.gender_map.map(function(d) { return d.labels;});
						var data = dataset.gender_map.map(function(d) { return d.data; });;
				
						var ctx = document.getElementById("myChart");
						var myChart = new Chart(ctx,{
							type:"doughnut", 
							data: {
						        labels:labels,
						        datasets: [{
						            label: '이 영화를 위시리스트에 추가한 회원 성비',
						            data: data,
						            backgroundColor: [
						                'rgba(255, 99, 132, 1)',
						                'rgba(54, 162, 235, 1)'
						            ],
						            borderColor: [
						                'rgba(255, 99, 132, 1)',
						                'rgba(54, 162, 235, 1)'
						            ],
						            borderWidth: 1
						        }]
						    },
						    options: {
						        scales: {
						            yAxes: [{
						                ticks: {
						                    beginAtZero: true
						                }
						            }]
						        }
						    }
						});
						
						</script>
						</c:if>
					</div>
		</div>
		
		<!-- 영화를 좋아요 누른 회원의 성별 파이 그래프 -->
		<div id="box4">
			<div id="ChartDIv">
				<canvas id="myChart" position="relative" top="15%" width="600" height="400"></canvas>
					<c:if test="${empty likes_gender_map}">
							<h3>위시리스트에 추가한 회원이 없습니다</h3>
					</c:if>
					<c:if test="${!empty likes_gender_map}">
						<c:set var="likes_gender_map" value="${likes_gender_map}"/>
					
					
					<%
					List<HashMap<String, Integer>> likes_gender_map = (List<HashMap<String, Integer>>) pageContext.getAttribute("likes_gender_map") ;
					
					JSONObject likes_mg_df = new JSONObject();
					JSONArray likes_mg_Array = new JSONArray();
					
						
					for (HashMap<String, Integer> map : likes_gender_map) {
							JSONObject likes_mg_json = new JSONObject();
							for( String key : map.keySet()){
								likes_mg_json.put("labels", key);
								likes_mg_json.put("data", map.get(key));
								likes_mg_Array.add(likes_mg_json);
						     }
							
					}
					
					likes_mg_df.put("gender_map",likes_mg_Array.toString());
					
					String likes_mg_df_re = likes_mg_df.toString().replaceAll("\"\\[" ,"\\[").replaceAll("\\]\"" ,"\\]").replaceAll("\\\\" ,"");
					System.out.println(likes_mg_df_re);
					%>
					
					<script type="text/javascript">
						var dataset = <%=likes_mg_df_re%>;
						var labels = dataset.gender_map.map(function(d) { return d.labels;});
						var data = dataset.gender_map.map(function(d) { return d.data; });;
				
						var ctx = document.getElementById("myChart");
						var myChart = new Chart(ctx,{
							type:"doughnut", 
							data: {
						        labels:labels,
						        datasets: [{
						            label: '이 영화를 위시리스트에 추가한 회원 성비',
						            data: data,
						            backgroundColor: [
						                'rgba(255, 99, 132, 1)',
						                'rgba(54, 162, 235, 1)'
						            ],
						            borderColor: [
						                'rgba(255, 99, 132, 1)',
						                'rgba(54, 162, 235, 1)'
						            ],
						            borderWidth: 1
						        }]
						    },
						    options: {
						        scales: {
						            yAxes: [{
						                ticks: {
						                    beginAtZero: true
						                }
						            }]
						        }
						    }
						});
						
						</script>
						
					</c:if>
					</div>
		</div>
		
		
		
		
		
		
</body>
</html>