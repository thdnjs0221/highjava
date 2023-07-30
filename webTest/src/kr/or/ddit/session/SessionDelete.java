package kr.or.ddit.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionDelete.do")
public class SessionDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//Session삭제하기
		
		//1. Session객체를 생성하거나 현재 세션 가져오기
		HttpSession session = request.getSession();
		
		//2. Session삭제
		
		//1) Session자체는 삭제되지 않고 개별적인 'session데이터'삭제하기
		// 형식) Session객체.removeAttribute("삭제할 key값");
		//session.removeAttribute("test");
		
		
		//2) Session 자체를 삭제하기 
		// 형식) Session객체.invalidate();
		session.invalidate();
		
		
		
		
		out.println("<html><head><meta charset='utf-8'<title>Session 연습 </title></head>");
		out.println("<body>");
		
		out.println("<h3>Session 데이터 삭제하기</h3><hr>");
		
		out.println("<a href='" + request.getContextPath() + 
	            "/session/sessionTest.jsp'>시작문서로 이동하기</a>");
		
		out.println("</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
