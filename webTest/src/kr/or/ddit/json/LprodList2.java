package kr.or.ddit.json;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.json.service.ILprodService;
import kr.or.ddit.json.service.LprodSeviceImpl;
import kr.or.ddit.json.vo.LprodVO;


@WebServlet("/lprodList2.do")
public class LprodList2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ILprodService serivce = LprodSeviceImpl.getInstance();
		
		//디비에서 원하는 작업을 수행한다(Service객체 이용)
		List<LprodVO> lprodList = serivce.AllLprod();
		
		//작업 결과를 Request객체에 저장한다 
		request.setAttribute("lprodList", lprodList);
		
		//View페이지로 forwarding한다
		request.getRequestDispatcher("/json/lprodView.jsp").forward(request, response);
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
