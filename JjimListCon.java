package mypage.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypage.model.JjimListSelectDAO;
import mypage.model.JjimListSelectDTO;


@WebServlet("/JjimListCon")
public class JjimListCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 닉네임, 카운트를 가져오기
		// 내가 필요한 자료를 어떤 형태로 가져올 것인가 
		// 데이터  딱 한개 만  필요할 경우는 어레이가 안필요한데
	 // 여러개를 가져와야해서 배열이 필요함
		
		
		String nick = request.getParameter("nick");
		int cnt = 1;
		
		JjimListSelectDAO dao = new JjimListSelectDAO();
		
		ArrayList<JjimListSelectDTO> list = dao.Select(nick, cnt);
		
		
	}

}
