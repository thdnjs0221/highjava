package kr.or.ddit.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/requestTest01.do")
public class requestTest01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//POST방식으로 전달되는 데이터의 문자 인코딩 방식 설정
		request.setCharacterEncoding("utf-8");
		
		//Request객체.getParameter("파라미터명") ==> 해당 파라미터에 설정된 '값'을 가져온다
		//									==> 가져오는 '값'의 자료형은 'String'이다
		//파라미터명은 태그의  name의 속성값이 파라미터명이 된다 
		
		String userName= request.getParameter("username"); //대소문자 구분해서 잘 쓰기 
		String job= request.getParameter("job");
		
		
		//Request객체 .getParameterValues("파라미터명")==> 파라미터명이 같은 것이 여러개 일 경우에 사용한다.
		//										==> 가져오는 '값'의 자료형은 'String[]'이 된다
		String[] hobbies= request.getParameterValues("hobby"); //jsp name값.
		
		//----------------------------------------------------------------------------

		//출력하기 위한 응답 만들기
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println( "<html><head><meta charset='utf-8'><title>Request객체 연습</title></head>" );
		out.println("<body>");
		
		out.println("<h3>Request 결과</h3>");
		out.println("<table border='1'> ");
		out.println("</tr><td>이름</td>");
		out.println("<td>"+userName+"</td></tr>");
		out.println("<tr><td>직업</td>");
		out.println("<td>"+job+"</td></tr>");
		
		out.println("<tr><td>취미</td>");
		out.println("<td>");
		if(hobbies!=null) {
			//배열의 크기만큼 반복해서 값들을 출력한다 
			for(int i=0; i<hobbies.length; i++) {
				out.println(hobbies[i]+"<br>");
			}
			out.println("<hr>");
			//향상된 for문
			for(String hobby:hobbies) {
				out.println(hobby+"<br>");
			}
		}
		out.println("</td></tr>");		
		out.println("</table>");
		out.println("<hr>");
		
		out.println("<h3>Request객체의 메서드들</h3>");
		out.println("<ol>");
		
		out.println("<li>클라이언트의 IP주소: "+request.getRemoteAddr()+"</li>");
		out.println("<li>요청 메서드: "+request.getMethod()+"</li>");
		out.println("<li>Context Path: "+request.getContextPath()+"</li>");
		out.println("<li>프로토콜: "+request.getProtocol()+"</li>");
		out.println("<li> URL정보: "+request.getRequestURL()+"</li>");
		out.println("<li> URI정보:"+request.getRequestURI()+"</li>");
		
		
		out.println("</ol>");
		
		out.println("</body></html>");
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
