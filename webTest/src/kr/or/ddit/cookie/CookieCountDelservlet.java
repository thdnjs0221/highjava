package kr.or.ddit.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieCountDelservlet.do")
public class CookieCountDelservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		Cookie[] cookieArr = request.getCookies(); // 쿠키배열에 전체 저장해서 가져오기
		out.println("<html><head><meta charset='utf-8'><title>쿠키 정보 삭제하기</title></head>");
		out.println("<body>");

		out.println("<h3>count가 초기화 되었습니다</h3><hr>");

		if (cookieArr != null ) {
			// 쿠키 배열에서 삭제할 쿠키 정보를 찾는다.
			for (Cookie cookie : cookieArr) {
				String name=cookie.getName();
				if("count".equals(name)) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);

				}
				
			}
		}
		out.println("<br>");
		out.println("<a href= '" + request.getContextPath() + "/cookie/cookieTest02.jsp'>" + "시작문서로 이동하기</a>");

		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
