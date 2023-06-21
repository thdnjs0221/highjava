package kr.or.ddit.basic;
/*문제: 5명의 사람 이름을 입력받아 ArrayList에 저장한 후에
 * 		이들 중 '김'씨 성의 이름을 모두 출력해라
 * 		(단, 입력은 Scanner객체를 이용한다)
 * 
 */

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest02 {
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		
		ArrayList <String> nameList= new ArrayList();
		for(int i=1; i<=5; i++) {
			System.out.println(i+"번째 이름입력>>");
			String name=sc.next();
			nameList.add(name);
		}
		
		for(String irum: nameList) {
			//김길동
			
			//1번째 방법
			//if(irum.substring(0,1).equals("김")) {  //0부터 1번째까지인데 1번째는 포함 시키지 않는다  
			//	System.out.println(irum);		
			//}
			
			//2번째 방법
			//if(irum.charAt(0)=='김') {  //0부터 1번째까지인데 1번째는 포함 시키지 않는다  
			//	System.out.println(irum);		
			//}
			
			//if(irum.startsWith("김")) {  
			//	System.out.println(irum);
			//}
			
			if(irum.indexOf("김")==0) { 
				System.out.println(irum);
			
		}
		}
	}
}
		
		
		
		
		
	


