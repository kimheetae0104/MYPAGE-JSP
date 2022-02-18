<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	HttpSession Session = request.getSession();
	String nick = "text";
	session.setAttribute("wishlist", nick);
	String name = (String)session.getAttribute("wishlist");
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=name %> 님 안녕하세요
	<a href="memberUpdate.jsp">회원수정</a>
	<a href="JjimListCon.jsp">찜 목록</a>
	<a href="delete.jsp">회원탈퇴</a>
	
</body>
</html>