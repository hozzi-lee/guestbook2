<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.javaex.vo.GuestbookVo" %>
<%@ page import="java.util.List"%>

<%

List<GuestbookVo> gList = (List<GuestbookVo>) request.getAttribute("gList");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
</head>
<body>

	<form action="/guestbook2/gbc" method="post">
		<input type="hidden" name="page" value="add">
		<table border="1" width="500">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value=""></td>
				<td>비밀번호</td>
				<td><input type="password" name="pw" value=""></td>
			</tr>
			<tr>
				<td colspan="4"><textarea name="ct" cols="65" rows="5" style="resize: none;"></textarea></td>
			</tr>
			<tr>
				<td colspan="4"><button type="submit">확인</button></td>
			</tr>
		</table>
	</form>
	
	<br>

	<%
	for (GuestbookVo g : gList) {
	%>
	
	<table border="1" width="500">
		<tr>
			<td><%=g.getNo()%></td>
			<td><%=g.getName()%></td>
			<td><%=g.getDate()%></td>
			<td><a href="/guestbook2/gbc?page=dForm&no=<%=g.getNo()%>">삭제</a></td>
		</tr>
		<tr>
			<td colspan="4"><%=g.getContent()%></td>
		</tr>
	</table>
	
	<br>
	
	<%
	}
	%>
</body>
</html>