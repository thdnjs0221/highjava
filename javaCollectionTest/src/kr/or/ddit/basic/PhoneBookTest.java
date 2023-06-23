package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Scanner;

/*
 * 문제) 이름 , 전화번호, 주소, 멤버로 갖는 Phone클래스를 만들고 
 *  Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
 *  (Map의 구조는 key값으로 '이름'을 사용하고 value값으로 'Phone클래스의 인스턴스'로한다)
 *   폰객체로 만든 value값으로,,/
 *   
 *   HashMap<String, Phone>변수명;
 *   
 *  아래 메뉴를 구현하시오. 
 *  1.전화번호 등록
 *  2.전화번호 삭제
 *  3.전화번호 수정
 *  4.전화번호 검색
 *  5.전화번호 전체 출력
 *  0.프로그램 종료
 *  
 *  삭제, 검색기능은 '이름을 '입력받아 처리한다
 * --------------------------------------------------
 * 실행예시)
 * ==============================
 *  1.전화번호 등록
 *  2.전화번호 삭제
 *  3.전화번호 수정
 *  4.전화번호 검색
 *  5.전화번호 전체 출력
 *  0.프로그램 종료
 * ==============================
 * 번호입력>> 1
 * 
 * 새롭게 등록할 전화번호 정보를 입력하세요.
 * 이름>> 홍길동(key값)
 * 전화번호>>010-1234-5678
 * 주소>>대전시 중구 오류동
 * 
 * '홍길동' 전화번호 등록 완료!!
 * 새롭게 등록할 전화번호 정보를 입력하세요
 * 이름>>홍길동
 * 
 * '홍길동은 이미 등록된 사람 입니다'
 * 
 * ==============================
 *  1.전화번호 등록
 *  2.전화번호 삭제
 *  3.전화번호 수정
 *  4.전화번호 검색
 *  5.전화번호 전체 출력
 *  0.프로그램 종료
 * ==============================
 * 번호입력>> 5
 * ------------------------------
 * 번호     이름      전화번호         주소
 * 1	홍길동	010-1234-5678	대전시 중구 오류동
 * ~~
 * ==============================
 *  1.전화번호 등록
 *  2.전화번호 삭제
 *  3.전화번호 수정
 *  4.전화번호 검색
 *  5.전화번호 전체 출력
 *  0.프로그램 종료
 * ==============================
 * 번호입력>> 5
 * 
 * 
 * 
 * */

public class PhoneBookTest {
	
	
	public static void main(String[] args) {
		Scanner scan=new Scanner (System.in);
		System.out.println("1.전화번호 등록");
		System.out.println("2.전화번호 삭제");
		System.out.println("3.전화번호 수정");
		System.out.println("4.전화번호 검색");
		System.out.println("5.전화번호 전체 출력");
		System.out.println("0.프로그램 종료");
		int num=scan.nextInt();	
		switch(num) {
		case 1:
			phoneNum();
		}
		}
		
	
		private static void phoneNum(){
			
	Scanner scan=new Scanner (System.in);
	System.out.println("전화번호 등록:");
	Person p1=new Person();
	HashMap<String,Person> pb=new HashMap<>();
	String name=scan.nextLine();
	int num=scan.nextInt();
	pb.put(name,p1.);
	
	
	
	
	
	
	}
}
class Person{
String name;
int tel;
String add;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getTel() {
	return tel;
}
public void setTel(int tel) {
	this.tel = tel;
}
public String getAdd() {
	return add;
}
public void setAdd(String add) {
	this.add = add;
}


	
}

