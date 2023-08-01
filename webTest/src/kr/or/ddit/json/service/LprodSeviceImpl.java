package kr.or.ddit.json.service;

import java.util.List;

import kr.or.ddit.json.dao.ILprodDAO;
import kr.or.ddit.json.dao.LprodImpl;
import kr.or.ddit.json.vo.LprodVO;

public class LprodSeviceImpl implements ILprodService {
	
	private ILprodDAO dao;
	
	private static LprodSeviceImpl service;
	
	private LprodSeviceImpl() {
		dao=LprodImpl.getInstance();
	}

	public static LprodSeviceImpl getInstance() {
		if(service==null) service= new LprodSeviceImpl();
		return service;
	}
	@Override
	public List<LprodVO> AllLprod() {
		
		return dao.AllLprod();
	}

}
