/**
 * 
 */
package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.IJdbcBoardDAO;
import kr.or.ddit.board.dao.JdbcBoardImpl;
import kr.or.ddit.board.vo.JdbcBoardVO;

/**
 * @author PC-14
 *
 */
public class JdbcBoardServiceImpl implements IJdbcBoardService {
	private IJdbcBoardDAO dao;
	
	private static JdbcBoardServiceImpl service;
	
	private JdbcBoardServiceImpl() {
		dao=JdbcBoardImpl.getInstance();
		
	}
	public static JdbcBoardServiceImpl getInstance() {
		if(service==null) service = new JdbcBoardServiceImpl();
		return service;
		
	}

	@Override
	public int insertBoard(JdbcBoardVO boardVo) {

		return dao.insertBoard(boardVo);
		
	}

	@Override
	public int deleteBoard(int boardNo) {
		
		return dao.deleteBoard(boardNo);
	}

	@Override
	public int updateBoard(JdbcBoardVO boardVo) {
		
		return dao.updateBoard(boardVo);
		
	}

	@Override
	public List<JdbcBoardVO> getAllBoard() {
		
		return dao.getAllBoard();
	}

	@Override
	public JdbcBoardVO getBoard(int boardNo) {
		int cnt= dao.setCountIncrement(boardNo); //조회수 증가 
		if(cnt==0) {
		}
		return dao.getBoard(boardNo);
	}
	@Override
	public List<JdbcBoardVO> getSearchBoard(String title) {
		
		return dao.getSearchBoard(title);
	}
	@Override
	public int setCountIncrement(int boardNo) {
	
		return dao.setCountIncrement(boardNo);
	}

}
