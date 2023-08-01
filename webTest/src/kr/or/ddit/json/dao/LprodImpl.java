package kr.or.ddit.json.dao;

import java.util.List;

import javax.websocket.Session;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.json.vo.LprodVO;
import kr.or.ddit.util.MyBatisUtil;

public class LprodImpl implements ILprodDAO {
	//싱글톤
	private static LprodImpl dao;
	
	
	private LprodImpl() {};
	
	public static LprodImpl getInstance() {
		if(dao==null) dao= new LprodImpl();
		return dao;
	}

	@Override
	public List<LprodVO> AllLprod() {
		SqlSession sql=null;
		List<LprodVO> list = null;
		
		try {
			sql = MyBatisUtil.getSqlSession();
			
			list = sql.selectList("lprod.AllLprod");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sql.commit();
			sql.close();
		}
		
		return list;
	}

}
