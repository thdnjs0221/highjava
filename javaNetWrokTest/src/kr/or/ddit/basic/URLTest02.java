package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class URLTest02 {
   public static void main(String[] args) throws IOException {
      // URLConnection클래스 ==> 애플리케이션과 URL 간의 통신연결을 위한 클래스

      // 특정 서버의 정보와 파일의 내용을 가져와 출력하는 예제
      URL url = new URL("https://www.naver.com/index.html");
      
      //URLConnection 객체 구하기
      URLConnection urlCon = url.openConnection();
      
      //Header 정보 가져오기
      Map<String, List<String>> headerMap = urlCon.getHeaderFields();

      //Header 정보 출력
      for(String headerKey : headerMap.keySet()) {
         System.out.println(headerKey + " : " + headerMap.get(headerKey));
      }

      System.out.println("----------------------------------------------------------------------");
      System.out.println();
      
      //해당 문서의 내용을 가져오기(index.html 문서의 내용 가져오기)
      
      //방법1) URLConnection 객체를 이용하는 방법 = getInputStream()메서드 이용
      /*
      // 파일 내용을 가져오기 위한 스트림 객체 생성
      InputStream in = urlCon.getInputStream(); //바이트 기반의 스트림을 구함
      InputStreamReader isr = new InputStreamReader(in,"utf-8");
      BufferedReader br = new BufferedReader(isr);
      
      //파일 내용을 읽어와 출력하기      
     while(true) {
    	 String str= br.readLine(); //한 줄씩 읽어오기
    	
    	 if(str==null) break;
    	
    	 System.out.println(str);
     }
     br.close();
	*/
      
     //방법2==> URL객체의 openStream()메서드 이용하기
      InputStream in2= url.openStream();//바이트 기반의 입력용 스트림 구할수있음
      BufferedReader br2 = new BufferedReader(new InputStreamReader(in2, "utf-8")); //1줄로 쓰는 방법
      
      while(true) {
    	  String str = br2.readLine();
    	  if(str== null) break;
    	  System.out.println(str);
      }
      br2.close();
     
     

   }
           
}