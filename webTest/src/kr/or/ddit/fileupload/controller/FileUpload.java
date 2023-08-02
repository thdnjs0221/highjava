package kr.or.ddit.fileupload.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.fileupload.service.FIleInfoSeriviceImpl;
import kr.or.ddit.fileupload.service.IFileInfoService;
import kr.or.ddit.fileupload.vo.FileinfoVO;




/*
 *  - Servlet 3.0 이상에서 파일 업로드를 하려면 서블릿에 @MulfipartConfig 애노테이션을 설정해야 한다.
 *  
 *  - @MultipartConfig 애노테이션에서 설정할 변수들
 *     1) location : 업로드한 파일이 임시적으로 저장될 경로를 지정한다.
 *     2) fileSizeThreshold : 이 곳에 지정한 값보다 큰 파일이 전송되면 location에서 지정한
 *                           임시 디렉토리에 파일을 잠시 저장한다.
 *                       (단위 : byte, 기본값 : 0 (무조건 임시 디렉토리 사용))
 *     3) maxFileSize : 1개 파일의 최대 크기 (단위 : byte, 기본값 : -1L (무제한))
 *     4) maxRequestSize : 전체 파일 크기와 파일 이외의 데이터 크기의 합계의 최대 크기
 *                    (단위 : byte, 기본값 : -1L (무제한))
 */

@MultipartConfig(
   fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 30,
   maxRequestSize = 1024 * 1024 * 100
)
@WebServlet("/fileUpload.do")
public class FileUpload extends HttpServlet {
   private static final long serialVersionUID = 1L;
       

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      // GET방식으로 요청하면 FileUpload 폼이 있는 jsp문서로 포워딩 한다.
      request.getRequestDispatcher("/fileupload/fileUpload.jsp").forward(request, response);
      
   }

   // 파일 업로드 작업은 POST방식으로 요청해야만 가능하기 때문에 getPost()메서드에서 작업한다.
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      request.setCharacterEncoding("utf-8");
      
      // 업로드된 파일들이 저장될 폴더 설정
      String uploadPath = "d:/d_other/uploadFiles";
      
      // 저장될 폴더가 없으면 새로 만들어 놓는다.
      File f = new File(uploadPath);
      if(!f.exists()) {
         f.mkdirs();
      }
      
      //------------------------------------------------------------
      
      // 파일이 아닌 일반 데이터는 getParameter()메서드나 getParameterValues()메서드를
      // 이용하여 구한다.
      String userName = request.getParameter("username");
      System.out.println("일반 파라미터 데이터 -> " + userName);
      
      //------------------------------------------------------------
      
      // 업로드된 파일 데이터 처리하기
      String fileName = "";      // 업로드된 파일의 원래의 파일명이 저장될 변수
      
      // 업로드된 파일 목록이 저장될 List객체 생성
      List<FileinfoVO> fileList = new ArrayList<FileinfoVO>();
      
      /*
       - Servlet 3.0 이상에서 파일 업로드와 관련되어 추가된 메서드
            1) request.getParts() : 전체 Part객체를 Collection객체에 담아서 반환한다.
           2) request.getPart("이름") : 저장된 '이름'을 갖는 개별 Part객체를 반환한다.           
       */
      
      // 전체 Part객체 개수 만큼 반복 처리한다.
      for(Part part : request.getParts()) {
         fileName = extractFileName(part);
         
         // 찾은 파일명이 공백문자("")이면 이것은 파일이 아닌 일반 파라미터라는 의미!!
         if(!"".equals(fileName)) {   // 파일인지 검사
            // 1개의 Upload파일 정보가 저장될 FileInfoVO객체 생성
        	 FileinfoVO fileVo = new FileinfoVO();
            
            fileVo.setFile_writer(userName);      // 작성자
            fileVo.setOrigin_file_name(fileName);   // 원래의 파일명
            
            // 실제 저장되는 파일 이름이 중복되는 것을 방지하기 위해서
            // UUID객체를 이용하여 저장할 파일명을 만든다.
            String saveFileName = UUID.randomUUID().toString();
            
            // 이 값을 저장 파일명으로 VO에 저장한다.
            fileVo.setSave_file_name(saveFileName);
            
            // 파일의 크기는 Part객체의 getSize()메서드로 구할 수 있다. (단위 : byte)
            // byte단위의 크기를 KB단위로 변환해서 VO객체에 저장한다.
            fileVo.setFile_size((long)(Math.ceil(part.getSize()/1024.0)));
            
            try {
               // 파일을 저장한다. -> Part객체의 write()메서드를 이용
               //    형식) Part객체.write("저장될 경로/저장될 파일멍");
               part.write(uploadPath + File.separator + saveFileName);   // 파일 저장
               
            } catch (Exception e) {
               e.printStackTrace();
            }
            
            fileList.add(fileVo);   // upload된 파일 정보를 List에 추가한다.
         }
      }
      
      // List에 저장된 FileInfoVO객체들을 DB에 insert한다.
      IFileInfoService service = FIleInfoSeriviceImpl.getInstacne();
      
      for(FileinfoVO fvo : fileList) {
         service.insertFileinfo(fvo);
      }
      
      // 저장이 완료된 후 파일 목록을 보여준다.
      response.sendRedirect(request.getContextPath() + "/fileList.do");
   }
   
   /*
    *  - Part구조
    *     1) 파일이 아닌 일반 파라미터 데이터 일 경우
    *        ------------------sdfjskje2323dfse             -> 각 Part를 구분하는 구분선
    *        content-disposition: form-data; name="username" -> 파라미터명
    *                                            -> 빈줄
    *        홍길동                                 -> 파라미터 값
    *  
    *     2) 파일일 경우
    *        ------------------sdfjskje2323dfse             -> 각 Part를 구분하는 구분선
    *        content-disposition: form-data; name="upFile1"; filename="text01.txt" ->파일정보
    *        content-type: text/plain                  -> 파일 종류
    *                                            -> 빈줄
    *        abcd1234안녕                              -> 파일의 내용
    */
   
   // Part구조 안에서 파일명을 찾는 메서드
   private String extractFileName(Part part) {
      String fileName = "";
      
      String conDisposition = part.getHeader("content-disposition");
      String[] items = conDisposition.split(";");
      for(String item : items) {
         if(item.trim().startsWith("filename")) {
            fileName = item.substring(item.indexOf("=")+2, item.length()-1);
         }
      }
      
      return fileName;
   }

}
