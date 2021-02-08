<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import = "java.util.*,fom.vo.*,  java.util.Map.*,  org.json.simple.*" %>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
h1{color:white;}
h2{color:white;}
h3{color:white;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>배우 조회</title>
<link rel="stylesheet" href="/fom/css/resultdirector.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.css"/>
<script src="http://d3js.org/d3.v4.min.js"></script>
<script src="https://d3js.org/d3-dispatch.v1.min.js"></script>
<script src="https://d3js.org/d3-quadtree.v1.min.js"></script>
<script src="https://d3js.org/d3-timer.v1.min.js"></script>
<script src="https://d3js.org/d3-force.v2.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.bundle.js"></script>
<script src="https://kit.fontawesome.com/e13247fad1.js"></script>
</head>
<body>

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
				<a href="mainsearch.jsp"><!-- 로고를 누르면 검색창으로 넘어감 -->
					<h1>	
					<span>Forest of Movie</span>
					</h1>
				</a>
				<h2>검색창</h2>
				<fieldset>
					<legend class="blind">검색</legend>
					<form action="/fom/actorlistsearch.do" method="post"><!--  -->
					<input type="text" class="searchtxt" name="name" placeholder="키워드 검색">
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
					<li><a href="#">MOVIE</a></li>
					<li><a href="#">ACTOR</a></li>
					<li><a href="#">DIRECTOR</a></li>
				</ul>
			</nav>
		</div>	
	</header>
<main>
	<c:if test="${empty dirsearch}">
		<h3>배우 정보가 없습니다</h3>
	</c:if>
	<div id="totalbox">
		
		<!-- 인물 설명-->
		<c:if test="${!empty dirsearch}">
			<h1 style="color: white;
    border-left: 3px solid red;">${dirsearch.name}</h1>
		</c:if>
			<div id="imagebox">
			<c:if test="${!empty dirsearch}">
				<img src="${dirsearch.dir_thumbnail}">
				이미지:이미지 들어가면 하얀 바탕 삭제
				<div class="container">
						<i onclick="Toggle()" id="btn" class="far fa-heart"></i>
					</div>
					<script>
						var btn = document.getElementById('btn');
						
						function Toggle(){
							if(btn.classList.contains("far")){
								btn.classList.remove("far");
								btn.classList.add("fas");
								location.href = "/fom/m_dirInsert.do?member_id=${sessionScope.user.member_id}&dir_code=${dirsearch.dir_code}";
							}else{
								btn.classList.remove("fas");
								btn.classList.add("far");
							}
						}	
					</script>
			</c:if>	
			</div>
	
		<!-- 타임라인 그래프 -->
		<div id="box2">
		<c:set var="dirfilmo" value="${dirfilmo}"/>
	
	<%
	List<MovieVO2> directorfilmo = (List<MovieVO2>) pageContext.getAttribute("dirfilmo") ;
	
	JSONObject film_df = new JSONObject();
	JSONArray dirfilmoArray = new JSONArray();
	
	for (MovieVO2 vo : directorfilmo) {
			JSONObject filmo_json = new JSONObject();
			filmo_json.put("moviecode", vo.getMoviecode());
			filmo_json.put("title", vo.getName());
			filmo_json.put("open_date", vo.getOpen_date());
			filmo_json.put("viewer", vo.getViewer());
			filmo_json.put("netizen_score", vo.getNetizen_score());
			dirfilmoArray.add(filmo_json);
	}
	
	film_df.put("dirfilmo",dirfilmoArray.toString());
	
	String film_df_re = film_df.toString().replaceAll("\"\\[" ,"\\[").replaceAll("\\]\"" ,"\\]").replaceAll("\\\\" ,"");
	System.out.println(film_df_re);
	%>
			<div id="timebox">
			
    		 	<script type="text/javascript">
      
    		 	var dataset = <%=film_df_re%>;
    		    
    		    var w = 700;
    		    var h = d3.max(dataset.dirfilmo, function(d){return d.viewer * 0.000025;}) + 10;
    		    var barPadding = 10;
    		    
    		    var margin = {top: 10, right: 20, bottom: 30, left: 40};
    		    var svg = d3.select("#timebox")
    		          .append("svg")
    		          .attr("width", w + margin.left + margin.right)
    		          .attr("height", h + margin.top + margin.bottom);
    		    
    		    // Add the x Axis
    		    var g = svg.append("g")
    		       .attr("transform", "translate(" + margin.left + "," + margin.top + ")");
    		    var x = d3.scaleBand().rangeRound([0, w]).padding(0.1);
    		    var xAxis = d3.axisBottom(x);
    		    x.domain(dataset.dirfilmo
    		          .sort((a, b) => d3.ascending(a.open_date, b.open_date))
    		          .map(function(d) { return d.title }));
    		    
    		    
    		    g.append("g")
    		       .attr("class", "axis axis--x")
    		       .attr("transform", "translate(-5," + h + ")")
    		       .call(xAxis);
    		    
    		    
    		    g.selectAll("rect")
    		       .data(dataset.dirfilmo)
    		       .enter()
    		       .append("rect")
    		       .sort((a, b) => d3.ascending(a.open_date, b.open_date))
    		       .attr("x", function(d, i){
    		          return i * (w / dataset.dirfilmo.length);
    		       })
    		       .attr("y", function(d){
    		          return h - d.viewer * 0.000025;
    		       })
    		       .attr("width", w / dataset.dirfilmo.length - barPadding)
    		       .attr("height", function(d){
    		          return d.viewer * 0.000025;
    		       })
    		       .attr("fill", "#ffd27a");
    		    
    		 
    		    
    		    g.selectAll("texts")
    		       .data(dataset.dirfilmo)
    		       .enter()
    		       .append("text")
    		       .sort((a, b) => d3.ascending(a.open_date, b.open_date))
    		        .text(function(d) { return d3.format(".0f")(d.viewer * 0.0001) + "만"; })
    		       .attr("x", function(d, i){
    		          return i * (w / dataset.dirfilmo.length) ;
    		       })
    		       .attr("y", function(d){return h - d.viewer * 0.000025 - 7;})
    		       .attr("font-family", "sans-serif")
    		       .attr("font-size", "15px")
    		       .attr("fill", "white");
				</script>
    		</div>
		</div>
	</div>
		

<!-- 배우를 좋아요 누른 회원의 성별 파이 그래프 -->
		<div id="box3">
			<div id="ChartDIv">
					<c:if test="${empty gender_map}">
							<h3>위시리스트에 추가한 회원이 없습니다</h3>
					</c:if>
					<c:if test="${!empty gender_map}">
						<c:set var="gender_map" value="${gender_map}"/>
					
					
					<%
					List<HashMap<String, Integer>> gender_map = (List<HashMap<String, Integer>>) pageContext.getAttribute("gender_map") ;
					
					JSONObject mg_df = new JSONObject();
					JSONArray mg_Array = new JSONArray();
						
					for (HashMap<String, Integer> map : gender_map) {
							JSONObject mg_json = new JSONObject();
							for( String key : map.keySet()){
								mg_json.put("labels", key);
								mg_json.put("data", map.get(key));
								mg_Array.add(mg_json);
						     }
					}
					
					mg_df.put("gender_map",mg_Array.toString());
					
					String mg_df_re = mg_df.toString().replaceAll("\"\\[" ,"\\[").replaceAll("\\]\"" ,"\\]").replaceAll("\\\\" ,"");
					System.out.println(mg_df_re);
					%>
					<canvas id="myChart" position="relative" top="15%" width="600" height="400"></canvas>
					<script type="text/javascript">
						var dataset = <%=mg_df_re%>;
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
		



		<c:set var="dir_networkgraph" value="${dir_networkgraph}"/>
	
	<%

	List<Network_DIRVO> network_list = (List<Network_DIRVO>) pageContext.getAttribute("dir_networkgraph") ;
	
	JSONObject df = new JSONObject();
	////////////////////////////////////////////////////////
	JSONArray nodeArray = new JSONArray();

	
	for (Network_DIRVO vo : network_list) {
		if (vo.getCode()==network_list.get(0).getDir_code()){
			JSONObject node_json = new JSONObject();
			node_json.put("id", vo.getName());
			node_json.put("group", vo.getJob());
			node_json.put("value", 5);
			node_json.put("code", vo.getCode());
			nodeArray.add(node_json);
		}else{
			JSONObject node_json = new JSONObject();
			node_json.put("id", vo.getName());
			node_json.put("group", vo.getJob());
			node_json.put("value", vo.getCount());
			node_json.put("code", vo.getCode());
			nodeArray.add(node_json);
	    }
	}
	
	df.put("nodes",nodeArray.toString());
	
	///////////////////////////////////////////////////////
	JSONArray linkArray = new JSONArray();
	
	for (Network_DIRVO vo : network_list) {
		JSONObject link_json = new JSONObject();
		link_json.put("source", vo.getSearch_name());
		link_json.put("target", vo.getName());
		linkArray.add(link_json);
	    }
	
	df.put("edges",linkArray.toString());
	
	String df_result = df.toString().replaceAll("\"\\[" ,"\\[").replaceAll("\\]\"" ,"\\]").replaceAll("\\\\" ,"");
	System.out.println(df_result);


	%>
			<div id="networkgraph">
			<script type="text/javascript">

		//Width and height
		var w = 1060;
		var h = 800;
	
		
		//Original data
		var dataset = <%=df_result%>;
		
		
		var svg = d3.select("#networkgraph")
					.append("svg")
					.attr("width", w)
					.attr("height", h);
	
		//var color = d3.scaleOrdinal(d3.schemeCategory20);
		var color = d3.scaleOrdinal(["#26aaff", "#ffa726"]);
		
		var simulation = d3.forceSimulation()
						    .force("link", d3.forceLink().id(function(d) { return d.id; }).distance(150))
						    .force("charge", d3.forceManyBody(-500).distanceMax(200).distanceMin(60))
						    .force("center", d3.forceCenter(w/2, h/2))
						    .force('collision', d3.forceCollide(20).strength(1).iterations(1))
						    ;
			
			
		
		var link = svg.append("g")
	      .attr("class", "links")
	    .selectAll("line")
	    .data(dataset.edges)
	    .enter().append("line")
	      .attr("stroke-width", 1);
		
	  var node = svg.append("g")
	      .attr("class", "nodes")
	    .selectAll("g")
	    .data(dataset.nodes)
	    .enter().append("g")
	    .append("a")
	  	.attr("xlink:href", function (d){
	  		if (d.group == 1){
	  		return "/fom/actorSpecificsearch.do?actor_code=" + d.code }
	  		if (d.group == 2){
	  		return "/fom/directorSpecificsearch.do?dir_code=" + d.code
	  		}
	  	});
	    
	  var circles = node.append("circle")
	      .attr("r", function(d) { return d.value * 5; })
	      .attr("fill", function(d) { return color(d.group); })
	      .call(d3.drag()
	    		  .on("start", dragStarted)
					.on("drag", dragging)
					.on("end", dragEnded));

	  var lables = node.append("text")
	      .text(function(d) {
	        return d.id;
	      })
	      .attr('x', 6)
	      .attr('y', 3);

	  node.append("title")
	      .text(function(d) { return d.id; });

	  simulation
	      .nodes(dataset.nodes)
	      .on("tick", ticked);

	  simulation.force("link")
	      .links(dataset.edges);
	  
	  function ticked() {
		    link
		        .attr("x1", function(d) { return d.source.x; })
		        .attr("y1", function(d) { return d.source.y; })
		        .attr("x2", function(d) { return d.target.x; })
		        .attr("y2", function(d) { return d.target.y; });

		    node
		        .attr("transform", function(d) {
		          return "translate(" + d.x + "," + d.y + ")";
		        })
		  }
	  

	  function dragStarted(d) {
	    if (!d3.event.active) simulation.alphaTarget(0.3).restart();
	    d.fx = d.x;
	    d.fy = d.y;
	  }

	  function dragging(d) {
	    d.fx = d3.event.x;
	    d.fy = d3.event.y;
	  }

	  function dragEnded(d) {
	    if (!d3.event.active) simulation.alphaTarget(0);
	    d.fx = null;
	    d.fy = null;
	  }
	  </script>
      		</div>
		</div>
	</main>
</body>
</html>