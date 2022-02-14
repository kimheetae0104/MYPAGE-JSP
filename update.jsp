<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align: center;">

	<!-- Wrapper  -->
	<div id="wrapper">
		<!-- Menu -->
		<nav id="Update">
			<ul class="actions vertical">
				<li><h5>회원정보수정</h5></li>
				<form action="UpdateCon" method="post">
					<li> ${member.getid }<li>
					<li><input type="password" name="pw" placeholder="PW를 입력하세요"	style="width: 500px; margin: 0 auto;"></li>
					<li><input type="text" name="nick" placeholder="닉네임을 입력하세요" style="width: 500px; margin: 0 auto;"></li>
					<li><input type="phone" name="phone" placeholder="핸드폰번호를 입력하세요" style="width: 500px; margin: 0 auto;"></li>
					<li><input type="submit" value="Update" class="button fit" style="width: 500px; margin: 0 auto;"></li>
				</form>
		</nav>
	</div>
	
</body>
</html>