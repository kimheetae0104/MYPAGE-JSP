<%@page import= " java.net.URLEncoder" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//데이터베이스와 연동하는 것이 아니라 임의로 지정해서 테스트해보기 우해
	// String 으로 만들어준다.
	String id = "pinksung";
	String pwd = "1234";
	String name = "성윤정";
	//post 전송 방식일 경우에 요청 파라미터 값에 대한 한글 처리
	request.setCharacterEncoding("UTF-8");
	// 아이디와 암호가 모두 일치ㅏ여 로그인에 성공하면 메인페이지로 이동
	if(id.equals(request.getParameter("id")) && 
			pwd.equals(request.getParameter("pwd")) ){
		//메인페이지로 회원 이름을 쿼리 스트링으로 넘겨주어 메인페이지에서 로그인한 회원의 이름을 출력되도록 한다.
		// 이때 직접 한글을 쿼리 스트링으로 만들어 페이지로 전송할 경우에는 URLEncoder.encode() 메소드로 인코딩 과정을 
		//거쳐야한다.
		response.sendRedirect("04_main01.jsp?name="
			+URLEncoder.encode(name, "UTF-8")); // 이부분을 사용하기 위해서 1번을 써준다.
		
	}
	else{ //아이디나 암호 중 어느 하나라도 불일치하면 로그인에 실패한 것이므로 로그인 페이지로 이동한다.
		response.sendRedirect("04_loginForm.jsp");
	}
			

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
</body>
</html>