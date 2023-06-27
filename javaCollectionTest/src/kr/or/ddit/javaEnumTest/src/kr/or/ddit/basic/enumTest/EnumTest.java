package kr.or.ddit.basic.enumTest;
/*
 * enum(열거형)==> 서로 관련있는 상수들의 집합을 나타낸다
 * 			==> 클래스처럼 보이게하는 상수
 * 
 * 열거형을 작성하는 위치
 * 1. 독립된 Java파일로 만들 수 있다.
 * 2. 하나의 Java파일에 클래스와 같이 만들 수 있다.
 * 3. 클래스 안에 내부 클래스처럼 만들 수 있다.
 * 
 * - 열거형의 속성 및 메서드 
 * 1. name() ==> 열거형 상수의 이름을 문자열로 반환한다.
 * 2. ordinal() ==> 열거형 상수가 정의된 순서값(index값)을 반환한다 (0부터 시작)
 * 3. valueOf("열거형상수명") ==> 정의된 열거형에서 '열거형상수명'과 일치하는 열거형 상수를 반환한다.
 * 
 * 4. 열거형이름.상수명	==> valueOf()메서드와 같다.
 * 5. values() 	==> 열거형에 정의도니 무든 상수들을 배열로 반환한다.
 * 
 * -열거형 선언하기
 * 방법1) 
 * 		enum 열거형이름{상수명1, 상수명2,....}
 * 
 * 방법2) 
 * 		enum 열거형이름{
 * 			상수명1(값들.....),
 * 			상수명2(값들.....),
 * 			...
 * 			상수명n(값들.....);
 * 
 * 			//'값들'이 저장될 변수들을 선언한다.
 * 			private 자료형이름 변수명1;
 * 			...
 * 			
 * 			//열거형의 생성자를 만든다.
 * 			//열거형의 생성자에서는 '열거형상수'에 지정한 '값들'을 변수에 셋팅한느
 * 			//역할을 수행한다.
 * 			
 * 			//열거형 생성자는 접근 제한자는 묵시적으로 'private'이다.
 * 
 *  		//열거형 생성자의 매개변수의 개수는 '값'의 개수와 같아야 하고 
 *  		//각각의 값들의 자료형도 맞아야 한다.
 *  		private 열거형이름(자료형 변수명1,...,자료형 변수명n){
 *  			위에 선언된 변수들 초기화 작업;
 *  			...
 *  		}
 *  		
 *  		// 구성된 '값들'을 외부에서 불러올 수 있는 getter메서드를 만든다.
 *  		
 * }
 * 
 * 
 * */

public class EnumTest {
	public enum Color{RED,GREEN,BLUE} //클래스 안에 내부 클래스처럼 만들 수 있다.
	
	public enum Count{ONE,TWO,THREE}
	
	public enum Season{
		봄("3월부터 5월까지",13), //
		여름("6월부터 8월까지", 28),
		가을("9월부터 11월까지",15),
		겨울("12월부터 2월까지",1);
		
		//값들이 저장될 변수 선언
		private String span;
		private int temp;
		
		//생성자
		Season(String months,int temp){//private Season(String months,int temp)와 같다 (private생략)
			span=months;
			this.temp=temp;
		}
		//getter메서드 
		public String getSpan() {
			return span;
		}
		public int getTemp() {
			return temp;
		}
		
		
	}
	
	public static void main(String[] args) {
		/*
		System.out.println("RED: "+ConstTest.RED);
		System.out.println("THREE: "+ConstTest.THREE);
		
		if(ConstTest.RED == ConstTest.TWO) {
			System.out.println(".....");		
		}else {
			System.out.println("*****");
		}*/
		
		Color mycol= Color.valueOf("GREEN"); //Color.GREEN와 같다
		Count mycnt= Count.ONE;				//Count.value.Of("ONE")와 같다
		
		System.out.println("mycol>> "+mycol.name());
		System.out.println("mycnt>> "+mycnt.name());
		
		System.out.println("mycol ordinal>> "+mycol.ordinal()); //
		System.out.println("mycnt ordinal>> "+mycnt.ordinal());
		
		
		/*
		//서로 다른 종류의 열거형끼리의 비교는 불가하다
		if(Color.RED==Count.TWO) {
			System.out.println("....");
		}
		*/
		
		if(mycol==Color.GREEN) {
			System.out.println("같다....");
		}else {
			System.out.println("다르다....");
		}
		
		// 열거형을 switch문에서 사용할 수 있다
		// 단, case문에 지정하는 값은 '열거형이름.상수명'형식으로 사용하는 것이 아니라 
		// 		'열거형 이름'을 생략한 '상수명'만으로 사용해야 한다.
		
		switch(mycnt) {
		case ONE: System.out.println("원"); break;
		case TWO: System.out.println("투"); break;
		case THREE: System.out.println("쓰리"); break;
		}
		
		System.out.println("----------------------------");
		
		Season ss= Season.valueOf("봄");
		System.out.println("name: "+ss.name());
		System.out.println("ordinal: "+ss.ordinal());
		System.out.println("span: "+ss.getSpan());
		System.out.println("temp: "+ss.getTemp());
		System.out.println();
		
		//열거형 상수 전체를 차례로 처리하기..
		for(Season time: Season.values()) {
			System.out.println(time.name()+" ==> "+time+" ==> "+time.getSpan()+time.getTemp()
			);
			System.out.println();
			
			for(Color col: Color.values()) {
				System.out.println(col+" ==> "+col.ordinal());
			}
		}
	}
}
