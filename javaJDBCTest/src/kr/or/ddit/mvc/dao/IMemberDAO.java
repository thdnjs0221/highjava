package kr.or.ddit.mvc.dao;

import java.util.List;

//import com.sun.java.util.jar.pack.Package.Class.Member;

import kr.or.ddit.mvc.vo.MemberVO;

/**
 * 실제 디비와 연결해서 sql문을 수행하여 결과를 작성해서 service에게 전달하는 DAO의 interface
 * 
 * 메서드 하나가 디비와 관련된 작업 1개를 수행하도록 작성한다
 * @author PC-14
 *
 */

public interface IMemberDAO {
	/** 
	 * MemberVO객체를 인수값으로 받아서 MemberVO에 저장된 데이터를 디비에 insert 하는 메서드 
	 *  
	 * @param memeVo insert할 데이터가 저장된 MemberVO 객체
	 * @return 작업 성공 :1 실패:0
	 */
	public int insertMember(MemberVO memVo); //되도록 매개변수는 적게,,데이터가 많으면 한개로 뭉쳐서 보낼수있도록하기
		
	/**
	 * 회원id를 매개변수로 방아서 해당 회원정보를 삭제하는 메서드
	 * 
	 * @param memId 삭제할 회원 아이디
	 * @return 작업 성공 :1 실패:0
	 */
	public int deleteMember(String memId); //

	/**
	 * MemberVO 자료를 이용하여 디비에 update하는 메서드
	 * 
	 * @param memVO update할 회원 정보가 저장된 MemberVO객체
	 * @return 작업 성공 :1 실패:0
	 */
	public int updateMember(MemberVO memVO);
	/**
	 * 전체 수정 작업
	 * 디비의 전체 회원정보를 가져와 List에 담아와서 반환하는 메서드
	 * 
	 * @return  MemberVO객체가 저장된 List
	 */
	public List<MemberVO> getALlMember();//
	/**
	 * 회원 아이디를 매개변수로 받아서 해당 회원아이디의 개수를 반환하는 메서드
	 * 
	 * @param memId 검색할 회원 아이디
	 * @return 검색된 회원 아이디 개수 
	 */
	public int getMemberCount(String memId);
	
}
