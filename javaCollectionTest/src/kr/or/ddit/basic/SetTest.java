package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class SetTest {

	public static void main(String[] args) {
	/*-List와 Set의 차이점
	 * 1.List
	 * 	-데이터의 순서(index)가 있다.
	 * 	-중복되는 데이터를 저장할 수 있다.
	 * 
	 * 2.Set
	 * 	-데이터의 순서(index)가 없다
	 * 	-중복되는 데이터를 저장할 수 없다
	 * 	
	 */
		HashSet hs1=new HashSet();
		
		
		//Set객체에 데이터를 추가할 때도 add()메서드를 사용한다.
		hs1.add("DD");
		hs1.add("AA");
		hs1.add(2);
		hs1.add("CC");
		hs1.add("BB");
		hs1.add(1);
		hs1.add(3);
		
		System.out.println("set 데이터>> "+hs1);
		System.out.println("set의 개수>> "+hs1.size());
		System.out.println();
		
		//Set에 중복되는 데이터를 추가하면 false를 반환하고 데이터는 추가되지 않는다.
		boolean isAdd=hs1.add("FF");  //
		System.out.println("중복되지 않을때>>"+isAdd);
		System.out.println("set 데이터>>"+hs1);
		System.out.println();
		
		isAdd=hs1.add("CC");
		System.out.println("중복될 때>>"+isAdd);
		System.out.println("set 데이터>>"+hs1);
		System.out.println();
		
		//Set의 데이터 수정하기 ==>수정하는 명령이 따로 없다.
		//==> 해당 자료를 삭제한 후에 추가해 주는 방법을 사용한다.
		
		//삭제하는 메서드: remove(삭제할자료)==> 삭제성공(true) 삭제실패(false)반환
		//				clear()==>전체 삭제
		
		//예) "FF"데이터를 "EE" 로 변경하기
		hs1.remove("FF");
		System.out.println("삭제 후 Set>> "+hs1);
		hs1.add("EE");
		System.out.println("set 데이터>>"+hs1);
		System.out.println();
		
		//hs1.clear();
		//System.out.println("clear 후 Set>>"+hs1);
		//System.out.println();
		
		/*
		 * Set의 데이터는 순서(index)가 없기 때문에 List 처럼 index로 데이터를 하나씩 불러올 수 없다
		 * 그래서 데이터를 하나씩 얻기 위해서는 Iterator형 객체로 변환해야 한다.
		 * 
		 * - Set형의 데이터들을 Iterator형 객체로 변환하는 메서드==> iterator()
		 * - 포인터가 가르키는 곳을 데이터를 꺼내올수있음
		 */
		Iterator it=hs1.iterator();
		//Iterator의 hasNext()메서드
		//   =>Iterator의  포인터가 가리키는 곳의 다음 번째에 데이터가 있으면 true 
		//		없으면 false를 반환한다.
		while(it.hasNext()) { //처음부터 끝까지 진행하기위해  /while문이 true이면 안에 실행후 (it.next());데이터 하나씩 꺼냄
			//Iterator의 next()메서드
			// 	==>Iterator의 포인터를 다음번째로 이동한 후 이동한 자리의 데이터를 반환한다
			System.out.println(it.next());
		}
		System.out.println();
		
		System.out.println("향상된  for문 이용");
		for(Object obj:hs1) {
			System.out.println(obj);		
		}
		System.out.println();		
		
		//우리반 학생들의 번호를 이용하여 추첨하는 프로그램을 작성해 보자
		//번호는 1번부터 28번까지 있고, 추첨할 인원은 3명이다
		//당첨자를 출력해 보시오...
		
		// 최소값~최대값 사이의 정수형 난수 만들기(Set중복없)
		// (int)(Math.random()*(최대값-최소값+1)+최소값)
		HashSet<Integer> testSet=new HashSet<>();
		while(testSet.size()<3) {
			testSet.add((int)(Math.random()*(18-1+1)+1));
			
		}
		System.out.println("당첨자 번호>>"+testSet);
		
		//Set유형의 자료를 List형으로 변환하기
		ArrayList<Integer>testList=new ArrayList<>(testSet); //Set이 가지고 있는 데이터를 가지고 있는 ArrayList
		System.out.println("List의 데이터 출력..");
		for(int i=0; i<testList.size(); i++) {
			System.out.println(testList.get(i));
		}
		System.out.println();
		
		
		
		
	}
}
