package kr.or.ddit.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.util.MyBatisUtil;
import kr.or.ddit.vo.MemberVO;

public class MemberDAOImpl implements IMemberDAO {
	//싱글톤 
		private static MemberDAOImpl dao;
		
		private MemberDAOImpl() {}
		
		public static MemberDAOImpl getInstance() {
			if(dao==null)dao = new MemberDAOImpl();
			return dao;
		}
	

	@Override
	public int insertMember(MemberVO memVo) {
		SqlSession session= null;
		int cnt=0;
		try {
			
			session=MyBatisUtil.getSqlSession();
			cnt= session.insert("member.insertMember",memVo);
			
			if(cnt>0) {
				session.commit();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
		
		return cnt;
	}
	@Override
	public int deleteMember(String memId) {
		SqlSession session= null;
		int cnt=0;
		try {
			
			session=MyBatisUtil.getSqlSession();
			cnt= session.delete("member.deleteMember",memId);
			
			if(cnt>0) {
				session.commit();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
		
		return cnt;
	}
	
	@Override
	public int updateMember(MemberVO memVo) {
		SqlSession session= null;
		int cnt=0;
		try {
			
			session=MyBatisUtil.getSqlSession();
			cnt= session.update("member.updatetMember",memVo);
			
			if(cnt>0) {
				session.commit();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
		
		return cnt;
	}
	
	@Override
	public List<MemberVO> getALlMember() {
		SqlSession session= null;
		List<MemberVO>memList=null; 
		try {
			session=MyBatisUtil.getSqlSession();
			
			memList=session.selectList("member.getAllMember");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
		return memList;
	}

	@Override
	public int getMemberCount(String memId) {
		SqlSession session= null;
		int count=0; //반환값이 저장될 변수 
		try {
			session=MyBatisUtil.getSqlSession();
			count = session.selectOne("getMemberCount", memId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
		
		return count;
	}

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		SqlSession session= null;
		int cnt=0;
		try {
			
			session=MyBatisUtil.getSqlSession();
			cnt= session.update("member.updatetMember2",paramMap);
			
			if(cnt>0) {
				session.commit();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
		
		return cnt;
	}
}

