package kr.or.ddit.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;


@WebServlet("/signup.do")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPass");
		String userName = request.getParameter("userName");
		String userTel = request.getParameter("userTel");
		String userAddr = request.getParameter("userAddr");
		
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(userId);
		memVo.setMem_pass(userPw);
		memVo.setMem_id(userName);
		memVo.setMem_id(userTel);
		memVo.setMem_id(userAddr);
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		int signup = service.insertMember(memVo);
		
		HttpSession session = request.getSession();
		
		if(signup>0) {
			//??
			session.setAttribute("SIGNUP", signup);
		}
		request.getRequestDispatcher("/signup/signup.jsp").forward(request, response);
	
	}

}
