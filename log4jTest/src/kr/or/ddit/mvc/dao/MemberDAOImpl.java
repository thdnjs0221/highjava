package kr.or.ddit.mvc.dao;
//dao나 Service에는 화면에 출력하는 내용이 들어가면 안된다.
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.DBUtil;
import kr.or.ddit.util.DBUtil3;
import sun.security.jca.GetInstance;

public class MemberDAOImpl implements IMemberDAO {
	private static final Logger logger= Logger.getLogger(MemberDAOImpl.class);
	//싱글톤 만들기
	//1번
	private static MemberDAOImpl dao;
	
	//2번 기본생성자 
	private MemberDAOImpl() {
	}
	
	//3번 
	public static MemberDAOImpl getInstance() {
		if(dao == null) dao= new MemberDAOImpl();
		return dao;
	}

	@Override
	public int insertMember(MemberVO memVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0; // 반환값이 저장될 변수 선언

		try {
			conn = DBUtil3.getConnection();
			
			logger.info("Connction객체 생성 완료!!");
			
			
			String sql = "insert into mymember(mem_id, mem_pass, mem_name, mem_tel, mem_addr)" + "values(?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memVo.getMem_id());
			pstmt.setString(2, memVo.getMem_pass());
			pstmt.setString(3, memVo.getMem_name());
			pstmt.setString(4, memVo.getMem_tel());
			pstmt.setString(5, memVo.getMem_addr());

			logger.info("PrepareStatement객체 생성...");
			logger.debug("실행 SQL==> "+sql);
			logger.debug("사용 데이터==> ["+ memVo.getMem_id()+","+memVo.getMem_pass()+","+
						memVo.getMem_name()+","+memVo.getMem_tel()+","+memVo.getMem_addr()+"]");
			
			cnt = pstmt.executeUpdate();
			logger.info("실행 작업 성공");
			
		} catch (SQLException e) {
			logger.error("DB 작업 실패!!!",e);
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try {
				pstmt.close();
				logger.info("PreparedStatement 객체 반납...");
				} catch(SQLException e) {}
	        if(conn!=null) try {
	        	conn.close();
	        	logger.info("Connection 객체 반납...");
	        } catch(SQLException e) {}
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
			
			logger.info("Connection객체 생성 완료!!");
			
			String sql2 = " delete from mymember where mem_id=?";

			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, memId);

			logger.info("PreparedStatemetn 객체생성..");
			logger.debug("실행 SQL==>"+sql2);
			logger.debug("사용데이터==> ["+memId+"]");
			
			
			cnt = pstmt.executeUpdate();
			logger.info("실행 작업 성공");

		
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("DB 작업 실패!!!",e);
		}finally {
			if(pstmt!=null) try {
				pstmt.close();
				logger.info("PreparedStatement 객체 반납...");
				} catch(SQLException e) {}
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
			conn= DBUtil3.getConnection();
			
			logger.info("Connection객체 생성 완료!!");
			
			String sql4="update mymember set mem_pass=? ,mem_name=?,mem_tel=?,mem_addr=? where mem_id=?";
			
			pstmt=conn.prepareStatement(sql4);
			
	
			
			pstmt.setString(1, memVO.getMem_pass());
			pstmt.setString(2, memVO.getMem_name());
			pstmt.setString(3, memVO.getMem_tel());
			pstmt.setString(4, memVO.getMem_addr());
			pstmt.setString(5, memVO.getMem_id());
			
			logger.info("PreparedStatemetn 객체생성..");
			logger.debug("실행 SQL==>"+sql4);
			logger.debug("사용데이터==> ["+memVO.getMem_pass()+","+memVO.getMem_name()+","+memVO.getMem_tel()+","
										+ memVO.getMem_addr()+","+memVO.getMem_id() +"]");
			
			cnt= pstmt.executeUpdate();
			logger.info("실행 작업 성공");
			
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("DB 작업 실패!!!",e);
		}finally {
			if(pstmt!=null) try {
				pstmt.close();
				logger.info("PreparedStatement 객체 반납...");
				} catch(SQLException e) {}
	        if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return cnt;
	}

