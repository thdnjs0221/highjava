package kr.or.ddit.basic;

public class ThreadTest03 {

	public static void main(String[] args) {
		// 쓰레드의 실행 시간을 체크해보자...
		Thread th = new Thread(new MyRunner()); //1줄로 줄여쓰는 방법
		
		//1971.01.01 0시0분0초(표준시간)부터 현재시간까지 경과한 시간을 
		//밀리세컨드(1/1000) 단위로 반환한다.
		long startTime=System.currentTimeMillis();
		
		th.start();
		
		try {
			th.join(); //현재의 위치에서 대상이 되는 쓰레드(지금은 변수 th)가
						// 종료될 때 까지 기다린다. (끝나면 join다음 명령어로 넘어감)
			
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		long endTime=System.currentTimeMillis();
		
		System.out.println("경과시간:"+(endTime - startTime));
		
	
	}

}

class MyRunner implements Runnable{ //쓰레드 만드는 방법 2가지 -> 부모클래스 상속받고 쓰레드 기능까지 넣어야할때는 방법2번쓰기(자바는 상속을 하나만 받을수 있기때문에)
	@Override
	public void run() {
		long sum=0L;
		for (long i=1L; i<=1_000_000_000L
				; i++) {
			sum+=i;
		}
		System.out.println("합계:"+sum);
	}
}
