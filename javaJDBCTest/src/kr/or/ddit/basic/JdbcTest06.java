package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;
import oracle.net.aso.p;

/*
 * 
 * 회원 관리를 하는 프로그램을 작성하시오(MYMEMBER테이블 이용)
 * 
 * 아래의 메뉴의 기능을 모두 구현하시오(CRUD기능 구현하기)
 * 
 * 메뉴 예시)
 * 1. 자료 추가  --> insert(c)
 * 2. 자료 삭제   --> delete(d)
 * 3. 자료 수정  --> update(u)
 * 4. 전체자료 출력 --> select(r)
 * 0. 작업 끝
 * ---------------
 * 조건 )
 * 1. 자료 추가 기능에서 '회원 아이디'는 중복되지 않는다(중복되면 다시 입력 받는다)
 * 2. 자료 삭제는 '회원아이디'를 입력 받아 처리한다
 * 3. 자료 수정에서 '회원아이디'는 변경되지 않는다
 * 
 * 
 * */
public class JdbcTest06 {
	Scanner scan  = new Scanner(System.in);
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;	
	Statement stmt = null;
	
	
	
	public int displayMenu() {
		System.out.println("1. 자료 추가");
		System.out.println("2. 자료 삭제");
		System.out.println("3. 자료 수정");
		System.out.println("4. 전체자료 출력");
		System.out.println("입력==>");
		return scan.nextInt();
	}
	
	public void memStart() {
		while(true) {
			int choice = displayMenu();
			switch (choice) {
			case 1:
				minsert();	
				break;
			case 2:
				mdelete();
			
				break;
			case 3:
				mupdate();
				break;
			case 4:
				mread();
				break;

			default:
				break;
			}
		}
		
	}
	public void minsert() {
		
		String id; //입력받은 상품 분류코드가 저장될 변수 
		int count=0; //입력한 상품분류 코드의 개수가 저장될 변수 
		try {
			conn=DBUtil.getConnection();
		do {
			System.out.println("아이디 입력: ");
			id=scan.next();
			
			String sql5= " select count(*)cnt from mymember where mem_id=? ";
			
			pstmt=conn.prepareStatement(sql5);
			pstmt.setString(1, id);
			
			rs=pstmt. executeQuery();
			
			if(rs.next()) {
				count=rs.getInt("cnt");
			}
			if(count>0) {
				System.out.println(id+"는 이미 등록된 코드입니다");
				System.out.println("다시 입력하세요...");
				System.out.println();
			}
		
		}while(count>0);
	

		
		//System.out.println("회원 아이디 ");
		//String id = scan.next();
		
		System.out.println("회원 비밀번호 ");
		String pw = scan.next();
		
		System.out.println("회원 이름");
		String name = scan.next();
		
		System.out.println("회원 전화번호 ");
		String tel = scan.next();
		
		System.out.println("주소 ");
		String addr = scan.next();
		
		
		
		String sql= "insert into mymember(mem_id, mem_pass, mem_name, mem_tel, mem_addr)"
							+"values(?,?,?,?,?)";
		
		pstmt= conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		pstmt.setString(3, name);
		pstmt.setString(4, tel);
		pstmt.setString(5, addr);
		
		int cnt=pstmt.executeUpdate();
		
		if(cnt>0) {
			System.out.println("등록성공!!");
		}else {
			System.out.println("등록 실패!!");
		}
		
	}	catch(SQLException e) {
		e.printStackTrace();
	}
		
	}
	
	public void mdelete() {
		try {
			
			conn=DBUtil.getConnection();
			
			System.out.println("삭제할 아이디 입력: ");
			String id=scan.next();
			
			String sql2= " delete from mymember where mem_id=?";
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, id);
			
			int cnt=pstmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println("등록성공!!");
			}else {
				System.out.println("등록 실패!!");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void mread() {
		try {
			
			conn=DBUtil.getConnection();
			String sql3= "select *from mymember";
			
			stmt= conn.createStatement();
			
			rs=stmt.executeQuery(sql3);
			while(rs.next()) {
				System.out.println("mem_id: "+rs.getString(1));
				System.out.println("mem_pass: "+rs.getString(2));
				System.out.println("mem_name: "+rs.getString(3));
				System.out.println("mem_tel: "+rs.getString(4));
				System.out.println("mem_addr: "+rs.getString(5));
				System.out.println("---------------------------");
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void mupdate() {
		
		try {
			conn=DBUtil.getConnection();
			System.out.println("수정할 정보 입력하세요");
			System.out.println("회원 아이디 ");
			String id = scan.next();
			
			System.out.println("회원 비밀번호 ");
			String pw = scan.next();
			
			System.out.println("회원 이름");
			String name = scan.next();
			
			System.out.println("회원 전화번호 ");
			String tel = scan.next();
			
			System.out.println("주소 ");
			String addr = scan.next();
			
			String sql4="update mymember set mem_pass=? ,mem_name=?,mem_tel=?,mem_addr=? where mem_id=?";
			
			pstmt= conn.prepareStatement(sql4);
			pstmt.setString(1,pw);
			pstmt.setString(2, name);
			pstmt.setString(3,tel );
			pstmt.setString(4,addr);
			pstmt.setString(5,id );
			
			int cnt=pstmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println("등록성공!!");
			}else {
				System.out.println("등록 실패!!");
			}
			
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	
	
	
	public static void main(String[] args) {
		
	new JdbcTest06().memStart();
	}
}