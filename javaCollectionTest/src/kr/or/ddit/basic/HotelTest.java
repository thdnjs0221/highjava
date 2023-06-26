package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class HotelTest {
	private Scanner scan;
	private HashMap<Integer, Room> hotelMap;
	
	
	public HotelTest() {
		scan=new Scanner(System.in);
		hotelMap=new HashMap<Integer, Room>();
	}
	
	
	public static void main(String[] args) {
		new HotelTest().Start();
	
	}
	private int displayMenu() {
		System.out.println("-----------------------------------------------------------");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료");
		System.out.println("-----------------------------------------------------------");
		System.out.println("선택>>");
		return scan.nextInt();
		
	}
	
	public void Start() {
		System.out.println("********************************************");
		System.out.println("호텔문을 열었습니다. 어서오십시요.");
		System.out.println("********************************************");
		
		while(true) {
			int choice=displayMenu();
			
		switch(choice) {
		case 1: 
			checkIn();
			break;
		case 2:
			checkOut();
			break;
		case 3: 
			break;
		case 4:
			System.out.println("*********************************************");
			System.out.println("호텔문을 닫았습니다.");
			System.out.println("*********************************************");
		}
		}
	}
	private void checkIn() {
		System.out.println("----------------------------------------------");
		System.out.println(" 체크인 작업");
		System.out.println("----------------------------------------------");
		System.out.println(" * 201~209 : 싱글룸");
		System.out.println(" * 301~309 : 더블룸");
		System.out.println(" * 401~409 : 스위트룸");
		System.out.println("----------------------------------------------");
		System.out.println("방 번호 입력 >>");
		int num=scan.nextInt();
		if(!hotelMap.containsKey(num)) {
			System.out.println(num+"객실은 존재하지 않습니다.");
		}
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.println("이름 입력 >> >>");
		String name= scan.next();
	
		hotelMap.put(num, new Room(num,name,kind));
		
		
	}
	private void checkOut() {
		Set<Integer>RoomKeySet=hotelMap.keySet();
		
		System.out.println("----------------------------------------------");
		System.out.println("체크아웃 작업");
		System.out.println("----------------------------------------------");
		System.out.println("체크아웃 할 방 번호를 입력하세요.");
		System.out.println("방번호 입력 >>");
		int num=scan.nextInt();
		if(!hotelMap.containsKey(num)) {
			System.out.println(num+"객실은 존재하지 않습니다.");
			return;
		}else if(hotelMap.containsKey(num)) {
	   
			hotelMap.remove(num);
			Room r=hotelMap.get(key);
			System.out.println(r.getNum()+"호 객실의"+r.getName()+"님은 체크아웃을 완료하였습니다.");
		}	
		
	}
	private void hotelAll() {
		Set<Integer>RoomKeySet=hotelMap.keySet();
		System.out.println("---------------------------------------------");
		System.out.println("현재 객실 상태");
		System.out.println("----------------------------------------------");
		if(RoomKeySet.size()==0) {
			System.out.println("정보 없음");
		}else
		for(Integer key:RoomKeySet) {
			Room r=hotelMap.get(key);
			System.out.println("방 번호	 방 종류	 투숙객 이름");
			System.out.println("----------------------------------------------");
			System.out.println(r.getNum()+r.getKind()+r.getName());	
		}
	}
	
	
	
	class Room{
		int num;
		String kind;
		String name;
		
	public Room(int num, String kind, String name) {
		super();
		this.num=num;
		this.kind=kind;
		this.name=name;	
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Room [num=" + num + ", kind=" + kind + ", name=" + name + "]";
	}

	
	
	}
	class manage{
		
	}

	
}
