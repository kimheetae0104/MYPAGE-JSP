<%@page import="com.saeyan.javabeans.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바 빈 객체 생성하기(useBean 액션 태그)</title>
</head>
<body>
	<!-- useBean 액션 태그로 자바 빈 객체를 생성합니다. -->
	<jsp:useBean id = "member" class="com.saeyan.javabeans.MemberBean"/>
	
	자바 빈 객체 생성 후 저장된 정보 출력하기 
	<!-- 객체의 String 형 필드에 초기값을 주지 않으면 null로 자동 초기화 됩니다.
		 그러므로 이름과 아이디 필드 값을 getter로 얻어와 출력하면 null이 출력됩니다.  -->
	<br><br>
	이름 : <%=member.getName() %><br>
	아이디 : <%=member.getUserid() %>
	<hr>
	정보 변경한 후 변경된 정보 출력하기
	<!-- setter로 이름에는 전수빈을 아이디에는 pinksubin을 저장 -->
	<br><br>
	<%
		member.setName("전수빈");
		member.setUserid("pinksubin");
	%>
	이름 : <%=member.getName() %><br>
	아이디 : <%=member.getUserid() %>
</body>
</html>