package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 문제 2) 5명의 별명을 입력받아 ArrayList에 저장하고 이들 중 별명의 길이가 제일 긴 별명을 출력해라 
 *   (단, 별명의 길이가 같을수있다) 긴별명이 여러개 나올수 있다
 */

public class ArrayListTest04 {
	
public static void main(String[] args) {
	 List<String> nicknames =new ArrayList<>();
     Scanner sc= new Scanner (System.in);
     
     for (int i = 1; i <= 5; i++) {
           System.out.print("입력" + i + ": ");
           
          // nicknames.add(sc.next());
           
           String nickname=sc.nextLine();
           nicknames.add(nickname);
     }      
     System.out.println();
     
     //제일 긴 별명의 길이가 저장될 변수를 선언하고 첫번째 별명의 길이로 초기화한다.
      int maxLength=nicknames.get(0).length();
      for(int i=1; i<nicknames.size(); i++) {
    	  if(maxLength<nicknames.get(i).length()) {
    		  maxLength=nicknames.get(i).length();
      }
      
}
      System.out.println("제일 긴 별명들");
      for(int i=0; i<nicknames.size(); i++) {
    	  if(maxLength==nicknames.get(i).length()) {
    		  System.out.println(nicknames.get(i));
    	  }
      }
}
}


