package kr.or.ddit.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionLogin.do")
public class SessionLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		String userId = request.getParameter("userId");
		String userPass = request.getParameter("userPass");

		HttpSession session = request.getSession();

		if ("admin".equals(userId) && "1234".equals(userPass)) {

			session.setAttribute("LOGINID", userId);
			
		}
		
		//아닐시
		response.sendRedirect(request.getContextPath() + "/session/sessionlogin.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   doGet(request,response);
	}

}