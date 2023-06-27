package kr.or.ddit.basic.args;

public class ArgsTest {
	/*
	 * -가변형 인수=> 메서드의 인수의 개수가 호출될 때 마다 다를 때 사용한다.
	 * 	가변형 인수는 메서드 안에서 배열로 처리된다.
	 * 	가변형 인수는 한가지 자료형만 사용할 수 있다.
	 * 	
	 * 
	 * */
	
	
	
	//매개변수로 받은 정수들의 합계를 구하는 메서드를 작성하시오.
	//(단 이 정수들의 개수는 상황에 따라 다르다..)
	
	//배열을 이용한 경우 
	public int sumArr(int[]data) {
		int sum=0;
		
		for(int i=0; i<data.length; i++) {
			sum+=data[i];
		}
		return sum;
	}
	
	//가변형 인수를 이용한 경우
	public int sumArg(int...data) {
		int sum=0;
		for(int i=0; i<data.length; i++) {
			sum+=data[i];
		}
		return sum;
	}
		
		
		
	//가변형 인수와 일반적인 인수를 같이 사용할 경우에는 가변형 인수를 제일 뒤쪽에 배치해야 한다.
	public String sumArg2(String name, int...data) {
		int sum=0;
		
		for(int i=0; i<data.length; i++) {
			sum+=data[i];
		}
		return name+"씨의 합계:"+sum;
	}

	public static void main(String[] args) {
	//static 없는 메서드 호출하려면
		ArgsTest at =new ArgsTest();
		
		int[] nums= {100,200,300};
		
		//int[] nums2;
		//nums2{1,2,3,4,5};
		
		
		System.out.println(at.sumArr(nums));
		System.out.println(at.sumArr(new int[] {1,2,3,4,5}));
		System.out.println();
		System.out.println(at.sumArg(100,200,300));
		System.out.println(at.sumArg(1,2,3,4,5));
		
		System.out.println(at.sumArg2("홍길동", 10,20,30,60,70,80));
	}
}
