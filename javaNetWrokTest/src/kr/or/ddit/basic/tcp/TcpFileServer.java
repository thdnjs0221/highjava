package kr.or.ddit.basic.tcp;
/*
 * 서버는 클라이언트가 보낸 파일을 받아서 'd/d_other/upload/펭귄.jpg'폴더에 저장한다.
 * */

import java.awt.Panel;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TcpFileServer {
	public void severStart() {
		//저장할 폴더 정보를 갖는 File객체 생성
		File saveDir = new File("d:/d_other/upload");
		if(!saveDir.exists()) { //저장할 폴더가 없으면,,,
			saveDir.mkdirs();
		}
		try {
			ServerSocket server = new ServerSocket(7777);
			System.out.println("서버가 준비 중입니다...");
			
			Socket socket = server.accept(); //클라이언트의 요청을 기다린다
			
			System.out.println("파일 수신 시작...");
			
			//수신용 스트림객체 생성
			DataInputStream din = new DataInputStream(socket.getInputStream());
			
			//클라이언트가 첫번째로 보낸 파일명을 받는다
			String filename = din.readUTF();
			
			File file = new File (saveDir, filename); //저장할 파일 정보를 갖는 File객체 생성
			
			BufferedInputStream bin = new BufferedInputStream(din);
			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(file));
			
			byte[] temp = new byte[1024];//맘대로 지정
			int len =0;
			
			//클라이언트가 소켓으로 보낸 데이터를 받아서 파일로 저장한다
			while((len=bin.read(temp)) > 0) {
				bout.write(temp, 0, len);
				
			}
			bout.flush();
			System.out.println("파일 수신 작업 완료....");
			
			
			
		} catch (IOException e) {
			System.out.println("파일 수신 작업 실패!!!");
			e.printStackTrace();
		}
		
	}
	 
	
	public static void main(String[] args) {
		new TcpFileServer().severStart();
	}

}
