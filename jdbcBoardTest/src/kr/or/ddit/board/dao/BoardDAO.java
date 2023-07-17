package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;

public interface BoardDAO {
	//전체 목록 출력, 새글작성, 수정, 삭제, 검색 기능

	//새글작성
	public int insertBoard(BoardVO boardVo);
	
	//전체목록 출력
	public List<BoardVO> getallBoard();
	
	//수정
	public int updateBoard(Map<String,String>paramMap);

	//삭제 
	public int deleteBoard(int boardNo);
	
	//검색
	public int searchBoard(Map<String,String>paramMap);
}
