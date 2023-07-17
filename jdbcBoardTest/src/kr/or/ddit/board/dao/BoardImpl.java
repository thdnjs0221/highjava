package kr.or.ddit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.util.DBUtil3;
import kr.or.ddit.board.vo.BoardVO;

public class BoardImpl implements BoardDAO {
	//싱글톤 만들기 
	//1번
	private static BoardImpl dao;
	//2번 기본 생성자 
	public BoardImpl() {
	}
	//3번
	public static BoardImpl getInstance() {
		if(dao==null) dao= new BoardImpl();
		return dao;
	}
	

	@Override
	public int insertBoard(BoardVO boardVo) {
		Connection conn= null;
		PreparedStatement pstmt= null;
		int cnt=0;  //반환갑이 저장될 변수 선언
		
		try {
			conn=DBUtil3.getConnection();
			//제목 , 작성자 , 내용 
			String sql= " insert to jdbc_board(board_title, board_writer, board_content) "
					+" values (?,?,?) ";
			
			pstmt= conn.prepareStatement(sql);
			
			pstmt.setString(1, boardVo.getBoard_title());
			pstmt.setString(2, boardVo.getBoard_writer());
			pstmt.setString(1, boardVo.getBoard_content());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
		
		
		
		return cnt;
	}

	@Override
	public List<BoardVO> getallBoard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateBoard(Map<String, String> paramMap) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard(int boardNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int searchBoard(Map<String, String> paramMap) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
