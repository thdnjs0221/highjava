package kr.or.ddit.fileupload.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.fileupload.vo.FileinfoVO;
import kr.or.ddit.util.MyBatisUtil;

public class FileInfoDaoImpl implements IFileInfoDao{
	private static FileInfoDaoImpl dao;
	
	private FileInfoDaoImpl () {}
	
	public static FileInfoDaoImpl getInstance() {
		if(dao==null)dao= new FileInfoDaoImpl();
		return dao;
	}

	@Override
	public int insertFileinfo(FileinfoVO fileVo) {
		SqlSession session = MyBatisUtil.getSqlSession();
		int cnt=0;
		
		try {
			
			session = MyBatisUtil.getSqlSession();
			cnt= session.insert("fileinfo.insertFileinfo",fileVo);
			if(cnt>0) session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
		return cnt;
	}

	@Override
	public List<FileinfoVO> getAllFileInfo() {
		SqlSession session=null;
		List<FileinfoVO> fileList = null;
		
		try {
			session= MyBatisUtil.getSqlSession();
			fileList = session.selectList("fileinfo.getAllFileinfo");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
		return fileList;
	}

	@Override
	public FileinfoVO getFileInfo(int fileNo) {
		SqlSession session = null;
		FileinfoVO fileVo = null;
		
		try {
			session= MyBatisUtil.getSqlSession();
			fileVo = session.selectOne("fileinfo.getFileInfo",fileNo);
		} catch (Exception e) {
		e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
		return fileVo;
	}

}
