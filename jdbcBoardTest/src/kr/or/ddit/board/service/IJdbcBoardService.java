package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.vo.JdbcBoardVO;

public interface IJdbcBoardService {
	/**
	 * JdbcBoardVO객체에 저장된 데이터를 디비에 insert하는 메서드
	 * 
	 * @param boardVo insert할 데이터가 저장된 JdbcBoardVO객체
	 * @return 작업성공 :1  작업실패:0
	 */
	public int insertBoard(JdbcBoardVO boardVo);
	
	/**
	 * 게시글 번호를 매개변수로 받아서 해당 게시글을 삭제하는 메서드 
	 * @param boardNo 삭제할 게시글 번호 
	 * @return 작업성공 :1  작업실패:0
	 */
	public int deleteBoard(int boardNo);
	
	/**
	 * 하나의 JbdcBoardVO자료를 이용하여 게시글을 update하는 메서드
	 * 
	 * @param boardVo update게시글 정보가 저장된 JdbcBoardVO객체
	 * @return 작업성공 :1  작업실패:0
	 */
	public int updateBoard(JdbcBoardVO boardVo);
	
	/**
	 * 게시물 전체 데이터를 가져와 List에 담아서 반환하는 메서드 
	 * @return JdbcBoardVO객체를 저장하고 있는 List 객체 
	 */
	public List<JdbcBoardVO> getAllBoard();
	
	/**
	 * 게시글 번호를 매개변수로 받아서 해당 게시글 정보를 가져와 반환하는 메서드 
	 * @param boardNo 가져올 게시글 번호 
	 * @return 게시글 번호에 맞는 자료가 있으면 해당 게시글 정보를 담고 있는 JdbcBoardVO객체,
	 * 			자료가 없으면 null반환
	 */
	public JdbcBoardVO getBoard(int boardNo);
	/**
	 * 검색할 게시글 제목을 매개변수로 받아서 해당 게시글을 검색하는 메서드 
	 * @param title 검색할 게시글 제목 
	 * @return 검색된 결과가 저장된 List객체
	 */
	public List<JdbcBoardVO> getSearchBoard(String title);
	/**
	 * 게시글 번호를 매개변수로 받아서 해당 게시글의 조회수를 증가 시키는 메서드 
	 * @param boardNo 조회수를 증가할 게시글 번호 
	 * @return 작업성공:1 작업실패:0
	 */
	public int setCountIncrement (int boardNo);
}
