package kr.or.ddit.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requestTest02.do")
public class requestTest02 extends HttpServlet {
	
	//post방식으로 처리해도 get방식 처리하는것과 똑같으면 
	//doGet(request, response); <- 부르기
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// POST방식으로 전달되는 데이터의 문자 인코딩 방식 설정
		request.setCharacterEncoding("utf-8");

		// Request객체.getParameter("파라미터명") ==> 해당 파라미터에 설정된 '값'을 가져온다
		// ==> 가져오는 '값'의 자료형은 'String'이다
		// 파라미터명은 태그의 name의 속성값이 파라미터명이 된다

		String strNum1 = request.getParameter("num1"); // 대소문자 구분해서 잘 쓰기
		String strNum2 = request.getParameter("num2");
		String op = request.getParameter("op");
		
		int num1=Integer.parseInt(strNum1);
		int num2=Integer.parseInt(strNum2);
		
		double res =0; //계산 결과가 저장될 변수 선언
		boolean calcOK= true; //계산의 성공 여부를 나타내는 변수  (true성공, false실패)
		

		// Request객체 .getParameterValues("파라미터명")==> 파라미터명이 같은 것이 여러개 일 경우에 사용한다.
		// ==> 가져오는 '값'의 자료형은 'String[]'이 된다
		// String[] hobbies= request.getParameterValues("hobby"); //jsp name값.

		// ----------------------------------------------------------------------------



		if (op.equals("+")) {
			res=num1+num2;
		
		} else if (op.equals("-")) {
			res=num1-num2;
			//out.print("<p>" + num1  + op + num2 + " = " + res + "</p> ");
		}else if(op.equals("*")) {
			res=num1*num2;
			
		}else if(op.equals("/")) {
			
			if(num2==0) {
				calcOK=false;
			}else {
				res=(double)num1/num2;
			}
			
		}else if(op.equals("%")) {
			if(num2==0) {
				calcOK=false;
			}else {
				res=num1%num2;
			}
		}
		
		// 출력하기 위한 응답 만들기
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		PrintWriter out = response.getWriter();
		out.println("<html><meta charset='utf-8'>");
		
		out.print("<body>");
		
		out.println("<h3>계산 결과</h3>");
		out.println("<hr>");
		out.printf("%d %s %d =",  num1, op, num2);
		
		if(calcOK) { //계산 성공
			out.println(res+"<br>");
		}else {
			out.println("계산 불능(0으로 나누기)<br>");
		}
		out.println("</body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
