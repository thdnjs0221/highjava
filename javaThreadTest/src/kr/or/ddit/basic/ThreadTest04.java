package kr.or.ddit.basic;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

/*
 * 1~20억까지의 합계를 구하는 프로그램을 하나의 쓰레드가 단독으로 처리할 때와
 * 여러개의 쓰레드가 협력해서 처리할 떄의 경과 시간을 비교해보자...
 * 
 * 
 * */

public class ThreadTest04 {

	public static void main(String[] args) {
		// 단독으로 처리하는 쓰레드
		SumThread smTh = new SumThread(1L, 2_000_000_000L);

		// 여럿이 협력해서 처리하는 쓰레드
		SumThread[] sumThs = new SumThread[] { new SumThread(1L, 50_000_000L),
				new SumThread(500_000_001L, 1_000_000_000L), new SumThread(1_000_000_00L, 1_500_000_000L),
				new SumThread(1_500_000_00L, 2_000_000_000L) };

		// 단독으로 처리하기..
		long startTime = System.currentTimeMillis();
		smTh.start();
		try {
			smTh.join();
		} catch (InterruptedException e) {

		}
		long endTime = System.currentTimeMillis();
		System.out.println("단독으로 처리할 때의 경과 시간: " + (endTime - startTime));
		System.out.println();

		// 여러 쓰레드가 협력해서 처리하는 경우..
		startTime = System.currentTimeMillis();
		for (int i = 0; i < sumThs.length; i++) {
			sumThs[i].start();

		}

		for (SumThread th : sumThs) {
			try {
				th.join();
			} catch (InterruptedException e) {

			}
		}
		endTime = System.currentTimeMillis();
		System.out.println("여러 쓰레드가 협력해서 처리할 때의 경과 시간: " + (endTime - startTime));

	}
}

class SumThread extends Thread {
	private long start;
	private long end;

	// 생성자
	public SumThread(long start, long end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		long sum = 0L;
		for (long i = start; i <= end; i++) {
			sum += i;
		}

		System.out.println(start + "부터" + end + "까지의 합계" + sum);
	}

}