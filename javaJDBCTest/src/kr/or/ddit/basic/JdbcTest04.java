package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcTest04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "pc14", "java");

			System.out.println("계좌번호 정보 추가하기");
			System.out.println("추가할 계좌번호 정보 입력하세요");
			System.out.println("계좌번호: ");
			String bankNo = scan.next();

			System.out.println("은행이름: ");
			String bankName = scan.next();

			System.out.println("예금주명: ");
			String bankUserName = scan.next();
			/*
			 * //Statement객체 이용해서 데이터 추가하기 String
			 * sql="insert into bankinfo(bank_no, bank_name, bank_user_name, bank_date)"+
			 * "values('"+bankNo+"','"+bankName+"','"+bankUserName+"',sysdate)";
			 * 
			 * System.out.println("sql=>"+sql);
			 * 
			 * stmt= conn.createStatement();
			 * 
			 * //select문을 실행할때는 executeQuery()메서드를 사용하고, //insert,update,delete등 select문이 아닌
			 * 쿼리문 실행할때는 //executeUpdate()메서드 사용한다 //executeUpdate()메서드의 반환값=> 작업에 성공한 레코드 수
			 * (정수값)
			 * 
			 * int cnt= stmt.executeUpdate(sql);
			 */
			// PreparedStatement 객체를 이용하여 처리하기

			// 1) sql문을 작성할때 sql문에 데이터가 들어갈 자리를 물음표(?)로 표시한다

			String sql = "insert into bankinfo(bank_no, bank_name, bank_user_name, bank_date)"
					+ "values(?,?,?,sysdate)";

			// 2)PreparedStatement객체 생성=>이 때 실행할 sql문을 인수값으로 넣어준다
			pstmt = conn.prepareStatement(sql);

			// 3) sql문의 물음표(?)자리에 들어갈 데이터를 셋팅한다.
			// 형식) pstmt.set자료형 이름(물음표 번호, 데이터)=> 물음표번호는 1번부터 시작
			pstmt.setString(1, bankNo);
			pstmt.setString(2, bankName);
			pstmt.setString(3, bankUserName);

			// 4) 데이터 셋팅이 완료되면 sql문을 실행한다
			int cnt = pstmt.executeUpdate();

			System.out.println("반환값 cnt" + cnt);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}

	}

}
