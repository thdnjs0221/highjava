package kr.or.ddit.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.dao.IMemberDAO;
import kr.or.ddit.dao.MemberDAOImpl;
import kr.or.ddit.vo.MemberVO;



public class MemberServiceImpl implements IMemberService {

	private IMemberDAO dao; //DAO객체가 저장될 변수 선언
	private static MemberServiceImpl service;
	
	
	public MemberServiceImpl() {
		//dao=new MemberDAOImpl();   //DAO객체 생성
		dao = MemberDAOImpl.getInstance(); //싱글톤 
	}
	
	public static MemberServiceImpl getInstance() {
		if(service==null) service =new MemberServiceImpl();
		return service;
	}

	@Override
	public int insertMember(MemberVO memVo) {
		//return dao.insertMember(memVo); //SERVICE는 일이 있으면 그 일에 필요한 DAO를 호출해서 일을 처리한 후 
										  //처리 결과를 CONTROLLER에게 전달한다.
		return dao.insertMember(memVo);
	}

	@Override
	public int deleteMember(String memId) {
		return dao.deleteMember(memId);
		
	}

	@Override
	public int updateMember(MemberVO memVO) {
		
		return dao.updateMember(memVO);
	}

	@Override
	public List<MemberVO> getALlMember() {
		
		return dao.getALlMember();
	}

	@Override
	public int getMemberCount(String memId) {
	
		return dao.getMemberCount(memId);
	}

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		
		return dao.updateMember2(paramMap);
	}

}
