package kr.or.ddit.basic;
//javaDoc 파일 만들기 예제
//html태그 작성 할 수 있음

/**
 * @version 1.0
 * @author PC-14
 *
 *<p> 
 *파일명: JavaDocTest.java<br>
 *설명: JavaDoc문서 작성을 위한 연습용 interface<br><br>
 *
 *변경 이력 <br>
 *--------------------<br>
 *변경일자: 2023-07-13<br>
 *변경인: 홍길동 <br>
 *변경 내용: 최초작성 <br>
 *--------------------<br>
 *
 *</p>
 *
 *
 */
public interface javaDocTest {
	/**
	 * 메서드명 : methodTest<br>
	 * 설명: 반환값이 없는 메서드 <br>
	 * 
	 * @param a 첫번째 매개변수 (정수형)
	 * @param b 두번째 매개변수 (정수형)
	 */
	public void methodTest(int a , int b);
	/**
	 * 메서드명: methoAdd<br>
	 * 설명: 반환값이 있는 메서드 <br>
	 * 
	 * @param x 첫번째 매개변수 (정수형)
	 * @param y 두번째 매개변수 (정수형)
	 * @return 처리된 결과를 정수형으로 반환한다
	 */
	public int methodAdd(int x , int y);
	/**
	 * 메서드명 : methodInput<br>
	 * 설명: 매개변수가 없는 매서드 <br>
	 * 
	 * @return 처리가 완료된 정수형 데이터 
	 */
	public int methodInput();

}
