package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

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
	private Scanner scan;
	private HashMap<String, Phone> phoneBookMap;

	public PhoneBookTest() {
		scan = new Scanner(System.in);
		phoneBookMap = new HashMap<String, Phone>();
	}

	// 메뉴를 출력하고 작업 번호를 입력받아 반환하는 메서드
	private int displayMenu() {
		System.out.println();
		System.out.println("==============================");
		System.out.println("1.전화번호 등록");
		System.out.println("2.전화번호 삭제");
		System.out.println("3.전화번호 수정");
		System.out.println("4.전화번호 검색");
		System.out.println("5.전화번호 전체 출력");
		System.out.println("0.프로그램 종료");
		System.out.println("==============================");
		System.out.println(" 번호입력>>");
		return scan.nextInt();

	}

	// 프로그램 시작하는 메서드
	public void phoneStart() {
		System.out.println();
		System.out.println("==============================");
		System.out.println("전 화 번 호 관 리 프 로 그 램");
		System.out.println("==============================");
		System.out.println();
		while (true) {  //true 끝나지 않고  무한반복
			int choice = displayMenu();// '='의 오른쪽 먼저 실행 

			switch (choice) {
			case 1: // 등록
				insert();
				break;
			case 2: // 삭제
				delete();
				break;
			case 3: // 수정
				update();
				break;
			case 4: // 검색
				search();
				break;
			case 5: // 전체 출력
				displayAll();
				break;
			case 0: // 종료
				System.out.println("프로그램 종료합니다");
				return;  //호출한 메인메서드에서 종료.
			default:
				System.out.println("번호 다시 입력하세요");

			}
		}
	}

//정보를 검색하는 메서드
	private void search() {
		System.out.println();
		System.out.println("검색할 전화번호 정보를 입력하세요...");
		System.out.println("이름>>");
		String name = scan.next();

		if (!phoneBookMap.containsKey(name)) {
			System.out.println(name + "씨의 전화번호 정보는 없습니다...");
			return;
		}
		Phone p = phoneBookMap.get(name);
		System.out.println(name + "씨 전화번호 정보");
		System.out.println("------------------------");
		System.out.println("이       름:  " + p.getName());
		System.out.println("전화번호:  " + p.getTel());
		System.out.println("주      소 :  " + p.getAdrr());
		System.out.println("------------------------");
	}

//정보 수정하는 메서드
	private void update() {
		System.out.println();
		System.out.println("수정할 전화번호 정보를 입력하세요....");
		String name = scan.next();

		// 등록된 사람인지 검사
		if (!phoneBookMap.containsKey(name)) {
			System.out.println(name + "씨는 등록되지 않은 사람입니다...");
			return;
		}
		System.out.print("새로운 전화번호>>");
		String newTel = scan.next();

		scan.hasNextLine();//버퍼 비우기 
		System.out.print("새로운 주소>>");
		String newAddr = scan.next();

		// 같은 key값으로 새운 데이터를 추가하면 수정작업이 완료된다.
		phoneBookMap.put(name, new Phone(name, newTel, newAddr));
//		방법 2:		
//		Phone p =phoneBookMap.get(name);
//		p.setTel(newTel);
//		p.setAdrr(newAddr);
//		
		
		System.out.println(name + "씨의 전화번호 정보를 변경했습니다....");

	}

//전체 자료를 출력하는 메서드
	private void displayAll() {
		System.out.println("========================================");
		System.out.println(" --------------------------------------");
		System.out.println(" 번호     이름               전화번호                          주소");
		System.out.println("---------------------------------------");
		System.out.println();

		// Map의 key값들만 모두 가져온다.
		Set<String> phoneKeySet = phoneBookMap.keySet();

		if (phoneKeySet.size() == 0) { //키값이 없으면 
			System.out.println("등록된 전화번호 정보가 하나도 없습니다...");
		} else {
			int num = 0; // 번호
//			Iterator<String> keyIt = phoneKeySet.iterator();
//			while (keyIt.hasNext()) {
//				num++;
//				String key = keyIt.next(); // key값 (이름) 구하기
//				Phone p = phoneBookMap.get(key);
//				; // value값(Phone클래스의 인스턴스) 구하기
//				System.out.println(num + "\t" + p.getName() + "\t" + p.getTel() + "\t" + p.getAdrr());
//			}
			
			//다른방법: 향상된 for문 이용 
			for(String key: phoneKeySet) {
				num++;
				Phone p = phoneBookMap.get(key);// value값(Phone클래스의 인스턴스) 구하기
				System.out.println(num + "\t" + p.getName() + "\t" + p.getTel() + "\t" + p.getAdrr());
				
			}
			
		}
		System.out.println("========================================");
		System.out.println("출력 끝...");
	}

	private void delete() {
		System.out.println();
		System.out.println("삭제할 전화번호 정보를 입력하세요...");
		System.out.print("이름>>");
		String name = scan.next();

		// 등록된 사람인지 검사
		if (!phoneBookMap.containsKey(name)) {
			System.out.println(name + "씨는 등록되지 않은 사람입니다...");
			return;	//밑에 있는 작업은 필요없으므로 return해서 delete메서드 끝내기
					//return을 안쓰려면 else쓰기
		}
		phoneBookMap.remove(name);
		System.out.println(name + "씨의 전화번호 정보를 삭제했습니다...");
	}

//새로운 전화번호 정보를 등록하는 메서드 
	private void insert() {
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요");
		System.out.println("이름>>");
		String name = scan.next();

		// 이미 등록된 사람 인지 검사
		if (phoneBookMap.containsKey(name)) {
			System.out.println(name + "이미 등록된 사람입니다");
			return; //밑에 있는 작업은 필요없으므로 return해서 insert메서드 끝내기
		}
		System.out.println("전화번호>> ");
		String tel = scan.next();
		
		scan.nextLine();//입력 버퍼 비우기
		System.out.println("주소>> ");
		String addr = scan.nextLine();

//		Phone p = new Phone(name, tel,addr);
//		phoneBookMap.put(name, p);
		// 한줄로 쓰는 법
		phoneBookMap.put(name, new Phone(name, tel, addr));

		System.out.println(name + "님 전화번호 등록 완료!!!");

	}

	public static void main(String[] args) {
		new PhoneBookTest().phoneStart();
	}
}

class Phone {
	private String name;
	private String tel;
	private String adrr;

	public Phone(String name, String tel, String adrr) {
		super();
		this.name = name;
		this.tel = tel;
		this.adrr = adrr;
	}

	public Phone() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdrr() {
		return adrr;
	}

	public void setAdrr(String adrr) {
		this.adrr = adrr;
	}

	@Override
	public String toString() {
		return "Phone [name=" + name + ", tel=" + tel + ", adrr=" + adrr + "]";
	}

}
