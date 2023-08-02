package kr.or.ddit.fileupload.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.fileupload.service.FIleInfoSeriviceImpl;
import kr.or.ddit.fileupload.service.IFileInfoService;
import kr.or.ddit.fileupload.vo.FileinfoVO;


//디비에 저장된 전체 파일목록을 가져와 view로 보내는 servlet
@WebServlet("/fileList.do")
public class FileList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Service 객체 생성
		IFileInfoService service = FIleInfoSeriviceImpl.getInstacne();
		
		//전처 파일 목록을 가져와서  List에 담아준다 
		List<FileinfoVO> fileList = service.getAllFileInfo();
		
		//구해진 전체 파일 목록을 view페이지로 보낸다 (포워딩 방식)

		request.setAttribute("fileList", fileList);
		request.getRequestDispatcher("/fileupload/fileList.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
