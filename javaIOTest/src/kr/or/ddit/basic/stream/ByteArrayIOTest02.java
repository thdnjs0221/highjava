package kr.or.ddit.basic.stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest02 {

	public static void main(String[] args) {
		byte[] inSrc= {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		byte[] outSrc=null;
		
		byte[] temp= new byte[4]; //4개 짜리 배열 생성
		
		ByteArrayInputStream bin = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		
		try {
			//읽어올 데이터가 있는지 확인
			while(bin.available()>0) {
//				bin.read(temp); //배열개수만큼 출력
//				bout.write(temp);
				
				int len = bin.read(temp);  //실제 읽어온 데이터의 개수를 반환한다
				
				//temp배열의 데이터 중 0번째 부터 len개수만큼 출력한다.
				bout.write(temp,0,len); //
				
				System.out.println("반복문 안에서 temp=>"+Arrays.toString(temp));
				
			}			
			outSrc = bout.toByteArray(); //출력할 데이터 배열에 담기
			
			bin.close();
			bout.close();
			
			System.out.println();
			System.out.println("inSrc=>"+Arrays.toString(inSrc));
			System.out.println("outSrc=> "+Arrays.toString(outSrc));
					
		} catch (IOException e) {
			
		}

	}

}
