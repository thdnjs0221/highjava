package kr.or.ddit.reqNresp;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// controller-servlet
// vo-> foward??
@WebServlet("/responseTest02.do")
public class ResponseTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 -redirect
		 	다른페이지로 이동하는 것을 말한다
		 	현재 페이지의 응답시 브라우저에게 '이동할 URL'을 전송하여 브라우저가 
		 	해당 URL로 자동으로 요청하는 방식이다
		 	이 떄 요청은 GET방식으로의 요청이기 때문에 URL의 길이에 제한이 있다
		 */
	/*	
	    // redirect방식의 이동은 Response객체의 sendRedirect()메서드를 이용하여 처리한다.
		// 형식) Response객체.sendRedirect("이동할 URL");
		//	이 때 '이동할 URL'은 전체 주소를 지정해 주어야 한다.
		//  '이동할 URL'주소에 한글이 포함될 경우에는 해당 한글을 URLEncoder를 이용하여 
		//	인코딩해서 지정해 주어야한다.
	 
	 	//공유가 안됨....
		// redirect방식에서는 HttpServletRequest객체와 HttpServletResponse객체를 
		// 서로 공유하지 못한다(브라우저에서 새롭게 요청하기 때문에...)
		
		request.setAttribute("tel", "010-9999-8888");
		
		
		response.sendRedirect("/webTest/redirectTest.do");
		
	*/	
		request.setCharacterEncoding("utf-8");
		
		//파라미터 데이터를 받는다.
		String userName = request.getParameter("username");
		
		//redirect로 데이터를 보내려면 GET방식으로 구성해서 보낸다.
		response.sendRedirect("/webTest/redirectTest.do?username=" +URLEncoder.encode(userName, "utf-8")
								 + "&mytel=010-9999-8888");
		//다른페이지 보여주고 싶을때 
		//게시판에 글쓰기를할때 작성폼에서 저장버튼 누르면 리스트 보여주는 페이지 가고싶을때 Redirect방식사용!
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
