<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//정보수정 화면으로 가기전에
	//아이디 기준으로 회원정보를 조회해서 다음화면으로 전달
	
	String id = (String)session.getAttribute("user_id");
	//DB 연결에 필요한 변수 선언
	String url = 
	String uid = 
	String upw =
	
	Connection conn = null;
	PreparedStatment pstmt = null;
	ResultSet rs = null;
	
	String sql = ""
	
	try{
			//드라이버 호출
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//conn 생성
			conn = DriverManager.getConnetion(url,uid,upw);
			
			//pstmt 생성
			pstmt = conn.preparStatment(sql);
			pstmt.setString(1,id);
			
			//sql실행
			rs = pstmt.executQuery();
			
			if(rs.next()){
				id = rs.getString("id");
				String name = rs.getString("name");
				String phone1 = rs.getString("phone1");
				String phone2 = rs.getString("phone2");
				String phone3 = rs.getString("phone3");
				String gender = rs.getString("gender");
				
				//포워드로 전달하기 위해
				request.setAttribute("id", id);
				request.setAttribute("name",name);
				request.setAttribute("phone1",phone1);
				request.setAttribute("phone2",phone2);
				request.setAttribute("phone3",phone3);
				request.setAttribute("gender",gender);
				
				//포워드 이동
request.getRequestDispatcher("update.jsp").forward(request, response);
			} else{ //세션이 만료된 경우
					response.sendRedirect("login.jsp");
			}
	} catch(Exception e){
		e.printStackTrace();
		response.sendRedirect("login.jsp");
	} finally{
		try{
			if(conn != null) conn.close();
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
%>