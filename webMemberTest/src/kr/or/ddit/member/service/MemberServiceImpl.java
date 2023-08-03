package kr.or.ddit.member.service;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;

public class MemberServiceImpl implements IMemberService{
	private IMemberDao dao;
	
	private static MemberServiceImpl service;
	
	private  MemberServiceImpl() {
		dao= MemberDaoImpl.getInstance();
		
	}
	public static MemberServiceImpl getInstance() {
		if(service==null) service = new MemberServiceImpl();
		return service;
	}
	
	@Override
	public MemberVO getMemberLogin(MemberVO memVo) {
		
		return dao.getMemberLogin(memVo);
	}
	@Override
	public int insertMember(MemberVO memVo) {
		
		return dao.insertMember(memVo);
	}

}
