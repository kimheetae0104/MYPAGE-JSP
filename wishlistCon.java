package com.member.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.model.wishlistDAO;
import com.member.model.wishlistDTO;


@WebServlet("/wishlistCon")
public class wishlistCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Object wishlist;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		wishlistDAO dao = new wishlistDAO();
		ArrayList<wishlistDTO> wishitems = dao.wishlistSeletAll();
		
		request.setAttribute("wishlist", wishlist);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("select.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
