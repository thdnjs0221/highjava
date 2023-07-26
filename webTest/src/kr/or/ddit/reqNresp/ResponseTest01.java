package kr.or.ddit.reqNresp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//a

@WebServlet("/responseTest01.do")
public class ResponseTest01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		  -forward 방식
		  	1) 특정 문서에 대한 요청을 다른 서블릿이나 JSP로 넘겨준다.
		  	   (이 때  HttpServletRequest객체와 HttpServletResponse객체를 공유한다)
		  	2) 클라이언트의 요청 URL주소는 처음 요청할 때의 주소가 바뀌지 않는다.
		  	3) 서버 내부에서만 접근이 가능하다.
		  	
		 */
		
		//현재 페이지에서 만든 데이터를 이동하는 페이지로 전달 할 수 있다.
		//방법) Request객체의 setAttribute()메서드로 데이터를 셋팅하여 보내고 
		//		받는 쪽에서는 getAttribute()메서드로 데이터를 읽어온다
		//보낼때 형식) Request객체.setAttribute("key 값",데이터);
		//			==> 'key값'은 문자열로 지정하고 '데이터'는 Java의 모든 자료를 사용할 수 있다.
		
		request.setAttribute("tel", "010-1234-5678");
		
		//forward방식으로 이동하기
		//1. Request객체의 getRequestDispatcher()메서드에 이동할 서블릿이나 JSP를 지정해 준다.
		//	(이 때 지정하는 주소는 전체 URI경로 중에서 ContextPath 이후의 경로를 지정해준다)
		// 이동할 URI주소가 'webTest/fowardTest02.do -> webTest(ContextPath)를뺴고 뒷부분 써주기 
		RequestDispatcher rd = request.getRequestDispatcher("/forwardTest.do");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
