package kr.or.ddit.basic;
/*
 * 10마리의 말들이 경주하는 경마 프로그램 작성하기...
 * 
 * 말은 Horse라는 이름의 쓰래드 클래스로 작성하는데 이 클래스는 
 * 말이름(String),현재위치(int),등수(int)를 멤버변수로 갖는다.
 * 그리고, 이 클래스에는 등수를 오름차순으로 처리할 수 있는 내부 정렬 기준이 있다.
 * (Comparable 인터페이스 구현)
 * 
 * 경기 구간은 1~50구간으로 되어 있다.
 * 
 * 경기가 끝나면 등수 순으로 출력한다.
 * 
 * 그리고 경기 중 중간 중간에 각 말들의 현재 위치를 아래와 같이 나타내시오...
 * 아래)
 * 
 * 01번말: ---------->--------------------------------------
 * 02번말: ------------->-----------------------------------
 * ...
 * 10번말: ---------->--------------------------------------
 * 
 * */
public class ThreadTest13 {

	public static void main(String[] args) {
		

	}

}

class Horse extends Thread{
	
	String name;
	int num;
	int rank;
	
	public Horse(String name, int num, int rank) {
		super();
		this.name = name;
		this.num = num;
		this.rank = rank;
	}
	@Override
		public void run() {
			for(int i=1; i<=10; i++) {
				System.out.println("");
				
			}
			super.run();
		}
	
	
	
}
