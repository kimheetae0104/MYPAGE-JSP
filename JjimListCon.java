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
		// �г���, ī��Ʈ�� ��������
		// ���� �ʿ��� �ڷḦ � ���·� ������ ���ΰ� 
		// ������  �� �Ѱ� ��  �ʿ��� ���� ��̰� ���ʿ��ѵ�
	 // �������� �����;��ؼ� �迭�� �ʿ���
		
		
		String nick = request.getParameter("nick");
		int cnt = 1;
		
		JjimListSelectDAO dao = new JjimListSelectDAO();
		
		ArrayList<JjimListSelectDTO> list = dao.Select(nick, cnt);
		
		
	}

}
