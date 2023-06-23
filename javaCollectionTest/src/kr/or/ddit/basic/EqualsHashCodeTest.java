package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Objects;

public class EqualsHashCodeTest {

	public static void main(String[] args) {
		Person p1=new Person();
		p1.setId(1);
		p1.setName("홍길동");
		
		Person p2=new Person();
		p2.setId(1);
		p2.setName("홍길동");
		
		Person p3=p1;
		
		System.out.println(p1==p2); //참조값 주소값 비교
		System.out.println(p1==p3);
		System.out.println();
		
		System.out.println(p1.equals(p2));//기본적으로 참조값 비교 //String같은 경우 재정의하기
		System.out.println(p1.equals(p3));
		
		System.out.println("p1=>"+p1);
		System.out.println("p2=>"+p2);
		System.out.println("p3=>"+p3);
		
		HashSet<Person>testSet=new HashSet<Person>();// HashSet에 데이터를 넣을때 Hashcode까지 같아야한다
												//Hashcode 재정의해야한다 / hash먼저 비교하고 equals비교
		testSet.add(p1);
		testSet.add(p2);
		System.out.println("set의 개수>>"+testSet.size());
		//Hashcode 그 객체라 나타내는 값
		System.out.println("p1의 hashcode>>"+p1.hashCode());
		System.out.println("p2의 hashcode>>"+p2.hashCode());
		System.out.println("p3의 hashcode>>"+p3.hashCode());
		
		/*
		 * -equals()메서드==> 두 객체의 내용이 같은지 비교하는 연산자 메서드
		 * -hashCode()메서드==> 두 객체가 같은 객체인지를 비교하는 메서드
		 * 
		 * -HashSet, HastMap, Hashtable과 같이 Hash로 시작하는 컬렉션 객체들은
		 * 객체의 의미상의 동일성을 비교를 위해서 hashCode()메서드와 equals()메서드를
		 * 호출해서 비교한다.
		 * -그래서 객체가 같은지 여부를 결정하려면 equals()메서드와 hashCode()메서드를 같이 재정의 해야 한다
		 * 
		 * -hashCode()메서드에서 사용되는 '해싱 알고리즘'은 서로 다른 객체들에 대해 같은
		 * hashCode값을 만들어 낼 수 있다.
		 * 
		 * 
		 */
		
	}

}

//id변수 값과 name변수 값이 모두 같으면 true가 반환되는 equals()메서드 재정의하기
class Person {	//객체를 만들면 기본적으로 obj상속받음 (extend object)
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
		public boolean equals(Object obj) {  
			if(this==obj) { //현재객체와 상대방 참조값(주소)비교
				return true;
			}
			if(obj==null) {
				return false;
			}
			if(this.getClass() != obj.getClass()) {
				return false;
			}
			Person that=(Person)obj; //원래의 자료형으로 형변환
			
			return this.id==that.id && Objects.equals(this.name, that.name);//null값까지 비교해줌
		}
	@Override
		public int hashCode() {
			
			return Objects.hash(id,name); 
		}
}
