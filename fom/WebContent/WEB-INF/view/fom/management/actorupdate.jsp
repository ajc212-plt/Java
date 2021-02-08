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
		var text = document.getElementById("actor_thumbnail");
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
		<h2>배우수정</h2>
		<form action="/fom/actorUpdate.do">
			<div style="width:210px; height:290px;">
				<input type="text" name="actor_thumbnail" id="text"  value="${actorupdatesearch.actor_thumbnail}"> <input
					type="button" onclick="setThumbnail2(event);" value="버튼">
				<div id="preview2" style="max-width: 550px">
					<input type="hidden" />
				</div>
			</div>
			
				<input type="text" name="name" value="${actorupdatesearch.name}">
				<input type="hidden" name="actor_code" value="${actorupdatesearch.actor_code}">
				<button type="submit">수정</button>
				
				
			
		</form>
	</section>

</body>
</html>