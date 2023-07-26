package kr.or.ddit.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//b

@WebServlet("/forwardTest.do")
public class ForwardTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//POST방식의 인코딩 방식 설정
		request.setCharacterEncoding("utf-8");
		
		
		//파라미터로 전달되는 데이터 받기 
		String userName = request.getParameter("username"); //responseTest01.jsp의 username
		
		//이전 문서에서 setAttribute()메서드로 셋팅한 데이터 받기 
		//받을때 형식) Request객체.getAttribute("key값")
		String tel= (String) request.getAttribute("tel"); //형변환해주기
		
		//응답 처리 
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><meta charset='utf-8'><title>Foward연습</title>");
		out.println("<body>");
		
		out.println("<h3>Foward 이동 결과</h3><hr> ");
		out.println("<table border='1'>");
		out.println("<tr><td>이 름</td>");
		out.println("<td>"+userName+"</td></tr>");
		out.println("<tr><td>전화</td>");
		out.println("<td>"+tel+"</td></tr>");
		out.println("</table>");
		
		
		out.println("</body></html>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
