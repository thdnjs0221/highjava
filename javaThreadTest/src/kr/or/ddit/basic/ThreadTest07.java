package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class ThreadTest07 {
	
	public static void main(String[] args) {
		Data th1 = new Data();
		Count th2 = new Count();
		th1.start();
		th2.start();

	}
}

class Data extends Thread {
	public static boolean inputCheck = false;

	@Override
	public void run() {
		String str = JOptionPane.showInputDialog("입력하세요");
		inputCheck = true;
		System.out.println("입력값: " + str);
	}
}

//카운트 다운
class Count extends Thread {
	@Override
	public void run() {
		for (int i = 5; i > 0; i--) {
			if (DataInput.inputCheck == true) {
				return;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			
			}
		}
		System.out.println("시간초과로 당신이 졌습니다..");
	}
}

class Com extends Thread{
	@Override
	public void run() {
		
	}
}
