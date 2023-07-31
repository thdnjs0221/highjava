package kr.or.ddit.json;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/jsonController.do")
public class JsonController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//JSON형태의 응답을 보낼 때의 ContentType 설정
		response.setContentType("application/json; charset=utf-8");
		
		String choice = request.getParameter("choice");
		
		Gson gson = new Gson();
		
		String jsonData = null;  //Json형태로 변환된 문자열이 저장될 변수 
		
		switch (choice) {
		case "str":
			String str="안녕하세요 문자열 응답입니다.";  //응답데이터			
			//json 문자열로 변환하기
			jsonData = gson.toJson(str);
			break;
			
		case "array":
			int[]arr= {10,20,30,40,50};
			jsonData = gson.toJson(arr);
			break;
		
		case "object":
			SampleVO samVo= new SampleVO(10,"홍길동");
			jsonData = gson.toJson(samVo);
			break;
			
			
			
		}
		System.out.println("jsonData==> "+jsonData);
		
		//JSON 문자열을 응답으로 보낸다.
		PrintWriter out = response.getWriter();
		
		out.println(jsonData);
		response.flushBuffer();  //혹시 데이터 전송 안된것이 있을까봐 쓰는 것
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
