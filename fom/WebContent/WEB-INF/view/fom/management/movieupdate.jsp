<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.util.*,fom.vo.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
@import url("/fom/css/sign.css");
</style>
<script type="text/javascript">
	function setThumbnail2(event) {
		var text = document.getElementById("image");
		var img = document.createElement("img");
		img.setAttribute("src", text.value);
		img.setAttribute("style", "width:30%");
		if (document.querySelector("div#preview2").hasChildNodes()) {
			document.querySelector("div#preview2").lastElementChild.remove();
		}
		document.querySelector("div#preview2").appendChild(img);
	}
</script>
</head>
<body>
<%

%>
	<section class="signbox">
		<h2>영화수정</h2>
		<form action="/fom/movieUpdate.do">
			<div style="width:210px; height:290px;">
				<input type="text" name="image" id="text"  value="${movieupdatesearch.image}"> <input
					type="button" onclick="setThumbnail2(event);" value="버튼">
				<div id="preview2" style="max-width: 550px">
					<input type="hidden" />
				</div>
			</div>
			
				<input type="text" name="name" value="${movieupdatesearch.name}">
				<input type="text" name="open_date" value="${movieupdatesearch.open_date}"><br>
				<input type="text" name="gross" value="${movieupdatesearch.gross}">
				<input type="text" name="viewer" value="${movieupdatesearch.viewer}"><br>
				<input type="text" name="country" value="${movieupdatesearch.country}">		
				<input type="text" name="distribution" value="${movieupdatesearch.distribution}"><br>
				<input type="text" name="link" value="${movieupdatesearch.link}">
				<input type="hidden" name="moviecode" value="${movieupdatesearch.moviecode}">
				<input type="text" name="py" value="${movieupdatesearch.py}"><br>
				<input type="text" name="director" value="${movieupdatesearch.director}">	
				<input type="text" name="genres" value="${movieupdatesearch.genres}"><br>
				<input type="text" name="expert_score" value="${movieupdatesearch.expert_score}">
				<input type="text" name="netizen_score" value="${movieupdatesearch.netizen_score}"><br>
				<input type="text" name="story" value="${movieupdatesearch.story}">			
				<button type="submit">수정</button>
				
				
			
		</form>
	</section>

</body>
</html>