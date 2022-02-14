<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String id = (String)session.getAttribute("user_id");
	String name = (String)session.getAttribute("user_name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>마이페이지</h1>
	<%=id %>님 안녕하세요
	<p>계정 대시보드에서 최근 보신 상품을 보거나 계정 수정, 탈퇴를 할 수 있습니다. 
	<a href = "wishlist.jsp">찜 목록</a></br>
	<a href = "update.jsp">정보수정</a></br>
	<a href = "delete_ok.jsp">회원탈퇴</a></br>
	
	
	
	
	
	
</body>
</html>