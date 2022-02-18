<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>세션 값 얻어오기</h3>
	<%
	// session.getAttribute()의 매개변수에 "id"를 지정하여 호출하면 문자열인 "pinksung"이 
	// object 형으로 반환(리턴)된다. 그래서 String 형 변수에 저장하려면 cast연산자로 명시적인 형 변환을 해야한다.
		String id = (String)session.getAttribute("id");
		String pwd = (String)session.getAttribute("pwd");
		//"age"에 저장된 값은 역시 object 형으로 반환(리턴)된다. 이메소드로 얻어진 결과값인 object 형은 integer로 형 변환된다.
		Integer age = (Integer)session.getAttribute("age");
	
	%>
<!--  세션에서 받아온 값을 출력한다.	 -->
	id : <%= id %><br>
	pwd : <%= pwd %><br>
	age : <%= age %><br>
</body>
</html>