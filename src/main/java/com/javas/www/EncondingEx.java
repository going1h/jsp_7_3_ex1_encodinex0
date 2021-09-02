package com.javas.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EncondingEx
 */
@WebServlet("/EncondingEx")
public class EncondingEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EncondingEx() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("GET 방식으로 실행되었습니다.");

		
		String name = request.getParameter("name");
		
		response.setContentType("text/html; charset=EUC-KR"); // 요것이 writer, response 부분은 한글로 바꿔주는데
		PrintWriter writer = response.getWriter();
		writer.println("<html><head></head><body>");
		writer.println("안녕하시오. " + name + "님 반갑수다<br>");  // name 값 들어오는 것 한글 인코딩은 안됨
		writer.println("</body></html>");
		
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		System.out.println("POST 방식으로 실행되었습니다.");
		
		request.setCharacterEncoding("EUC-KR"); // request 객체의 파라미터값을 한글로 인코딩 post방식만 됨
		
		String name = request.getParameter("name");
		
		response.setContentType("text/html; charset=EUC-KR");
		PrintWriter writer = response.getWriter();
		writer.println("<html><head></head><body>");
		writer.println("안녕하시오. " + name + "님 반갑수다<br>");
		writer.println("</body></html>");
		
		writer.close();
	}

}
