package kr.or.ddit.basic.tcp;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

//이 클래스는 소켓을 통해서 메세지를 보내는 역할을 담당하는 클래스이다.
public class Sender extends Thread {
	private Socket socket;
	private DataOutputStream dout;
	private String name;
	private Scanner scan;
	
	
	//생성자
	public Sender(Socket socket) {
		this.socket=socket;
		scan = new Scanner(System.in);
		
		try {
			System.out.print("이름 입력>>");
			name=scan.nextLine();
			//전송용(출력용) 스트림 객체 생성
			dout= new DataOutputStream(this.socket.getOutputStream());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	@Override
	public void run() {
		while(dout!=null) {
			try {
				//이름과 입력한 내용을 붙어서 전송한다
				dout.writeUTF(name+":"+scan.nextLine());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
}
