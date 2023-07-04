package kr.or.ddit.basic.stream;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOTest02 {

	public static void main(String[] args) {
		//파일 데이터 출력하기 ==> 바이트 기반 스트림 이용
		try {
			//파일 출력용 스트림 객체 생성 ==> 출력할 파일을 지정해 준다.
			FileOutputStream fout = new FileOutputStream("d:/d_other/out.txt");
			
			for(char c= 'A'; c<='Z'; c++) {
				fout.write(c); //c 변수의 데이터를 파일로 출력한다	
			}
			
			System.out.println("출력 작업 끝...");
			fout.close(); //스트림 닫기
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
