package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 이 예제는 배포 서술자(DD, Deployment, Descriptor==> web.xml)를 이용해서 실행할 
 * Servlet을 설정하여 처리하는 예제
 * 
 * http://localhost:80/webTest/servletTest01.do
 * -http ==> 프로토콜
 * -localhost==> 컴퓨터이름(도메인명) 또는 IP주소
 * -80 ==> 포트번호 (80번은 생략 가능)
 * -/webTest==> 컨텍스트 패스 (보통 프로젝트 이름으로 지정한다) 
 * -/servletTest01.do ==> 서블릿 요청 URL패턴 
 * 
 * 
 */

//서블릿 클래스는 HttpServlet상속해서 작성한다
public class ServletTest01 extends HttpServlet {
	//이 서블릿 클래스는 service()메서드 또는 doGet()메서드나 doPost()메서드를 재정의해서 작성한다
	
	//doGet()메서드나 doPost()메서드는 service()메서드를 통해서 호출된다
	//HttpServletRequest객체==> 서비스 요청에 관련된 정보 및 메서드를 관리하는 객체
	//HttpServletResponse객체==> 서비스 응답에 관련된 정보 및 메서드를 관리하는 객체 
	
	//doGet()메서드 ==> Get방식의 요청을 처리하는 메서드
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8"); //응답 문서의 인코딩 방식 지정
		response.setContentType("text/html; charset=utf-8");//응답 문서의 ContentType지정
		
		//처리한  내용을 응답으로 보내기 위해 PrintWriter객체를 생성한다 
		PrintWriter out = response.getWriter();
		
		//처리한 내용을 출력한다 
		//방법1) append()메서드 이용하기 
		out.append("<html>")
		.append("<head><meta charset='utf-8'>")
		.append("<tite>첫번째 Servlet연습</tite></head>")
		.append("<body>")
		.append("<h2 style='text-align: center;'>안녕하세요 첫번째 Servlet프로그램 입니다 </h2>")
		.append("</body></html>");
	}
	
	//doPost()메서드 ==> POST방식의 요청을 처리하는 메서드
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
	}

}
