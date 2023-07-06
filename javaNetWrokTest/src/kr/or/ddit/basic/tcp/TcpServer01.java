package kr.or.ddit.basic.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer01 {

	public static void main(String[] args) throws IOException {
		
		// TCP소켓 통신을 위해서 ServerSocket객체를 생성한다
		ServerSocket server = new  ServerSocket(7777); //포트번호
		
		System.out.println("클라이언트의 접속을 기다립니다...");
		
		//accept()메서드    => 클라이언트에서 연결 요청이 올 때까지 계속 기다린다.
		//				=> 연결 요청이 오면 새로운 Socket객체를 생성해서 클라이언트의 Socket과
		//					연결하고 , 연결된 Socket객체를 반환한다.
		
		Socket socket = server.accept();
		
		
		//accept()메서드 명령 이후는  클라이언트와 연결된 후 처리할 내용을 기술하면 된다.
		System.out.println();
		System.out.println("클라이언트와 연결 되었습니다");
		System.out.println();
		
		//Socket객체를 이용하여 상대방의 정보를 구할 수 있다.
		System.out.println("상대방의 정보 확인...");
		System.out.println("IP 주소: "+socket.getInetAddress().getHostAddress());
		System.out.println("Port번호: "+socket.getPort());
		System.out.println();
		
		//자신의 정보도 구할 수 있다.
		System.out.println("자기자신의 정보 확인...");
		System.out.println("IP 주소: "+socket.getLocalAddress());
		System.out.println("port 번호: "+socket.getLocalPort());
		System.out.println();
		
		//-------------------------------------------------------------------
		
		//클라이언트에게 메세지 보내기 ==> Socket의 OutputStream객체를 이용하여 보낸다.
		OutputStream out = socket.getOutputStream(); //소켓의 OutputStream객체 구하기
		DataOutputStream dout = new DataOutputStream(out); //
		
		//클라이언트에게 메세지 전송
		dout.writeUTF("환영합니다 어서오세요!"); //서버에서 클라이언트로 보낸 데이터
		
		System.out.println("메세지를 보냈습니다..");
		
		
		//소켓과 스트림 닫기		
		dout.close();
		socket.close();
		server.close();
		
		
		
		
		
		
		
		
		
		
	}

}
