package kr.or.ddit.basic;

public class ThreadTest15 {

	public static void main(String[] args) {
		ShareObject sObj= new ShareObject();
		
		TestThread th1= new TestThread("Test1", sObj);
		TestThread th2= new TestThread("Test2", sObj);
		
		th1.start();
		th2.start();

	}

}

class TestThread extends Thread{
	private ShareObject sObj;  //

	public TestThread(String name,ShareObject sObj) {
		super(name); //부모의 생성자 호출 / 쓰레드의 name설정
		this.sObj = sObj;
	}
	
	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			sObj.add(); //10번 호출
		}
	}
}

//공통 클래스
class ShareObject{
	private int sum=0;
	
	
	//동기화 처리
	
//	public synchronized void add() { //방법1=> 메서드에 동기화 설정을 한다.
		public void add(){ 
			synchronized (this) { //방법 2=> 동기화 블럭으로 설정한다.
				int n= sum;   //
				
				n+=10;
				
				sum=n;
				
				System.out.println(Thread.currentThread().getName()+"합계:"+sum);		
				
			}
			
		}
//		int n= sum;   //
//		
//		n+=10;
//		
//		sum=n;
//		
//		System.out.println(Thread.currentThread().getName()+"합계:"+sum);		
	}