	@Override
	public List<MemberVO> getALlMember() {
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<MemberVO>memList=null;//반환값이 저장될 변수 
		

		try {
			conn = DBUtil3.getConnection();
			
			logger.info("Connection객체 생성 완료!!");
			
			String sql = "select *from mymember";
			pstmt = conn.prepareStatement(sql);
			
			logger.info("PreparedStatement 객체 생성..");
			logger.debug("실행 SQL==>"+sql);
			logger.debug("사용데이터==> ["+memList+"]");
			
			rs = pstmt.executeQuery(sql);
			logger.info("실행 작업 성공");

			memList = new ArrayList<MemberVO>();
			
			while (rs.next()) {
				//각 컬럼의 값들을 가져와 VO객체에 저장한다
				MemberVO memVo= new MemberVO(); //VO객체 생성
				
				memVo.setMem_id(rs.getString("mem_id"));
				memVo.setMem_pass(rs.getString("mem_pass"));
				memVo.setMem_name(rs.getString("mem_name"));
				memVo.setMem_tel(rs.getString("mem_tel"));
				memVo.setMem_addr(rs.getString("mem_addr"));
		
				memList.add(memVo); //데이터가 저장된 VO객체를 List에 추가한다
				
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("DB 작업 실패!!!",e);
		}finally {
			if(rs!=null) try {
				rs.close();
				logger.info("ResultSet 객체 반납...");
				} catch(SQLException e) {}
			if(pstmt!=null) try {
				pstmt.close();
				logger.info("PreparedStatement 객체 반납...");
				} catch(SQLException e) {}
	        if(conn!=null) try {
	        	conn.close();
	        	
	        	} catch(SQLException e) {}
		}
	
		return memList;
	}

	@Override
	public int getMemberCount(String memId) {
		Connection conn= null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		int count=0;
		
		try {
			conn = DBUtil.getConnection();
			
			logger.info("Connection객체 생성 완료!!");
			
			String sql = " select count(*)cnt from mymember where mem_id=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			logger.info("PreparedStatement객체 생성 완료!!");
			logger.debug("실행 SQL==>"+sql);
			logger.debug("사용데이터==>"+memId);

			rs = pstmt.executeQuery();
			logger.info("실행 작업 성공");

			if (rs.next()) {
				count = rs.getInt("cnt");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("DB 작업 실패!!!",e);
			
		}finally {
			if(pstmt!=null) try {
				pstmt.close();
				logger.info("PreparedStatement 객체 반납...");
				} catch(SQLException e) {}
	        if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return count;
	}

	
	//( Key값 정보==> 회원 ID(memid), 수정할 컬럼명(field), 수정할 데이터(data)  )
	@Override
	public int updateMember2(Map<String, String> paramMap) {
		Connection conn= null;
		PreparedStatement pstmt= null;
		int cnt=0;
		try {
			
			conn=DBUtil3.getConnection();
			logger.info("Connection객체 생성 완료!!");
			String sql=" update mymember set "+paramMap.get("field")+ "= ? where mem_id= ? ";
			
			
			//map에 있는 데이터를 꺼내기 위해서 
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,paramMap.get("data"));
			pstmt.setString(2,paramMap.get("memid"));
			
			logger.info("PreparedStatement객체 생성 완료!!");
			logger.debug("실행 SQL==>"+sql);
			logger.debug("사용데이터==>"+paramMap);
			
			cnt=pstmt.executeUpdate();
			logger.info("실행 작업 성공");
			
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("DB 작업 실패!!!",e);
		}finally {
			if(pstmt!=null) try {
				pstmt.close();
				logger.info("PreparedStatement 객체 반납...");
				} catch(SQLException e) {}
	        if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return cnt;
	}

	}
	
