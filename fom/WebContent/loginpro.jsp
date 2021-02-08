<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="java.sql.*"%>
<%@page import="fom.vo.MemberVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
request.setCharacterEncoding("UTF-8");

String member_id = request.getParameter("member_id");
String password = request.getParameter("password");

MemberVO nmember = new MemberVO();
nmember.setMember_id(member_id);
nmember.setPassword(password);
out.print(member_id);
out.print(password);

String url = "jdbc:oracle:thin:@localhost:1521:xe";
String user = "big5", pw = "admin1234";

Connection con = null;
int res = 0;
CallableStatement pstmt = null;

Class.forName("oracle.jdbc.OracleDriver");
con = DriverManager.getConnection(url, user, pw);

// 3) SQL문 준비
String blogin = "{ ? = call MEMBER_LOGIN(?,?) }";
pstmt = con.prepareCall(blogin); // 쿼리호출

pstmt.setQueryTimeout(1800);

pstmt.setString(2, nmember.getMember_id());
pstmt.setString(3, nmember.getPassword());

pstmt.registerOutParameter(1, java.sql.Types.INTEGER);

pstmt.executeUpdate();

res = pstmt.getInt(1);


if (res==1) {
		session.setAttribute("member_id", member_id);
		session.setAttribute("password", password);
		
		Cookie c = new Cookie("member_id", member_id);
		Cookie p = new Cookie("password", password);
		c.setMaxAge(60 * 2);
		c.setPath("/");
		response.addCookie(c);
		response.addCookie(p);
		%>
	<script>alert("인증되었습니다.");
		location.href = "mainsearch.jsp" // 쿠키 정보도 같이 넘어감
		</script>
	<%
	} else {
		%>
	<script>alert("아이디 또는 비밀번호가 다릅니다.");
		location.href = "login.jsp"
		</script>
	<%
	}
%>
</body>
</html>