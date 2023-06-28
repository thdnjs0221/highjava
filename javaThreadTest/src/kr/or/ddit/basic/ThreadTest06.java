package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class ThreadTest06 {

	public static void main(String[] args) {
		DataInput th1=new DataInput();
		CountDown th2=new CountDown();
		
		th1.start();
		th2.start();
		
	}

}

//데이터를 입력하는 쓰레드
class DataInput extends Thread {
	//입력 여부를 확인하기 위한 변수 선언- 쓰레드에서 공통으로 사용되는 변수
	public static boolean inputCheck = false;
	
	
	
	@Override
	public void run() {
		String str = JOptionPane.showInputDialog("아무거나 입력하세요...");
		inputCheck=true;  //입력이 완료되면 true값을 저장한다.
		System.out.println("입력 값>> " + str);
	}
}

//카운트 다운을 진행하는 쓰레드
class CountDown extends Thread {
	@Override
	public void run() {
		for (int i = 10; i > 0; i--) {
			// 입력 여부를 확인하여 입력이 완료되면 쓰레드를 종료 시킨다.
			if(DataInput.inputCheck==true) {
				//run()메서드가 종료되면 해당 쓰레드가 종료되는 것과 같다.
				return;
				
			}
			
			System.out.println(i);
			try {
				Thread.sleep(1000); // 1초 동안 멈춘다.
			} catch (InterruptedException e) {

			}
		}
		
		System.out.println("10초가 지났습니다... 프로그램을 종료합니다...");
		System.exit(0); //10초동안 입력을 못하면 실행이 끝나는 프로그램
	}
}
