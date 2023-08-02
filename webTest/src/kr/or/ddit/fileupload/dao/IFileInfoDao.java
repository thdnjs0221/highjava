package kr.or.ddit.fileupload.dao;

import java.util.List;

import kr.or.ddit.fileupload.vo.FileinfoVO;


public interface IFileInfoDao {
	
/**
 * Filevo에 저장된 자료를 디비에 인서트하는 메서드 
 * @param fileVo 인서트할 자료가 저장된 vo객체
 * @return작업성공 1 실패 0
 */
	public int insertFileinfo(FileinfoVO fileVo);
	
	
	
	/**
	 * db에 있는 전체 파일 목록을 가져와 List에 담아서 반환하는 메서드 
	 * @return 전체 ㄹFileInfoVo 저장된 List객체
	 */
	public List<FileinfoVO> getAllFileInfo();
	
	
	
	/**
	 * 파일번호를 매개변수로 받아서 해당 파일정보를 vo에 담아서 반환하는 메서드 
	 * 
	 * @param fileNo 검색할 파일번호 
	 * @return 검색할 결과가 저장된 vo객체
	 */
	public FileinfoVO getFileInfo(int fileNo);
}
