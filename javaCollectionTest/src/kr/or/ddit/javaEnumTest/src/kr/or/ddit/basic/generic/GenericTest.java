package kr.or.ddit.basic.generic;
/*
 * -제네릭 클래스 만드는 방법
 * 형식)
 * class 클래스명 <제네릭타입글자>{
 * 	제네릭타입글자 변수명; 		//변수 선언에 제네릭을 사용할 경우
 * 	...
 * 	
 * 	제네릭타입글자 메서드명(){  //반환값이 있는 메서드에 제네릭을 사용할 경우
 * 		...
 * 		return 값;
 * }
 * 	...
 * 
 * 	반환값타입 메서드명(제네릭타입글자 변수명, ...){	//메서드의 매개변수에 제네릭을 사용할 경우
 * 	...
 * 
 *  }
 * 
 * }
 * 
 * 	--제네릭 타입 글자--
 *  T==>Type
 *  K==>Key
 *  V==>Value
 *  E==>Element(데이터를 의미함)
 * 
 * */
//제네릭을 사용하지 않는 클래스
class NonGenericClass{
	private Object value;
	
	public void setValue(Object value) {
		this.value=value;
	}
	public Object getValue() {
		return this.value;
	}
	
}
//제네릭을 적용한 클래스
class MyGeneric<T>{
	private T value;
	
	public T getValue() {
		return value;
	}
	
	public void setValue(T value) {
		this.value=value;
	}
}

public class GenericTest {

	public static void main(String[] args) {
		NonGenericClass ng1= new NonGenericClass();
		ng1.setValue("가나다라");
		
		NonGenericClass ng2=new NonGenericClass();
		ng2.setValue(100);
		
		//데이터 꺼내오기. 부모객체가 자식객체에 저장할때는 캐스팅해주기
		String tempNg1=(String)ng1.getValue();
		System.out.println("문자열 반환값 tempNg1=> "+tempNg1);
		
		int iTempNg=(int)ng2.getValue();
		System.out.println("정수형 반환값 iTempNg=> "+iTempNg);
		System.out.println();
		
		MyGeneric<String> mg1=new MyGeneric<String>(); //<String>=>T자리로 감
		MyGeneric<Integer> mg2=new MyGeneric<Integer>();
		
		mg1.setValue( "우리나라");
		mg2.setValue(500);
		
		String tempMg1=mg1.getValue();
		int iTempMg2=mg2.getValue();
		System.out.println("제네릭 문자열 반환값=>"+tempMg1);
		System.out.println("제네릭 정수형 반환값=>"+iTempMg2);
		
		NonGenericClass ng3=new NonGenericClass();
		ng3.setValue(1000);
		
		//세팅한 데이터와 꺼내온 데이터의 타입이 맞지 않음 컴파일 단계에서는 오류가 아님 실행단계(run)에서는 오류 
		String test=(String)ng3.getValue();
		System.out.println(test);
		
		
	}

}
