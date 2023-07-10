package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpMultiChatClient {

	public static void main(String[] args) {
		new TcpMultiChatClient().clientStart();

	}
	
	
	//시작 메서드
	public void clientStart() {
		Socket socket = null;
		try {
			socket= new Socket("192.168.35.28",7777);
			System.out.println("서버에 연결이 되었습니다");
			System.out.println();
			//--------------------------------------------
			//전송용 쓰레드 객체 생성
			ClientSender sender= new ClientSender(socket);
			
			//수신용 쓰레드 객체 생성
			ClientReceiver receiver = new ClientReceiver(socket);
			
			sender.start();
			receiver.start();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}//시작 메서드 끝...
	
	
	//-------------------------------------------------------
	//메시지 전송용 쓰레드 
	class ClientSender extends Thread{
		private Socket socket;
		private DataInputStream din;
		private DataOutputStream dout;
		
		
		private String name;
		private Scanner scan;
		
		//생성자
		public ClientSender(Socket socket) {
			this.socket = socket;
			scan= new Scanner(System.in);
			
			try {
				din = new DataInputStream(this.socket.getInputStream());//수신용
				dout= new DataOutputStream(this.socket.getOutputStream());//송신용

				if(dout!= null) {
					while(true) {
						//클라이언트용 프로그램은 처음 실행하면 서버에 접속하고 접속에 성공함녀
						//첫번째로 '대화명'을 입력 받아 전송하고 '대화명'의 중복 여부를 
						//응답으로 받아서 확인한다.
						System.out.println("대화명>> ");
						String name= scan.nextLine();
						dout.writeUTF(name); //대화명 전송

						//대화명 중복 여부를 응답으로 받는다 
						String feedBack = din.readUTF();
						
						if("대화명중복".equals(feedBack)) { //대화명이 중복될때....
							System.out.println(name+"은 중복되는 대화명입니다...");
							System.out.println("다른 대화명을 입력하세요...");
							System.out.println();
						}else {//대화명이 중복되지 않을 때..
							this.name = name;
							System.out.println(name+"대화명으로 대화방에 접속했습니다..");
							break; //반복문 탈출..
						}
						
						
					}//while문 끝...
					
					
				}//if문 끝...
				
			} catch (Exception e) {
				
			}
			
		}//생성자 끝
		@Override
		public void run() {
			try {
				while(dout!=null) {
					//키보드로 입력한 메시지를 서버로 전송한다.
					dout.writeUTF("["+this.name+"]"+scan.nextLine());
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	
	
	//메시지 수신용 쓰레드
	class ClientReceiver extends Thread{
		private Socket socket;
		private DataInputStream din;
		
		//생성자
		public ClientReceiver(Socket socket) {
			this.socket= socket;
			
			try {
				din= new DataInputStream(this.socket.getInputStream());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}//생성자 끝..
		
		@Override
		public void run() {
			try {
				while(din!=null) {
					//서버에서 받은 메세지를 화면에 출력한다
					System.out.println(din.readUTF());
				}
			} catch (Exception e) {
				
			}
		}
		
	}
}
