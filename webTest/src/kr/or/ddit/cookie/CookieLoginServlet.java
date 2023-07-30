package kr.or.ddit.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookieLoginServlet.do")
public class CookieLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//userid, userpass ,chkid값 받기
		String userId = request.getParameter("userid");
		String userPass = request.getParameter("userpass");
		String chikd=request.getParameter("chikd");
		
		//체크가 되면 데이터가 가고 아니면 안감
		// userId를 쿠키값으로 갖는 Cookie 객체 생성(쿠키이름: USERID)
		Cookie userCookie = new Cookie("USERID", userId);
		
		System.out.println("체크박스의 체크여부: "+chikd); //확인용
		
		//체크박스의 체크 여부에 따라 쿠키 저장확인
		if(chikd!=null) {//체크박스가 체크되었을때
			response.addCookie(userCookie); //쿠키 저장
		}else {
			userCookie.setMaxAge(0);
			response.addCookie(userCookie);//쿠키 삭제
		}
		if("test".equals(userId) && "1234".equals(userPass)) { //로그인 성공
			response.sendRedirect(request.getContextPath()+"/cookie/cookieMain.jsp"); //Redirect
			
		}else {
			response.sendRedirect(request.getContextPath()+"/cookie/cookieLogin.jsp");
		}
		
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
