package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//문제3) LPROD_id값을 2개를 입력 받아서 두 값중 작은 값부터 큰값까지의 데이터를 출력하시오


public class JdbcTest03 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		System.out.print("1 id 입력: ");
		int num1=scan.nextInt();
		
		System.out.print("2 id 입력: ");
		int num2=scan.nextInt();
		//if,3항,메서드
		
		//3항연산자
		//int max= num1>num2 ? num1: num2;
		//int min= num1>num2 ? num2: num1;
		
		//메서드 이용
		int max = Math.max(num1, num2);
		int min = Math.min(num1, num2);
		
		Connection conn = null;
		Statement stmt= null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn=DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe","pc14","java");
			
			/*
			//String sql ="select * from lprod where lprod_id >="+min+"and lprod_id<="+max;
				String sql ="select * from lprod where lprod_id between"+min+"and"+max;
			stmt= conn.createStatement();
			rs=stmt.executeQuery(sql);
			*/
			String sql ="select * from lprod where lprod_id between ? and ?";
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, min);
			pstmt.setInt(2, max);
			
			rs=pstmt.executeQuery();
			
			System.out.println("== 쿼리문 처리 결과 ==");
			
			while(rs.next()) {
				System.out.println("LPROD_ID: "+rs.getInt("lprod_id"));	
				System.out.println("LPROD_GU: "+rs.getString(2));
				System.out.println("LPROD_NM: "+rs.getString("lprod_nm"));
				System.out.println("---------------------------------------");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException e) {}
			if(stmt!=null)try {stmt.close();}catch(SQLException e) {}
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}

	}

}
