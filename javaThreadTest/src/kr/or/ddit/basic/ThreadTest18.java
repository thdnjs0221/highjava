package kr.or.ddit.basic;
/*
 * wait(), notify()메서드를 이용한 두 쓰레드가 번갈아 한번씩 실행하는 예제
 *  
 * */

public class ThreadTest18 {

	public static void main(String[] args) {
		WorkObject workObj = new WorkObject();

		ThreadA thA = new ThreadA(workObj);
		ThreadB thB = new ThreadB(workObj);

		thA.start();
		thB.start();

	}

}

//공통으로 사용할 객체
class WorkObject {
	public synchronized void testMehthodA() {
		System.out.println("testMethodA()메서드 실행중...");
		notify(); // 신호 보내고 B메소드 실행

		try {
			wait();
		} catch (InterruptedException e) {

		}
		System.out.println("testMethodA 끝");
	}

	public synchronized void testMethodB() {
		System.out.println("testMethodB()메서드 작성중...");
		notify();

		try {
			wait();
		} catch (InterruptedException e) {

		}
		System.out.println("testMethodB 끝");
	}
}

//WorkObject의 testMethodA()메서드만 호출하는 쓰레드
class ThreadA extends Thread {
	private WorkObject workObj;

	public ThreadA(WorkObject workObj) {
		this.workObj = workObj;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) { // 10번씩 호출
			workObj.testMehthodA();
		}
		synchronized (workObj) {
			workObj.notify(); // notify()동기화 영역에서만 사용 가능
		}
	}
}

//WorkObject의 testMethodB()메서드만 호출하는 쓰레드
class ThreadB extends Thread {
	private WorkObject workObj;

	public ThreadB(WorkObject workObj) {
		this.workObj = workObj;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			workObj.testMethodB();
		}
		synchronized (workObj) {
			workObj.notify(); // notify()동기화 영역에서만 사용 가능 .
		}
	}
}

//마지막번째 B의 wait()를 꺠워줄수없음. 쓰레드B가 끝나지 않은 상태.