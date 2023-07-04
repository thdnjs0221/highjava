package kr.or.ddit.basic.stream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedIOTest01 {

	public static void main(String[] args) {
		// Buffered스트림 사용 예제
		
		try {
			FileOutputStream fout = new FileOutputStream("d:/d_other/bufferTest.txt");
			
			//버퍼의 크기가 5인 버퍼스트림 객체 생성
			BufferedOutputStream bout = new BufferedOutputStream(fout,5);
			
			for(int i='1'; i<='9'; i++) {
				bout.write(i);
			}
			//bout.flush(); //작업을 종료하기 전에 버퍼에 남아 있는 데이터를 모두 출력 시킨다.
			
			//fout.close();
			bout.close();	//보조 스트림을 닫으면 보조 스트림에서 사용한 기반 스트림도 같이 닫힌다.
							//버퍼의 close()는 flush()기능도 있다.
			
			
			System.out.println("작업 끝...");
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}
