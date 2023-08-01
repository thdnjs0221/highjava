package kr.or.ddit.json.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.json.service.ILprodService;
import kr.or.ddit.json.service.LprodSeviceImpl;
import kr.or.ddit.json.vo.LprodVO;
import sun.print.resources.serviceui;


@WebServlet("/lprodList.do")
public class LprodList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		
		ILprodService service = LprodSeviceImpl.getInstance();
		List<LprodVO> list = service.AllLprod();
		
		
		
		Gson gson = new Gson();
	
		
		String jsonData = gson.toJson(list);
		
		//Json 문자열 응답
		
		
		out.write(jsonData);
		response.flushBuffer();
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
