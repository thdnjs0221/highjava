package kr.or.ddit.basic.file;

import java.io.File;

public class FileTest02 {
	
	public static void main(String[] args) {
		File f1 = new File("d:/d_other/test.txt");
		System.out.println(f1.getName()+"의 파일 크기 : "+f1.length()+"bytes"); 
		System.out.println();
		
		System.out.println("path: "+f1.getPath()); //지정해준 경로
		System.out.println("absolutePath: "+ f1.getAbsolutePath()); //절대 경로
		System.out.println();
		
		//이클립스를 이용하여 JAVA프로그램을 실행하면 실행된 JAVA프로그램이  소속된 project폴더가 현재 폴더가 된다.
		
		File f2= new File("."); //현재위치
		System.out.println("path: "+f2.getPath());
		System.out.println("absolutePath: "+ f2.getAbsolutePath());
		System.out.println();
		
		
		
		
	}

}
