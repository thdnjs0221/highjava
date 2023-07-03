package kr.or.ddit.basic;

public class ThreadTest19 {

	public static void main(String[] args) {
		DataBox databox = new DataBox();
		
		ProducerThread th1 = new ProducerThread(databox);
		ConnsumerThread th2 = new ConnsumerThread(databox);
		
		th1.start();
		th2.start();

	}

}
// 공통으로 사용할 클래스
class DataBox{
	private String data;
	
	//데이터를 가져가는 메서드
	//==> data변수의 값이 null이면 data변수에 문자열이 채워질때까지 기다리고 
	//		data변수에 값이 있으면 해당 문자열을 반환한다
	//		(문자열을 반환한 후에는 data변수의 값을 null로 만든다.)
	public synchronized String getData() {
		if(data==null) {
			try {
				wait(); 
			} catch (InterruptedException e) {
				
			}
		}
		
		String temp= data;
		System.out.println("쓰레드가 읽은 데이터: "+temp);
		
		data=null;
		
		notify(); 
		
		return data;
	}
	
	//데이터를 공급하는 메서드
	//==> data변수에 값이 있으면 data변수의 값이 null이 될 때까지 기다린다
	//		data변수의 값이 null이 되면 새로운 문자열을 data변수에 저장한다.
	public synchronized void setData(String data) {
		if(this.data!=null) { //멤버변수를 나타내기 위해 this.써주기
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		this.data=data;  //null일때 실행
		System.out.println("Thread에서 새로 저장한 데이터: "+this.data);
		
		notify();
	}
}

//데이터를 공급하는 메서드
class ProducerThread extends Thread{
	private DataBox databox;

	public ProducerThread(DataBox databox) {
		super();
		this.databox = databox;
	}
	@Override
	public void run() {
		String[] dataArr={"서울","대전","부산","제주"};
		for(int i=0; i<dataArr.length; i++) {
			databox.setData(dataArr[i]);
		}
	}
}

//데이터를 꺼내서 사용하는 쓰레드
class ConnsumerThread extends Thread{
	private DataBox databox;
	
	//생성자
	public ConnsumerThread(DataBox databox) {
		super();
		this.databox = databox;
	}
	@Override
	public void run() {
		for(int i=1; i<=4; i++) {
			String returnData = databox.getData();
			
			//가져온 데이터를 사용하는 코드들...
		}
	}
}
