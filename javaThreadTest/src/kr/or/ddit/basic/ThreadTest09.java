package kr.or.ddit.basic;

//쓰레드의 상태를 출력하는 예제

public class ThreadTest09 {

	public static void main(String[] args) {
		StatePrintThread th= new StatePrintThread(new TargetThread());
		th.start();
		

	}

}

//쓰레드 상태의 검사 대상이 되는 쓰레드
class TargetThread extends Thread{
	@Override
	public void run() {
		long temp = 0;
		for(long i=1L; i<=20_000_000_000L; i++) {  //시간 지연용..
			temp= i % 8L;	
		}		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {			
		}
		for(long i=1L; i<=20_000_000_000L; i++) {
			temp= i % 8L;
			
		}
	}
}
//검사 대상의 쓰레드의 상태를 출력하는 쓰레드
class StatePrintThread extends Thread{
	private TargetThread target;
	
	
	//생성자
	public StatePrintThread(TargetThread target) {
		super();
		this.target = target;
	}
	@Override
	public void run() {
		while(true) {
			//쓰레드의 현재 상태값 구하기
			//getState()==>쓰레드의 현재 상태값을 Thread.State의 열거형으로 봔환한다.
			Thread.State state = target.getState();
			System.out.println("TargetThread의 현재 상태값: "+state);
			
			//TargetThread의 상태가 NEW상태이면...
			if(state==Thread.State.NEW) {
				target.start();
			}
			
			//TargetThread의 상태가 TERMINATED상태 이면...
			if(state==Thread.State.TERMINATED) {
				break;
				
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
			}
		}
	}
	
	
	
	
}



