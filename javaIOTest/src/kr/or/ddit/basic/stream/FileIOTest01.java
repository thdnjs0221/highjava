package kr.or.ddit.basic.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileIOTest01 {

	public static void main(String[] args) {
		//바이트 기반의 파일 입력용 스트림을 이용하여 파일을 읽어와 출력하기 
		try {
			// 파일 입력용 스트림 객체 생성 ==> 객체를 생성할 때 읽어올 파일을 지정한다
			
			//읽어올 파일 지정하는 방법1 ==> 파일의 전체 경로를 문자열로 지정하기
			//FileInputStream fin  =new FileInputStream("d:/d_other/test.txt");
			
			//읽어올 파일 저장하는 방법2 ==> 읽어올 파일 정보를 갖는 File객체로 지정하기
			File file = new File("d:/d_other/test.txt");
			FileInputStream fin = new FileInputStream(file);
		
			int c; //읽어온 데이터가 저장 될 변수 
			
			while( (c=fin.read()) != -1 ) {
				//읽어온 데이터를 화면에 출력하기
				System.out.print((char)c);
			}		
			//작업 완료 후 스트림 닫기
			fin.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
