package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 * 
 * LPROD테이블에 새로운 데이터 추가하기
 * 
 * Lprod_gu Lprod_nm은 직접 입력받아서 처리하고,
 * Lprod_id는 현재의 Lprod_id중에서 제일 큰 값보다 1크게 한다
 * 
 * 입력 받은 Lprod_gu가 이미 등록되어 있으면 다시 입력 받아서 처리한다.
 * 
 * 쿼리문-> 제일 큰값  select max(iprod_id)from lprod;
 * p101 입력
 * select count(*) from lprod where lprod_gu ='p101';
 * */
public class JdbcTest05 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "pc14", "java");
			System.out.println("Lprod_gu 입력: ");
			String gu=scan.next();
			
			System.out.println("Lprod_nm 입력: ");
			String nm=scan.next();
			String sql = "insert into lprod(lprod_gu, lprod_nm, lprod_id+1)" + "values(?,?)";

			pstmt= conn.prepareStatement(sql);
			
			pstmt.setNString(1,gu);
			pstmt.setNString(1,nm);
			// String sql="select max(lprod_id)from lprod";
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
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
