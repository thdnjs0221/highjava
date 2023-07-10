package kr.or.ddit.basic.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
	UDP방식: 비연결 지향, 데이터에 신뢰성이 없다.데이터 순서대로 도착한다는 보장이 없다.
		그렇지만 TCP방식보다 속도가 빠르다
	
	DatagramSocket객체와 DatagramPacket객체를 이용하여 통신한다.
	-DatagramSocket: 데이터의 송수신과 관련된 작업을 수행한다.(우체부 역할)
	-DatagramPacket: 주고 받는 데이터와 관련된 작업을 수행한다.(소포, 편지)
				==> 수신용 생성자와 송신용 생성자를 따로 제공한다.
				
	TCP의 경우에는 스트림객체를 이용하여 데이터를 송수신하지만 ,
	UDP의 경우에는 데이터그램을 이용하여 송수신한다.
	
*/

public class UdpServer {

	public static void main(String[] args) {
		try {
			//통신할 포트번호를 지정해서 소켓을 생성한다.
			DatagramSocket socket = new DatagramSocket(8888);
			System.out.println("서버 실행 중...");
			System.out.println();
			
			while(true) {
				//수신한 데이터가 저장될 byte형 배열 선언
				byte [] bMsg = new byte[512]; //바이트 크기는 맘대로 지정
				
				//수신용 패킷 객체 생성
				//==> 수신한 데이터가 저장될 byte형 배열, 배열의 길이를 지정하여 생성한다.
				DatagramPacket inpacket = new DatagramPacket(bMsg, bMsg.length);
				
				//데이터를 수신한다 ==> receive()메서드 이용
				//	receive()메서드 수신용 패킷을 지정하여 호출한다.
				//  이 메서드 는 데이터가 올 때까지 기다린다.
				//  수신된 데이터의 패킷정보는 지정한 수신용 패킷변수에 저장된다.(inpacket에 데이터 들어있다)
				socket.receive(inpacket);   //통과하면 데이터를 받았다는 의미 
				
				//수신 받은 패킷에서 상대방의 주소, 포트번호등을 알 수 있다.
				InetAddress address= inpacket.getAddress(); //상대방 ip 얻기
				int port = inpacket.getPort();
				
				System.out.println("상대방의 IP 정보: "+address);
				System.out.println("상재방의 port 번호: "+port);
				System.out.println();
				
				//상대방이 보낸 메시지 출력하기
				//inpacket.getLength()==> 실제 읽어온 데이터의 길이를 반환한다.
				//inpacket.getData() ==> 실제 읽어온 데이터를 byte형 배열로 반환한다.
				//				실제 읽어온 데이터는 수신용 패킷객체를 생성할 때 지정한 byte형 배열에도 저장된다.=bMsg
				
				//= String msg = new String(inpacket.getData(),0,inpacket.getLength(), "utf-8");
				String msg = new String(bMsg,0,inpacket.getLength(), "utf-8");
				
				if("/end".equals(msg)) {
					break;
				}
				
				System.out.println("상대방이 보낸 메세지 : "+msg);
				System.out.println();
				
				//----------------------------------------------------------
				//상대방에게 메세지 보내기(수신 받은 메세지를 그대로 송신한다.)
				
				//송신할 메세지를 byte형 배열로 변환한다.
				byte[]sendMsg = msg.getBytes("utf-8"); 
				
				//송신용 패킷객체 생성
				//	==> 전송할 데이터가 저장된 byte형 배열, 전송할  데이터의 길이(배열의 길이),
				//  	상대방의 주소 정보, 포트번호를 지정해서 객체를 생성한다.
				DatagramPacket outpacket = 
						new DatagramPacket(sendMsg, sendMsg.length,address,port);
				
				//데이터 송신하기 ==> send()메서드 이용
				//		send()메서드에 송신용 패킷을 지정해서 호출한다.
				socket.send(outpacket);
				System.out.println("송신 완료...");
				System.out.println();
				
		
			}//while문 끝...
			System.out.println("서버 끝...");
			socket.close();
			
	
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
