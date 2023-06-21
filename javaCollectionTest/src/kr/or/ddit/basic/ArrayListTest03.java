package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*문제 1) 5명의 별명을 입력받아 ArrayList에 저장하고 이들 중 별명의 길이가 제일 긴 별명을 출력해라 
 *    (단, 별명의 길이는 모두 다르게 입력한다)
 */
public class ArrayListTest03 {
	public static void main(String[] args) {
	      List<String> nicknames =new ArrayList<>();
	      Scanner sc= new Scanner (System.in);
	      
	      for (int i = 1; i <= 5; i++) {
	            System.out.print("입력" + i + ": ");
	            
	           // nicknames.add(sc.next());
	            
	            String nickname=sc.nextLine();
	            nicknames.add(nickname);
	      }      
	      //제일 긴 별명이 저장될 변수를 선언하고 이 변수에는 List의 첫번재 데이터로 초기화 한다.
	        String longestNickname = nicknames.get(0);    
	        for (int i=1; i<nicknames.size(); i++) {
	            if (nicknames.get(i).length()> longestNickname.length()) {
	                longestNickname = nicknames.get(i);
	            }
	        }
	        System.out.println("가장 긴 별명: " + longestNickname);

	    }
	}

