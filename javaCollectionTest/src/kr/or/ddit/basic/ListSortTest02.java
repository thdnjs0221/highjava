package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



public class ListSortTest02 {
	public static void main(String[] args) {
		ArrayList<Member>memList=new ArrayList<Member>();
		memList.add(new Member(1,"홍길동","010-1111-1111"));
		memList.add(new Member(5,"이순신","010-2222-1111"));
		memList.add(new Member(9,"성춘향","010-3333-1111"));
		memList.add(new Member(3,"강감찬","010-4444-1111"));
		memList.add(new Member(6,"일지매","010-5555-1111"));
		memList.add(new Member(2,"변학도","010-6666-1111"));
		
		System.out.println("정렬전..");
		for(Member mem:memList) {
			System.out.println(mem);
			
		}
		System.out.println("----------------------------------");
		Collections.sort(memList);//
		System.out.println("정렬후..");
		for(Member mem:memList) {
			System.out.println(mem);
			
		}
		System.out.println("----------------------------------");
		//회원이름의 오름차순으로 정렬되는 외부 정렬 기준을 만들어 정렬하여 출력하시오
				//클래스명 NameSort
		Collections.sort(memList, new NameSort());
		System.out.println("회원 이름의 오름차순 정렬후..");
		for(Member mem:memList) {
			System.out.println(mem);
		
	
		}
	}



}

//Member클래스 작성
//회원번호의 오름차순의 내부 정렬 기준 만들기

class Member implements Comparable<Member>{
	private int num; //회원번호 
	private String name;//회원이름
	private String tel;//전화번호
	
	public Member(int num, String name, String tel) {
		this.num=num;
		this.name=name;
		this.tel=tel;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}
	//회원번호의 오름차순 정렬 기준 설정하기
	@Override
	public int compareTo(Member mem) { //현재 값(기준)과 매개값과 비교
	/*
		if(this.getNum() > mem.getNum()) {
			return 1;			
		}else if(this.getNum()<mem.getNum()) {
			return -1;			
		}
		return 0;
	}	*/
		//Wrapper클래스를 이용하는 방법1 오름차순/ 내림차순일경우 뒤에 곱하기 -1
		//return new Integer(this.getNum()).compareTo(mem.getNum());
		
		///Wrapper클래스를 이용하는 방법2
		return Integer.compare(this.getNum(), mem.getNum());
		
}

}
//회원이름의 오름차순으로 정렬되는 외부 정렬 기준을 만들어 정렬하여 출력하시오
		//클래스명 NameSort
class NameSort implements Comparator<Member>{

	@Override
	public int compare(Member mem1, Member mem2) {

		return mem1.getName().compareTo(mem2.getName());
	}
}
