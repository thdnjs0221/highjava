package kr.or.ddit.basic.tcp;
/*
 * 클라이언트가 서버와 접속이 완료되면 'd:/d_other/펭귄.jpg'파일을 서버로 전송한다
 * */

import java.awt.Panel;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TcpFileClient {
	
	
	public void clientStart() {
		//전송용 파일 정보를 갖는 File객체 생성
		//File file = new File("d:/d_other/펭귄.jpg"); 
		File file = showDialog("OPEN");
		if(!file.exists()) {
			System.out.println(file.getPath()+"파일이 없습니다...");
			return;
		}
		try {
			Socket socket = new Socket("localhost",7777);
			
			System.out.println("파일전송 시작...");
			
			DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
			
			//서버에 접속하면 첫번째로 파일 이름을 전송한다
			dout.writeUTF(file.getName());
			
			//파일 입력용 스트림 객체 생성
			BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file));
			
			//서버로 전송할 출력용 스트림 객체 생성
			BufferedOutputStream bout = new BufferedOutputStream(dout);
			
			byte[]temp = new byte[1024];
			int length =0;
			
			//파일 내용을 읽어서 소켓으로 출력한다(전송)
			
			while((length=bin.read(temp)) > 0) {
				bout.write(temp, 0, length);
			}
			bout.flush();
			
			System.out.println("파일전송 완료...");
			bin.close();
			bout.close();
			
			
		} catch (Exception e) {
			System.out.println("파일 전송 실패!!!");
			e.printStackTrace();
		}
		
		
	}
	  private File showDialog(String option) {
	      File selectedFile = null;
	      
	      JFileChooser chooser = new JFileChooser();
	      
	      // 보여줄 파일 목록의 확장자 설정하기
	      FileNameExtensionFilter doc = new FileNameExtensionFilter("Word 파일", "docx", "doc", "hwp");
	      FileNameExtensionFilter img = 
	            new FileNameExtensionFilter("이미지 파일", new String[] {"png","jpg","gif"});
	      FileNameExtensionFilter txt = new FileNameExtensionFilter("텍스트 파일", "txt");
	      
	      // '모든 파일' 목록 표시 설정 여부 (true:설정, false:해제)
	      chooser.setAcceptAllFileFilterUsed(true);
	            
	      
	      // 생성한 확장자 목록을 Chooser에 추가한다.
	      chooser.addChoosableFileFilter(doc);
	      chooser.addChoosableFileFilter(img);
	      chooser.addChoosableFileFilter(txt);
	      
	            
	      // Dialog창에 나타날 기본 경로 설정하기
	      chooser.setCurrentDirectory(new File("d:/d_other"));
	      
	      int result;
	      if("SAVE".equals(option.toUpperCase())) {
	         result = chooser.showSaveDialog(new Panel());   // 저장용 창 (SaveDialog)
	      }else if("OPEN".equals(option.toUpperCase())) {
	         result = chooser.showOpenDialog(new Panel());   // 열기용 창 (OpenDialog)
	      }else {
	         System.out.println("option은 'SAVE' 또는 'OPEN'만 가능합니다.");
	         return null;
	      }
	      
	      
	      
	      
	      // Dialog창에서 '저장' 또는 '열기' 버튼을 클릭했을 때 처리하기 (JFileChooser.APPROVE_OPTION)
	      if(result == JFileChooser.APPROVE_OPTION) {
	         selectedFile = chooser.getSelectedFile();   // 선택한 파일 정보 가져오기
	         //System.out.println("선택 파일 : " + selectedFile.getAbsolutePath());
	      }
	      
	      return selectedFile;
	   }
	

	public static void main(String[] args) {
		new TcpFileClient().clientStart();
	      
	   }
	}
