/**
 * 
 */
package kr.or.ddit.fileupload.service;

import java.util.List;

import kr.or.ddit.fileupload.dao.FileInfoDaoImpl;
import kr.or.ddit.fileupload.dao.IFileInfoDao;
import kr.or.ddit.fileupload.vo.FileinfoVO;


public class FIleInfoSeriviceImpl implements IFileInfoService {
	private IFileInfoDao dao;
	
	private static FIleInfoSeriviceImpl service;
	
	private FIleInfoSeriviceImpl() {
		dao= FileInfoDaoImpl.getInstance();
	}
	
	public static FIleInfoSeriviceImpl getInstacne() {
		if(service==null) service= new FIleInfoSeriviceImpl();
		return service;
	}

	@Override
	public int insertFileinfo(FileinfoVO fileVo) {
		// TODO Auto-generated method stub
		return dao.insertFileinfo(fileVo);
	}

	@Override
	public List<FileinfoVO> getAllFileInfo() {
		// TODO Auto-generated method stub
		return dao.getAllFileInfo();
	}

	@Override
	public FileinfoVO getFileInfo(int fileNo) {
		// TODO Auto-generated method stub
		return dao.getFileInfo(fileNo);
	}

}
