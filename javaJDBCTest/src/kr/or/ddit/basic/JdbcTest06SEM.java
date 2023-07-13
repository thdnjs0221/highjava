package kr.or.ddit.basic;
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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


import kr.or.ddit.util.DBUtil;
import kr.or.ddit.util.DBUtil3;

public class JdbcTest06SEM {
	Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		new JdbcTest06SEM().startMember();
	}

//시작 메서드
	public void startMember() {
		while (true) {
			int choice = displayMenu();
			switch (choice) {
			case 1:
				insertMember();
				break;
			case 2:
				deleteMember();
				break;
			case 3:
				updateMember();
				break;
			case 4:
				displayAllMember();
				break;
				
			case 5:
				updateMember2();
				break;
			case 0:
				System.out.println("작업을 마칩니다");
				return;
			default:
				break;
			}
		}
	}
	public void updateMember2() {
		   //회원 정보를 수정하는 메서드 ==> 개별 항목 수정하기
		   
		      Connection conn = null;
		      PreparedStatement pstmt = null;
		      
		      System.out.println();
		      System.out.println("수정할 회원 정보를 입력하세요...");
		      System.out.print("회원ID >> ");
		      String memId = scan.next();
		      
		      int count = getMemberCount(memId);
		      if(count==0) {
		         System.out.println(memId + "은(는) 없는 회원ID 입니다...");
		         System.out.println("수정 작업을 종료합니다...");
		          return;
		      }
		      
		      int num;   //수정할 항목 번호가 저장될 변수
		      String updateField = null;   //수정할 컬럼명이 저장될 변수
		      String updateTitle = null;   //변경할 데이터를 입력할 때 출력할 메시지가 저장될 변수
		      do {
		         System.out.println();
		         System.out.println("수정할 항목을 선택하세요...");
		         System.out.println("1.비밀번호   2.회원이름   3.전화번호   4.회원주소");
		         System.out.println("-------------------------------------");
		         System.out.print("수정 항목 선택 >> ");
		         num = scan.nextInt();
		         
		         switch(num) {
		         case 1 : updateField = "mem_pass"; updateTitle = "비밀번호"; break;
		         case 2 : updateField = "mem_name"; updateTitle = "회원이름"; break;
		         case 3 : updateField = "mem_tel"; updateTitle = "전화번호"; break;
		         case 4 : updateField = "mem_addr"; updateTitle = "회원주소"; break;
		         default : System.out.println("수정 항목을 잘못 선택했습니다...");
		               System.out.println("다시 선택하세요...");
		         }
		      }while(num<1 || num>4);
		      
		      scan.nextLine();
		      System.out.println();
		      System.out.print("새로운 "+updateTitle + " >> ");
		      String updateData =scan.nextLine();
		      
		      try {
		         conn = DBUtil.getConnection();
		         String sql = " update mymember set "+updateField+ "= ? where mem_id = ? ";
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setString(1, updateData);
		         pstmt.setString(2, memId);
		         
		         int cnt = pstmt.executeUpdate();
		         
		         if(cnt>0) {
		            System.out.println("수정 완료!!!");
		         }else {
		            System.out.println("수정 실패!!!");
		         }
		         
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }finally {         
		         if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
		         if(conn!=null) try {conn.close();} catch(SQLException e) {}
		      }
		      
		   }
		   
		   
	public void updateMember() {
		Connection conn= null;
		PreparedStatement pstmt = null;
		
		System.out.println();
		System.out.println("수정할 회원 정보 입력");
		System.out.println("회원 아이디: ");
		String memId = scan.next();
		
		int count = getMemberCount(memId);
		//회원 아이디 개수가 나옴
		
		if(count==0) {//없는 회원이면..
			System.out.println(memId+"는 없는 회원 아이디 입니다");
			return;
		}
		
		System.out.println("회원 비밀번호 ");
		String newMemPw = scan.next();
		
		System.out.println("회원 이름");
		String newMemName = scan.next();
		
		System.out.println("회원 전화번호 ");
		String newMemTel = scan.next();
		
		
		scan.nextLine();
		System.out.println("주소 ");
		String newMemAddr = scan.nextLine();
		
		try {
			
			conn=DBUtil.getConnection();
			String sql4="update mymember set mem_pass=? ,mem_name=?,mem_tel=?,mem_addr=? where mem_id=?";
			
			pstmt=conn.prepareStatement(sql4);
			
			pstmt.setString(1, newMemPw);
			pstmt.setString(2, newMemName);
			pstmt.setString(3, newMemTel);
			pstmt.setString(4, newMemAddr);
			pstmt.setString(5, memId);
			
			int cnt= pstmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println("수정완료");
			}else {
				System.out.println("수정실패");
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
	

	private void deleteMember() {
		Connection conn = null;
		PreparedStatement pstmt = null;

		System.out.println("");
		System.out.println("삭제할 회원 정보를 입력하세요");
		System.out.println("회원 아이디: ");
		String memId = scan.next();

		try {

			conn = DBUtil.getConnection();

			String sql2 = " delete from mymember where mem_id=?";

			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, memId);

			int cnt = pstmt.executeUpdate();

			if (cnt > 0) {

				System.out.println(memId + "삭제완료");
			} else {
				System.out.println("실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

	private void insertMember() {

		Connection conn = null;
		PreparedStatement pstmt = null;

		System.out.println();
		System.out.println("추가할 회원 정보를 입력하세요...");

		int count;
		String memId = null;// 회원아이디가 저장될 변수
		do {

			System.out.println("회원 아이디>>");
			memId = scan.next();
			count = getMemberCount(memId);

			if (count > 0) {

				System.out.println(memId + "는 이미 등록된 회원입니다.");
				System.out.println("다른 회원 아이디를 입력하세요...");
				System.out.println();
			}

		} while (count > 0);

		System.out.println(" 비밀번호 ");
		String memPw = scan.next();

		System.out.println("회원 이름");
		String memName = scan.next();

		System.out.println("전화번호 ");
		String memTel = scan.next();

		scan.nextLine();
		System.out.println("주소 ");
		String memAddr = scan.nextLine();

		try {
			conn = DBUtil.getConnection();

			String sql = "insert into mymember(mem_id, mem_pass, mem_name, mem_tel, mem_addr)" + "values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			pstmt.setString(2, memPw);
			pstmt.setString(3, memName);
			pstmt.setString(4, memTel);
			pstmt.setString(5, memAddr);

			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
				System.out.println("회원 정보 추가 완료");
			} else {
				System.out.println("실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

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

//회원 아이디를 매개변수로 받아서 DB에 해당 회원아이디의 개수를 반환하는 메서드
	private int getMemberCount(String memId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int count = 0;
		try {
			conn = DBUtil.getConnection();
			String sql = " select count(*)cnt from mymember where mem_id=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt("cnt");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

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
		return count;

	}

	private void displayAllMember() {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		System.out.println();
		System.out.println("=========================================");
		System.out.println("ID   이름     비밀번호    전화번호    주소");
		System.out.println("=========================================");
		try {
			//conn = DBUtil.getConnection();
			//conn = DBUtil2.getConnection();
			conn = DBUtil3.getConnection();
			String sql = "select *from mymember";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			int cnt = 0;
			while (rs.next()) {
				cnt++;
				String id = rs.getString("mem_id");
				String name = rs.getString(2);
				String pw = rs.getString(3);
				String tel = rs.getString(4);
				String addr = rs.getString(5);

				System.out.println(id + "\t" + name + "\t" + pw + "\t" + tel + "\t" + addr);
			}
			if (cnt == 0) {
				System.out.println("등록된 회원이 하나도 없습니다");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}

	}

	public int displayMenu() {
		System.out.println("");
		System.out.println("1.자료추가");
		System.out.println("2.자료삭제");
		System.out.println("3.자료수정");
		System.out.println("4.전체자료출력");
		System.out.println("5. 자료 수정 2");
		System.out.println("0.작업끝");
		return scan.nextInt();

	}
}
