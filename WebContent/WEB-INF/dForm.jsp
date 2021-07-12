<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.javaex.vo.GuestbookVo" %>

<%

int no = Integer.parseInt(request.getParameter("no"));

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/guestbook2/gbc" method="post">
		<input type="hidden" name="page" value="delete">
		비밀번호 <input type="password" name="pw" value=""> <button type="submit">확인</button>
		<input type="hidden" name="no" value="<%=no %>">
	</form>
	<a href="/guestbook2/gbc?page=addList">메인으로 돌아가기</a>

</body>
</html>