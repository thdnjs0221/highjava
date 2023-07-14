package kr.or.ddit.mvc.dao;
//dao나 Service에는 화면에 출력하는 내용이 들어가면 안된다.
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.DBUtil;
import kr.or.ddit.util.DBUtil3;

public class MemberDAOImpl implements IMemberDAO {

	@Override
	public int insertMember(MemberVO memVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0; // 반환값이 저장될 변수 선언

		try {
			conn = DBUtil3.getConnection();
			String sql = "insert into mymember(mem_id, mem_pass, mem_name, mem_tel, mem_addr)" + "values(?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memVo.getMem_id());
			pstmt.setString(2, memVo.getMem_pass());
			pstmt.setString(3, memVo.getMem_name());
			pstmt.setString(4, memVo.getMem_tel());
			pstmt.setString(5, memVo.getMem_addr());

			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
	        if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0; // 반환값이 저장될 변수 선언
		
		try {
			conn= DBUtil3.getConnection();
			String sql2 = " delete from mymember where mem_id=?";

			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, memId);

			cnt = pstmt.executeUpdate();

//			if (cnt > 0) {
//
//				System.out.println(memId + "삭제완료");
//			} else {
//				System.out.println("실패");
//			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
	        if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
		return cnt;
	}

	//전체 업데이트 
	@Override
	public int updateMember(MemberVO memVO) {
		Connection conn=null;
		PreparedStatement pstmt= null;
		int cnt=0;
		
		try {
			
			String sql4="update mymember set mem_pass=? ,mem_name=?,mem_tel=?,mem_addr=? where mem_id=?";
			
			pstmt=conn.prepareStatement(sql4);
			
			pstmt.setString(1, memVO.getMem_id());
			pstmt.setString(2, memVO.getMem_pass());
			pstmt.setString(3, memVO.getMem_name());
			pstmt.setString(4, memVO.getMem_tel());
			pstmt.setString(5, memVO.getMem_addr());
			
			cnt= pstmt.executeUpdate();
			
//			if(cnt>0) {
//				System.out.println("수정완료");
//			}else {
//				System.out.println("수정실패");
//			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
	        if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return cnt;
	}

	@Override
	public List<MemberVO> getALlMember() {
		Connection conn= null;
		Statement stmt = null;
		ResultSet rs = null;
		int cnt=0;
		try {
			conn = DBUtil3.getConnection();
			String sql = "select *from mymember";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			cnt = 0;
			while (rs.next()) {
				cnt++;
				String id = rs.getString("mem_id");
				String name = rs.getString(2);
				String pw = rs.getString(3);
				String tel = rs.getString(4);
				String addr = rs.getString(5);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(stmt!=null) try {stmt.close();} catch(SQLException e) {}
	        if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
				
		return getALlMember();
	}

	@Override
	public int getMemberCount(String memId) {
		Connection conn= null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		int count=0;
		
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
			
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
	        if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return count;
	}

}
