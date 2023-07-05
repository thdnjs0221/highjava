package kr.or.ddit.basic.stream;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataIOTest {

	public static void main(String[] args) {
		try {
			FileOutputStream fout= new FileOutputStream("d:/d_other/test.data");
			
			//자료형 단위로 출력할 보조 스트림 객체 생성
			DataOutputStream dout = new DataOutputStream(fout);
			
			//자료출력하기
			dout.writeInt(200);  //정수형 데이터 출력
			dout.writeFloat(12.45f); //실수형(float) 데이터 출력
			dout.writeBoolean(false); //논리형 데이터 출력
			dout.writeUTF("ABCDabcd"); //문자열 출력
			
			System.out.println("출력 완료...");
			
			dout.close(); //스트림 닫기
			//-----------------------------------------------------
			System.out.println("--------------------------------------");
			System.out.println();
			
			//출력된 자료 읽어오기
			FileInputStream fin = new FileInputStream("d:/d_other/test.data");
			DataInputStream din = new DataInputStream(fin);
			
			//DataInputStream으로 자료를 읽어 올 때는
			//출력할때의 순서와 같은 순서로 읽어와야한다
			System.out.println("정수형 : "+din.readInt());
			System.out.println("실수형: "+din.readFloat());
			System.out.println("논리형: "+din.readBoolean());
			System.out.println("문자열 "+din.readUTF());
			
			System.out.println("읽기 작업 완료...");
			
			din.close();
			
			
		} catch (IOException e) {
			
		}

	}

}
