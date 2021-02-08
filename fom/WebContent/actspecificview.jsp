<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import = "java.util.*,fom.vo.*,  java.util.Map.*,  org.json.simple.*" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>

.links line {
  stroke: #999;
  stroke-opacity: 0.6;
}

.nodes circle {
  stroke: #fff;
  stroke-width: 1.5px;
}

text {
  font-family: sans-serif;
  font-size: 7px;
}

.bar {
  fill: steelblue;
}

.bar:hover {
  fill: brown;
}

.axis--x path {
  display: none;
}


</style>
<title>배우 조회</title>
<script src="http://d3js.org/d3.v4.min.js"></script>
<script src="https://d3js.org/d3-dispatch.v1.min.js"></script>
<script src="https://d3js.org/d3-quadtree.v1.min.js"></script>
<script src="https://d3js.org/d3-timer.v1.min.js"></script>
<script src="https://d3js.org/d3-force.v2.min.js"></script>
</head>
<body>

<a href="/fom/mainsearch.jsp">홈 화면으로 이동</a>

<c:if test="${empty actresearch}">
		<h3>배우 정보가 없습니다</h3>
	</c:if>
	<c:if test="${!empty actresearch}">
		<h3>**배우 정보 리스트**</h3>
	${actresearch.actor_code} &nbsp;&nbsp;&nbsp;
	${actresearch.name} &nbsp;&nbsp;&nbsp;
	<br>
	</c:if>
	<br>
	<c:set var="actfilmo" value="${actfilmo}"/>
	
	<%
	List<MovieVO2> actorfilmo = (List<MovieVO2>) pageContext.getAttribute("actfilmo") ;
	
	JSONObject film_df = new JSONObject();
	JSONArray actfilmoArray = new JSONArray();
	
	for (MovieVO2 vo : actorfilmo) {
			JSONObject filmo_json = new JSONObject();
			filmo_json.put("moviecode", vo.getMoviecode());
			filmo_json.put("title", vo.getName());
			filmo_json.put("open_date", vo.getOpen_date());
			filmo_json.put("viewer", vo.getViewer());
			filmo_json.put("netizen_score", vo.getNetizen_score());
			actfilmoArray.add(filmo_json);
	}
	
	film_df.put("actfilmo",actfilmoArray.toString());
	
	String film_df_re = film_df.toString().replaceAll("\"\\[" ,"\\[").replaceAll("\\]\"" ,"\\]").replaceAll("\\\\" ,"");
	System.out.println(film_df_re);
	%>
	
	<br/><br/><br/><br/><br/>
	<div width="700px" height="400px">
	<script type="text/javascript">
	

    //Original data
    var dataset = <%=film_df_re%>;
    
    var w = 700;
    var h = d3.max(dataset.actfilmo, function(d){return d.viewer * 0.000025;}) + 10;
    var barPadding = 10;
    
    var margin = {top: 10, right: 20, bottom: 30, left: 40};
    var svg = d3.select("body")
          .append("svg")
          .attr("width", w + margin.left + margin.right)
          .attr("height", h + margin.top + margin.bottom);
    
    // Add the x Axis
    var g = svg.append("g")
       .attr("transform", "translate(" + margin.left + "," + margin.top + ")");
    var x = d3.scaleBand().rangeRound([0, w]).padding(0.1);
    var xAxis = d3.axisBottom(x);
    x.domain(dataset.actfilmo
          .sort((a, b) => d3.ascending(a.open_date, b.open_date))
          .map(function(d) { return d.title }));
    
    
    g.append("g")
       .attr("class", "axis axis--x")
       .attr("transform", "translate(-5," + h + ")")
       .call(xAxis);
    
    
    g.selectAll("rect")
       .data(dataset.actfilmo)
       .enter()
       .append("rect")
       .sort((a, b) => d3.ascending(a.open_date, b.open_date))
       .attr("x", function(d, i){
          return i * (w / dataset.actfilmo.length);
       })
       .attr("y", function(d){
          return h - d.viewer * 0.000025;
       })
       .attr("width", w / dataset.actfilmo.length - barPadding)
       .attr("height", function(d){
          return d.viewer * 0.000025;
       })
       .attr("fill", "#ffd27a");
    
 
    
    g.selectAll("texts")
       .data(dataset.actfilmo)
       .enter()
       .append("text")
       .sort((a, b) => d3.ascending(a.open_date, b.open_date))
        .text(function(d) { return d3.format(".0f")(d.viewer * 0.0001) + "만"; })
       .attr("x", function(d, i){
          return i * (w / dataset.actfilmo.length) ;
       })
       .attr("y", function(d){return h - d.viewer * 0.000025 - 7;})
       .attr("font-family", "sans-serif")
       .attr("font-size", "7px")
       .attr("fill", "black");
		
	</script>
	</div>
	
	
	
	
	<c:set var="networkgraph" value="${networkgraph}"/>
	
	<%

	List<NetworkVO> network_list = (List<NetworkVO>) pageContext.getAttribute("networkgraph") ;
	
	JSONObject df = new JSONObject();
	////////////////////////////////////////////////////////
	JSONArray nodeArray = new JSONArray();

	
	for (NetworkVO vo : network_list) {
		if (vo.getCode()==network_list.get(0).getActor_code()){
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
	
	for (NetworkVO vo : network_list) {
		JSONObject link_json = new JSONObject();
		link_json.put("source", vo.getSearch_name());
		link_json.put("target", vo.getName());
		linkArray.add(link_json);
	    }
	
	df.put("edges",linkArray.toString());
	
	String df_result = df.toString().replaceAll("\"\\[" ,"\\[").replaceAll("\\]\"" ,"\\]").replaceAll("\\\\" ,"");
	System.out.println(df_result);


	%>
	
	<div>
	<script type="text/javascript">

		//Width and height
		var w = 700;
		var h = 700;
	
		
		//Original data
		var dataset = <%=df_result%>;
		
		
		var svg = d3.select("body")
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
	  
	  
		/* //Initialize a simple force layout, using the nodes and edges in dataset
		var force = d3.forceSimulation(dataset.nodes)
					  .force("charge", d3.forceManyBody())
					  .force("link", d3.forceLink(dataset.edges).id(function(d) { return d.id; }).distance(150))
					  .force("center", d3.forceCenter().x(w/2).y(h/2));

		var colors = d3.scaleOrdinal(d3.schemeCategory10);

		//Create SVG element
		var svg = d3.select("body")
					.append("svg")
					.attr("width", w)
					.attr("height", h);
		
		
			
		//Create edges as lines
		var edges = svg.selectAll("line")
						.data(dataset.edges)
						.enter()
						.append("line")
						.style("stroke", "#ccc")
						.style("stroke-width", 1);
			
		
		
		//Create nodes as circles
		var nodes = svg.selectAll("circle")
						.data(dataset.nodes)
						.enter()
						.append("circle")
						.attr("r", function(d) { return d.value; })
						.style("fill", function(d) {
						return colors(d.group);
						})
						.call(d3.drag()  //Define what to do on drag events
						.on("start", dragStarted)
						.on("drag", dragging)
						.on("end", dragEnded))
						;
		
		var nodes = svg.append("g")
	      			   .attr("class", "nodes")
	    			   .selectAll("g")
	    			   .data(dataset.nodes)
	    			   .enter().append("g");
	    
		var circles = nodes.append("circle")
	      				   .attr("r", function(d) { return d.value; })
	      				   .attr("fill", function(d) { return colors(d.group); })
	      				   .call(d3.drag()  //Define what to do on drag events
						   .on("start", dragStarted)
						   .on("drag", dragging)
						   .on("end", dragEnded))
						   ;
		
		//Add a simple tooltip
		nodes.append("title")
			 .text(function(d) {
				return d.id;
			 }); 
		 */
			
		/* //Every time the simulation "ticks", this will be called
		force.on("tick", function() {

		edges.attr("x1", function(d) { return d.source.x; })
			 .attr("y1", function(d) { return d.source.y; })
			 .attr("x2", function(d) { return d.target.x; })
			 .attr("y2", function(d) { return d.target.y; });
			
		nodes.attr("cx", function(d) { return d.x; })
			 .attr("cy", function(d) { return d.y; });
				});

		//Define drag event functions
		function dragStarted(d) {
			if (!d3.event.active) force.alphaTarget(0.3).restart();
				d.fx = d.x;
				d.fy = d.y;
			}

		function dragging(d) {
			d.fx = d3.event.x;
			d.fy = d3.event.y;
		}

		function dragEnded(d) {
			if (!d3.event.active) force.alphaTarget(0);
				d.fx = null;
				d.fy = null;
		}
 */
	</script>
	</div>
	
	
</body>
</html>