<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

	<form action="/fom/memberInsert.do">
		<table border="1">
			<tr>
				<th>ID</th>
				<td><input type="text" name="member_id" /></td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="password" name="password" /></td>
			</tr>

			<tr>
				<th>AGE</th>
				<td valign="top"><select name="age">
						<option value="10">10</option>
						<option value="20">20</option>
						<option value="30">30</option>
				</select></td>
			</tr>
			

			<tr>
				<th>GENDER</th>
				<td><input type="radio" name="gender" value="남자" />남자</td>
				<td><input type="radio" name="gender" value="여자" />여자</td>
			</tr>
		</table>
		<input type="submit" value="확인"></input> <input type="reset"
			value="취소" />
	</form>


</body>
</html>