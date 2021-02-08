<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
@import url("/fom/css/sign.css");
</style>
</head>
<body>
<section class="signbox">
		<h2>회원가입</h2>
		<form action="/fom/memberInsert.do">
			<ul>
				<li>
					<input type="text" name="member_id" placeholder="아이디" id="idtxt" title="아이디 입력">
					<input type="button" name="multiname" id="multiname" value="중복확인">
					<select id="checksx" name="gender">
						<option value="male">남성</option>
						<option value="female">여성</option>
					</select>
				</li>
				<li><input type="password" name="password" placeholder="비밀번호" title="비밀번호 입력"></li>
				<li>
				<input type="radio" name="age" value="10" style="width:20px"
				class="birth"><p>10대</p>
				<input type="radio" name="age" value="20" style="width:20px"
				class="birth"><p>20대</p>
				<input type="radio" name="age" value="30" style="width:20px"
				class="birth"><p>30대</p>
				<input type="radio" name="age" value="40" style="width:20px"
				class="birth"><p>40대</p>
				<input type="radio" name="age" value="50" style="width:20px"
				class="birth"><p>50대</p>
				</li>
				<li><button type="submit">회원가입</button></li>
			</ul>
		</form>
		</section>

</body>
</html>