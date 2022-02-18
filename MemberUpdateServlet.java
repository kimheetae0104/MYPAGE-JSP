package mypage.model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sayan.dao.MemberDAO;


@WebServlet("/MemberUpdateServlet")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		MemberDAO mDao = MemberDAO.getInstance();
		
		MemberDTO mDTO = mDao.getMember(userid);
		request.setAttribute("mDTO", mDTO);
		//MemberDAO ��ü�� ��� �ͼ� getMember �޼ҵ带 ȣ���Ͽ� member ���̺����� ȸ�� ������ ���´�
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/memberUpdate.jsp");
		dispatcher.forward(request, response); //ȸ�������� ��û ��ü�� �����մϴ�. 
	}

}