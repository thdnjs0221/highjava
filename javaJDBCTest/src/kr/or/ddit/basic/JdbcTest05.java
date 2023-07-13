package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

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
			/*
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "pc14", "java");
			*/
			
			conn=DBUtil.getConnection();
			//1. Lprod_id는 현재의 Lprod_id중에서 제일 큰 값보다 1크게 한다
			String sql=  " select nvl(max(lprod_id),0)+1 maxid from lprod ";
			
			stmt= conn.createStatement();
			
			rs= stmt.executeQuery(sql);
			
			int maxId=0;
			if(rs.next()) {//포인터를 실제 데이터가 있는곳으로 옮기기! 데이터가 하나 있을때는 if문써도 됨(while 써도 상관없음)
				maxId=rs.getInt("maxid");
				
			}
			//------------------------------------------------------------------
			
			
			//2. 입력 받은 Lprod_gu(상품분류코드)가 이미 등록되어 있으면 다시 입력 받아서 처리한다.
			
			String gu; //입력받은 상품 분류코드가 저장될 변수 
			int count=0; //입력한 상품분류 코드의 개수가 저장될 변수 
			
			do {
				System.out.println("상품분류코드 Lprod_gu 입력: ");
				gu=scan.next();
				
				String sql2= " select count(*)cnt from lprod where lprod_gu=? ";
				
				pstmt=conn.prepareStatement(sql2);
				pstmt.setString(1, gu);
				
				rs=pstmt. executeQuery();
				
				if(rs.next()) {
					count=rs.getInt("cnt");
				}
				if(count>0) {
					System.out.println("입력한 상품 분류코드"+gu+"는 이미 등록된 코드입니다");
					System.out.println("다시 입력하세요...");
					System.out.println();
				}
				
			}while(count>0);
			
			System.out.println("상품 분류명 Lprod_nm 입력: ");
			String nm=scan.next();
			
			String sql3 = " insert into lprod(lprod_id,lprod_gu, lprod_nm ) "
							+ " values(?,?,?) ";
			
			pstmt= conn.prepareStatement(sql3);
			pstmt.setInt(1, maxId);
			pstmt.setString(2, gu);
			pstmt.setString(3, nm);
			
			int cnt=pstmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println("등록성공!!");
			}else {
				System.out.println("등록 실패!!");
			}
			

			
		} catch (SQLException e) {
			e.printStackTrace();
//		}catch (ClassNotFoundException e) { //conn=DBUtil.getConnection();할때 주석처리
//			e.printStackTrace();
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
